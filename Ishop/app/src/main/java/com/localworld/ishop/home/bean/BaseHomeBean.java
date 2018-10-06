package com.localworld.ishop.home.bean;

import java.io.Serializable;

public class BaseHomeBean implements Serializable {

    /**
     * 规定内容type的范围为1-999
     */
    public static final int DOUBLE_ROW_GOODS_TYPE = 1;
    public static final int HEAD_BANNER_TYPE_SLIDE = 2;
    public static final int FOUR_HOLDER_TYPE = 3;
    public static final int HORIZONTAL_DISPLAY_TYPE = 4;
    public static final int DISCOVERY_SPECIAL_DOUBLE_ROW_GOODS_TYPE=5;
    public static final int HEAD_BANNER_TYPE_FIXED=6;
    public static final int DISCOVERY_POPULARITY_TYPE=7;
    public static final int DISCOVERY_FRIENDS_TYPE=8;
    public static final int FOOTPRINT_TIME=9;
    public static final int FOOTPRINT_CONTENT=10;

    /**
     * 规定控制type的范围从1001开始
     */
    public static final int AUTHOR_SECTION_TYPE = 1001;
    public static final int SPECIAL_SECTION_TYPE=1002;

    public int frontType;
}
