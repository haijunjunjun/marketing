package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 18 - 15:55
 */
@Data
public class CompactCheckRequestModel implements Serializable {
    private static final long serialVersionUID = 946008540877041494L;
    private String custName;
    private String custPhone;
    private String userRealName;
    private String userPhone;
    private String compactNo;
    private Integer status;
    private Integer pageNum;
    private Integer pageSize;
}
