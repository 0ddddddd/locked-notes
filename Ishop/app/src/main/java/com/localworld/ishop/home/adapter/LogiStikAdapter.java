package com.localworld.ishop.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.model.LogiStik;

import java.util.List;



public class LogiStikAdapter extends RecyclerView.Adapter<LogiStikAdapter.ViewHolder>{
    private List<LogiStik> mLogiStikList;
    public LogiStikAdapter(List<LogiStik> LogiStikList){
        mLogiStikList=LogiStikList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView logistik_data,logistik_time,logistik_status,logistik_comment;
        View logistik_view;

        public ViewHolder(View view) {
            super(view);
            logistik_data=view.findViewById(R.id.logistik_data);
            logistik_time=view.findViewById(R.id.logistik_time);
            logistik_status=view.findViewById(R.id.logistik_status);
            logistik_comment=view.findViewById(R.id.logistik_comment);
            logistik_view=view.findViewById(R.id.logistik_view);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.logistik_item1,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LogiStik logiStik=mLogiStikList.get(position);
        holder.logistik_data.setText(logiStik.getData());
        holder.logistik_time.setText(logiStik.getTime());
        holder.logistik_status.setText(logiStik.getStatus());
        holder.logistik_comment.setText(logiStik.getComment());
        //隐藏第一个View
        if(position==0){
            holder.logistik_view.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mLogiStikList.size();
    }


}
