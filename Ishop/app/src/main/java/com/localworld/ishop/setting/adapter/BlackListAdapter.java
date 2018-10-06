package com.localworld.ishop.setting.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.bean.BlackListBean;
import com.localworld.ishop.setting.viewholder.BlackListVH;

import java.util.ArrayList;
import java.util.List;

public class BlackListAdapter extends RecyclerView.Adapter<BlackListVH> {
    private List<BlackListBean> blackListBeanList = new ArrayList<>();

    public void setBlackListBeanList(List<BlackListBean> list) {
        blackListBeanList.clear();
        blackListBeanList.addAll(list);
    }

    @Override
    public BlackListVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_setting_blacklist,parent,false);
        return new BlackListVH(view);
    }

    @Override
    public void onBindViewHolder(BlackListVH holder, int position) {
        ((BlackListVH) holder).bind((BlackListBean) blackListBeanList.get(position));
    }

    @Override
    public int getItemCount() {
        return blackListBeanList.size();
    }
}
