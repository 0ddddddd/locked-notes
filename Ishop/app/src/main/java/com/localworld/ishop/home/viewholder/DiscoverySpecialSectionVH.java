package com.localworld.ishop.home.viewholder;

import android.view.View;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;


public class DiscoverySpecialSectionVH extends BaseViewHolder{
    private TextView specialtitle;


    public DiscoverySpecialSectionVH(View itemView) {
        super(itemView);
        specialtitle=itemView.findViewById(R.id.discovery_special_title);
    }

    @Override
    public void bind(Object bean) {
        specialtitle.setText("七夕节特辑");
    }
}