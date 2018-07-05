package com.forum.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Message {
    private Notification notification;
    private int itemId;
    private String itemName;
    private String commentContent;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date CreateTime;

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "notification=" + notification +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", CreateTime=" + CreateTime +
                '}';
    }
}
