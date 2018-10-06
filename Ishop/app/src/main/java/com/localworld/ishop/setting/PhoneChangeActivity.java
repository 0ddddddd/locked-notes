package com.localworld.ishop.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.localworld.ishop.R;
import com.localworld.ishop.common.ISHOPBaseActivity;



public class PhoneChangeActivity extends ISHOPBaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_phone_change);

        Button button_back = (Button)findViewById(R.id.btn_toolbar_phonechange_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
