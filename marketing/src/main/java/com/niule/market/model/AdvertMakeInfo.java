package com.niule.market.model;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 07 - 18 - 14:16
 */
@Data
public class AdvertMakeInfo implements Serializable {
    private static final long serialVersionUID = 3593601508259296642L;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 渠道
     */
    private String icon;
    /**
     * 二维码
     */
    private String ewmUrl;
    /**
     * 链接
     */
    private String url;
}
