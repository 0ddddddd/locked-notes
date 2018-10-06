package com.localworld.ishop.setting.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.setting.bean.SettingBtnBean;
import com.localworld.ishop.setting.viewholder.SettingBtnVH;

public class SettingBtnAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private SettingBtnBean settingBtn;

    public void setBean(SettingBtnBean bean) {
        this.settingBtn = bean;
        initSettingBtn();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_setting,parent,false);
        return new SettingBtnVH(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        ((SettingBtnVH) holder).bind((String) settingBtn.settingBtn[position]);
    }

    @Override
    public int getItemCount() {
        return settingBtn.settingBtn.length;
    }

    public void initSettingBtn(){
        settingBtn.settingBtn = new String[]{/*"添加账户","账户隐私","黑名单",*/"更改密码","支付设置","赞过的内容","搜索记录","通知","意见","条款","开源库","退出"};
    }
}
