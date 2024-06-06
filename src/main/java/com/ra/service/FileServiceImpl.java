package com.ra.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService{
    @Value("${path-upload}")
    private String path;
    @Value("${server.port}")
    private Integer port;
    @Override
    public String uploadImage(MultipartFile file) {

        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),new File(path+fileName));
        } catch (IOException exception){
          throw new RuntimeException(exception.getMessage());
        }
        return "http:localhost:"+port+"/"+fileName;
    }
}
