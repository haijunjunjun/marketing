package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 25 - 17:58
 */
@Data
public class AreaCityInfoModel implements Serializable {
    private static final long serialVersionUID = -6738857696965766L;
    private String area;
    private List<String> city;
}
