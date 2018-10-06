package com.localworld.ishop.setting.fragment;

import com.localworld.ishop.setting.bean.BaseSettingBean;
import com.localworld.ishop.setting.bean.FollowTopicCommendBean;
import com.localworld.ishop.setting.bean.FollowTopicFollowedBean;

import java.util.ArrayList;
import java.util.List;

public class FollowTest {
    private static List<FollowTopicCommendBean> testListtopic = new ArrayList<>();
    private static List<BaseSettingBean> userTestList = new ArrayList<>();
    private static List<FollowTopicFollowedBean> followedBeans = new ArrayList<>();

    public static List<FollowTopicCommendBean> getTopicTestList() {
        testListtopic.clear();
        FollowTopicCommendBean item3;
        for(int i=0;i<9;i++) {
            item3 = new FollowTopicCommendBean();
            item3.ctopicHeadPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
            item3.ctopicName = "#居老师";
            item3.carticleNum = "5,000";
            testListtopic.add(item3);
        }
        return testListtopic;
    }

    public static List<FollowTopicFollowedBean> getFollowedBeans() {
        followedBeans.clear();
        FollowTopicFollowedBean item ;
        for(int i=0;i<9;i++) {
            item = new FollowTopicFollowedBean();
            item.topicHeadPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
            item.topicName = "居老师";
            item.articleNum = "5,000";
            followedBeans.add(item);
        }
        return followedBeans;
    }

/*    public static List<BaseSettingBean> getUserTestList(){

        FollowFollowedUserBean item2 = new FollowFollowedUserBean();
        for(int i=0;i<8;i++) {
            item2.followUserHeadPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
            item2.followUserName = "hhhhh";
            item2.followUserMotto = "心态爆炸";
            item2.frontType = BaseSettingBean.FOLLOW_USER_FOLLOWEDUSER;
            userTestList.add(item2);
        }
        return userTestList;
    }*/
}
