package com.localworld.ishop.model.util;

import com.localworld.ishop.model.Order;

import java.util.ArrayList;
import java.util.List;

public class MoreUtils {

    private static List<Order> mockHomeDataList;

    static {
        initMockData();
    }
    private static void initMockData() {
        mockHomeDataList = new ArrayList<>();
        mockHomeDataList.add(new Order("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1080698572,1462149591&fm=27&gp=0.jpg",4003));
        mockHomeDataList.add(new Order("http://i.ebayimg.com/00/s/NTEwWDUxMA==/z/0KIAAOSwI-BWG2jz/$_1.JPG?set_id=880000500F",4003));
        mockHomeDataList.add(new Order("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=92934363,3498888770&fm=27&gp=0.jpg",4003));
        mockHomeDataList.add(new Order("http://imgqn.koudaitong.com/upload_files/2015/06/01/143315781003313013.jpg%21580x580.jpg",4003));
        mockHomeDataList.add(new Order("http://i.ebayimg.com/00/s/NTEwWDUxMA==/z/0KIAAOSwI-BWG2jz/$_1.JPG?set_id=880000500F",4003));
        mockHomeDataList.add(new Order("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1080698572,1462149591&fm=27&gp=0.jpg",4003));

    }

    public static List<Order> getMockHomeDataList() {
        return mockHomeDataList;
    }
}
