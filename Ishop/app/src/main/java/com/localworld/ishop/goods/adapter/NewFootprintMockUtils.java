package com.localworld.ishop.goods.adapter;

import com.localworld.ishop.goods.bean.FootprintBean;
import com.localworld.ishop.goods.bean.FootprintTimeBean;
import com.localworld.ishop.home.bean.BaseHomeBean;

import java.util.ArrayList;
import java.util.List;

public class NewFootprintMockUtils {
    private static List<BaseHomeBean> testDataList = new ArrayList<>();

    public static List<BaseHomeBean> getList() {

        testDataList.clear();

        FootprintTimeBean time1=new FootprintTimeBean();
        time1.frontType=BaseHomeBean.FOOTPRINT_TIME;
        time1.time="8月1日";
        testDataList.add(time1);

        FootprintBean item1=new FootprintBean();
        item1.frontType=BaseHomeBean.FOOTPRINT_CONTENT;
        item1.picPath="http://pic.616pic.com/bg_w1180/00/03/84/jpyygcIg8b.jpg!/fw/1120";
        testDataList.add(item1);
        FootprintBean item2=new FootprintBean();
        item2.frontType=BaseHomeBean.FOOTPRINT_CONTENT;
        item2.picPath="http://pic.616pic.com/bg_w1180/00/03/84/jpyygcIg8b.jpg!/fw/1120";
        testDataList.add(item2);
        FootprintBean item3=new FootprintBean();
        item3.frontType=BaseHomeBean.FOOTPRINT_CONTENT;
        item3.picPath="http://pic.616pic.com/bg_w1180/00/03/84/jpyygcIg8b.jpg!/fw/1120";
        testDataList.add(item3);
        FootprintBean item4=new FootprintBean();
        item4.frontType=BaseHomeBean.FOOTPRINT_CONTENT;
        item4.picPath="http://pic.616pic.com/bg_w1180/00/03/84/jpyygcIg8b.jpg!/fw/1120";
        testDataList.add(item4);
        FootprintBean item5=new FootprintBean();
        item5.frontType=BaseHomeBean.FOOTPRINT_CONTENT;
        item5.picPath="http://pic.616pic.com/bg_w1180/00/03/84/jpyygcIg8b.jpg!/fw/1120";
        testDataList.add(item5);
        FootprintBean item6=new FootprintBean();
        item6.frontType=BaseHomeBean.FOOTPRINT_CONTENT;
        item6.picPath="http://pic.616pic.com/bg_w1180/00/03/84/jpyygcIg8b.jpg!/fw/1120";
        testDataList.add(item6);
        FootprintBean item7=new FootprintBean();
        item7.frontType=BaseHomeBean.FOOTPRINT_CONTENT;
        item7.picPath="http://pic.616pic.com/bg_w1180/00/03/84/jpyygcIg8b.jpg!/fw/1120";
        testDataList.add(item7);

        FootprintTimeBean time2=new FootprintTimeBean();
        time2.frontType=BaseHomeBean.FOOTPRINT_TIME;
        time2.time="8月2日";
        testDataList.add(time2);

        FootprintBean item11=new FootprintBean();
        item11.frontType=BaseHomeBean.FOOTPRINT_CONTENT;
        item11.picPath="http://pic.616pic.com/bg_w1180/00/03/84/jpyygcIg8b.jpg!/fw/1120";
        testDataList.add(item11);
        FootprintBean item12=new FootprintBean();
        item12.frontType=BaseHomeBean.FOOTPRINT_CONTENT;
        item12.picPath="http://pic.616pic.com/bg_w1180/00/03/84/jpyygcIg8b.jpg!/fw/1120";
        testDataList.add(item12);
        FootprintBean item13=new FootprintBean();
        item13.frontType=BaseHomeBean.FOOTPRINT_CONTENT;
        item13.picPath="http://pic.616pic.com/bg_w1180/00/03/84/jpyygcIg8b.jpg!/fw/1120";
        testDataList.add(item13);
        FootprintBean item14=new FootprintBean();
        item14.frontType=BaseHomeBean.FOOTPRINT_CONTENT;
        item14.picPath="http://pic.616pic.com/bg_w1180/00/03/84/jpyygcIg8b.jpg!/fw/1120";
        testDataList.add(item14);
        FootprintBean item15=new FootprintBean();
        item15.frontType=BaseHomeBean.FOOTPRINT_CONTENT;
        item15.picPath="http://pic.616pic.com/bg_w1180/00/03/84/jpyygcIg8b.jpg!/fw/1120";
        testDataList.add(item15);
        FootprintBean item16=new FootprintBean();
        item16.frontType=BaseHomeBean.FOOTPRINT_CONTENT;
        item16.picPath="http://pic.616pic.com/bg_w1180/00/03/84/jpyygcIg8b.jpg!/fw/1120";
        testDataList.add(item16);
        return testDataList;
    }
}
