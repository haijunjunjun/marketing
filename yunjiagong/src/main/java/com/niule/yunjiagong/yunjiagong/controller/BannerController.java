package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.dal.model.Banner;
import com.niule.yunjiagong.yunjiagong.service.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 10:40
 */
@Description("banner")
@Slf4j
@Controller
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @Description("获取banner信息")
    @RequestMapping(value = "/user/banner", method = RequestMethod.GET)
    public ResponseEntity<List<Banner>> getBanner(@Valid @NotNull @RequestParam("type") Integer bannerType) {
        return ResponseEntity.ok(bannerService.getBanner(bannerType));
    }
}
