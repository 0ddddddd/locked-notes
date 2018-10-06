package com.localworld.ishop.shop.util;

import com.localworld.ishop.shop.bean.ShopRecommendUserBean;

import java.util.ArrayList;
import java.util.List;

public class RecommendUserUtilMock {
    public static List<ShopRecommendUserBean> getList() {

        List<ShopRecommendUserBean> DataList = new ArrayList<>();
        DataList.clear();

        ShopRecommendUserBean item1 = new ShopRecommendUserBean();
        item1.id = 1;
        item1.username = "用户1";
        item1.userimage = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        ShopRecommendUserBean item2 = new ShopRecommendUserBean();
        item2.id = 2;
        item2.username = "用户2";
        item2.userimage = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        ShopRecommendUserBean item3 = new ShopRecommendUserBean();
        item3.id = 3;
        item3.username = "用户3";
        item3.userimage = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        ShopRecommendUserBean item4 = new ShopRecommendUserBean();
        item4.id = 4;
        item4.username = "用户4";
        item4.userimage = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        ShopRecommendUserBean item5 = new ShopRecommendUserBean();
        item5.id = 4;
        item5.username = "用户5";
        item5.userimage = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";

        DataList.add(item1);
        DataList.add(item2);
        DataList.add(item3);
        DataList.add(item4);
        DataList.add(item5);

        return DataList;

    }
}
