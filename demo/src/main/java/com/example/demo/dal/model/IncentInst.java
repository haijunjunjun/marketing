package com.example.demo.dal.model;

import javax.persistence.*;

@Table(name = "incent_inst")
public class IncentInst {
    @Id
    private Integer id;

    /**
     * 制度编号
     */
    @Column(name = "inst_id")
    private String instId;

    /**
     * 制度名称
     */
    @Column(name = "inst_name")
    private String instName;

    /**
     * 制度内容
     */
    @Column(name = "inst_content")
    private String instContent;

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
     * 获取制度编号
     *
     * @return inst_id - 制度编号
     */
    public String getInstId() {
        return instId;
    }

    /**
     * 设置制度编号
     *
     * @param instId 制度编号
     */
    public void setInstId(String instId) {
        this.instId = instId == null ? null : instId.trim();
    }

    /**
     * 获取制度名称
     *
     * @return inst_name - 制度名称
     */
    public String getInstName() {
        return instName;
    }

    /**
     * 设置制度名称
     *
     * @param instName 制度名称
     */
    public void setInstName(String instName) {
        this.instName = instName == null ? null : instName.trim();
    }

    /**
     * 获取制度内容
     *
     * @return inst_content - 制度内容
     */
    public String getInstContent() {
        return instContent;
    }

    /**
     * 设置制度内容
     *
     * @param instContent 制度内容
     */
    public void setInstContent(String instContent) {
        this.instContent = instContent == null ? null : instContent.trim();
    }
}