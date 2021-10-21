package com.test.whatap.dto.product;

import com.test.whatap.database.FilePath;
import com.test.whatap.domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductAddRequestDto{
    private String title;
    private int price;
    private int category;
    private int stock;
    private String thumbnailImage;
    private String bodyImage;

    @Builder
    public ProductAddRequestDto(String title, int price, int category, int stock, String thumbnailImage, String bodyImage) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.thumbnailImage = thumbnailImage;
        this.bodyImage = bodyImage;
    }

    public Product toEntity() {
        return Product.builder()
                .title(title)
                .price(price)
                .category(category)
                .stock(stock)
                .thumbnailImage(FilePath.THUMBNAIL_LOAD_PATH + thumbnailImage)
                .bodyImage(FilePath.BODY_IMAGE_LOAD_PATH + bodyImage)
                .build();
    }
}
