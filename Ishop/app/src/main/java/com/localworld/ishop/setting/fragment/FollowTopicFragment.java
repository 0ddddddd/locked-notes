package com.localworld.ishop.setting.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportFragment;
import com.localworld.ishop.setting.adapter.FollowTopicFollowedAdapter;
import com.localworld.ishop.setting.adapter.FollowTopicCommendAdapter;
import com.localworld.ishop.setting.bean.FollowTopicCommendBean;
import com.localworld.ishop.setting.bean.FollowTopicFollowedBean;

import java.util.List;

public class FollowTopicFragment extends BaseSupportFragment {

    private FollowTopicCommendAdapter commendAdapter;
    private FollowTopicFollowedAdapter followedTopicAdapter;
    private List<FollowTopicFollowedBean> followedList;
    private List<FollowTopicCommendBean> commendList;

    public static FollowTopicFragment newInstance(){
        Bundle bundle = new Bundle();
        FollowTopicFragment followTopicFragment = new FollowTopicFragment();
        followTopicFragment.setArguments(bundle);
        return followTopicFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_follow_topic,container,false);
        loadData();
        initTopicFollowedView(view);
        initTopicCommendView(view);
        return view;
    }

    private void initTopicCommendView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_setting_follow_topic_commend);
        commendAdapter = new FollowTopicCommendAdapter(commendList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(commendAdapter);
    }
    private void initTopicFollowedView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_setting_follow_topic_followed);
        followedTopicAdapter = new FollowTopicFollowedAdapter(followedList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(followedTopicAdapter);
    }

    private void loadData() {
        commendList = FollowTest.getTopicTestList();
        followedList = FollowTest.getFollowedBeans();
    }
}
