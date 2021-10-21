package com.test.whatap.database.category;

import com.test.whatap.database.category.crud.ReadCategoryCategory;
import com.test.whatap.database.category.crud.ReadCategoryData;
import com.test.whatap.domain.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryRepository implements Repository<Category> {
    private final ReadCategoryData readCategoryData;

    public CategoryRepository() {
        readCategoryData = new ReadCategoryCategory();
    }

    @Override
    public List<Category> findAll() {
        return readCategoryData.findAll();
    }
}
