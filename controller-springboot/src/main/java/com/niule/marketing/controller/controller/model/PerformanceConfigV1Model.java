package com.niule.marketing.controller.controller.model;

import lombok.Data;

/**
 * @author LsAusi
 * @date 2018/9/19
 * @time 18:32
 **/
@Data
public class PerformanceConfigV1Model {
    private Integer id;

    private String level;

    private Double baseBalary;

    private Double kpi;

    private Double deathLine;


}
