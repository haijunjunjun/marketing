package com.niule.marketing.controller.controller.dal.model.define;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 19 - 10:53
 */
@Data
public class UserCashDetailResponse implements Serializable {
    private static final long serialVersionUID = -388927897732643349L;
    private Integer id;
    private String userRealName;
    private String userPhone;
    private double cash;
    private String accountHolder;
    private String cashAccountBankName;
    private String cashAccountBankNo;
    private Date cashModifyTime;
    private Date cashCreateTime;
    private Integer status;
}
