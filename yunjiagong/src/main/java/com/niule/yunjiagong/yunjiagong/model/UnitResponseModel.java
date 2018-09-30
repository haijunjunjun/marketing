package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 30 - 14:41
 */
@Data
public class UnitResponseModel implements Serializable {
    private static final long serialVersionUID = 7565053814032445184L;
    private Integer id;
    private String unit;
}
