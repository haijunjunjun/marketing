package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.dal.mapper.ReleaseTypeConfigMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.ReleaseTypeConfig;
import com.niule.yunjiagong.yunjiagong.model.ReleaseTypeResponseModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 10 - 10 - 14:31
 */
@Service
public class ReleaseService {

    @Autowired
    private ReleaseTypeConfigMapper releaseTypeConfigMapper;

    public List<ReleaseTypeResponseModel> getReleaseTypeInfo (){
        List<ReleaseTypeResponseModel> dataList = new ArrayList<>();
        List<ReleaseTypeConfig> releaseTypeConfigs = releaseTypeConfigMapper.selectAll();
        if (!Objects.isNull(releaseTypeConfigs) && releaseTypeConfigs.size() != 0){
            releaseTypeConfigs.forEach(releaseTypeConfig -> {
                ReleaseTypeResponseModel releaseTypeResponseModel = new ReleaseTypeResponseModel();
                if (!StringUtils.isEmpty(releaseTypeConfig.getCode()) && releaseTypeConfig.getCode().length() != 0){
                    releaseTypeResponseModel.setCode(releaseTypeConfig.getCode());
                }
                if (!StringUtils.isEmpty(releaseTypeConfig.getType()) && releaseTypeConfig.getType().length() != 0){
                    releaseTypeResponseModel.setType(releaseTypeConfig.getType());
                }
                if (!StringUtils.isEmpty(releaseTypeConfig.getTypeDesc()) && releaseTypeConfig.getTypeDesc().length() != 0){
                    releaseTypeResponseModel.setTypeDesc(releaseTypeConfig.getTypeDesc());
                }
                dataList.add(releaseTypeResponseModel);
            });
        }
        return dataList;
    }
}
