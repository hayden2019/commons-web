package com.github.commonweb.page;

public class PageBase {

    private static final Integer DEFAULT_PAGESIZE = 15;
    private static final Integer DEFAULT_PAGE_NUMBER = 1;


    Integer pageSize = DEFAULT_PAGESIZE;
    Integer pageNumber = DEFAULT_PAGE_NUMBER;

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
