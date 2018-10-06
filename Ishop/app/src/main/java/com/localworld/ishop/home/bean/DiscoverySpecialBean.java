package com.localworld.ishop.home.bean;

import java.io.Serializable;
import java.util.List;


public class DiscoverySpecialBean extends BaseHomeBean implements Serializable{
    public int count;

    public List<SpecialBean> list;
    public class SpecialBean extends BaseHomeBean implements Serializable{
        public String code;
        public int id;
        public String imgUrl;
        public String name;
    }
}
