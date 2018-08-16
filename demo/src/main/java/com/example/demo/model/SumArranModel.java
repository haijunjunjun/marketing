package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 06 - 10:07
 */
@Data
public class SumArranModel implements Serializable {

    private static final long serialVersionUID = -124352752622093616L;
    /**
     * 今日总结
     */
    private String todaySum;
    /**
     * 明日安排
     */
    private String tomorrowArra;
}
