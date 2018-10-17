package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 17 - 18:26
 */
@Data
public class UserTeamResponseModel implements Serializable {
    private static final long serialVersionUID = 2593333634219641629L;
    private Integer id;
    private String realName;
    private String phone;
    private String roleName;
    private Date createTime;
}
