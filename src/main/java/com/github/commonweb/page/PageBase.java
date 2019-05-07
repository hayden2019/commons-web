package com.github.commonweb.page;

public class PageBase {

    private static final Integer DEFAULTPAGESIZE = 15;

    private static final Integer DEFAULTPAGENUM = 1;


    Integer pageIndex=DEFAULTPAGENUM;
    Integer pageNumber =DEFAULTPAGESIZE;
    Integer offset = 0;


    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
        this.offset = this.getOffset();
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        this.offset = this.getOffset();
    }

    public Integer getOffset() {
        if (pageIndex == null || pageIndex < 1) {
            pageIndex = DEFAULTPAGENUM;
        }

        if (pageNumber == null || pageNumber <= 0) {
            pageNumber = DEFAULTPAGESIZE;
        }

        return (pageIndex-1)* pageNumber;
    }
}
