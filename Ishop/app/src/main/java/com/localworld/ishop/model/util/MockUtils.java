package com.localworld.ishop.model.util;

import com.localworld.ishop.model.IndexResponse;
import com.localworld.ishop.model.home.HomeCategoryBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述
 *
 * @author chenfeng
 * @since 2017-12-02 13:39
 */

public class MockUtils {
    private static List<IndexResponse> mockHomeDataList;
    private static List<HomeCategoryBean> mockIndexCategoryList;

    static {
        initTopCategoryData();
        initMockData();
    }

    private static void initMockData() {
        mockHomeDataList = new ArrayList<>();
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131462490&di=b0cf6f0cde3a2982b028ed4ed6fe34f9&imgtype=jpg&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D3907283791%2C4038091709%26fm%3D214%26gp%3D0.jpg",1003));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131529258&di=6f206093c5dce5ab2946adf6a70d31cf&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20161216%2F09094e7370b34b309a3503f098d2c26a_th.jpeg", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131570272&di=1964b86f5bd153b446b2d8e08c7566a2&imgtype=0&src=http%3A%2F%2Fimg1.lukou.com%2Fstatic%2Fp%2Fblog%2Fmedium%2F0013%2F88%2F49%2F03%2F13884903.jpg", "星空二"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131624542&di=01b9f8971e123e05757accbc04ae0aa8&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20170829%2F89d7eefadf214156bee40af13a373254.jpeg", "星空三"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131681126&di=e1e3ea931088cfb1e3ad101cfc3453cb&imgtype=0&src=http%3A%2F%2Ftgi1.jia.com%2F120%2F330%2F20330550.jpg", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131462490&di=b0cf6f0cde3a2982b028ed4ed6fe34f9&imgtype=jpg&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D3907283791%2C4038091709%26fm%3D214%26gp%3D0.jpg", "星空三"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131529258&di=6f206093c5dce5ab2946adf6a70d31cf&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20161216%2F09094e7370b34b309a3503f098d2c26a_th.jpeg", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131570272&di=1964b86f5bd153b446b2d8e08c7566a2&imgtype=0&src=http%3A%2F%2Fimg1.lukou.com%2Fstatic%2Fp%2Fblog%2Fmedium%2F0013%2F88%2F49%2F03%2F13884903.jpg", "星空二"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131624542&di=01b9f8971e123e05757accbc04ae0aa8&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20170829%2F89d7eefadf214156bee40af13a373254.jpeg", "星空三"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131681126&di=e1e3ea931088cfb1e3ad101cfc3453cb&imgtype=0&src=http%3A%2F%2Ftgi1.jia.com%2F120%2F330%2F20330550.jpg", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131462490&di=b0cf6f0cde3a2982b028ed4ed6fe34f9&imgtype=jpg&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D3907283791%2C4038091709%26fm%3D214%26gp%3D0.jpg", "星空三"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131529258&di=6f206093c5dce5ab2946adf6a70d31cf&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20161216%2F09094e7370b34b309a3503f098d2c26a_th.jpeg", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131570272&di=1964b86f5bd153b446b2d8e08c7566a2&imgtype=0&src=http%3A%2F%2Fimg1.lukou.com%2Fstatic%2Fp%2Fblog%2Fmedium%2F0013%2F88%2F49%2F03%2F13884903.jpg", "星空二"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131624542&di=01b9f8971e123e05757accbc04ae0aa8&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20170829%2F89d7eefadf214156bee40af13a373254.jpeg", "星空三"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131681126&di=e1e3ea931088cfb1e3ad101cfc3453cb&imgtype=0&src=http%3A%2F%2Ftgi1.jia.com%2F120%2F330%2F20330550.jpg", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131752268&di=3dda50761e65b21865d6630a3360165d&imgtype=0&src=http%3A%2F%2Fimg2.wuhoo.cn%2Fi3%2F56151171%2FTB22UqSpstnpuFjSZFKXXalFFXa_%2521%252156151171.jpg_600x600.jpg", "星空二"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468830&di=3b5e6f8a2e121ca13a8f0de72d9c1f6c&src=http://i.weather.com.cn/images/cn/trip/2014/11/28/458FCDC98416F74A342D8E2615EEBA24.jpg", "星空三"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468463&di=58244daffe94e6ef6c5d9d5c1f988eb2&src=http%3A%2F%2Fphotos.tuchong.com%2F475435%2Fm%2F7537840.jpg", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468742&di=1d18406087026889b17457b5337e2aa6&src=http%3A%2F%2Fp7.qhimg.com%2Ft01dd9ae0e051b9e357.jpg", "星空二"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468830&di=3b5e6f8a2e121ca13a8f0de72d9c1f6c&src=http://i.weather.com.cn/images/cn/trip/2014/11/28/458FCDC98416F74A342D8E2615EEBA24.jpg", "星空三", 1002));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468463&di=58244daffe94e6ef6c5d9d5c1f988eb2&src=http%3A%2F%2Fphotos.tuchong.com%2F475435%2Fm%2F7537840.jpg", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468742&di=1d18406087026889b17457b5337e2aa6&src=http%3A%2F%2Fp7.qhimg.com%2Ft01dd9ae0e051b9e357.jpg", "星空二", 1002));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468830&di=3b5e6f8a2e121ca13a8f0de72d9c1f6c&src=http://i.weather.com.cn/images/cn/trip/2014/11/28/458FCDC98416F74A342D8E2615EEBA24.jpg", "星空三"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468463&di=58244daffe94e6ef6c5d9d5c1f988eb2&src=http%3A%2F%2Fphotos.tuchong.com%2F475435%2Fm%2F7537840.jpg", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468742&di=1d18406087026889b17457b5337e2aa6&src=http%3A%2F%2Fp7.qhimg.com%2Ft01dd9ae0e051b9e357.jpg", "星空二"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468830&di=3b5e6f8a2e121ca13a8f0de72d9c1f6c&src=http://i.weather.com.cn/images/cn/trip/2014/11/28/458FCDC98416F74A342D8E2615EEBA24.jpg", "星空三"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468463&di=58244daffe94e6ef6c5d9d5c1f988eb2&src=http%3A%2F%2Fphotos.tuchong.com%2F475435%2Fm%2F7537840.jpg", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468742&di=1d18406087026889b17457b5337e2aa6&src=http%3A%2F%2Fp7.qhimg.com%2Ft01dd9ae0e051b9e357.jpg", "星空二"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468830&di=3b5e6f8a2e121ca13a8f0de72d9c1f6c&src=http://i.weather.com.cn/images/cn/trip/2014/11/28/458FCDC98416F74A342D8E2615EEBA24.jpg", "星空三", 1002));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468463&di=58244daffe94e6ef6c5d9d5c1f988eb2&src=http%3A%2F%2Fphotos.tuchong.com%2F475435%2Fm%2F7537840.jpg", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468742&di=1d18406087026889b17457b5337e2aa6&src=http%3A%2F%2Fp7.qhimg.com%2Ft01dd9ae0e051b9e357.jpg", "星空二", 1002));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468830&di=3b5e6f8a2e121ca13a8f0de72d9c1f6c&src=http://i.weather.com.cn/images/cn/trip/2014/11/28/458FCDC98416F74A342D8E2615EEBA24.jpg", "星空三"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468463&di=58244daffe94e6ef6c5d9d5c1f988eb2&src=http%3A%2F%2Fphotos.tuchong.com%2F475435%2Fm%2F7537840.jpg", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468742&di=1d18406087026889b17457b5337e2aa6&src=http%3A%2F%2Fp7.qhimg.com%2Ft01dd9ae0e051b9e357.jpg", "星空二"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468830&di=3b5e6f8a2e121ca13a8f0de72d9c1f6c&src=http://i.weather.com.cn/images/cn/trip/2014/11/28/458FCDC98416F74A342D8E2615EEBA24.jpg", "星空三"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468463&di=58244daffe94e6ef6c5d9d5c1f988eb2&src=http%3A%2F%2Fphotos.tuchong.com%2F475435%2Fm%2F7537840.jpg", "星空1", 1002));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468742&di=1d18406087026889b17457b5337e2aa6&src=http%3A%2F%2Fp7.qhimg.com%2Ft01dd9ae0e051b9e357.jpg", "星空二"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468830&di=3b5e6f8a2e121ca13a8f0de72d9c1f6c&src=http://i.weather.com.cn/images/cn/trip/2014/11/28/458FCDC98416F74A342D8E2615EEBA24.jpg", "星空三"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468463&di=58244daffe94e6ef6c5d9d5c1f988eb2&src=http%3A%2F%2Fphotos.tuchong.com%2F475435%2Fm%2F7537840.jpg", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468742&di=1d18406087026889b17457b5337e2aa6&src=http%3A%2F%2Fp7.qhimg.com%2Ft01dd9ae0e051b9e357.jpg", "星空二"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468830&di=3b5e6f8a2e121ca13a8f0de72d9c1f6c&src=http://i.weather.com.cn/images/cn/trip/2014/11/28/458FCDC98416F74A342D8E2615EEBA24.jpg", "星空三"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468463&di=58244daffe94e6ef6c5d9d5c1f988eb2&src=http%3A%2F%2Fphotos.tuchong.com%2F475435%2Fm%2F7537840.jpg", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468742&di=1d18406087026889b17457b5337e2aa6&src=http%3A%2F%2Fp7.qhimg.com%2Ft01dd9ae0e051b9e357.jpg", "星空二"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468830&di=3b5e6f8a2e121ca13a8f0de72d9c1f6c&src=http://i.weather.com.cn/images/cn/trip/2014/11/28/458FCDC98416F74A342D8E2615EEBA24.jpg", "星空三"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468463&di=58244daffe94e6ef6c5d9d5c1f988eb2&src=http%3A%2F%2Fphotos.tuchong.com%2F475435%2Fm%2F7537840.jpg", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468742&di=1d18406087026889b17457b5337e2aa6&src=http%3A%2F%2Fp7.qhimg.com%2Ft01dd9ae0e051b9e357.jpg", "星空二"));

        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468830&di=3b5e6f8a2e121ca13a8f0de72d9c1f6c&src=http://i.weather.com.cn/images/cn/trip/2014/11/28/458FCDC98416F74A342D8E2615EEBA24.jpg", "星空三",1003));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468463&di=58244daffe94e6ef6c5d9d5c1f988eb2&src=http%3A%2F%2Fphotos.tuchong.com%2F475435%2Fm%2F7537840.jpg", "星空1"));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468742&di=1d18406087026889b17457b5337e2aa6&src=http%3A%2F%2Fp7.qhimg.com%2Ft01dd9ae0e051b9e357.jpg", "星空二",1003));
        mockHomeDataList.add(new IndexResponse("https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1510468830&di=3b5e6f8a2e121ca13a8f0de72d9c1f6c&src=http://i.weather.com.cn/images/cn/trip/2014/11/28/458FCDC98416F74A342D8E2615EEBA24.jpg", "星空三",1003));
    }

    private static void initTopCategoryData() {
        mockIndexCategoryList = new ArrayList<>();
        HomeCategoryBean response1 = new HomeCategoryBean();
        response1.id = 1000L;
        response1.name = "潮品";
        HomeCategoryBean response2 = new HomeCategoryBean();
        response2.id = 1001L;
        response2.name = "首页";
        HomeCategoryBean response3 = new HomeCategoryBean();
        response3.id = 1002L;
        response3.name = "手链";
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
