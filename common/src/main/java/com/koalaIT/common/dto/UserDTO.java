package com.koalaIT.common.dto;

import com.koalaIT.common.model.User;

public class UserDTO extends User {
    private String cc;

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
}
