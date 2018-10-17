package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 17 - 19:07
 */
@Data
public class UserGoldCheckResponseModel implements Serializable {
    private static final long serialVersionUID = 7858074876940559932L;
    private Integer id;
    private String realName;
    private String phone;
    private Integer goldApplyNum;
    private String statusName;
    private Date operateTime;
    private String refuseReason;
}
