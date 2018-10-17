package com.niule.marketing.controller.controller.controller;

import com.niule.marketing.controller.controller.config.DataResponse;
import com.niule.marketing.controller.controller.model.LevelModel;
import com.niule.marketing.controller.controller.service.ManageLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LsAusi
 * @date 2018/9/18
 * @time 17:54
 **/
@RestController
@RequestMapping("/manageLevelControl")
public class ManageLevelController {
    @Autowired
    private ManageLevelService manageLevelService;


    @RequestMapping("/getManageLevelList")
    public DataResponse getManageLevelList(@RequestBody(required = true)LevelModel levelModel){
        return DataResponse.success(manageLevelService.getManageLevelList(levelModel.getLevelName()));
    }


    @RequestMapping("/addManageLevel")
    public DataResponse addManageLevel(@RequestBody(required = true)LevelModel levelModel){
        return DataResponse.success(manageLevelService.addManageLevel(levelModel));
    }

    @RequestMapping("/queryManageLevelDetail")
    public DataResponse queryManageLevelDetail(@RequestBody(required = true)LevelModel levelModel){
        return DataResponse.success(manageLevelService.queryManageLevel(levelModel.getId()));
    }

    @RequestMapping("/updateManageLevel")
    public DataResponse updateManageLevel(@RequestBody(required = true)LevelModel levelModel){
        return DataResponse.success(manageLevelService.updateManageLevel(levelModel));
    }

}
