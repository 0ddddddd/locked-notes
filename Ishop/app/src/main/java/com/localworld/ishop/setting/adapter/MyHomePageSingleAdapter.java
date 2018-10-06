package com.localworld.ishop.setting.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.localworld.ishop.R;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.setting.bean.MyHomePageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 单列适配器
 *
 * @author chenmiyang
 * @since 2018-08-07 15:34
 */
public class MyHomePageSingleAdapter extends RecyclerView.Adapter<MyHomePageSingleAdapter.ViewHolder> {

    private List<MyHomePageBean> mDataList = new ArrayList<>();

    public MyHomePageSingleAdapter() {

    }

    public MyHomePageSingleAdapter(List<MyHomePageBean> mDataList) {
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
            mImg = (ISImageView)itemView.findViewById(R.id.iv_setting_myhomepage_singleimg);
            mDelete = itemView.findViewById(R.id.iv_setting_myhomepage_singledelete);
            mLayoutImg = itemView.findViewById(R.id.layout_setting_myhomepage_singleimg);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_myhomepage_singleimg,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHomePageSingleAdapter.ViewHolder holder, final int position) {
        MyHomePageBean bean = mDataList.get(position);
        holder.mImg.showImage(bean.img);
        holder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"删除成功！",Toast.LENGTH_SHORT).show();
                removeData(position);
            }
        });
        if (mDataList.get(position).isDelete()==true){
            holder.mDelete.setVisibility(View.VISIBLE);
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
