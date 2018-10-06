package com.localworld.ishop.setting;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportActivity;
import com.localworld.ishop.common.view.ScrollControllerViewPager;
import com.localworld.ishop.setting.adapter.FollowPageAdapter;
import com.localworld.ishop.setting.fragment.FollowTopicFragment;
import com.localworld.ishop.setting.fragment.FollowUserFragment;

import java.util.ArrayList;
import java.util.List;

public class FollowActivity extends BaseSupportActivity implements View.OnClickListener {
    private ScrollControllerViewPager followContentViewPager;
    private TextView mFollowUser,mFollowTopic,mFollowUserLine,mFollowTopicLine;
    private List<Fragment> fragmentList = new ArrayList<>();
    private FollowPageAdapter adapter;
    private FollowUserFragment followUserFragment;
    private FollowTopicFragment followTopicFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_follow);
        initView();

    }
/*
*   初始化ViewPager*/
    private void initView(){
        ImageView mBack = findViewById(R.id.iv_setting_followed_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        followContentViewPager =findViewById(R.id.vp_setting_follow_content);
        followContentViewPager.setCanScroll(false);

        followUserFragment = FollowUserFragment.newInstance();
        followTopicFragment = FollowTopicFragment.newInstance();
        fragmentList.add(followUserFragment);
        fragmentList.add(followTopicFragment);

        adapter = new FollowPageAdapter(getSupportFragmentManager(),fragmentList);
        followContentViewPager.setAdapter(adapter);
        followContentViewPager.setCurrentItem(0);
        /*初始化链接*/
        mFollowUser = findViewById(R.id.tv_setting_follow_user);
        mFollowUserLine = findViewById(R.id.tv_setting_follow_userline);
        mFollowUser.setOnClickListener(this);

        mFollowTopic = findViewById(R.id.tv_setting_follow_topic);
        mFollowTopicLine = findViewById(R.id.tv_setting_follow_topicline);
        mFollowTopic.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.tv_setting_follow_user:
                mFollowUser.setTextColor(Color.BLACK);
                mFollowTopic.setTextColor(Color.GRAY);
                mFollowUserLine.setVisibility(view.VISIBLE);
                mFollowTopicLine.setVisibility(view.INVISIBLE);
                followContentViewPager.setCurrentItem(0);
                break;
            case R.id.tv_setting_follow_topic:
                mFollowTopic.setTextColor(Color.BLACK);
                mFollowUser.setTextColor(Color.GRAY);
                mFollowTopicLine.setVisibility(view.VISIBLE);
                mFollowUserLine.setVisibility(view.INVISIBLE);
                followContentViewPager.setCurrentItem(1);
                break;
            default:
                break;
        }
    }
}
