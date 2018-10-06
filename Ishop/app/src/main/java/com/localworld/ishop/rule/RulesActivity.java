package com.localworld.ishop.rule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.localworld.ishop.R;

public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_rules);

        Button backButton = (Button)findViewById(R.id.btn_toolbar_rules_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button secretButton = (Button)findViewById(R.id.btn_rules_secret);
        secretButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RulesActivity.this,RulesSecretActivity.class);
                startActivity(intent);
            }
        });

        Button servicesButton = (Button)findViewById(R.id.btn_rules_serices);
        servicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RulesActivity.this,RulesServicesActivity.class);
                startActivity(intent);
            }
        });

        Button intellectualpropertyButton =(Button)findViewById(R.id.btn_rules_intellectualproperty);
        intellectualpropertyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RulesActivity.this,RulesIntellectualpropertyActivity.class);
                startActivity(intent);
            }
        });

    }
}
