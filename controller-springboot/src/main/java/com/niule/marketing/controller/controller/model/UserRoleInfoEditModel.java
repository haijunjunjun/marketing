package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 27 - 17:09
 */
@Data
public class UserRoleInfoEditModel implements Serializable {
    private static final long serialVersionUID = -5666716347922656935L;
    private Integer id;
    private String roleName;
    private String roleDesc;
    private String status;
    private Integer toStatus;
    private List<AuthPageModel> authPageModelList;
}
