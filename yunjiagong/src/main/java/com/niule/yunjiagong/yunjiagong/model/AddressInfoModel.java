package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author haijun
 * @create 2018 - 08 - 10 - 17:50
 */
@Data
public class AddressInfoModel implements Serializable {
    private static final long serialVersionUID = 5858359624808138878L;
    private List<String> hotCity;
    private Map<String, List<String>> keyCity;
    private List<String> allCity;
}
