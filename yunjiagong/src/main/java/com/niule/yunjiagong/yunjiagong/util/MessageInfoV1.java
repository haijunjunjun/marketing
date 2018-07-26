package com.niule.yunjiagong.yunjiagong.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 07 - 26 - 17:12
 */
@Data
public class MessageInfoV1<T> implements Serializable {
    private static final long serialVersionUID = 970807620930150483L;
    private T data;
    private String content;
}
