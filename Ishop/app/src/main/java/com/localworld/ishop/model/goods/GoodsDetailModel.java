package com.localworld.ishop.model.goods;

import android.support.annotation.Keep;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jx on 2018/1/29.
 */

@Keep
public class GoodsDetailModel implements Serializable {

    public List<Comment> goodsCommentList;


    public GoodsBean goods;

    public static class GoodsBean implements Serializable {

        public String id;

        public String title;

        public String outerId;

        public double price;

        public double postFee;

        public long authorId;

        public long categoryId;

        public Integer status;

        public String headPics;

        public String contentPics;

        public String desc;

        public String created;

        public String updated;

        public int availStock;

        public int lockStock;

        public int weight;

    }

}
