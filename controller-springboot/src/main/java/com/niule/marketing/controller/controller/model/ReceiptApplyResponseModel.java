package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 18 - 17:54
 */
@Data
public class ReceiptApplyResponseModel implements Serializable {
    private static final long serialVersionUID = -6841697980443866448L;
    private Integer id;
    private String applyUserName;
    private String applyUserPhone;
    private String companyName;
    private String dutyParagraph;
    private String receiptTitle;
    private Date applyTime;
    private Integer status;
}
