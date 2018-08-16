package com.example.demo.util;

import lombok.Data;

@Data
public class PerformanceMessageInfo<T> {
    private T data;
    private double totalPerformance;
    /**
     * 已沟通数
     */
    private Integer hasComunication;
    /**
     * 有意向数
     */
    private Integer hasInterest;
    /**
     * 已签约数
     */
    private Integer hasCompact;
}
