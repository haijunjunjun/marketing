package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 25 - 16:14
 */
@Data
public class UInfoModel implements Serializable {
    private static final long serialVersionUID = 4411435508145512873L;
    private String userRealName;
    private String userPhone;
    private Integer userId;
}
