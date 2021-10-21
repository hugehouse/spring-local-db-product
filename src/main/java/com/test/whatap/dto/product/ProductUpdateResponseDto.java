package com.test.whatap.dto.product;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductUpdateResponseDto{
    private String title;
    private int price;
    private int category;
    private int stock;
    private String thumbnailImage;
    private String bodyImage;

    @Builder
    public ProductUpdateResponseDto(String title, int price, int category, int stock, String thumbnailImage, String bodyImage) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.thumbnailImage = thumbnailImage;
        this.bodyImage = bodyImage;
    }
}
