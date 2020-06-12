package com.koalaIT.common.model;

import org.springframework.stereotype.Repository;

@Repository
public class Checkconnect extends BaseDO{
    private Integer check;

    private String state;

    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}