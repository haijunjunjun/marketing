package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Balance implements Serializable {
    private static final long serialVersionUID = -1145157859623132532L;
    private List<BalanceCommission> balanceCommissionList;
    private List<BalanceCash> balanceCashList;
}
