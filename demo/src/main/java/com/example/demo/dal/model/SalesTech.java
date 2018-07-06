package com.example.demo.dal.model;

import javax.persistence.*;

@Table(name = "sales_tech")
public class SalesTech {
    @Id
    private Integer id;

    /**
     * 销售技巧编号
     */
    @Column(name = "tech_id")
    private String techId;

    /**
     * 销售技巧名称
     */
    @Column(name = "tech_name")
    private String techName;

    /**
     * 销售技巧内容
     */
    @Column(name = "tech_content")
    private String techContent;

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
     * 获取销售技巧编号
     *
     * @return tech_id - 销售技巧编号
     */
    public String getTechId() {
        return techId;
    }

    /**
     * 设置销售技巧编号
     *
     * @param techId 销售技巧编号
     */
    public void setTechId(String techId) {
        this.techId = techId == null ? null : techId.trim();
    }

    /**
     * 获取销售技巧名称
     *
     * @return tech_name - 销售技巧名称
     */
    public String getTechName() {
        return techName;
    }

    /**
     * 设置销售技巧名称
     *
     * @param techName 销售技巧名称
     */
    public void setTechName(String techName) {
        this.techName = techName == null ? null : techName.trim();
    }

    /**
     * 获取销售技巧内容
     *
     * @return tech_content - 销售技巧内容
     */
    public String getTechContent() {
        return techContent;
    }

    /**
     * 设置销售技巧内容
     *
     * @param techContent 销售技巧内容
     */
    public void setTechContent(String techContent) {
        this.techContent = techContent == null ? null : techContent.trim();
    }
}