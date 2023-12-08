package com.example.market;

import java.time.LocalDateTime;
import java.util.Date;

public class MarketVO {
    private int id;
    private String photoURL;
    private String title;
    private String email;
    private String password;
    private int price;
    private String content;
    private String howPurchase;
    private LocalDateTime createTime;
    private LocalDateTime exposeTime;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getExposeTime() {
        return exposeTime;
    }

    public void setExposeTime(LocalDateTime exposeTime) {
        this.exposeTime = exposeTime;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }
}
