package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 20 - 14:20
 */
@Data
public class ReceiptCheckEditInfoRequestModel implements Serializable {
    private static final long serialVersionUID = 8712864725265091333L;
    private Integer id;
    private String certificateNo;
    private String refuseReason;
    private Integer status;
}
