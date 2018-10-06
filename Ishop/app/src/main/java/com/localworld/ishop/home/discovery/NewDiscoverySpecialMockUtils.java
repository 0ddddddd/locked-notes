package com.localworld.ishop.home.discovery;

import com.localworld.ishop.home.bean.BaseHomeBean;
import com.localworld.ishop.home.bean.DiscoverySpecialBannerBean;
import com.localworld.ishop.home.bean.DiscoverySpecialContentBean;

import java.util.ArrayList;
import java.util.List;



public class NewDiscoverySpecialMockUtils {

    private static List<BaseHomeBean> testDataList = new ArrayList<>();

    public static List<BaseHomeBean> getList(){

        testDataList.clear();

       DiscoverySpecialBannerBean item1=new DiscoverySpecialBannerBean();
       item1.frontType=BaseHomeBean.HEAD_BANNER_TYPE_FIXED;
       item1.picPath="http://pic.616pic.com/bg_w1180/00/03/84/jpyygcIg8b.jpg!/fw/1120";
       item1.specialtitle="万圣节特辑";
       testDataList.add(item1);


       BaseHomeBean section1=new BaseHomeBean();
       section1.frontType=BaseHomeBean.SPECIAL_SECTION_TYPE;
       testDataList.add(section1);

        BaseHomeBean section2=new BaseHomeBean();
        section2.frontType=BaseHomeBean.SPECIAL_SECTION_TYPE;

        DiscoverySpecialContentBean item101 = new DiscoverySpecialContentBean();
        item101.frontType = BaseHomeBean.DISCOVERY_SPECIAL_DOUBLE_ROW_GOODS_TYPE;
        item101.contentPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item101.title = "测试11";

        DiscoverySpecialContentBean item102 = new DiscoverySpecialContentBean();
        item102.contentPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item102.title = "测试22";
        item102.frontType = BaseHomeBean.DISCOVERY_SPECIAL_DOUBLE_ROW_GOODS_TYPE;


        DiscoverySpecialContentBean item103 = new DiscoverySpecialContentBean();
        item103.contentPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item103.title = "测试33";
        item103.frontType = BaseHomeBean.DISCOVERY_SPECIAL_DOUBLE_ROW_GOODS_TYPE;


        DiscoverySpecialContentBean item104 = new DiscoverySpecialContentBean();
        item104.contentPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item104.title = "测试44";
        item104.frontType = BaseHomeBean.DISCOVERY_SPECIAL_DOUBLE_ROW_GOODS_TYPE;

        testDataList.add(item101);
        testDataList.add(item102);
        testDataList.add(section2);
        testDataList.add(item103);
        testDataList.add(item104);



        return testDataList;
    }
}
