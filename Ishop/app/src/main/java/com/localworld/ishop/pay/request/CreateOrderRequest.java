package com.localworld.ishop.pay.request;

import java.io.Serializable;
import java.util.List;

/**
 * 生成订单的请求
 *
 * @author chenfeng
 * @since 2018-08-18 15:19
 */
public class CreateOrderRequest implements Serializable {

    public String deliveryWayCode;
    public long receiveAddressId;
    public List<Order> orders;

    public static class Order {
        public long goodsId;
        public int num;
    }
}
