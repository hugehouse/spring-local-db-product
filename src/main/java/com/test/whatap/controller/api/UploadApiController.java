package com.test.whatap.controller.api;

import com.test.whatap.database.FilePath;
import com.test.whatap.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class UploadApiController {
    private final UploadService uploadService;

    @PostMapping("/upload/images")
    public String addProduct(@RequestParam("thumbnail") MultipartFile thumbnail,
                             @RequestParam("body_img") MultipartFile bodyImg) {
        uploadService.saveImage(thumbnail, FilePath.THUMBNAIL_PATH);
        return uploadService.saveImage(bodyImg, FilePath.BODY_IMAGE_PATH);
    }
}