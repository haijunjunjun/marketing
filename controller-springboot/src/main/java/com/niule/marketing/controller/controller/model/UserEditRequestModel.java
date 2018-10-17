package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 18 - 13:15
 */
@Data
public class UserEditRequestModel implements Serializable {
    private static final long serialVersionUID = -8160136806311287181L;
    private Integer userId;
    private Integer roleName;
    private String marketLevel;
    private String manageLevel;
    private String userRealName;
    private String userPhone;
    private Integer sex;
    private transient String password;
    private String cardNo;
    private String area;
    private String city;
    private String awater;
    private String cardPositive;
    private String cardOppositive;
    private Integer status;
    private Integer manageId;
    private Integer jobStatus;
    private Integer goldBeansNum;
    private String accountHolder;
    private String accountBankCardNo;
    private String accountBankName;
}
