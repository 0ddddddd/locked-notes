package com.localworld.ishop.home.discovery;

import com.localworld.ishop.home.bean.BaseHomeBean;
import com.localworld.ishop.home.bean.DiscoveryFriendsBean;

import java.util.ArrayList;
import java.util.List;

public class NewDiscoveryFriendsMockUtils {

    private static List<BaseHomeBean> testDataList = new ArrayList<>();

    public static List<BaseHomeBean> getList() {

        testDataList.clear();

        DiscoveryFriendsBean item1 = new DiscoveryFriendsBean();
        item1.frontType = BaseHomeBean.DISCOVERY_FRIENDS_TYPE;
        item1.picPath = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        testDataList.add(item1);

        DiscoveryFriendsBean item2 = new DiscoveryFriendsBean();
        item2.frontType = BaseHomeBean.DISCOVERY_FRIENDS_TYPE;
        item2.picPath = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        testDataList.add(item2);

        return testDataList;
    }
}
