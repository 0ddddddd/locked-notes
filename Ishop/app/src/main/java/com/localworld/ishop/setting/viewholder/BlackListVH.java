package com.localworld.ishop.setting.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.setting.bean.BlackListBean;

public class BlackListVH extends BaseViewHolder<BlackListBean>{

    private ISImageView mHeadPic;
    private TextView mAccountName;
    private TextView mAccountID;
    private ImageView mRemove;
    private LinearLayout mBlackList;

    public BlackListVH(View itemView) {
        super(itemView);
        mHeadPic = itemView.findViewById(R.id.iv_setting_setting_blacklist_headpic);
        mAccountName = itemView.findViewById(R.id.tv_setting_setting_blacklist_name);
        mAccountID = itemView.findViewById(R.id.tv_setting_setting_blacklist_id);
        mRemove = itemView.findViewById(R.id.iv_setting_setting_blacklist_remove);
        mBlackList = itemView.findViewById(R.id.layout_setting_setting_blacklist);
    }

    @Override
    public void bind(BlackListBean bean) {
        mHeadPic.showImage(bean.blackListHeadPic);
        mAccountName.setText(bean.blackListAccountName);
        mAccountID.setText(bean.blackListAccountID);
        mRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBlackList.setVisibility(View.GONE);
            }
        });
    }
}
