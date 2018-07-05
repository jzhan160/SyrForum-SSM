package com.forum.entity;

public class SlideInfo {
    private  String slideImg1;
    private  String slideImg2;
    private String category;


    public SlideInfo(String slideImg1, String slideImg2, String category) {
        this.slideImg1 = slideImg1;
        this.slideImg2 = slideImg2;
        this.category = category;
    }

    public String getSlideImg1() {
        return slideImg1;
    }

    public String getSlideImg2() {
        return slideImg2;
    }

    public String getCategory() {
        return category;
    }
}
