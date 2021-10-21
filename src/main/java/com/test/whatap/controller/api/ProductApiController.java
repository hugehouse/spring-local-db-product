package com.test.whatap.controller.api;

import com.test.whatap.database.FilePath;
import com.test.whatap.domain.Product;
import com.test.whatap.dto.product.ProductAddRequestDto;
import com.test.whatap.dto.product.ProductUpdateResponseDto;
import com.test.whatap.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/products")
public class ProductApiController {

    private final ProductService productService;

    @PostMapping // Product 생성 중 에러 발생 시 http 400 에러 전달
    public Product addProduct(@RequestBody ProductAddRequestDto requestDto) {
        return productService.add(requestDto.toEntity());
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductUpdateResponseDto requestDto) {
        return productService.update(id,
                Product.builder()
                .id(id)
                .title(requestDto.getTitle())
                .price(requestDto.getPrice())
                .category(requestDto.getCategory())
                .stock(requestDto.getStock())
                .thumbnailImage(FilePath.THUMBNAIL_LOAD_PATH + requestDto.getThumbnailImage())
                .bodyImage(FilePath.BODY_IMAGE_LOAD_PATH + requestDto.getBodyImage())
                .build());
    }

    @DeleteMapping("/{id}")
    public Long deleteProduct(@PathVariable Long id) {
        return productService.delete(id);
    }
}