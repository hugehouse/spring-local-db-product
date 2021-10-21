package com.test.whatap.database.category;


import java.util.List;

public interface Repository<T> {
    List<T> findAll();
}
