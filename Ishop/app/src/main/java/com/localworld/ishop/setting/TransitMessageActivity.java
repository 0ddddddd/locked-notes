package com.localworld.ishop.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.image.ISImageView;
import com.localworld.ishop.setting.adapter.TransitMessageAdapter;
import com.localworld.ishop.setting.bean.TransitMessageBean;

import java.util.List;

public class TransitMessageActivity extends AppCompatActivity {
    private TransitMessageAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_delivered_transitmessage);
        RecyclerView recyclerView = findViewById(R.id.recycler_setting_delivered_transitmessage);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TransitMessageAdapter();
        recyclerView.setAdapter(adapter);
        initNav();
        initView();
        loadData();
    }

    private void initView() {
        ISImageView mGoodPic = findViewById(R.id.iv_setting_delivered_transitmessage_goodpic);
        TextView mStartPlace = findViewById(R.id.tv_setting_delivered_startplace);
        TextView mEndPlace = findViewById(R.id.tv_setting_delivered_endplace);
        TextView mTransitTime = findViewById(R.id.tv_setting_delivered_transittime);
        TransitMessageBean bean = new TransitMessageBean();
        Intent intent = getIntent();
        String goodPic = intent.getStringExtra("goodPic");
        String goodName = intent.getStringExtra("goodName");
        if(goodName.equals(bean.goodName)){
            mGoodPic.showImage(goodPic);
            mStartPlace.setText(bean.startPlace);
            mEndPlace.setText(bean.endPlace);
            mTransitTime.setText(bean.transitTime);
        }
    }

    private void initNav() {
        ImageView mBack = findViewById(R.id.iv_setting_deliveredbacktomian);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void loadData() {
        List<TransitMessageBean> transitMessageBeanList = NewDeliveredMockUtils.getTransitMessageList();
        adapter.setList(transitMessageBeanList);
        adapter.notifyDataSetChanged();
    }
}
