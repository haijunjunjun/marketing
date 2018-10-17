package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 25 - 15:21
 */
@Data
public class MarketUserCommissionRequestModel implements Serializable {
    private static final long serialVersionUID = 6226590855715602315L;
    private String realName;
    private String city;
    private String time;
    private Integer pageNum;
    private Integer pageSize;
}
