package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BindCardModel implements Serializable {
    private static final long serialVersionUID = -204458870534499753L;
    private String accountBankNo;
    private String accountHolder;
    private String accountBankName;
}
