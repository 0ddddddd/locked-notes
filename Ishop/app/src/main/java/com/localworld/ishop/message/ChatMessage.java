package com.localworld.ishop.message;

public class ChatMessage {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    public String content;
    private int type;
    private Long time;
    private int imageId;
    private String chatobj;

    public ChatMessage(String content, int type ,Long time,int imageId) {
        this.content = content;
        this.type = type;
        this.time = time;
        this.imageId = imageId;

    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

    public int getImageId() {
        return imageId;
    }

    public String getChatobj() {
        return chatobj;
    }

    public Long getTime() {
        return time;
    }


}