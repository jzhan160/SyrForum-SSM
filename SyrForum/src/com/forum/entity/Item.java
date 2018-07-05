///////////////////////////////////////////////////////////////////////
// Item.java   A JavaBean class which encapsulate item information   //
// ver 1.0                                                           //
// Author: Biao A                                                    //
///////////////////////////////////////////////////////////////////////
/*
 * This package provides one Java class which is a JavaBean class encapsulating
 * item information.
 *
 * Maintenance History:
 * -------------------
 * May 4th
 * version 1.0
 *
 *
 * */
package com.forum.entity;

public class Item{
    private String ItemName;
    private String Description;
    private int CatID;
    private String ImagePath;
    private int TopicID;
    private double Price;
    private int ItemID;
    private int ReadingTimes;

    public int getReadingTimes() {
        return ReadingTimes;
    }

    public void setReadingTimes(int readingTimes) {
        this.ReadingTimes = readingTimes;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int ItemsID) {
        this.ItemID = ItemID;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ItemName='" + ItemName + '\'' +
                ", Description='" + Description + '\'' +
                ", CatID=" + CatID +
                ", ImagePath='" + ImagePath + '\'' +
                ", TopicID=" + TopicID +
                ", Price=" + Price +
                ", ItemID=" + ItemID +
                ", readingTimes=" + ReadingTimes +
                '}';
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getCatID() {
        return CatID;
    }

    public void setCatID(int catID) {
        CatID = catID;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public int getTopicID() {
        return TopicID;
    }

    public void setTopicID(int topicID) {
        TopicID = topicID;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
