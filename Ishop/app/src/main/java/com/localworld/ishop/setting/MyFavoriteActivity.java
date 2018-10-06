package com.localworld.ishop.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.adapter.MyFavoriteAdapter;
import com.localworld.ishop.setting.bean.MyFavoriteBean;

import java.util.ArrayList;
import java.util.List;


public class MyFavoriteActivity extends AppCompatActivity {
    private List<MyFavoriteBean> myFavoriteBeanList = new ArrayList<>();
    private ImageView mBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_setting_myfavorite);
        RecyclerView recyclerView = findViewById(R.id.recycler_setting_setting_myfavorite);
        LinearLayoutManager layoutManager = new GridLayoutManager(this,3,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        MyFavoriteAdapter adapter = new MyFavoriteAdapter(myFavoriteBeanList);
        recyclerView.setAdapter(adapter);

        loadData();

        mBack = findViewById(R.id.iv_setting_setting_myfavorite_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void loadData() {
        for(int i=0;i<=15;i++){
            MyFavoriteBean bean = new MyFavoriteBean();
            bean.img = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533878525822&di=6d43e6f3ee5b6dacac107dd9e421efba&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F019e1956c5c5fe32f875520f5cdab5.jpg%401280w_1l_2o_100sh.jpg";
            myFavoriteBeanList.add(bean);
        }
    }
}
