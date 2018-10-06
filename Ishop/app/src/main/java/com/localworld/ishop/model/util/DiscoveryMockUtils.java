package com.localworld.ishop.model.util;

import com.localworld.ishop.model.IndexResponse;
import com.localworld.ishop.model.home.HomeCategoryBean;

import java.util.ArrayList;
import java.util.List;


public class DiscoveryMockUtils {
    private static List<IndexResponse> mockHomeDataList;
    private static List<HomeCategoryBean> mockIndexCategoryList;

    static {
        initTopCategoryData();
    }

    private static void initTopCategoryData() {
        mockIndexCategoryList = new ArrayList<>();
        HomeCategoryBean response1 = new HomeCategoryBean();
        response1.id = 1000L;
        response1.name = "特辑";
        HomeCategoryBean response2 = new HomeCategoryBean();
        response2.id = 1001L;
        response2.name = "流行";
        HomeCategoryBean response3 = new HomeCategoryBean();
        response3.id = 1002L;
        response3.name = "好友";
        mockIndexCategoryList.add(response1);
        mockIndexCategoryList.add(response2);
        mockIndexCategoryList.add(response3);
    }

    public static List<IndexResponse> getMockHomeDataList() {
        return mockHomeDataList;
    }

    public static List<HomeCategoryBean> getMockIndexCategoryList() {
        return mockIndexCategoryList;
    }

}
