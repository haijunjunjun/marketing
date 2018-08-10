package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.service.NoticeService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 10:46
 */
@RestController
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @Description("获取公告信息")
    @RequestMapping(value = "/user/notice", method = RequestMethod.GET)
    public DataResponse getNoticeList() {
        return DataResponse.success(noticeService.getNoticeList());
    }
}
