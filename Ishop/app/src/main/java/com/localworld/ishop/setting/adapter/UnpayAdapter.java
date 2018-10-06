package com.localworld.ishop.setting.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.bean.UnpayGoodsBean;
import com.localworld.ishop.setting.viewholder.UnpayGoodsVH;

import java.util.ArrayList;
import java.util.List;

public class UnpayAdapter extends RecyclerView.Adapter<UnpayGoodsVH> {

    private List<UnpayGoodsBean> unpayGoodsBeanList = new ArrayList<>();

    public void setUnpayGoodsBeanList(List<UnpayGoodsBean> list) {
        unpayGoodsBeanList.clear();
        unpayGoodsBeanList.addAll(list);
    }

    @Override
    public UnpayGoodsVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_unpay_good,parent,false);
        return new UnpayGoodsVH(view);
    }

    @Override
    public void onBindViewHolder(UnpayGoodsVH holder, int position) {
        ((UnpayGoodsVH) holder).bind((UnpayGoodsBean) unpayGoodsBeanList.get(position));
    }

    @Override
    public int getItemCount() {
        return unpayGoodsBeanList.size();
    }
}
