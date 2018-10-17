package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 13 - 11:51
 */
@Data
public class FileUploadRequestModel implements Serializable {
    private static final long serialVersionUID = 9020680022755935748L;
    private String userPhone;
    private String base64;
}
