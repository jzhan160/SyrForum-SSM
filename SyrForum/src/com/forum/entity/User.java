/////////////////////////////////////////////////////////////////////////////
// User.java   A JavaBean class which encapsulate User information         //
// ver 1.0                                                                 //
// Author: Biao A                                                          //
/////////////////////////////////////////////////////////////////////////////
/*
 * This package provides one Java class which is a JavaBean class encapsulating
 * user information.
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

public class User{
    private String UserName;
    private String UserPassword;
    private String Email;
    private String Gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date UserBirthday;
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date CreateTime;
    private int IsAdmin;
    private int UserID;
    private int ImageID;

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        UserID = UserID;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", UserPassword='" + UserPassword + '\'' +
                ", Email='" + Email + '\'' +
                ", Gender='" + Gender + '\'' +
                ", UserBirthday='" + UserBirthday + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", IsAdmin=" + IsAdmin +
                ", UserID=" + UserID +
                ", ImageID=" + ImageID +
                '}';
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Date getUserBirthday() {
        return UserBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        UserBirthday = userBirthday;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    public int getIsAdmin() {
        return IsAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        IsAdmin = isAdmin;
    }
}
