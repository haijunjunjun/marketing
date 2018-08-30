package com.niule.yunjiagong.yunjiagong.model.cloud;

import java.io.Serializable;

/**
 * @Author MrD on 2018/8/30.
 * time 10:25
 */
public class SystemPayRequest implements Serializable{
    private static final long serialVersionUID = 8006425855623347475L;
    private Integer targetType;
    private Long payAmount;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }
}
