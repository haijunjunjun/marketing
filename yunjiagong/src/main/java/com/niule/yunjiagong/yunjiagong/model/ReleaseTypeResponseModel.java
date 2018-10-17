package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 10 - 10 - 14:43
 */
@Data
public class ReleaseTypeResponseModel implements Serializable {
    private static final long serialVersionUID = 3493858160333472554L;
    private String code;
    private String type;
    private String typeDesc;
}
