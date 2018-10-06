package com.localworld.ishop.setting.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.bean.AddAccountBean;
import com.localworld.ishop.setting.viewholder.AddAccountVH;

import java.util.ArrayList;
import java.util.List;

public class AddAccountAdapter extends RecyclerView.Adapter<AddAccountVH> {
    private List<AddAccountBean> accountBeanList = new ArrayList<>();

    public void setAccountBeanList(List<AddAccountBean> list) {
        accountBeanList.clear();
        accountBeanList.addAll(list);
    }

    @Override
    public AddAccountVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_setting_addaccount,parent,false);
        return new AddAccountVH(view);
    }

    @Override
    public void onBindViewHolder(AddAccountVH holder, int position) {
        ((AddAccountVH) holder).bind((AddAccountBean) accountBeanList.get(position));
    }

    @Override
    public int getItemCount() {
        return accountBeanList.size();
    }
}
