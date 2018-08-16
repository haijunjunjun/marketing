package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BalanceCommission implements Serializable {
    private static final long serialVersionUID = 8434884597859642657L;
    private String type;
    private double commission;
    private Date dates;
}
