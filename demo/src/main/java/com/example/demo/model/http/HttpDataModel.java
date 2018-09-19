package com.example.demo.model.http;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 05 - 11:40
 */
@Data
public class HttpDataModel implements Serializable {
    private static final long serialVersionUID = 2959215401833758529L;
    private String data;
}
