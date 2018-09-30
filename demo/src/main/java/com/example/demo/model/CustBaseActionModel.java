package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 28 - 14:40
 */
@Data
public class CustBaseActionModel implements Serializable {
    private static final long serialVersionUID = -961040217541336904L;
    private Integer custId;
    private String actionCode;
    private String operateTime;
    private String mark;
}
