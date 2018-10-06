package com.localworld.ishop.search.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.localworld.ishop.R;
import com.localworld.ishop.search.SlidSpic;

import java.util.List;

public class SlidSpicAdapter extends RecyclerView.Adapter<SlidSpicAdapter.ViewHolder>{
    private List<SlidSpic> mSlidSpicList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_special,parent,false);
        ViewHolder holder =new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        SlidSpic slidSpic = mSlidSpicList.get(position);
        holder.spic.setImageResource(slidSpic.getImageId());

    }

    @Override
    public int getItemCount() {
        return mSlidSpicList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView spic;


        public ViewHolder(View view){
            super(view);
            spic=(ImageView)view.findViewById(R.id.iv_search_spic);
        }
    }
    public SlidSpicAdapter(List<SlidSpic> spicList){
        mSlidSpicList=spicList;
    }
}
