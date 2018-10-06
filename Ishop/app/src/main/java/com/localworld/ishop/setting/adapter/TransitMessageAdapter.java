package com.localworld.ishop.setting.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.bean.TransitMessageBean;
import com.localworld.ishop.setting.viewholder.TransitMessageVH;

import java.util.ArrayList;
import java.util.List;

public class TransitMessageAdapter extends RecyclerView.Adapter<TransitMessageVH> {

    private List<TransitMessageBean> deliveredList = new ArrayList<>();

    public void setList(List<TransitMessageBean> list) {
        deliveredList.clear();
        deliveredList.addAll(list);
    }

    @Override
    public TransitMessageVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_delivered_transitmessage,parent,false);
        return new TransitMessageVH(view);
    }

    @Override
    public void onBindViewHolder(TransitMessageVH holder, int position) {
        ((TransitMessageVH)holder).bind((TransitMessageBean) deliveredList.get(position));
    }

    @Override
    public int getItemCount() {
        return deliveredList.size();
    }
}
