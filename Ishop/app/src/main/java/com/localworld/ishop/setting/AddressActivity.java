package com.localworld.ishop.setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.adapter.AddressAdapter;
import com.localworld.ishop.model.ReceivedAddress;

import java.util.ArrayList;
import java.util.List;

public class AddressActivity extends AppCompatActivity {

    //test
    private List<ReceivedAddress> receivedAddressList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        initAddress();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view_settings_address);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AddressAdapter addressAdapter = new AddressAdapter(receivedAddressList);
        recyclerView.setAdapter(addressAdapter);

        Button addAddressButton = (Button)findViewById(R.id.btn_settings_add_address);
        addAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddressActivity.this, AddAddressActivity.class);
                startActivity(intent);
            }
        });

        Button backButton = (Button)findViewById(R.id.btn_toolbar_address_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    //测试数据初始化
    private void initAddress(){
        for (int i = 0 ; i < 2; i++){
            ReceivedAddress receivedAddress = new ReceivedAddress("15988877777","杭州市","王小熊","100000", 2001);
            receivedAddressList.add(receivedAddress);
        }
        ReceivedAddress receivedAddress = new ReceivedAddress("1598886767676","北京市朝阳区","啦啦啦","111111", 2002);
        receivedAddressList.add(receivedAddress);
    }
}
