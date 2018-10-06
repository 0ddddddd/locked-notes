package com.localworld.ishop.setting.viewholder;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.manager.account.LoginManager;
import com.localworld.ishop.setting.AccountSecretActivity;
import com.localworld.ishop.setting.AddAccountActivity;
import com.localworld.ishop.setting.AdviceActivity;
import com.localworld.ishop.setting.BlackListActivity;
import com.localworld.ishop.setting.ChangePasswordActivity;
import com.localworld.ishop.setting.MessageActivity;
import com.localworld.ishop.setting.MyFavoriteActivity;
import com.localworld.ishop.setting.PaySettingActivity;
import com.localworld.ishop.setting.ProvisionActivity;


public class SettingBtnVH extends BaseViewHolder<String> {
    private LinearLayout mItemName;
    private TextView mShowItemName;

    public SettingBtnVH(View itemView) {
        super(itemView);
        mItemName = itemView.findViewById(R.id.layout_setting_setting_itemname);
        mShowItemName = itemView.findViewById(R.id.tv_setting_setting_itemname);
    }

    @Override
    public void bind(String settingBtn) {
        switch (settingBtn.toString()) {
            case "添加账户":
                mShowItemName.setText("添加账户");
                mItemName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), AddAccountActivity.class);
                        view.getContext().startActivity(intent);
                    }
                });
                break;
            case "更改密码":
                mShowItemName.setText("更改密码");
                mItemName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), ChangePasswordActivity.class);
                        view.getContext().startActivity(intent);
                    }
                });
                break;
            case "支付设置":
                mShowItemName.setText("支付设置");
                mItemName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), PaySettingActivity.class);
                        view.getContext().startActivity(intent);
                    }
                });
                break;
            case "赞过的内容":
                mShowItemName.setText("赞过的内容");
                mItemName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), MyFavoriteActivity.class);
                        view.getContext().startActivity(intent);
                    }
                });
                break;
            case "搜索记录":
                mShowItemName.setText("搜索记录");
                mItemName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                break;
            case "账户隐私":
                mShowItemName.setText("账户隐私");
                mItemName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), AccountSecretActivity.class);
                        view.getContext().startActivity(intent);
                    }
                });
                break;
            case "黑名单":
                mShowItemName.setText("黑名单");
                mItemName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), BlackListActivity.class);
                        view.getContext().startActivity(intent);
                    }
                });
                break;
            case "通知":
                mShowItemName.setText("通知");
                mItemName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), MessageActivity.class);
                        view.getContext().startActivity(intent);
                    }
                });
                break;
            case "意见":
                mShowItemName.setText("意见");
                mItemName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), AdviceActivity.class);
                        view.getContext().startActivity(intent);
                    }
                });
                break;
            case "条款":
                mShowItemName.setText("条款");
                mItemName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //todo 条款页面跳转报错
                        Intent intent = new Intent(view.getContext(), ProvisionActivity.class);
                        view.getContext().startActivity(intent);
                    }
                });
                break;
            case "开源库":
                mShowItemName.setText("开源库");
                mItemName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //todo 开源库跳转
                    }
                });
                break;
            case "退出":
                mShowItemName.setText("退出");
                mItemName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LoginManager.getInstance().logout();
                        ((Activity) view.getContext()).finish();
                    }
                });

                break;
            default:
                break;
        }
    }
}
