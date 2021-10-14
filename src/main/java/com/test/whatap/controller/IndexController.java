package com.test.whatap.controller;

import com.test.whatap.dto.ProductUpdateResponseDto;
import com.test.whatap.dto.ProductsListResponseDto;
import com.test.whatap.paging.PageInfo;
import com.test.whatap.paging.PagingExceptionHandler;
import com.test.whatap.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ProductService productService;

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
        PageRequest request = PageRequest.of(offset, transLimit, Sort.Direction.DESC, "id");

        Page<ProductsListResponseDto> products = productService.findAllDescByPagination(request);

        model.addAttribute("products", products.getContent());
        model.addAttribute("page", new PageInfo(offset, products.getTotalPages(), transLimit));
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
