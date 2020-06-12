package com.koalaIT.common.model;

import org.springframework.stereotype.Repository;

@Repository
public class SysLogKey extends BaseDO{
    private Integer logid;

    private String ie;

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie == null ? null : ie.trim();
    }
}