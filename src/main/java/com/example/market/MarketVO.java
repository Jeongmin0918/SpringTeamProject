package com.example.market;

import java.util.Date;

public class MarketVO {
    private int id;
    private String photoURL;
    private String title;
    private String writer;
    private int price;
    private String content;
    private String howPurchase;
    private Date createTime;
    private Date exposeTime;
    private int viewCnt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHowPurchase() {
        return howPurchase;
    }

    public void setHowPurchase(String howPurchase) {
        this.howPurchase = howPurchase;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExposeTime() {
        return exposeTime;
    }

    public void setExposeTime(Date exposeTime) {
        this.exposeTime = exposeTime;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }
}
