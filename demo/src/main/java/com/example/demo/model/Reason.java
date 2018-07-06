package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Reason implements Serializable {
    private static final long serialVersionUID = 3218309598297971255L;
    private Integer custId;
    private String reason;
}
