package com.example.demo.controller;

import com.example.demo.dal.model.CustomerInfo;
import com.example.demo.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping(value = "/marketing/upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadFile(@Valid @NotNull @RequestParam("id") Integer custId,
                                             @Valid @NotNull @RequestBody(required = true) MultipartFile file,
                                             @Valid @NotNull @RequestParam("path") String path) {
        return ResponseEntity.ok(fileUploadService.uploadFile(custId, file, path));
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ResponseEntity<String> compactCheck(@Valid @NotNull @RequestParam("id") Integer custId,
                                               @Valid @NotNull @RequestParam("isCheck") Integer isCompactCheck,
                                               @Valid @NotNull @RequestParam("reason") String checkRefuseReason) {
        return ResponseEntity.ok(fileUploadService.compactCheck(custId, isCompactCheck, checkRefuseReason));
    }

    @RequestMapping(value = "/check/list")
    public ResponseEntity<List<CustomerInfo>> compactCheckList() {
        return ResponseEntity.ok(fileUploadService.getCompactCheckList());
    }
}
