package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 31 - 15:07
 */
@Data
public class AliPayResponseModel implements Serializable {
    private static final long serialVersionUID = -8073936990305917623L;
    private String payStatus;
}
