package com.localworld.ishop.setting.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.bean.OpenAllFriendsBean;
import com.localworld.ishop.setting.viewholder.OpenAllFriendsVH;

import java.util.ArrayList;
import java.util.List;

public class OpenAllFriendsAdapter extends RecyclerView.Adapter<OpenAllFriendsVH> {
    private List<OpenAllFriendsBean> openAllFriendsBeanList = new ArrayList<>();

    public void setOpenAllFriendsBeanList(List<OpenAllFriendsBean> list) {
        openAllFriendsBeanList.clear();
        openAllFriendsBeanList.addAll(list);
    }

    @Override
    public OpenAllFriendsVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_friends_friend,parent,false);
        return new OpenAllFriendsVH(view);
    }

    @Override
    public void onBindViewHolder(OpenAllFriendsVH holder, int position) {
        ((OpenAllFriendsVH) holder).bind((OpenAllFriendsBean) openAllFriendsBeanList.get(position));
    }

    @Override
    public int getItemCount() {
        return openAllFriendsBeanList.size();
    }
}
