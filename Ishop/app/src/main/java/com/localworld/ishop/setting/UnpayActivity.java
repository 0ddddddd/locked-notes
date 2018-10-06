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
import com.localworld.ishop.setting.adapter.UnpayAdapter;
import com.localworld.ishop.setting.bean.UnpayGoodsBean;

import java.util.List;

public class UnpayActivity extends AppCompatActivity {

    private UnpayAdapter adapter;
    private ImageView mBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_unpay);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.recycler_setting_unpay);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new UnpayAdapter();
        recyclerView.setAdapter(adapter);
        loadData();

        mBack = findViewById(R.id.iv_setting_unpaybacktomian);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void loadData(){
        List<UnpayGoodsBean> dataList = NewPayMockUtils.getUnpayList();
        adapter.setUnpayGoodsBeanList(dataList);
        adapter.notifyDataSetChanged();
    }
}
