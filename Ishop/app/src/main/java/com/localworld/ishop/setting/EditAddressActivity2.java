package com.localworld.ishop.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.localworld.ishop.R;

public class EditAddressActivity2 extends AppCompatActivity{

    private TextView mDeleteAddress;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_editaddress);
    }

    private void init(){
        ImageView mBack = findViewById(R.id.iv_setting_editaddress_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TextView mSave = findViewById(R.id.tv_setting_edieaddress_save);
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo 地址编辑 点击保存后进行后续操作
            }
        });
        mDeleteAddress = findViewById(R.id.btn_setting_deleteaddress);
        mDeleteAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditAddressActivity2.this,PersonInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
