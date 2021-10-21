package com.test.whatap.database.category.crud;

import com.test.whatap.database.FilePath;
import com.test.whatap.domain.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCategoryCategory implements ReadCategoryData<Category> {

    public List<Category> findAll() {
        List<Category> category = new ArrayList<>();
        DataInputStream dis = null;

        try {
            File file = new File(FilePath.CATEGORY_PATH);
            File[] files = file.listFiles();

            for(int i = 0; i < files.length; i++) {
                dis = new DataInputStream(new FileInputStream(files[i]));
                category.add(new Category().builder()
                        .id(dis.readInt())
                        .parent(dis.readInt())
                        .tier(dis.readInt())
                        .name(dis.readUTF())
                        .build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(!category.isEmpty()) {
                return category;
            }
    }
        return null;
    }
}
