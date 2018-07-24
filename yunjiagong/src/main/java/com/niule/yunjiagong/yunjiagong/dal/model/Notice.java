package com.niule.yunjiagong.yunjiagong.dal.model;

import javax.persistence.*;

public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 通知类型
     */
    @Column(name = "type_id")
    private Integer typeId;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 是否开启（1：开启 0：未开启）
     */
    @Column(name = "isStart")
    private String isstart;

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
     * 获取通知类型
     *
     * @return type_id - 通知类型
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * 设置通知类型
     *
     * @param typeId 通知类型
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取公告内容
     *
     * @return content - 公告内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置公告内容
     *
     * @param content 公告内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取是否开启（1：开启 0：未开启）
     *
     * @return isStart - 是否开启（1：开启 0：未开启）
     */
    public String getIsstart() {
        return isstart;
    }

    /**
     * 设置是否开启（1：开启 0：未开启）
     *
     * @param isstart 是否开启（1：开启 0：未开启）
     */
    public void setIsstart(String isstart) {
        this.isstart = isstart == null ? null : isstart.trim();
    }
}