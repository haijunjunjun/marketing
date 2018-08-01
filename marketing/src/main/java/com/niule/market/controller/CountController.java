package com.niule.market.controller;

import com.github.pagehelper.PageInfo;
import com.niule.market.dao.model.AuthNo;
import com.niule.market.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 08 - 01 - 13:35
 */
@Controller
public class CountController {

    @Autowired
    private CountService countService;

    @RequestMapping(value = "/market/count", method = RequestMethod.GET)
    public ResponseEntity<PageInfo<AuthNo>> getInfo(@Valid @NotNull @RequestParam("workNo") String workNo,
                                                    @Valid @NotNull @RequestParam("pageNum") Integer pageNum,
                                                    @Valid @NotNull @RequestParam("pageSize") Integer pageSize) {
        return ResponseEntity.ok(countService.getCountInfo(workNo, pageNum, pageSize));
    }
}
