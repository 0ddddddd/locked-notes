package com.localworld.ishop.goods.viewholder;

import android.view.View;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.goods.bean.FootprintBean;

public class FootprintVH extends BaseViewHolder<FootprintBean> {
    private ISImageView iv_content;

    public FootprintVH(View view){
        super(view);
        iv_content=view.findViewById(R.id.iv_footprint_item);
    }

    @Override
    public void bind(FootprintBean bean){
        iv_content.showImage(bean.picPath);
    }

}
