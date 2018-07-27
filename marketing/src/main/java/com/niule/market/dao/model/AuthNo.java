package com.niule.market.dao.model;

import javax.persistence.*;

@Table(name = "auth_no")
public class AuthNo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 广告id
     */
    @Column(name = "advert_id")
    private Integer advertId;

    /**
     * qq号
     */
    private String qq;

    /**
     * 工号
     */
    @Column(name = "work_no")
    private String workNo;

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
     * 获取广告id
     *
     * @return advert_id - 广告id
     */
    public Integer getAdvertId() {
        return advertId;
    }

    /**
     * 设置广告id
     *
     * @param advertId 广告id
     */
    public void setAdvertId(Integer advertId) {
        this.advertId = advertId;
    }

    /**
     * 获取qq号
     *
     * @return qq - qq号
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置qq号
     *
     * @param qq qq号
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
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
}