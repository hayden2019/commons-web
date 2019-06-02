package com.github.commonweb.page;

import java.util.List;

public class PageResult<T> {
    long count;
    List<T> rows;

    public static <T> PageResult<T> make(long count, List<T> rows) {
        PageResult page = new PageResult<T>();
        page.setCount(count);
        page.setRows(rows);
        return page;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "count=" + count +
                ", rows=" + rows +
                '}';
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}