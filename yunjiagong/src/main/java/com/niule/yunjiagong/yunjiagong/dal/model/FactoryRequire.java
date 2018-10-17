package com.niule.yunjiagong.yunjiagong.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "factory_require")
public class FactoryRequire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "factoryRequire")
    private String factoryrequire;

    @Column(name = "createTimeStamp")
    private Date createtimestamp;

    @Column(name = "updateTimeStamp")
    private Date updatetimestamp;

    @Column(name = "creatorId")
    private Long creatorid;

    @Column(name = "creatorName")
    private String creatorname;

    private String sort;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return factoryRequire
     */
    public String getFactoryrequire() {
        return factoryrequire;
    }

    /**
     * @param factoryrequire
     */
    public void setFactoryrequire(String factoryrequire) {
        this.factoryrequire = factoryrequire == null ? null : factoryrequire.trim();
    }

    /**
     * @return createTimeStamp
     */
    public Date getCreatetimestamp() {
        return createtimestamp;
    }

    /**
     * @param createtimestamp
     */
    public void setCreatetimestamp(Date createtimestamp) {
        this.createtimestamp = createtimestamp;
    }

    /**
     * @return updateTimeStamp
     */
    public Date getUpdatetimestamp() {
        return updatetimestamp;
    }

    /**
     * @param updatetimestamp
     */
    public void setUpdatetimestamp(Date updatetimestamp) {
        this.updatetimestamp = updatetimestamp;
    }

    /**
     * @return creatorId
     */
    public Long getCreatorid() {
        return creatorid;
    }

    /**
     * @param creatorid
     */
    public void setCreatorid(Long creatorid) {
        this.creatorid = creatorid;
    }

    /**
     * @return creatorName
     */
    public String getCreatorname() {
        return creatorname;
    }

    /**
     * @param creatorname
     */
    public void setCreatorname(String creatorname) {
        this.creatorname = creatorname == null ? null : creatorname.trim();
    }

    /**
     * @return sort
     */
    public String getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }
}