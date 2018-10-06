package com.localworld.ishop.setting.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.setting.bean.MyFavoriteBean;

import java.util.List;

public class MyFavoriteAdapter extends RecyclerView.Adapter<MyFavoriteAdapter.ViewHolder> {
    private List<MyFavoriteBean> myFavoriteBeanList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ISImageView ISImageView;

        public ViewHolder(View view) {
            super(view);
            ISImageView = view.findViewById(R.id.iv_setting_setting_myfavorite);
        }
    }

    public MyFavoriteAdapter(List<MyFavoriteBean> myFavoriteBean){
        myFavoriteBeanList = myFavoriteBean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_setting_myfavorite,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        MyFavoriteBean myCollectionBean = myFavoriteBeanList.get(position);
        holder.ISImageView.showImage(myCollectionBean.img);
    }

    @Override
    public int getItemCount(){
        return myFavoriteBeanList.size();
    }

}
