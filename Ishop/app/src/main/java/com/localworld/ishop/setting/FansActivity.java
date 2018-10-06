package com.localworld.ishop.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.adapter.FansAdapter;
import com.localworld.ishop.setting.bean.FansBean;

import java.util.ArrayList;
import java.util.List;


public class FansActivity extends AppCompatActivity{
    private FansAdapter adapter;
    private RecyclerView recyclerView;
    private List<FansBean> fansList = new ArrayList<>();
    private FansBean bean;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_myhomepage_fans);
        loadData();
        recyclerView = findViewById(R.id.recycler_setting_myhomepage_fans);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FansAdapter(fansList);
        recyclerView.setAdapter(adapter);

        ImageView mBack = findViewById(R.id.iv_setting_myhomepage_fans_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void loadData() {
        for(int i =0;i<10;i++){
            bean = new FansBean();
            bean.fansName = "陈翔大佬";
            bean.fansId = "666";
            bean.fansPic = "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1306/03/c0/21608858_1370244891829.jpg";
            fansList.add(bean);
        }
    }
}
