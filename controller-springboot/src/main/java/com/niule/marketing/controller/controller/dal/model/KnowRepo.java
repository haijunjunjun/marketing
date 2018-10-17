package com.niule.marketing.controller.controller.dal.model;

public class KnowRepo {
    private Integer id;

    private String title;

    private String repoId;

    private String repoName;

    private String repoContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getRepoId() {
        return repoId;
    }

    public void setRepoId(String repoId) {
        this.repoId = repoId == null ? null : repoId.trim();
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName == null ? null : repoName.trim();
    }

    public String getRepoContent() {
        return repoContent;
    }

    public void setRepoContent(String repoContent) {
        this.repoContent = repoContent == null ? null : repoContent.trim();
    }
}