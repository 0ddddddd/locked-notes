package com.localworld.ishop.setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.localworld.ishop.R;
import com.localworld.ishop.rule.HelpActivity;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        RelativeLayout receivedAddress = (RelativeLayout)findViewById(R.id.rl_setting_receive_address);
        receivedAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, AddressActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout infoChange = (RelativeLayout)findViewById(R.id.rl_setting_info_change);
        infoChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, InfoChangeActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout aboutUs = (RelativeLayout)findViewById(R.id.rl_setting_about);
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout account = (RelativeLayout)findViewById(R.id.rl_setting_account_security);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout help = (RelativeLayout)findViewById(R.id.rl_setting_help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout currency = (RelativeLayout)findViewById(R.id.rl_setting_currency);
        currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this,CurrencyActivity.class);
                startActivity(intent);
            }
        });

    }
}
