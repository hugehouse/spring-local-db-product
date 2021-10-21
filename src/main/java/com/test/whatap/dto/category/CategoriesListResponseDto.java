package com.test.whatap.dto.category;

import com.test.whatap.domain.Category;
import lombok.Getter;

@Getter
public class CategoriesListResponseDto {
    private final int id;
    private final String name;
    private final int parent;
    private final int tier;

    public CategoriesListResponseDto (Category category) {
        id = category.getId();
        name = category.getName();
        parent = category.getParent();
        tier = category.getTier();
    }
}
