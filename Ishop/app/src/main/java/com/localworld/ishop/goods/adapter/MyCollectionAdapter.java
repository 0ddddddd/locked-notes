package com.localworld.ishop.goods.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.goods.bean.MyCollectionBean;

import java.util.List;

public class MyCollectionAdapter extends RecyclerView.Adapter<MyCollectionAdapter.ViewHolder> {
    private List<MyCollectionBean> myCollectionBeanList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ISImageView ISImageView;

        public ViewHolder(View view) {
            super(view);
            ISImageView =view.findViewById(R.id.iv_mycollection_item);
        }
    }

    public MyCollectionAdapter(List<MyCollectionBean> myCollectionBeans){
        myCollectionBeanList = myCollectionBeans;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mycollection,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        MyCollectionBean myCollectionBean = myCollectionBeanList.get(position);
        holder.ISImageView.showImage(myCollectionBean.picPath);
    }

    @Override
    public int getItemCount(){
        return myCollectionBeanList.size();
    }

}
