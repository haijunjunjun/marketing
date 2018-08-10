package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.service.SortService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 11:50
 */
@RestController
public class SortController {

    @Autowired
    private SortService sortService;

    @Description("获取排序列表")
    @RequestMapping(value = "/user/sort/type", method = RequestMethod.GET)
    public DataResponse getSortType() {
        return DataResponse.success(sortService.getSortType());
    }
}
