package com.localworld.ishop.home.bean;

import java.util.List;


public class HomeBannersBean extends BaseHomeBean {

    public List<BannerBean> banners;
     public static class BannerBean {
          public String picPath;

          public String path;

          public long startTime;

          public long endTime;

          public long id;
     }

}
