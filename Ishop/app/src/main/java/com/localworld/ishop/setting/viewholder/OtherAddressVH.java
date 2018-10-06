package com.localworld.ishop.setting.viewholder;

import android.view.View;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.setting.bean.OtherAddressBean;

public class OtherAddressVH extends BaseViewHolder<OtherAddressBean> {

    private TextView mOtherNickName;
    private TextView mOtherPhoneNum;
    private TextView mOtherAddress;

    public OtherAddressVH(View itemView) {
        super(itemView);
        mOtherNickName = itemView.findViewById(R.id.tv_setting_othernickname);
        mOtherPhoneNum = itemView.findViewById(R.id.tv_setting_otherphonenumber);
        mOtherAddress = itemView.findViewById(R.id.tv_setting_otheraddress);
    }

    @Override
    public void bind(OtherAddressBean bean) {
        mOtherNickName.setText(bean.receiver);
        mOtherPhoneNum.setText(bean.mobile);
        mOtherAddress.setText(bean.address);
    }
}
