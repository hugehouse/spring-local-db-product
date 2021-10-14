package com.test.whatap.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductUpdateResponseDto {
    private String title;
    private int price;

    @Builder
    public ProductUpdateResponseDto(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
