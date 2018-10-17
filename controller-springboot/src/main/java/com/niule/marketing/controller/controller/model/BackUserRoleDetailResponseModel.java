package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author haijun
 * @create 2018 - 09 - 21 - 13:41
 */
@Data
public class BackUserRoleDetailResponseModel implements Serializable {
    private static final long serialVersionUID = 3052825933369661663L;
    private Integer id;
    private String roleName;
    private Integer status;
    private Map<String,Map<String,String>> authMap;
}
