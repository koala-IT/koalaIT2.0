package com.koalaIT.common.model;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class Hunter extends BaseDO{
    private Integer hunterId;

    private Integer userId;

    private String capacity;

    private String hunterDetail;

    private String salary;

    private String company;

    private Boolean hunterState;

    private String hunterTitle;

    private String workTime;

    private String dailyWage;

    private String imgUrl;

    private Date createTime;

    private Integer orderboss;

    private Integer checkstate;

    public Integer getHunterId() {
        return hunterId;
    }

    public void setHunterId(Integer hunterId) {
        this.hunterId = hunterId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity == null ? null : capacity.trim();
    }

    public String getHunterDetail() {
        return hunterDetail;
    }

    public void setHunterDetail(String hunterDetail) {
        this.hunterDetail = hunterDetail == null ? null : hunterDetail.trim();
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Boolean getHunterState() {
        return hunterState;
    }

    public void setHunterState(Boolean hunterState) {
        this.hunterState = hunterState;
    }

    public String getHunterTitle() {
        return hunterTitle;
    }

    public void setHunterTitle(String hunterTitle) {
        this.hunterTitle = hunterTitle == null ? null : hunterTitle.trim();
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime == null ? null : workTime.trim();
    }

    public String getDailyWage() {
        return dailyWage;
    }

    public void setDailyWage(String dailyWage) {
        this.dailyWage = dailyWage == null ? null : dailyWage.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOrderboss() {
        return orderboss;
    }

    public void setOrderboss(Integer orderboss) {
        this.orderboss = orderboss;
    }

    public Integer getCheckstate() {
        return checkstate;
    }

    public void setCheckstate(Integer checkstate) {
        this.checkstate = checkstate;
    }
}