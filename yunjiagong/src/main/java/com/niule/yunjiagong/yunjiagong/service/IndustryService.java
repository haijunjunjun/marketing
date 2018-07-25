package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.dal.mapper.IndustryMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.Industry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 11:29
 */
@Service
public class IndustryService {

    @Autowired
    private IndustryMapper industryMapper;

    public List<Industry> getIndustryInfo() {
        return industryMapper.getIndustryInfo();
    }
}
