package com.localworld.ishop.setting.bean;

import java.io.Serializable;
/*
* Setting中所有bean的基类,包含了区分类型
* */

public class BaseSettingBean implements Serializable {
    /*
    * 依次为头、说说、订单、物流、优惠、朋友、编辑按钮item
    *
    * 规定内容type的范围为1-999
    *//*
    * //setting主界面的item
    public static  final int SETTING_INDEX_TYPE = 0;*/
    public static final int SETTING_MOTTO_TYPE = 1;
    public static final int SETTING_ORDER_TYPE = 2;
    public static final int SETTING_TRANSIT_TYPE = 3;
    public static final int SETTING_DISCOUNT_TYPE = 4;
    public static final int SETTING_FRIENDS_TYPE = 5;
    public static final int SETTING_BTN_CREDIT = 6;

    public static final int FOLLOW_USER_FOLLOWEDUSER = 8002;


    public int frontType;
}
