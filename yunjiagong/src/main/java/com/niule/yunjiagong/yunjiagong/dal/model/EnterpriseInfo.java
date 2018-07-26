package com.niule.yunjiagong.yunjiagong.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "enterprise_info")
public class EnterpriseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * logo图片
     */
    private String logo;

    /**
     * 员工数
     */
    @Column(name = "worker_cnt")
    private Integer workerCnt;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 公司类型
     */
    @Column(name = "company_type")
    private String companyType;

    /**
     * 公司地址
     */
    @Column(name = "company_address")
    private String companyAddress;

    /**
     * 公司电话
     */
    @Column(name = "company_phone")
    private String companyPhone;

    /**
     * 公司介绍
     */
    @Column(name = "company_desc")
    private String companyDesc;

    /**
     * 产品照片
     */
    @Column(name = "product_imgs")
    private String productImgs;

    /**
     * 工作间照片
     */
    @Column(name = "work_shop_imgs")
    private String workShopImgs;

    /**
     * 办公室照片
     */
    @Column(name = "office_imgs")
    private String officeImgs;

    /**
     * 样品间
     */
    @Column(name = "simple_room_imgs")
    private String simpleRoomImgs;

    /**
     * 工商资质照片
     */
    @Column(name = "qualification_imgs")
    private String qualificationImgs;

    /**
     * 公司招牌
     */
    @Column(name = "business_imgs")
    private String businessImgs;

    /**
     * 是否开启
     */
    private Integer switches;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 过期时间
     */
    @Column(name = "expire_time")
    private Date expireTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 负责人照片
     */
    @Column(name = "boss_img")
    private String bossImg;

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
     * 获取logo图片
     *
     * @return logo - logo图片
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 设置logo图片
     *
     * @param logo logo图片
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * 获取员工数
     *
     * @return worker_cnt - 员工数
     */
    public Integer getWorkerCnt() {
        return workerCnt;
    }

    /**
     * 设置员工数
     *
     * @param workerCnt 员工数
     */
    public void setWorkerCnt(Integer workerCnt) {
        this.workerCnt = workerCnt;
    }

    /**
     * 获取公司名称
     *
     * @return company_name - 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名称
     *
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取公司类型
     *
     * @return company_type - 公司类型
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * 设置公司类型
     *
     * @param companyType 公司类型
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    /**
     * 获取公司地址
     *
     * @return company_address - 公司地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 设置公司地址
     *
     * @param companyAddress 公司地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    /**
     * 获取公司电话
     *
     * @return company_phone - 公司电话
     */
    public String getCompanyPhone() {
        return companyPhone;
    }

    /**
     * 设置公司电话
     *
     * @param companyPhone 公司电话
     */
    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone == null ? null : companyPhone.trim();
    }

    /**
     * 获取公司介绍
     *
     * @return company_desc - 公司介绍
     */
    public String getCompanyDesc() {
        return companyDesc;
    }

    /**
     * 设置公司介绍
     *
     * @param companyDesc 公司介绍
     */
    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc == null ? null : companyDesc.trim();
    }

    /**
     * 获取产品照片
     *
     * @return product_imgs - 产品照片
     */
    public String getProductImgs() {
        return productImgs;
    }

    /**
     * 设置产品照片
     *
     * @param productImgs 产品照片
     */
    public void setProductImgs(String productImgs) {
        this.productImgs = productImgs == null ? null : productImgs.trim();
    }

    /**
     * 获取工作间照片
     *
     * @return work_shop_imgs - 工作间照片
     */
    public String getWorkShopImgs() {
        return workShopImgs;
    }

    /**
     * 设置工作间照片
     *
     * @param workShopImgs 工作间照片
     */
    public void setWorkShopImgs(String workShopImgs) {
        this.workShopImgs = workShopImgs == null ? null : workShopImgs.trim();
    }

    /**
     * 获取办公室照片
     *
     * @return office_imgs - 办公室照片
     */
    public String getOfficeImgs() {
        return officeImgs;
    }

    /**
     * 设置办公室照片
     *
     * @param officeImgs 办公室照片
     */
    public void setOfficeImgs(String officeImgs) {
        this.officeImgs = officeImgs == null ? null : officeImgs.trim();
    }

    /**
     * 获取样品间
     *
     * @return simple_room_imgs - 样品间
     */
    public String getSimpleRoomImgs() {
        return simpleRoomImgs;
    }

    /**
     * 设置样品间
     *
     * @param simpleRoomImgs 样品间
     */
    public void setSimpleRoomImgs(String simpleRoomImgs) {
        this.simpleRoomImgs = simpleRoomImgs == null ? null : simpleRoomImgs.trim();
    }

    /**
     * 获取工商资质照片
     *
     * @return qualification_imgs - 工商资质照片
     */
    public String getQualificationImgs() {
        return qualificationImgs;
    }

    /**
     * 设置工商资质照片
     *
     * @param qualificationImgs 工商资质照片
     */
    public void setQualificationImgs(String qualificationImgs) {
        this.qualificationImgs = qualificationImgs == null ? null : qualificationImgs.trim();
    }

    /**
     * 获取公司招牌
     *
     * @return business_imgs - 公司招牌
     */
    public String getBusinessImgs() {
        return businessImgs;
    }

    /**
     * 设置公司招牌
     *
     * @param businessImgs 公司招牌
     */
    public void setBusinessImgs(String businessImgs) {
        this.businessImgs = businessImgs == null ? null : businessImgs.trim();
    }

    /**
     * 获取是否开启
     *
     * @return switches - 是否开启
     */
    public Integer getSwitches() {
        return switches;
    }

    /**
     * 设置是否开启
     *
     * @param switches 是否开启
     */
    public void setSwitches(Integer switches) {
        this.switches = switches;
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
     * 获取过期时间
     *
     * @return expire_time - 过期时间
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * 设置过期时间
     *
     * @param expireTime 过期时间
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取负责人照片
     *
     * @return boss_img - 负责人照片
     */
    public String getBossImg() {
        return bossImg;
    }

    /**
     * 设置负责人照片
     *
     * @param bossImg 负责人照片
     */
    public void setBossImg(String bossImg) {
        this.bossImg = bossImg == null ? null : bossImg.trim();
    }
}