package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 20 - 13:42
 */
@Data
public class ReceiptCheckEditInfoResponseModel implements Serializable {
    private static final long serialVersionUID = -7087067442192557506L;
    private String applyName;
    private String phone;
    private String companyName;
    private String dutyParagraph;
    private String receiptTitle;
    private double price;
    private String userRealName;
    private Date applyTime;
    private Integer status;
    private String certificateNo;
    private String refuseReason;
}
