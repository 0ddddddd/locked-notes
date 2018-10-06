package com.localworld.ishop.home.discovery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.home.adapter.IFullSpanPosition;
import com.localworld.ishop.home.bean.BaseHomeBean;
import com.localworld.ishop.home.bean.DiscoveryFriendsBean;
import com.localworld.ishop.home.viewholder.DiscoveryFriendsVH;
import com.localworld.ishop.home.viewholder.HomeGoodsVH;

import java.util.ArrayList;
import java.util.List;


public class DiscoveryFriendsAdapter extends RecyclerView.Adapter<BaseViewHolder> implements IFullSpanPosition {

    private List<BaseHomeBean> mDataList = new ArrayList<>();

    public DiscoveryFriendsAdapter() {

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
            case BaseHomeBean.DISCOVERY_FRIENDS_TYPE:
                view= LayoutInflater.from(context).inflate(R.layout.view_discovery_friends,parent,false);
                return new DiscoveryFriendsVH(view);
            default:
                view = LayoutInflater.from(context).inflate(R.layout.item_home_index_list, parent, false);
                return new HomeGoodsVH(view);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case BaseHomeBean.DISCOVERY_FRIENDS_TYPE:
                ((DiscoveryFriendsVH)holder).bind((DiscoveryFriendsBean) mDataList.get(position));
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

    @Override
    public boolean isFullSpan(int position) {
        int type = getItemViewType(position);
        if (type == BaseHomeBean.DISCOVERY_SPECIAL_DOUBLE_ROW_GOODS_TYPE){
            return false;
        } else {
            return true;
        }
    }
}
