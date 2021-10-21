package com.test.whatap.service;

import com.test.whatap.database.product.ProductRepository;
import com.test.whatap.domain.Product;
import com.test.whatap.dto.product.ProductAddRequestDto;
import com.test.whatap.dto.product.ProductUpdateResponseDto;
import com.test.whatap.dto.product.ProductResponseDto;
import com.test.whatap.paging.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@RequiredArgsConstructor
@Validated
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDto findById(Long id) {
        return new ProductResponseDto(productRepository.findById(id));
    }

    public ProductUpdateResponseDto findByIdForUpdate(Long id) {
        Product product = productRepository.findById(id);
        return new ProductUpdateResponseDto()
                .builder()
                .title(product.getTitle())
                .price(product.getPrice())
                .category(product.getCategory())
                .stock(product.getStock())
                .thumbnailImage(product.getThumbnailImage())
                .bodyImage(product.getBodyImage())
                .build();
    }


    public Page findAllDescByPagination(int offset, int limit) {
        return productRepository.findAll(offset, limit);
}


    public Product add(@Valid Product receiveProduct) {
        Product product = productRepository.save(receiveProduct);
        product.setLocalDateTime();
        return product;
    }

    public Product update(Long id, @Valid Product receiveProduct) {
        return productRepository.update(receiveProduct);
    }

    public Long delete(Long id) {
        Product product = productRepository.findById(id);
        productRepository.delete(product);
        return product.getId();
    }
}
