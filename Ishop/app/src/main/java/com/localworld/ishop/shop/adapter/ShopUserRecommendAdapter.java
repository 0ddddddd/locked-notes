package com.localworld.ishop.shop.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.shop.bean.ShopRecommendUserBean;

import java.util.ArrayList;
import java.util.List;

public class ShopUserRecommendAdapter extends RecyclerView.Adapter<ShopUserRecommendAdapter.ViewHolder>{
    private List<ShopRecommendUserBean> mShopGoodsBeanList = new ArrayList<>();



    static class ViewHolder extends RecyclerView.ViewHolder{
        ISImageView shopgoodsImage;
        TextView usernameText;


        public ViewHolder(View view){
            super(view);
            shopgoodsImage = (ISImageView)view.findViewById(R.id.iv_shopuser_recommend);
            usernameText = (TextView)view.findViewById(R.id.recommend_user_name);
        }
    }
    public ShopUserRecommendAdapter(List<ShopRecommendUserBean> list){
        mShopGoodsBeanList = list;
    }

    public void setDataList(List<ShopRecommendUserBean> list) {
        mShopGoodsBeanList.clear();
        mShopGoodsBeanList.addAll(list);
    }

    @Override
    public ShopUserRecommendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shopdetail_recommend,parent,false);
        ShopUserRecommendAdapter.ViewHolder holder = new ShopUserRecommendAdapter.ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ShopUserRecommendAdapter.ViewHolder holder, final int position){
        ShopRecommendUserBean shopRecommendUserBean = mShopGoodsBeanList.get(position);
        holder.shopgoodsImage.showImage(shopRecommendUserBean.userimage);
        holder.usernameText.setText(shopRecommendUserBean.username);

    }
    @Override
    public int getItemCount(){
        return mShopGoodsBeanList.size();
    }

}
