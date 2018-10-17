package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 25 - 18:19
 */
@Data
public class CommissionModel implements Serializable {
    private static final long serialVersionUID = -1420508127284520942L;
    private Integer userId;
    private String time;
}
