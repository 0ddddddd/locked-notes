package com.localworld.ishop.setting.bean;

/**
 * 文件描述
 *
 * @author chenmiyang
 * @since 2018-08-07 15:32
 */
public class MyHomePageBean {
    public String homePagePic;
    public String homePageName;
    public String fansNum;
    public String articleNum;
    public String followNum;
    public String img;
    public boolean delete;

    public boolean isDelete(){
        return delete;
    }

    public void setDelete(boolean bool){
        delete=bool;
    }
}
