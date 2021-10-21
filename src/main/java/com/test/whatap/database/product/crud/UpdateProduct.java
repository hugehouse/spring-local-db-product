package com.test.whatap.database.product.crud;

import com.test.whatap.database.FilePath;
import com.test.whatap.domain.Product;

import java.io.*;

public class UpdateProduct implements UpdateData<Product> {
    @Override
    public Product update(Product product) {
        try {
            File file = new File(FilePath.PRODUCT_PATH + product.getId());
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
            dos.writeLong(product.getId());
            dos.writeInt(product.getPrice());
            dos.writeInt(product.getCategory());
            dos.writeInt(product.getStock());
            dos.writeUTF(product.getTitle());
            dos.writeUTF(product.setLocalDateTime());
            dos.writeUTF(product.getThumbnailImage());
            dos.writeUTF(product.getBodyImage());
            dos.close();
            return product;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
