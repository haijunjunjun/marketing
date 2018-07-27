package com.niule.market.service;

import com.niule.market.dao.mapper.AdvertMapper;
import com.niule.market.dao.mapper.AuthNoMapper;
import com.niule.market.dao.mapper.ChannelMapper;
import com.niule.market.dao.mapper.WorkAuthNoMapper;
import com.niule.market.dao.model.Advert;
import com.niule.market.dao.model.AuthNo;
import com.niule.market.dao.model.WorkAuthNo;
import com.niule.market.model.AdvertMakeInfo;
import com.niule.market.util.BizRunTimeException;
import com.niule.market.util.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 07 - 18 - 14:11
 */
@Slf4j
@Service
public class AdvertService {

    @Autowired
    private AdvertMapper advertMapper;
    @Autowired
    private AuthNoMapper authNoMapper;
    @Autowired
    private ChannelMapper channelMapper;
    @Autowired
    private WorkAuthNoMapper workAuthNoMapper;

//    public MessageV1 makeAdvert(AdvertMakeInfo advertMakeInfo) {
//        MessageV1 messageV1 = new MessageV1();
//        if (Objects.isNull(advertMakeInfo)) {
//            log.info("请输入生成所需要的信息!");
//            messageV1.setResult("请输入生成所需要的信息!");
//            return messageV1;
//        }
//        //判断类型 (1:二维码链接 2:url链接)
//        if (1 == advertMakeInfo.getType()) {
//            if (StringUtils.isEmpty(advertMakeInfo.getEwmUrl())) {
//                log.info("二维码路径不能为空!");
//                messageV1.setResult("二维码路径不能为空!");
//                return messageV1;
//            }
//            try {
//                QRCodeUtil.encode(advertMakeInfo.getEwmUrl(), "", advertMakeInfo.getEwmUrl(), true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        Advert advert = new Advert();
//        advert.setTitle(advertMakeInfo.getTitle());
//        advert.setChannelId(advertMakeInfo.getChannel());
//        advert.setContent(advertMakeInfo.getContent());
//        advert.setEwmUrl(advertMakeInfo.getEwmUrl() == null ? null : advertMakeInfo.getEwmUrl());
//        advert.setUrl(advertMakeInfo.getUrl() == null ? null : advertMakeInfo.getUrl());
//        advert.setType(advertMakeInfo.getType());
//        advert.setCreateTime(new Date());
//        int i = advertMapper.insert(advert);
//        if (1 != i) {
//            log.info("数据保存异常!");
//            throw new BizRunTimeException("数据保存异常!");
//        }
//        messageV1.setResult("success");
//        return messageV1;
//    }

    public MessageInfo<AdvertMakeInfo> makeAdvertV1(String qq, String workNo) {
        MessageInfo<AdvertMakeInfo> messageInfo = new MessageInfo<>();
        if (StringUtils.isEmpty(qq)) {
            messageInfo.setResult("qq号不能为空");
            return messageInfo;
        }
        if (StringUtils.isEmpty(workNo)) {
            messageInfo.setResult("工号不能为空");
            return messageInfo;
        }
        WorkAuthNo workAuthNo = new WorkAuthNo();
        workAuthNo.setWorkNo(workNo);
        workAuthNo.setStatus(1);
        WorkAuthNo workAuthNoInfo = workAuthNoMapper.selectOne(workAuthNo);
        if (Objects.isNull(workAuthNoInfo)) {
            log.info("该工号目前还没有授权！");
            messageInfo.setResult("该工号目前还没有授权!");
            return messageInfo;
        }
        AdvertMakeInfo advertMakeInfo = new AdvertMakeInfo();
        Advert advert = advertMapper.selectByPrimaryKey(1);
        advertMakeInfo.setIcon(advert.getIcon());
        advertMakeInfo.setContent(advert.getContent());
        advertMakeInfo.setEwmUrl(advert.getEwmUrl());
        advertMakeInfo.setTitle(advert.getTitle());
        advertMakeInfo.setUrl(advert.getUrl());

        AuthNo authNo = new AuthNo();
        authNo.setAdvertId(1);
        authNo.setQq(qq);
        authNo.setWorkNo(workNo);
        int i = authNoMapper.insertSelective(authNo);
        if (1 != i) {
            log.info("信息存储异常!");
            throw new BizRunTimeException("信息存储异常!");
        }
        messageInfo.setData(advertMakeInfo);
        messageInfo.setResult("success");
        return messageInfo;
    }

    public String getChannel(Integer channelId) {
        return channelMapper.selectByPrimaryKey(channelId).getValue();
    }

}
