package com.localworld.ishop.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.igerm.android.lib.net.core.HdlCore;
import com.localworld.ishop.R;
import com.localworld.ishop.common.config.IGERMConstant;
import com.localworld.ishop.common.fragmentation.BaseSupportActivity;
import com.localworld.ishop.common.fragmentation.BaseSupportFragment;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.common.manager.account.LoginManager;
import com.localworld.ishop.login.ISHOPUserLoginActivity;
import com.localworld.ishop.setting.SettingMainActivity;
import com.localworld.ishop.shopcart.ShopCartActivity;


    public  class HomeActivity extends BaseSupportActivity implements View.OnClickListener {
    
        private final int[] TAB_TITLES = IGERMConstant.DEFAULT_TABS;
        private final int[] ICON_TITLES = IGERMConstant.DEFAULT_TABS_ICON;
        private final int[] ICON_TITLES_SELECTED = IGERMConstant.DEFAULT_TABS_ICON_SELECTED;
        private final int[] WIDTH_SIZE_TITLES = {80, 85, 110, 80};
        private final int[] HEIGHT_SIZE_TITLES = {82, 85, 75, 80};
    
    
        private BaseSupportFragment[] mFragments;
        private TabLayout tabLayout;
        private View headportrait;
        private View logo;
        private View shoppingcart;
        private Toolbar mToolbar;
        private View mBottomLayout;
    
        private ISNetService netService = HdlCore.getInstance().getService(ISNetService.class);
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            obtainFragment();
            initView();
        }
    
    
        private void obtainFragment() {
            mFragments = new BaseSupportFragment[TAB_TITLES.length];
            BaseSupportFragment indexFragment = findFragment(IndexFragment.class);
            if (indexFragment == null) {
                mFragments[0] = IndexFragment.newInstance();
                mFragments[1] = SearchFragment.newInstance();
                mFragments[2] = DiscoveryFragment.newInstance();
                mFragments[3] = MessageFragment.newInstance();
                loadMultipleRootFragment(R.id.home_container, 0, mFragments[0], mFragments[1], mFragments[2], mFragments[3]);
            } else {
                mFragments[0] = indexFragment;
                mFragments[1] = findFragment(SearchFragment.class);
                mFragments[2] = findFragment(DiscoveryFragment.class);
                mFragments[3] = findFragment(MessageFragment.class);
            }
        }
    
        private void initView() {
            mBottomLayout = findViewById(R.id.home_content_bottom);
            initToolbar();
            initTabLayout();
        }
    
        private void initToolbar() {
            mToolbar = findViewById(R.id.toolbar);
            setSupportActionBar(mToolbar);
    
            //自定义顶部栏
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                RelativeLayout layout = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.ime_base_toolbar, null, false);
                supportActionBar.setCustomView(layout);
                supportActionBar.setDisplayShowCustomEnabled(true);
                supportActionBar.setDisplayHomeAsUpEnabled(false);
                supportActionBar.setDisplayShowTitleEnabled(false);
                //自定义view完全填充toolbar
                Toolbar parent = (Toolbar) layout.getParent();
                parent.setContentInsetsAbsolute(0, 0);
    
                headportrait = findViewById(R.id.iv_toolbar_head);
                headportrait.setOnClickListener(this);
                logo = findViewById(R.id.iv_toolbar_logo);
                logo.setOnClickListener(this);
                shoppingcart = findViewById(R.id.iv_toolbar_shoppingcart);
                shoppingcart.setOnClickListener(this);
            }
        }
    
        private void initTabLayout() {
            tabLayout = findViewById(R.id.tablayout_home_bottom);
            for (int i = 0; i < TAB_TITLES.length; i++) {
                TabLayout.Tab tab = tabLayout.newTab();
                View tabItem = LayoutInflater.from(this).inflate(R.layout.view_tab_item, null, false);
                ImageView img = tabItem.findViewById(R.id.img_home_tab_item);
                LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) img.getLayoutParams();
                linearParams.width = WIDTH_SIZE_TITLES[i];
                linearParams.height = HEIGHT_SIZE_TITLES[i];
                img.setLayoutParams(linearParams);
                img.setImageResource(ICON_TITLES[i]);
                tab.setCustomView(tabItem);
                tabLayout.addTab(tab);
            }
            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                private Integer prePos = null;
    
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    int currentPos = tab.getPosition();
                    if (currentPos >= mFragments.length) {
                        return;
                    }
                    if (prePos == null) {
                        showHideFragment(mFragments[currentPos]);
                        View view = tab.getCustomView();
                        ImageView imgselected = view.findViewById(R.id.img_home_tab_item);
                        imgselected.setImageResource(ICON_TITLES_SELECTED[currentPos]);
                    } else if (prePos < mFragments.length) {
                        showHideFragment(mFragments[currentPos], mFragments[prePos]);
                        View view = tab.getCustomView();
                        ImageView imgselected = view.findViewById(R.id.img_home_tab_item);
                        imgselected.setImageResource(ICON_TITLES_SELECTED[currentPos]);
                        TabLayout.Tab lasttab = tabLayout.getTabAt(prePos);
                        View lastview = lasttab.getCustomView();
                        ImageView imglastselected = lastview.findViewById(R.id.img_home_tab_item);
                        imglastselected.setImageResource(ICON_TITLES[prePos]);
                    }
                    prePos = currentPos;
                }
    
                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }
    
                @Override
                public void onTabReselected(TabLayout.Tab tab) {
    
                }
            });
        }
    
        @Override
        public void onClick(View view) {
    
            int id = view.getId();
            switch (id) {
                case R.id.iv_toolbar_head:
    
                    if (LoginManager.getInstance().getUserInfo() == null) {
                        startActivity(new Intent(HomeActivity.this, ISHOPUserLoginActivity.class));
                    } else {
                        Intent intent = new Intent(HomeActivity.this, SettingMainActivity.class);
                        startActivity(intent);
                    }
                    break;
    
                case R.id.iv_toolbar_shoppingcart:
                    Intent intent = new Intent(this, ShopCartActivity.class);
                    startActivity(intent);
    //                startActivity(new Intent(HomeActivity.this, PayTestActivity.class));
                    break;
                default:
                    break;
            }
    
        }
    
        public void hideToolbar() {
            if (mToolbar.getVisibility() != View.GONE) {
                mToolbar.setVisibility(View.GONE);
            }
        }
    
        public void hideBottomBar() {
            if (tabLayout.getVisibility() != View.GONE) {
                mBottomLayout.setVisibility(View.GONE);
                tabLayout.setVisibility(View.GONE);
            }
        }
    
        public void showBottomBar() {
            if (tabLayout.getVisibility() != View.VISIBLE) {
                tabLayout.setVisibility(View.VISIBLE);
                mBottomLayout.setVisibility(View.VISIBLE);
            }
        }
    
        public void showToolbar() {
            if (mToolbar.getVisibility() != View.VISIBLE) {
                mToolbar.setVisibility(View.VISIBLE);
            }
        }
    }
