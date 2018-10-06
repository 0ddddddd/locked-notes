package com.localworld.ishop.home.discovery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.igerm.android.lib.net.core.HdlCore;
import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.home.adapter.IFullSpanPosition;
import com.localworld.ishop.home.bean.BaseHomeBean;
import com.localworld.ishop.home.bean.DiscoveryPopularityBean;
import com.localworld.ishop.home.viewholder.DiscoveryPopularityAuthorVH;

import java.util.ArrayList;
import java.util.List;


public class DiscoveryPopularityAdapter extends RecyclerView.Adapter<BaseViewHolder> implements IFullSpanPosition {

    private List<BaseHomeBean> mDataList = new ArrayList<>();
    private ISNetService service = HdlCore.getInstance().getService(ISNetService.class);

    public DiscoveryPopularityAdapter() {

    }

    public void setDataList(List<DiscoveryPopularityBean.PopularityBean> bean) {
        mDataList.clear();
        mDataList.addAll(bean);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        Context context = parent.getContext();
        switch (viewType) {
            case BaseHomeBean.DISCOVERY_POPULARITY_TYPE:
                view= LayoutInflater.from(context).inflate(R.layout.view_discovery_popularity,parent,false);
                return new DiscoveryPopularityAuthorVH(view);
            default:
                view = LayoutInflater.from(context).inflate(R.layout.view_discovery_popularity, parent, false);
                return new DiscoveryPopularityAuthorVH(view);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case BaseHomeBean.DISCOVERY_POPULARITY_TYPE:
                ((DiscoveryPopularityAuthorVH)holder).bind((DiscoveryPopularityBean.PopularityBean)mDataList.get(position));
                break;
            default:
                ((DiscoveryPopularityAuthorVH)holder).bind((DiscoveryPopularityBean.PopularityBean)mDataList.get(position));
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

    @Override
    public boolean isFullSpan(int position) {
        int type = getItemViewType(position);
        if (type == BaseHomeBean.DISCOVERY_SPECIAL_DOUBLE_ROW_GOODS_TYPE){
            return false;
        } else {
            return true;
        }
    }

}

