package com.niule.market.util;

import lombok.Data;

/**
 * @author haijun
 * @create 2018 - 07 - 18 - 14:13
 */
@Data
public class MessageInfo<T> {

    private T data;
    private String result;
}
