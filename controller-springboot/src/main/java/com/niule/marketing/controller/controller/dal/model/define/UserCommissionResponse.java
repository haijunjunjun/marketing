package com.niule.marketing.controller.controller.dal.model.define;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 09 - 19 - 14:32
 */
@Data
public class UserCommissionResponse implements Serializable {
    private static final long serialVersionUID = 6630963082506405495L;
    private Integer id;
    private String userRealName;
    private String userPhone;
    private String city;
    private Date createTime;
    private double commission;
    private String yearMonth;
}
