package com.localworld.ishop.model;

import java.util.Date;



public class ReceivedAddress {

    private Long id;

    private String mobile;

    private String province;

    private String city;

    private String address;

    private String receiver;

    private String postCode;

    private Boolean isDefault;

    private Date created;

    private Date updated;

    private Long userId;

    public int type;

    public ReceivedAddress(String mobile, String address, String receiver, String postCode) {
        this.mobile = mobile;
        this.address = address;
        this.receiver = receiver;
        this.postCode = postCode;
        this.type = 2001;
    }

    public ReceivedAddress(String mobile, String address, String receiver, String postCode, int type) {
        this.mobile = mobile;
        this.address = address;
        this.receiver = receiver;
        this.postCode = postCode;
        this.type = type;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
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
}
