package com.test.whatap.dto;

import com.test.whatap.domain.Product;
import com.test.whatap.util.PriceFormat;
import lombok.Getter;

@Getter
public class ProductsListResponseDto {
    private final Long id;
    private final String title;
    private final String price;

    public ProductsListResponseDto (Product product) {
        id = product.getId();
        title = product.getTitle();
        price = PriceFormat.formatPrice(product.getPrice());
    }
}
