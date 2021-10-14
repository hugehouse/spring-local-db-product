package com.test.whatap.service;

import com.test.whatap.domain.Product;
import com.test.whatap.domain.ProductRepository;
import com.test.whatap.dto.ProductAddRequestDto;
import com.test.whatap.dto.ProductUpdateResponseDto;
import com.test.whatap.dto.ProductResponseDto;
import com.test.whatap.dto.ProductsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductResponseDto findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        return new ProductResponseDto(product);
    }

    @Transactional(readOnly = true)
    public ProductUpdateResponseDto findByIdForUpdate(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        return new ProductUpdateResponseDto(product.getTitle(), product.getPrice());
    }

    @Transactional(readOnly = true)
    public Page<ProductsListResponseDto> findAllDescByPagination(Pageable page) {
        return productRepository.findAll(page).map(ProductsListResponseDto::new);
    }

    @Transactional
    public Long add(ProductAddRequestDto product) {
        return productRepository.save(product.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ProductUpdateResponseDto requestDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        product.update(requestDto.getTitle(), requestDto.getPrice());
        return id;
    }

    @Transactional
    public Long delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        productRepository.delete(product);
        return id;
    }
}
