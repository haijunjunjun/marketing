package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.dal.model.SortType;
import com.niule.yunjiagong.yunjiagong.service.SortService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 11:50
 */
@Controller
public class SortController {

    @Autowired
    private SortService sortService;

    @Description("获取排序列表")
    @RequestMapping(value = "/user/sort/type", method = RequestMethod.GET)
    public DataResponse getSortType() {
        return DataResponse.success(sortService.getSortType());
    }
}
