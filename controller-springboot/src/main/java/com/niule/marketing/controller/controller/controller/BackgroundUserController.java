package com.niule.marketing.controller.controller.controller;

import com.niule.marketing.controller.controller.config.DataResponse;
import com.niule.marketing.controller.controller.model.*;
import com.niule.marketing.controller.controller.service.BackgroundUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 09 - 10 - 17:23
 */
@SessionAttributes
@RestController
public class BackgroundUserController {

    @Autowired
    private BackgroundUserService backgroundUserService;

//    @Description("后台管理人员登录")
//    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
//    public DataResponse login(@Valid @NotNull @RequestBody(required = true) BackgroundUserLoginModel backgroundUserLoginModel) {
//        LoginSuccessModel loginInfo = backgroundUserService.login(backgroundUserLoginModel.getUserName(), backgroundUserLoginModel.getPassword());
//        if ("no_ser".trim().equals(loginInfo.getMessage())) {
//            return DataResponse.error(new CodeResponse(40001, "该用户不存在!"));
//        }
//        if ("incorrect_pass".trim().equals(loginInfo.getMessage())) {
//            return DataResponse.error(new CodeResponse(40002, "该用户密码不正确!"));
//        }
//        if ("invalid_user".trim().equals(loginInfo.getMessage())) {
//            return DataResponse.error(new CodeResponse(40003, "该用户已被禁用!"));
//        }
//        if ("login_success".trim().equals(loginInfo.getMessage())) {
//            return DataResponse.success(loginInfo);
//        }
//        return DataResponse.error(new CodeResponse(40000, "系统异常!"));
//    }

    @Description("后台管理人员登录V1")
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public DataResponse loginV1(@Valid @NotNull @RequestBody(required = true) BackgroundUserLoginModel backgroundUserLoginModel) {
        LoginSuccessModel loginInfo = backgroundUserService.loginV1(backgroundUserLoginModel.getUserName(), backgroundUserLoginModel.getPassword());
        return DataResponse.success(loginInfo);
    }

    @Description("绑定角色时获取角色信息")
    @RequestMapping(value = "/get/back/user/role", method = RequestMethod.POST)
    public DataResponse getBackUserRoleInfo() {
        return DataResponse.success(backgroundUserService.getUserRoleInfo());
    }

    @Description("当前用户拥有的角色信息")
    @RequestMapping(value = "/get/back/current/user/role", method = RequestMethod.POST)
    public DataResponse getCurrentUserRoleInfo(@Valid @NotNull @RequestBody(required = true) IdModel idModel) {
        return DataResponse.success(backgroundUserService.getCurrentUserInfo(idModel));
    }

    @Description("给当前用户绑定角色 编辑")
    @RequestMapping(value = "/bind/back/current/user/role", method = RequestMethod.POST)
    public DataResponse bindCurrentUserRoleInfo(@Valid @NotNull @RequestBody(required = true) CurrentUserInfoModel currentUserInfoModel) {
        return DataResponse.success(backgroundUserService.bindCurrentUserRoleInfo(currentUserInfoModel));
    }

    @Description("无权限时禁止登陆接口")
    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public DataResponse noLogin() {
        return DataResponse.success("对不起，您暂时没有权限访问该页面");
    }


    @Description("获取后台管理人员信息")
    @RequestMapping(value = "/back/user/info/fetch", method = RequestMethod.POST)
    public DataResponse fetchBackUserInfo(@Valid @NotNull @RequestBody(required = true) BackUserInfoSearchModel backUserInfoSearchModel) {
        return DataResponse.success(backgroundUserService.getBackGroundUserInfo(backUserInfoSearchModel));
    }

    @Description("获取后台管理人员详细信息")
    @RequestMapping(value = "/back/user/detail/info/fetch", method = RequestMethod.POST)
    public DataResponse fetchBackUserDetailInfo(@Valid @NotNull @RequestBody(required = true) IdModel idModel) {
        return DataResponse.success(backgroundUserService.getUserDetailInfo(idModel));
    }

    @Description("后台管理人员详细信息编辑")
    @RequestMapping(value = "/back/user/detail/info/edit", method = RequestMethod.POST)
    public DataResponse editBackUserDetailInfo(@Valid @NotNull @RequestBody(required = true) BackGroundUserDetailModel backGroundUserDetailModel) {
        return DataResponse.success(backgroundUserService.editBackUserDetailInfo(backGroundUserDetailModel));
    }

    @Description("添加后台管理人员信息")
    @RequestMapping(value = "/back/user/detail/info/add", method = RequestMethod.POST)
    public DataResponse addBackUserInfo(@Valid @NotNull @RequestBody(required = true) BackGroundUserDetailModel backGroundUserDetailModel) {
        return DataResponse.success(backgroundUserService.addBackUserDetailInfo(backGroundUserDetailModel));
    }

    @Description("获取角色信息")
    @RequestMapping(value = "/back/user/role/info", method = RequestMethod.POST)
    public DataResponse getUserRoleInfo() {
        return DataResponse.success(backgroundUserService.getBackUserRoleInfo());
    }

    @Description("编辑角色信息获取信息")
    @RequestMapping(value = "/edit/back/user/role//info", method = RequestMethod.POST)
    public DataResponse editFetchUserRoleInfo(@Valid @NotNull @RequestBody(required = true) IdModel idModel) {
        return DataResponse.success(backgroundUserService.editFetchUserRoleInfo(idModel));
    }

    @Description("编辑角色信息")
    @RequestMapping(value = "/back/user/role/detail/info", method = RequestMethod.POST)
    public DataResponse editUserRoleInfo(@Valid @NotNull @RequestBody(required = true) UserRoleInfoEditRequestModel userRoleInfoEditRequestModel) {
        return DataResponse.success(backgroundUserService.editUserRoleInfo(userRoleInfoEditRequestModel));
    }

    @Description("获取权限信息")
    @RequestMapping(value = "/back/user/auth/info", method = RequestMethod.POST)
    public DataResponse getUserAuthInfo() {
        return DataResponse.success(backgroundUserService.getUserAuthInfo());
    }
}
