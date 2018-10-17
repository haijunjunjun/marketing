package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 10 - 18:26
 */
@Data
public class LoginSuccessModel implements Serializable {
    private static final long serialVersionUID = -8331845018424568353L;
    private String realName;
    private String message;
    private String result;
}
