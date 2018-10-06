package com.localworld.ishop.cart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.localworld.ishop.R;
import com.localworld.ishop.cart.bean.PaymentCommendBean;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.home.HomeActivity;


public class PaymentFailActivity extends AppCompatActivity implements View.OnClickListener{
    private PaymentCommendBean bean = new PaymentCommendBean();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_payment_fail);
        initView();

    }

    private void initView() {
        ISImageView paymentImg1=findViewById(R.id.payment_fail_img_1);
        ISImageView paymentImg2=findViewById(R.id.payment_fail_img_2);
        ISImageView paymentImg3=findViewById(R.id.payment_fail_img_3);
        ISImageView paymentImg4=findViewById(R.id.payment_fail_img_4);

        paymentImg1.showImage(bean.paymentImg1);
        paymentImg2.showImage(bean.paymentImg2);
        paymentImg3.showImage(bean.paymentImg3);
        paymentImg4.showImage(bean.paymentImg4);

        ImageView back = findViewById(R.id.iv_cart_payment_fail_back);
        back.setOnClickListener(this);
        Button paymentAgain = findViewById(R.id.btn_cart_payment_fail_again);
        paymentAgain.setOnClickListener(this);
        Button paymentReturnHome = findViewById(R.id.tv_cart_payment_fail_return_home);
        paymentReturnHome.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.iv_cart_payment_fail_back:
                finish();
                break;
            case R.id.btn_cart_payment_fail_again:
//                Intent intent=new Intent(this, ShopFragment.class);
//                startActivity(intent);
                break;
            case R.id.tv_cart_payment_fail_return_home:
                Intent intent1=new Intent(this, HomeActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}
