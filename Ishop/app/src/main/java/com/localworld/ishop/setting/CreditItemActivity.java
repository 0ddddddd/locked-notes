package com.localworld.ishop.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.util.SharedPreferencesUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CreditItemActivity extends AppCompatActivity implements View.OnClickListener {
    private List<SharedPreferencesUtil> utilList = new ArrayList<>();
    private SharedPreferencesUtil sharedPreferencesUtil;
    private ImageView mOrder;
    private boolean order = true;
    private ImageView mTransit;
    private boolean transit = true;
    private ImageView mDiscount;
    private boolean discount = true;
    private ImageView mFriends;
    private boolean friends = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_credit);
        initView();
    }

    private void initView() {
        TextView mCancle = findViewById(R.id.tv_setting_credit_back);
        mCancle.setOnClickListener(this);
        TextView mFinish = findViewById(R.id.tv_setting_credit_finish);
        mFinish.setOnClickListener(this);
        mOrder = findViewById(R.id.iv_setting_credititem_order);
        mOrder.setOnClickListener(this);
        mTransit = findViewById(R.id.iv_setting_credititem_transit);
        mTransit.setOnClickListener(this);
        mDiscount = findViewById(R.id.iv_setting_credititem_discount);
        mDiscount.setOnClickListener(this);
        mFriends = findViewById(R.id.iv_setting_credititem_friends);
        mFriends.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.tv_setting_credit_back:
                finish();
                break;
            case R.id.tv_setting_credit_finish:
                //数据是使用Intent返回
                Intent intent = new Intent();
                //把返回数据存入Intent
                intent.putExtra("sharedList", (Serializable) utilList);
                //设置返回数据
                CreditItemActivity.this.setResult(RESULT_OK, intent);
                //关闭Activity
                finish();
                break;
            case R.id.iv_setting_credititem_order:
                sharedPreferencesUtil = new SharedPreferencesUtil();
                if(order){
                    mOrder.setBackgroundResource(R.drawable.ipole_icon_31);
                    SharedPreferencesUtil.putBoolean(CreditItemActivity.this,"setting","order",false);
                    utilList.add(sharedPreferencesUtil);
                    order = false;
                }else {
                    mOrder.setBackgroundResource(R.drawable.ipole_icon_21);
                    sharedPreferencesUtil.putBoolean(CreditItemActivity.this,"setting","order",true);
                    utilList.add(sharedPreferencesUtil);
                    order = true;
                }
                break;
            case R.id.iv_setting_credititem_transit:
                sharedPreferencesUtil = new SharedPreferencesUtil();
                if(transit){
                    mTransit.setBackgroundResource(R.drawable.ipole_icon_31);
                    sharedPreferencesUtil.putBoolean(CreditItemActivity.this,"setting","transit",false);
                    utilList.add(sharedPreferencesUtil);
                    transit = false;
                }else {
                    mTransit.setBackgroundResource(R.drawable.ipole_icon_21);
                    sharedPreferencesUtil.putBoolean(CreditItemActivity.this,"setting","transit",true);
                    utilList.add(sharedPreferencesUtil);
                    transit = true;
                }
                break;
            case R.id.iv_setting_credititem_discount:
                sharedPreferencesUtil = new SharedPreferencesUtil();
                if(discount){
                    mDiscount.setBackgroundResource(R.drawable.ipole_icon_31);
                    sharedPreferencesUtil.putBoolean(CreditItemActivity.this,"setting","discount",false);
                    utilList.add(sharedPreferencesUtil);
                    discount = false;
                }else {
                    mDiscount.setBackgroundResource(R.drawable.ipole_icon_21);
                    sharedPreferencesUtil.putBoolean(CreditItemActivity.this,"setting","discount",true);
                    utilList.add(sharedPreferencesUtil);
                    discount = true;
                }
                break;
            case R.id.iv_setting_credititem_friends:
                sharedPreferencesUtil = new SharedPreferencesUtil();
                if(friends){
                    mFriends.setBackgroundResource(R.drawable.ipole_icon_31);
                    sharedPreferencesUtil.putBoolean(CreditItemActivity.this,"setting","friends",false);
                    utilList.add(sharedPreferencesUtil);
                    friends = false;
                }else {
                    mFriends.setBackgroundResource(R.drawable.ipole_icon_21);
                    sharedPreferencesUtil.putBoolean(CreditItemActivity.this,"setting","friends",true);
                    utilList.add(sharedPreferencesUtil);
                    friends = true;
                }
                break;
        }
    }

}
