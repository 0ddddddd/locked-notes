package com.localworld.ishop.setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.localworld.ishop.R;

public class EditAddressActivity extends AppCompatActivity {

    private EditText receiverET;
    private EditText mobileET;
    private EditText postcodeET;
    private EditText addreaaET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_address);

        receiverET = (EditText) findViewById(R.id.edit_edit_address_receiver);
        mobileET = (EditText) findViewById(R.id.edit_edit_address_mobile);
        postcodeET = (EditText) findViewById(R.id.edit_edit_address_postcode);
        addreaaET = (EditText) findViewById(R.id.edit_edit_address_address);

        Intent intent = getIntent();
        receiverET.setText(intent.getStringExtra("Receiver"));
        mobileET.setText(intent.getStringExtra("Mobile"));
        postcodeET.setText(intent.getStringExtra("Postcode"));
        addreaaET.setText(intent.getStringExtra("Address"));

        Button backButton = (Button)findViewById(R.id.btn_toolbar_edit_address_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
