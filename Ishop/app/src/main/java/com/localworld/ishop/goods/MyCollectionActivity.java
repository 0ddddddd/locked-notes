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
import com.localworld.ishop.goods.adapter.MyCollectionAdapter;
import com.localworld.ishop.goods.bean.MyCollectionBean;

import java.util.ArrayList;
import java.util.List;

public class MyCollectionActivity extends BaseSupportActivity{
    private List<MyCollectionBean> myCollectionBeanList =new ArrayList<>();

    private Toolbar mToolbar;
    private View back;
    private RecyclerView recyclerView;
    private MyCollectionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycollection);
        initToolbar();
        initView();
        initData();
    }

    private void initToolbar() {
        mToolbar = findViewById(R.id.toolbar_mycollection);
        setSupportActionBar(mToolbar);

        //自定义顶部栏
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            LinearLayout layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.ime_base_toolbar_mycollection, null, false);
            supportActionBar.setCustomView(layout);
            supportActionBar.setDisplayShowCustomEnabled(true);
            supportActionBar.setDisplayHomeAsUpEnabled(false);
            supportActionBar.setDisplayShowTitleEnabled(false);
            //自定义view完全填充toolbar
            Toolbar parent = (Toolbar) layout.getParent();
            parent.setContentInsetsAbsolute(0, 0);

            back=findViewById(R.id.iv_toolbar_mycollection_back);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    private void initView(){
        recyclerView=(RecyclerView)findViewById(R.id.rcv_mycollection);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new MyCollectionAdapter(myCollectionBeanList);
        recyclerView.setAdapter(adapter);
    }

    private void initData(){
        MyCollectionBean test1=new MyCollectionBean("http://pic.616pic.com/bg_w1180/00/03/92/5XuT1F9vhD.jpg!/fw/1120");
        myCollectionBeanList.add(test1);
        MyCollectionBean test2=new MyCollectionBean("http://pic.616pic.com/bg_w1180/00/03/92/5XuT1F9vhD.jpg!/fw/1120");
        myCollectionBeanList.add(test2);
        MyCollectionBean test3=new MyCollectionBean("http://pic.616pic.com/bg_w1180/00/03/92/5XuT1F9vhD.jpg!/fw/1120");
        myCollectionBeanList.add(test3);
        MyCollectionBean test4=new MyCollectionBean("http://pic.616pic.com/bg_w1180/00/03/92/5XuT1F9vhD.jpg!/fw/1120");
        myCollectionBeanList.add(test4);
        MyCollectionBean test5=new MyCollectionBean("http://pic.616pic.com/bg_w1180/00/03/92/5XuT1F9vhD.jpg!/fw/1120");
        myCollectionBeanList.add(test5);
        MyCollectionBean test6=new MyCollectionBean("http://pic.616pic.com/bg_w1180/00/03/92/5XuT1F9vhD.jpg!/fw/1120");
        myCollectionBeanList.add(test6);
        MyCollectionBean test7=new MyCollectionBean("http://pic.616pic.com/bg_w1180/00/03/92/5XuT1F9vhD.jpg!/fw/1120");
        myCollectionBeanList.add(test7);
    }

}
