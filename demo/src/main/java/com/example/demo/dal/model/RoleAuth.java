package com.example.demo.dal.model;

import javax.persistence.*;

@Table(name = "role_auth")
public class RoleAuth {
    @Id
    private Integer id;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 权限信息
     */
    @Column(name = "auth_info")
    private String authInfo;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取权限信息
     *
     * @return auth_info - 权限信息
     */
    public String getAuthInfo() {
        return authInfo;
    }

    /**
     * 设置权限信息
     *
     * @param authInfo 权限信息
     */
    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo == null ? null : authInfo.trim();
    }
}