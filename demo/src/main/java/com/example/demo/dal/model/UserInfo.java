package com.example.demo.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_info")
public class UserInfo {
    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户手机号（联系方式）
     */
    private String phone;

    /**
     * 用户对应的角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 性别（0：男 1：女）
     */
    private Integer sex;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 状态（0：禁用 1：启用 ）
     */
    private Integer status;

    /**
     * 微信接口id 唯一标识
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 销售经理id
     */
    @Column(name = "manage_id")
    private Integer manageId;

    /**
     * 头像路径
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 获取用户id
     *
     * @return id - 用户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户id
     *
     * @param id 用户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户密码
     *
     * @return password - 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     *
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取用户手机号（联系方式）
     *
     * @return phone - 用户手机号（联系方式）
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置用户手机号（联系方式）
     *
     * @param phone 用户手机号（联系方式）
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取用户对应的角色id
     *
     * @return role_id - 用户对应的角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置用户对应的角色id
     *
     * @param roleId 用户对应的角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取性别（0：男 1：女）
     *
     * @return sex - 性别（0：男 1：女）
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别（0：男 1：女）
     *
     * @param sex 性别（0：男 1：女）
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取状态（0：禁用 1：启用 ）
     *
     * @return status - 状态（0：禁用 1：启用 ）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态（0：禁用 1：启用 ）
     *
     * @param status 状态（0：禁用 1：启用 ）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取微信接口id 唯一标识
     *
     * @return open_id - 微信接口id 唯一标识
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置微信接口id 唯一标识
     *
     * @param openId 微信接口id 唯一标识
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 获取销售经理id
     *
     * @return manage_id - 销售经理id
     */
    public Integer getManageId() {
        return manageId;
    }

    /**
     * 设置销售经理id
     *
     * @param manageId 销售经理id
     */
    public void setManageId(Integer manageId) {
        this.manageId = manageId;
    }

    /**
     * 获取头像路径
     *
     * @return image_url - 头像路径
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 设置头像路径
     *
     * @param imageUrl 头像路径
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }
}