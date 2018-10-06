package com.localworld.ishop.request;

import android.support.annotation.Keep;

import java.io.Serializable;

/**
 * 列表请求基类
 *
 * @author chenfeng
 * @since 2018-03-24 15:28
 */

@Keep
public class BaseRequest implements Serializable {

    public int pageNo;
    public int pageSize;
}
