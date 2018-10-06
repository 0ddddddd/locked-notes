package com.localworld.ishop.setting.viewholder;

import android.view.View;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.setting.bean.AddAccountBean;

public class AddAccountVH extends BaseViewHolder<AddAccountBean> {
    private ISImageView mHeadPic;
    private TextView mAccountName;
    private TextView mAccountID;

    public AddAccountVH(View itemView) {
        super(itemView);
        mHeadPic = itemView.findViewById(R.id.iv_setting_setting_addaccount_headpic);
        mAccountName = itemView.findViewById(R.id.tv_setting_setting_addaccount_name);
        mAccountID = itemView.findViewById(R.id.tv_setting_setting_addacount_id);
    }

    @Override
    public void bind(AddAccountBean bean) {
        mHeadPic.showImage(bean.headPic);
        mAccountName.setText(bean.AccountName);
        mAccountID.setText(bean.AccountID);

    }
}
