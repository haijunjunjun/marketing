package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 11 - 9:54
 */
@Data
public class CustModel implements Serializable {
    private static final long serialVersionUID = -8003513983696022044L;
    private Integer custId;
    private String phone;
    private Integer pageNum;
    private Integer pageSize;
}
