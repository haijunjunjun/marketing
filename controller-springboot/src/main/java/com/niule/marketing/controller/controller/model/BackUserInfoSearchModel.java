package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 21 - 9:53
 */
@Data
public class BackUserInfoSearchModel implements Serializable {
    private static final long serialVersionUID = -6439976561062334445L;
    private String realName;
    private String phone;
}
