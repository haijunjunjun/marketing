package com.example.demo.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 08 - 17:56
 */
@Data
public class GoldBeansMessageInfo<T> implements Serializable {
    private static final long serialVersionUID = -3282616197021890499L;
    private T data;
    private Integer totalGoldBeans;
}
