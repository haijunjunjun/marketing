package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 10 - 11 - 17:06
 */
@Data
public class PathModel implements Serializable {
    private static final long serialVersionUID = -5946718072436576250L;
    private String startTime;
    private String endTime;
}
