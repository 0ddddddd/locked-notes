package com.localworld.ishop.home.discovery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.home.bean.BaseHomeBean;
import com.localworld.ishop.home.bean.DiscoverySpecialBean;
import com.localworld.ishop.home.viewholder.DiscoverySpecialBannerVH;
import com.localworld.ishop.home.viewholder.DiscoverySpecialGoodsVH;
import com.localworld.ishop.home.viewholder.DiscoverySpecialSectionVH;

import java.util.ArrayList;
import java.util.List;


public class DiscoverySpecialAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<DiscoverySpecialBean.SpecialBean> mDataList = new ArrayList<>();

    public DiscoverySpecialAdapter() {

    }

    public void setDataList(List<DiscoverySpecialBean.SpecialBean> list) {
        mDataList.clear();
        mDataList.addAll(list);
        for(int i=0;i<mDataList.size();i++){
            mDataList.get(i).frontType=BaseHomeBean.HEAD_BANNER_TYPE_FIXED;
        }
    }

/*    public void addDataList(){
        for(int i=0;i<mDataList.size();i++){
            if(i%3==1){
                DiscoverySpecialBean discoverySpecialBean=new DiscoverySpecialBean();
                DiscoverySpecialBean.SpecialBean bean=discoverySpecialBean.new SpecialBean();
                mDataList.add(i,bean);
            }
        }
    }*/

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        Context context = parent.getContext();
        switch (viewType) {
            case BaseHomeBean.DISCOVERY_SPECIAL_DOUBLE_ROW_GOODS_TYPE:
                view = LayoutInflater.from(context).inflate(R.layout.view_discovery_special_goods, parent, false);
                return new DiscoverySpecialGoodsVH(view);
            case BaseHomeBean.SPECIAL_SECTION_TYPE:
                view = LayoutInflater.from(context).inflate(R.layout.view_discovery_special_title, parent, false);
                return new DiscoverySpecialSectionVH(view);
            case BaseHomeBean.HEAD_BANNER_TYPE_FIXED:
                view = LayoutInflater.from(context).inflate(R.layout.view_discovery_special_banner, parent, false);
                return new DiscoverySpecialBannerVH(view);
            default:
                view = LayoutInflater.from(context).inflate(R.layout.view_discovery_special_banner, parent, false);
                return new DiscoverySpecialBannerVH(view);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case BaseHomeBean.DISCOVERY_SPECIAL_DOUBLE_ROW_GOODS_TYPE:
                ((DiscoverySpecialGoodsVH) holder).bind((DiscoverySpecialBean.SpecialBean) mDataList.get(position));
                break;
            case BaseHomeBean.HEAD_BANNER_TYPE_FIXED:
                ((DiscoverySpecialBannerVH) holder).bind((DiscoverySpecialBean.SpecialBean) mDataList.get(position));
                break;
            case BaseHomeBean.SPECIAL_SECTION_TYPE:
                ((DiscoverySpecialSectionVH) holder).bind((DiscoverySpecialBean.SpecialBean) mDataList.get(position));
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

/*    @Override
    public boolean isFullSpan(int position) {
        int type = getItemViewType(position);
        if (type ==BaseHomeBean.DISCOVERY_SPECIAL_DOUBLE_ROW_GOODS_TYPE) {
            return false;
        } else {
            return true;
        }
    }*/
}
