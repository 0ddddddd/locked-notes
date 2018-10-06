package com.localworld.ishop.setting;

import com.localworld.ishop.setting.bean.DeliveredBean;
import com.localworld.ishop.setting.bean.GetGoodsBean;
import com.localworld.ishop.setting.bean.TransitMessageBean;
import com.localworld.ishop.setting.bean.UnDeliverBean;

import java.util.ArrayList;
import java.util.List;

public class NewDeliveredMockUtils {
    private static List<TransitMessageBean> transitMessageList = new ArrayList<>();
    private static List<UnDeliverBean> unDeliverBeanList = new ArrayList<>();
    private static List<DeliveredBean> deliveredList = new ArrayList<>();
    private static List<GetGoodsBean> getGoodsList = new ArrayList<>();

    public static List<TransitMessageBean> getTransitMessageList() {
        transitMessageList.clear();
        TransitMessageBean bean1;
        TransitMessageBean bean2 = new TransitMessageBean();
        bean2.goodName = "鞋子";
//        bean2.goodPic ="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        bean2.startPlace = "北京";
        bean2.endPlace = "厦门";
        bean2.transitTime = "36";
        transitMessageList.add(bean2);
        for(int i=0;i<=3;i++){
            bean1 = new TransitMessageBean();
            bean1.time = "11:30";
            bean1.message = "杭州中转站已收货";
            transitMessageList.add(bean1);
        }
        return transitMessageList;
    }

    public static List<UnDeliverBean> getUnDeliverBeanList() {
        unDeliverBeanList.clear();
        UnDeliverBean bean;
        for (int i=0;i<9;i++){
            bean = new UnDeliverBean();
            bean.unDeliverGoodPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
            bean.unDeliverGoodName = "鞋子";
            bean.unDeliverGoodPrice = "100";
            bean.unDeliverGoodNum = "2";
            bean.unDeliverGoodInfo = "黑色";
            unDeliverBeanList.add(bean);
        }
        return unDeliverBeanList;
    }

    public static List<DeliveredBean> getDeliveredList() {
        deliveredList.clear();
        DeliveredBean bean ;
        for (int i=0;i<9;i++){
            bean = new DeliveredBean();
            bean.deliveredGoodHeadPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
            bean.deliveredGoodName = "鞋子";
            bean.deliveredGoodPrice = "100";
            bean.deliveredGoodNum = "2";
            bean.deliveredGoodInfo = "黑色";
            deliveredList.add(bean);
        }
        return deliveredList;
    }

    public static List<GetGoodsBean> getGetGoodsList() {
        getGoodsList.clear();
        GetGoodsBean bean1;
        for (int i=0;i<9;i++){
            bean1 = new GetGoodsBean();
            bean1.getGoodsPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
            bean1.getGoodsName = "短裙";
            bean1.getGoodsPrice = "100";
            bean1.getGoodsNum = "2";
            bean1.getGoodsInfo = "黑色";
            getGoodsList.add(bean1);
        }
        return getGoodsList;
    }
}
