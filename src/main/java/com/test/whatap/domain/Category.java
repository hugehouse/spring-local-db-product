package com.test.whatap.domain;

import com.test.whatap.dto.category.CategoriesListResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class Category implements Entity {

    private int id; // 카테고리 번호
    private int parent;
    private int tier;
    private String name;

    @Builder
    public Category(int id, String name, int parent, int tier){
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.tier = tier;
    }

    public Category getParentObject(List<Category> categories) {
        return categories.get(parent);
    }

//    public void coupleParent(List<CategoriesListResponseDto> categories) {
//        if(tier != 0) {
//            categories.get(parent % 1000).addChild(this);
//            categories.remove(this);
//        }
//    }
}
