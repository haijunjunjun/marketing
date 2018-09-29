package com.niule.yunjiagong.yunjiagong.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "advice_response")
public class AdviceResponse {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 问题类型
     */
    @Column(name = "question_type")
    private String questionType;

    /**
     * 详细问题与意见
     */
    @Column(name = "question_detail")
    private String questionDetail;

    /**
     * 相关问题图片与照片
     */
    @Column(name = "question_imgs")
    private String questionImgs;

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
     * 获取问题类型
     *
     * @return question_type - 问题类型
     */
    public String getQuestionType() {
        return questionType;
    }

    /**
     * 设置问题类型
     *
     * @param questionType 问题类型
     */
    public void setQuestionType(String questionType) {
        this.questionType = questionType == null ? null : questionType.trim();
    }

    /**
     * 获取详细问题与意见
     *
     * @return question_detail - 详细问题与意见
     */
    public String getQuestionDetail() {
        return questionDetail;
    }

    /**
     * 设置详细问题与意见
     *
     * @param questionDetail 详细问题与意见
     */
    public void setQuestionDetail(String questionDetail) {
        this.questionDetail = questionDetail == null ? null : questionDetail.trim();
    }

    /**
     * 获取相关问题图片与照片
     *
     * @return question_imgs - 相关问题图片与照片
     */
    public String getQuestionImgs() {
        return questionImgs;
    }

    /**
     * 设置相关问题图片与照片
     *
     * @param questionImgs 相关问题图片与照片
     */
    public void setQuestionImgs(String questionImgs) {
        this.questionImgs = questionImgs == null ? null : questionImgs.trim();
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