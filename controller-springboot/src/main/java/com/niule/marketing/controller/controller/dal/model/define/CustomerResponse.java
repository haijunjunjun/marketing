package com.niule.marketing.controller.controller.dal.model.define;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 12 - 14:18
 */
@Data
public class CustomerResponse implements Serializable {
    private static final long serialVersionUID = 1947325319592390878L;
    private Integer id;
    private String custName;
    private String custPhone;
    private String companyName;
    private String companyType;
    private String userName;
    private String userPhone;
    private Date createTime;
    private Date modifyTime;
    private Date lastModifyTime;
    private Integer isPhone;
    private Integer isVisit;
    private Integer isGoldBeans;
    private Integer isCompact;
    private Integer isCompactCheck;
    private Integer isMoney;
    private Integer isInterestCust;
    private Integer status;
}
