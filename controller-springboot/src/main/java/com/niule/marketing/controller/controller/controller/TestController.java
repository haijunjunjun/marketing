package com.niule.marketing.controller.controller.controller;

import com.niule.marketing.controller.controller.config.DataResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haijun
 * @create 2018 - 08 - 29 - 14:53
 */
@RestController
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public DataResponse test() {
        return DataResponse.success("success");
    }
}
