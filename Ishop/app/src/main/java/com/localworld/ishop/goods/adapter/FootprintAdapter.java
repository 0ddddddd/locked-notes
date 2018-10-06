package com.localworld.ishop.goods.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.goods.bean.FootprintBean;
import com.localworld.ishop.goods.bean.FootprintTimeBean;
import com.localworld.ishop.goods.viewholder.FootprintTimeVH;
import com.localworld.ishop.goods.viewholder.FootprintVH;
import com.localworld.ishop.home.adapter.IFullSpanPosition;
import com.localworld.ishop.home.bean.BaseHomeBean;

import java.util.ArrayList;
import java.util.List;

public class FootprintAdapter extends RecyclerView.Adapter<BaseViewHolder> implements IFullSpanPosition {

    private List<BaseHomeBean> mDataList = new ArrayList<>();

    public FootprintAdapter() {

    }

    public void setDataList(List<BaseHomeBean> list) {
        mDataList.clear();
        mDataList.addAll(list);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        Context context = parent.getContext();
        switch (viewType) {
            case BaseHomeBean.FOOTPRINT_TIME:
                view = LayoutInflater.from(context).inflate(R.layout.item_footprint_time, parent, false);
                return new FootprintTimeVH(view);
            case BaseHomeBean.FOOTPRINT_CONTENT:
                view = LayoutInflater.from(context).inflate(R.layout.item_footprint, parent, false);
                return new FootprintVH(view);
            default:
                view = LayoutInflater.from(context).inflate(R.layout.item_footprint, parent, false);
                return new FootprintVH(view);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case BaseHomeBean.FOOTPRINT_TIME:
                ((FootprintTimeVH) holder).bind((FootprintTimeBean) mDataList.get(position));
                break;
            case BaseHomeBean.FOOTPRINT_CONTENT:
                ((FootprintVH) holder).bind((FootprintBean) mDataList.get(position));
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mDataList.get(position).frontType;
    }

    public List<BaseHomeBean> getmDataList() {
        return mDataList;
    }

    @Override
    public boolean isFullSpan(int position) {
        int type = getItemViewType(position);
        if (type == BaseHomeBean.FOOTPRINT_CONTENT){
            return false;
        } else {
            return true;
        }
    }
}
