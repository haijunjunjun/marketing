package com.example.demo.dal.model;

import javax.persistence.*;

@Table(name = "know_repo")
public class KnowRepo {
    @Id
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 知识库编号
     */
    @Column(name = "repo_id")
    private String repoId;

    /**
     * 知识库名称
     */
    @Column(name = "repo_name")
    private String repoName;

    /**
     * 知识库内容
     */
    @Column(name = "repo_content")
    private String repoContent;

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
     * 获取知识库编号
     *
     * @return repo_id - 知识库编号
     */
    public String getRepoId() {
        return repoId;
    }

    /**
     * 设置知识库编号
     *
     * @param repoId 知识库编号
     */
    public void setRepoId(String repoId) {
        this.repoId = repoId == null ? null : repoId.trim();
    }

    /**
     * 获取知识库名称
     *
     * @return repo_name - 知识库名称
     */
    public String getRepoName() {
        return repoName;
    }

    /**
     * 设置知识库名称
     *
     * @param repoName 知识库名称
     */
    public void setRepoName(String repoName) {
        this.repoName = repoName == null ? null : repoName.trim();
    }

    /**
     * 获取知识库内容
     *
     * @return repo_content - 知识库内容
     */
    public String getRepoContent() {
        return repoContent;
    }

    /**
     * 设置知识库内容
     *
     * @param repoContent 知识库内容
     */
    public void setRepoContent(String repoContent) {
        this.repoContent = repoContent == null ? null : repoContent.trim();
    }
}