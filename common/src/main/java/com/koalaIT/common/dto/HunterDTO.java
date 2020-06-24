package com.koalaIT.common.dto;

import com.koalaIT.common.model.Hunter;

public class HunterDTO extends Hunter {
    private String rdateStr;
    private String priceStr;
    private Integer pageSize;
    private Integer pageNum;
    private Boolean noPage;

    public String getRdateStr() {
        return rdateStr;
    }

    public void setRdateStr(String rdateStr) {
        this.rdateStr = rdateStr;
    }

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Boolean getNoPage() {
        return noPage;
    }

    public void setNoPage(Boolean noPage) {
        this.noPage = noPage;
    }
}
