package com.localworld.ishop.login;

import android.content.Intent;
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
import com.localworld.ishop.model.DefaultResponse;
import com.localworld.ishop.model.login.FollowListBean;
import com.localworld.ishop.request.LoginRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ISHOPUserLoginActivity extends ISHOPBaseActivity {
    private EditText mUserNameET;
    private EditText mPasswordET;
    private ISNetService service = HdlCore.getInstance().getService(ISNetService.class);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        mUserNameET = findViewById(R.id.edit_login_name);
        mPasswordET = findViewById(R.id.edit_login_password);

        findViewById(R.id.tv_register_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ISHOPUserLoginActivity.this, ISHOPUserRegister.class);
                startActivity(intent);
            }
        });

        Button closeButton = findViewById(R.id.btn_login_close);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.btn_login_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginEvent();
            }
        });
    }

    private void loginEvent() {
        String userNameString = mUserNameET.getText().toString();
        String passwordString = mPasswordET.getText().toString();
        if (TextUtils.isEmpty(userNameString) || TextUtils.isEmpty(userNameString.trim())) {
            Toast.makeText(getApplicationContext(), "用户名不能为空！", Toast.LENGTH_LONG).show();
        }

        if (TextUtils.isEmpty(passwordString) || TextUtils.isEmpty(passwordString.trim())) {
            Toast.makeText(getApplicationContext(), "密码不能为空！", Toast.LENGTH_LONG).show();
        }
        LoginRequest request = new LoginRequest();
        request.name = userNameString;
        request.password = passwordString;
        service.login(request).enqueue(new HdlRawCallback<UserInfoLoginResp>() {
            @Override
            protected void onSuccess(UserInfoLoginResp userInfo) {
                //做一个本地存储
                SPUtils.put(getApplicationContext(), SPUtils.LOGIN_SP, "token", userInfo.token);
                LoginManager.getInstance().setUserInfo(userInfo);

                Toast.makeText(getApplicationContext(), "登陆成功！", Toast.LENGTH_SHORT).show();

//                collectGoods();
//                getFollowList();
//                getBoards();
//                getSearchList();
//                getPopularList();

//                LoginManager.getInstance().logout();
//                LoginManager.getInstance().restPwdBySendSMSCode();
//                LoginManager.getInstance().restPwdByCode("227619", "654321");

//                getFollowList();
//                getShareList();
                //getPopularList();
//                LoginManager.getInstance().restPwdByCode("227619","654321");
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

    private void collectGoods() {
        service.postCollection("47").enqueue(new HdlRawCallback<DefaultResponse>() {
            @Override
            protected void onSuccess(DefaultResponse defaultResponse) {
                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();

            }

            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getFansList() {
        Map<String, String> map = new HashMap<>();
        map.put("keyword", "");
        map.put("pageNo", "1");
        map.put("pageSize", "10");
        map.put("targetId", "");
        map.put("targetType", "");
        service.getFansList(map).enqueue(new HdlRawCallback<FollowListBean>() {
            @Override
            protected void onSuccess(FollowListBean followListBean) {
                List<FollowListBean.FollowerBean> list = followListBean.list;
            }

            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(getApplicationContext(), "failed:" + msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getFollowList() {
        if (LoginManager.getInstance().getUserInfo() == null) {
            return;
        }
        long id = LoginManager.getInstance().getUserInfo().id;
        Map<String, String> map = new HashMap<>();
        map.put("keyword", "");
        map.put("pageNo", "1");
        map.put("pageSize", "10");
        map.put("userId", String.valueOf(id));
        map.put("targetType", "user");
        service.getMyFollowList(map).enqueue(new HdlRawCallback<FollowListBean>() {
            @Override
            protected void onSuccess(FollowListBean followListBean) {
                List<FollowListBean.FollowerBean> list = followListBean.list;
            }

            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(getApplicationContext(), "failed:" + msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

 /*   private void getBoards() {
        Map<String, String> map = new HashMap<>();
        map.put("keyword", "特辑");
        service.getBoards(map).enqueue(new HdlRawCallback<DiscoverySpecialBean>() {
            @Override
            protected void onSuccess(DiscoverySpecialBean discoverySpecialBean) {
                List<DiscoverySpecialBean.SpecialBean> list=discoverySpecialBean.SpecialBean;
            }

            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(getApplicationContext(), "failed:" + msg, Toast.LENGTH_SHORT).show();
            }
        });
    }*/

    private void getSearchList() {
        Map<String, String> map = new HashMap<>();
        map.put("boardCode", "goods");
        service.getSearchList(map).enqueue(new HdlRawCallback<List<Object>>() {
            @Override
            protected void onSuccess(List<Object> o) {
                o.toString();
            }

            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(getApplicationContext(), "failed:" + msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

/*    private void getPopularList() {
        service.getPopularList().enqueue(new HdlRawCallback<Object>() {
            @Override
            protected void onSuccess(Object o) {
                o.toString();
            }

            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(getApplicationContext(), "failed:" + msg, Toast.LENGTH_SHORT).show();

            }
        });
    }*/

//    private void getShareList() {
//        service.getShareList().enqueue(new HdlRawCallback<Object>() {
//            @Override
//            protected void onSuccess(Object o) {
//                o.toString();
//            }
//
//            @Override
//            protected void onFailed(String msg, int status) {
//                Toast.makeText(getApplicationContext(), "failed:" + msg, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.ig_base_push_out);
    }
}
