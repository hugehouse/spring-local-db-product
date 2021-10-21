package com.test.whatap.database.product.crud;

import com.test.whatap.database.FilePath;
import com.test.whatap.domain.Product;

import java.io.File;

public class DeleteProduct implements DeleteData<Product> {
    @Override
    public void delete(Product product) {
        try {
            File file = new File(FilePath.PRODUCT_PATH + product.getId());
            if(!file.delete()) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
