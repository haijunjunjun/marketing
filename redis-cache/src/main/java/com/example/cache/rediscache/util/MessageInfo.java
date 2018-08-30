package com.example.cache.rediscache.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 22 - 18:19
 */
@Data
public class MessageInfo implements Serializable {
    private static final long serialVersionUID = 6403322886962667020L;
    private String base64;
}
