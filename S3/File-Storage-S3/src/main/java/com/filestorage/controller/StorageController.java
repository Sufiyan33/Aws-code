package com.filestorage.controller;

import com.filestorage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class StorageController {

    @Autowired
    public StorageService service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file){
        return new ResponseEntity<>(service.uploadFile(file), HttpStatus.OK);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String filName){
       byte[] data = service.downloadFile(filName);
       ByteArrayResource resource = new ByteArrayResource(data);
       return ResponseEntity
               .ok()
               .contentLength(data.length)
               .header("Content-type", "application/octet-stream")
               .header("Content-disposition", "attachment; fileName=\"" + filName + "\"")
               .body(resource);
    }

    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName){
        return new ResponseEntity<>(service.deleteFile(fileName), HttpStatus.OK);
    }
}
