package com.localworld.ishop.setting;

import com.localworld.ishop.setting.bean.AddAccountBean;
import com.localworld.ishop.setting.bean.BlackListBean;
import com.localworld.ishop.setting.bean.OpenAllFriendsBean;

import java.util.ArrayList;
import java.util.List;

public class NewAddAccountMockUtils {
    private static List<AddAccountBean> accountBeanList = new ArrayList<>();

    public static List<AddAccountBean> getAccountBeanList() {
        accountBeanList.clear();
        AddAccountBean bean = new AddAccountBean();
        bean.headPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        bean.AccountName =  "共产主义接班人";
        bean.AccountID = "10086";
        accountBeanList.add(bean);
        return accountBeanList;
    }
    private static List<BlackListBean> blackListBeans = new ArrayList<>();

    public static List<BlackListBean> getBlackListBeans() {
        blackListBeans.clear();
        BlackListBean beans ;
        for (int i=0;i<9;i++) {
            beans = new BlackListBean();
            beans.blackListHeadPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
            beans.blackListAccountName = "共产主义接班人";
            beans.blackListAccountID = "10086";
            blackListBeans.add(beans);
        }
        return blackListBeans;
    }

    private static List<OpenAllFriendsBean> openAllFriendsBeanList = new ArrayList<>();

    public static List<OpenAllFriendsBean> getFriendsBeansList() {
        openAllFriendsBeanList.clear();
        OpenAllFriendsBean beans ;
        for (int i=0;i<9;i++) {
            beans = new OpenAllFriendsBean();
            beans.friendsHeadPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
            beans.friendsAccountName = "共产主义接班人";
            beans.friendsAccountID = "10086";
            openAllFriendsBeanList.add(beans);
        }
        return openAllFriendsBeanList;
    }
}
