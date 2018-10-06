package com.localworld.ishop.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.adapter.SettingBtnAdapter;
import com.localworld.ishop.setting.bean.SettingBtnBean;

public class SettingBtnActivity extends AppCompatActivity {
    private SettingBtnAdapter adapter;
    private ImageView mSetBackToMain;
    private SettingBtnBean setBean;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_setting);

        RecyclerView recyclerView = findViewById(R.id.recycler_setting_setting);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new SettingBtnAdapter();
        recyclerView.setAdapter(adapter);
        setBean = new SettingBtnBean();
        adapter.setBean(setBean);
        adapter.notifyDataSetChanged();
        initTop();
    }

    private void initTop(){
        mSetBackToMain = findViewById(R.id.iv_setting_setbacktomian);
        mSetBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
