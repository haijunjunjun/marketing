package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 20 - 11:31
 */
@Data
public class CompactCheckEditInfoRequestModel implements Serializable {
    private static final long serialVersionUID = 4800004244587706944L;
    private Integer custId;
    private Integer status;
    private String refuseReason;

}
