package com.test.whatap.database.upload;

import com.test.whatap.database.upload.crud.CreateImage;
import com.test.whatap.database.upload.crud.CreateUploadData;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadRepository implements Repository {
    private final CreateUploadData createData;

    public UploadRepository() {
        createData = new CreateImage();
    }

    @Override
    public String saveImage(MultipartFile file, String path) {
        return createData.saveImage(file, path);
    }
}
