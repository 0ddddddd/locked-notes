package com.localworld.ishop.model;

import java.util.Date;
import java.util.List;



public class Trade {

    private Long id;

    private Double price;

    private Double postFee;

    private String deliveryWayCode;

    private String outSid;

    private Date created;

    private Date payed;

    private Date updated;

    private Long userId;

    private String status;

    private String refundStatus;

    private String code;

    private String remark;

    private Long receiveAddressId;

    private Long authorId;

    private List<Order> orders;

    public Date getPayed() {
        return payed;
    }

    public void setPayed(Date payed) {
        this.payed = payed;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPostFee() {
        return postFee;
    }

    public void setPostFee(Double postFee) {
        this.postFee = postFee;
    }

    public String getDeliveryWayCode() {
        return deliveryWayCode;
    }

    public void setDeliveryWayCode(String deliveryWayCode) {
        this.deliveryWayCode = deliveryWayCode;
    }

    public String getOutSid() {
        return outSid;
    }

    public void setOutSid(String outSid) {
        this.outSid = outSid;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getReceiveAddressId() {
        return receiveAddressId;
    }

    public void setReceiveAddressId(Long receiveAddressId) {
        this.receiveAddressId = receiveAddressId;
    }
}
