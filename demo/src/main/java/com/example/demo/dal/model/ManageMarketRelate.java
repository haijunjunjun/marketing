package com.example.demo.dal.model;

import javax.persistence.*;

@Table(name = "manage_market_relate")
public class ManageMarketRelate {
    @Id
    private Integer id;

    /**
     * 城市经理id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 销售人员id
     */
    @Column(name = "market_id")
    private String marketId;

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
     * 获取城市经理id
     *
     * @return user_id - 城市经理id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置城市经理id
     *
     * @param userId 城市经理id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取销售人员id
     *
     * @return market_id - 销售人员id
     */
    public String getMarketId() {
        return marketId;
    }

    /**
     * 设置销售人员id
     *
     * @param marketId 销售人员id
     */
    public void setMarketId(String marketId) {
        this.marketId = marketId == null ? null : marketId.trim();
    }
}