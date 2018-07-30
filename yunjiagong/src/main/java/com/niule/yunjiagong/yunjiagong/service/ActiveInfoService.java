package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.dal.mapper.ActiveInfoMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.ActiveInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 30 - 16:41
 */
@Slf4j
@Service
public class ActiveInfoService {

    @Autowired
    private ActiveInfoMapper activeInfoMapper;

    public List<ActiveInfo> getActiveInfo() {
        List<ActiveInfo> activeInfos = activeInfoMapper.selectAll();
        return activeInfos;
    }
}
