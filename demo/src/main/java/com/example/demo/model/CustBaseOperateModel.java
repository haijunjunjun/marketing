package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 28 - 14:50
 */
@Data
public class CustBaseOperateModel implements Serializable {
    private static final long serialVersionUID = 2955932029362916467L;
    private Integer id;
    private String actionName;
    private String userName;
    private String operateTime;
    private String isEdit;
}
