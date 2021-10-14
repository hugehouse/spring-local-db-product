package com.test.whatap.dto;

import com.test.whatap.domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductAddRequestDto {
    private String title;
    private int price;

    @Builder
    public ProductAddRequestDto(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public Product toEntity() {
        return Product.builder()
                .title(title)
                .price(price)
                .build();
    }
}
