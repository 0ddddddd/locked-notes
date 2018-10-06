package com.localworld.ishop.shop;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.igerm.android.lib.net.core.HdlCore;
import com.igerm.android.lib.net.core.HdlRawCallback;
import com.localworld.ishop.R;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.common.view.NestedRecyclerView;
import com.localworld.ishop.shop.adapter.ShopDetailAdapter2;
import com.localworld.ishop.shop.bean.ShopAuthor;

import java.util.ArrayList;
import java.util.List;

public class ShopGoods2Fragment extends Fragment {
    private NestedRecyclerView recyclerView;
    private ShopDetailAdapter2 adapter;
//    private List<ShopGoods2Bean> sg2List = new ArrayList<>();
    private ISNetService service2 = HdlCore.getInstance().getService(ISNetService.class);
    private List<ShopAuthor> shopAuthorList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shopdetail_goods2, null);
        initView(rootView);
        return rootView;


    }

    private void initView(View rootView) {
        recyclerView = rootView.findViewById(R.id.rcv_shopgoods2_fragment);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ShopDetailAdapter2(shopAuthorList);
        recyclerView.setAdapter(adapter);
        //loadData();
        requestData();

    }
//    private void loadData() {
//        List<ShopGoods2Bean> data = ShopGoods2UtilMock.getList();
//        adapter.setDataList(data);
//        adapter.notifyDataSetChanged();
//
//    }
    private void requestData(){

        service2.getShopAuthor(16).enqueue(new HdlRawCallback<List<ShopAuthor>>() {
            @Override
            protected void onSuccess(List<ShopAuthor> shopAuthor) {
                List<ShopAuthor> data = shopAuthor;
                adapter.setDataList(data);
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
