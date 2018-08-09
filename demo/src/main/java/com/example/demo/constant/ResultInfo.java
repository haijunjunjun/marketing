package com.example.demo.constant;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 07 - 20 - 11:30
 */
@Data
public class ResultInfo implements Serializable {

    private static final long serialVersionUID = -8118027672165013633L;
    private String code;
    private String message;

}
