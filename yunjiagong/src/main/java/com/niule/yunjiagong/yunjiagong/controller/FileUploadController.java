package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.model.UploadUserAdvicePicModel;
import com.niule.yunjiagong.yunjiagong.service.FileUploadService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 09 - 29 - 14:55
 */
@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @Description("上传图片")
    @RequestMapping(value = "/upload/user/advice/pic", method = RequestMethod.POST)
    public DataResponse uploadUserAdvicePic(@Valid @NotNull @RequestBody(required = true) UploadUserAdvicePicModel uploadUserAdvicePicModel) {
        return DataResponse.success(fileUploadService.uploadFile(uploadUserAdvicePicModel.getBase64()));
    }
}
