package com.niule.market.dao.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "adv_record")
public class AdvRecord {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 广告id
     */
    @Column(name = "advert_id")
    private Integer advertId;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 动作
     */
    private String action;

    /**
     * 来源
     */
    private String resource;

    /**
     * 访问url
     */
    @Column(name = "view_url")
    private String viewUrl;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取ip地址
     *
     * @return ip - ip地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置ip地址
     *
     * @param ip ip地址
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 获取动作
     *
     * @return action - 动作
     */
    public String getAction() {
        return action;
    }

    /**
     * 设置动作
     *
     * @param action 动作
     */
    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    /**
     * 获取来源
     *
     * @return resource - 来源
     */
    public String getResource() {
        return resource;
    }

    /**
     * 设置来源
     *
     * @param resource 来源
     */
    public void setResource(String resource) {
        this.resource = resource == null ? null : resource.trim();
    }

    /**
     * 获取访问url
     *
     * @return view_url - 访问url
     */
    public String getViewUrl() {
        return viewUrl;
    }

    /**
     * 设置访问url
     *
     * @param viewUrl 访问url
     */
    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl == null ? null : viewUrl.trim();
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
}