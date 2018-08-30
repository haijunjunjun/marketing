package com.niule.marketing.controller.controller.dal.model;

public class WorkFlow {
    private Integer id;

    private String flowId;

    private String flowName;

    private String flowContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId == null ? null : flowId.trim();
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName == null ? null : flowName.trim();
    }

    public String getFlowContent() {
        return flowContent;
    }

    public void setFlowContent(String flowContent) {
        this.flowContent = flowContent == null ? null : flowContent.trim();
    }
}