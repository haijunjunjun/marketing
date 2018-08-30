package com.niule.marketing.control.dal.model;

public class IncentInst {
    private Integer id;

    private String instId;

    private String instName;

    private String instContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId == null ? null : instId.trim();
    }

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName == null ? null : instName.trim();
    }

    public String getInstContent() {
        return instContent;
    }

    public void setInstContent(String instContent) {
        this.instContent = instContent == null ? null : instContent.trim();
    }
}