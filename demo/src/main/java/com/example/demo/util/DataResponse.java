package com.example.demo.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 20 - 16:59
 */
@Data
public class DataResponse implements Serializable {
    private static final long serialVersionUID = 2256768526546366083L;
    private String code;
    private String message;
}
