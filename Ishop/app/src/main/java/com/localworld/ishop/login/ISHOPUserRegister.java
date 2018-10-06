package com.localworld.ishop.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.igerm.android.lib.net.core.HdlCore;
import com.igerm.android.lib.net.core.HdlRawCallback;
import com.igerm.android.lib.net.util.SPUtils;
import com.localworld.ishop.R;
import com.localworld.ishop.common.ISHOPBaseActivity;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.common.manager.account.LoginManager;
import com.localworld.ishop.common.manager.account.UserInfoLoginResp;
import com.localworld.ishop.request.UserInfoRequest;


public class ISHOPUserRegister extends ISHOPBaseActivity {

    private EditText mPhoneNumberET;
    //    private EditText mVerificationCode;
    private EditText mPasswordET;
    private EditText mUserNameET;
    private ISNetService service = HdlCore.getInstance().getService(ISNetService.class);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        mPhoneNumberET = findViewById(R.id.edit_register_phonenumber);
        mUserNameET = findViewById(R.id.edit_register_username);
        mPasswordET = findViewById(R.id.edit_register_password);
        findViewById(R.id.button_register_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerEvent();
            }
        });

        Button closeButton = findViewById(R.id.btn_register_close);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void registerEvent() {
        String userNameString = mUserNameET.getText().toString();
        String passwordString = mPasswordET.getText().toString();
        String mPhoneNumberString = mPhoneNumberET.getText().toString();
        UserInfoRequest request = new UserInfoRequest();
        request.mobile = mPhoneNumberString;
        request.name = userNameString;
        request.password = passwordString;
        service.register(request).enqueue(new HdlRawCallback<UserInfoLoginResp>() {
            @Override
            protected void onSuccess(UserInfoLoginResp userInfo) {
                SPUtils.put(getApplicationContext(), SPUtils.LOGIN_SP, "token", userInfo.token);
                LoginManager.getInstance().setUserInfo(userInfo);

                Toast.makeText(getApplicationContext(), "注册成功！", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            protected void onFailed(String msg, int status) {
                String toastString;
                if (TextUtils.isEmpty(msg)) {
                    toastString = "网络似乎有点问题！";
                } else {
                    toastString = msg;
                }
                Toast.makeText(getApplicationContext(), toastString, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.ig_base_push_out);
    }
}
