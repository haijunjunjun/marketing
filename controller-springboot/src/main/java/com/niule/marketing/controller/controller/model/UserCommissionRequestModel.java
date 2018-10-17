package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 19 - 14:01
 */
@Data
public class UserCommissionRequestModel implements Serializable {
    private static final long serialVersionUID = 4451971397564403110L;
    private String realName;
    private String city;
    private String searchTime;
}
