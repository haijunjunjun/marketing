package com.niule.yunjiagong.yunjiagong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niule.yunjiagong.yunjiagong.config.enums.ActionType;
import com.niule.yunjiagong.yunjiagong.dal.mapper.ConfigTemplateMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.SubscribeMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.Subscribe;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserBaseInfo;
import com.niule.yunjiagong.yunjiagong.service.cloud.UserInfoFeginService;
import com.niule.yunjiagong.yunjiagong.util.BizRuntimeException;
import com.niule.yunjiagong.yunjiagong.util.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 07 - 30 - 9:19
 */
@Slf4j
@Service
public class SubscribeService {

    @Autowired
    private SubscribeMapper subscribeMapper;
    @Autowired
    private UserInfoFeginService userInfoFeginService;
    @Autowired
    private ConfigTemplateMapper configTemplateMapper;

    public PageInfo<Subscribe> getSubscribe(Integer pageNum, Integer pageSize) {
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        int userId = userBaseInfo.getId().intValue();
        PageHelper.startPage(pageNum == null ? 1 : pageNum, pageSize == null ? 10 : pageSize);
        Subscribe subscribe = new Subscribe();
        subscribe.setUserId(userId);
        List<Subscribe> subscribes = subscribeMapper.select(subscribe);
        if (Objects.isNull(subscribes)) {
            log.info("数据信息查询异常!");
            throw new BizRuntimeException("数据信息查询异常!");
        }
        PageInfo<Subscribe> subscribePageInfo = new PageInfo<>(subscribes);
        if (Objects.isNull(subscribePageInfo)) {
            log.info("分页信息异常");
            throw new BizRuntimeException("分页信息异常！");
        }
        return subscribePageInfo;
    }

    public MessageInfo addSubscribe(String mobile, String subscribeName) {
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        int userId = userBaseInfo.getId().intValue();
        MessageInfo messageInfo = new MessageInfo();
        if (StringUtils.isEmpty(mobile)) {
            log.info("手机号为空!");
            throw new BizRuntimeException("手机号为空!");
        }
        if (StringUtils.isEmpty(subscribeName)) {
            log.info("订阅名称不能为空!");
            throw new BizRuntimeException("订阅名称不能为空！");
        }
        List<Integer> changeCountBytypeAndUserstatus = configTemplateMapper.getChangeCountBytypeAndUserstatus(ActionType.WORK_INFO_SUBSCRIBE.getType(), userBaseInfo.getStatus());
        if (Objects.isNull(changeCountBytypeAndUserstatus)) {
            log.info("数据库信息异常！");
            throw new BizRuntimeException("数据库信息异常!");
        }
        Integer subNum = changeCountBytypeAndUserstatus.get(0);

        Subscribe subscribeV1 = new Subscribe();
        subscribeV1.setUserId(userBaseInfo.getId().intValue());
        int userSubCount = subscribeMapper.selectCount(subscribeV1);
        if (subNum - userSubCount == 0) {
            log.info("已达关键词订阅次数上限");
            messageInfo.setContent("已达关键词订阅次数上限");
            return messageInfo;
        }
        Subscribe subscribe = new Subscribe();
        subscribe.setUserId(userId);
        subscribe.setCreateTime(new Date());
        subscribe.setSubscribeName(subscribeName);
        int info = subscribeMapper.insert(subscribe);
        if (1 != info) {
            log.info("数据库信息异常!");
            throw new BizRuntimeException("数据库信息异常!");
        }
        messageInfo.setContent("订阅成功!");
        return messageInfo;
    }

    public boolean deleteSubscribe(Integer subscribeId) {
        if (Objects.isNull(subscribeId)) {
            log.info("参数信息异常!");
            throw new BizRuntimeException("参数信息异常！");
        }
        subscribeMapper.deleteByPrimaryKey(subscribeId);
        return true;
    }
}
