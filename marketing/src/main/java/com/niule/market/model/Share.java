package com.niule.market.model;

import lombok.Data;

import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 07 - 30 - 11:12
 */
@Data
public class Share {
    private Long id;

    private Date createTimeStamp;

    private Date updateTimeStamp;

    private Long creatorId;

    private String creatorName;

    private String url;

    private Integer type;

    private String icon;

    private String title;

    private String content;

    private String desc;

    private String QRcodeUrl;
}
