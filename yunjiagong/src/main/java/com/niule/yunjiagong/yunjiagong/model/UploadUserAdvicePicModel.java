package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 29 - 15:15
 */
@Data
public class UploadUserAdvicePicModel implements Serializable {
    private static final long serialVersionUID = -3877461900724635523L;
    private String base64;
}
