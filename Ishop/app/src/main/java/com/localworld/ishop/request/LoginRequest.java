package com.localworld.ishop.request;

import android.support.annotation.Keep;

import java.io.Serializable;

/**
 * 文件描述
 *
 * @author chenfeng
 * @since 2017-12-11 16:32
 */

@Keep
public class LoginRequest implements Serializable {

    public String name;
    public String password;
}
