package com.niule.marketing.controller.controller.controller;

import com.niule.marketing.controller.controller.config.DataResponse;
import com.niule.marketing.controller.controller.model.FileUploadRequestModel;
import com.niule.marketing.controller.controller.service.FileUploadService;
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
 * @create 2018 - 09 - 13 - 11:46
 */
@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @Description("销售人员文件信息上传")
    @RequestMapping(value = "/user/upload", method = RequestMethod.POST)
    public DataResponse fileUpload(@Valid @NotNull @RequestBody(required = true) FileUploadRequestModel fileUploadRequestModel) {
        return DataResponse.success(fileUploadService.uploadFile(fileUploadRequestModel.getUserPhone(), fileUploadRequestModel.getBase64()));
    }

    @Description("财务管理提现申请付款图片文件信息上传")
    @RequestMapping(value = "/user/upload/V1", method = RequestMethod.POST)
    public DataResponse fileUploadV1(@Valid @NotNull @RequestBody(required = true) FileUploadRequestModel fileUploadRequestModel) {
        return DataResponse.success(fileUploadService.uploadFileV1(fileUploadRequestModel.getUserPhone(), fileUploadRequestModel.getBase64()));
    }
}
