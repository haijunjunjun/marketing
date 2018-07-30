package com.niule.yunjiagong.yunjiagong.service;

import com.github.pagehelper.PageHelper;
import com.niule.yunjiagong.yunjiagong.constants.Enum.NoticeTypeEnum;
import com.niule.yunjiagong.yunjiagong.dal.mapper.ActivityNoticeMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.NoticeMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.NoticeTypeMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.ActivityNotice;
import com.niule.yunjiagong.yunjiagong.dal.model.Notice;
import com.niule.yunjiagong.yunjiagong.dal.model.NoticeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private ActivityNoticeMapper activityNoticeMapper;

    public List<Notice> getNoticeList() {
        List<Notice> noticeList = new ArrayList<>();
        List<NoticeType> noticeTypeList = this.getNoticeTypeList();
        for (NoticeType n : noticeTypeList) {
            if (String.valueOf(n.getId()).equals(NoticeTypeEnum.SALE.getCode())) {
                PageHelper.startPage(1, n.getStandard());
                List<Notice> noticeListInfo = noticeMapper.getNoticeList(n.getId());
                noticeList.addAll(noticeListInfo);
            }
            if (String.valueOf(n.getId()).equals(NoticeTypeEnum.NOTICE.getCode())) {
                PageHelper.startPage(1, n.getStandard());
                List<Notice> noticeListInfo = noticeMapper.getNoticeList(n.getId());
                noticeList.addAll(noticeListInfo);
            }
            if (String.valueOf(n.getId()).equals(NoticeTypeEnum.ACTIV_INFO.getCode())) {
                List<ActivityNotice> activityNoticeInfo = activityNoticeMapper.getActivityNoticeInfo(n.getStandard());
                for (ActivityNotice a : activityNoticeInfo) {
                    Notice notice = new Notice();
                    notice.setTypeId(n.getId());
                    notice.setContent(a.getContent());
                    notice.setIsstart("1");
                    noticeList.add(notice);
                }
            }
        }
        return noticeList;
    }


    private NoticeType getNoticeType(Integer noticeTypeId) {
        return noticeTypeMapper.selectByPrimaryKey(noticeTypeId);
    }

    private List<NoticeType> getNoticeTypeList() {
        return noticeTypeMapper.selectAll();
    }
}
