package com.localworld.ishop.model;



public class LogiStik {
    String data;
    String time;
    String status;
    String comment;

    public LogiStik(String data,String time,String status,String comment){
        this.data=data;
        this.time=time;
        this.status=status;
        this.comment=comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
