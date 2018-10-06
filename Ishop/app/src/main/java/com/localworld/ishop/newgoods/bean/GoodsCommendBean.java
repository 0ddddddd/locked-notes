package com.localworld.ishop.newgoods.bean;

import android.support.annotation.Keep;

import java.io.Serializable;

@Keep
public class GoodsCommendBean implements Serializable{

    public long id;

    public long userId;

    public String content;

    public String userName;

    public String created;
}
