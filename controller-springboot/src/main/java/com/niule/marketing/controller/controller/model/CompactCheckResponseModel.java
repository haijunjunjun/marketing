package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 18 - 16:03
 */
@Data
public class CompactCheckResponseModel implements Serializable {
    private static final long serialVersionUID = 1680710169750206057L;
    private Integer id;
    private String custName;
    private String custPhone;
    private String compactNo;
    private String compactImageUrl;
    private Integer isCompactCheck;
    private double price;
    private String userRealName;
    private String userPhone;
    private Date compactTime;
}
