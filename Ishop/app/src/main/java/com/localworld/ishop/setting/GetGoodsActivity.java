package com.localworld.ishop.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.adapter.GetGoodsAdapter;
import com.localworld.ishop.setting.bean.GetGoodsBean;

import java.util.ArrayList;
import java.util.List;

public class GetGoodsActivity extends AppCompatActivity{
    private List<GetGoodsBean> list = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_getgoods);
        list = NewDeliveredMockUtils.getGetGoodsList();
        RecyclerView recyclerView = findViewById(R.id.recycler_setting_getgoods);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        GetGoodsAdapter adapter = new GetGoodsAdapter(list);
        recyclerView.setAdapter(adapter);
        initNav();
    }

    private void initNav() {
        ImageView back = findViewById(R.id.iv_setting_getgoodsbacktomian);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
