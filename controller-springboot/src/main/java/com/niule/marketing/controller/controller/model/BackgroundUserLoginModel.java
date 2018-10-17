package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 10 - 17:25
 */
@Data
public class BackgroundUserLoginModel implements Serializable {
    private static final long serialVersionUID = 3674809748356149584L;
    private String userName;
    private String password;
}
