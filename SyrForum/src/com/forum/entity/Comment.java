package com.forum.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Comment{
    private int CommentID;
    private int ItemID;
    private String Content;
    private int Users_UserID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date CreateTime;


    public int getCommentID() {
        return CommentID;
    }

    public void setCommentID(int id) {
        CommentID = id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "CommentID=" + CommentID +
                ", ItemID=" + ItemID +
                ", Content='" + Content + '\'' +
                ", Users_UserID=" + Users_UserID +
                ", CreateTime=" + CreateTime +
                '}';
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getUsers_UserID() {
        return Users_UserID;
    }

    public void setUsers_UserID(int users_UserID) {
        Users_UserID = users_UserID;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }
}
