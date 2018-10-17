package com.niule.marketing.controller.controller.dal.model.define;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 17 - 11:42
 */
@Data
public class UserPerformanceResponse implements Serializable {
    private static final long serialVersionUID = 4877904484759168366L;
    private Integer id;
    private Integer custId;
    private String realName;
    private String custName;
    private String companyName;
    private String companyType;
    private String custPhone;
    private Date createTime;
    private double performance;
}
