package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 03 - 18:14
 */
@Data
public class ActionModel implements Serializable {
    private static final long serialVersionUID = -4693314655614613615L;
    private Integer custId;
    private Integer actionType;
    private String mark;
}
