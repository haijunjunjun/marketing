package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 28 - 15:10
 */
@Data
public class CustBaseOperateEditInfoModel implements Serializable {
    private static final long serialVersionUID = -1717136641385785240L;
    private Integer id;
    private String operateTime;
    private String mark;
}
