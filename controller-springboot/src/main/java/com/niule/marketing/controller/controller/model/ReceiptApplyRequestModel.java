package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 18 - 17:52
 */
@Data
public class ReceiptApplyRequestModel implements Serializable {
    private static final long serialVersionUID = -2451979657163307511L;
    private String applyUserName;
    private String applyUserPhone;
    private Integer status;
    private String startTime;
    private String endTime;
    private Integer pageNum;
    private Integer pageSize;
}
