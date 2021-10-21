package com.test.whatap.database.upload.crud;

import org.springframework.web.multipart.MultipartFile;

public interface CreateUploadData {
    String saveImage(MultipartFile file, String path);
}
