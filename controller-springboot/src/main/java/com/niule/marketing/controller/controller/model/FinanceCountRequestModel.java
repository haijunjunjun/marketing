package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 25 - 10:51
 */
@Data
public class FinanceCountRequestModel implements Serializable {
    private static final long serialVersionUID = -7814562270493784009L;
    private String custName;
    private Integer payStatus;
    private String startTime;
    private String endTime;
    private Integer pageNum;
    private Integer pageSize;
}
