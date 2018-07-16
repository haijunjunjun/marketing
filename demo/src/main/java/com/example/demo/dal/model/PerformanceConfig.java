package com.example.demo.dal.model;

import javax.persistence.*;

@Table(name = "performance_config")
public class PerformanceConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 代码字段
     */
    private String code;

    /**
     * 代码字段对应值
     */
    private String value;

    /**
     * 备注
     */
    private String mark;

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
     * 获取代码字段
     *
     * @return code - 代码字段
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置代码字段
     *
     * @param code 代码字段
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取代码字段对应值
     *
     * @return value - 代码字段对应值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置代码字段对应值
     *
     * @param value 代码字段对应值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * 获取备注
     *
     * @return mark - 备注
     */
    public String getMark() {
        return mark;
    }

    /**
     * 设置备注
     *
     * @param mark 备注
     */
    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}