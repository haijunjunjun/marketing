package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BankInfoModel implements Serializable {
    private static final long serialVersionUID = -759991308302303843L;
    private String accountHolder;
    private String accountBankNo;
    private String accountBankName;
}
