package com.localworld.ishop.model;

import java.util.Date;



public class Author {

    private Long   id;

    private String name;

    private String category_codes;

    private String username;

    private String phone;

    private String addres;

    private Date   created;

    private String head_piicture;

    int    sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory_codes() {
        return category_codes;
    }

    public void setCategory_codes(String category_codes) {
        this.category_codes = category_codes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getHead_piicture() {
        return head_piicture;
    }

    public void setHead_piicture(String head_piicture) {
        this.head_piicture = head_piicture;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
