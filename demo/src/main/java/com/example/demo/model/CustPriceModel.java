package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 14 - 11:43
 */
@Data
public class CustPriceModel implements Serializable {
    private static final long serialVersionUID = 5041350573924828816L;
    private Integer id;
    private double price;
}
