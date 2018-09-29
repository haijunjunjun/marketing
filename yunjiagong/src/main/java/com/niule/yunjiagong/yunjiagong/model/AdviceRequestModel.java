package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 29 - 14:27
 */
@Data
public class AdviceRequestModel implements Serializable {
    private static final long serialVersionUID = 5229404614656350950L;
    private String questionType;
    private String detailQuestion;
    private String questionImg;
}
