package com.localworld.ishop.goods;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportActivity;
import com.localworld.ishop.goods.adapter.FootprintAdapter;
import com.localworld.ishop.goods.adapter.NewFootprintMockUtils;
import com.localworld.ishop.home.adapter.SpanHelper;
import com.localworld.ishop.home.bean.BaseHomeBean;

import java.util.ArrayList;
import java.util.List;

public class FootPrintActivity extends BaseSupportActivity {
    private List<BaseHomeBean> baseHomeBeans = new ArrayList<>();
    private Toolbar mToolbar;
    private View back;
    private RecyclerView recyclerView;
    private FootprintAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footprint);
        initToolbar();
        initView();
    }

    private void initToolbar() {
        mToolbar = findViewById(R.id.toolbar_footprint);
        setSupportActionBar(mToolbar);

        //自定义顶部栏
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            LinearLayout layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.ime_base_toolbar_footprint, null, false);
            supportActionBar.setCustomView(layout);
            supportActionBar.setDisplayShowCustomEnabled(true);
            supportActionBar.setDisplayHomeAsUpEnabled(false);
            supportActionBar.setDisplayShowTitleEnabled(false);
            //自定义view完全填充toolbar
            Toolbar parent = (Toolbar) layout.getParent();
            parent.setContentInsetsAbsolute(0, 0);

            back = findViewById(R.id.iv_toolbar_footprint_back);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rcv_footprint);
        adapter = new FootprintAdapter();
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSpanSizeLookup(new SpanHelper(adapter, 3));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        loadData();

    }

    private void loadData() {

        List<BaseHomeBean> data = NewFootprintMockUtils.getList();

        adapter.setDataList(data);
        adapter.notifyDataSetChanged();
    }

}
