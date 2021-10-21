package com.test.whatap.database.product.crud;

import com.test.whatap.domain.Product;
import com.test.whatap.paging.Page;

public interface ReadData {
    Page findAllDescById(int offset, int limit);
    Product findById(Long id);
}
