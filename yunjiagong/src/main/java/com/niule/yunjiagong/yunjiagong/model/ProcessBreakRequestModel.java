package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 10 - 10 - 10:21
 */
@Data
public class ProcessBreakRequestModel implements Serializable {
    private static final long serialVersionUID = -6867250344744364946L;
    private String processType;
    private String reasonType;
}
