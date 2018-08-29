package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 24 - 18:25
 */
@Data
public class StickModel implements Serializable {
    private static final long serialVersionUID = -1025533917691217549L;
    private String addressDetail;
    private String address;
}
