package com.niule.yunjiagong.yunjiagong.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 07 - 26 - 10:58
 */
@Data
public class MessageInfo implements Serializable {
    private static final long serialVersionUID = 3775809485459514694L;
    private String content;
    private Integer realDuration;
    private Integer goldBeans = 0;
}
