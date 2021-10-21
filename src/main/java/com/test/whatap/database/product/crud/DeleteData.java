package com.test.whatap.database.product.crud;

import com.test.whatap.domain.Product;

public interface DeleteData<T> {
    void delete(T t);
}
