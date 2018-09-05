package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 31 - 17:01
 */
@Data
public class UserActionModel implements Serializable {
    private static final long serialVersionUID = 6615316164994299870L;
    private String action;
    private String userName;
    private String actionTime;
}
