package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MyPersonalInfo implements Serializable {
    private static final long serialVersionUID = -4314570878788319896L;
    private String imageUrl;
    private String realName;
    private String phone;
    private Integer sex;
}
