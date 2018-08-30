package com.niule.marketing.control.dal.model;

import java.util.Date;

public class PerformanceConfigV1 {
    private Integer id;

    private String level;

    private Double baseBalary;

    private Double kpi;

    private Double deathLine;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Double getBaseBalary() {
        return baseBalary;
    }

    public void setBaseBalary(Double baseBalary) {
        this.baseBalary = baseBalary;
    }

    public Double getKpi() {
        return kpi;
    }

    public void setKpi(Double kpi) {
        this.kpi = kpi;
    }

    public Double getDeathLine() {
        return deathLine;
    }

    public void setDeathLine(Double deathLine) {
        this.deathLine = deathLine;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}