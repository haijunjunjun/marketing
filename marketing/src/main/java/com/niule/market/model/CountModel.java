package com.niule.market.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 08 - 01 - 13:38
 */
@Data
public class CountModel implements Serializable {
    private static final long serialVersionUID = 4788655256630776597L;
    private String qq;
    private Date createTime;
}
