package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 17 - 11:37
 */
@Data
public class DateRequestModel implements Serializable {
    private static final long serialVersionUID = 3014521166755612846L;
    private Integer userId;
    private String startTime;
    private String endTime;
    private Integer pageNum;
    private Integer pageSize;
}
