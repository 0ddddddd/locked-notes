package com.localworld.ishop.shop.util;

import com.localworld.ishop.shop.bean.ShopGoods2Bean;

import java.util.ArrayList;
import java.util.List;

public class ShopGoods2UtilMock {
    public static List<ShopGoods2Bean> getList() {
        List<ShopGoods2Bean> DataList = new ArrayList<>();
        DataList.clear();


        ShopGoods2Bean item1=new ShopGoods2Bean();
        item1.id=1;
        item1.username = "用户1";
        item1.pulishtime = "1天前";
        item1.shopgoodspic="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        ShopGoods2Bean item2=new ShopGoods2Bean();
        item2.id=2;
        item2.username = "用户2";
        item2.pulishtime = "2天前";
        item2.shopgoodspic="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        ShopGoods2Bean item3=new ShopGoods2Bean();
        item3.id=3;
        item3.username = "用户3";
        item3.pulishtime = "3天前";
        item3.shopgoodspic="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        ShopGoods2Bean item4=new ShopGoods2Bean();
        item4.id=4;
        item4.username = "用户4";
        item4.pulishtime = "4天前";
        item4.shopgoodspic="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";



        DataList.add(item1);
        DataList.add(item2);
        DataList.add(item3);
        DataList.add(item4);

        return DataList;
    }
}
