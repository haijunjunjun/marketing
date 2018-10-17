package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 19 - 10:40
 */
@Data
public class UserCashDetailRequestModel implements Serializable {
    private static final long serialVersionUID = 93088320109365475L;
    private String userRealName;
    private String userPhone;
    private Integer status;
    private String startTime;
    private String endTime;
    private Integer pageNum;
    private Integer pageSize;
}
