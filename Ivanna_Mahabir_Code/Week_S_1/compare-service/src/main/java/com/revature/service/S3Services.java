package com.revature.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;

public interface S3Services {
    public ByteArrayOutputStream downloadFile(String name);
    public void uploadeFile(String name, MultipartFile file);
}
