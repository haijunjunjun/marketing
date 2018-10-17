package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.constants.Enum.TemplateEnum;
import com.niule.yunjiagong.yunjiagong.dal.mapper.SignGoldBeansMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.SignInfoMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.SignLogMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.SignTemplateMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.SignGoldBeans;
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
import java.util.Date;
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
    @Autowired
    private SignGoldBeansMapper signGoldBeansMapper;

    public MessageInfo doSign() {
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        Integer userId = userBaseInfo.getId().intValue();
//        Integer userId = 90;
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

            if (realDuration > 1 && realDuration % 7 == 1){
                signGoldBeansMapper.updateSignGoldBeansInfo(userId,0,0);
            }
            if ((realDuration - 1) % signTemplateV1.getCycles() + 1 == signTemplate.getCycles()) {
                signLogMapper.saveSignLog(userId, signTemplate.getBeans() + "", "用户签到", new Date());
                systemPayRequest.setBuyAmount(signTemplate.getBeans().longValue());
                DataResponse dataResponse = userGoldBeansFeginService.updateUserGoldBeans(systemPayRequest);
                log.info("dataResponse is :" + dataResponse);
            } else if ((realDuration - 1) % signTemplateV1.getCycles() + 1 == signTemplateV1.getCycles()) {
                randomGoldBeans = 1 + (int) (Math.random() * (signTemplateV1.getBeans() - 1 + 1));
                signLogMapper.saveSignLog(userId, randomGoldBeans + "", "用户签到", new Date());
                systemPayRequest.setBuyAmount(randomGoldBeans.longValue());
                DataResponse dataResponse = userGoldBeansFeginService.updateUserGoldBeans(systemPayRequest);
                log.info("dataResponse is :" + dataResponse);
            } else {
                signLogMapper.saveSignLog(userId, 0 + "", "用户签到", new Date());
            }
        }
        if ((realDuration - 1) % signTemplateV1.getCycles() + 1 == signTemplate.getCycles()) {
            messageInfo.setContent("恭喜您，已连续签到" + realDuration + "天，获得金豆" + signTemplate.getBeans() + "颗！");
            messageInfo.setGoldBeans(signTemplate.getBeans());

            signGoldBeansMapper.updateSignThreeGoldBeans(userId,signTemplate.getBeans());

        }
        if ((realDuration - 1) % signTemplateV1.getCycles() + 1 == signTemplateV1.getCycles()) {
            messageInfo.setContent("恭喜您，已连续签到" + realDuration + "天，获得金豆" + randomGoldBeans + "颗！");
            messageInfo.setGoldBeans(randomGoldBeans);

            signGoldBeansMapper.updateSignSevenGoldBeans(userId,randomGoldBeans);
        }
        messageInfo.setRealDuration(realDuration);
        return messageInfo;
    }

    public SignInfoModel getSignInfo() {
        SignInfoModel signInfoModel = new SignInfoModel();
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        Integer userId = userBaseInfo.getId().intValue();

        SignInfo signInfo = new SignInfo();
        signInfo.setUserId(userId);
        SignInfo signInfoV1 = signInfoMapper.selectOne(signInfo);
        Date preOneDate = DateUtils.addDays(new Date(), -1);

        SignGoldBeans signGoldBeans = new SignGoldBeans();
        signGoldBeans.setUserId(userId);
        SignGoldBeans signGoldBeansInfo = signGoldBeansMapper.selectOne(signGoldBeans);
        if (Objects.isNull(signGoldBeansInfo)){
            SignGoldBeans signGoldBeansV1 = new SignGoldBeans();
            signGoldBeansV1.setUserId(userId);
            signGoldBeansV1.setCreateTime(new Date());
            signGoldBeansV1.setModifyTime(new Date());
            signGoldBeansV1.setThreeGoldBeans(0);
            signGoldBeansV1.setSevenGoldBeans(0);
            signGoldBeansMapper.insert(signGoldBeansV1);
            signGoldBeansInfo = signGoldBeansV1;
        }

        signInfoModel.setSign(this.checkSign());
        if (Objects.isNull(signInfoV1)){
            signInfoModel.setRealDuration(0);
            signInfoModel.setGoldBeans(signGoldBeansInfo.getThreeGoldBeans());
            signInfoModel.setRandomGoldBeans(signGoldBeansInfo.getSevenGoldBeans());
            return signInfoModel;
        }

        SignLog signLog = new SignLog();
        signLog.setUserId(userId);
        int i = signLogMapper.selectCount(signLog);
        if (i>= 2){
            SignLog signInfo1 = signLogMapper.getSignInfo(userId, DateUtilV1.dateV3(preOneDate));
            if (Objects.isNull(signInfo1)){
                signGoldBeansMapper.updateSignGoldBeansInfo(userId,0,0);

                signInfoModel.setGoldBeans(signGoldBeansInfo.getThreeGoldBeans());
                signInfoModel.setRealDuration(signInfoV1.getDuration());
                signInfoModel.setRandomGoldBeans(signGoldBeansInfo.getSevenGoldBeans());
                return signInfoModel;
            }
        }
        Integer duration = signInfoV1.getDuration();
        signInfoModel.setGoldBeans(signGoldBeansInfo.getThreeGoldBeans());
        signInfoModel.setRealDuration(duration);
        signInfoModel.setRandomGoldBeans(signGoldBeansInfo.getSevenGoldBeans());
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
