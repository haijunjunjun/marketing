package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.dal.mapper.BannerMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.Banner;
import com.niule.yunjiagong.yunjiagong.util.BizRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

}
