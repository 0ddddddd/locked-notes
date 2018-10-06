package com.localworld.ishop.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.util.CommonUtils;
import com.localworld.ishop.model.home.HomeCategoryBean;

import java.util.ArrayList;
import java.util.List;



public class TopCategoryAdapter extends RecyclerView.Adapter<TopCategoryAdapter.TopCategoryVH> {

    private List<HomeCategoryBean> categoryList = new ArrayList<>();
    private TopTabClickListener tabClickListener;

    public void setCategoryList(List<HomeCategoryBean> responseList) {
        categoryList.clear();
        categoryList.addAll(responseList);
    }

    public void setTabClickListener(TopTabClickListener listener) {
        tabClickListener = listener;
    }

    @Override
    public TopCategoryVH onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.view_index_top_category_list_item, parent, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(CommonUtils.getScreenWidth(context) / 3, CommonUtils.dp2px(context, 30)));
        return new TopCategoryVH(view);
    }

    @Override
    public void onBindViewHolder(TopCategoryVH holder, int position) {
        holder.bind(categoryList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class TopCategoryVH extends RecyclerView.ViewHolder {
        private TextView textView;

        public TopCategoryVH(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_index_top_category_list_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position >= 0 && position < categoryList.size()) {
                        tabClickListener.onTabClick(position);
                    }
                }
            });
        }

        void bind(String text) {
            textView.setText(text);
        }
    }

    public interface TopTabClickListener {
        void onTabClick(int position);
    }
}
