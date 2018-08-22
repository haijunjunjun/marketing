package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 21 - 17:43
 */
@Data
public class WxPayResponseModel implements Serializable {
    private static final long serialVersionUID = 3268007820100818773L;
    private String returnMessage;
    private String payResult;
}
