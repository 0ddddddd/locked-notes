package com.localworld.ishop.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.localworld.ishop.R;
import com.localworld.ishop.common.ISHOPBaseActivity;



public class AboutActivity extends ISHOPBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_about);

        Button button_back = (Button)findViewById(R.id.btn_toolbar_about_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
