package com.localworld.ishop.search;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.localworld.ishop.R;
import com.localworld.ishop.search.adapter.SearchViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchTypeFragment extends AppCompatActivity {

  //  private TextView tvTitle;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Button mbackbtn;

    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_search_types);
        fragmentList.add(new QuerySearchClothFragment());
        fragmentList.add(new QuerySearchRubyFragment());
        fragmentList.add(new QuerySearchFurnitureFragment());
        fragmentList.add(new QuerySearchBagFragment());
        fragmentList.add(new QuerySearchShoeFragment());


        mViewPager= (ViewPager) findViewById(R.id.vp_SearchFragment_pager);
        SearchViewPagerAdapter searchViewPagerAdapter = new SearchViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(searchViewPagerAdapter);
        mTabLayout= (TabLayout) findViewById(R.id.tab_SearchFragment_title);
        mTabLayout.addTab(mTabLayout.newTab().setText("衣物"));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText("首饰"));
        mTabLayout.addTab(mTabLayout.newTab().setText("家具"));
        mTabLayout.addTab(mTabLayout.newTab().setText("箱包"));
        mTabLayout.addTab(mTabLayout.newTab().setText("鞋子"));

        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.getTabAt(0).setText("衣物");
        mTabLayout.getTabAt(1).setText("首饰");
        mTabLayout.getTabAt(2).setText("家具");
        mTabLayout.getTabAt(3).setText("箱包");
        mTabLayout.getTabAt(4).setText("鞋子");
        mbackbtn= findViewById(R.id.btn_search_back);
        mbackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

