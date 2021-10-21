package com.test.whatap.controller;

import com.test.whatap.dto.category.CategoriesListResponseDto;
import com.test.whatap.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class JsonTestController {

    private final CategoryService categoryService;


    @GetMapping("/test/categories")
    public List<CategoriesListResponseDto> getProductsByPagination(Model model) {
        return categoryService.findAllCategory();
    }
}
