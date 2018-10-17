package com.niule.marketing.controller.controller.service;

import com.niule.marketing.controller.controller.config.base64.MultipartFileV1;
import com.niule.marketing.controller.controller.dal.mapper.UserInfoMapper;
import com.niule.marketing.controller.controller.util.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author haijun
 * @create 2018 - 09 - 13 - 9:58
 */
@Slf4j
@Service
public class FileUploadService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public MessageInfo<String> uploadFile(String phone, String base64) {
        assert (phone != null) : "phone 不能为空!";
        assert (base64 != null) : "base64 不能为空!";

        MessageInfo<String> messageInfo = new MessageInfo<>();
        MultipartFile multipartFile = MultipartFileV1.base64ToMultipart(base64);
//        String uploadPath = "/home/www/upload/images/market_user/";
        String uploadPath = "D://path/market_user/";
        if (multipartFile.isEmpty()) {
            log.info("文件转换异常！");
            messageInfo.setResult("上传失败!");
            return messageInfo;
        }
        String originName = multipartFile.getOriginalFilename();
        String suffixName = originName.substring(originName.lastIndexOf("."));
        String filename = UUID.randomUUID().toString() + suffixName;
        String realPath = uploadPath + phone + "/" + filename;
//        String url = "http://106.15.37.191/images/market_user/" + phone + "/" + filename;
        String url = "http://192.168.105.75:8090/market_user/" + phone + "/" + filename;
        File dest = new File(realPath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(dest);
            messageInfo.setData(url);
            messageInfo.setResult("success");
            return messageInfo;
        } catch (IOException e) {
            messageInfo.setResult("fail");
            return messageInfo;
        }
    }

    public MessageInfo<String> uploadFileV1(String phone, String base64) {
        assert (phone != null) : "phone 不能为空!";
        assert (base64 != null) : "base64 不能为空!";

        MessageInfo<String> messageInfo = new MessageInfo<>();
        MultipartFile multipartFile = MultipartFileV1.base64ToMultipart(base64);
//        String uploadPath = "/home/www/upload/images/market_user/";
        String uploadPath = "D://path/market_cash/";
        if (multipartFile.isEmpty()) {
            log.info("文件转换异常！");
            messageInfo.setResult("上传失败!");
            return messageInfo;
        }
        String originName = multipartFile.getOriginalFilename();
        String suffixName = originName.substring(originName.lastIndexOf("."));
        String filename = UUID.randomUUID().toString() + suffixName;
        String realPath = uploadPath + phone + "/" + filename;
//        String url = "http://106.15.37.191/images/market_user/" + phone + "/" + filename;
        String url = "http://192.168.105.75:8090/market_cash/" + phone + "/" + filename;
        File dest = new File(realPath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(dest);
            messageInfo.setData(url);
            messageInfo.setResult("success");
            return messageInfo;
        } catch (IOException e) {
            messageInfo.setResult("fail");
            return messageInfo;
        }
    }
}
