package com.localworld.ishop.shop.adapter;


import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.shop.bean.ShopAuthor;
import com.localworld.ishop.shop.bean.ShopGoods1Bean;

import java.util.ArrayList;
import java.util.List;


public class ShopDetailAdapter extends RecyclerView.Adapter<ShopDetailAdapter.ViewHolder> {
    private List<ShopGoods1Bean> mShopGoods1BeanList = new ArrayList<>();
    private List<ShopAuthor> authorDataList = new ArrayList<>();


    class ViewHolder extends RecyclerView.ViewHolder{
        ISImageView shopgoodsImage;


        public ViewHolder(View view){
            super(view);
            shopgoodsImage = (ISImageView)view.findViewById(R.id.iv_shopdetail_good1_item);
        }
    }
//    public ShopDetailAdapter(List<ShopGoods1Bean> list){
//        mShopGoods1BeanList = list;
//    }
    public ShopDetailAdapter(List<ShopAuthor> list){
        authorDataList = list;
    }


    public void setDataList(List<ShopGoods1Bean> list) {
        mShopGoods1BeanList.clear();
        mShopGoods1BeanList.addAll(list);
    }

    public void setShopAuthorDataList(List<ShopAuthor> bean){
        authorDataList.clear();
        authorDataList.addAll(bean);
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shopdetail_goods1,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
//        ShopGoods1Bean shopgoods = mShopGoods1BeanList.get(position);
        ShopAuthor shopAuthor = authorDataList.get(position);
        holder.shopgoodsImage.showImage(shopAuthor.contentPic);
        String contentPics = shopAuthor.contentPics;
        if (!TextUtils.isEmpty(contentPics)) {
            String[] pics = contentPics.split(",");


        }

    }
//    @Override
//    public int getItemCount(){
//        return mShopGoods1BeanList.size();
//    }
    @Override
    public int getItemCount(){
        return authorDataList.size();
    }

}
