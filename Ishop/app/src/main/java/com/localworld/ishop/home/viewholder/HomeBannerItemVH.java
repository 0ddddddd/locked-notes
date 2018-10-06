package com.localworld.ishop.home.viewholder;

import android.view.View;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.home.bean.HomeBannersBean;

public class HomeBannerItemVH extends BaseViewHolder<HomeBannersBean.BannerBean> {
    private ISImageView mBannerIv;

    public HomeBannerItemVH(View itemView) {
        super(itemView);
       mBannerIv = itemView.findViewById(R.id.iv_home_banner_item);
    }

    @Override
    public void bind(HomeBannersBean.BannerBean bean) {
        mBannerIv.showImage(bean.picPath);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
