package com.example.demo.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 06 - 10:40
 */
@Data
public class MessageInfoV1 implements Serializable {
    private static final long serialVersionUID = -7250555521926862991L;
    private String content;
    private String tradeNo;
}
