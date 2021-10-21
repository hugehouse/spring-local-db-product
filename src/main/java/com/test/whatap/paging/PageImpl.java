package com.test.whatap.paging;

import com.test.whatap.domain.Product;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class PageImpl implements Page<Product> {
    List<Product> products;
    int totalPages = 0;

    @Override
    public List<Product> getEntityList() {
        return products;
    }

    @Override
    public int getTotalPages() {
        return totalPages;
    }

    @Override
    public void setEntityList(List<Product> list) {
        this.products = list;
    }

    @Override
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
