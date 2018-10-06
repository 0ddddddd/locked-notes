package com.localworld.ishop.setting.viewholder;

import android.view.View;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.setting.bean.OpenAllFriendsBean;

public class OpenAllFriendsVH extends BaseViewHolder<OpenAllFriendsBean> {
    private ISImageView mHeadPic;
    private TextView mAccountName;
    private TextView mAccountID;
    private TextView mCall;

    public OpenAllFriendsVH(View itemView) {
        super(itemView);
        mHeadPic = itemView.findViewById(R.id.iv_setting_friends_headpic);
        mAccountName = itemView.findViewById(R.id.tv_setting_friends_name);
        mAccountID = itemView.findViewById(R.id.tv_setting_friends_id);
        mCall = itemView.findViewById(R.id.tv_setting_friends_call);
    }

    @Override
    public void bind(OpenAllFriendsBean bean) {
        mHeadPic.showImage(bean.friendsHeadPic);
        mAccountName.setText(bean.friendsAccountName);
        mAccountID.setText(bean.friendsAccountID);
        mCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
