package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 10 - 17:58
 */
@Data
public class DonateGoldBeansModel implements Serializable {
    private static final long serialVersionUID = -2335980770710128765L;
    private Integer custId;
    private Integer goldBeansNum;
}
