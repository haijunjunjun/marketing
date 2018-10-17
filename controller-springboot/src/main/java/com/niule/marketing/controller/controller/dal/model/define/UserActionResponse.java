package com.niule.marketing.controller.controller.dal.model.define;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 14 - 17:23
 */
@Data
public class UserActionResponse implements Serializable {
    private static final long serialVersionUID = 5928403389932125005L;
    private Integer id;
    private String userRealName;
    private String custName;
    private String companyName;
    private String companyType;
    private String custPhone;
    private Date createTime;
    private String action;
}
