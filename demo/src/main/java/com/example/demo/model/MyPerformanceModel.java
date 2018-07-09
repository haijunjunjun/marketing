package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MyPerformanceModel implements Serializable {
    private static final long serialVersionUID = 7863310919594046439L;
    private String companyName;
    private String companyType;
    private String custName;
    private String custPhone;
    private Date time;
    private Integer performance;
}
