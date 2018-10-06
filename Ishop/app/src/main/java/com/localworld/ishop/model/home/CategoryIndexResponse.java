package com.localworld.ishop.model.home;

import android.support.annotation.Keep;

import java.io.Serializable;
import java.util.List;

/**
 * 左右两个分类的返回数据
 *
 * @author chenfeng
 * @since 2018-05-01 15:54
 */

@Keep
public class CategoryIndexResponse implements Serializable {
    public int pageCount; //总页数
    public int count;//总数
    public List<IndexPageItem> list;

}
