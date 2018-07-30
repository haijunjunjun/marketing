package com.niule.yunjiagong.yunjiagong.dal.model;

import javax.persistence.*;

@Table(name = "active_info")
public class ActiveInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 图片
     */
    private String img;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 本地地址
     */
    @Column(name = "local_url")
    private String localUrl;

    /**
     * 分享链接
     */
    @Column(name = "share_url")
    private String shareUrl;

    @Column(name = "reward_beans")
    private Integer rewardBeans;

    @Column(name = "reward_max")
    private Integer rewardMax;

    /**
     * 活跃标志
     */
    @Column(name = "active_sign")
    private String activeSign;

    private Integer swiches;

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
     * 获取图片
     *
     * @return img - 图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置图片
     *
     * @param img 图片
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
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
     * 获取本地地址
     *
     * @return local_url - 本地地址
     */
    public String getLocalUrl() {
        return localUrl;
    }

    /**
     * 设置本地地址
     *
     * @param localUrl 本地地址
     */
    public void setLocalUrl(String localUrl) {
        this.localUrl = localUrl == null ? null : localUrl.trim();
    }

    /**
     * 获取分享链接
     *
     * @return share_url - 分享链接
     */
    public String getShareUrl() {
        return shareUrl;
    }

    /**
     * 设置分享链接
     *
     * @param shareUrl 分享链接
     */
    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl == null ? null : shareUrl.trim();
    }

    /**
     * @return reward_beans
     */
    public Integer getRewardBeans() {
        return rewardBeans;
    }

    /**
     * @param rewardBeans
     */
    public void setRewardBeans(Integer rewardBeans) {
        this.rewardBeans = rewardBeans;
    }

    /**
     * @return reward_max
     */
    public Integer getRewardMax() {
        return rewardMax;
    }

    /**
     * @param rewardMax
     */
    public void setRewardMax(Integer rewardMax) {
        this.rewardMax = rewardMax;
    }

    /**
     * 获取活跃标志
     *
     * @return active_sign - 活跃标志
     */
    public String getActiveSign() {
        return activeSign;
    }

    /**
     * 设置活跃标志
     *
     * @param activeSign 活跃标志
     */
    public void setActiveSign(String activeSign) {
        this.activeSign = activeSign == null ? null : activeSign.trim();
    }

    /**
     * @return swiches
     */
    public Integer getSwiches() {
        return swiches;
    }

    /**
     * @param swiches
     */
    public void setSwiches(Integer swiches) {
        this.swiches = swiches;
    }
}