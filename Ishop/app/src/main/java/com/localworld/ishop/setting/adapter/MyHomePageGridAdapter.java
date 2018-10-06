package com.localworld.ishop.setting.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.localworld.ishop.R;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.setting.bean.MyHomePageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 *
 * @author chenmiyang
 * @since 2018-08-07 15:34
 */
public class MyHomePageGridAdapter extends RecyclerView.Adapter<MyHomePageGridAdapter.ViewHolder> {

    private List<MyHomePageBean> mDataList = new ArrayList<>();

    public MyHomePageGridAdapter(){

    }

    public MyHomePageGridAdapter(List<MyHomePageBean> mDataList) {
        this.mDataList = mDataList;
    }

    public void setmDataList(List<MyHomePageBean> myHomePageBeanList){
        mDataList.clear();
        mDataList.addAll(myHomePageBeanList);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ISImageView mImg;
        ImageView mDelete;
        LinearLayout mLayoutImg;

        public ViewHolder(View itemView) {
            super(itemView);
            mImg = (ISImageView)itemView.findViewById(R.id.iv_setting_myhomepage_gridimg);
            mDelete = itemView.findViewById(R.id.iv_setting_myhomepage_griddelete);
            mLayoutImg = itemView.findViewById(R.id.layout_setting_myhomepage_gridimg);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_myhomepage_gridimg,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHomePageGridAdapter.ViewHolder holder, final int position) {
        MyHomePageBean bean = mDataList.get(position);
        holder.mImg.showImage(bean.img);
        holder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeData(position);
            }
        });
        if(mDataList.get(position).isDelete()==true){
            holder.mDelete.setVisibility(View.VISIBLE);
        }
        else if(mDataList.get(position).isDelete()==false){
            holder.mDelete.setVisibility(View.GONE);
        }
    }


    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    private void removeData(int position){
        mDataList.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();

    }

}
