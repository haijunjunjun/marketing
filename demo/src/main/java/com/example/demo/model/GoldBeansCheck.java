package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoldBeansCheck implements Serializable {
    private static final long serialVersionUID = -2183793410171708375L;
    /**
     * 用户头像
     */
    private String imageUrl;
    /**
     * 真实名字
     */
    private String realName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 申请数量
     */
    private Integer applyNum;
    /**
     * 申请id
     */
    private Integer applyId;
}
