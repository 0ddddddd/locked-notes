package com.localworld.ishop.order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.localworld.ishop.R;
import com.localworld.ishop.model.Order;

import java.util.ArrayList;
import java.util.List;


public class CheckOrder extends AppCompatActivity {
    private List<Order> orderList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_order);
        initView();
    }

    private void initView() {
        initOrder();
        RecyclerView recyclerView=findViewById(R.id.check_order_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
     //   OrderAdapter adapter=new OrderAdapter(orderList,this);
        //调用OrderUtils的数据
//        OrderAdapter adapter=new OrderAdapter(OrderUtils.getmorderListData(),this);
//        recyclerView.setAdapter(adapter);

        Button btn_toolbar_check_order_back=findViewById(R.id.btn_toolbar_check_order_back);
        btn_toolbar_check_order_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initOrder() {
    }
}
