package com.niule.marketing.controller.controller.controller;

import com.niule.marketing.controller.controller.config.DataResponse;
import com.niule.marketing.controller.controller.model.AdviceRespAndUserModel;
import com.niule.marketing.controller.controller.service.AdviceRespService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LsAusi
 * @date 2018/9/18
 * @time 10:47
 **/
@RestController
@RequestMapping("/adviceRespControl")
public class AdviceRespController {
    @Autowired
    private AdviceRespService adviceRespService;


    /**
     * 获取意见反馈列表
     *
     * @param userName 用户名
     * @param mobile   电话
     * @return
     */
    @RequestMapping("/getAdviceRespList")
    public DataResponse<List<AdviceRespAndUserModel>> getAdviceRespList(String userName, String mobile) {
        return DataResponse.success(adviceRespService.getAdviceRespList(userName, mobile));
    }

}
