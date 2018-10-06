package com.localworld.ishop.search.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.localworld.ishop.R;
import com.localworld.ishop.search.SearchTestImageBean;


import java.util.List;

public class SlidSampicAdapter extends RecyclerView.Adapter<SlidSampicAdapter.ViewHolder>{
    private List<SearchTestImageBean> mSlidSampicList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_sample,parent,false);
        ViewHolder holder =new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SearchTestImageBean searchTestImageBean = mSlidSampicList.get(position);
        holder.sampicT.setImageResource(searchTestImageBean.imageId);


    }

    @Override
    public int getItemCount() {
        return mSlidSampicList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView sampicT;
        public ViewHolder(View view){
            super(view);
            sampicT=(ImageView)view.findViewById(R.id.iv_search_samplet);
        }
    }
    public SlidSampicAdapter(List<SearchTestImageBean> sampicList){
        mSlidSampicList=sampicList;
    }
}
