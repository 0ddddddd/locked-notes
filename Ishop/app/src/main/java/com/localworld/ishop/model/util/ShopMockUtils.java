package com.localworld.ishop.model.util;

import com.localworld.ishop.model.Order;

import java.util.List;

public class ShopMockUtils {
    private static List<Order> mockHomeDataList;

    static {
        initMockData();
    }

    private static void initMockData() {
        /*mockHomeDataList = new ArrayList<>();
        mockHomeDataList.add(new Order("HandMade手工饰品工坊","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522419748670&di=d11cafc60e6bd7bde793d5c6129132fc&imgtype=0&src=http%3A%2F%2Fwww.hkbtv.cn%2Fupload%2Farticle%2F1%2F2017%2F06%2F19%2F0mbmqffusb5.jpg", "Loozoo独创木制可爱冰箱贴",47.0,2,4002,true,false,false));
        mockHomeDataList.add(new Order("HandMade手工饰品工坊","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522419888312&di=ccb9699c20dfa8642fb84d72aa1d83ae&imgtype=0&src=http%3A%2F%2Fimg.mp.sohu.com%2Fupload%2F20170718%2F2aedd83294f94afd8e597556c312a5c2_th.png", "针织布制品小熊挂件",129.0,1,4002,false,false,false));
        mockHomeDataList.add(new Order("pearl之家","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522419748670&di=d11cafc60e6bd7bde793d5c6129132fc&imgtype=0&src=http%3A%2F%2Fwww.hkbtv.cn%2Fupload%2Farticle%2F1%2F2017%2F06%2F19%2F0mbmqffusb5.jpg", "珍珠方块个性小巧耳环",88.0,4,4002,true,false,false));
        mockHomeDataList.add(new Order("小呆家","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522419888312&di=ccb9699c20dfa8642fb84d72aa1d83ae&imgtype=0&src=http%3A%2F%2Fimg.mp.sohu.com%2Fupload%2F20170718%2F2aedd83294f94afd8e597556c312a5c2_th.png", "蝴蝶结个性小巧耳钉",108.0,3,4002,true,false,false));*/
    }

    public static List<Order> getMockHomeDataList() {
        return mockHomeDataList;
    }
}
