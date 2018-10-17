package com.niule.marketing.controller.controller.controller;

import com.niule.marketing.controller.controller.config.DataResponse;
import com.niule.marketing.controller.controller.dal.model.Config;
import com.niule.marketing.controller.controller.dal.model.PerformanceConfigV1;
import com.niule.marketing.controller.controller.model.CommissionConfigModel;
import com.niule.marketing.controller.controller.model.ConfigModel;
import com.niule.marketing.controller.controller.model.PerformanceConfigV1Model;
import com.niule.marketing.controller.controller.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LsAusi
 * @date 2018/9/19
 * @time 15:43
 **/
@RestController
@RequestMapping("/configControl")
public class ConfigController {
    @Autowired
    private ConfigService configService;


    /**
     * 获取金豆设置
     * @return
     */
    @RequestMapping("/getConfigList")
    public DataResponse getConfigList(){
        return DataResponse.success(configService.getConfigList());
    }


    /**
     * 修改金豆设置
     * @param configModel
     * @return
     */
    @RequestMapping("/updateConfig")
    public DataResponse updateConfig(@RequestBody(required = true) ConfigModel configModel){
        int count = configService.updateConfig(configModel);
        return DataResponse.success(count);
    }

    /**
     * 获取考核提成设置
     * @return
     */
    @RequestMapping("/getPerformanceConfigV1List")
    public DataResponse getPerformanceConfigV1List(){
        return DataResponse.success(configService.getPerformanceConfigV1List());
    }

    /**
     * 编辑考核设置
     * @param performanceConfigV1Model
     * @return
     */
    @RequestMapping("/updatePerformanceConfig")
    public DataResponse updatePerformanceConfig(@RequestBody(required = true)PerformanceConfigV1Model performanceConfigV1Model){
        return DataResponse.success(configService.updatePerformanceConfigV1(performanceConfigV1Model));
    }

    /**
     * 获取提成设置
     * @return
     */
    @RequestMapping("/getCommissionConfigList")
    public DataResponse getCommissionConfigList(){
        return DataResponse.success(configService.getCommissionConfigList());

    }

    @RequestMapping("/updateCommissionConfig")
    public DataResponse updateCommissionConfig(@RequestBody(required = true)CommissionConfigModel commissionConfigModel){
        return DataResponse.success(configService.updateCommissionConfig(commissionConfigModel));
    }
}




