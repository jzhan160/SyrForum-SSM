/////////////////////////////////////////////////////////////////////////////
// Topic.java   A JavaBean class which encapsulate Topic information       //
// ver 1.0                                                                 //
// Author: Biao A                                                          //
/////////////////////////////////////////////////////////////////////////////
/*
 * This package provides one Java class which is a JavaBean class encapsulating
 * Topic information.
 *
 * Maintenance History:
 * -------------------
 * May 4th
 * version 1.0
 *
 *
 * */
package com.forum.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Topic {
    private String Title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date CreateTime;
    private int Users_UserID;
    private String Contact;
    private String Address;
    private int TopicID;

    public int getTopicID() {
        return TopicID;
    }

    public void setTopicID(int id) {
        TopicID = id;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "Title='" + Title + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", Users_UserID=" + Users_UserID +
                ", Contact='" + Contact + '\'' +
                ", Address='" + Address + '\'' +
                ", ID=" + TopicID +
                '}';
    }

    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public Date getCreateTime() {
        return CreateTime;
    }
    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }
    public int getUsers_UserID() {
        return Users_UserID;
    }
    public void setUsers_UserID(int users_UserID) {
        Users_UserID = users_UserID;
    }
    public String getContact() {
        return Contact;
    }
    public void setContact(String contact) {
        Contact = contact;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
}
