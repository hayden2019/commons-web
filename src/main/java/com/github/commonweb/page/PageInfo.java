package com.github.commonweb.page;

import java.util.List;

public class PageInfo<T> {
    Integer count;
    List<T> rows;

    public static <T> PageInfo<T> make(Integer count, List<T> rows) {
        PageInfo page = new PageInfo<T>();
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}