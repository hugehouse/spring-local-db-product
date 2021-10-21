package com.test.whatap.database.upload.crud;

import com.test.whatap.database.FilePath;
import com.test.whatap.util.TimeFormatter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Time;
import java.time.LocalTime;

@NoArgsConstructor
public class CreateImage implements CreateUploadData {

    @Override
    public String saveImage(MultipartFile file, String path) {
        try {
            String fileName = file.getOriginalFilename();

            FileOutputStream fos = new FileOutputStream(path + fileName);
            InputStream is = file.getInputStream();
            // 파일로부터 데이터 읽어오기 위한 Stream

            int readCount = 0;
            byte[] buffer = new byte[1024];

            while ((readCount = is.read(buffer)) != -1) { // is.read(buffer) -> 1024byte만큼 잘라서 buffer에 저장
                fos.write(buffer, 0, readCount);  // 저장된 내용을 출력
            }
            fos.close();
            return fileName;

        } catch (FileSizeLimitExceededException e) {
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
