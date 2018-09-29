package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 29 - 9:40
 */
@Data
public class SignInfoModel implements Serializable {
    private static final long serialVersionUID = 5634371189518476088L;
    private Integer realDuration = 0;
    private Integer goldBeans = 0;
    private Integer randomGoldBeans = 0;
    private boolean isSign;
}
