package com.fushi.util;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;


public class PaginationRequest {
    private Integer pageNumber;

    private Integer pageSize;

    private String keyText;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyText() {
        return keyText;
    }

    public void setKeyText(String keyText) {
        this.keyText = keyText;
    }
}
