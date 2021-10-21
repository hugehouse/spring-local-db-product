package com.test.whatap.dto.product;

import com.test.whatap.domain.Product;
import com.test.whatap.util.PriceFormat;
import lombok.Getter;

@Getter
public class ProductResponseDto{
    private final Long id;
    private final String title;
    private final String price;
    private final int category;
    private final int stock;
    private final String createdTime;
    private final String thumbnailImage;
    private final String bodyImage;

    public ProductResponseDto(Product product) {
        id = product.getId();
        title = product.getTitle();
        price = PriceFormat.formatPrice(product.getPrice());
        category = product.getCategory();
        stock = product.getStock();
        createdTime = product.getCreatedTime();
        thumbnailImage = product.getThumbnailImage();
        bodyImage = product.getBodyImage();
    }
}
