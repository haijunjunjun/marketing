package com.niule.yunjiagong.yunjiagong.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "process_break_config")
public class ProcessBreakConfig {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 进程类型
     */
    @Column(name = "process_type")
    private String processType;

    /**
     * 进程类型描述
     */
    @Column(name = "process_type_desc")
    private String processTypeDesc;

    /**
     * 取消原因(我方)
     */
    @Column(name = "break_reason_my")
    private String breakReasonMy;

    /**
     * 取消原因(对方)
     */
    @Column(name = "break_reason_opppsitive")
    private String breakReasonOpppsitive;

    /**
     * 原因类型（1：甲方 2：乙方）
     */
    @Column(name = "reason_type")
    private String reasonType;

    /**
     * 创建人姓名
     */
    @Column(name = "create_name")
    private String createName;

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
     * 获取进程类型
     *
     * @return process_type - 进程类型
     */
    public String getProcessType() {
        return processType;
    }

    /**
     * 设置进程类型
     *
     * @param processType 进程类型
     */
    public void setProcessType(String processType) {
        this.processType = processType == null ? null : processType.trim();
    }

    /**
     * 获取进程类型描述
     *
     * @return process_type_desc - 进程类型描述
     */
    public String getProcessTypeDesc() {
        return processTypeDesc;
    }

    /**
     * 设置进程类型描述
     *
     * @param processTypeDesc 进程类型描述
     */
    public void setProcessTypeDesc(String processTypeDesc) {
        this.processTypeDesc = processTypeDesc == null ? null : processTypeDesc.trim();
    }

    /**
     * 获取取消原因(我方)
     *
     * @return break_reason_my - 取消原因(我方)
     */
    public String getBreakReasonMy() {
        return breakReasonMy;
    }

    /**
     * 设置取消原因(我方)
     *
     * @param breakReasonMy 取消原因(我方)
     */
    public void setBreakReasonMy(String breakReasonMy) {
        this.breakReasonMy = breakReasonMy == null ? null : breakReasonMy.trim();
    }

    /**
     * 获取取消原因(对方)
     *
     * @return break_reason_opppsitive - 取消原因(对方)
     */
    public String getBreakReasonOpppsitive() {
        return breakReasonOpppsitive;
    }

    /**
     * 设置取消原因(对方)
     *
     * @param breakReasonOpppsitive 取消原因(对方)
     */
    public void setBreakReasonOpppsitive(String breakReasonOpppsitive) {
        this.breakReasonOpppsitive = breakReasonOpppsitive == null ? null : breakReasonOpppsitive.trim();
    }

    /**
     * 获取原因类型（1：甲方 2：乙方）
     *
     * @return reason_type - 原因类型（1：甲方 2：乙方）
     */
    public String getReasonType() {
        return reasonType;
    }

    /**
     * 设置原因类型（1：甲方 2：乙方）
     *
     * @param reasonType 原因类型（1：甲方 2：乙方）
     */
    public void setReasonType(String reasonType) {
        this.reasonType = reasonType == null ? null : reasonType.trim();
    }

    /**
     * 获取创建人姓名
     *
     * @return create_name - 创建人姓名
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 设置创建人姓名
     *
     * @param createName 创建人姓名
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
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