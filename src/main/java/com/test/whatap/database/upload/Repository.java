package com.test.whatap.database.upload;

import com.test.whatap.domain.Entity;
import com.test.whatap.paging.Page;
import org.springframework.web.multipart.MultipartFile;

public interface Repository {
    String saveImage(MultipartFile file, String path);
}
