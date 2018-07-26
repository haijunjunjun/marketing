package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 07 - 26 - 17:10
 */
@Data
public class ComplaintModel implements Serializable {
    private static final long serialVersionUID = -1247365456854254798L;
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 目标id
     */
    private Integer targetId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 投诉内容
     */
    private String content;
    /**
     * 备注
     */
    private String remark;
}
