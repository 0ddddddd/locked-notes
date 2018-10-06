package com.localworld.ishop.home.viewholder;

import android.view.View;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;


public class HomeRecommendSectionVH extends BaseViewHolder{

    private TextView mSeeAllBtn;

    public HomeRecommendSectionVH(View itemView) {
        super(itemView);

        mSeeAllBtn = itemView.findViewById(R.id.btn_home_recommend_section_see_all);
        mSeeAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void bind(Object bean) {

    }
}
