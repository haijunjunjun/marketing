package com.niule.yunjiagong.yunjiagong.dal.model;

import javax.persistence.*;

@Table(name = "hot_city")
public class HotCity {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * code码
     */
    private String code;

    /**
     * 名字
     */
    private String name;

    /**
     * address_info表的主键id
     */
    @Column(name = "address_info_id")
    private Integer addressInfoId;

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
     * 获取code码
     *
     * @return code - code码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置code码
     *
     * @param code code码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取名字
     *
     * @return name - 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取address_info表的主键id
     *
     * @return address_info_id - address_info表的主键id
     */
    public Integer getAddressInfoId() {
        return addressInfoId;
    }

    /**
     * 设置address_info表的主键id
     *
     * @param addressInfoId address_info表的主键id
     */
    public void setAddressInfoId(Integer addressInfoId) {
        this.addressInfoId = addressInfoId;
    }
}