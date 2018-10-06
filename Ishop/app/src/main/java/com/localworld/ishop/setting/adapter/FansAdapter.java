package com.localworld.ishop.setting.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.setting.bean.FansBean;

import java.util.List;

/**
 * 文件描述
 *
 * @author chenmiyang
 * @since 2018-08-08 15:19
 */
public class FansAdapter extends RecyclerView.Adapter<FansAdapter.ViewHolder> {
    private List<FansBean> fansBeansList;

    public FansAdapter(List<FansBean> fansBeansList) {
        this.fansBeansList = fansBeansList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ISImageView mFansPic;
        TextView mFansName;
        TextView mFansId;
        TextView mFollow;
        public ViewHolder(View itemView) {
            super(itemView);
            mFansPic = itemView.findViewById(R.id.iv_setting_myhomepage_fans_pic);
            mFansName = itemView.findViewById(R.id.tv_setting_myhomepage_fans_name);
            mFansId = itemView.findViewById(R.id.tv_setting_myhomepage_fans_id);
            mFollow = itemView.findViewById(R.id.tv_setting_myhomepage_fans_followedbtn);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_myhomepage_fans,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        FansBean bean = new FansBean();
        holder.mFansPic.showImage(bean.fansPic);
        holder.mFansName.setText(bean.fansName);
        holder.mFansId.setText(bean.fansId);
        holder.mFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.mFollow.setBackgroundResource(R.drawable.payment_button_shape);
                holder.mFollow.setTextColor(Color.BLACK);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fansBeansList.size();
    }
}
