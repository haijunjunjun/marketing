package com.niule.yunjiagong.yunjiagong.dal.model;

import javax.persistence.*;

@Table(name = "address_info")
public class AddressInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 大写首字母
     */
    private String code;

    /**
     * 值
     */
    private String name;

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
     * 获取大写首字母
     *
     * @return code - 大写首字母
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置大写首字母
     *
     * @param code 大写首字母
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取值
     *
     * @return name - 值
     */
    public String getName() {
        return name;
    }

    /**
     * 设置值
     *
     * @param name 值
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}