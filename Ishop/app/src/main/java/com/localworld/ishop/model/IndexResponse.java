package com.localworld.ishop.model;

import java.io.Serializable;



public class IndexResponse implements Serializable {
    public String imgUrl;
    public String text;
    public int type;

    public IndexResponse(String url, String text) {
        this.imgUrl = url;
        this.text = text;
        this.type = 1001;
    }

    public IndexResponse(String url, String text, int type) {
        this.imgUrl = url;
        this.text = text;
        this.type = type;
    }

    public IndexResponse(String imgUrl, int type) {
        this.imgUrl = imgUrl;
        this.type = type;
    }
}
