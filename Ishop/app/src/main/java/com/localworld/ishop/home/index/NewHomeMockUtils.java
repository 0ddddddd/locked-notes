package com.localworld.ishop.home.index;

import com.localworld.ishop.home.bean.BaseHomeBean;
import com.localworld.ishop.home.bean.HomeAuthorRecommendBean;
import com.localworld.ishop.home.bean.HomeBannersBean;
import com.localworld.ishop.home.bean.HomeGoodsBean;

import java.util.ArrayList;
import java.util.List;



public class NewHomeMockUtils {

    private static List<BaseHomeBean> testDataList = new ArrayList<>();

    public static List<BaseHomeBean> getList(){

        testDataList.clear();
//        HomeBannersBean.Banner banner1 = new HomeBannersBean.Banner()
//        HomeBannersBean bannersBean = new HomeBannersBean();
//        bannersBean.banner = ;


        HomeBannersBean.BannerBean item1=new HomeBannersBean.BannerBean();
        item1.picPath="http://pic.616pic.com/bg_w1180/00/03/92/5XuT1F9vhD.jpg!/fw/1120";
        HomeBannersBean.BannerBean item2=new HomeBannersBean.BannerBean();
        item2.picPath="http://pic.616pic.com/ys_b_img/00/03/66/elaoZXSgtd.jpg";
        HomeBannersBean.BannerBean item3=new HomeBannersBean.BannerBean();
        item3.picPath="http://pic.616pic.com/bg_w1180/00/03/84/jpyygcIg8b.jpg!/fw/1120";

        List<HomeBannersBean.BannerBean> bannerBeansList = new ArrayList<>();
        bannerBeansList.add(item1);
        bannerBeansList.add(item2);
        bannerBeansList.add(item3);

        HomeBannersBean mbannersBeans = new HomeBannersBean();
        mbannersBeans.frontType = BaseHomeBean.HEAD_BANNER_TYPE_SLIDE;
        mbannersBeans.banners = bannerBeansList;
        testDataList.add(mbannersBeans);

        HomeGoodsBean item101 = new HomeGoodsBean();
        item101.frontType = BaseHomeBean.DOUBLE_ROW_GOODS_TYPE;
        item101.contentPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item101.title = "测试1";
        item101.authorname="Beethoven";
        item101.mutualfriends="1个共同的朋友";

        HomeGoodsBean item102 = new HomeGoodsBean();
        item102.contentPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item102.title = "测试22";
        item102.frontType = BaseHomeBean.DOUBLE_ROW_GOODS_TYPE;
        item102.authorname="Beethoven";
        item102.mutualfriends="1个共同的朋友";


        HomeGoodsBean item103 = new HomeGoodsBean();
        item103.contentPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item103.title = "测试33";
        item103.frontType = BaseHomeBean.DOUBLE_ROW_GOODS_TYPE;
        item103.authorname="Beethoven";
        item103.mutualfriends="1个共同的朋友";


        HomeGoodsBean item104 = new HomeGoodsBean();
        item104.contentPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item104.title = "测试1220";
        item104.frontType = BaseHomeBean.DOUBLE_ROW_GOODS_TYPE;
        item104.authorname="Beethoven";
        item104.mutualfriends="1个共同的朋友";


        testDataList.add(item101);
        testDataList.add(item102);
        testDataList.add(item103);
        testDataList.add(item104);

        BaseHomeBean section = new BaseHomeBean();
        section.frontType = BaseHomeBean.AUTHOR_SECTION_TYPE;

        HomeAuthorRecommendBean.AuthorBean item1001 = new HomeAuthorRecommendBean.AuthorBean();
        item1001.authorPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item1001.name = "test1";

        HomeAuthorRecommendBean.AuthorBean item1002 = new HomeAuthorRecommendBean.AuthorBean();
        item1002.authorPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item1002.name = "test2";

        HomeAuthorRecommendBean.AuthorBean item1003 = new HomeAuthorRecommendBean.AuthorBean();
        item1003.authorPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item1003.name = "test3";

        HomeAuthorRecommendBean.AuthorBean item1004 = new HomeAuthorRecommendBean.AuthorBean();
        item1004.authorPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item1004.name = "test4";

        HomeAuthorRecommendBean.AuthorBean item1005 = new HomeAuthorRecommendBean.AuthorBean();
        item1005.authorPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item1005.name = "test5";

        HomeAuthorRecommendBean.AuthorBean item1006 = new HomeAuthorRecommendBean.AuthorBean();
        item1006.authorPic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522131503674&di=9c03e43cbe9e30cf6b595400fc5c0799&imgtype=0&src=http%3A%2F%2Fg1.hexun.com%2F2017-05-05%2F189067528.png";
        item1006.name = "test6";

        List<HomeAuthorRecommendBean.AuthorBean> horizontalList = new ArrayList<>();
        horizontalList.add(item1001);
        horizontalList.add(item1002);
        horizontalList.add(item1003);
        horizontalList.add(item1004);
        horizontalList.add(item1005);
        horizontalList.add(item1006);

        HomeAuthorRecommendBean testHorizontalBean = new HomeAuthorRecommendBean();
        testHorizontalBean.frontType = BaseHomeBean.HORIZONTAL_DISPLAY_TYPE;
        testHorizontalBean.authors = horizontalList;

        testDataList.add(section);
        testDataList.add(testHorizontalBean);


        return testDataList;
    }
}
