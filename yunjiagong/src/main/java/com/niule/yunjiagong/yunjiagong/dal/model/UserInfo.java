package com.niule.yunjiagong.yunjiagong.dal.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_info")
public class UserInfo {
    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * logo图片
     */
    private String logo;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 密码
     */
    private String password;

    /**
     * 个人认证
     */
    @Column(name = "personal_verify")
    private Integer personalVerify;

    /**
     * 企业认证
     */
    @Column(name = "business_verify")
    private Integer businessVerify;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 公司地址
     */
    @Column(name = "company_address")
    private String companyAddress;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 公司电话
     */
    @Column(name = "company_phone")
    private String companyPhone;

    /**
     * 发布数量
     */
    @Column(name = "release_count")
    private Integer releaseCount;

    /**
     * 发承接的数量
     */
    @Column(name = "order_tasks_count")
    private Integer orderTasksCount;

    /**
     * 余额
     */
    @Column(name = "balance_money")
    private Double balanceMoney;

    /**
     * 金豆
     */
    @Column(name = "gold_beans")
    private Integer goldBeans;

    /**
     * 身份证号
     */
    @Column(name = "card_no")
    private String cardNo;

    /**
     * 荣誉度
     */
    @Column(name = "reputation_score")
    private Integer reputationScore;

    /**
     * 用户类型
     */
    @Column(name = "user_type")
    private Integer userType;

    /**
     * 订阅数量
     */
    @Column(name = "subscribe_count")
    private Integer subscribeCount;

    /**
     * 身份证正面
     */
    @Column(name = "card_no_just")
    private String cardNoJust;

    /**
     * 身份证反面
     */
    @Column(name = "card_no_back")
    private String cardNoBack;

    /**
     * 营业执照
     */
    @Column(name = "business_license")
    private String businessLicense;

    /**
     * 公司大门照
     */
    @Column(name = "door_photo")
    private String doorPhoto;

    /**
     * 公司环境照
     */
    @Column(name = "environment_around")
    private String environmentAround;

    /**
     * 1：注册用户 2：个人高级认证 3：企业认证
     */
    @Column(name = "user_verify")
    private Integer userVerify;

    /**
     * 卡券总数
     */
    @Column(name = "coupons_cnt")
    private Integer couponsCnt;

    /**
     * 1：有 0：无（企业站台）
     */
    @Column(name = "has_enterprise_info")
    private Integer hasEnterpriseInfo;

    /**
     * 企业站台id
     */
    @Column(name = "enterprise_id")
    private Integer enterpriseId;

    /**
     * 获取用户id
     *
     * @return id - 用户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户id
     *
     * @param id 用户id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取个人认证
     *
     * @return personal_verify - 个人认证
     */
    public Integer getPersonalVerify() {
        return personalVerify;
    }

    /**
     * 设置个人认证
     *
     * @param personalVerify 个人认证
     */
    public void setPersonalVerify(Integer personalVerify) {
        this.personalVerify = personalVerify;
    }

    /**
     * 获取企业认证
     *
     * @return business_verify - 企业认证
     */
    public Integer getBusinessVerify() {
        return businessVerify;
    }

    /**
     * 设置企业认证
     *
     * @param businessVerify 企业认证
     */
    public void setBusinessVerify(Integer businessVerify) {
        this.businessVerify = businessVerify;
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
     * 获取发布数量
     *
     * @return release_count - 发布数量
     */
    public Integer getReleaseCount() {
        return releaseCount;
    }

    /**
     * 设置发布数量
     *
     * @param releaseCount 发布数量
     */
    public void setReleaseCount(Integer releaseCount) {
        this.releaseCount = releaseCount;
    }

    /**
     * 获取发承接的数量
     *
     * @return order_tasks_count - 发承接的数量
     */
    public Integer getOrderTasksCount() {
        return orderTasksCount;
    }

    /**
     * 设置发承接的数量
     *
     * @param orderTasksCount 发承接的数量
     */
    public void setOrderTasksCount(Integer orderTasksCount) {
        this.orderTasksCount = orderTasksCount;
    }

    /**
     * 获取余额
     *
     * @return balance_money - 余额
     */
    public Double getBalanceMoney() {
        return balanceMoney;
    }

    /**
     * 设置余额
     *
     * @param balanceMoney 余额
     */
    public void setBalanceMoney(Double balanceMoney) {
        this.balanceMoney = balanceMoney;
    }

    /**
     * 获取金豆
     *
     * @return gold_beans - 金豆
     */
    public Integer getGoldBeans() {
        return goldBeans;
    }

    /**
     * 设置金豆
     *
     * @param goldBeans 金豆
     */
    public void setGoldBeans(Integer goldBeans) {
        this.goldBeans = goldBeans;
    }

    /**
     * 获取身份证号
     *
     * @return card_no - 身份证号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置身份证号
     *
     * @param cardNo 身份证号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 获取荣誉度
     *
     * @return reputation_score - 荣誉度
     */
    public Integer getReputationScore() {
        return reputationScore;
    }

    /**
     * 设置荣誉度
     *
     * @param reputationScore 荣誉度
     */
    public void setReputationScore(Integer reputationScore) {
        this.reputationScore = reputationScore;
    }

    /**
     * 获取用户类型
     *
     * @return user_type - 用户类型
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置用户类型
     *
     * @param userType 用户类型
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取订阅数量
     *
     * @return subscribe_count - 订阅数量
     */
    public Integer getSubscribeCount() {
        return subscribeCount;
    }

    /**
     * 设置订阅数量
     *
     * @param subscribeCount 订阅数量
     */
    public void setSubscribeCount(Integer subscribeCount) {
        this.subscribeCount = subscribeCount;
    }

    /**
     * 获取身份证正面
     *
     * @return card_no_just - 身份证正面
     */
    public String getCardNoJust() {
        return cardNoJust;
    }

    /**
     * 设置身份证正面
     *
     * @param cardNoJust 身份证正面
     */
    public void setCardNoJust(String cardNoJust) {
        this.cardNoJust = cardNoJust == null ? null : cardNoJust.trim();
    }

    /**
     * 获取身份证反面
     *
     * @return card_no_back - 身份证反面
     */
    public String getCardNoBack() {
        return cardNoBack;
    }

    /**
     * 设置身份证反面
     *
     * @param cardNoBack 身份证反面
     */
    public void setCardNoBack(String cardNoBack) {
        this.cardNoBack = cardNoBack == null ? null : cardNoBack.trim();
    }

    /**
     * 获取营业执照
     *
     * @return business_license - 营业执照
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * 设置营业执照
     *
     * @param businessLicense 营业执照
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    /**
     * 获取公司大门照
     *
     * @return door_photo - 公司大门照
     */
    public String getDoorPhoto() {
        return doorPhoto;
    }

    /**
     * 设置公司大门照
     *
     * @param doorPhoto 公司大门照
     */
    public void setDoorPhoto(String doorPhoto) {
        this.doorPhoto = doorPhoto == null ? null : doorPhoto.trim();
    }

    /**
     * 获取公司环境照
     *
     * @return environment_around - 公司环境照
     */
    public String getEnvironmentAround() {
        return environmentAround;
    }

    /**
     * 设置公司环境照
     *
     * @param environmentAround 公司环境照
     */
    public void setEnvironmentAround(String environmentAround) {
        this.environmentAround = environmentAround == null ? null : environmentAround.trim();
    }

    /**
     * 获取1：注册用户 2：个人高级认证 3：企业认证
     *
     * @return user_verify - 1：注册用户 2：个人高级认证 3：企业认证
     */
    public Integer getUserVerify() {
        return userVerify;
    }

    /**
     * 设置1：注册用户 2：个人高级认证 3：企业认证
     *
     * @param userVerify 1：注册用户 2：个人高级认证 3：企业认证
     */
    public void setUserVerify(Integer userVerify) {
        this.userVerify = userVerify;
    }

    /**
     * 获取卡券总数
     *
     * @return coupons_cnt - 卡券总数
     */
    public Integer getCouponsCnt() {
        return couponsCnt;
    }

    /**
     * 设置卡券总数
     *
     * @param couponsCnt 卡券总数
     */
    public void setCouponsCnt(Integer couponsCnt) {
        this.couponsCnt = couponsCnt;
    }

    /**
     * 获取1：有 0：无（企业站台）
     *
     * @return has_enterprise_info - 1：有 0：无（企业站台）
     */
    public Integer getHasEnterpriseInfo() {
        return hasEnterpriseInfo;
    }

    /**
     * 设置1：有 0：无（企业站台）
     *
     * @param hasEnterpriseInfo 1：有 0：无（企业站台）
     */
    public void setHasEnterpriseInfo(Integer hasEnterpriseInfo) {
        this.hasEnterpriseInfo = hasEnterpriseInfo;
    }

    /**
     * 获取企业站台id
     *
     * @return enterprise_id - 企业站台id
     */
    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * 设置企业站台id
     *
     * @param enterpriseId 企业站台id
     */
    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}