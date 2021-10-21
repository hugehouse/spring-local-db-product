package com.test.whatap.database.product.crud;

import com.test.whatap.database.FilePath;
import com.test.whatap.domain.Product;
import lombok.NoArgsConstructor;

import java.io.*;

@NoArgsConstructor
public class CreateProduct implements CreateData<Product>{

    @Override
    public Product save(Product product) { // = save(toEntity) id 자동 증가도 해야 됨

        try {
            // index 정보 불러오기
            File indexFile = new File(FilePath.PRODUCT_INDEX_PATH);
            DataInputStream dis = new DataInputStream(new FileInputStream(indexFile));
            Long count = dis.readLong();
            dis.close();

            // 받아온 객체 저장 -> 이미 존재하는 파일인지 검증해야 함
            File file = new File(FilePath.PRODUCT_PATH + count);
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
            product.setId(count); // id 설정
            dos.writeLong(product.getId());
            dos.writeInt(product.getPrice());
            dos.writeInt(product.getCategory());
            dos.writeInt(product.getStock());
            dos.writeUTF(product.getTitle());
            dos.writeUTF(product.setLocalDateTime());
            dos.writeUTF(product.getThumbnailImage());
            dos.writeUTF(product.getBodyImage());
            dos.close();

            // 저장 완료 후 인덱스 증가
            DataOutputStream idxDos = new DataOutputStream(new FileOutputStream(indexFile));
            idxDos.writeLong(++count);
            idxDos.close();

            return product;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
