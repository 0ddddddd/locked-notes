package com.localworld.ishop.setting.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.bean.MainDiscountBean;
import com.localworld.ishop.setting.viewholder.MainDiscountVH2;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 *
 * @author chenmiyang
 * @since 2018-08-07 10:43
 */
public class MainDiscountAdapter extends RecyclerView.Adapter<MainDiscountVH2> {
    private List<MainDiscountBean> discountBeanList = new ArrayList<>();

    public void setDiscountBeanList(List<MainDiscountBean> list) {
        discountBeanList.clear();
        discountBeanList.addAll(list);
    }

    @Override
    public MainDiscountVH2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_main_discount,parent,false);
        return new MainDiscountVH2(view);
    }

    @Override
    public void onBindViewHolder(MainDiscountVH2 holder, int position) {
        holder.bind(discountBeanList.get(position));
    }

    @Override
    public int getItemCount() {
        return discountBeanList.size();
    }
}
