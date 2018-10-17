package com.niule.yunjiagong.yunjiagong.model;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 10 - 10 - 10:23
 */
@Data
public class ProcessBreakResponseModel implements Serializable {
    private static final long serialVersionUID = 136154372998496546L;
    private JSONArray breakReason;
}
