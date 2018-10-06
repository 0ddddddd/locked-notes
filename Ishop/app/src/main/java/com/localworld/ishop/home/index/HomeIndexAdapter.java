package com.localworld.ishop.home.index;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.home.adapter.IFullSpanPosition;
import com.localworld.ishop.home.bean.BaseHomeBean;
import com.localworld.ishop.home.bean.HomeAuthorRecommendBean;
import com.localworld.ishop.home.bean.HomeBannersBean;
import com.localworld.ishop.home.bean.HomeGoodsBean;
import com.localworld.ishop.home.viewholder.HomeBannerVH;
import com.localworld.ishop.home.viewholder.HomeGoodsVH;
import com.localworld.ishop.home.viewholder.HomeRecommendAuthorVH;
import com.localworld.ishop.home.viewholder.HomeRecommendSectionVH;

import java.util.ArrayList;
import java.util.List;


public class HomeIndexAdapter extends RecyclerView.Adapter<BaseViewHolder> implements IFullSpanPosition {

    private List<BaseHomeBean> mDataList = new ArrayList<>();

    public HomeIndexAdapter() {

    }

    public void setDataList(List<BaseHomeBean> list) {
        mDataList.clear();
        mDataList.addAll(list);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        Context context = parent.getContext();
        switch (viewType) {
            case BaseHomeBean.HORIZONTAL_DISPLAY_TYPE:
                view = LayoutInflater.from(context).inflate(R.layout.view_home_recommend_author_recyclerview, parent, false);
                return new HomeRecommendAuthorVH(view);
            case BaseHomeBean.DOUBLE_ROW_GOODS_TYPE:
                view = LayoutInflater.from(context).inflate(R.layout.view_home_goods_item, parent, false);
                return new HomeGoodsVH(view);
            case BaseHomeBean.HEAD_BANNER_TYPE_SLIDE:
                view = LayoutInflater.from(context).inflate(R.layout.view_home_banner_recyclerview, parent, false);
                return new HomeBannerVH(view);
            case BaseHomeBean.FOUR_HOLDER_TYPE:
                return null;
            case BaseHomeBean.AUTHOR_SECTION_TYPE:
                view = LayoutInflater.from(context).inflate(R.layout.view_home_recommend_section_item, parent, false);
                return new HomeRecommendSectionVH(view);
            default:
                view = LayoutInflater.from(context).inflate(R.layout.item_home_index_list, parent, false);
                return new HomeGoodsVH(view);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case BaseHomeBean.HEAD_BANNER_TYPE_SLIDE:
                ((HomeBannerVH) holder).bind((HomeBannersBean) mDataList.get(position));
                break;
            case BaseHomeBean.DOUBLE_ROW_GOODS_TYPE:
                ((HomeGoodsVH) holder).bind((HomeGoodsBean) mDataList.get(position));
                break;
            case BaseHomeBean.HORIZONTAL_DISPLAY_TYPE:
                ((HomeRecommendAuthorVH) holder).bind((HomeAuthorRecommendBean) mDataList.get(position));
                break;
            case BaseHomeBean.FOUR_HOLDER_TYPE:
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mDataList.get(position).frontType;
    }

    public List<BaseHomeBean> getmDataList(){
        return mDataList;
    }

    @Override
    public boolean isFullSpan(int position) {
        int type = getItemViewType(position);
        if (type == BaseHomeBean.DOUBLE_ROW_GOODS_TYPE){
            return false;
        } else {
            return true;
        }
    }
}
