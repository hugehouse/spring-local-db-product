package com.test.whatap.database.product;

import com.test.whatap.database.product.crud.*;
import com.test.whatap.domain.Product;
import com.test.whatap.paging.Page;
import org.springframework.stereotype.Component;

@Component
public class ProductRepository implements Repository<Product>{
    private final CreateData createData;
    private final ReadData readData;
    private final UpdateData updateData;
    private final DeleteData deleteData;

    public ProductRepository() {
        createData = new CreateProduct();
        readData = new ReadProduct();
        updateData = new UpdateProduct();
        deleteData = new DeleteProduct();
    }

    @Override
    public Product save(Product product) {
        return (Product)createData.save(product);
    }

    @Override
    public Product findById(Long id) {
        return readData.findById(id);
    }

    @Override
    public Page findAll(int offset, int limit) {
        return readData.findAllDescById(offset, limit);
    }

    @Override
    public Product update(Product product) {
        return (Product) updateData.update(product);
    }

    @Override
    public void delete(Product product) {
        deleteData.delete(product);
    }
}
