package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 10 - 11 - 12:05
 */
@Data
public class ReasonTypeModel implements Serializable {
    private static final long serialVersionUID = -5662720422739426958L;
    private String reason;
    private String type;
}
