package com.example.demo.controller;

import com.example.demo.config.annotation.Operator;
import com.example.demo.dal.model.CustomerInfo;
import com.example.demo.model.Base64Model;
import com.example.demo.model.CurOperator;
import com.example.demo.model.CustModel;
import com.example.demo.service.FileUploadService;
import com.example.demo.util.MessageInfoV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @Description("上传客户的合同图片")
    @RequestMapping(value = "/marketing/upload", method = RequestMethod.POST)
    public ResponseEntity<MessageInfoV1> uploadFile(@Valid @NotNull @RequestBody(required = true) Base64Model base64Model) {
        return ResponseEntity.ok(fileUploadService.uploadFileV1(base64Model.getId(), base64Model.getBase64()));
    }

    @Description("合同审核")
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ResponseEntity<String> compactCheck(@Valid @NotNull @RequestParam("id") Integer custId,
                                               @Valid @NotNull @RequestParam("isCheck") Integer isCompactCheck,
                                               @Valid @NotNull @RequestParam("reason") String checkRefuseReason) {
        return ResponseEntity.ok(fileUploadService.compactCheck(custId, isCompactCheck, checkRefuseReason));
    }

    @Description("合同审核列表")
    @RequestMapping(value = "/check/list")
    public ResponseEntity<List<CustomerInfo>> compactCheckList() {
        return ResponseEntity.ok(fileUploadService.getCompactCheckList());
    }

    @Description("查询合同图片路径")
    @RequestMapping(value = "/marketing/cust/compact/info", method = RequestMethod.POST)
    public ResponseEntity<MessageInfoV1> getCustCompact(@Valid @NotNull @RequestBody(required = true) CustModel custModel) {
        return ResponseEntity.ok(fileUploadService.getCustCompact(custModel.getCustId()));
    }

    @Description("上传用户头像")
    @RequestMapping(value = "/marketing/upload/awater", method = RequestMethod.POST)
    public ResponseEntity<MessageInfoV1> uploadFile(@Valid @NotNull @Operator CurOperator curOperator,
                                                    @Valid @NotNull @RequestBody(required = true) MultipartFile file) {
        return ResponseEntity.ok(fileUploadService.uploadFileV2(curOperator.getId(), file));
    }
}
