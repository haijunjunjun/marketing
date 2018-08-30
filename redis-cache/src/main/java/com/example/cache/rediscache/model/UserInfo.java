package com.example.cache.rediscache.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 22 - 10:45
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1384510047326482418L;
    private Integer id;
    private Integer userId;
    private String userName;
}
