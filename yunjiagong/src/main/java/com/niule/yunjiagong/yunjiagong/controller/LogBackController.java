package com.niule.yunjiagong.yunjiagong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haijun
 * @create 2018 - 10 - 09 - 14:02
 */
@RestController
public class LogBackController {

    @RequestMapping(value = "/")
    public void log (){
        return ;
    }
}
