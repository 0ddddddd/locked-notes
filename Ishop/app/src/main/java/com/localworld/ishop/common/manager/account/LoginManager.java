package com.localworld.ishop.common.manager.account;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.igerm.android.lib.net.core.HdlCore;
import com.igerm.android.lib.net.core.HdlRawCallback;
import com.igerm.android.lib.net.util.SPUtils;
import com.localworld.ishop.common.heimdall.ISNetService;
import com.localworld.ishop.request.UserInfoRequest;
import com.localworld.ishop.util.AppUtil;
import com.localworld.ishop.util.Constant;
import com.localworld.ishop.util.SharedPreferencesUtil;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginManager {
    private static LoginManager mLoginManager;
    private static final String IPOLE_LOGIN_RESP = "ipole_login_resp";
    private UserInfo mUserInfo;
    private Context mContext;
    private ISNetService service = HdlCore.getInstance().getService(ISNetService.class);

    private LoginManager() {
    }

    public static LoginManager getInstance() {
        if (mLoginManager == null) {
            mLoginManager = new LoginManager();
        }
        return mLoginManager;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public UserInfo getUserInfo() {
        if (mUserInfo == null) {
            String userInfoString = SharedPreferencesUtil.get(mContext, Constant.IPOLE_SP, IPOLE_LOGIN_RESP, "");
            if (!TextUtils.isEmpty(userInfoString)) {
                UserInfo userInfo = AppUtil.JsonToObject(userInfoString, UserInfo.class);
                if (userInfo != null) {
                    mUserInfo = userInfo;
                }
            }
        }
        return mUserInfo;
    }

    public void setUserInfo(UserInfo info) {
        String userInfoString = AppUtil.ObjectToJsonString(info);
        if (!TextUtils.isEmpty(userInfoString)) {
            SharedPreferencesUtil.put(mContext, Constant.IPOLE_SP, IPOLE_LOGIN_RESP, userInfoString);
        }
    }

    private void cleanUserInfo() {
        SharedPreferencesUtil.clear(mContext, Constant.IPOLE_SP);
        SPUtils.put(mContext, SPUtils.LOGIN_SP, "token", "");
        mUserInfo = null;
    }

    public void updateUserInfo(UserInfo userInfo) {
        if (userInfo == null) {
            return;
        }
        UserInfoRequest request = (UserInfoRequest) userInfo;
        service.updateUserInfo(request).enqueue(new HdlRawCallback<UserInfo>() {
            @Override
            protected void onSuccess(UserInfo userInfo) {
                setUserInfo(userInfo);
                Toast.makeText(mContext, "更新用户信息成功！", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(mContext, "failed:" + msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void logout() {
        String token = SPUtils.get(mContext, SPUtils.LOGIN_SP, "token", "");
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        service.logout(map).enqueue(new HdlRawCallback<String>() {
            @Override
            protected void onSuccess(String s) {
                cleanUserInfo();
                Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onFailed(String msg, int status) {
                Toast.makeText(mContext, "failed:" + msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 发送短信验证码
     */
    public void restPwdBySendSMSCode() {
        UserInfo info = getUserInfo();
        if (info != null) {
            String phone = info.mobile;

            Map<String, String> map = new HashMap<>();
            map.put("phone", phone);
            service.restPwdPhoneCode(map).enqueue(new HdlRawCallback<Boolean>() {

                @Override
                protected void onSuccess(Boolean aBoolean) {
                    Toast.makeText(mContext, "成功接收到短信验证码", Toast.LENGTH_SHORT).show();
                }

                @Override
                protected void onFailed(String msg, int status) {
                    Toast.makeText(mContext, "重置失败:", Toast.LENGTH_SHORT).show();
                }

            });
        }
    }

    public void restPwdByCode(String code, final String pwd) {
        UserInfo info = getUserInfo();
        if (info != null) {
            String phone = info.mobile;

            Map<String, String> map = new HashMap<>();
            map.put("phone", phone);
            map.put("validateCode", code);
            service.restPwdGetToken(map).enqueue(new HdlRawCallback<String>() {

                @Override
                protected void onSuccess(String s) {
                    if (!TextUtils.isEmpty(s)) {
                        String token = s;
                        restPwdUpdatePwd(token, pwd);
                    }
                }

                @Override
                protected void onFailed(String msg, int status) {
                    Toast.makeText(mContext, "重置失败:" + msg, Toast.LENGTH_SHORT).show();
                }

            });
        }
    }

    public void restPwdUpdatePwd(String token, String pwd) {
        Map<String, String> map = new HashMap<>();
        map.put("password", pwd);
        map.put("token", token);
        service.restPwd(map).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                Toast.makeText(mContext, "重置成功！请重新登录", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(mContext, "重置失败:", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
