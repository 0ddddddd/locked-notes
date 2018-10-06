package com.localworld.ishop.shop;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.igerm.android.lib.net.core.HdlCore;
import com.igerm.android.lib.net.core.HdlRawCallback;
import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportFragment;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.common.view.NestedRecyclerView;
import com.localworld.ishop.shop.adapter.ShopDetailAdapter;
import com.localworld.ishop.shop.bean.ShopAuthor;

import java.util.ArrayList;
import java.util.List;

public class ShopGoods1Fragment extends BaseSupportFragment {
    private NestedRecyclerView recyclerView;
    private ShopDetailAdapter adapter;
//    private List<ShopGoods1Bean> sg1List = new ArrayList<>();
    private List<ShopAuthor> shopAuthorList = new ArrayList<>();
    private ISNetService service1 = HdlCore.getInstance().getService(ISNetService.class);
    private int authorId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shopdetail_goods1, null);
        initView(rootView);
        return rootView;

    }
    private void initView(View rootView) {
        recyclerView = rootView.findViewById(R.id.rcv_shopgoods1_fragment);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ShopDetailAdapter(shopAuthorList);
        recyclerView.setAdapter(adapter);
        //loadData();
        requestData();

    }
//    private void loadData() {
//        List<ShopGoods1Bean> data = ShopGoods1UtilMock.getList();
//        adapter.setDataList(data);
//        adapter.notifyDataSetChanged();
//    }


    private void requestData(){

        service1.getShopAuthor(16).enqueue(new HdlRawCallback<List<ShopAuthor>>() {
            @Override
            protected void onSuccess(List<ShopAuthor> shopAuthor) {
                List<ShopAuthor> data = shopAuthor;
                adapter.setShopAuthorDataList(data);
                adapter.notifyDataSetChanged();
            }

            @Override
            protected void onFailed(String msg, int status) {
                String toastString;
                if (TextUtils.isEmpty(msg)) {
                    toastString = "网络似乎有点问题！";
                } else {
                    toastString = msg;
                }
                Toast.makeText(getContext(), toastString, Toast.LENGTH_SHORT).show();
            }
        });
    }

}


