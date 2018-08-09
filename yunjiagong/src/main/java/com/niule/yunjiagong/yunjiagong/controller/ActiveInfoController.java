package com.niule.yunjiagong.yunjiagong.controller;

import com.alibaba.fastjson.JSON;
import com.niule.yunjiagong.yunjiagong.model.ActivityModel;
import com.niule.yunjiagong.yunjiagong.model.ShareInfoParamModel;
import com.niule.yunjiagong.yunjiagong.service.ActiveInfoService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 07 - 30 - 16:41
 */
@RestController
public class ActiveInfoController {

    @Autowired
    private ActiveInfoService activeInfoService;

    @RequestMapping(value = "/market/active/info", method = RequestMethod.POST)
    public DataResponse getActiveInfoList() {
        return DataResponse.success(activeInfoService.getActiveInfo());
    }

    @RequestMapping(value = "/market/local/url", method = RequestMethod.POST)
    public DataResponse getLocalUrl(@Valid @NotNull @RequestBody(required = true) ActivityModel activityModel) {
        return DataResponse.success(activeInfoService.getLocal(activityModel.getActivityId()));
    }

    @RequestMapping(value = "/market/share/url", method = RequestMethod.POST)
    public DataResponse getShareUrl(@Valid @NotNull @RequestBody(required = true) ActivityModel activityModel) {
        return DataResponse.success(activeInfoService.getShareUrl(activityModel.getActivityId()));
    }

    @RequestMapping(value = "/market/share/info", method = RequestMethod.POST)
    public DataResponse getShareUrl(@Valid @NotNull @RequestBody(required = true) ShareInfoParamModel shareInfoParamModel) {
        return DataResponse.success(shareInfoParamModel.getCallback() + "(" + JSON.toJSON(activeInfoService.getShareInfo(shareInfoParamModel.getActivityId())) + ")");
    }
}
