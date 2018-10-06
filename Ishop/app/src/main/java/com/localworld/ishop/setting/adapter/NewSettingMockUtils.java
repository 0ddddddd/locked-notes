package com.localworld.ishop.setting.adapter;

import com.localworld.ishop.setting.bean.BaseSettingBean;
import com.localworld.ishop.setting.bean.PersonInfoBean;
import com.localworld.ishop.setting.bean.SettingCreditBtnBean;
import com.localworld.ishop.setting.bean.MainDiscountBean;
import com.localworld.ishop.setting.bean.SettingFriendsBean;
import com.localworld.ishop.setting.bean.SettingIndexBean;
import com.localworld.ishop.setting.bean.SettingMottoBean;
import com.localworld.ishop.setting.bean.SettingOrderBean;
import com.localworld.ishop.setting.bean.SettingTransitBean;

import java.util.ArrayList;
import java.util.List;

public class NewSettingMockUtils {
    private static SettingIndexBean indexData = new SettingIndexBean();
    private static PersonInfoBean personInfoBean = new PersonInfoBean();
    private static List<BaseSettingBean> testDataList = new ArrayList<>();
    private static List<MainDiscountBean> discountBeanList = new ArrayList<>();

    public static SettingIndexBean getIndexData(){
        indexData.headPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        indexData.collectionNum = "110";
        indexData.trackNum = "100";
        indexData.followNum = "120";
        return indexData;
    }
    public static PersonInfoBean getPersonInfoBean(){
        personInfoBean.headPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        return personInfoBean;
    }
    public static List<BaseSettingBean> getList(){
        testDataList.clear();

     /*   SettingIndexBean item1 = new SettingIndexBean();
        item1.headPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item1.collectionNum = "110";
        item1.trackNum = "100";
        item1.followNum = "120";
        testDataList.add(item1);*/

        SettingMottoBean item2 = new SettingMottoBean();
        item2.userName = "泼猴哪里走";
        item2.userMotto="lallaalalalalllllllllllllllllllllllllllllllllllllaallaaalalalaallaal";
        item2.frontType = BaseSettingBean.SETTING_MOTTO_TYPE;
        testDataList.add(item2);

        SettingOrderBean item3 = new SettingOrderBean();
        item3.frontType = BaseSettingBean.SETTING_ORDER_TYPE;
        testDataList.add(item3);

        SettingTransitBean item4 = new SettingTransitBean();
        item4.goodsPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item4.startPlace = "天津";
        item4.transitTime = "3";
        item4.endPlace = "上海";
        item4.frontType = BaseSettingBean.SETTING_TRANSIT_TYPE;
        testDataList.add(item4);

        MainDiscountBean item5 = new MainDiscountBean();
        item5.points = "100";
       /* item5.discountImg = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item5.shopName = "英格兰的小店";
        item5.frontType = BaseSettingBean.SETTING_DISCOUNT_TYPE;*/
        testDataList.add(item5);

        SettingFriendsBean item6 = new SettingFriendsBean();
        item6.friendsName = "朱一龙";
        item6.friendsPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item6.frontType = BaseSettingBean.SETTING_FRIENDS_TYPE;
        testDataList.add(item6);

        SettingCreditBtnBean item7 = new SettingCreditBtnBean();
        item7.frontType = BaseSettingBean.SETTING_BTN_CREDIT;
        testDataList.add(item7);

        return testDataList;
    }

    public static List<MainDiscountBean> getDiscountBeanList() {
        discountBeanList.clear();
        MainDiscountBean item5 ;
        for (int i=0;i<=9;i++) {
            item5 = new MainDiscountBean();
            item5.points = "100";
            item5.discountImg = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
            item5.shopName = "英格兰的小店";
            discountBeanList.add(item5);
        }
        return discountBeanList;
    }
}
