package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 08 - 31 - 16:56
 */
@Data
public class CustDetailModel implements Serializable {
    private static final long serialVersionUID = -8844192614072461127L;
    private CustDetailInfo custDetailInfo;
    private List<UserActionModel> userActionModelList;
}
