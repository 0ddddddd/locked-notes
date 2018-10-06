package com.localworld.ishop.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.adapter.DeliveredAdapter;
import com.localworld.ishop.setting.bean.DeliveredBean;

import java.util.ArrayList;
import java.util.List;

public class DeliveredActivity extends AppCompatActivity {
    private List<DeliveredBean> list = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_delivered);
        list = NewDeliveredMockUtils.getDeliveredList();
        RecyclerView recyclerView = findViewById(R.id.recycler_setting_delivered);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DeliveredAdapter adapter = new DeliveredAdapter(list);
        recyclerView.setAdapter(adapter);
        initNav();
    }

    private void initNav() {
        ImageView back = findViewById(R.id.iv_setting_delivered_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
