package com.niule.yunjiagong.yunjiagong.dal.model;

import javax.persistence.*;

@Table(name = "sign_template")
public class SignTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 连续签到多少天可以获得多少金豆
     */
    private Integer cycles;

    /**
     * 金豆数量
     */
    private Integer beans;

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
     * 获取连续签到多少天可以获得多少金豆
     *
     * @return cycles - 连续签到多少天可以获得多少金豆
     */
    public Integer getCycles() {
        return cycles;
    }

    /**
     * 设置连续签到多少天可以获得多少金豆
     *
     * @param cycles 连续签到多少天可以获得多少金豆
     */
    public void setCycles(Integer cycles) {
        this.cycles = cycles;
    }

    /**
     * 获取金豆数量
     *
     * @return beans - 金豆数量
     */
    public Integer getBeans() {
        return beans;
    }

    /**
     * 设置金豆数量
     *
     * @param beans 金豆数量
     */
    public void setBeans(Integer beans) {
        this.beans = beans;
    }
}