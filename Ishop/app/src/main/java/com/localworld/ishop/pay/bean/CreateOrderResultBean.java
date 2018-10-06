package com.localworld.ishop.pay.bean;

import java.io.Serializable;
import java.util.List;


public class CreateOrderResultBean implements Serializable {

    public String code;
    public String deliveryWayCode;
    public long id;
    public List<Order> orders;
    public long postFee;
    public float price;
    public int receiveAddressId;
    public String status;
    public long userId;

    public static class Order {
        public long goodsId;
        public int num;
        public float price;
        public String status;
        public long tradeId;
    }
}
