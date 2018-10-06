package com.localworld.ishop.setting.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.setting.bean.OtherAddressBean;
import com.localworld.ishop.setting.viewholder.OtherAddressVH;

import java.util.ArrayList;
import java.util.List;

public class OtherAddressAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<OtherAddressBean> mOtherAddressBeanList = new ArrayList<>();

    public OtherAddressAdapter() {
    }

    public void setmOtherAddressBeanList(List<OtherAddressBean> list) {
        mOtherAddressBeanList.clear();
        mOtherAddressBeanList.addAll(list);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_otheraddress,parent,false);
        return new OtherAddressVH(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        ((OtherAddressVH) holder).bind((OtherAddressBean) mOtherAddressBeanList.get(position));
    }

    @Override
    public int getItemCount() {
        return mOtherAddressBeanList.size();
    }
}
