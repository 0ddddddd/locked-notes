package com.localworld.ishop.home.bean;

import java.io.Serializable;
import java.util.List;

public class DiscoveryPopularityBean extends BaseHomeBean implements Serializable{

    public List<PopularityBean> list;
    public class PopularityBean extends BaseHomeBean implements Serializable{
        public long authorId;
        public long availStock;
        public long categoryId;
        public String contentPic;
        public String contentPics;
        public long created;
        public String desc;
        public String headPics;
        public long id;
        public int lockStock;
        public String outerId;
        public double price;
        public int status;
        public String title;
        public long updatad;
        public int weight;
    }
}
