package com.test.whatap.controller;

import com.test.whatap.dto.product.ProductUpdateResponseDto;
import com.test.whatap.dto.product.ProductsListResponseDto;
import com.test.whatap.paging.PageImpl;
import com.test.whatap.paging.PageInfo;
import com.test.whatap.paging.PagingExceptionHandler;
import com.test.whatap.service.CategoryService;
import com.test.whatap.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }

    @GetMapping("/products")
    public String getProductsByPagination(
            @RequestParam(value = "offset", required = true, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = true, defaultValue = "10") int limit, Model model) {
        int transLimit = PagingExceptionHandler.normalizationLimit(limit);

        PageImpl page = (PageImpl)productService.findAllDescByPagination(offset, transLimit);

        if(page != null) {
            List<ProductsListResponseDto> products = page
                    .getEntityList()
                    .stream()
                    .map(ProductsListResponseDto::new)
                    .collect(Collectors.toList());

            model.addAttribute("products", products);
            model.addAttribute("page", new PageInfo(offset, page.getTotalPages(), transLimit));
        }
        model.addAttribute("categories", categoryService.findAllCategory());
        return "products";
    }

    @GetMapping("/products/new-item")
    public String addPage() { return "add"; }

    @GetMapping("/products/update/{id}")
    public String updatePage(@PathVariable Long id, Model model) {
        ProductUpdateResponseDto product = productService.findByIdForUpdate(id);
        model.addAttribute("id", id);
        model.addAttribute("product", product);
        return "update";
    }
}
