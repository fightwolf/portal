package com.pab.framework.portal.utils.mybatis;

import java.io.Serializable;
import java.util.List;

public class Pagination<T> implements Serializable {
    private int count;
    private List<T> items;
    private int pageIndex;
    private int pageSize;

    public Pagination(int pageIndex, int pageSize, List<T> items, int count) {
        this.setCount(count);
        this.setItems(items);
        this.setPageIndex(pageIndex);
        this.setPageSize(pageSize);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}