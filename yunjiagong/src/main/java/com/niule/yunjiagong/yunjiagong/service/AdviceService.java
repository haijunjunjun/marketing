package com.niule.yunjiagong.yunjiagong.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.niule.yunjiagong.yunjiagong.constants.Enum.AdviceResponseEnum;
import com.niule.yunjiagong.yunjiagong.dal.mapper.AdviceResponseMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.AdviceResponse;
import com.niule.yunjiagong.yunjiagong.model.AdviceRequestModel;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserBaseInfo;
import com.niule.yunjiagong.yunjiagong.service.cloud.UserInfoFeginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 09 - 29 - 14:53
 */
@Service
public class AdviceService {

    @Autowired
    private AdviceResponseMapper adviceResponseMapper;
    @Autowired
    private UserInfoFeginService userInfoFeginService;

    public String submitAdvice (AdviceRequestModel adviceRequestModel){
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        Integer userId = userBaseInfo.getId().intValue();
        if (Objects.isNull(userId)){
            return "userId 为空";
        }
        AdviceResponse adviceResponse = new AdviceResponse();
        adviceResponse.setUserId(userId);
        if (!StringUtils.isEmpty(adviceRequestModel.getQuestionType()) && adviceRequestModel.getQuestionType().length() != 0){
            adviceResponse.setQuestionType(adviceRequestModel.getQuestionType());
        }
        if (!StringUtils.isEmpty(adviceRequestModel.getDetailQuestion()) && adviceRequestModel.getDetailQuestion().length() != 0){
            adviceResponse.setQuestionDetail(adviceRequestModel.getDetailQuestion());
        }
        if (!StringUtils.isEmpty(adviceRequestModel.getQuestionImg()) && adviceRequestModel.getQuestionImg().length() != 0){
            adviceResponse.setQuestionImgs(adviceRequestModel.getQuestionImg());
        }
        adviceResponse.setCreateTime(new Date());
        int insert = adviceResponseMapper.insert(adviceResponse);
        if (1 != insert){
            return "插入操作失败";
        }
        return "success";
    }
}
