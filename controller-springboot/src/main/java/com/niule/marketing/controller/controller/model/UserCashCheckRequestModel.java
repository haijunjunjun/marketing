package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 21 - 15:55
 */
@Data
public class UserCashCheckRequestModel implements Serializable {
    private static final long serialVersionUID = -9049157367974863321L;
    private Integer id;
    private Integer status;
    private String refuseReason;
}
