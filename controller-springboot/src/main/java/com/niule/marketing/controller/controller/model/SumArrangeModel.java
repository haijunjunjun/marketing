package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 18 - 11:07
 */
@Data
public class SumArrangeModel implements Serializable {
    private static final long serialVersionUID = 3388847921154808829L;
    private Integer id;
    private String userRealName;
    private String todaySum;
    private String tomorrowArrange;
    private Date createTime;
}
