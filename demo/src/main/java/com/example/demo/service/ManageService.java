package com.example.demo.service;

import com.example.demo.dal.mapper.CustomerInfoMapper;
import com.example.demo.dal.mapper.GoldBeansApplyMapper;
import com.example.demo.dal.mapper.UserGoldBeansMapper;
import com.example.demo.dal.mapper.UserInfoMapper;
import com.example.demo.dal.model.GoldBeansApply;
import com.example.demo.dal.model.UserInfo;
import com.example.demo.model.GoldBeansCheck;
import com.example.demo.model.SaleInfo;
import com.example.demo.model.SaleList;
import com.example.demo.util.BizRuntimeException;
import com.example.demo.util.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
public class ManageService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private GoldBeansApplyMapper goldBeansApplyMapper;
    @Autowired
    private UserGoldBeansMapper userGoldBeansMapper;
    @Autowired
    private PerformanceConfigService performanceConfigService;

    public List<SaleList> getSaleListInfo(Integer manageId) {
        List<SaleList> saleListList = new ArrayList<>();
        if (StringUtils.isEmpty(manageId.toString())) {
            log.info("manageId 参数信息有误!");
            throw new BizRuntimeException("manageId 参数信息有误!");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setManageId(manageId);
        List<UserInfo> dataList = userInfoMapper.select(userInfo);
        for (UserInfo u : dataList) {
            SaleList saleList = new SaleList();
            SaleInfo saleInfo = this.getSaleInfo(u.getId());
            saleList.setImageUrl(saleInfo.getImageUrl());
            saleList.setPhone(saleInfo.getPhone());
            saleList.setRealName(saleInfo.getRealName());
            saleList.setSaleType(saleInfo.getSaleType());
            Map<String, Integer> saleNum = this.getSaleNum(u.getId());
            saleList.setMonthNum(saleNum.get("monthNum"));
            saleList.setWeekNum(saleNum.get("weekNum"));
            saleListList.add(saleList);
        }
        return saleListList;
    }

    public List<GoldBeansCheck> getGoldBeansCheckList(Integer manageId) {
        List<GoldBeansCheck> goldBeansCheckList = new ArrayList<>();
        if (StringUtils.isEmpty(manageId.toString())) {
            log.info("manageId 参数信息有误!");
            throw new BizRuntimeException("manageId 参数信息有误!");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setManageId(manageId);
        List<UserInfo> dataList = userInfoMapper.select(userInfo);
        for (UserInfo u : dataList) {
            List<GoldBeansApply> goldBeansApplyNum = this.getGoldBeansApplyNum(u.getId());
            for (GoldBeansApply g : goldBeansApplyNum) {
                GoldBeansCheck goldBeansCheck = new GoldBeansCheck();
                goldBeansCheck.setImageUrl(u.getImageUrl());
                goldBeansCheck.setPhone(u.getPhone());
                goldBeansCheck.setRealName(u.getRealName());
                goldBeansCheck.setApplyNum(g.getGoldBeansApplyNum());
                goldBeansCheck.setApplyId(g.getId());
                goldBeansCheckList.add(goldBeansCheck);
            }
        }
        return goldBeansCheckList;
    }

    public MessageInfo goldBeansCheck(Integer applyId, Integer status, String refuseReason) {
        MessageInfo messageInfo = new MessageInfo();
        if (StringUtils.isEmpty(applyId.toString())) {
            log.info("applyId 参数信息有误!");
            throw new BizRuntimeException("applyId 参数信息有误!");
        }
        GoldBeansApply goldBeansApply = goldBeansApplyMapper.selectByPrimaryKey(applyId);
        if (Objects.isNull(goldBeansApply)) {
            log.info("数据查询异常!");
            throw new BizRuntimeException("数据查询异常!");
        }
        if (2 == status) {
            GoldBeansApply goldBeans = new GoldBeansApply();
            goldBeans.setId(applyId);
            goldBeans.setStatus(status);
            goldBeans.setCheckTime(new Date());
            goldBeansApplyMapper.updateByPrimaryKeySelective(goldBeans);
            userGoldBeansMapper.updateGoldBeansNum(goldBeansApply.getGoldBeansApplyNum(), goldBeansApply.getUserId(), new Date());
            messageInfo.setContent("success");
            return messageInfo;
        }
        if (3 == status) {
            GoldBeansApply goldBeans = new GoldBeansApply();
            goldBeans.setId(applyId);
            goldBeans.setStatus(status);
            goldBeans.setCheckTime(new Date());
            goldBeans.setRefuseReason(refuseReason);
            goldBeansApplyMapper.updateByPrimaryKeySelective(goldBeans);
            messageInfo.setContent("success");
            return messageInfo;
        }
        messageInfo.setContent("审核信息异常!");
        return messageInfo;
    }


    private SaleInfo getSaleInfo(Integer userId) {
        if (StringUtils.isEmpty(userId.toString())) {
            log.info("参数信息有误!");
            throw new BizRuntimeException("参数信息有误！");
        }
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        if (Objects.isNull(userId)) {
            log.info("数据查询异常!");
            throw new BizRuntimeException("数据查询异常!");
        }
        SaleInfo saleInfo = new SaleInfo();
        saleInfo.setImageUrl(userInfo.getImageUrl());
        saleInfo.setPhone(userInfo.getPhone());
        saleInfo.setRealName(userInfo.getRealName());
        saleInfo.setSaleType(userInfo.getRoleId() == 1 ? "销售" : "other");
        return saleInfo;
    }

    private Map<String, Integer> getSaleNum(Integer userId) {
        Map<String, Integer> map = new HashMap<>();
        if (StringUtils.isEmpty(userId.toString())) {
            log.info("参数信息异常");
            throw new BizRuntimeException("参数信息异常!");
        }
        Integer monthNum = customerInfoMapper.getMonthNum(userId, getDt(new Date()));
        Map<String, String> mapInfo = getMapInfo(performanceConfigService.getTimeInterval(new Date()));
        Integer weekNum = customerInfoMapper.getWeekNum(userId, mapInfo.get("begin"), mapInfo.get("end"));
        map.put("monthNum", monthNum);
        map.put("weekNum", weekNum);
        return map;

    }

    private Map<String, String> getMapInfo(String str) {
        Map<String, String> map = new HashMap<>();
        String[] data = str.trim().split(",");
        map.put("begin", data[0]);
        map.put("end", data[1]);
        return map;
    }

    private String getDt(Date date) {
        if (Objects.isNull(date)) {
            log.info("日期参数信息有误!");
            throw new BizRuntimeException("日期参数信息有误!");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String dtInfo = sdf.format(date);
        return dtInfo;
    }

    private List<GoldBeansApply> getGoldBeansApplyNum(Integer userId) {
        GoldBeansApply goldBeansApply = new GoldBeansApply();
        goldBeansApply.setType(1);
        goldBeansApply.setStatus(1);
        goldBeansApply.setUserId(userId);
        List<GoldBeansApply> dataList = goldBeansApplyMapper.select(goldBeansApply);
        return dataList;
    }
}
