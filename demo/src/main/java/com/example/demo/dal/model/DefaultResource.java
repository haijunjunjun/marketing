package com.example.demo.dal.model;

import javax.persistence.*;

@Table(name = "default_resource")
public class DefaultResource {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 默认资源字段名
     */
    private String name;

    /**
     * 资源路径
     */
    @Column(name = "resource_url")
    private String resourceUrl;

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
     * 获取默认资源字段名
     *
     * @return name - 默认资源字段名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置默认资源字段名
     *
     * @param name 默认资源字段名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
}