package com.niule.marketing.controller.controller.model;

/**
 * @author LsAusi
 * @date 2018/9/18
 * @time 15:57
 **/
public class LevelModel{
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
        this.levelName = levelName;
    }

    public String getLevelIdentity() {
        return levelIdentity;
    }

    public void setLevelIdentity(String levelIdentity) {
        this.levelIdentity = levelIdentity;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
