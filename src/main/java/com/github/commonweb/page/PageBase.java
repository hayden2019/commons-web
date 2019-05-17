package com.github.commonweb.page;

public class PageBase {

    private static final Integer DEFAULT_PAGESIZE = 15;
    private static final Integer DEFAULT_PAGENUMBER = 1;


    Integer pageSize = DEFAULT_PAGESIZE;
    Integer pageNumber = DEFAULT_PAGENUMBER;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
