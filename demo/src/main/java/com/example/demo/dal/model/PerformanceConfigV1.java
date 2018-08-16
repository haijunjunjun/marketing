package com.example.demo.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "performance_config_v1")
public class PerformanceConfigV1 {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 等级
     */
    private String level;

    /**
     * 底薪
     */
    @Column(name = "base_balary")
    private Double baseBalary;

    /**
     * 绩效考核
     */
    private Double kpi;

    /**
     * 生死线
     */
    @Column(name = "death_line")
    private Double deathLine;

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
     * 获取等级
     *
     * @return level - 等级
     */
    public String getLevel() {
        return level;
    }

    /**
     * 设置等级
     *
     * @param level 等级
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * 获取底薪
     *
     * @return base_balary - 底薪
     */
    public Double getBaseBalary() {
        return baseBalary;
    }

    /**
     * 设置底薪
     *
     * @param baseBalary 底薪
     */
    public void setBaseBalary(Double baseBalary) {
        this.baseBalary = baseBalary;
    }

    /**
     * 获取绩效考核
     *
     * @return kpi - 绩效考核
     */
    public Double getKpi() {
        return kpi;
    }

    /**
     * 设置绩效考核
     *
     * @param kpi 绩效考核
     */
    public void setKpi(Double kpi) {
        this.kpi = kpi;
    }

    /**
     * 获取生死线
     *
     * @return death_line - 生死线
     */
    public Double getDeathLine() {
        return deathLine;
    }

    /**
     * 设置生死线
     *
     * @param deathLine 生死线
     */
    public void setDeathLine(Double deathLine) {
        this.deathLine = deathLine;
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