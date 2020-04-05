package com.fushi.util;

import java.util.List;

public class PaginationResponse<T> {
    private List<T> list;
    private Integer total;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
