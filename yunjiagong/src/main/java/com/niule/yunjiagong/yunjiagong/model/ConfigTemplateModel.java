package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 29 - 17:42
 */
@Data
public class ConfigTemplateModel implements Serializable {
    private static final long serialVersionUID = -7232241765332116602L;
    private Integer type;
    private Integer userStatus;
}
