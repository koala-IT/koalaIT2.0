package com.koalaIT.common.vo;

import com.koalaIT.common.model.Hunter;

public class HunterVO extends Hunter {
    private String rflagStr;
    private String rdateStr;
    private String sname;
    private String cname;

    public String getRflagStr() {
        return rflagStr;
    }

    public void setRflagStr(String rflagStr) {
        this.rflagStr = rflagStr;
    }

    public String getRdateStr() {
        return rdateStr;
    }

    public void setRdateStr(String rdateStr) {
        this.rdateStr = rdateStr;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
