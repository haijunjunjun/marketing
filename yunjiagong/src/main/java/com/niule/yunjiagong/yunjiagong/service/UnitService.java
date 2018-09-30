package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.dal.mapper.UnitMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.Unit;
import com.niule.yunjiagong.yunjiagong.model.UnitResponseModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 09 - 30 - 14:31
 */
@Service
public class UnitService {

    @Autowired
    private UnitMapper unitMapper;

    public List<UnitResponseModel> getUnitInfo() {
        List<UnitResponseModel> dataList = new ArrayList<>();
        List<Unit> unitInfoList = unitMapper.getUnitInfo();
        if (Objects.isNull(unitInfoList) && unitInfoList.size() == 0 ){
            return null;
        }
        unitInfoList.forEach(unit -> {
            UnitResponseModel unitResponseModel = new UnitResponseModel();
            unitResponseModel.setId(unit.getId().intValue());
            if (!StringUtils.isEmpty(unit.getUnit()) && unit.getUnit().length() != 0){
                unitResponseModel.setUnit(unit.getUnit());
            }
            dataList.add(unitResponseModel);
        });
        return dataList;
    }

}
