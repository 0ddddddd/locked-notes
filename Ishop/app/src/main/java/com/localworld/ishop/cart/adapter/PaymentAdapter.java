package com.localworld.ishop.cart.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.cart.bean.PaymentItemBean;
import com.localworld.ishop.common.image.ISImageView;

import java.util.ArrayList;
import java.util.List;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.ViewHolder> {

    private List<PaymentItemBean> paymentItemBeanList = new ArrayList<>();

    public PaymentAdapter(List<PaymentItemBean> paymentItemBeanList) {
        this.paymentItemBeanList = paymentItemBeanList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView shopName;
        ISImageView goodImg;
        TextView goodName;
        TextView goodInfo;
        TextView goodNum;
        TextView goodPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            shopName = itemView.findViewById(R.id.tv_cart_payment_shopname);
            goodImg = itemView.findViewById(R.id.iv_cart_payment_goodImg);
            goodName = itemView.findViewById(R.id.tv_cart_payment_goodname);
            goodInfo = itemView.findViewById(R.id.tv_cart_payment_goodinfo);
            goodNum = itemView.findViewById(R.id.tv_cart_payment_goodnum);
            goodPrice = itemView.findViewById(R.id.tv_cart_payment_goodprice);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart_payment,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PaymentItemBean bean = new PaymentItemBean();
        holder.shopName.setText(bean.shopName);
        holder.goodImg.showImage(bean.goodImg);
        holder.goodName.setText(bean.goodName);
        holder.goodInfo.setText(bean.goodInfo);
        holder.goodNum.setText(bean.goodNum);
        holder.goodPrice.setText(bean.goodPrice);
    }

    @Override
    public int getItemCount() {
        return paymentItemBeanList.size();
    }


}
