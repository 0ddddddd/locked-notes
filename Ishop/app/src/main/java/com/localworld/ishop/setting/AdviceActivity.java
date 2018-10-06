package com.localworld.ishop.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.localworld.ishop.R;

public class AdviceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_setting_advice);
        initNav();
        initView();
    }

    private void initView() {
        final LinearLayout checkProblem = findViewById(R.id.layout_setting_setting_advice_checkproblem);
        final LinearLayout problem = findViewById(R.id.layout_setting_setting_advice_problem);
        final LinearLayout otherProblem = findViewById(R.id.layout_setting_setting_advice_otherproblem);
        final TextView aboutBuy = findViewById(R.id.tv_setting_setting_advice_aboutbuy);
        final TextView aboutPay = findViewById(R.id.tv_setting_setting_advice_aboutpay);
        final TextView aboutGoods = findViewById(R.id.tv_setting_setting_advice_aboutgoods);
        final TextView aboutOrder = findViewById(R.id.tv_setting_setting_advice_aboutorder);
        final TextView noGoods = findViewById(R.id.tv_setting_setting_advice_nogoods);

        otherProblem.setVisibility(View.GONE);

        problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problem.setBackgroundResource(0);
                checkProblem.setBackgroundResource(R.drawable.payment_button_shape);
                otherProblem.setVisibility(View.VISIBLE);
            }
        });
        aboutBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otherProblem.setVisibility(View.GONE);
            }
        });
        aboutPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String index = aboutBuy.getText().toString();
                aboutBuy.setText(aboutPay.getText());
                aboutPay.setText(index);
                otherProblem.setVisibility(View.GONE);
            }
        });
        aboutGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String index = aboutBuy.getText().toString();
                aboutBuy.setText(aboutGoods.getText());
                aboutGoods.setText(index);
                otherProblem.setVisibility(View.GONE);
            }
        });
        aboutOrder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String index = aboutBuy.getText().toString();
                aboutBuy.setText(aboutOrder.getText());
                aboutOrder.setText(index);
                otherProblem.setVisibility(View.GONE);
            }
        });
        noGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String index = aboutBuy.getText().toString();
                aboutBuy.setText(noGoods.getText());
                noGoods.setText(index);
                otherProblem.setVisibility(View.GONE);
            }
        });
    }

    private void initNav() {
        ImageView mBack = findViewById(R.id.iv_setting_advicebacktomian);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
