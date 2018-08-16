package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 20 - 16:48
 */
@Data
public class CurOperator implements Serializable {
    private static final long serialVersionUID = -2239030833148332733L;
    private Integer id;
    private String roleInfo;
    private List<String> authInfo;
}
