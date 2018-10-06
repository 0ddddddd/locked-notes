package com.localworld.ishop.home.viewholder;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.view.NestedRecyclerView;
import com.localworld.ishop.home.bean.HomeAuthorRecommendBean;

import java.util.ArrayList;
import java.util.List;


public class HomeRecommendAuthorVH extends BaseViewHolder<HomeAuthorRecommendBean> {

    private NestedRecyclerView mAuthorListView;
    private HomeAuthorAdapter mAdapter;

    public HomeRecommendAuthorVH(View itemView) {
        super(itemView);
        mAuthorListView = itemView.findViewById(R.id.rv_home_recommend_author_list);
        mAuthorListView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        mAdapter = new HomeAuthorAdapter();
        mAuthorListView.setAdapter(mAdapter);
    }

    @Override
    public void bind(HomeAuthorRecommendBean bean) {

        List<HomeAuthorRecommendBean.AuthorBean> authorBeans = bean.authors;
        mAdapter.setDataList(authorBeans);
        mAdapter.notifyDataSetChanged();

    }

    public class HomeAuthorAdapter extends RecyclerView.Adapter<HomeRecommendAuthorItemVH> {

        private List<HomeAuthorRecommendBean.AuthorBean> mDataList = new ArrayList<>();
        private ImageView deleteIv;

        public void setDataList(List<HomeAuthorRecommendBean.AuthorBean> list) {
            mDataList.clear();
            mDataList.addAll(list);
        }

        @Override
        public HomeRecommendAuthorItemVH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_home_recommend_author_item, parent, false);
            deleteIv=view.findViewById(R.id.iv_author_delete);
            return new HomeRecommendAuthorItemVH(view);
        }

        @Override
        public void onBindViewHolder(final HomeRecommendAuthorItemVH holder, final int position) {
            holder.bind(mDataList.get(position));
            deleteIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDataList.remove(holder.getAdapterPosition());
                    //notifyDataSetChanged();
                    notifyItemRemoved(holder.getAdapterPosition());
                    notifyItemRangeChanged(holder.getAdapterPosition(), mDataList.size()-holder.getAdapterPosition());
                }
            });
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }
    }
}
