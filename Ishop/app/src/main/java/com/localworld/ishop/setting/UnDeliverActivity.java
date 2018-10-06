package com.localworld.ishop.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.adapter.UnDeliverAdapter;
import com.localworld.ishop.setting.bean.UnDeliverBean;

import java.util.ArrayList;
import java.util.List;

public class UnDeliverActivity extends AppCompatActivity{
    private UnDeliverAdapter adapter;
    private List<UnDeliverBean> list = new ArrayList<>();
    private ImageView mBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_undeliver);

        list = NewDeliveredMockUtils.getUnDeliverBeanList();

        RecyclerView recyclerView = findViewById(R.id.recycler_setting_undeliver);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new UnDeliverAdapter(list);
        recyclerView.setAdapter(adapter);
        initNav();

        mBack = findViewById(R.id.iv_setting_undeliverbacktomian);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initNav() {
        ImageView back = findViewById(R.id.iv_setting_undeliverbacktomian);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
