package com.localworld.ishop.setting.viewholder;

import android.view.View;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.setting.bean.TransitMessageBean;

public class TransitMessageVH extends BaseViewHolder<TransitMessageBean> {
    private TextView mTime;
    private TextView mMessage;
    public TransitMessageVH(View itemView) {
        super(itemView);
        mTime = itemView.findViewById(R.id.tv_setting_delivered_time);
        mMessage = itemView.findViewById(R.id.tv_setting_delivered_message);
    }

    @Override
    public void bind(TransitMessageBean bean) {
        mTime.setText(bean.time);
        mMessage.setText(bean.message);
    }
}
