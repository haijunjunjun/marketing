package com.niule.yunjiagong.yunjiagong.dal.model;

import java.util.Date;
import javax.persistence.*;

public class Industry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 工种
     */
    private String industry;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建者id
     */
    @Column(name = "creator_id")
    private Integer creatorId;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 图片
     */
    private String icon;

    /**
     * 分类
     */
    private Integer sort;

    /**
     * 是否展示（1：展示 0：不展示）
     */
    @Column(name = "isShow")
    private String isshow;

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
     * 获取工种
     *
     * @return industry - 工种
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * 设置工种
     *
     * @param industry 工种
     */
    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取创建者id
     *
     * @return creator_id - 创建者id
     */
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建者id
     *
     * @param creatorId 创建者id
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取创建者
     *
     * @return creator - 创建者
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建者
     *
     * @param creator 创建者
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 获取图片
     *
     * @return icon - 图片
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图片
     *
     * @param icon 图片
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取分类
     *
     * @return sort - 分类
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置分类
     *
     * @param sort 分类
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取是否展示（1：展示 0：不展示）
     *
     * @return isShow - 是否展示（1：展示 0：不展示）
     */
    public String getIsshow() {
        return isshow;
    }

    /**
     * 设置是否展示（1：展示 0：不展示）
     *
     * @param isshow 是否展示（1：展示 0：不展示）
     */
    public void setIsshow(String isshow) {
        this.isshow = isshow == null ? null : isshow.trim();
    }
}