package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 17 - 15:26
 */
@Data
public class UserGoldDetailResponseModel implements Serializable {
    private static final long serialVersionUID = 5319135109794036396L;
    private Integer id;
    private String realName;
    private String phone;
    private String action;
    private Integer goldNum;
    private Date operateTime;
}
