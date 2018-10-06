package com.localworld.ishop.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.bean.ChangePasswordBean;

import java.util.List;

public class ChangePasswordActivity extends AppCompatActivity {
    private EditText mOldPwd;
    private EditText mNewPwd;
    private EditText mConfirmPwd;
    private TextView mConfirmModify;
    private ImageView mBack;
    private ChangePasswordBean bean;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_setting_changepwd);
        initView();
        loadData();
    }

    private void loadData() {
        List<ChangePasswordBean> list = NewPasswordMockUtils.getPwdList();
    }

    private void initView(){
        mOldPwd = findViewById(R.id.edit_setting_setting_changepwd_oldpwd);
        mNewPwd = findViewById(R.id.edit_setting_setting_changepwd_newpwd);
        mConfirmPwd = findViewById(R.id.edit_setting_setting_changepwd_confirmpwd);
        mConfirmModify = findViewById(R.id.tv_setting_setting_changepwd_confirmmodify);
        mBack = findViewById(R.id.iv_setting_changepwdbacktomian);

        bean = new ChangePasswordBean();


        mConfirmModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOldPwd.getText().toString().equals(bean.oldPwd)&& mNewPwd.getText().toString().equals(bean.newPwd)&&mConfirmPwd.getText().toString().equals(bean.confirmPwd)){
                    Toast.makeText(ChangePasswordActivity.this,"修改成功",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(ChangePasswordActivity.this,"修改失败",Toast.LENGTH_LONG).show();

                }
            }
        });
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
