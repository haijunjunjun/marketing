package com.example.demo.dal.model;

import javax.persistence.*;

@Table(name = "manage_market_relate")
public class ManageMarketRelate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 城市经理id
     */
    @Column(name = "manage_id")
    private Integer manageId;

    /**
     * 销售人员id
     */
    @Column(name = "market_id")
    private Integer marketId;

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
     * @return manage_id - 城市经理id
     */
    public Integer getManageId() {
        return manageId;
    }

    /**
     * 设置城市经理id
     *
     * @param manageId 城市经理id
     */
    public void setManageId(Integer manageId) {
        this.manageId = manageId;
    }

    /**
     * 获取销售人员id
     *
     * @return market_id - 销售人员id
     */
    public Integer getMarketId() {
        return marketId;
    }

    /**
     * 设置销售人员id
     *
     * @param marketId 销售人员id
     */
    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }
}