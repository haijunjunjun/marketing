package com.niule.market.dao.model;

import javax.persistence.*;

public class Channel {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 渠道代码
     */
    private String name;

    /**
     * 渠道名称
     */
    private String value;

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
     * 获取渠道代码
     *
     * @return name - 渠道代码
     */
    public String getName() {
        return name;
    }

    /**
     * 设置渠道代码
     *
     * @param name 渠道代码
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取渠道名称
     *
     * @return value - 渠道名称
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置渠道名称
     *
     * @param value 渠道名称
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}