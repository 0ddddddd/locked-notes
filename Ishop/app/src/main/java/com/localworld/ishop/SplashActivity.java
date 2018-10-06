package com.localworld.ishop;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.localworld.ishop.common.ISHOPBaseActivity;
import com.localworld.ishop.home.HomeActivity;


public class SplashActivity extends ISHOPBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gotoHome();
            }
        }, 2000);
    }

    private void gotoHome() {
        startActivity(new Intent(SplashActivity.this, HomeActivity.class));
        finish();
    }
}
