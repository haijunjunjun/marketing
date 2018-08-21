package com.example.demo.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 20 - 15:24
 */
@Data
public class MessageInfoV2<T> implements Serializable {
    private static final long serialVersionUID = 7051845635899010764L;

    private T data;
    private String successContent;
    private String failContent;
}
