package com.localworld.ishop.cart.bean;

import java.util.List;

/**
 * 确认支付主页面的bean
 *
 * @author chenmiyang
 * @since 2018-08-10 14:13
 */
public class PaymentBean {
    public String man;
    public String mail;
    public String address;
    public String phoneNumber;
    public String discountPrice;
    public String finalPrice;
    public List<PaymentItemBean> itemBeanList;
}
