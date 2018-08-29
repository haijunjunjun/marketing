package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.dal.mapper.BannerEditMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.BannerMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.Banner;
import com.niule.yunjiagong.yunjiagong.dal.model.BannerEdit;
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
 * @create 2018 - 07 - 25 - 10:24
 */
@Slf4j
@Service
public class BannerService {

    @Autowired
    private BannerMapper bannerMapper;
    @Autowired
    private BannerEditMapper bannerEditMapper;
    @Autowired
    private UserInfoFeginService userInfoFeginService;

    public List<Banner> getBanner(Integer bannerType) {
        if (StringUtils.isEmpty(bannerType)) {
            log.info("参数信息异常！");
            throw new BizRuntimeException("参数信息异常！");
        }
        List<Banner> banner = bannerMapper.getBanner(bannerType);
        if (Objects.isNull(banner)) {
            log.info("数据库信息异常!");
            throw new BizRuntimeException("数据库信息异常！");
        }
        return banner;
    }

//    public MessageInfo editBannerInfo(String editInfo) {
//        MessageInfo messageInfo = new MessageInfo();
//        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
//        if (Objects.isNull(userBaseInfo)) {
//            messageInfo.setContent("登录信息异常!");
//            return messageInfo;
//        }
//        Integer countBannerEdit = bannerEditMapper.countBannerEdit(userBaseInfo.getId().intValue());
//        if (countBannerEdit>0){
//            bannerEditMapper.updateBannerEdit(userBaseInfo.getId().intValue(),editInfo);
//        }else {
//            BannerEdit bannerEdit = new BannerEdit();
//            bannerEdit.setUserId(userBaseInfo.getId().intValue());
//            bannerEdit.setEditInfo(editInfo);
//            bannerEdit.setCreateTime(new Date());
//            bannerEditMapper.insert(bannerEdit);
//        }
//        messageInfo.setContent("成功");
//        return messageInfo;
//    }
//
//    public MessageInfo getUserBanner (){
//        MessageInfo messageInfo = new MessageInfo();
//        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
//        if (Objects.isNull(userBaseInfo)) {
//            messageInfo.setContent("登录信息异常!");
//            return messageInfo;
//        }
//        BannerEdit bannerEdit = new BannerEdit();
//        bannerEdit.setUserId(userBaseInfo.getId().intValue());
//        BannerEdit bannerEditInfo = bannerEditMapper.selectOne(bannerEdit);
//        if (!Objects.isNull(bannerEditInfo) && !StringUtils.isEmpty(bannerEditInfo.getEditInfo())){
//            messageInfo.setContent(bannerEditInfo.getEditInfo());
//        }
//        return messageInfo;
//    }

}
