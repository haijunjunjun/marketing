package com.niule.yunjiagong.yunjiagong.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "recommend_log")
public class RecommendLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "host_id")
    private Integer hostId;

    private Integer beans;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "create_time")
    private Date createTime;

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
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return host_id
     */
    public Integer getHostId() {
        return hostId;
    }

    /**
     * @param hostId
     */
    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    /**
     * @return beans
     */
    public Integer getBeans() {
        return beans;
    }

    /**
     * @param beans
     */
    public void setBeans(Integer beans) {
        this.beans = beans;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}