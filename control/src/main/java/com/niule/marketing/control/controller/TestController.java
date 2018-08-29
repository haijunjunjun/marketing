package com.niule.marketing.control.controller;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> response() {
        return ResponseEntity.ok("success");
    }
}
