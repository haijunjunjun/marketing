package com.example.demo.model.http;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 10 - 08 - 14:39
 */
@Data
public class HttpCustGoldBeansDetailModel implements Serializable {
    private static final long serialVersionUID = 4807767873186810265L;
    private List<HttpCustGoldBeansDetail> logList;
    private Integer otayoniiCnt;
}
