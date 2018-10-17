package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 10 - 16 - 15:45
 */
@Data
public class HttpCustGoldBeansInfoModel implements Serializable {
    private static final long serialVersionUID = -1946883545377140565L;
    List<HttpCustGoldBeansDetail> logList;
    private Integer otayoniiCnt;
}
