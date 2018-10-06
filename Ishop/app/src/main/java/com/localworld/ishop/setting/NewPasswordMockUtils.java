package com.localworld.ishop.setting;

import com.localworld.ishop.setting.bean.ChangePasswordBean;

import java.util.ArrayList;
import java.util.List;

public class NewPasswordMockUtils {
    private static List<ChangePasswordBean> pwdList = new ArrayList<>();

    public static List<ChangePasswordBean> getPwdList() {
        pwdList.clear();
        ChangePasswordBean bean = new ChangePasswordBean();
        bean.oldPwd = "123";
        bean.newPwd = "1234";
        bean.confirmPwd = "1234";
        return pwdList;
    }
}
