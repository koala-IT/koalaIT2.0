package com.koalaIT.common.model;

import org.springframework.stereotype.Repository;

@Repository
public class Collect extends BaseDO{
    private Integer collectCheck;

    private String collectState;

    public Integer getCollectCheck() {
        return collectCheck;
    }

    public void setCollectCheck(Integer collectCheck) {
        this.collectCheck = collectCheck;
    }

    public String getCollectState() {
        return collectState;
    }

    public void setCollectState(String collectState) {
        this.collectState = collectState == null ? null : collectState.trim();
    }
}