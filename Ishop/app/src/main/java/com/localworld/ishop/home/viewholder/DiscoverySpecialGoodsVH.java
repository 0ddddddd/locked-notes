package com.localworld.ishop.home.viewholder;

import android.view.View;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.home.bean.DiscoverySpecialBean;

public class DiscoverySpecialGoodsVH extends BaseViewHolder<DiscoverySpecialBean.SpecialBean> {
    private ISImageView itemcontentIV;

    public DiscoverySpecialGoodsVH(View itemview){
        super(itemview);
        itemcontentIV=itemview.findViewById(R.id.iv_special_content);
    }

    @Override
    public void bind(DiscoverySpecialBean.SpecialBean bean){
        itemcontentIV.showImage(bean.imgUrl);
    }
}
