package com.localworld.ishop.setting.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.home.adapter.IFullSpanPosition;
import com.localworld.ishop.setting.bean.FollowTopicCommendBean;

import java.util.ArrayList;
import java.util.List;

public class FollowTopicCommendAdapter extends RecyclerView.Adapter<FollowTopicCommendAdapter.ViewHolder> implements IFullSpanPosition {

    private List<FollowTopicCommendBean> mDataList = new ArrayList<>();
    private FollowTopicCommendBean bean;

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ISImageView mTopicHeadPic;
        private TextView mTopicName;
        private TextView mArticleNum;
        private TextView mFollowBtn;
        public ViewHolder(View itemView) {
            super(itemView);
            mTopicHeadPic = itemView.findViewById(R.id.iv_setting_follow_topicheadpic);
            mTopicName = itemView.findViewById(R.id.tv_setting_follow_topicname);
            mArticleNum = itemView.findViewById(R.id.tv_setting_follow_articlenum);
            mFollowBtn = itemView.findViewById(R.id.tv_setting_follow_followbtn);
        }
    }

    public FollowTopicCommendAdapter(List<FollowTopicCommendBean> mDataList) {
        this.mDataList = mDataList;
    }

    public void setmDataList(List<FollowTopicCommendBean> list) {
        mDataList.clear();
        mDataList.addAll(list);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        Context context = parent.getContext();
        view = LayoutInflater.from(context).inflate(R.layout.item_setting_follow_topic_commend,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        bean = new FollowTopicCommendBean();
        holder.mTopicHeadPic.showImage(bean.ctopicHeadPic);
        holder.mTopicName.setText(bean.ctopicName);
        holder.mArticleNum.setText(bean.carticleNum);
        holder.mFollowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
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
