package com.niule.yunjiagong.yunjiagong.dal.model;

import javax.persistence.*;

public class Area {
    /**
     * 城市id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 区域
     */
    private String area;

    /**
     * 城市id
     */
    @Column(name = "city_id")
    private Integer cityId;

    /**
     * 是否展示（1：展示 0：不展示）
     */
    @Column(name = "is_show")
    private String isShow;

    /**
     * 获取城市id
     *
     * @return id - 城市id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置城市id
     *
     * @param id 城市id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取区域
     *
     * @return area - 区域
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置区域
     *
     * @param area 区域
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 获取城市id
     *
     * @return city_id - 城市id
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 设置城市id
     *
     * @param cityId 城市id
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取是否展示（1：展示 0：不展示）
     *
     * @return is_show - 是否展示（1：展示 0：不展示）
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * 设置是否展示（1：展示 0：不展示）
     *
     * @param isShow 是否展示（1：展示 0：不展示）
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
    }
}