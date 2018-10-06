package com.localworld.ishop.setting.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.home.adapter.IFullSpanPosition;
import com.localworld.ishop.setting.bean.FollowFollowedUserBean;
import com.localworld.ishop.setting.viewholder.FollowFollowedUserVH;

import java.util.ArrayList;
import java.util.List;

public class FollowUserAdapter extends RecyclerView.Adapter<BaseViewHolder> implements IFullSpanPosition {

    private List<FollowFollowedUserBean> mDataList = new ArrayList<>();

    public void setmDataList(List<FollowFollowedUserBean> list) {
        mDataList.clear();
        mDataList.addAll(list);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_follow_followeduser,parent,false);
        return new FollowFollowedUserVH(view);

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        ((FollowFollowedUserVH) holder).bind((FollowFollowedUserBean) mDataList.get(position));

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public boolean isFullSpan(int position) {
        return false;
    }
}
