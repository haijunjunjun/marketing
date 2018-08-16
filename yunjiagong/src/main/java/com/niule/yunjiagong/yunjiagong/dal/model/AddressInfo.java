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
    private String key;

    /**
     * 值
     */
    private String value;

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
     * @return key - 大写首字母
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置大写首字母
     *
     * @param key 大写首字母
     */
    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    /**
     * 获取值
     *
     * @return value - 值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置值
     *
     * @param value 值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}