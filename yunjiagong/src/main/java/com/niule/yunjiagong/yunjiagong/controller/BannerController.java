package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.model.BannerModel;
import com.niule.yunjiagong.yunjiagong.service.BannerService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 10:40
 */
@Description("banner")
@Slf4j
@RestController
public class BannerController {

    @Autowired
    private BannerService bannerService;

    // TODO: 2018/8/10 1 、添加缓存  2 、后端编辑时更新
    @Description("获取banner信息")
    @RequestMapping(value = "/user/banner", method = RequestMethod.POST)
    public DataResponse getBanner(@Valid @NotNull @RequestBody(required = true) BannerModel bannerModel) {
        return DataResponse.success(bannerService.getBanner(bannerModel.getBannerType()));
    }
}
