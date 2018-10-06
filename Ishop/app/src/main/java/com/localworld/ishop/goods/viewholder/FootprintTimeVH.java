package com.localworld.ishop.goods.viewholder;

import android.view.View;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.goods.bean.FootprintTimeBean;

public class FootprintTimeVH extends BaseViewHolder<FootprintTimeBean> {
    private TextView tv_time;

    public FootprintTimeVH(View view){
        super(view);
        tv_time=view.findViewById(R.id.tv_footprint_time);
    }

    @Override
    public void bind(FootprintTimeBean bean){
        tv_time.setText(bean.time);
    }

}
