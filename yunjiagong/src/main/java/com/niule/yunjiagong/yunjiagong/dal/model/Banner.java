package com.niule.yunjiagong.yunjiagong.dal.model;

import java.util.Date;
import javax.persistence.*;

public class Banner {
    /**
     * 轮播图主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 资源路径
     */
    @Column(name = "resource_url")
    private String resourceUrl;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建者id
     */
    @Column(name = "creator_id")
    private Integer creatorId;

    /**
     * 创建者名字
     */
    private String creator;

    /**
     * 轮播图类型
     */
    @Column(name = "banner_type")
    private String bannerType;

    /**
     * 链接
     */
    private String link;

    /**
     * 分类
     */
    private String sort;

    /**
     * 获取轮播图主键
     *
     * @return id - 轮播图主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置轮播图主键
     *
     * @param id 轮播图主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取资源路径
     *
     * @return resource_url - 资源路径
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * 设置资源路径
     *
     * @param resourceUrl 资源路径
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
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
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
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
     * 获取创建者名字
     *
     * @return creator - 创建者名字
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建者名字
     *
     * @param creator 创建者名字
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 获取轮播图类型
     *
     * @return banner_type - 轮播图类型
     */
    public String getBannerType() {
        return bannerType;
    }

    /**
     * 设置轮播图类型
     *
     * @param bannerType 轮播图类型
     */
    public void setBannerType(String bannerType) {
        this.bannerType = bannerType == null ? null : bannerType.trim();
    }

    /**
     * 获取链接
     *
     * @return link - 链接
     */
    public String getLink() {
        return link;
    }

    /**
     * 设置链接
     *
     * @param link 链接
     */
    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    /**
     * 获取分类
     *
     * @return sort - 分类
     */
    public String getSort() {
        return sort;
    }

    /**
     * 设置分类
     *
     * @param sort 分类
     */
    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }
}