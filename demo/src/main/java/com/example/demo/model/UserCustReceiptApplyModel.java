package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 28 - 10:00
 */
@Data
public class UserCustReceiptApplyModel implements Serializable {
    private static final long serialVersionUID = 8474459666873373785L;
    private Integer custId;
    private String companyName;
    private String dutyParagraph;
    private String receiptTitle;
    private String custReceiptName;
    private String custReceiptPhone;
    private String custReceiptAddress;
}
