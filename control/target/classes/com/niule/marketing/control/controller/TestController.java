package com.niule.marketing.control.controller;

import com.niule.marketing.control.config.DataResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haijun
 * @create 2018 - 08 - 22 - 11:48
 */
@RestController
public class TestController {

    @RequestMapping(value = "/response", method = RequestMethod.GET)
    public DataResponse response() {
        return DataResponse.success("success");
    }
}
