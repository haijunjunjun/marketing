package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 13 - 18:40
 */
@Data
public class Base64Model implements Serializable {
    private static final long serialVersionUID = -6815143814436650018L;
    private Integer id;
    private String base64;
}
