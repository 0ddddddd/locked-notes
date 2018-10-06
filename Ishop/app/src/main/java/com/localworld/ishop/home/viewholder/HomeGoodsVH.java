package com.localworld.ishop.home.viewholder;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.igerm.android.lib.net.core.HdlCore;
import com.localworld.ishop.R;
import com.localworld.ishop.common.BaseViewHolder;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.goods.FootPrintActivity;
import com.localworld.ishop.goods.MyCollectionActivity;
import com.localworld.ishop.home.bean.HomeGoodsBean;
import com.localworld.ishop.newgoods.NewGoodsActivity;


public class HomeGoodsVH extends BaseViewHolder<HomeGoodsBean> implements View.OnClickListener{

    private ISImageView itemImageView;
    private TextView itemNameTv;
    private TextView itemPriceTv;
    private ImageView itemAuthorheadIV;
    private TextView itemAuthorname;
    private TextView itemMutualfriends;
    private CardView GoodsCv;
    private ISNetService service = HdlCore.getInstance().getService(ISNetService.class);

    public HomeGoodsVH(View itemView) {
        super(itemView);

        itemImageView = itemView.findViewById(R.id.iv_view_home_goods_item);
        //itemNameTv = itemView.findViewById(R.id.tv_view_home_name);
        itemAuthorheadIV=itemView.findViewById(R.id.iv_view_home_authorhead);
        itemAuthorname=itemView.findViewById(R.id.tv_view_home_name);
        itemMutualfriends=itemView.findViewById(R.id.tv_view_home_mutualfriends);
        GoodsCv=itemView.findViewById(R.id.cv_view_home_goods_item);
       // itemPriceTv = itemView.findViewById(R.id.tv_home_main_item_price);
    }

    @Override
    public void bind(HomeGoodsBean bean) {
        itemImageView.showImage(bean.contentPic);
       // itemNameTv.setText(bean.title);
        itemAuthorname.setText(bean.authorname);
        itemMutualfriends.setText(bean.mutualfriends);
        itemImageView.setOnClickListener(this);
        itemAuthorheadIV.setOnClickListener(this);
//        itemPriceTv.setText(String.format("￥ %s", bean.price));

        itemImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), NewGoodsActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.iv_view_home_goods_item:
                Intent intent1=new Intent(v.getContext(),MyCollectionActivity.class);
                v.getContext().startActivity(intent1);
                break;
            case R.id.iv_view_home_authorhead:
                Intent intent2=new Intent(v.getContext(),FootPrintActivity.class);
                v.getContext().startActivity(intent2);
                break;
        }
    }


}
