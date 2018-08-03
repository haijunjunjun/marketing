package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 08 - 03 - 11:22
 */
@Data
public class Share implements Serializable {
    private static final long serialVersionUID = -8111658692333480226L;
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
