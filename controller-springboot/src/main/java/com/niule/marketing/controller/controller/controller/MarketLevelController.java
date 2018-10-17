package com.niule.marketing.controller.controller.controller;

import com.niule.marketing.controller.controller.config.DataResponse;
import com.niule.marketing.controller.controller.model.LevelModel;
import com.niule.marketing.controller.controller.service.MarketLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author LsAusi
 * @date 2018/9/18
 * @time 15:04
 **/
@RestController
@RequestMapping("/marketLevel")
public class MarketLevelController {
    @Autowired
    private MarketLevelService marketLevelService;

    /**
     * 查询销售人员等级列表
     * @param levelModel
     * @return
     */
    @RequestMapping("/getMarketLevelList")
    public DataResponse getMarketLevelList(@RequestBody(required = true) LevelModel levelModel){
        return DataResponse.success(marketLevelService.getMarketLevelList(levelModel));
    }


    /**
     * 添加销售人员等级信息
     * @param levelModel
     * @return
     */
    @RequestMapping("/addMarketLevel")
    public DataResponse addMarketLevel( @RequestBody(required = true) LevelModel levelModel){
        int count  = marketLevelService.addMarketLevel(levelModel);
        return DataResponse.success(count);
    }

    @RequestMapping("/queryMarketLevelDetail")
    public DataResponse queryMarketLevelDetail(@RequestBody(required = true) LevelModel levelModel){
        return DataResponse.success(marketLevelService.queryMarketLevelDetail(levelModel.getId()));
    }

    @RequestMapping("/updateMarketLevel")
    public DataResponse updateMarketLevel(@RequestBody(required = true) LevelModel levelModel){
        int count  = marketLevelService.updateMarketLevel(levelModel);
        return DataResponse.success(count);
    }
}
