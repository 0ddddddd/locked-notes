package com.localworld.ishop.home.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.igerm.android.lib.net.core.HdlCore;
import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportFragment;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.common.view.NestedRecyclerView;
import com.localworld.ishop.home.adapter.SpanHelper;
import com.localworld.ishop.home.bean.BaseHomeBean;

import java.util.List;


public class MainFragment2 extends BaseSupportFragment{

    private NestedRecyclerView recyclerView;
    private HomeIndexAdapter adapter;
    private ISNetService service = HdlCore.getInstance().getService(ISNetService.class);
    private List<BaseHomeBean> data;
    int spanCount = 2; // 3 columns
    int spacing = 12; // 50px
    boolean includeEdge = true;

    public static MainFragment2 newInstance() {
        Bundle args = new Bundle();
        MainFragment2 mainFragment2 = new MainFragment2();
        mainFragment2.setArguments(args);
        return mainFragment2;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_main2, container, false);
        initView(rootView);

        return rootView;
    }

    private void initView(View rootView) {
        recyclerView = rootView.findViewById(R.id.rcv_main_fragment2);
        adapter = new HomeIndexAdapter();

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSpanSizeLookup(new SpanHelper(adapter, 2));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        loadData();
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration());
    }

    private void loadData() {

        data = NewHomeMockUtils.getList();

        adapter.setDataList(data);
        adapter.notifyDataSetChanged();
    }

}
