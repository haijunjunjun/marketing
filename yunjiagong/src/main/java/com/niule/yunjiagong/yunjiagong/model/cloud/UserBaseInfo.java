package com.niule.yunjiagong.yunjiagong.model.cloud;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserBaseInfo implements Serializable {
    private static final long serialVersionUID = -1498608700435698620L;
    private Long id;

    private String mobile;

    private String avatar;

    private String realName;

    private Integer sex;

    private Date createtime;

    private Date updatetime;

}