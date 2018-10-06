package com.localworld.ishop.setting.adapter;

import com.localworld.ishop.setting.bean.PaidGoodsBean;
import com.localworld.ishop.setting.bean.UnpayGoodsBean;

import java.util.ArrayList;
import java.util.List;

public class NewPayMockUtils {
    private static List<UnpayGoodsBean> unpayList = new ArrayList<>();
    private static List<PaidGoodsBean> paidList = new ArrayList<>();

    public static List<UnpayGoodsBean> getUnpayList(){
        unpayList.clear();
        String[] book = new String[]{"数学书","英语书","营养学","会计学","奥数书"};
        UnpayGoodsBean goodsBean;
        for(int i=0;i<book.length;i++) {
            goodsBean = new UnpayGoodsBean();
            goodsBean.unpayGoodsPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
            goodsBean.unpayGoodsName = book[i];
            goodsBean.unpayGoodsPrice = "9.9";
            goodsBean.unpayGoodsInfo = "书籍";
            goodsBean.unpayGoodsNum = "5";
            goodsBean.unpayTotalPrice = "49.5";
            unpayList.add(goodsBean);
        }
        return unpayList;
    }

    public static List<PaidGoodsBean> getPaidList() {
        paidList.clear();
        String[] book = new String[]{"数学书","英语书","营养学","会计学","奥数书"};
        PaidGoodsBean goods;
        for(int i=0;i<book.length;i++) {
            goods = new PaidGoodsBean();
            goods.paidGoodsPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
            goods.paidGoodsName = book[i];
            goods.paidGoodsPrice = "9.9";
            goods.paidGoodsInfo = "书籍";
            goods.paidGoodsNum = "5";
            goods.paidState = "已发货";
            paidList.add(goods);
        }
        return paidList;
    }
}
