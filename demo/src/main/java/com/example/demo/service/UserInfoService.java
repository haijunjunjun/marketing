package com.example.demo.service;

import com.example.demo.config.annotation.CurrentUser;
import com.example.demo.dal.mapper.*;
import com.example.demo.dal.model.*;
import com.example.demo.model.AuthToken;
import com.example.demo.model.UserRole;
import com.example.demo.util.BizRuntimeException;
import com.example.demo.util.MessageInfo;
import com.example.demo.util.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by haijun on 2018/7/3.
 */
@Slf4j
@Service
public class UserInfoService {

    private UserInfoMapper userInfoMapper;
    private RoleInfoMapper roleInfoMapper;
    private RoleAuthMapper roleAuthMapper;
    private TokenInfoMapper tokenInfoMapper;
    private UserAccountMapper userAccountMapper;
    private UserGoldBeansMapper userGoldBeansMapper;
    private AccountBankMapper accountBankMapper;

    @Autowired
    public UserInfoService(UserInfoMapper userInfoMapper,
                           RoleInfoMapper roleInfoMapper,
                           RoleAuthMapper roleAuthMapper,
                           TokenInfoMapper tokenInfoMapper,
                           UserAccountMapper userAccountMapper,
                           UserGoldBeansMapper userGoldBeansMapper,
                           AccountBankMapper accountBankMapper) {
        this.userInfoMapper = userInfoMapper;
        this.roleInfoMapper = roleInfoMapper;
        this.roleAuthMapper = roleAuthMapper;
        this.tokenInfoMapper = tokenInfoMapper;
        this.userAccountMapper = userAccountMapper;
        this.userGoldBeansMapper = userGoldBeansMapper;
        this.accountBankMapper = accountBankMapper;
    }

    public List<UserInfo> getUserInfo() {
        List<UserInfo> userInfos = userInfoMapper.selectAll();
        return userInfos;
    }

    /**
     * 登录
     */
    public MessageInfo<UserRole> login(String phone, String passWord) {
        MessageInfo<UserRole> userRoleMessageInfo = new MessageInfo<>();
        if (!checkMobileNumber(phone)) {
            log.info("手机号格式不正确！");
            userRoleMessageInfo.setContent("手机号格式不正确，请重新输入手机号！");
            return userRoleMessageInfo;
        }
        if (StringUtils.isEmpty(phone)) {
            log.info("用户名不能为空!");
            userRoleMessageInfo.setContent("用户名为空，请检查用户名！");
            return userRoleMessageInfo;
        }
        if (StringUtils.isEmpty(passWord)) {
            log.info("密码不能为空！");
            userRoleMessageInfo.setContent("密码不能为空，请检查密码！");
            return userRoleMessageInfo;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setPhone(phone);
        UserInfo user = userInfoMapper.selectOne(userInfo);
        if (Objects.isNull(user)) {
            userRoleMessageInfo.setContent("该用户不存在!");
            return userRoleMessageInfo;
        }
        if (!passWord.equals(user.getPassword())) {
            userRoleMessageInfo.setContent("密码不正确!");
            return userRoleMessageInfo;
        }
        UserRole userRole = new UserRole();
        userRole.setId(user.getId());
        String roleInfo = this.getRoleInfo(user.getRoleId());
        userRole.setRoleName(roleInfo);
        List<String> authInfo = this.getAuthInfo(user.getRoleId());
        userRole.setAuthInfo(authInfo);

        TokenInfo tokenInfo = this.getTokenInfo(user.getId());
        //token信息
        if (Objects.isNull(tokenInfo)) {
            AuthToken authToken = this.authToken(user.getId());
            userRole.setAuthToken(authToken);
            //初始化银行账户数据
            initAccountBank(user.getId());
            //初始化金豆数量
            initGoldBeans(user.getId());
        }
        if (!Objects.isNull(tokenInfo) && System.currentTimeMillis() - tokenInfo.getExpiredTime().getTime() > 0) {
            AuthToken authToken = this.updateTokenInfo(user.getId());
            userRole.setAuthToken(authToken);
        } else {
            TokenInfo tokenInfoV1 = this.getTokenInfo(user.getId());
            AuthToken authToken = new AuthToken();
            BeanUtils.copyProperties(tokenInfoV1, authToken);
            userRole.setAuthToken(authToken);
        }
        userRoleMessageInfo.setData(userRole);
        userRoleMessageInfo.setContent("success");

        return userRoleMessageInfo;
    }

    /**
     * 通过角色id 获取角色名称
     */
    public String getRoleInfo(Integer roleId) {
        if (StringUtils.isEmpty(roleId)) {
            log.info("role's id is null !");
            throw new BizRuntimeException("角色 id 不能为空!");
        }
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setId(roleId);
        RoleInfo data = roleInfoMapper.selectOne(roleInfo);
        if (Objects.isNull(data)) {
            log.info("数据获取为空");
            throw new BizRuntimeException("数据获取失败，请检查数据库数据！");
        }
        return data.getRoleInfo();
    }

    /**
     * 通过角色id 获取权限名称
     */
    public List<String> getAuthInfo(Integer roleId) {
        if (StringUtils.isEmpty(roleId)) {
            log.info("role's id is null !");
            throw new BizRuntimeException("角色id不能为空！");
        }
        RoleAuth roleAuth = new RoleAuth();
        roleAuth.setRoleId(roleId);
        RoleAuth authInfo = roleAuthMapper.selectOne(roleAuth);
        if (Objects.isNull(authInfo)) {
            log.info("数据获取为空！");
            throw new BizRuntimeException("数据获取失败，请检查数据库!");
        }
        String auth = authInfo.getAuthInfo();
        if (StringUtils.isEmpty(auth)) {
            log.info("该角色对应的权限为空！");
            throw new BizRuntimeException("该角色对应的权限为空，请修改数据库!");
        }
        List<String> auths = Arrays.asList(auth.trim().split(","));
        return auths;
    }

    /**
     * 判断手机号格式
     */
    public boolean checkMobileNumber(String mobileNumber) {
        boolean flag = false;
        try {
            Pattern regex = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$");
            Matcher matcher = regex.matcher(mobileNumber);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * token信息
     */
    public AuthToken authToken(Integer userId) {
        AuthToken authToken = new AuthToken();
        TokenInfo tokenInfo = new TokenInfo();
        Date expiredTime = new Date();
        expiredTime.setTime(3600 * 24 * 100 + new Date().getTime());
        tokenInfo.setUserId(userId);
        tokenInfo.setExpiredTime(expiredTime);
        tokenInfo.setStatus(0);
        tokenInfo.setToken(TokenUtils.createJwtToken(userId));
        int i = tokenInfoMapper.insert(tokenInfo);
        if (i != 1) {
            log.info("token 存入失败！");
            throw new BizRuntimeException("token 存入失败！");
        }
        BeanUtils.copyProperties(tokenInfo, authToken);
        return authToken;
    }

    /**
     * 通过userId 获取token信息
     */
    public TokenInfo getTokenInfo(Integer userId) {
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setUserId(userId);
        TokenInfo token = tokenInfoMapper.selectOne(tokenInfo);
        return token;
    }

    /**
     * 初始化用户银行相关数据
     */
    public void initAccountBank(Integer userId) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(userId);
        userAccount.setBalance(0d);
        userAccount.setCreateTime(new Date());
        userAccountMapper.insert(userAccount);
        AccountBank accountBank = new AccountBank();
        accountBank.setUserId(userId);
        accountBank.setCreateTime(new Date());
        accountBankMapper.insert(accountBank);
    }

    /**
     * 初始化金豆数量
     */
    public void initGoldBeans(Integer userId) {
        UserGoldBeans userGoldBeans = new UserGoldBeans();
        userGoldBeans.setUserId(userId);
        userGoldBeans.setGoldBeansNum(0);
        userGoldBeans.setCreateTime(new Date());
        userGoldBeansMapper.insert(userGoldBeans);
    }

    /**
     * token 信息更新
     */
    public AuthToken updateTokenInfo(Integer userId) {
        AuthToken authToken = new AuthToken();
        TokenInfo tokenInfo = new TokenInfo();
        Date expiredTime = new Date();
        expiredTime.setTime(3600 * 24 * 100 + new Date().getTime());
        tokenInfo.setUserId(userId);
        tokenInfo.setExpiredTime(expiredTime);
        tokenInfo.setToken(TokenUtils.createJwtToken(userId));

        TokenInfo t = new TokenInfo();
        t.setUserId(userId);
        TokenInfo tokenInfo1 = tokenInfoMapper.selectOne(t);
        tokenInfo.setStatus(tokenInfo1.getStatus());
        tokenInfo.setId(tokenInfo1.getId());

        tokenInfoMapper.updateByPrimaryKeySelective(tokenInfo);
        BeanUtils.copyProperties(tokenInfo, authToken);
        return authToken;
    }

    /**
     * 通过token 获取userInfo
     */
    public UserInfo getUserInfo(String token) {
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setToken(token);
        TokenInfo tokenInfos = tokenInfoMapper.selectOne(tokenInfo);
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(tokenInfos.getUserId());
        return userInfo;
    }

    /**
     * 通过token 获取TokenInfo
     */
    public TokenInfo getTokenInfo(String token) {
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setToken(token);
        TokenInfo tokenInfos = tokenInfoMapper.selectOne(tokenInfo);
        return tokenInfos;
    }

    /**
     * 测试方法
     */
    public String getOpeator(@CurrentUser UserInfo userInfo) {
        return "用户" + userInfo.getRealName() + "不需要重复登录";
    }
}
