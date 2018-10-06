package com.localworld.ishop.setting.viewholder;

import android.view.View;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.setting.bean.FollowFollowedUserBean;

public class FollowFollowedUserVH extends BaseViewHolder<FollowFollowedUserBean> {

    private ISImageView mFollowUserHeadPic;
    private TextView mFollowUserName;
    private TextView mFollowUserMotto;
    private TextView mFollowedBtn;
    public FollowFollowedUserVH(View itemView) {
        super(itemView);
        mFollowUserHeadPic = itemView.findViewById(R.id.iv_setting_follow_followuserheadpic);
        mFollowUserName = itemView.findViewById(R.id.tv_setting_follow_followusername);
        mFollowUserMotto = itemView.findViewById(R.id.tv_setting_follow_followusermotto);
        mFollowedBtn = itemView.findViewById(R.id.tv_setting_follow_followedbtn);
    }

    @Override
    public void bind(FollowFollowedUserBean bean) {
       /* mFollowUserHeadPic.showImage(bean.followUserHeadPic);
        mFollowUserName.setText(bean.followUserName);
        mFollowUserMotto.setText(bean.followUserMotto);*/
        mFollowUserHeadPic.showImage(bean.headPic);
        mFollowUserName.setText(bean.userName);
        mFollowUserMotto.setText(bean.targetType);
        mFollowedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
