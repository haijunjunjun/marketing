package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 21 - 16:43
 */
@Data
public class UserMoneyCheckRequestModel implements Serializable {
    private static final long serialVersionUID = -5087225003100377826L;
    private Integer id;
    private Integer isMoneyStatus;
    private String moneyCertificateImg;
    private String refuseMoneyReason;
}
