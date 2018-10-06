package com.localworld.ishop.model;

import java.io.Serializable;


public class GoodsResponse implements Serializable {

    public String imgUrl;
    public String userName;
    public String goodsName;
    public String goodsType;
    public String comment;
    public int type;

    public GoodsResponse(String imgUrl) {
        this.imgUrl = imgUrl;
        this.type = 2001;
    }

    public GoodsResponse(String imgUrl, String userName, String goodsName, String goodsType, String comment, int type) {
        this.imgUrl = imgUrl;
        this.userName = userName;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.comment = comment;
        this.type = type;
    }
}
