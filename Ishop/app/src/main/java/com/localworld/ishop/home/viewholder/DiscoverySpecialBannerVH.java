package com.localworld.ishop.home.viewholder;

import android.view.View;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.home.bean.DiscoverySpecialBean;

public class DiscoverySpecialBannerVH extends BaseViewHolder<DiscoverySpecialBean.SpecialBean>{
    private TextView specialnametv;
    private ISImageView specialpiciv;

    public DiscoverySpecialBannerVH(View view){
        super(view);
        specialnametv=view.findViewById(R.id.tv_discovery_special_banner);
        specialpiciv=view.findViewById(R.id.iv_discovery_special_banner);
    }

    @Override
    public void bind(DiscoverySpecialBean.SpecialBean bean) {
        specialnametv.setText("七夕节特辑");
        specialpiciv.showImage(bean.imgUrl);
    }

}
