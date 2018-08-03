package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.dal.mapper.ActiveInfoMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.RecommendLogMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.ActiveInfo;
import com.niule.yunjiagong.yunjiagong.dal.model.RecommendLog;
import com.niule.yunjiagong.yunjiagong.model.Share;
import com.niule.yunjiagong.yunjiagong.util.BizRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 07 - 30 - 16:41
 */
@Slf4j
@Service
public class ActiveInfoService {

    @Autowired
    private ActiveInfoMapper activeInfoMapper;
    @Autowired
    private RecommendLogMapper recommendLogMapper;

    public List<ActiveInfo> getActiveInfo() {
        ActiveInfo activeInfo = new ActiveInfo();
        activeInfo.setSwiches(1);
        List<ActiveInfo> activeInfos = activeInfoMapper.select(activeInfo);
        return activeInfos;
    }

    public String getLocal(Integer userId, Integer activityId) {
        ActiveInfo activeInfo = activeInfoMapper.selectByPrimaryKey(activityId);
        if (Objects.isNull(activeInfo)) {
            log.info("数据库信息查询异常!");
            throw new BizRuntimeException("数据库信息查询异常！");
        }
        if ("NORMAL".equals(activeInfo.getActiveSign())) {
            return activeInfo.getLocalUrl();
        }
        if ("RECOMMEND".equals(activeInfo.getActiveSign())) {
            int userCnt = 0;
            int beanCnt = 0;
            if (userId != null) {
                RecommendLog recommendLog = new RecommendLog();
                recommendLog.setUserId(userId);
                List<RecommendLog> recommendLogList = recommendLogMapper.select(recommendLog);
                userCnt = recommendLogList.size();
                for (RecommendLog r : recommendLogList) {
                    beanCnt += r.getBeans();
                }
            }
            return activeInfo.getLocalUrl() + "?userCnt=" + userCnt + "&beanCnt=" + beanCnt;
        }
        return activeInfo.getLocalUrl();
    }

    public Share getShareUrl(Integer userId, Integer activityId) {
        ActiveInfo activeInfo = activeInfoMapper.selectByPrimaryKey(activityId);
        String shareUrl;
        if ("NORMAL".equals(activeInfo.getActiveSign())) {
            shareUrl = activeInfo.getShareUrl();
        } else if ("RECOMMEND".equals(activeInfo.getActiveSign())) {
            shareUrl = activeInfo.getShareUrl() + "?activityId=" + activityId + "&hostId=" + userId;
        } else {
            shareUrl = activeInfo.getShareUrl();
        }
        Share share = new Share();
        share.setTitle(activeInfo.getTitle());
        share.setContent(activeInfo.getContent());
        share.setUrl(shareUrl);
        share.setIcon(activeInfo.getImg());
        return share;
    }

    public Share getShareInfo(Integer activityId) {
        ActiveInfo activeInfo = activeInfoMapper.selectByPrimaryKey(activityId);
        Share share = new Share();
        share.setTitle(activeInfo.getTitle());
        share.setContent(activeInfo.getContent());
        share.setUrl(activeInfo.getShareUrl());
        share.setIcon(activeInfo.getImg());
        return share;
    }
}
