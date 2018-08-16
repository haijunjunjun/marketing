package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BalanceCash implements Serializable {
    private static final long serialVersionUID = -9178826714244243951L;
    private String type;
    private double cash;
    private Date dates;
}
