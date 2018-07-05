//////////////////////////////////////////////////////////////////////////////////////////////////
// ItemInfo.java   A JavaBean class which encapsulate information to display for each item      //
// ver 1.0                                                                                      //
// Author: Jiacheng Zhang                                                                       //
/////////////////////////////////////////////////////////////////////////////////////////////////
/*
 * This package provides one Java class which is a JavaBean class which
 * encapsulate information to display for each item.
 *
 * Maintenance History:
 * -------------------
 * May 4th
 * version 1.0
 *
 *
 * */
package com.forum.entity;

import java.util.Date;
import java.util.List;

public class ItemInfo{
    private Item item;
    private String userName;
    private Date createTime;
    private List<Comment> comments;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ItemInfo{" +
                "item=" + item +
                ", userName='" + userName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", commentCount=" + comments.size() +
                '}';
    }
}
