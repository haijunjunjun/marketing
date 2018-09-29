package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.constants.Enum.TemplateEnum;
import com.niule.yunjiagong.yunjiagong.dal.mapper.SignInfoMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.SignLogMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.SignTemplateMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.SignInfo;
import com.niule.yunjiagong.yunjiagong.dal.model.SignLog;
import com.niule.yunjiagong.yunjiagong.dal.model.SignTemplate;
import com.niule.yunjiagong.yunjiagong.model.SignInfoModel;
import com.niule.yunjiagong.yunjiagong.model.cloud.SystemPayRequest;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserBaseInfo;
import com.niule.yunjiagong.yunjiagong.service.cloud.UserGoldBeansFeginService;
import com.niule.yunjiagong.yunjiagong.service.cloud.UserInfoFeginService;
import com.niule.yunjiagong.yunjiagong.util.BizRuntimeException;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import com.niule.yunjiagong.yunjiagong.util.DateUtilV1;
import com.niule.yunjiagong.yunjiagong.util.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 07 - 26 - 9:20
 */
@Slf4j
@Service
public class SignService {

    @Autowired
    private SignInfoMapper signInfoMapper;
    @Autowired
    private SignTemplateMapper signTemplateMapper;
    @Autowired
    private SignLogMapper signLogMapper;
    @Autowired
    private UserInfoFeginService userInfoFeginService;
    @Autowired
    private UserGoldBeansFeginService userGoldBeansFeginService;

    public MessageInfo doSign() {
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        Integer userId = userBaseInfo.getId().intValue();
//        Integer userId = 48;
//        Date signDate = this.formatDate(signDateV1);
        Date signDate = new Date();
        if (Objects.isNull(userId) || Objects.isNull(signDate)) {
            log.info("参数信息异常！");
            throw new BizRuntimeException("参数信息异常!");
        }
        SignInfo signInfo = new SignInfo();
        signInfo.setUserId(userId);
        SignInfo signInfoV1 = signInfoMapper.selectOne(signInfo);
        SignTemplate signTemplate = signTemplateMapper.selectByPrimaryKey(Integer.parseInt(TemplateEnum.SIGN_TEMPLATE.getCode()));
        SignTemplate signTemplateV1 = signTemplateMapper.selectByPrimaryKey(Integer.parseInt(TemplateEnum.SIGN_TEMPLATE_V1.getCode()));
//        SignTemplate signTemplate = this.getSignTemplate();
        Date preOneDate = DateUtils.addDays(signDate, -1);
        MessageInfo messageInfo = new MessageInfo();
        int realDuration = 0;
        Integer randomGoldBeans = 0;
        if (Objects.isNull(signInfoV1)) {
            signLogMapper.saveSignLog(userId, 0 + "", "用户签到", new Date());
            signInfoMapper.saveSignInfo(userId, signDate, 1);
            realDuration = 1;
        } else if (!DateUtils.isSameDay(preOneDate, signInfoV1.getSignDate())) {
            signLogMapper.saveSignLog(userId, 0 + "", "用户签到", new Date());
            signInfoMapper.updateSignInfo(userId, signDate, new Date(), 1);
            realDuration = 1;
        } else {
            signInfoMapper.updateSignInfo(userId, signDate, new Date(), signInfoV1.getDuration() + 1);
            realDuration = signInfoV1.getDuration() + 1;

            SystemPayRequest systemPayRequest = new SystemPayRequest();
            systemPayRequest.setUserId(userId.longValue());
            systemPayRequest.setPayAmount(0l);
            systemPayRequest.setTargetType(2);
            systemPayRequest.setDesc("用户签到赠送金豆");
            if (realDuration % signTemplateV1.getCycles() == signTemplate.getCycles()) {
                signLogMapper.saveSignLog(userId, signTemplate.getBeans() + "", "用户签到", new Date());
                systemPayRequest.setBuyAmount(signTemplate.getBeans().longValue());
                DataResponse dataResponse = userGoldBeansFeginService.updateUserGoldBeans(systemPayRequest);
                log.info("dataResponse is :" + dataResponse);
            }
            if (realDuration % signTemplateV1.getCycles() == 0) {
                randomGoldBeans = 1 + (int) (Math.random() * (signTemplateV1.getBeans() - 1 + 1));
                signLogMapper.saveSignLog(userId, randomGoldBeans + "", "用户签到", new Date());
                systemPayRequest.setBuyAmount(randomGoldBeans.longValue());
                DataResponse dataResponse = userGoldBeansFeginService.updateUserGoldBeans(systemPayRequest);
                log.info("dataResponse is :" + dataResponse);
            }
            signLogMapper.saveSignLog(userId, 0 + "", "用户签到", new Date());
        }
        if (realDuration % signTemplateV1.getCycles() == signTemplate.getCycles()) {
            messageInfo.setContent("恭喜您，已连续签到" + realDuration + "天，获得金豆" + signTemplate.getBeans() + "颗！");
            messageInfo.setGoldBeans(signTemplate.getBeans());
        }
        if (realDuration % signTemplateV1.getCycles() == 0) {
            messageInfo.setContent("恭喜您，已连续签到" + realDuration + "天，获得金豆" + randomGoldBeans + "颗！");
            messageInfo.setGoldBeans(randomGoldBeans);
        }
        messageInfo.setRealDuration(realDuration);
        return messageInfo;
    }

    public SignInfoModel getSignInfo() {
        SignInfoModel signInfoModel = new SignInfoModel();
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        Integer userId = userBaseInfo.getId().intValue();
        SignLog signLogInfo = signLogMapper.getSignInfo(userId, DateUtilV1.dateV3(new Date()));
        if (!Objects.isNull(signLogInfo)) {
                signInfoModel.setSign(this.checkSign());
                SignInfo signInfo = new SignInfo();
                signInfo.setUserId(userId);
                SignInfo signInfoV1 = signInfoMapper.selectOne(signInfo);
                if (!Objects.isNull(signInfoV1)){
                    signInfoModel.setRealDuration(signInfoV1.getDuration());
                    if (signInfoV1.getDuration() % 7 == 3){
                        signInfoModel.setGoldBeans(Integer.parseInt(signLogInfo.getBeans()));
                    }
                    if (signInfoV1.getDuration() % 7 == 0){
                        signInfoModel.setRandomGoldBeans(Integer.parseInt(signLogInfo.getBeans()));
                    }
                }
        }else {
            signInfoModel.setSign(this.checkSign());
            signInfoModel.setGoldBeans(0);
            SignInfo signInfo = new SignInfo();
            signInfo.setUserId(userId);
            SignInfo signInfoV1 = signInfoMapper.selectOne(signInfo);
            if (!Objects.isNull(signInfoV1)){
                signInfoModel.setRealDuration(signInfoV1.getDuration());
            }
        }
        return signInfoModel;
    }

    public boolean checkSign() {
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        int userId = userBaseInfo.getId().intValue();
        int i = signInfoMapper.checkSign(userId, DateUtilV1.dateV3(new Date()));
        if (i > 0) {
            return true;
        }
        return false;
    }


    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private Date formatDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parseDate = sdf.parse(date);
        return parseDate;
    }

    public SignTemplate getSignTemplate() {
        log.info("开始");
        return signTemplateMapper.selectByPrimaryKey(Integer.parseInt(TemplateEnum.SIGN_TEMPLATE.getCode()));
    }
}
