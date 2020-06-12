package com.koalaIT.common.model;

import org.springframework.stereotype.Repository;

@Repository
public class Manager extends BaseDO{
    private Integer managerId;

    private String password;

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}