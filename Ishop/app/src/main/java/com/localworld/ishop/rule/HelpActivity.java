package com.localworld.ishop.rule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.localworld.ishop.R;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_help);

        Button backButton = (Button)findViewById(R.id.btn_toolbar_help_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button contcatButton = (Button)findViewById(R.id.btn_help_contact_us);
        contcatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelpActivity.this, ContactUsActivity.class);
                startActivity(intent);
            }
        });

        Button rulesButton = (Button)findViewById(R.id.btn_help_rules_and_regulations);
        rulesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelpActivity.this, RulesActivity.class);
                startActivity(intent);
            }
        });
    }
}
