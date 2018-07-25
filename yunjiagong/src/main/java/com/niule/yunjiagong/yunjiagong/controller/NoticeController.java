package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.dal.model.Notice;
import com.niule.yunjiagong.yunjiagong.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 10:46
 */
@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @Description("获取公告信息")
    @RequestMapping(value = "/user/notice", method = RequestMethod.GET)
    public ResponseEntity<List<Notice>> getNoticeList() {
        return ResponseEntity.ok(noticeService.getNoticeList());
    }
}
