package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 13 - 10:37
 */
@Data
public class AdviceModel implements Serializable {
    private static final long serialVersionUID = 9101546466072421698L;
    private String advice;
}
