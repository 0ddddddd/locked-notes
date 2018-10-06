package com.localworld.ishop.message;

public class ChatObj {
    private String name;
    private int imageId;
    private String time;
    private String message;
    public boolean isSelect;
    public boolean isRead;

    public ChatObj(String name, int imageId, String time, String message) {
        this.name = name;
        this.imageId = imageId;
        this.time = time;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }
}
