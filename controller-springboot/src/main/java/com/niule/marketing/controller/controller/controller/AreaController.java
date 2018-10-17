package com.niule.marketing.controller.controller.controller;

import com.niule.marketing.controller.controller.config.CodeResponse;
import com.niule.marketing.controller.controller.config.DataResponse;
import com.niule.marketing.controller.controller.model.AreaAndCityModel;
import com.niule.marketing.controller.controller.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LsAusi
 * @date 2018/9/20
 * @time 15:19
 **/
@RestController
@RequestMapping("/areaControl")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("/getAreaList")
    public DataResponse getAreaList(@RequestBody(required = true)AreaAndCityModel areaAndCityModel){
        return DataResponse.success(areaService.getAreaList(areaAndCityModel.getAreaName()));


    }

    /**
     * 判断是否存在输入的区域名称
     * @param areaAndCityModel
     * @return
     */
    @RequestMapping("/areaNameIsExist")
    public DataResponse areaIsExist(@RequestBody(required = true) AreaAndCityModel areaAndCityModel){
        return DataResponse.success(areaService.areaNameIsExist(areaAndCityModel.getAreaName(),areaAndCityModel.getAreaId()));
    }


    /**
     * 判断是否存在输入的区域编号
     * @param areaAndCityModel
     * @return
     */
    @RequestMapping("/areaNoIsExist")
    public DataResponse areaNoIsExist(@RequestBody(required = true)AreaAndCityModel areaAndCityModel){
        return DataResponse.success(areaService.areaNOIsExist(areaAndCityModel.getAreaNo(),areaAndCityModel.getAreaId()));
    }



    /**
     * 添加区域以及该区域对应的线下城市
     * @param areaAndCityModel
     * @return
     */
    @RequestMapping("/addAreaAndCity")
    public  DataResponse addAreaAndCity(@RequestBody(required = true) AreaAndCityModel areaAndCityModel){
        try {
            return DataResponse.success(areaService.addAreaAndCity(areaAndCityModel));
        }catch (DuplicateKeyException duplicateKeyException){
            duplicateKeyException.printStackTrace();
            return DataResponse.error(new CodeResponse(1001,"出现重复值"));
        }

    }

    /**
     * 根据区域id查询区域的详情
     * @param areaAndCityModel
     * @return
     */
    @RequestMapping("/getAreaDetails")
    public DataResponse getAreaDetails(@RequestBody(required = true) AreaAndCityModel areaAndCityModel){
        return DataResponse.success(areaService.getAreaDetails(areaAndCityModel.getAreaId()));
    }

    /**
     * 获取线下城市列表
     * @param areaAndCityModel
     * @return
     */
    @RequestMapping("/getAreaCityList")
    public  DataResponse getAreaCityList(@RequestBody(required = true) AreaAndCityModel areaAndCityModel){
        return DataResponse.success(areaService.getAreaCityList(areaAndCityModel.getAreaNo()));
    }


    @RequestMapping("/updateArea")
    public DataResponse updateArea(@RequestBody(required = true)AreaAndCityModel areaAndCityModel){
        return DataResponse.success(areaService.updateArea(areaAndCityModel));
    }




}
