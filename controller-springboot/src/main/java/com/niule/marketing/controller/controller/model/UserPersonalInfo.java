package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 14 - 11:23
 */
@Data
public class UserPersonalInfo implements Serializable {
    private static final long serialVersionUID = 2797734921702835563L;
    private String cardNo;
    private String cardPositiveImageUrl;
    private String cardOppositiveImageUrl;
}
