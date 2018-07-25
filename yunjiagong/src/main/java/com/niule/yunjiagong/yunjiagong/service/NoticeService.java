package com.niule.yunjiagong.yunjiagong.service;

import com.github.pagehelper.PageInfo;
import com.niule.yunjiagong.yunjiagong.dal.mapper.NoticeMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.NoticeTypeMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.Notice;
import com.niule.yunjiagong.yunjiagong.dal.model.NoticeType;
import com.niule.yunjiagong.yunjiagong.util.BizRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 10:47
 */
@Slf4j
@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private NoticeTypeMapper noticeTypeMapper;

    public PageInfo<List<Notice>> getNoticeList(Integer typeId) {
        if (StringUtils.isEmpty(typeId.toString())) {
            log.info("参数信息异常!");
            throw new BizRuntimeException("参数信息异常！");
        }
        // TODO: 2018/7/25
        return null;
    }

    private NoticeType getNoticeType(Integer noticeTypeId) {
        return noticeTypeMapper.selectByPrimaryKey(noticeTypeId);
    }
}
