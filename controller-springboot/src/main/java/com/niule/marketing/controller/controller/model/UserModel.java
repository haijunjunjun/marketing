package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 13 - 15:25
 */
@Data
public class UserModel implements Serializable {
    private static final long serialVersionUID = 7874831105173644492L;
    private Integer userId;
    private Integer status;
    private Integer pageNum;
    private Integer pageSize;
}
