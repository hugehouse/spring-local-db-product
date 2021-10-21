package com.test.whatap.database.category.crud;


import java.util.List;

public interface ReadCategoryData<T> {
    List<T> findAll();
}
