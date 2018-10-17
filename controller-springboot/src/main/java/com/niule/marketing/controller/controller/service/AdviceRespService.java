package com.niule.marketing.controller.controller.service;

import com.niule.marketing.controller.controller.dal.mapper.AdviceRespMapper;
import com.niule.marketing.controller.controller.dal.mapper.UserInfoMapper;
import com.niule.marketing.controller.controller.dal.model.AdviceResp;
import com.niule.marketing.controller.controller.dal.model.AdviceRespExample;
import com.niule.marketing.controller.controller.dal.model.UserInfo;
import com.niule.marketing.controller.controller.dal.model.UserInfoExample;
import com.niule.marketing.controller.controller.model.AdviceRespAndUserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LsAusi
 * @date 2018/9/18
 * @time 10:26
 **/

@Slf4j
@Service
public class AdviceRespService {

    @Autowired
    private AdviceRespMapper adviceRespMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;


    /**
     * 意见反馈列表
     *
     * @param userName 销售人员名称
     * @param mobile   销售人员电话
     * @return
     */
    public List<AdviceRespAndUserModel> getAdviceRespList(String userName, String mobile) {
        List<AdviceRespAndUserModel> adviceRespAndUserModelList = new ArrayList<>();

        List<AdviceResp> adviceRespList = new ArrayList<>();

        AdviceRespExample adviceRespExample = new AdviceRespExample();
        adviceRespExample.setOrderByClause("id desc");
        AdviceRespExample.Criteria criteria1 = adviceRespExample.createCriteria();

        UserInfoExample userInfoExample = new UserInfoExample();

        if ((userName == "" || userName == null) && (mobile == "" || mobile == null)) {
            adviceRespList = adviceRespMapper.selectByExample(adviceRespExample);
        } else {
            UserInfoExample.Criteria criteria = userInfoExample.createCriteria();

            if (userName != null && !userName.isEmpty()) {
                criteria.andRealNameLike("%" + userName + "%");
            }
            if (mobile != null && !mobile.isEmpty()) {
                criteria.andPhoneLike("%" + mobile + "%");
            }
            List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);
            List<Integer> userIds = new ArrayList<>();
            for (UserInfo userInfo : userInfoList) {
                userIds.add(userInfo.getId());
            }
            if (userIds.size() > 0) {
                criteria1.andUserIdIn(userIds);
                adviceRespList = adviceRespMapper.selectByExample(adviceRespExample);
            } else {
                adviceRespList = new ArrayList<>();
            }
        }

        for (AdviceResp adviceResp : adviceRespList) {
            AdviceRespAndUserModel adviceRespAndUserModel = new AdviceRespAndUserModel();
            adviceRespAndUserModel.setAdviceRes(adviceResp);
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(adviceResp.getUserId());
            adviceRespAndUserModel.setUserInfos(userInfo);

            adviceRespAndUserModelList.add(adviceRespAndUserModel);

        }
        return adviceRespAndUserModelList;
    }

}
