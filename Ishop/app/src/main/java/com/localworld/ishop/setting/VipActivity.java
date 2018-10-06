package com.localworld.ishop.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.bean.VipBean;

import java.text.SimpleDateFormat;
import java.util.Date;


public class VipActivity extends AppCompatActivity{
    private VipBean bean;
    private LinearLayout vipCard;
    private LinearLayout noVipCard;
    private TextView points;
    private TextView year;
    private TextView month;
    private TextView day;
    private TextView vipName;
    private TextView becomeVip;
    private TextView becameVip;
    private ImageView mBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_ppoint_vip);
        initData();
        initView();

    }

    private void initView() {
        vipCard = findViewById(R.id.layout_setting_vipcard);
        noVipCard = findViewById(R.id.layout_setting_novipcard);
        points = findViewById(R.id.tv_setting_ppoint_point);
        year = findViewById(R.id.tv_setting_ppoint_year);
        month = findViewById(R.id.tv_setting_ppoint_month);
        day = findViewById(R.id.tv_setting_ppoint_day);
        vipName = findViewById(R.id.tv_setting_ppoint_vipname);
        becomeVip = findViewById(R.id.tv_setting_ppoint_becomevip);
        becameVip = findViewById(R.id.tv_setting_ppoint_becamevip);
        mBack = findViewById(R.id.iv_setting_vipbacktomian);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bean = new VipBean();
        //todo 是否为会员的判断条件 变更
        if(bean.vipName!=null){
            vipCard.setVisibility(View.VISIBLE);
            becameVip.setVisibility(View.VISIBLE);
            noVipCard.setVisibility(View.GONE);
            becomeVip.setVisibility(View.GONE);
            points.setText(bean.points);
            year.setText(bean.date);
            /*year.setText(bean.year);
            month.setText(bean.month);
            day.setText(bean.day);*/
            vipName.setText(bean.vipName);
        }else{
            vipCard.setVisibility(View.GONE);
            becameVip.setVisibility(View.GONE);
            noVipCard.setVisibility(View.VISIBLE);
            becomeVip.setVisibility(View.VISIBLE);
            points.setText(bean.points);
            becomeVip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),"你已成为会员！",Toast.LENGTH_LONG);
                    vipCard.setVisibility(View.VISIBLE);
                    becameVip.setVisibility(View.VISIBLE);
                    noVipCard.setVisibility(View.GONE);
                    becomeVip.setVisibility(View.GONE);
                    points.setText(bean.points);
                   /* year.setText(bean.year);
                    month.setText(Calendar.getInstance().get(Calendar.MONTH));
                    day.setText(Calendar.getInstance().get(Calendar.DATE));*/
                    //获取个人主页的昵称
                    Intent intent = getIntent();
                    String name = intent.getStringExtra("vipName");
                    vipName.setText(name);
                }
            });
        }
    }
    private void initData(){
        VipBean bean = new VipBean();
        bean.vipName = "nihao";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        bean.date = sdf.format(date);
    }
}
