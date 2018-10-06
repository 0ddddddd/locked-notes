package com.localworld.ishop.search.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.localworld.ishop.R;

public class SearchShoeRecycleAdapter extends RecyclerView.Adapter<SearchShoeRecycleAdapter.ViewHolder>{

        private FragmentActivity mContext;
        private String[] shoeStrs = new String[100];
        private ItemClickListener clickListener;


        public SearchShoeRecycleAdapter(FragmentActivity activity) {
            this.mContext=activity;
            //为测试给Recycler添加数据
            initStr();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_search_types, null);
            ViewHolder viewHolder = new ViewHolder(view);

            return viewHolder;

        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.textView.setText(shoeStrs[position]);
            if(clickListener != null) {
                holder.typeView.setOnClickListener(new View.OnClickListener() {
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
            return shoeStrs.length;
        }

        static class ViewHolder extends RecyclerView.ViewHolder {

            private TextView textView;
            private View typeView;
            public ViewHolder(View itemView) {
                super(itemView);
                typeView = itemView;
                textView= (TextView) itemView.findViewById(R.id.tv_search_types);

            }
        }
        public SearchShoeRecycleAdapter setClickListener(ItemClickListener clickListener){
            this.clickListener = clickListener;
            return  this;
        }
        public interface ItemClickListener {
            //声明接口ItemClickListener
            void OnItemClick(View view, int position);
    //        void OnTitleClick(View view,int position);
    //        void OnInfoClick(View view,int position);
    //        void OnTypeClick(View view,int position);
        }

    public void initStr(){
        shoeStrs= new String[]{"全部鞋子", "运动鞋","小白鞋","棉鞋","高帮鞋","简约风"};
    }

    }

