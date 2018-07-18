package com.niule.market.dao.model;

import java.util.Date;
import javax.persistence.*;

public class Advert {
    /**
     * 广告id
     */
    @Id
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 渠道id
     */
    @Column(name = "channel_id")
    private Integer channelId;

    /**
     * 类型（1：二维码 2：链接）
     */
    private Integer type;

    /**
     * 二维码链接
     */
    @Column(name = "ewm_url")
    private String ewmUrl;

    /**
     * 链接
     */
    private String url;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取广告id
     *
     * @return id - 广告id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置广告id
     *
     * @param id 广告id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取渠道id
     *
     * @return channel_id - 渠道id
     */
    public Integer getChannelId() {
        return channelId;
    }

    /**
     * 设置渠道id
     *
     * @param channelId 渠道id
     */
    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取类型（1：二维码 2：链接）
     *
     * @return type - 类型（1：二维码 2：链接）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型（1：二维码 2：链接）
     *
     * @param type 类型（1：二维码 2：链接）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取二维码链接
     *
     * @return ewm_url - 二维码链接
     */
    public String getEwmUrl() {
        return ewmUrl;
    }

    /**
     * 设置二维码链接
     *
     * @param ewmUrl 二维码链接
     */
    public void setEwmUrl(String ewmUrl) {
        this.ewmUrl = ewmUrl == null ? null : ewmUrl.trim();
    }

    /**
     * 获取链接
     *
     * @return url - 链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置链接
     *
     * @param url 链接
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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