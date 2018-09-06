package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 06 - 14:56
 */
@Data
public class ManagePerformanceModel implements Serializable {
    private static final long serialVersionUID = 4109589217308247720L;
    private Integer userId;
    private String dates;
}
