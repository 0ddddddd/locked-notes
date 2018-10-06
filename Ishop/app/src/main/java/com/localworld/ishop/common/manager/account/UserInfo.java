package com.localworld.ishop.common.manager.account;

import android.support.annotation.Keep;

import java.io.Serializable;



@Keep
public class UserInfo implements Serializable {
    public long id;
    public String address;
    public long birthday;
    public String email;
    public String headPic;
    public String mobile;
    public int sex;
    public String name;
    public String password;


}
