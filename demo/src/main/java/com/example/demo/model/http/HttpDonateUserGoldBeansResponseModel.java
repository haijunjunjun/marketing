package com.example.demo.model.http;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 13 - 18:18
 */
@Data
public class HttpDonateUserGoldBeansResponseModel implements Serializable {
    private static final long serialVersionUID = -2112741139147570818L;
    private String data;
    private String success;
    private String message;
    private Integer errorCode;
    private Date timeStamp;
    private Integer statusCode;
}
