package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 20 - 11:18
 */
@Data
public class CompactCheckEditInfoResponseModel implements Serializable {
    private static final long serialVersionUID = -4288071964786694690L;
    private String custName;
    private String custPhone;
    private String compactNo;
    private double price;
    private String compactImgUrl;
    private Integer status;
    private String refuseReason;
}
