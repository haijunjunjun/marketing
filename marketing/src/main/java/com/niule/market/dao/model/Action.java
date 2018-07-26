package com.niule.market.dao.model;

import javax.persistence.*;

public class Action {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 动作名称
     */
    private String action;

    /**
     * 发生次数
     */
    @Column(name = "happen_count")
    private Integer happenCount;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取动作名称
     *
     * @return action - 动作名称
     */
    public String getAction() {
        return action;
    }

    /**
     * 设置动作名称
     *
     * @param action 动作名称
     */
    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    /**
     * 获取发生次数
     *
     * @return happen_count - 发生次数
     */
    public Integer getHappenCount() {
        return happenCount;
    }

    /**
     * 设置发生次数
     *
     * @param happenCount 发生次数
     */
    public void setHappenCount(Integer happenCount) {
        this.happenCount = happenCount;
    }
}