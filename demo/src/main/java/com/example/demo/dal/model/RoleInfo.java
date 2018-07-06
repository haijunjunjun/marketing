package com.example.demo.dal.model;

import javax.persistence.*;

@Table(name = "role_info")
public class RoleInfo {
    /**
     * 角色id
     */
    @Id
    private Integer id;

    /**
     * 角色信息（market：销售人员 manage：城市经理）
     */
    @Column(name = "role_info")
    private String roleInfo;

    /**
     * 获取角色id
     *
     * @return id - 角色id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置角色id
     *
     * @param id 角色id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色信息（market：销售人员 manage：城市经理）
     *
     * @return role_info - 角色信息（market：销售人员 manage：城市经理）
     */
    public String getRoleInfo() {
        return roleInfo;
    }

    /**
     * 设置角色信息（market：销售人员 manage：城市经理）
     *
     * @param roleInfo 角色信息（market：销售人员 manage：城市经理）
     */
    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo == null ? null : roleInfo.trim();
    }
}