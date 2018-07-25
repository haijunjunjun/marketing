package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.constants.Enum.DefaultResourceTypeEnum;
import com.niule.yunjiagong.yunjiagong.dal.mapper.DefaultResourceTemplateMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.DefaultResourceTemplate;
import com.niule.yunjiagong.yunjiagong.model.DefaultResource;
import com.niule.yunjiagong.yunjiagong.util.BizRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 16:17
 */
@Slf4j
@Service
public class DefaultResourceService {

    @Autowired
    private DefaultResourceTemplateMapper defaultResourceTemplateMapper;

    public List<DefaultResource> getDefaultResource() {
        List<DefaultResourceTemplate> defaultResourceTemplateList = defaultResourceTemplateMapper.getDefaultResourceTemplate();
        if (Objects.isNull(defaultResourceTemplateList)) {
            log.info("数据库信息异常！");
            throw new BizRuntimeException("数据库信息异常！");
        }
        List<DefaultResource> defaultResourceList = new ArrayList<>();
        for (DefaultResourceTemplate d : defaultResourceTemplateList) {
            if (DefaultResourceTypeEnum.V1.getValue().equals(String.valueOf(d.getType()))) {
                defaultResourceList.add(new DefaultResource(DefaultResourceTypeEnum.V1.getName(), d.getResourceUrl()));
            }
            if (DefaultResourceTypeEnum.V2.getValue().equals(String.valueOf(d.getType()))) {
                defaultResourceList.add(new DefaultResource(DefaultResourceTypeEnum.V2.getName(), d.getResourceUrl()));
            }
            if (DefaultResourceTypeEnum.V3.getValue().equals(String.valueOf(d.getType()))) {
                defaultResourceList.add(new DefaultResource(DefaultResourceTypeEnum.V3.getName(), d.getResourceUrl()));
            }
            if (DefaultResourceTypeEnum.V4.getValue().equals(String.valueOf(d.getType()))) {
                defaultResourceList.add(new DefaultResource(DefaultResourceTypeEnum.V4.getName(), d.getResourceUrl()));
            }
            if (DefaultResourceTypeEnum.V5.getValue().equals(String.valueOf(d.getType()))) {
                defaultResourceList.add(new DefaultResource(DefaultResourceTypeEnum.V5.getName(), d.getResourceUrl()));
            }
            if (DefaultResourceTypeEnum.V6.getValue().equals(String.valueOf(d.getType()))) {
                defaultResourceList.add(new DefaultResource(DefaultResourceTypeEnum.V6.getName(), d.getResourceUrl()));
            }
        }
        return defaultResourceList;
    }

}
