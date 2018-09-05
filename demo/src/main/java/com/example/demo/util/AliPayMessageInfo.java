package com.example.demo.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 31 - 12:02
 */
@Data
public class AliPayMessageInfo<T> implements Serializable {
    private static final long serialVersionUID = -8739617150804206962L;
    private String code;
    private String message;
    private T data;
}
