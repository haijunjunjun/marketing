package com.example.demo.util;

import lombok.Data;

@Data
public class PerformanceMessageInfo<T> {
    private T data;
    private Integer totalPerformance;
}
