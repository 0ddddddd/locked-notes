package com.localworld.ishop.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.localworld.ishop.R;
import com.localworld.ishop.common.ISHOPBaseActivity;



public class AccountActivity extends ISHOPBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_account);

        RelativeLayout passwordChange =(RelativeLayout) findViewById(R.id.rl_account_password_change);
        passwordChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this, PasswordChangeActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout phoneChange =(RelativeLayout) findViewById(R.id.rl_account_phone_change);
        phoneChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this,PhoneChangeActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout delete =(RelativeLayout) findViewById(R.id.rl_account_delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this,DeleteActivity.class);
                startActivity(intent);
            }
        });

        Button button_back = (Button)findViewById(R.id.btn_toolbar_account_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
