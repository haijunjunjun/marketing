package com.niule.marketing.controller.controller.dal.model.define;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 18 - 17:58
 */
@Data
public class ReceiptApplyResponse implements Serializable {
    private static final long serialVersionUID = -2529763120233319640L;
    private Integer id;
    private String applyUserName;
    private String applyUserPhone;
    private String companyName;
    private String dutyParagraph;
    private String receiptTitle;
    private Date applyTime;
    private Integer status;
}
