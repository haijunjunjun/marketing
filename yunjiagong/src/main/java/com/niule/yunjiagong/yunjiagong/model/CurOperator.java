package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 07 - 20 - 16:48
 */
@Data
public class CurOperator implements Serializable {
    private static final long serialVersionUID = -2239030833148332733L;
    private Integer userId;
    private Integer userType;
    private Integer id;
    private String mobile;
    private String realName;
    private Integer sex;
    private Date createtime;
    private Date updatetime;
    private String avatar;
}
