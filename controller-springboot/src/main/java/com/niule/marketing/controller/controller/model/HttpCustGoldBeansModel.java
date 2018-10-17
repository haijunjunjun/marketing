package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 12 - 18:51
 */
@Data
public class HttpCustGoldBeansModel implements Serializable {
    private static final long serialVersionUID = 7279028281852184985L;
    private HttpCustGoldBeansInfoModel data;
    private String success;
    private String message;
    private Integer errorCode;
    private Date timeStamp;
    private String statusCode;
}
