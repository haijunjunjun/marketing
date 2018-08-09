package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 06 - 17:03
 */
@Data
public class ShareInfoParamModel implements Serializable {
    private static final long serialVersionUID = -6755636243278210977L;
    private String callback;
    private Integer activityId;
}
