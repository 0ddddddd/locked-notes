package com.localworld.ishop.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.adapter.AddAccountAdapter;
import com.localworld.ishop.setting.bean.AddAccountBean;

import java.util.List;

public class AddAccountActivity extends AppCompatActivity {
    private AddAccountAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayout mAddAccount;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_setting_addaccount);
        recyclerView = findViewById(R.id.recycler_setting_addaccount);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AddAccountAdapter();
        recyclerView.setAdapter(adapter);
        initNav();
        initView();
        loadDatd();
    }

    private void initView() {
        mAddAccount = findViewById(R.id.layout_setting_setting_addaccount);
        mAddAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddAccountActivity.this, "添加成功！", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initNav() {
        ImageView mBack = findViewById(R.id.iv_setting_addacccountbacktomian);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void loadDatd() {
        List<AddAccountBean> accountBeanList = NewAddAccountMockUtils.getAccountBeanList();
        adapter.setAccountBeanList(accountBeanList);
        adapter.notifyDataSetChanged();
    }
}
