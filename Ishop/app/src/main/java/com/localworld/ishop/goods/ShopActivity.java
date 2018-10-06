package com.localworld.ishop.goods;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.localworld.ishop.R;
import com.localworld.ishop.common.fragmentation.BaseSupportActivity;
import com.localworld.ishop.shopcart.adapter.ShopAdapter;
import com.localworld.ishop.model.Order;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends BaseSupportActivity {
    private List<Order> shoplist=new ArrayList<>();
    private ShopAdapter shopAdapter=new ShopAdapter(shoplist);
    private RecyclerView shoprcv,recommendrcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart);
        initview();
        initdata();
    }

    private void initview(){
        shoprcv=findViewById(R.id.rv_shop);
        recommendrcv=findViewById(R.id.rv_shop_image);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        shoprcv.setLayoutManager(layoutManager);
        shoprcv.setAdapter(shopAdapter);
        recommendrcv.setLayoutManager(layoutManager);
        recommendrcv.setAdapter(shopAdapter);

    }

    private void initdata(){
         Order order=new Order("1","2","3",23,2);
        shoplist.add(order);
    }

}
