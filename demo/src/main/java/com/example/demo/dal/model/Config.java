package com.example.demo.dal.model;

import java.util.Date;
import javax.persistence.*;

public class Config {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "config_name")
    private String configName;

    /**
     * 配置值
     */
    @Column(name = "config_value")
    private Integer configValue;

    /**
     * 创建时间
     */
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
     * @return config_name
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * @param configName
     */
    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    /**
     * 获取配置值
     *
     * @return config_value - 配置值
     */
    public Integer getConfigValue() {
        return configValue;
    }

    /**
     * 设置配置值
     *
     * @param configValue 配置值
     */
    public void setConfigValue(Integer configValue) {
        this.configValue = configValue;
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