package com.localworld.ishop.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportActivity;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.common.view.ScrollControllerViewPager;
import com.localworld.ishop.setting.adapter.MyHomePageAdapter;
import com.localworld.ishop.setting.bean.MyHomePageBean;
import com.localworld.ishop.setting.fragment.MyHomePageGridFragment;
import com.localworld.ishop.setting.fragment.MyHomePageSingleFragment;

import java.util.ArrayList;
import java.util.List;


public class MainMyHomePageActivity extends BaseSupportActivity implements View.OnClickListener {
    private ScrollControllerViewPager myHomePageControllerViewPager;
    private ImageView mGrid,mSingle;
    private List<Fragment> fragmentList = new ArrayList<>();
    private MyHomePageAdapter adapter;
    private MyHomePageGridFragment gridFragment;
    private MyHomePageSingleFragment singleFragment;
    private List<MyHomePageBean> myHomePageBeanList = new ArrayList<>();
    private TextView mEditHomePage;
    private MyHomePageBean bean;
    private int flag = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_myhomepage);
        loadData();
        initView();
        initViewPager();
    }

    private void loadData() {
        bean = new MyHomePageBean();
        bean.homePagePic = "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1306/03/c0/21608858_1370244891829.jpg";
        bean.articleNum = "520";
        bean.fansNum = "521";
    }

    private void initView() {
        LinearLayout mFans = findViewById(R.id.layout_setting_myhomepage_fans);
        LinearLayout mArticle = findViewById(R.id.layout_setting__myhomepage_article);
        LinearLayout mFollow = findViewById(R.id.layout_setting__myhomepage_follow);
        TextView mFansNum = findViewById(R.id.tv_setting_myhomepage_fansnum);
        TextView mArticleNum = findViewById(R.id.tv_setting_myhomepage_articlenum);
        TextView mFollowNum = findViewById(R.id.tv_setting_myhomepage_follownum);
        mEditHomePage = findViewById(R.id.tv_setting_myhomepage_edithomepage);
        ISImageView mHomePagePic = findViewById(R.id.iv_setting_myhomepage_headpic);
        TextView mName = findViewById(R.id.tv_setting_myhomepage_name);
        ImageView mAdd = findViewById(R.id.iv_setting_myhomepage_add);
        mAdd.setOnClickListener(this);
        mEditHomePage.setOnClickListener(this);

        Intent intent = getIntent();
        /*Log.d("MainMyHomePageActivity",intent.getStringExtra("headPic"));
        Log.d("MainMyHomePageActivity",intent.getStringExtra("userName"));
        Log.d("MainMyHomePageActivity",intent.getStringExtra("followNum"));*/
        /*mHomePagePic.showImage(intent.getStringExtra("headPic"));*/
        mName.setText(intent.getStringExtra("userName"));
        mFollowNum.setText(intent.getStringExtra("followNum"));
        mFansNum.setText(bean.fansNum);
        mArticleNum.setText(bean.articleNum);

        mFans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMyHomePageActivity.this,FansActivity.class);
                startActivity(intent);
            }
        });
        mArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMyHomePageActivity.this,FollowActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViewPager() {
        myHomePageControllerViewPager = findViewById(R.id.vp_setting_myhomepage_content);
        myHomePageControllerViewPager.setCanScroll(false);

        gridFragment = MyHomePageGridFragment.newInstance();
        singleFragment = MyHomePageSingleFragment.newInstance();
        fragmentList.add(gridFragment);
        fragmentList.add(singleFragment);

        adapter = new MyHomePageAdapter(getSupportFragmentManager(),fragmentList);
        myHomePageControllerViewPager.setAdapter(adapter);
        myHomePageControllerViewPager.setCurrentItem(0);

        mGrid = findViewById(R.id.iv_setting_myhomepage_grid);
        mGrid.setOnClickListener(this);
        mSingle = findViewById(R.id.iv_setting_myhomepage_single);
        mSingle.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.iv_setting_myhomepage_grid:
                mGrid.setImageResource(R.drawable.ipole_icon_more);
                mSingle.setImageResource(R.drawable.ipole_icon_48);
                myHomePageControllerViewPager.setCurrentItem(0);
                break;
            case R.id.iv_setting_myhomepage_single:
                mSingle.setImageResource(R.drawable.ipole_icon_list);
                mGrid.setImageResource(R.drawable.ipole_icon_49);
                myHomePageControllerViewPager.setCurrentItem(1);
                break;
            case R.id.tv_setting_myhomepage_edithomepage:
                //todo 删除item数据后，点击编辑完成会重新获取原始数据
                if(flag==0) {
                    mEditHomePage.setBackgroundResource(R.drawable.payment_button_shape);
                    mEditHomePage.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    flag = 1;
                    if (myHomePageControllerViewPager.getCurrentItem() == 0) {
                        myHomePageBeanList = gridFragment.getGridShopList();
                        for (int i = 0; i < myHomePageBeanList.size(); i++) {
                            myHomePageBeanList.get(i).setDelete(false);
                        }
                        gridFragment.setGridMyHomePageBeanList(myHomePageBeanList);
                        mSingle.setClickable(true);
                    } else {
                        myHomePageBeanList = (singleFragment.getSingleShopList());
                        for (int i = 0; i < myHomePageBeanList.size(); i++) {
                            myHomePageBeanList.get(i).setDelete(false);
                        }
                        singleFragment.setSingleMyHomePageBeanList(myHomePageBeanList);
                        mGrid.setClickable(true);
                    }
                }else{
                    mEditHomePage.setBackgroundResource(R.drawable.payment_button_shape_4);
                    mEditHomePage.setTextColor(getResources().getColor(R.color.colorPrimary));
                    flag = 0;
                    if (myHomePageControllerViewPager.getCurrentItem() == 0) {
                        mGrid.setClickable(true);
                        myHomePageBeanList = gridFragment.getGridShopList();
                        for (int i = 0; i < myHomePageBeanList.size(); i++) {
                            myHomePageBeanList.get(i).setDelete(true);
                        }
                        gridFragment.setGridMyHomePageBeanList(myHomePageBeanList);
                        mSingle.setClickable(false);
                    } else {
                        mSingle.setClickable(true);
                        myHomePageBeanList = (singleFragment.getSingleShopList());
                        for (int i = 0; i < myHomePageBeanList.size(); i++) {
                            myHomePageBeanList.get(i).setDelete(true);
                        }
                        singleFragment.setSingleMyHomePageBeanList(myHomePageBeanList);
                       mGrid.setClickable(false);
                    }
                }
                break;
            case R.id.iv_setting_myhomepage_add:
                Intent intent = new Intent(MainMyHomePageActivity.this,MyHomePageAddActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
