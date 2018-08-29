package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.constants.Enum.TemplateEnum;
import com.niule.yunjiagong.yunjiagong.dal.mapper.SignInfoMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.SignLogMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.SignTemplateMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.SignInfo;
import com.niule.yunjiagong.yunjiagong.dal.model.SignTemplate;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserBaseInfo;
import com.niule.yunjiagong.yunjiagong.service.cloud.UserInfoFeginService;
import com.niule.yunjiagong.yunjiagong.util.BizRuntimeException;
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

    public MessageInfo doSign(String signDateV1) throws ParseException {
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        int userId = userBaseInfo.getId().intValue();
        Date signDate = this.formatDate(signDateV1);
        if (Objects.isNull(userId) || Objects.isNull(signDate)) {
            log.info("参数信息异常！");
            throw new BizRuntimeException("参数信息异常!");
        }
        SignInfo signInfo = new SignInfo();
        signInfo.setUserId(userId);
        SignInfo signInfoV1 = signInfoMapper.selectOne(signInfo);
        SignTemplate signTemplate = signTemplateMapper.selectByPrimaryKey(Integer.parseInt(TemplateEnum.SIGN_TEMPLATE.getCode()));
        Date preOneDate = DateUtils.addDays(signDate, -1);
        MessageInfo messageInfo = new MessageInfo();
        int realDuration;
        if (Objects.isNull(signInfoV1)) {
            signInfoMapper.saveSignInfo(userId, signDate, 1);
            realDuration = 1;
        } else if (!DateUtils.isSameDay(preOneDate, signInfoV1.getSignDate())) {
            signInfoMapper.updateSignInfo(userId, signDate, new Date(), 1);
            realDuration = 1;
        } else {
            signInfoMapper.updateSignInfo(userId, signDate, new Date(), signInfoV1.getDuration() + 1);
            realDuration = signInfoV1.getDuration() + 1;
            if (realDuration % signTemplate.getCycles() == 0) {
                signLogMapper.saveSignLog(userId, signTemplate.getBeans() + "", "用户签到", new Date());
                // TODO: 2018/8/29 更新用户的金豆

            }
        }
        if (realDuration % signTemplate.getCycles() == 0) {
            messageInfo.setContent("恭喜您，已连续签到" + realDuration + "天，获得金豆" + signTemplate.getBeans() + "颗！");
        } else {
            messageInfo.setContent("您已连续签到" + realDuration + "天，再连续签到" + (signTemplate.getCycles() - (realDuration % signTemplate.getCycles())) + "天，可获得"
                    + signTemplate.getBeans() + "颗金豆！");
        }
        return messageInfo;
    }

    public boolean checkSign(String signDateV1) throws ParseException {
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        int userId = userBaseInfo.getId().intValue();
        Date signDate = this.formatDate(signDateV1);
        if (Objects.isNull(userId) || Objects.isNull(signDate)) {
            log.info("参数信息异常！");
            throw new BizRuntimeException("参数信息异常!");
        }
        SignInfo signInfo = new SignInfo();
        signInfo.setUserId(userId);
        signInfo.setSignDate(signDate);
        SignInfo signInfoV1 = signInfoMapper.selectOne(signInfo);
        if (!Objects.isNull(signInfoV1)) {
            return true;
        }
        return false;
    }

    private Date formatDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parseDate = sdf.parse(date);
        return parseDate;
    }
}
