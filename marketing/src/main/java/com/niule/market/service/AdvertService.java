package com.niule.market.service;

import com.niule.market.dao.mapper.AdvertMapper;
import com.niule.market.dao.model.Advert;
import com.niule.market.model.AdvertMakeInfo;
import com.niule.market.util.BizRunTimeException;
import com.niule.market.util.MessageV1;
import com.niule.market.util.QRCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
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

    public MessageV1 makeAdvert(AdvertMakeInfo advertMakeInfo) {
        MessageV1 messageV1 = new MessageV1();
        if (Objects.isNull(advertMakeInfo)) {
            log.info("请输入生成所需要的信息!");
            messageV1.setResult("请输入生成所需要的信息!");
            return messageV1;
        }
        //判断类型 (1:二维码链接 2:url链接)
        if (1 == advertMakeInfo.getType()) {
            if (StringUtils.isEmpty(advertMakeInfo.getEwmUrl())) {
                log.info("二维码路径不能为空!");
                messageV1.setResult("二维码路径不能为空!");
                return messageV1;
            }
            try {
                QRCodeUtil.encode(advertMakeInfo.getEwmUrl(), "", advertMakeInfo.getEwmUrl(), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Advert advert = new Advert();
        advert.setTitle(advertMakeInfo.getTitle());
        advert.setChannelId(advertMakeInfo.getChannel());
        advert.setContent(advertMakeInfo.getContent());
        advert.setEwmUrl(advertMakeInfo.getEwmUrl() == null ? null : advertMakeInfo.getEwmUrl());
        advert.setUrl(advertMakeInfo.getUrl() == null ? null : advertMakeInfo.getUrl());
        advert.setType(advertMakeInfo.getType());
        advert.setCreateTime(new Date());
        int i = advertMapper.insert(advert);
        if (1 != i) {
            log.info("数据保存异常!");
            throw new BizRunTimeException("数据保存异常!");
        }
        messageV1.setResult("success");
        return messageV1;
    }
}
