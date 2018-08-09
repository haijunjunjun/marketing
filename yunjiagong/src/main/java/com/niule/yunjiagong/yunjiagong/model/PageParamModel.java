package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 06 - 17:19
 */
@Data
public class PageParamModel implements Serializable {
    private static final long serialVersionUID = -3311506867390774792L;
    private Integer pageSize;
    private Integer pageNum;
}
