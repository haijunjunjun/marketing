package com.niule.marketing.controller.controller.service;

import com.niule.marketing.controller.controller.dal.mapper.BackgroundUserAuthInfoMapper;
import com.niule.marketing.controller.controller.dal.mapper.BackgroundUserInfoMapper;
import com.niule.marketing.controller.controller.dal.mapper.BackgroundUserRoleInfoMapper;
import com.niule.marketing.controller.controller.dal.model.*;
import com.niule.marketing.controller.controller.model.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author haijun
 * @create 2018 - 09 - 10 - 17:23
 */
@Slf4j
@Service
public class BackgroundUserService {

    @Autowired
    private BackgroundUserInfoMapper backgroundUserInfoMapper;
    @Autowired
    private BackgroundUserRoleInfoMapper backgroundUserRoleInfoMapper;
    @Autowired
    private BackgroundUserAuthInfoMapper backgroundUserAuthInfoMapper;

    public LoginSuccessModel login(String userName, String password) {
        assert (userName == null) : "用户名不能为空!";
        assert (password == null) : "密码不能为空!";

        LoginSuccessModel loginSuccessModel = new LoginSuccessModel();

        BackgroundUserInfoExample backgroundUserInfoExampleV1 = new BackgroundUserInfoExample();
        backgroundUserInfoExampleV1.createCriteria().andUserNameEqualTo(userName);
        int i = backgroundUserInfoMapper.countByExample(backgroundUserInfoExampleV1);
//        int i = backgroundUserInfoMapper.validUserExist(userName);

        if (1 != i) {
            log.info("该用户不存在!");
            loginSuccessModel.setMessage("no_ser");
            return loginSuccessModel;
        }

        BackgroundUserInfoExample backgroundUserInfoExample = new BackgroundUserInfoExample();
        backgroundUserInfoExample.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(password);
        List<BackgroundUserInfo> backgroundUserInfos = backgroundUserInfoMapper.selectByExample(backgroundUserInfoExample);
        if (Objects.isNull(backgroundUserInfos) || backgroundUserInfos.size() == 0) {
            log.info("用户名密码不正确！");
            loginSuccessModel.setMessage("incorrect_pass");
            return loginSuccessModel;
        }
        if (0 == backgroundUserInfos.get(0).getStatus()) {
            log.info("该用户已禁用!");
            loginSuccessModel.setMessage("invalid_user");
            return loginSuccessModel;
        }
        loginSuccessModel.setMessage("login_success");
        loginSuccessModel.setRealName(backgroundUserInfos.get(0).getRealName());
        return loginSuccessModel;
    }

    public LoginSuccessModel loginV1(String userName, String password) {
        LoginSuccessModel loginSuccessModel = new LoginSuccessModel();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        subject.login(token);
        List<String> roleNameList = this.getRoleNameList(userName);
        loginSuccessModel.setRealName(userName);
        String str = "";
        if (!Objects.isNull(roleNameList) && roleNameList.size() != 0) {
            for (String s : roleNameList) {
                str = str + s + ",";
            }
            loginSuccessModel.setMessage("您目前拥有的角色:" + str.substring(0, str.length() - 1));
        }else {
            loginSuccessModel.setMessage("您目前不拥有任何角色");
        }
        return loginSuccessModel;
    }

    public List<UserRoleInfoModel> getUserRoleInfo (){
        List<UserRoleInfoModel> userRoleInfoModelList = new ArrayList<>();
        BackgroundUserRoleInfoExample backgroundUserRoleInfoExample = new BackgroundUserRoleInfoExample();
        backgroundUserRoleInfoExample.createCriteria();
        List<BackgroundUserRoleInfo> backgroundUserRoleInfos = backgroundUserRoleInfoMapper.selectByExample(backgroundUserRoleInfoExample);
        if (!Objects.isNull(backgroundUserRoleInfos) && backgroundUserRoleInfos.size() != 0){
            backgroundUserRoleInfos.forEach(backgroundUserRoleInfo -> {
                UserRoleInfoModel userRoleInfoModel = new UserRoleInfoModel();
                if (!StringUtils.isEmpty(backgroundUserRoleInfo.getRoleName()) && backgroundUserRoleInfo.getRoleName().length() != 0){
                    userRoleInfoModel.setRoleName(backgroundUserRoleInfo.getRoleName());
                }
                if (!StringUtils.isEmpty(backgroundUserRoleInfo.getRoleDesc()) && backgroundUserRoleInfo.getRoleDesc().length() != 0){
                    userRoleInfoModel.setRoleDesc(backgroundUserRoleInfo.getRoleDesc());
                }
                if (!Objects.isNull(backgroundUserRoleInfo.getId())){
                    userRoleInfoModel.setId(backgroundUserRoleInfo.getId());
                }
                userRoleInfoModelList.add(userRoleInfoModel);
            });
        }
        return userRoleInfoModelList;
    }

    public List<BackGroundUserResponseModel> getBackGroundUserInfo (BackUserInfoSearchModel backUserInfoSearchModel){
        List<BackGroundUserResponseModel> dataList = new ArrayList<>();
        List<BackgroundUserInfo> backgroundUserInfos = backgroundUserInfoMapper.searchBackUserInfo(backUserInfoSearchModel);
        if (!Objects.isNull(backgroundUserInfos) && backgroundUserInfos.size() != 0){
            backgroundUserInfos.forEach(backgroundUserInfo -> {
                BackGroundUserResponseModel backGroundUserResponseModel = new BackGroundUserResponseModel();
                if (!Objects.isNull(backgroundUserInfo.getId())){
                    backGroundUserResponseModel.setId(backgroundUserInfo.getId());
                }
                if (!StringUtils.isEmpty(backgroundUserInfo.getRealName()) && backgroundUserInfo.getRealName().length() != 0){
                    backGroundUserResponseModel.setRealName(backgroundUserInfo.getRealName());
                }
                if (!StringUtils.isEmpty(backgroundUserInfo.getUserName()) && backgroundUserInfo.getUserName().length() != 0){
                    backGroundUserResponseModel.setUserName(backgroundUserInfo.getUserName());
                }
                if (!StringUtils.isEmpty(backgroundUserInfo.getPhone()) && backgroundUserInfo.getPhone().length() != 0){
                    backGroundUserResponseModel.setPhone(backgroundUserInfo.getPhone());
                }
                if (!Objects.isNull(backgroundUserInfo.getSex())){
                    backGroundUserResponseModel.setSex(backgroundUserInfo.getSex());
                }
                if (!Objects.isNull(backgroundUserInfo.getCreateTime())){
                    backGroundUserResponseModel.setCreateTime(backgroundUserInfo.getCreateTime());
                }
                String roleName = this.getRoleName(backgroundUserInfo.getId());
                if (!StringUtils.isEmpty(roleName) && roleName.length() != 0){
                    backGroundUserResponseModel.setRoleName(roleName);
                }
                dataList.add(backGroundUserResponseModel);
            });
        }
        return dataList;
    }

    public BackGroundUserDetailModel getUserDetailInfo (IdModel idModel){
        BackGroundUserDetailModel backGroundUserDetailModel = new BackGroundUserDetailModel();
        BackgroundUserInfoExample backgroundUserInfoExample = new BackgroundUserInfoExample();
        backgroundUserInfoExample.createCriteria().andIdEqualTo(idModel.getId());
        List<BackgroundUserInfo> backgroundUserInfos = backgroundUserInfoMapper.selectByExample(backgroundUserInfoExample);
        if (!Objects.isNull(backgroundUserInfos) && backgroundUserInfos.size() != 0){
            BackgroundUserInfo backgroundUserInfo = backgroundUserInfos.get(0);
            if (!Objects.isNull(backgroundUserInfo.getId())){
                backGroundUserDetailModel.setId(backgroundUserInfo.getId());
            }
            if (!Objects.isNull(backgroundUserInfo.getStatus())){
                backGroundUserDetailModel.setStatus(backgroundUserInfo.getStatus());
            }
            if (!Objects.isNull(backgroundUserInfo.getSex())){
                backGroundUserDetailModel.setSex(backgroundUserInfo.getSex());
            }
            if (!StringUtils.isEmpty(backgroundUserInfo.getRealName()) && backgroundUserInfo.getRealName().length() != 0){
                backGroundUserDetailModel.setRealName(backgroundUserInfo.getRealName());
            }
            if (!StringUtils.isEmpty(backgroundUserInfo.getPhone()) && backgroundUserInfo.getPhone().length() != 0){
                backGroundUserDetailModel.setPhone(backgroundUserInfo.getPhone());
            }
            if (!StringUtils.isEmpty(backgroundUserInfo.getPassword()) && backgroundUserInfo.getPassword().length() != 0){
                backGroundUserDetailModel.setPassword(backgroundUserInfo.getPassword());
            }
            if (!StringUtils.isEmpty(backgroundUserInfo.getUserName()) && backgroundUserInfo.getUserName().length() != 0){
                backGroundUserDetailModel.setUserName(backgroundUserInfo.getUserName());
            }
        }
        return backGroundUserDetailModel;
    }

    public String editBackUserDetailInfo (BackGroundUserDetailModel backGroundUserDetailModel){
        BackgroundUserInfoExample backgroundUserInfoExample = new BackgroundUserInfoExample();
        BackgroundUserInfo backgroundUserInfo = new BackgroundUserInfo();
        backgroundUserInfo.setId(backGroundUserDetailModel.getId());
        if (!Objects.isNull(backGroundUserDetailModel.getStatus())){
            backgroundUserInfo.setStatus(backGroundUserDetailModel.getStatus());
        }
        if (!Objects.isNull(backGroundUserDetailModel.getSex())){
            backgroundUserInfo.setSex(backGroundUserDetailModel.getSex());
        }
        if (!StringUtils.isEmpty(backGroundUserDetailModel.getRealName()) && backGroundUserDetailModel.getRealName().length() != 0){
            backgroundUserInfo.setRealName(backGroundUserDetailModel.getRealName());
        }
        if (!StringUtils.isEmpty(backGroundUserDetailModel.getPhone()) && backGroundUserDetailModel.getPhone().length() != 0){
            backgroundUserInfo.setPhone(backGroundUserDetailModel.getPhone());
        }
        if (!StringUtils.isEmpty(backGroundUserDetailModel.getPassword()) && backGroundUserDetailModel.getPassword().length() != 0){
            backgroundUserInfo.setPassword(backGroundUserDetailModel.getPassword());
        }
        if (!StringUtils.isEmpty(backGroundUserDetailModel.getUserName()) && backGroundUserDetailModel.getUserName().length() != 0){
            backgroundUserInfo.setUserName(backGroundUserDetailModel.getUserName());
        }
        int i = backgroundUserInfoMapper.updateByPrimaryKeySelective(backgroundUserInfo);
        if (1 != i){
            log.info("更新失败");
            return "系统信息异常!";
        }
        return "更新成功!";
    }

    public String addBackUserDetailInfo (BackGroundUserDetailModel backGroundUserDetailModel){
        BackgroundUserInfo backgroundUserInfo = new BackgroundUserInfo();
        backgroundUserInfo.setRealName(backGroundUserDetailModel.getRealName());
        backgroundUserInfo.setUserName(backGroundUserDetailModel.getUserName());
        backgroundUserInfo.setPassword(backGroundUserDetailModel.getPassword());
        backgroundUserInfo.setPhone(backGroundUserDetailModel.getPhone());
        backgroundUserInfo.setSex(backGroundUserDetailModel.getSex());
        backgroundUserInfo.setStatus(backGroundUserDetailModel.getStatus());
        backgroundUserInfo.setCreateTime(new Date());
        try {
            int insert = backgroundUserInfoMapper.insert(backgroundUserInfo);
            if (1 != insert){
                return "添加失败!";
            }
            return "添加成功!";
        }catch (DuplicateKeyException e){
            return "该用户名已被注册!";
        }
    }

    public CurrentUserInfoModel getCurrentUserInfo (IdModel idModel){
        CurrentUserInfoModel currentUserInfoModel = new CurrentUserInfoModel();
        BackgroundUserInfoExample backgroundUserInfoExample = new BackgroundUserInfoExample();
        backgroundUserInfoExample.createCriteria().andIdEqualTo(idModel.getId());
        List<BackgroundUserInfo> backgroundUserInfos = backgroundUserInfoMapper.selectByExample(backgroundUserInfoExample);
        if (!Objects.isNull(backgroundUserInfos) && backgroundUserInfos.size() != 0){
            BackgroundUserInfo backgroundUserInfo = backgroundUserInfos.get(0);
            currentUserInfoModel.setUserId(idModel.getId());
            currentUserInfoModel.setUserName(backgroundUserInfo.getUserName());
            currentUserInfoModel.setRoleName(this.getRoleName(idModel.getId()));
        }
        return currentUserInfoModel;
    }

    public String bindCurrentUserRoleInfo (CurrentUserInfoModel currentUserInfoModel){
        BackgroundUserInfo backgroundUserInfo = new BackgroundUserInfo();
        backgroundUserInfo.setId(currentUserInfoModel.getUserId());
        if (!StringUtils.isEmpty(currentUserInfoModel.getUserName()) && currentUserInfoModel.getUserName().length() != 0){
            backgroundUserInfo.setUserName(currentUserInfoModel.getUserName());
        }
        if (!StringUtils.isEmpty(currentUserInfoModel.getRoleName()) && currentUserInfoModel.getRoleName().length() != 0){
            backgroundUserInfo.setBackgroundRoleIds(currentUserInfoModel.getRoleName());
        }
        int i = backgroundUserInfoMapper.updateByPrimaryKeySelective(backgroundUserInfo);
        if (1 != i){
            return "系统信息异常!";
        }
        return "更新成功!";
    }

    public List<BackUserRoleResponseModel> getBackUserRoleInfo (){
        List<BackUserRoleResponseModel> dataList = new ArrayList<>();

        BackgroundUserRoleInfoExample backgroundUserRoleInfoExample = new BackgroundUserRoleInfoExample();
        backgroundUserRoleInfoExample.createCriteria();
        List<BackgroundUserRoleInfo> backgroundUserRoleInfos = backgroundUserRoleInfoMapper.selectByExample(backgroundUserRoleInfoExample);
        if (!Objects.isNull(backgroundUserRoleInfos) && backgroundUserRoleInfos.size() != 0){
            backgroundUserRoleInfos.forEach(backgroundUserRoleInfo -> {
                BackUserRoleResponseModel backUserRoleResponseModel = new BackUserRoleResponseModel();
                if (!Objects.isNull(backgroundUserRoleInfo.getStatus())){
                    backUserRoleResponseModel.setStatus(backgroundUserRoleInfo.getStatus());
                }
                if (!StringUtils.isEmpty(backgroundUserRoleInfo.getRoleName()) && backgroundUserRoleInfo.getRoleName().length() != 0){
                    backUserRoleResponseModel.setRoleName(backgroundUserRoleInfo.getRoleName());
                }
                if (!StringUtils.isEmpty(backgroundUserRoleInfo.getRoleDesc()) && backgroundUserRoleInfo.getRoleDesc().length() != 0){
                    backUserRoleResponseModel.setRoleDesc(backgroundUserRoleInfo.getRoleDesc());
                }
                if (!Objects.isNull(backgroundUserRoleInfo.getCreateTime())){
                    backUserRoleResponseModel.setCreateTime(backgroundUserRoleInfo.getCreateTime());
                }
                if (!Objects.isNull(backgroundUserRoleInfo.getModifyTime())){
                    backUserRoleResponseModel.setModifyTime(backgroundUserRoleInfo.getModifyTime());
                }
                backUserRoleResponseModel.setId(backgroundUserRoleInfo.getId());
                dataList.add(backUserRoleResponseModel);
            });
        }
        return dataList;
    }

    public UserRoleInfoEditModel editFetchUserRoleInfo(IdModel idModel){
        UserRoleInfoEditModel userRoleInfoEditModel = new UserRoleInfoEditModel();
        List<AuthPageModel> authPageModelList = new ArrayList<>();

        BackgroundUserRoleInfoExample backgroundUserRoleInfoExample = new BackgroundUserRoleInfoExample();
        backgroundUserRoleInfoExample.createCriteria().andIdEqualTo(idModel.getId());
        List<BackgroundUserRoleInfo> backgroundUserRoleInfos = backgroundUserRoleInfoMapper.selectByExample(backgroundUserRoleInfoExample);
        if (!Objects.isNull(backgroundUserRoleInfos) && backgroundUserRoleInfos.size() != 0){
            BackgroundUserRoleInfo backgroundUserRoleInfo = backgroundUserRoleInfos.get(0);
            userRoleInfoEditModel.setId(backgroundUserRoleInfo.getId());
            userRoleInfoEditModel.setRoleName(backgroundUserRoleInfo.getRoleName());
            userRoleInfoEditModel.setRoleDesc(backgroundUserRoleInfo.getRoleDesc());
            userRoleInfoEditModel.setStatus(backgroundUserRoleInfo.getStatus() == 0 ? "禁用":"开启");

            BackgroundUserAuthInfoExample backgroundUserAuthInfoExample = new BackgroundUserAuthInfoExample();
            backgroundUserAuthInfoExample.createCriteria();
            List<BackgroundUserAuthInfo> backgroundUserAuthInfos = backgroundUserAuthInfoMapper.selectByExample(backgroundUserAuthInfoExample);
            if (!Objects.isNull(backgroundUserAuthInfos) && backgroundUserAuthInfos.size() != 0){
                backgroundUserAuthInfos.forEach(backgroundUserAuthInfo -> {
                    if (backgroundUserAuthInfo.getBackRoleIds().contains(backgroundUserRoleInfo.getId().toString())){
                        AuthPageModel authPageModel = new AuthPageModel();
                        authPageModel.setId(backgroundUserAuthInfo.getId());
                        authPageModel.setPageDesc(backgroundUserAuthInfo.getPageDesc());
                        authPageModel.setPageInterface(backgroundUserAuthInfo.getPageInterface());
                        authPageModelList.add(authPageModel);
                    }
                });
            }
            userRoleInfoEditModel.setAuthPageModelList(authPageModelList);
        }
        return userRoleInfoEditModel;
    }

    public String editUserRoleInfo (UserRoleInfoEditRequestModel userRoleInfoEditRequestModel){
        BackgroundUserRoleInfo backgroundUserRoleInfo = new BackgroundUserRoleInfo();
        backgroundUserRoleInfo.setId(userRoleInfoEditRequestModel.getId());
        if (!StringUtils.isEmpty(userRoleInfoEditRequestModel.getRoleName()) && userRoleInfoEditRequestModel.getRoleName().length() != 0){
            backgroundUserRoleInfo.setRoleName(userRoleInfoEditRequestModel.getRoleName());
        }
        if (!StringUtils.isEmpty(userRoleInfoEditRequestModel.getRoleDesc()) && userRoleInfoEditRequestModel.getRoleDesc().length() != 0){
            backgroundUserRoleInfo.setRoleDesc(userRoleInfoEditRequestModel.getRoleDesc());
        }
        if (!Objects.isNull(userRoleInfoEditRequestModel.getStatus())){
            backgroundUserRoleInfo.setStatus(userRoleInfoEditRequestModel.getStatus());
        }
        int is = backgroundUserRoleInfoMapper.updateByPrimaryKeySelective(backgroundUserRoleInfo);
        if (1 != is){
            log.info("更新用户角色信息失败!");
            return "系统信息异常!";
        }

        String[] split = userRoleInfoEditRequestModel.getAuthIds().trim().split(",");
        List<Integer> strList = new ArrayList<>();
        for (int i = 0;i<split.length;i++){
            strList.add(Integer.parseInt(split[i]));
        }
        BackgroundUserAuthInfoExample backgroundUserAuthInfoExample = new BackgroundUserAuthInfoExample();
        backgroundUserAuthInfoExample.createCriteria().andIdIn(strList);
        List<BackgroundUserAuthInfo> backgroundUserAuthInfos = backgroundUserAuthInfoMapper.selectByExample(backgroundUserAuthInfoExample);
        if (!Objects.isNull(backgroundUserAuthInfos) && backgroundUserAuthInfos.size() != 0){
            backgroundUserAuthInfos.forEach(backgroundUserAuthInfo -> {
                if (!backgroundUserAuthInfo.getBackRoleIds().contains(userRoleInfoEditRequestModel.getId().toString())){
                    BackgroundUserAuthInfo backgroundUserAuthInfoV1 = new BackgroundUserAuthInfo();
                    backgroundUserAuthInfoV1.setId(backgroundUserAuthInfo.getId());
                    backgroundUserAuthInfoV1.setBackRoleIds(backgroundUserAuthInfo.getBackRoleIds().trim()+","+userRoleInfoEditRequestModel.getId());
                    backgroundUserAuthInfoV1.setModifyTime(new Date());
                    int i = backgroundUserAuthInfoMapper.updateByPrimaryKeySelective(backgroundUserAuthInfoV1);
                    if (1 != i){
                        log.info("更新失败!");
                    }
                }
            });
        }

        BackgroundUserAuthInfoExample backgroundUserAuthInfoExampleV1 = new BackgroundUserAuthInfoExample();
        backgroundUserAuthInfoExampleV1.createCriteria().andIdNotIn(strList);
        List<BackgroundUserAuthInfo> backgroundUserAuthInfosV1 = backgroundUserAuthInfoMapper.selectByExample(backgroundUserAuthInfoExampleV1);
        if (!Objects.isNull(backgroundUserAuthInfosV1) && backgroundUserAuthInfosV1.size() != 0){
            backgroundUserAuthInfosV1.forEach(backgroundUserAuthInfo -> {
                String strResult = "";
                String str = userRoleInfoEditRequestModel.getId().toString();
                String backRoleIds = backgroundUserAuthInfo.getBackRoleIds();
                if (backRoleIds.contains(str)){
                    if (backRoleIds.contains(str+",")){
                        strResult = backRoleIds.replace(str+",","").trim();
                    }
                    if (backRoleIds.contains(","+str)){
                        strResult = backRoleIds.replace(","+str,"").trim();
                    }
                }
                BackgroundUserAuthInfo backgroundUserAuthInfoV2 = new BackgroundUserAuthInfo();
                backgroundUserAuthInfoV2.setId(backgroundUserAuthInfo.getId());
                backgroundUserAuthInfoV2.setBackRoleIds(strResult);
                backgroundUserAuthInfoV2.setModifyTime(new Date());
                int i = backgroundUserAuthInfoMapper.updateByPrimaryKeySelective(backgroundUserAuthInfoV2);
                if (1 != i){
                    log.info("更新失败!");
                }
            });
        }
        return "更新成功";
    }

    public List<BackgroundUserAuthInfo> getUserAuthInfo (){
        BackgroundUserAuthInfoExample backgroundUserAuthInfoExample = new BackgroundUserAuthInfoExample();
        backgroundUserAuthInfoExample.createCriteria();
        List<BackgroundUserAuthInfo> backgroundUserAuthInfos = backgroundUserAuthInfoMapper.selectByExample(backgroundUserAuthInfoExample);
        if (!Objects.isNull(backgroundUserAuthInfos) && backgroundUserAuthInfos.size() != 0){
            return backgroundUserAuthInfos;
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------------------------------------------

    public String deleteCharString0(String sourceString, char chElemData) {
        String deleteString = "";
        for (int i = 0; i < sourceString.length(); i++) {
            if (sourceString.charAt(i) != chElemData) {
                deleteString += sourceString.charAt(i);
            }
        }
        return deleteString;
    }

    private String getRoleName(Integer userId) {
        String str = "";
        BackgroundUserInfoExample backgroundUserInfoExample = new BackgroundUserInfoExample();
        backgroundUserInfoExample.createCriteria().andIdEqualTo(userId);
        List<BackgroundUserInfo> backgroundUserInfos = backgroundUserInfoMapper.selectByExample(backgroundUserInfoExample);
        if (!Objects.isNull(backgroundUserInfos) && backgroundUserInfos.size() != 0) {
            BackgroundUserInfo backgroundUserInfo = backgroundUserInfos.get(0);

            String backgroundRoleIds = backgroundUserInfo.getBackgroundRoleIds();
            String[] split = backgroundRoleIds.trim().split(",");
            List<Integer> its = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                int iV1 = Integer.parseInt(split[i]);
                its.add(iV1);
            }

            BackgroundUserRoleInfoExample backgroundUserRoleInfoExample = new BackgroundUserRoleInfoExample();
            backgroundUserRoleInfoExample.createCriteria().andIdIn(its);
            List<BackgroundUserRoleInfo> backgroundUserRoleInfos = backgroundUserRoleInfoMapper.selectByExample(backgroundUserRoleInfoExample);
            if (!Objects.isNull(backgroundUserRoleInfos) && backgroundUserRoleInfos.size() != 0) {
                for (BackgroundUserRoleInfo backgroundUserRoleInfo : backgroundUserRoleInfos) {
                    str = str + backgroundUserRoleInfo.getRoleDesc() + "、";
                }
            }
        }
        return str.substring(0, str.length() - 1);
    }

    public List<String> getRoleNameList(String userName) {
        List<String> stringList = new ArrayList<>();
        BackgroundUserInfoExample backgroundUserInfoExample = new BackgroundUserInfoExample();
        backgroundUserInfoExample.createCriteria().andUserNameEqualTo(userName.trim());
        List<BackgroundUserInfo> backgroundUserInfos = backgroundUserInfoMapper.selectByExample(backgroundUserInfoExample);
        if (!Objects.isNull(backgroundUserInfos) && backgroundUserInfos.size() != 0) {
            BackgroundUserInfo backgroundUserInfo = backgroundUserInfos.get(0);
            String backgroundRoleIds = backgroundUserInfo.getBackgroundRoleIds();
            if (StringUtils.isEmpty(backgroundRoleIds) && backgroundRoleIds.length() == 0){
                return null;
            }
            String[] split = backgroundRoleIds.trim().split(",");
            List<Integer> its = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                int iV1 = Integer.parseInt(split[i]);
                its.add(iV1);
            }

            BackgroundUserRoleInfoExample backgroundUserRoleInfoExample = new BackgroundUserRoleInfoExample();
            backgroundUserRoleInfoExample.createCriteria().andIdIn(its);
            List<BackgroundUserRoleInfo> backgroundUserRoleInfos = backgroundUserRoleInfoMapper.selectByExample(backgroundUserRoleInfoExample);
            if (!Objects.isNull(backgroundUserRoleInfos) && backgroundUserRoleInfos.size() != 0) {
                for (BackgroundUserRoleInfo backgroundUserRoleInfo : backgroundUserRoleInfos) {
                    stringList.add(backgroundUserRoleInfo.getRoleName().trim());
                }
            }
        }
        return stringList;
    }


    public String getUserPassword(String userName) {
        BackgroundUserInfoExample backgroundUserInfoExample = new BackgroundUserInfoExample();
        backgroundUserInfoExample.createCriteria().andUserNameEqualTo(userName);
        List<BackgroundUserInfo> backgroundUserInfos = backgroundUserInfoMapper.selectByExample(backgroundUserInfoExample);
        if (!Objects.isNull(backgroundUserInfos) && backgroundUserInfos.size() != 0) {
            BackgroundUserInfo backgroundUserInfo = backgroundUserInfos.get(0);
            if (!Objects.isNull(backgroundUserInfo)) {
                return backgroundUserInfo.getPassword();
            }
        }
        return null;
    }



    private String getAuthPageRole (String roleStr){
        String strResult = "";
        String[] split = roleStr.trim().split(",");
        BackgroundUserRoleInfoExample backgroundUserRoleInfoExample = new BackgroundUserRoleInfoExample();
        List<Integer> roleIds = new ArrayList<>();
        for (int i = 0;i<split.length;i++){
            roleIds.add(Integer.parseInt(split[i]));
        }
        backgroundUserRoleInfoExample.createCriteria().andIdIn(roleIds);
        List<BackgroundUserRoleInfo> backgroundUserRoleInfos = backgroundUserRoleInfoMapper.selectByExample(backgroundUserRoleInfoExample);
        if (!Objects.isNull(backgroundUserRoleInfos) && backgroundUserRoleInfos.size() != 0){
            for (BackgroundUserRoleInfo b : backgroundUserRoleInfos){
                strResult = strResult + b.getRoleName().trim() + ",";
            }
        }
        return strResult.substring(0,strResult.length()-1);
    }

}
