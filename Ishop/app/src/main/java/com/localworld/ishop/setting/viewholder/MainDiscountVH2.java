package com.localworld.ishop.setting.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.setting.bean.MainDiscountBean;

public class MainDiscountVH2 extends BaseViewHolder<MainDiscountBean> {

    private TextView mDiscount;
    private ISImageView mDiscountImg;
    private TextView mShopName;
    private Button mDiscountUse;
    public MainDiscountVH2(View itemView) {
        super(itemView);
        mShopName =(TextView)itemView.findViewById(R.id.tv_setting_shopname);
        mDiscountImg = (ISImageView)itemView.findViewById(R.id.iv_setting_discountimg);
        mDiscount = itemView.findViewById(R.id.tv_setting_discount);
        mDiscountUse = (Button)itemView.findViewById(R.id.btn_setting_discountuse);
    }

    @Override
    public void bind(MainDiscountBean bean) {

        mShopName.setText(bean.shopName);

        mDiscountImg.showImage(bean.discountImg);

        mDiscount.setText(bean.discount);

        mDiscountUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"使用成功",Toast.LENGTH_LONG);
            }
        });
    }
}
