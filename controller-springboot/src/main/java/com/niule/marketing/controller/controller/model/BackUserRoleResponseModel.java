package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 21 - 11:46
 */
@Data
public class BackUserRoleResponseModel implements Serializable {
    private static final long serialVersionUID = -873503691738999447L;
    private Integer id;
    private String roleName;
    private String roleDesc;
    private Date createTime;
    private Date modifyTime;
    private Integer status;
}
