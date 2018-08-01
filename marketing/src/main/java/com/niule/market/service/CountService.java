package com.niule.market.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niule.market.dao.mapper.AuthNoMapper;
import com.niule.market.dao.model.AuthNo;
import com.niule.market.model.CountModel;
import com.niule.market.util.BizRunTimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 08 - 01 - 13:35
 */
@Slf4j
@Service
public class CountService {

    @Autowired
    private AuthNoMapper authNoMapper;

    public PageInfo<AuthNo> getCountInfo(String workNo, Integer pageNum, Integer pageSize) {
        List<CountModel> countModelList = new ArrayList<>();
        if (StringUtils.isEmpty(workNo)) {
            log.info("参数信息异常!");
            throw new BizRunTimeException("参数信息异常！");
        }
        AuthNo authNo = new AuthNo();
        authNo.setWorkNo(workNo);
        PageHelper.startPage(pageNum == null ? 1 : pageNum, pageSize == null ? 10 : pageSize);
        List<AuthNo> authNoList = authNoMapper.select(authNo);
        PageInfo<AuthNo> data = new PageInfo<AuthNo>(authNoList);
        return data;
    }
}
