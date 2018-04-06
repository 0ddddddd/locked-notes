package com.example.qiangqiang.ldnotebookapplication;

import java.io.Serializable;

/**
 * Created by qiangqiang on 2017/12/6.
 */

public class Note implements Serializable {
    private String title;
    private String content;
    private String create_time;
    private String pwd;
    private String isSet;

    public String getIsSet() {
        return isSet;
    }

    public void setIsSet(String isSet) {
        this.isSet = isSet;
    }

    //    public boolean isSet() {
//        return isSet;
//    }
//
//    public void setSet(boolean set) {
//        isSet = set;
//    }

    public Note(String title, String contnet, String create_time){
        this.title = title;
        this.content = contnet;
        this.create_time = create_time;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    public Note(){
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String contnet) {
        this.content = contnet;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

}

