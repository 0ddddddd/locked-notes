package com.localworld.ishop.model.util;

import com.localworld.ishop.model.GoodsResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 *
 * @author Even.P
 * @since 2018/4/14 14:46
 */
public class GoodsMockUtils {

    private static List<GoodsResponse> mockGoodsDataList;
    private static List<GoodsResponse> mockGoodsEvaluationList;

    static {
        initMockData();
    }

    private static void initMockData(){
        mockGoodsDataList = new ArrayList<>();
        mockGoodsDataList.add(new GoodsResponse("http://img1.lukou.com/static/p/blog/medium/0013/97/85/05/13978505.jpg"));
        mockGoodsDataList.add(new GoodsResponse("http://img1.lukou.com/static/p/blog/medium/0013/97/85/05/13978505.jpg"));
        mockGoodsDataList.add(new GoodsResponse("http://img.mp.sohu.com/upload/20170704/a535b30aa1e14b0b934c8dbd6e75d3a2_th.png"));
//        mockGoodsDataList.add(new GoodsResponse(""));
        mockGoodsEvaluationList= new ArrayList<>();
        mockGoodsEvaluationList.add(new GoodsResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523700575660&di=3d052040824766c8cbc26a849cb9deef&imgtype=0&src=http%3A%2F%2Fimg1.lukou.com%2Fstatic%2Fp%2Fblog%2Fmedium%2F0013%2F88%2F48%2F99%2F13884899.jpg","niming","手工耳钉","red","终于收到我需要的宝贝了，东西很好，价美物廉，谢谢掌柜的！说实在，这是我淘宝购物来让我最满意的一次购物。无论是掌柜的态度还是对物品，我都非常满意的。",2002));
        mockGoodsEvaluationList.add(new GoodsResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523700575660&di=3d052040824766c8cbc26a849cb9deef&imgtype=0&src=http%3A%2F%2Fimg1.lukou.com%2Fstatic%2Fp%2Fblog%2Fmedium%2F0013%2F88%2F48%2F99%2F13884899.jpg","王小明","手工耳钉","blue","说实在，这是我淘宝购物来让我最满意的一次购物。无论是掌柜的态度还是对物品，我都非常满意的。",2002));

    }

    public static List<GoodsResponse> getMockGoodsDataList() {
        return mockGoodsDataList;
    }

    public static List<GoodsResponse> getMockGoodsEvaluationList() {
        return mockGoodsEvaluationList;
    }
}
