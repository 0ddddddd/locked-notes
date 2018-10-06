package com.localworld.ishop.model.goods;

import android.support.annotation.Keep;

import java.io.Serializable;

/**
 * Created by jx on 2018/1/29.
 */

@Keep
public class Comment implements Serializable {

    public long id;

    public long userId;

    public String content;

    public String userName;

    public String created;

}
