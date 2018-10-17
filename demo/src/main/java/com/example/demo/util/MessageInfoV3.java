package com.example.demo.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 10 - 08 - 12:56
 */
@Data
public class MessageInfoV3<T> implements Serializable {
    private static final long serialVersionUID = -8692315893794641219L;
    private T data;
    private Integer totalGoldBeans;
    private String content;
}
