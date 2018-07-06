package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AuthToken implements Serializable {
    private static final long serialVersionUID = 5170719236523307168L;
    private String token;
    private Date expiredTime;
    private Integer status;
}
