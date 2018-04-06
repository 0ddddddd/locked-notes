package com.example.qiangqiang.ldnotebookapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LdLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_name, et_pass;
    private Button mLoginButton,mLoginError,mRegister;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private Button bt_username_clear;
    private Button bt_pwd_clear;
    private Button bt_pwd_eye;
    private CheckBox bt_login_rem;
    private TextWatcher username_watcher;
    private TextWatcher password_watcher;

    public LdLoginActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ld_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        et_name = (EditText) findViewById(R.id.username);
        et_pass = (EditText) findViewById(R.id.password);

        bt_username_clear = (Button)findViewById(R.id.bt_username_clear);
        bt_pwd_clear = (Button)findViewById(R.id.bt_pwd_clear);
        bt_pwd_eye = (Button)findViewById(R.id.bt_pwd_eye);
        bt_username_clear.setOnClickListener(this);
        bt_pwd_clear.setOnClickListener(this);
        bt_pwd_eye.setOnClickListener(this);

        initWatcher();
        et_name.addTextChangedListener(username_watcher);
        et_pass.addTextChangedListener(password_watcher);

        mLoginButton = (Button) findViewById(R.id.login);
        mRegister    = (Button) findViewById(R.id.register);
        bt_login_rem = (CheckBox)findViewById(R.id.login_rem) ;
        mLoginButton.setOnClickListener(this);
        mRegister.setOnClickListener(this);
        bt_login_rem.setOnClickListener(this);

        Boolean isRemember = pref.getBoolean("remember_password",false);
        if (isRemember) {
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            et_name.setText(account);
            et_pass.setText(password);
            bt_login_rem.setChecked(true);
        }

    }

/* 账号，密码输入控件公用这一个watcher*/

    private void initWatcher() {
        username_watcher = new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
            public void afterTextChanged(Editable s) {
                et_pass.setText("");
                if(s.toString().length()>0){
                    bt_username_clear.setVisibility(View.VISIBLE);
                }else{
                    bt_username_clear.setVisibility(View.INVISIBLE);
                }
            }
        };

        password_watcher = new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
            public void afterTextChanged(Editable s) {
                if(s.toString().length()>0){
                    bt_pwd_clear.setVisibility(View.VISIBLE);
                }else{
                    bt_pwd_clear.setVisibility(View.INVISIBLE);
                }
            }
        };
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:  //登陆
                String account = et_name.getText().toString();
                String password = et_pass.getText().toString();
                // 如果账号是123且密码是123，就认为登录成功
                if (account.equals("123") && password.equals("123")) {
                    if(bt_login_rem.isChecked()){
                        editor = pref.edit();
                        if (bt_login_rem.isChecked()) {
                            editor.putBoolean("remember_password", true);
                            editor.putString("account", account);
                            editor.putString("password", password);
                        } else {
                            editor.clear();
                        }
                        editor.apply();
                        Toast.makeText(LdLoginActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                    }
                    Intent intent = new Intent(LdLoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LdLoginActivity.this, "account or password is invalid",
                            Toast.LENGTH_SHORT).show();
                }
                startActivity(new Intent(LdLoginActivity.this, MainActivity.class));
                break;
            case R.id.login_rem:
                Toast.makeText(LdLoginActivity.this, "记住密码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.register:    //注册新的用户
                Toast.makeText(LdLoginActivity.this, "暂未添加该功能", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_username_clear:
                et_name.setText("");
                et_pass.setText("");
                break;
            case R.id.bt_pwd_clear:
                et_pass.setText("");
                break;
            case R.id.bt_pwd_eye:
                if(et_pass.getInputType() == (InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD)){
                    bt_pwd_eye.setBackgroundResource(R.drawable.login_eye);
                    et_pass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_NORMAL);
                }else{
                    bt_pwd_eye.setBackgroundResource(R.drawable.login_eye);
                    et_pass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                et_pass.setSelection(et_pass.getText().toString().length());
                break;
        }
    }

}
