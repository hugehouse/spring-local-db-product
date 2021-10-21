package com.test.whatap.database.product.crud;

import com.test.whatap.domain.Entity;

public interface CreateData<T> {
    T save(T t);
}
