package com.localworld.ishop.home.discovery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportFragment;
import com.localworld.ishop.common.view.NestedRecyclerView;
import com.localworld.ishop.home.adapter.SpanHelper;
import com.localworld.ishop.home.bean.BaseHomeBean;

import java.util.List;

public class DiscoveryFriendsFragment extends BaseSupportFragment {
    private NestedRecyclerView recyclerView;
    private DiscoveryFriendsAdapter mAdapter;

    public static DiscoveryFriendsFragment newInstance() {
        Bundle args = new Bundle();
        DiscoveryFriendsFragment discoveryFriendsFragment = new DiscoveryFriendsFragment();
        discoveryFriendsFragment.setArguments(args);
        return discoveryFriendsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_discovery_friends, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        recyclerView = rootView.findViewById(R.id.rcv_discovery_fragment_friends);
        mAdapter = new DiscoveryFriendsAdapter();

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSpanSizeLookup(new SpanHelper(mAdapter, 2));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        loadData();
    }

    private void loadData() {

        List<BaseHomeBean> data = NewDiscoveryFriendsMockUtils.getList();

        mAdapter.setDataList(data);
        mAdapter.notifyDataSetChanged();
    }
}
