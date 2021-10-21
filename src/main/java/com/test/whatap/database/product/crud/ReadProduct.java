package com.test.whatap.database.product.crud;

import com.test.whatap.database.FilePath;
import com.test.whatap.domain.Product;
import com.test.whatap.paging.Page;
import com.test.whatap.paging.PageCalculator;
import com.test.whatap.paging.PageImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadProduct implements ReadData {

    @Override
    public Page findAllDescById(int offset, int limit) {
        return findFileDescById(offset, limit);
    }

    @Override
    public Product findById(Long id) {
        try {
            File file = new File(FilePath.PRODUCT_PATH + id);
            DataInputStream dis = new DataInputStream(new FileInputStream(file));
            Product product = new Product().builder()
                            .id(dis.readLong())
                            .price(dis.readInt())
                            .category(dis.readInt())
                            .stock(dis.readInt())
                            .title(dis.readUTF())
                            .createdTime(dis.readUTF())
                            .thumbnailImage(dis.readUTF())
                            .bodyImage(dis.readUTF())
                            .build();
            dis.close();
            return product;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private Page findFileDescById(int offset, int limit) {
        List<Product> products = new ArrayList<>();
        PageImpl page = new PageImpl();
        DataInputStream dis = null;
        boolean existPage = false;

        try {
            // 받아온 객체 저장 -> 이미 존재하는 파일인지 검증해야 함
            File file = new File(FilePath.PRODUCT_PATH);
            File[] files = file.listFiles();

            PageCalculator carculator = new PageCalculator(files.length, offset, limit);

            int currentPage = carculator.getDescCurrentPage(); // 오름차순 시 Asc 메소드로 변경
            page.setTotalPages(carculator.getTotalPages());
            limit = carculator.getLimit();

            for(int i = currentPage; i > currentPage - limit; i--) {
                dis = new DataInputStream(new FileInputStream(files[i]));
                products.add(new Product().builder()
                                .id(dis.readLong())
                                .price(dis.readInt())
                                .category(dis.readInt())
                                .stock(dis.readInt())
                                .title(dis.readUTF())
                                .createdTime(dis.readUTF())
                                .thumbnailImage(dis.readUTF())
                                .bodyImage(dis.readUTF())
                        .build());
                existPage = true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) { // 나머지 에러들 발생 시 error page로 이동
            throw new IllegalArgumentException();
        } finally {
            try {
                if(dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(existPage) {
                page.setEntityList(products);
                return page;
            }
        }
        return null;
    }
}
