package com.koalaIT.common.model;

import org.springframework.stereotype.Repository;

@Repository
public class Hunterconnect extends BaseDO{
    private Integer cid;

    private Integer hunterId;

    private Integer userId;

    private Integer check;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

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

    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }
}