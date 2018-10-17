package com.niule.marketing.controller.controller.service;

import com.niule.marketing.controller.controller.dal.mapper.ManageLevelMapper;
import com.niule.marketing.controller.controller.dal.model.ManageLevel;
import com.niule.marketing.controller.controller.dal.model.ManageLevelExample;
import com.niule.marketing.controller.controller.model.LevelModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LsAusi
 * @date 2018/9/18
 * @time 17:53
 **/
@Slf4j
@Service
public class ManageLevelService {
    @Autowired
    private ManageLevelMapper manageLevelMapper;


    /**
     * 查询销售管理等级
     * @param levelName
     * @return
     */
    public List<ManageLevel> getManageLevelList(String levelName){
        ManageLevelExample manageLevelExample = new ManageLevelExample();
        manageLevelExample.setOrderByClause("id desc");
        ManageLevelExample.Criteria criteria = manageLevelExample.createCriteria();

        if(levelName != null && !levelName.isEmpty()){
            criteria.andLevelNameLike("%"+levelName+"%");
        }

        List<ManageLevel> manageLevels = manageLevelMapper.selectByExample(manageLevelExample);
        return manageLevels;
    }

    /**
     * 添加销售管理等级
     * @param levelModel
     * @return
     */
    public int addManageLevel(LevelModel levelModel){
        ManageLevel manageLevel = new ManageLevel();
        if(levelModel.getLevelName() != null && !levelModel.getLevelName().isEmpty()){
            manageLevel.setLevelName(levelModel.getLevelName());
        }
        if(levelModel.getLevelIdentity() != null && !levelModel.getLevelIdentity().isEmpty()){
            manageLevel.setLevelIdentity(levelModel.getLevelIdentity());
        }
        if(levelModel.getMark() != null && !levelModel.getMark().isEmpty()){
            manageLevel.setMark(levelModel.getMark());
        }

        int count = manageLevelMapper.insertSelective(manageLevel);
        return count;
    }

    /**
     * 查询销售人员等级详情
     * @param id
     * @return
     */
    public ManageLevel queryManageLevel(Integer id){
        return manageLevelMapper.selectByPrimaryKey(id);
    }
    /**
     * 编辑销售人员等级
     * @param levelModel
     * @return
     */
    public int updateManageLevel(LevelModel levelModel){
        ManageLevel manageLevel = new ManageLevel();
        if(levelModel.getId() != null){
            manageLevel.setId(levelModel.getId());
        }
        if(levelModel.getLevelName() != null && !levelModel.getLevelName().isEmpty()){
            manageLevel.setLevelName(levelModel.getLevelName());
        }
        if(levelModel.getLevelIdentity() != null && !levelModel.getLevelIdentity().isEmpty()){
            manageLevel.setLevelIdentity(levelModel.getLevelIdentity());
        }
        if(levelModel.getMark() != null && !levelModel.getMark().isEmpty()){
            manageLevel.setMark(levelModel.getMark());
        }

        int count = manageLevelMapper.updateByPrimaryKeySelective(manageLevel);
        return count;
    }
}
