package com.example.demo.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_gold_beans")
public class UserGoldBeans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 金豆数量（该销售员可赠送出的金豆数量）
     */
    @Column(name = "gold_beans_num")
    private Integer goldBeansNum;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

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
     * 获取金豆数量（该销售员可赠送出的金豆数量）
     *
     * @return gold_beans_num - 金豆数量（该销售员可赠送出的金豆数量）
     */
    public Integer getGoldBeansNum() {
        return goldBeansNum;
    }

    /**
     * 设置金豆数量（该销售员可赠送出的金豆数量）
     *
     * @param goldBeansNum 金豆数量（该销售员可赠送出的金豆数量）
     */
    public void setGoldBeansNum(Integer goldBeansNum) {
        this.goldBeansNum = goldBeansNum;
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

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}