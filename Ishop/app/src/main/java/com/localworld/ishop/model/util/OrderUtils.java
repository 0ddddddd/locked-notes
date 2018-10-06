package com.localworld.ishop.model.util;

import com.localworld.ishop.model.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lxysss on 2018/4/15.
 */

public class OrderUtils {

    private static List<Order> morderListData;

    static {
        initmorderListData();
    }

    private static void initmorderListData() {
        morderListData=new ArrayList<>();
        morderListData.add(new Order("handmade手工饰品工坊","http://img3.redocn.com/tupian/20150421/xiaohuakafeikafeibeibiankuangsucai_4013296.jpg",
                "Loozoo独创木制可爱电冰箱贴", 23,1));
        morderListData.add(new Order("localworld","http://www.taopic.com/uploads/allimg/140421/318743-140421213T910.jpg","local",
                22,12));
    }



    public static List<Order> getmorderListData() {
        return morderListData;
    }

}
