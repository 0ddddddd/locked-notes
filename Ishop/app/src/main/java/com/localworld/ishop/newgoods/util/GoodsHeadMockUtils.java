package com.localworld.ishop.newgoods.util;


import com.localworld.ishop.newgoods.bean.GoodsHeadBean;

import java.util.ArrayList;
import java.util.List;

public class GoodsHeadMockUtils {


    public static List<GoodsHeadBean> getList() {

        List<GoodsHeadBean> goodsHeadBeansList = new ArrayList<>();
        goodsHeadBeansList.clear();

        GoodsHeadBean item1=new GoodsHeadBean();
        item1.id=1;
        item1.headpic="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        GoodsHeadBean item2=new GoodsHeadBean();
        item1.id=2;
        item2.headpic="http://file.cbcgdf.org/T18/O125/image/20170222/20170222093249_4605.png";
        GoodsHeadBean item3=new GoodsHeadBean();
        item1.id=3;
        item3.headpic="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        GoodsHeadBean item4=new GoodsHeadBean();
        item1.id=4;
        item4.headpic="http://file.cbcgdf.org/T18/O125/image/20170222/20170222093249_4605.png";



        goodsHeadBeansList.add(item1);
        goodsHeadBeansList.add(item2);
        goodsHeadBeansList.add(item3);
        goodsHeadBeansList.add(item4);

        return goodsHeadBeansList;
    }
}
