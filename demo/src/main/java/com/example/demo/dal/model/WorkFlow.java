package com.example.demo.dal.model;

import javax.persistence.*;

@Table(name = "work_flow")
public class WorkFlow {
    @Id
    private Integer id;

    /**
     * 流程编号
     */
    @Column(name = "flow_id")
    private String flowId;

    /**
     * 流程名称
     */
    @Column(name = "flow_name")
    private String flowName;

    /**
     * 流程内容
     */
    @Column(name = "flow_content")
    private String flowContent;

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
     * 获取流程编号
     *
     * @return flow_id - 流程编号
     */
    public String getFlowId() {
        return flowId;
    }

    /**
     * 设置流程编号
     *
     * @param flowId 流程编号
     */
    public void setFlowId(String flowId) {
        this.flowId = flowId == null ? null : flowId.trim();
    }

    /**
     * 获取流程名称
     *
     * @return flow_name - 流程名称
     */
    public String getFlowName() {
        return flowName;
    }

    /**
     * 设置流程名称
     *
     * @param flowName 流程名称
     */
    public void setFlowName(String flowName) {
        this.flowName = flowName == null ? null : flowName.trim();
    }

    /**
     * 获取流程内容
     *
     * @return flow_content - 流程内容
     */
    public String getFlowContent() {
        return flowContent;
    }

    /**
     * 设置流程内容
     *
     * @param flowContent 流程内容
     */
    public void setFlowContent(String flowContent) {
        this.flowContent = flowContent == null ? null : flowContent.trim();
    }
}