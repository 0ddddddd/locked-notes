package com.localworld.ishop.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.adapter.NewPayMockUtils;
import com.localworld.ishop.setting.adapter.PaidAdapter;
import com.localworld.ishop.setting.bean.PaidGoodsBean;

import java.util.List;

public class PaidActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PaidAdapter adapter;
    private ImageView mBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_paid);
        recyclerView = findViewById(R.id.recycler_setting_paid);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PaidAdapter();
        recyclerView.setAdapter(adapter);
        loadData();

        mBack = findViewById(R.id.iv_setting_paidbacktomian);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void loadData() {
        List<PaidGoodsBean> dataList = NewPayMockUtils.getPaidList();
        adapter.setBeanList(dataList);
        adapter.notifyDataSetChanged();
    }
}
