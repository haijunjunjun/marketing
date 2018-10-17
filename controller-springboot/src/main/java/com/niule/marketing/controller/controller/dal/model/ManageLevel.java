package com.niule.marketing.controller.controller.dal.model;

public class ManageLevel {
    private Integer id;

    private String levelName;

    private String levelIdentity;

    private String mark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public String getLevelIdentity() {
        return levelIdentity;
    }

    public void setLevelIdentity(String levelIdentity) {
        this.levelIdentity = levelIdentity == null ? null : levelIdentity.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}