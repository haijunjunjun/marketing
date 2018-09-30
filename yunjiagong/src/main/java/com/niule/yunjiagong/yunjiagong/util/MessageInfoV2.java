package com.niule.yunjiagong.yunjiagong.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 30 - 11:29
 */
@Data
public class MessageInfoV2<T> implements Serializable {
    private static final long serialVersionUID = 9117947638067545270L;
    private T result;
}
