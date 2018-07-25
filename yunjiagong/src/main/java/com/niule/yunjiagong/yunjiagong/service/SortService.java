package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.dal.mapper.SortTypeMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.SortType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 11:50
 */
@Slf4j
@Service
public class SortService {

    @Autowired
    private SortTypeMapper sortTypeMapper;

    public List<SortType> getSortType() {
        return sortTypeMapper.getSortType();
    }
}
