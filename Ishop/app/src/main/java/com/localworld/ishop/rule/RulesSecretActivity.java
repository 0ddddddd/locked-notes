package com.localworld.ishop.rule;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.localworld.ishop.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;




public class RulesSecretActivity extends AppCompatActivity {
        // 声明控件
        private TextView textView;
        private BufferedReader bufferedReader;
        private InputStream inputStream;
        String words = "12";

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_rules_secret);
            textView = findViewById(R.id.textview_rules_secret);
            getTxt();

            Button backBtton2 = (Button)findViewById(R.id.btn_toolbar_secret_back);
            backBtton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }

        // 获取assets中的txt文件
        private void getTxt() {
            try {
                inputStream = getResources().getAssets().open("121.txt");
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp = "";
                while ((temp = bufferedReader.readLine()) != null) {
                    temp += "\n";
                    words = words + temp;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            textView.setText(words);
        }

}
