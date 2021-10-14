package com.test.whatap.controller.api;

import com.test.whatap.dto.ProductAddRequestDto;
import com.test.whatap.dto.ProductUpdateResponseDto;
import com.test.whatap.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/products")
public class ProductApiController {

    private final ProductService productService;

    @PostMapping
    public Long addProduct(@RequestBody ProductAddRequestDto requestDto) {
        return productService.add(requestDto);
    }

    @PutMapping("/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductUpdateResponseDto requestDto) {
        return productService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public Long deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return id;
    }
}
