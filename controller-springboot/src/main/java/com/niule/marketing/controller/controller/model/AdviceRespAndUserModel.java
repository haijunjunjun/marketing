package com.niule.marketing.controller.controller.model;

import com.niule.marketing.controller.controller.dal.model.AdviceResp;
import com.niule.marketing.controller.controller.dal.model.UserInfo;

/**
 * @author LsAusi
 * @date 2018/9/18
 * @time 10:28
 **/
public class AdviceRespAndUserModel {
    private AdviceResp adviceRes; //意见反馈
    private UserInfo userInfos; //销售人员信息

    public AdviceResp getAdviceRes() {
        return adviceRes;
    }

    public void setAdviceRes(AdviceResp adviceRes) {
        this.adviceRes = adviceRes;
    }

    public UserInfo getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(UserInfo userInfos) {
        this.userInfos = userInfos;
    }
}
