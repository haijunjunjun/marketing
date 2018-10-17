package com.niule.marketing.controller.controller.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 12 - 19:30
 */
@Data
public class MessageInfo<T> implements Serializable {
    private static final long serialVersionUID = 570178528851271775L;
    private T data;
    private String result;
}
