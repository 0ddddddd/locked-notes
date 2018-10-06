package com.localworld.ishop.search.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.localworld.ishop.R;
import com.localworld.ishop.search.SlidSpic;

import java.util.List;

public class SearchGoodsRecycleAdapter extends RecyclerView.Adapter<SearchGoodsRecycleAdapter.ViewHolder>{
    private List<SlidSpic> mSlidSpicList;
    private ItemClickListener clickListener;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_goods,parent,false);
        ViewHolder holder =new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        SlidSpic slidSpic = mSlidSpicList.get(position);
        holder.mGoods.setImageResource(slidSpic.getImageId());

        if(clickListener != null) {
            holder.mGoods.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 点击事件
                    //  Toast.makeText(mContext, postion + "", 1000).show();
                    clickListener.OnItemClick(view,position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mSlidSpicList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mGoods;


        public ViewHolder(View view){
            super(view);
            mGoods = (ImageView)view.findViewById(R.id.iv_search_goods);
        }
    }
    public SearchGoodsRecycleAdapter setClickListener(ItemClickListener clickListener){
        this.clickListener = clickListener;
        return  this;
    }
    public interface ItemClickListener {
        //声明接口ItemClickListener
        void OnItemClick(View view, int position);
        //void OnTitleClick(View view,int position);
        //void OnInfoClick(View view,int position);
        //void OnTypeClick(View view,int position);
    }
    public SearchGoodsRecycleAdapter(List<SlidSpic> spicList){
        mSlidSpicList=spicList;
    }



}

