package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 08 - 20 - 13:17
 */
@Data
public class GoldBeansApplyModel implements Serializable {
    private static final long serialVersionUID = 4290793471160838590L;
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 金豆申请数量
     */
    private Integer goldBeansApplyNum;

    /**
     * 申请时间
     */
    private Date applyTime;
    private String applyTimeV1;

    /**
     * 金豆申请状态（1：待审核 2：已成功 3：已拒绝）
     */
    private Integer status;

    /**
     * 金豆申请类型（1：申请金豆 2：赠送）
     */
    private Integer type;

    /**
     * 审核时间
     */
    private Date checkTime;
    private String checkTimeV1;

    /**
     * 拒绝原因
     */
    private String refuseReason;
}
