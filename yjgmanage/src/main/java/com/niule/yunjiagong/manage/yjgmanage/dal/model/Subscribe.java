package com.niule.yunjiagong.manage.yjgmanage.dal.model;

import java.util.Date;
import javax.persistence.*;

public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 订阅名字
     */
    @Column(name = "subscribe_name")
    private String subscribeName;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取订阅名字
     *
     * @return subscribe_name - 订阅名字
     */
    public String getSubscribeName() {
        return subscribeName;
    }

    /**
     * 设置订阅名字
     *
     * @param subscribeName 订阅名字
     */
    public void setSubscribeName(String subscribeName) {
        this.subscribeName = subscribeName == null ? null : subscribeName.trim();
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