package com.test.whatap.paging;

public class PageInfo {
    int offset;
    int totalPages;
    int limit;

    public PageInfo(int offset, int totalPages, int limit) {
        this.offset = offset;
        this.totalPages = totalPages;
        this.limit = limit;
    }
}
