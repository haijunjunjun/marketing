package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.model.DefaultResource;
import com.niule.yunjiagong.yunjiagong.service.DefaultResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 17:51
 */
@Controller
public class DefaultResourceController {

    @Autowired
    private DefaultResourceService defaultResourceService;

    @Description("获取默认图片")
    @RequestMapping(value = "/user/default/resource", method = RequestMethod.GET)
    public ResponseEntity<List<DefaultResource>> getDefaultResource() {
        return ResponseEntity.ok(defaultResourceService.getDefaultResource());
    }
}
