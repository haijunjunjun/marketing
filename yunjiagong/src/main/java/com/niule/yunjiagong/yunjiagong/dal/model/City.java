package com.niule.yunjiagong.yunjiagong.dal.model;

import javax.persistence.*;

public class City {
    /**
     * 城市名字
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String city;

    /**
     * 省份主键
     */
    @Column(name = "province_id")
    private Integer provinceId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 获取城市名字
     *
     * @return id - 城市名字
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置城市名字
     *
     * @param id 城市名字
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取省份主键
     *
     * @return province_id - 省份主键
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     * 设置省份主键
     *
     * @param provinceId 省份主键
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}