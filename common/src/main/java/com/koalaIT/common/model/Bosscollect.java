package com.koalaIT.common.model;

import org.springframework.stereotype.Repository;

@Repository
public class Bosscollect extends BaseDO{
    private Integer collectId;

    private Integer bossId;

    private Integer userId;

    private Integer collectState;

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getBossId() {
        return bossId;
    }

    public void setBossId(Integer bossId) {
        this.bossId = bossId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCollectState() {
        return collectState;
    }

    public void setCollectState(Integer collectState) {
        this.collectState = collectState;
    }
}