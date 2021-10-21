package com.test.whatap.database.product;

import com.test.whatap.domain.Entity;
import com.test.whatap.paging.Page;

import java.util.List;

public interface Repository<T> {
    Entity save(T t);
    Entity findById(Long id);
    Page findAll(int offset, int limit);
    Entity update(T t);
    void delete(T t);
}
