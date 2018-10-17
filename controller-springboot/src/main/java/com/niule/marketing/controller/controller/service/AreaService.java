package com.niule.marketing.controller.controller.service;

import com.niule.marketing.controller.controller.dal.mapper.AreaCityMapper;
import com.niule.marketing.controller.controller.dal.mapper.AreaMapper;
import com.niule.marketing.controller.controller.dal.model.Area;
import com.niule.marketing.controller.controller.dal.model.AreaCity;
import com.niule.marketing.controller.controller.dal.model.AreaCityExample;
import com.niule.marketing.controller.controller.dal.model.AreaExample;
import com.niule.marketing.controller.controller.model.AreaAndCityModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author LsAusi
 * @date 2018/9/20
 * @time 15:15
 **/
@Slf4j
@Service
public class AreaService {
    @Autowired
    private AreaMapper areaMapper;

    @Autowired
    private AreaCityMapper areaCityMapper;


    public List<Area> getAreaList(String areaName){
        AreaExample areaExample = new AreaExample();
        areaExample.setOrderByClause("id desc");
        AreaExample.Criteria criteria = areaExample.createCriteria();
        if(areaName != null && !areaName.isEmpty()){
            criteria.andAreaNameLike("%"+areaName+"%");
        }
        List<Area> areaList = areaMapper.selectByExample(areaExample);
        return  areaList;
    }

    /**
     * 添加区域以及对应的线下城市
     * @param areaAndCityModel
     * @return
     */
    public int addAreaAndCity(AreaAndCityModel areaAndCityModel){
        Area area = new Area();
        AreaCity areaCity  = new AreaCity();

        if(areaAndCityModel.getAreaName() != null && !areaAndCityModel.getAreaName().isEmpty()){
            area.setAreaName(areaAndCityModel.getAreaName());
        }
        if(areaAndCityModel.getAreaNo() != null && !areaAndCityModel.getAreaNo().isEmpty()){
            area.setAreaNo(areaAndCityModel.getAreaNo());
        }

        if(areaAndCityModel.getAreaMark() != null && !areaAndCityModel.getAreaMark().isEmpty()){
            area.setMark(areaAndCityModel.getAreaMark());
        }
        area.setCreateTime(new Date());
        area.setModifyTime(new Date());
        int count = areaMapper.insertSelective(area);

        if(count> 0 ){
            if(areaAndCityModel.getCityName() != null && !areaAndCityModel.getCityName().isEmpty()){
                String str = areaAndCityModel.getCityName();
                String[] strings=str.split(",");
                for(int i=0,len=strings.length;i<len;i++){
                    areaCity.setAreaName(areaAndCityModel.getAreaName());
                    areaCity.setAreaNo(areaAndCityModel.getAreaNo());
                    areaCity.setCityName(strings[i].toString());
                    areaCity.setCreateTime(new Date());
                    areaCity.setModifyTime(new Date());
                    areaCity.setMark(areaAndCityModel.getCityMark());
                    areaCity.setAreaId(area.getId());
                    areaCityMapper.insertSelective(areaCity);
                }
            }
        }

        return count;
    }

    /**
     * 根据区域id查询区域详情
     * @param id
     * @return
     */
    public Area getAreaDetails(Integer id){
        return areaMapper.selectByPrimaryKey(id);
    }


    /**
     * 根据区域编号查询该区域下对应的线下城市
     * @param areaNo
     * @return
     */
    public List<AreaCity> getAreaCityList(String areaNo){
        AreaCityExample areaCityExample = new AreaCityExample();
        areaCityExample.setOrderByClause("id desc");
        areaCityExample.createCriteria().andAreaNoEqualTo(areaNo);

        List<AreaCity> areaCityList = areaCityMapper.selectByExample(areaCityExample);
        return areaCityList;
    }

    /**
     * 查询是否已经存在输入的区域名称
     * @param areaName
     * @param areaId
     * @return
     */
    public int areaNameIsExist(String areaName,Integer areaId){
        AreaExample areaExample = new AreaExample();
        AreaExample.Criteria criteria = areaExample.createCriteria();
        if(areaId == null){
            if(areaName != null && !areaName.isEmpty()){
                criteria.andAreaNameEqualTo(areaName);
            }
        }else {
            if(areaName != null && !areaName.isEmpty()){
                criteria.andAreaNameEqualTo(areaName).andIdNotEqualTo(areaId);
            }
        }
        int count  = areaMapper.countByExample(areaExample);
        return count;
    }

    /**
     * 查询是否已经存在输入的区域编号
     * @param areaNo
     * @param areaId
     * @return
     */
    public int areaNOIsExist(String areaNo,Integer areaId){
        AreaExample areaExample = new AreaExample();
        AreaExample.Criteria criteria = areaExample.createCriteria();
        if(areaId == null){
            if(areaNo != null && !areaNo.isEmpty()){
                criteria.andAreaNoEqualTo(areaNo);
            }
        }else {
            if(areaNo != null && !areaNo.isEmpty()){
                criteria.andAreaNoEqualTo(areaNo).andIdNotEqualTo(areaId);
            }
        }
        int count  = areaMapper.countByExample(areaExample);
        return count;

    }

    /**
     * 编辑区域信息
     * @param areaAndCityModel
     * @return
     */
    public int updateArea(AreaAndCityModel areaAndCityModel){
        Area area = new Area();
        if(areaAndCityModel.getAreaId() != null){
            area.setId(areaAndCityModel.getAreaId());
        }
        if(areaAndCityModel.getAreaName() !=  null && !areaAndCityModel.getAreaName().isEmpty()){
            area.setAreaName(areaAndCityModel.getAreaName());
        }
        if(areaAndCityModel.getAreaNo() != null && !areaAndCityModel.getAreaNo().isEmpty()){
            area.setAreaNo(areaAndCityModel.getAreaNo());
        }

        if(areaAndCityModel.getAreaMark()!= null && !areaAndCityModel.getAreaMark().isEmpty()){
            area.setMark(areaAndCityModel.getAreaMark());
        }
        area.setModifyTime(new Date());
        int count  = areaMapper.updateByPrimaryKeySelective(area);

        if(count > 0 ){
//            AreaCity areaCity = new AreaCity();
            AreaCityExample areaCityExample = new AreaCityExample();
            areaCityExample.createCriteria().andAreaIdEqualTo(areaAndCityModel.getAreaId());
            List<AreaCity> areaCityList = areaCityMapper.selectByExample(areaCityExample);
            for(AreaCity areaCity : areaCityList){
                areaCity.setAreaName(areaAndCityModel.getAreaName());
                areaCity.setAreaNo(areaAndCityModel.getAreaNo());
                areaCity.setAreaId(areaAndCityModel.getAreaId());
                areaCity.setModifyTime(new Date());
                areaCityMapper.updateByPrimaryKeySelective(areaCity);
            }

        }

        return count;
    }
}
