package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 12 - 18:36
 */
@Data
public class HttpCustGoldBeansDetail implements Serializable {
    private static final long serialVersionUID = -4786394339894668705L;
    private Integer id;
    private Date createTimeStamp;
    private String source;
    private Integer otayonii;
    private Integer userId;
    private String orderNo;
}
