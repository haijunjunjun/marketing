package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 11 - 13:50
 */
@Data
public class CompactDetailModel implements Serializable {
    private static final long serialVersionUID = 2160206977129144351L;
    private Integer id;
    private String custName;
    private String custPhone;
    private String compactImg;
    private Date createTime;
}
