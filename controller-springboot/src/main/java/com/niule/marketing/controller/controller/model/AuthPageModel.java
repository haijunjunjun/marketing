package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 27 - 17:11
 */
@Data
public class AuthPageModel implements Serializable {
    private static final long serialVersionUID = 7556187255698391008L;
    private Integer id;
    private String pageInterface;
    private String pageDesc;
}
