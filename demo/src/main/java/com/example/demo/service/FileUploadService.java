package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Slf4j
@Service
public class FileUploadService {

    public String uploadFile(MultipartFile multipartFile, String uploadPath) {
        if (multipartFile.isEmpty()) {
            return "文件为空!";
        }
        String filename = multipartFile.getOriginalFilename();
        log.info("上传的文件名为:" + filename);
        String suffixName = filename.substring(filename.lastIndexOf("."));
        log.info("上传文件的后缀名为:" + suffixName);
        File dest = new File(uploadPath + filename);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(dest);
            return "上传成功!";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败!";
    }

}
