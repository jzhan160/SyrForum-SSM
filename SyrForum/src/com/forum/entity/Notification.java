///////////////////////////////////////////////////////////////////////////////////////////
// Notification.java   A JavaBean class which encapsulate Notification information       //
// ver 1.0                                                                               //
// Author: Jiacheng Zhang                                                                //
//////////////////////////////////////////////////////////////////////////////////////////
/*
 * This package provides one Java class which is a JavaBean class encapsulating
 * Notification information.
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

public class Notification{
    private int NoteID;
    private int UserID;
    private int CommentID;
    private String Author;
    private boolean Viewed;

    public int getNoteID() {
        return NoteID;
    }

    public void setNoteID(int noteID) {
        NoteID = noteID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getCommentID() {
        return CommentID;
    }

    public void setCommentID(int commentID) {
        CommentID = commentID;
    }

    public String getAuthor() {
        return Author;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "NoteID=" + NoteID +
                ", UserID=" + UserID +
                ", CommentID=" + CommentID +
                ", Author='" + Author + '\'' +
                ", Viewed=" + Viewed +
                '}';
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public boolean isViewed() {
        return Viewed;
    }

    public void setViewed(boolean viewed) {
        Viewed = viewed;
    }
}
