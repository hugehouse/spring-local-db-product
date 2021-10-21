package com.test.whatap.paging;

import java.util.List;

public interface Page<T> {
    List<T> getEntityList();
    int getTotalPages();
    void setEntityList(List<T> list);
    void setTotalPages(int totalPages);
}
