package com.example.demo.test;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 08 - 17:16
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -5983605221388433231L;
    private String id;
}
