package com.example.demo.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "token_info")
public class TokenInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 过期时间
     */
    @Column(name = "expired_time")
    private Date expiredTime;

    /**
     * 状态（0：有效 1：无效）
     */
    private Integer status;

    /**
     * token字段
     */
    private String token;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取过期时间
     *
     * @return expired_time - 过期时间
     */
    public Date getExpiredTime() {
        return expiredTime;
    }

    /**
     * 设置过期时间
     *
     * @param expiredTime 过期时间
     */
    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    /**
     * 获取状态（0：有效 1：无效）
     *
     * @return status - 状态（0：有效 1：无效）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态（0：有效 1：无效）
     *
     * @param status 状态（0：有效 1：无效）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取token字段
     *
     * @return token - token字段
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置token字段
     *
     * @param token token字段
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
}