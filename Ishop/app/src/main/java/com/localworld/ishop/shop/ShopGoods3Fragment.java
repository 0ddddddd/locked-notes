package com.localworld.ishop.shop;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportFragment;
import com.localworld.ishop.common.view.NestedRecyclerView;
import com.localworld.ishop.shop.adapter.ShopDetailAdapter;
import com.localworld.ishop.shop.bean.ShopAuthor;

import java.util.ArrayList;
import java.util.List;

public class ShopGoods3Fragment extends BaseSupportFragment {
    private NestedRecyclerView recyclerView;
    private ShopDetailAdapter adapter3;
//    private List<ShopGoods1Bean> sgaboutList = new ArrayList<>();
    private List<ShopAuthor> shopAuthorData = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shopdetail_goods3, null);
        initView(rootView);
        return rootView;

    }
    private void initView(View rootView) {
        recyclerView = rootView.findViewById(R.id.rcv_shopgoods3_fragment);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter3 = new ShopDetailAdapter(shopAuthorData);
        recyclerView.setAdapter(adapter3);
//        loadData();

    }
//    private void loadData() {
//        List<ShopGoods1Bean> data = ShopGoods1UtilMock.getList();
//        adapter3.setDataList(data);
//        adapter3.notifyDataSetChanged();
//    }
}
