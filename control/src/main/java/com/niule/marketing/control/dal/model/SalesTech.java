package com.niule.marketing.control.dal.model;

public class SalesTech {
    private Integer id;

    private String techId;

    private String techName;

    private String techContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTechId() {
        return techId;
    }

    public void setTechId(String techId) {
        this.techId = techId == null ? null : techId.trim();
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName == null ? null : techName.trim();
    }

    public String getTechContent() {
        return techContent;
    }

    public void setTechContent(String techContent) {
        this.techContent = techContent == null ? null : techContent.trim();
    }
}