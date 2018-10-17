package com.niule.marketing.controller.controller.service;

import com.niule.marketing.controller.controller.dal.mapper.CommissionConfigMapper;
import com.niule.marketing.controller.controller.dal.mapper.ConfigMapper;
import com.niule.marketing.controller.controller.dal.mapper.PerformanceConfigV1Mapper;
import com.niule.marketing.controller.controller.dal.model.*;
import com.niule.marketing.controller.controller.model.CommissionConfigModel;
import com.niule.marketing.controller.controller.model.ConfigModel;
import com.niule.marketing.controller.controller.model.PerformanceConfigV1Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author LsAusi
 * @date 2018/9/19
 * @time 15:41
 **/
@Slf4j
@Service
public class ConfigService {
    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private PerformanceConfigV1Mapper performanceConfigV1Mapper;

    @Autowired
    private CommissionConfigMapper commissionConfigMapper;


    /**
     * 获取金豆设置数据
     * @return
     */
    public List<Config> getConfigList(){
        ConfigExample configExample = new ConfigExample();
        configExample.setOrderByClause("id desc");
        List<Config> configList = configMapper.selectByExample(configExample);
        return configList;
    }

    /**
     * 修改金豆设置
     * @param configModel
     * @return
     */
    public int updateConfig(ConfigModel configModel){
        Config config = new Config();
        if(configModel.getId() != null){
            config.setId(configModel.getId());
        }

        if(configModel.getConfigValue() != null){
            config.setConfigValue(configModel.getConfigValue());
        }

        int count  = configMapper.updateByPrimaryKeySelective(config);

        return count;
    }

    /**
     * 获取考核提成设置
     * @return
     */
    public List<PerformanceConfigV1> getPerformanceConfigV1List(){
        PerformanceConfigV1Example performanceConfigV1Example = new PerformanceConfigV1Example();
        performanceConfigV1Example.setOrderByClause("id desc");
        List<PerformanceConfigV1> performanceConfigV1List = performanceConfigV1Mapper.selectByExample(performanceConfigV1Example);
        return performanceConfigV1List;
    }


    /**
     * 编辑考核设置
     * @param performanceConfigV1Model
     * @return
     */
    public  int updatePerformanceConfigV1(PerformanceConfigV1Model performanceConfigV1Model){
        PerformanceConfigV1 performanceConfigV1 = new PerformanceConfigV1();
        if(performanceConfigV1Model.getId() != null){
            performanceConfigV1.setId(performanceConfigV1Model.getId());
        }
        if(performanceConfigV1Model.getBaseBalary() != null){
            performanceConfigV1.setBaseBalary(performanceConfigV1Model.getBaseBalary());
        }

        if(performanceConfigV1Model.getKpi() != null){
            performanceConfigV1.setKpi(performanceConfigV1Model.getKpi());
        }
        if(performanceConfigV1Model.getDeathLine() != null){
            performanceConfigV1.setDeathLine(performanceConfigV1Model.getDeathLine());
        }

        int count  = performanceConfigV1Mapper.updateByPrimaryKeySelective(performanceConfigV1);
        return count;
    }

    /**
     * 获取提成设置
     * @return
     */
    public List<CommissionConfig> getCommissionConfigList(){
        CommissionConfigExample commissionConfigExample = new CommissionConfigExample();
//        commissionConfigExample.setOrderByClause("id desc");
        List<CommissionConfig> commissionConfigList = commissionConfigMapper.selectByExample(commissionConfigExample);
        return commissionConfigList;

    }

    public int updateCommissionConfig(CommissionConfigModel commissionConfigModel){
        CommissionConfig commissionConfig = new CommissionConfig();
        if(commissionConfigModel.getId() != null){
            commissionConfig.setId(commissionConfigModel.getId());
        }
        if(commissionConfigModel.getCommissionPoint() != null ){
            commissionConfig.setCommissionPoint(commissionConfigModel.getCommissionPoint());
        }

        commissionConfig.setModifyTime(new Date());
        int count  = commissionConfigMapper.updateByPrimaryKeySelective(commissionConfig);
        return count;
    }

}
