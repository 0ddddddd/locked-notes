package com.localworld.ishop.home.bean;

import java.util.List;


public class HomeAuthorRecommendBean extends BaseHomeBean {

    public List<AuthorBean> authors;

    public static class AuthorBean{
        public String authorPic;

        public String name;

        public long id;
    }

}
