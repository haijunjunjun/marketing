package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.model.BannerEditModel;
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

    @Description("获取banner信息")
    @RequestMapping(value = "/user/banner", method = RequestMethod.POST)
    public DataResponse getBanner(@Valid @NotNull @RequestBody(required = true) BannerModel bannerModel) {
        return DataResponse.success(bannerService.getBanner(bannerModel.getBannerType()));
    }

//    @Description("用户自定义banner信息编辑")
//    @RequestMapping(value = "/user/banner/edit", method = RequestMethod.POST)
//    public DataResponse editBanner(@Valid @NotNull @RequestBody(required = true) BannerEditModel bannerEditModel) {
//        return DataResponse.success(bannerService.editBannerInfo(bannerEditModel.getEditInfo()));
//    }
//
//    @Description("查询用户自定义的banner信息")
//    @RequestMapping(value = "/user/banner/view", method = RequestMethod.GET)
//    public DataResponse getUserBanner() {
//        return DataResponse.success(bannerService.getUserBanner());
//    }
}
