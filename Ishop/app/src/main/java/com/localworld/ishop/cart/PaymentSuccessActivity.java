package com.localworld.ishop.cart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.cart.bean.PaymentCommendBean;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.home.HomeActivity;
import com.localworld.ishop.order.CheckOrder;


public class PaymentSuccessActivity extends AppCompatActivity implements View.OnClickListener{

    private PaymentCommendBean bean = new PaymentCommendBean();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_payment_success);
        initView();

    }

    private void initView() {
        ISImageView paymentImg1=findViewById(R.id.payment_img_1);
        ISImageView paymentImg2=findViewById(R.id.payment_img_2);
        ISImageView paymentImg3=findViewById(R.id.payment_img_3);
        ISImageView paymentImg4=findViewById(R.id.payment_img_4);

        paymentImg1.showImage(bean.paymentImg1);
        paymentImg2.showImage(bean.paymentImg2);
        paymentImg3.showImage(bean.paymentImg3);
        paymentImg4.showImage(bean.paymentImg4);

        TextView share = findViewById(R.id.tv_cart_payment_share);
        share.setOnClickListener(this);
        Button order_button=findViewById(R.id.btn_cart_payment_order_button);
        order_button.setOnClickListener(this);
        Button payment_return_home=findViewById(R.id.btn_cart_payment_return_home);
        payment_return_home.setOnClickListener(this);
        ImageView back=findViewById(R.id.iv_cart_payment_success_back);
        back.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.tv_cart_payment_share:
                //todo 分享给好友
                break;
            case R.id.iv_cart_payment_success_back:
                finish();
                break;
            case R.id.btn_cart_payment_order_button:
                //todo 查看订单跳转？？？
                Intent intent=new Intent(this, CheckOrder.class);
                startActivity(intent);
                break;
            case R.id.btn_cart_payment_return_home:
                Intent intent1=new Intent(this, HomeActivity.class);
                startActivity(intent1);
            default:
                break;
        }
    }

}
