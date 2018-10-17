package com.niule.marketing.controller.controller.dal.model.define;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 18 - 16:11
 */
@Data
public class CompactCheckResponse implements Serializable {
    private static final long serialVersionUID = 1820929270361521406L;
    private Integer id;
    private String custName;
    private String custPhone;
    private String compactNo;
    private Integer isCompactCheck;
    private String compactImageUrl;
    private double price;
    private String userRealName;
    private String userPhone;
    private Date compactTime;
}
