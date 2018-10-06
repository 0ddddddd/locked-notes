package com.localworld.ishop.setting.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.bean.PaidGoodsBean;
import com.localworld.ishop.setting.viewholder.PaidGoodsVH;

import java.util.ArrayList;
import java.util.List;

public class PaidAdapter extends RecyclerView.Adapter<PaidGoodsVH> {

    List<PaidGoodsBean> beanList = new ArrayList<>();

    public void setBeanList(List<PaidGoodsBean>list) {
        beanList.clear();
        beanList.addAll(list);
    }

    @Override
    public PaidGoodsVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_paid_good,parent,false);
        return new PaidGoodsVH(view);
    }

    @Override
    public void onBindViewHolder(PaidGoodsVH holder, int position) {
        ((PaidGoodsVH) holder).bind((PaidGoodsBean) beanList.get(position));
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

}
