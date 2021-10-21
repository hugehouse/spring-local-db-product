package com.test.whatap.service;

import com.test.whatap.database.upload.Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class UploadService {
    private final Repository uploadRepository;

    public String saveImage(MultipartFile file, String path) {
        return uploadRepository.saveImage(file, path);
    }
}
