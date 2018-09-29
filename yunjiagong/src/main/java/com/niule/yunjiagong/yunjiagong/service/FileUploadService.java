package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.config.base64.MultipartFileV1;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserBaseInfo;
import com.niule.yunjiagong.yunjiagong.service.cloud.UserInfoFeginService;
import com.niule.yunjiagong.yunjiagong.util.MessageInfoV1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author haijun
 * @create 2018 - 09 - 29 - 14:56
 */
@Slf4j
@Service
public class FileUploadService {

    @Autowired
    private UserInfoFeginService userInfoFeginService;

    public MessageInfoV1<String> uploadFile(String base64) {
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        Integer userId = userBaseInfo.getId().intValue();
        MessageInfoV1<String> messageInfo = new MessageInfoV1<>();
        MultipartFile multipartFile = MultipartFileV1.base64ToMultipart(base64);
//        String uploadPath = "/home/www/upload/images/user_advice_pic/";
        String uploadPath = "D://path/user_advice_pic/";
        if (multipartFile.isEmpty()) {
            log.info("文件转换异常！");
            messageInfo.setContent("上传失败!");
            return messageInfo;
        }
        String originName = multipartFile.getOriginalFilename();
        String suffixName = originName.substring(originName.lastIndexOf("."));
        String filename = UUID.randomUUID().toString() + suffixName;
        String realPath = uploadPath + userId + "/" + filename;
//        String url = "http://106.15.37.191/images/user_advice_pic/" + userId + "/" + filename;
        String url = "http://192.168.105.75:8090/user_advice_pic/" + userId + "/" + filename;
        File dest = new File(realPath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(dest);
            messageInfo.setData(url);
            messageInfo.setContent("success");
            return messageInfo;
        } catch (IOException e) {
            messageInfo.setContent("fail");
            return messageInfo;
        }
    }
}
