package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 29 - 17:47
 */
@Data
public class SubModel implements Serializable {
    private static final long serialVersionUID = 3868470363598977850L;
    private Integer subscribeId;
    private String mobile;
    private String subscribeName;
}
