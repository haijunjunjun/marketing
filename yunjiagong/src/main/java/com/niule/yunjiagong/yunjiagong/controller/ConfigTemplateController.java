package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.model.ConfigTemplateModel;
import com.niule.yunjiagong.yunjiagong.service.ConfigTemplateService;
import com.niule.yunjiagong.yunjiagong.util.CodeResponse;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 08 - 29 - 11:52
 */
@RestController
public class ConfigTemplateController {

    @Autowired
    private ConfigTemplateService configTemplateService;

    @RequestMapping(value = "/user/config/template/value", method = RequestMethod.POST)
    public DataResponse getConfigTemplate(@Valid @NotNull @RequestBody(required = true)ConfigTemplateModel configTemplateModel) {
        if (Objects.isNull(configTemplateModel.getType())) {
            return DataResponse.error(new CodeResponse(44100, "type is not defined"));
        }
        if (Objects.isNull(configTemplateModel.getUserStatus())) {
            return DataResponse.error(new CodeResponse(44100, "userStatus is not defined"));
        }
        return DataResponse.success(configTemplateService.getConfigTemplateValue(configTemplateModel.getType(),configTemplateModel.getUserStatus()));
    }
}
