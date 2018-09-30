package com.niule.yunjiagong.yunjiagong.dal.model;

import java.util.Date;
import javax.persistence.*;

public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 单位
     */
    private String unit;

    @Column(name = "createTimeStamp")
    private Date createtimestamp;

    @Column(name = "updateTimeStamp")
    private Date updatetimestamp;

    @Column(name = "creatorId")
    private Long creatorid;

    /**
     * 创建人姓名
     */
    @Column(name = "creatorName")
    private String creatorname;

    private Integer sort;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取单位
     *
     * @return unit - 单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置单位
     *
     * @param unit 单位
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * @return createTimeStamp
     */
    public Date getCreatetimestamp() {
        return createtimestamp;
    }

    /**
     * @param createtimestamp
     */
    public void setCreatetimestamp(Date createtimestamp) {
        this.createtimestamp = createtimestamp;
    }

    /**
     * @return updateTimeStamp
     */
    public Date getUpdatetimestamp() {
        return updatetimestamp;
    }

    /**
     * @param updatetimestamp
     */
    public void setUpdatetimestamp(Date updatetimestamp) {
        this.updatetimestamp = updatetimestamp;
    }

    /**
     * @return creatorId
     */
    public Long getCreatorid() {
        return creatorid;
    }

    /**
     * @param creatorid
     */
    public void setCreatorid(Long creatorid) {
        this.creatorid = creatorid;
    }

    /**
     * 获取创建人姓名
     *
     * @return creatorName - 创建人姓名
     */
    public String getCreatorname() {
        return creatorname;
    }

    /**
     * 设置创建人姓名
     *
     * @param creatorname 创建人姓名
     */
    public void setCreatorname(String creatorname) {
        this.creatorname = creatorname == null ? null : creatorname.trim();
    }

    /**
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}