package com.test.whatap.service;

import com.test.whatap.database.category.CategoryRepository;
import com.test.whatap.domain.Category;
import com.test.whatap.dto.category.CategoriesListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoriesListResponseDto> findAllCategory() {
        return categoryRepository.findAll().stream()
            .map(CategoriesListResponseDto::new)
            .collect(Collectors.toList());
    }
}
