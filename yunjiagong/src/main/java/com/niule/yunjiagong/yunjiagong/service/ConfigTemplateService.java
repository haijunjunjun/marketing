package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.dal.mapper.ConfigTemplateMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 08 - 29 - 11:52
 */
@Slf4j
@Service
public class ConfigTemplateService {

    @Autowired
    private ConfigTemplateMapper configTemplateMapper;

    public List<Integer> getConfigTemplateValue(Integer type, Integer userStatus) {
        List<Integer> changeCountInfo = configTemplateMapper.getChangeCountBytypeAndUserstatus(type, userStatus);
        return changeCountInfo;
    }
}
