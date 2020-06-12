package com.koalaIT.common.model;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class Boss extends BaseDO{
    private Integer bossId;

    private String bossDetail;

    private Integer userId;

    private String limitedTime;

    private String price;

    private String dailyWage;

    private Date createTime;

    private String bossTitle;

    private Integer bossState;

    private String imgUrl;

    private Integer orderhunter;

    private Integer checkstate;

    public Integer getBossId() {
        return bossId;
    }

    public void setBossId(Integer bossId) {
        this.bossId = bossId;
    }

    public String getBossDetail() {
        return bossDetail;
    }

    public void setBossDetail(String bossDetail) {
        this.bossDetail = bossDetail == null ? null : bossDetail.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLimitedTime() {
        return limitedTime;
    }

    public void setLimitedTime(String limitedTime) {
        this.limitedTime = limitedTime == null ? null : limitedTime.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getDailyWage() {
        return dailyWage;
    }

    public void setDailyWage(String dailyWage) {
        this.dailyWage = dailyWage == null ? null : dailyWage.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBossTitle() {
        return bossTitle;
    }

    public void setBossTitle(String bossTitle) {
        this.bossTitle = bossTitle == null ? null : bossTitle.trim();
    }

    public Integer getBossState() {
        return bossState;
    }

    public void setBossState(Integer bossState) {
        this.bossState = bossState;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Integer getOrderhunter() {
        return orderhunter;
    }

    public void setOrderhunter(Integer orderhunter) {
        this.orderhunter = orderhunter;
    }

    public Integer getCheckstate() {
        return checkstate;
    }

    public void setCheckstate(Integer checkstate) {
        this.checkstate = checkstate;
    }
}