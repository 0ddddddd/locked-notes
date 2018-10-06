package com.localworld.ishop.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.adapter.OpenAllFriendsAdapter;
import com.localworld.ishop.setting.bean.OpenAllFriendsBean;

import java.util.List;

public class OpenAllFriendsActivity extends AppCompatActivity {
    private OpenAllFriendsAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_friends_openall);
        RecyclerView recyclerView = findViewById(R.id.recycler_setting_friends_openall);
        adapter = new OpenAllFriendsAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        initNav();
        loadData();
    }

    private void initNav() {
        ImageView mBack = findViewById(R.id.iv_setting_openfriendsbacktomian);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void loadData() {
        List<OpenAllFriendsBean> openAllFriendsBeanList = NewAddAccountMockUtils.getFriendsBeansList();
        adapter.setOpenAllFriendsBeanList(openAllFriendsBeanList);
        adapter.notifyDataSetChanged();
    }
}
