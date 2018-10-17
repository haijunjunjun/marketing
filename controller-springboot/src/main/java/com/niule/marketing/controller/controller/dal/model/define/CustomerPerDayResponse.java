package com.niule.marketing.controller.controller.dal.model.define;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 10 - 11 - 16:33
 */
@Data
public class CustomerPerDayResponse implements Serializable {
    private static final long serialVersionUID = -5399804822615747817L;
    private String userRealName;
    private String companyName;
    private String companyType;
    private String custName;
    private String custPhone;
    private String custAddr;
    private Date repoTime;
    private String mark;
}
