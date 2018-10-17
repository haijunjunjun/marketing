package com.niule.marketing.controller.controller.service;

import com.niule.marketing.controller.controller.dal.mapper.MarketLevelMapper;
import com.niule.marketing.controller.controller.dal.model.MarketLevel;
import com.niule.marketing.controller.controller.dal.model.MarketLevelExample;
import com.niule.marketing.controller.controller.model.LevelModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LsAusi
 * @date 2018/9/18
 * @time 14:59
 **/
@Slf4j
@Service
public class MarketLevelService {

    @Autowired
    private MarketLevelMapper marketLevelMapper;

    /**
     * 查询销售人员等级列表
     * @param levelModel
     * @return
     */
    public List<MarketLevel> getMarketLevelList(LevelModel levelModel){

        MarketLevelExample marketLevelExample = new MarketLevelExample();
        marketLevelExample.setOrderByClause("id desc");
        MarketLevelExample.Criteria criteria = marketLevelExample.createCriteria();

        if(levelModel.getLevelName() != null && !levelModel.getLevelName().isEmpty()){
            criteria.andLevelNameLike("%"+levelModel.getLevelName()+"%");
        }

        List<MarketLevel> marketLevels = marketLevelMapper.selectByExample(marketLevelExample);
        return marketLevels;
    }

    /**
     * 添加销售人员等级
     * @param levelModel
     * @return
     */
    public int addMarketLevel(LevelModel levelModel){
        MarketLevel marketLevel = new MarketLevel();
        if(levelModel.getLevelName() != null && !levelModel.getLevelName().isEmpty()){
            marketLevel.setLevelName(levelModel.getLevelName());
        }
        if(levelModel.getLevelIdentity() != null && !levelModel.getLevelIdentity().isEmpty()){
            marketLevel.setLevelIdentity(levelModel.getLevelIdentity());
        }
        if(levelModel.getMark() != null && !levelModel.getMark().isEmpty()){
            marketLevel.setMark(levelModel.getMark());
        }

        int count = marketLevelMapper.insertSelective(marketLevel);
        return count;
    }

    /**
     * 查询销售人员等级详情
     * @param id
     * @return
     */
    public MarketLevel queryMarketLevelDetail(Integer id){
        return marketLevelMapper.selectByPrimaryKey(id);
    }
    /**
     * 编辑销售人员等级
     * @param levelModel
     * @return
     */
    public int updateMarketLevel(LevelModel levelModel){
        MarketLevel marketLevel = new MarketLevel();
        if(levelModel.getId() != null){
            marketLevel.setId(levelModel.getId());
        }
        if(levelModel.getLevelName() != null && !levelModel.getLevelName().isEmpty()){
            marketLevel.setLevelName(levelModel.getLevelName());
        }
        if(levelModel.getLevelIdentity() != null && !levelModel.getLevelIdentity().isEmpty()){
            marketLevel.setLevelIdentity(levelModel.getLevelIdentity());
        }
        if(levelModel.getMark() != null && !levelModel.getMark().isEmpty()){
            marketLevel.setMark(levelModel.getMark());
        }

        int count = marketLevelMapper.updateByPrimaryKeySelective(marketLevel);
        return count;
    }
}
