package com.localworld.ishop.setting.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.setting.bean.FollowTopicFollowedBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 *
 * @author chenmiyang
 * @since 2018-08-09 13:46
 */
public class FollowTopicFollowedAdapter extends RecyclerView.Adapter<FollowTopicFollowedAdapter.ViewHolder> {
    private List<FollowTopicFollowedBean> followedBeanList = new ArrayList<>();

    public FollowTopicFollowedAdapter(List<FollowTopicFollowedBean> followedBeanList) {
        this.followedBeanList = followedBeanList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ISImageView mTopicHeadPic;
        TextView mTopicName;
        TextView mArticleNum;
        TextView mFollowBtn;
        ViewHolder(View itemView) {
            super(itemView);
            mTopicHeadPic = itemView.findViewById(R.id.iv_setting_follow_topic_followed_headpic);
            mTopicName = itemView.findViewById(R.id.tv_setting_follow_topic_followed_name);
            mArticleNum = itemView.findViewById(R.id.tv_setting_follow_topic_followed_articlenum);
            mFollowBtn = itemView.findViewById(R.id.tv_setting_follow_topic_followed_btn);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_follow_topic_followed,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FollowTopicFollowedBean bean = new FollowTopicFollowedBean();
        holder.mTopicHeadPic.showImage(bean.topicHeadPic);
        holder.mTopicName.setText(bean.topicName);
        holder.mArticleNum.setText(bean.articleNum);
        holder.mFollowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo 已关注话题
            }
        });
    }

    @Override
    public int getItemCount() {
        return followedBeanList.size();
    }
}
