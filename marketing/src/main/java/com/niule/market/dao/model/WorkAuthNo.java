package com.niule.market.dao.model;

import javax.persistence.*;

@Table(name = "work_auth_no")
public class WorkAuthNo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 工号
     */
    @Column(name = "work_no")
    private String workNo;

    /**
     * 状态（1：启用 0 未启用）
     */
    private Integer status;

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
     * 获取工号
     *
     * @return work_no - 工号
     */
    public String getWorkNo() {
        return workNo;
    }

    /**
     * 设置工号
     *
     * @param workNo 工号
     */
    public void setWorkNo(String workNo) {
        this.workNo = workNo == null ? null : workNo.trim();
    }

    /**
     * 获取状态（1：启用 0 未启用）
     *
     * @return status - 状态（1：启用 0 未启用）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态（1：启用 0 未启用）
     *
     * @param status 状态（1：启用 0 未启用）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}