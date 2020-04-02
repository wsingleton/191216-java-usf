package com.revature.controllers;

import com.revature.service.S3Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.ByteArrayOutputStream;

public class DownloadFileController {
    @Autowired
    S3Services s3Services;

    @GetMapping("/{name}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String name) {
        ByteArrayOutputStream downloadInputStream = s3Services.downloadFile(name);

        return ResponseEntity.ok()
                .contentType(contentType(name))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + name + "\"")
                .body(downloadInputStream.toByteArray());
    }

    private MediaType contentType(String name) {
        String[] arr = name.split("\\.");
        String type = arr[arr.length-1];
        switch(type) {
            case "txt": return MediaType.TEXT_PLAIN;
            case "png": return MediaType.IMAGE_PNG;
            case "jpg": return MediaType.IMAGE_JPEG;
            default: return MediaType.APPLICATION_OCTET_STREAM;
        }
    }
}
