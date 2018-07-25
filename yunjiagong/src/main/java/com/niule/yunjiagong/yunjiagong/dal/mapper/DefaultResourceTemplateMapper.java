package com.niule.yunjiagong.yunjiagong.dal.mapper;

import com.niule.yunjiagong.yunjiagong.dal.model.DefaultResourceTemplate;
import com.niule.yunjiagong.yunjiagong.dal.mymapper.MyMapper;

import java.util.List;

public interface DefaultResourceTemplateMapper extends MyMapper<DefaultResourceTemplate> {

    List<DefaultResourceTemplate> getDefaultResourceTemplate();
}