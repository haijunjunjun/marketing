package com.niule.marketing.control.dal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIsNull() {
            addCriterion("company_type is null");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIsNotNull() {
            addCriterion("company_type is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeEqualTo(String value) {
            addCriterion("company_type =", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotEqualTo(String value) {
            addCriterion("company_type <>", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeGreaterThan(String value) {
            addCriterion("company_type >", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("company_type >=", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLessThan(String value) {
            addCriterion("company_type <", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLessThanOrEqualTo(String value) {
            addCriterion("company_type <=", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLike(String value) {
            addCriterion("company_type like", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotLike(String value) {
            addCriterion("company_type not like", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIn(List<String> values) {
            addCriterion("company_type in", values, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotIn(List<String> values) {
            addCriterion("company_type not in", values, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeBetween(String value1, String value2) {
            addCriterion("company_type between", value1, value2, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotBetween(String value1, String value2) {
            addCriterion("company_type not between", value1, value2, "companyType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("cust_name is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("cust_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("cust_name =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("cust_name <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("cust_name >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("cust_name >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("cust_name <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("cust_name <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("cust_name like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("cust_name not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("cust_name in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("cust_name not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("cust_name between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("cust_name not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIsNull() {
            addCriterion("cust_phone is null");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIsNotNull() {
            addCriterion("cust_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCustPhoneEqualTo(String value) {
            addCriterion("cust_phone =", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotEqualTo(String value) {
            addCriterion("cust_phone <>", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneGreaterThan(String value) {
            addCriterion("cust_phone >", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("cust_phone >=", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLessThan(String value) {
            addCriterion("cust_phone <", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLessThanOrEqualTo(String value) {
            addCriterion("cust_phone <=", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLike(String value) {
            addCriterion("cust_phone like", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotLike(String value) {
            addCriterion("cust_phone not like", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIn(List<String> values) {
            addCriterion("cust_phone in", values, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotIn(List<String> values) {
            addCriterion("cust_phone not in", values, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneBetween(String value1, String value2) {
            addCriterion("cust_phone between", value1, value2, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotBetween(String value1, String value2) {
            addCriterion("cust_phone not between", value1, value2, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIsNull() {
            addCriterion("company_addr is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIsNotNull() {
            addCriterion("company_addr is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrEqualTo(String value) {
            addCriterion("company_addr =", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotEqualTo(String value) {
            addCriterion("company_addr <>", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrGreaterThan(String value) {
            addCriterion("company_addr >", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrGreaterThanOrEqualTo(String value) {
            addCriterion("company_addr >=", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLessThan(String value) {
            addCriterion("company_addr <", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLessThanOrEqualTo(String value) {
            addCriterion("company_addr <=", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLike(String value) {
            addCriterion("company_addr like", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotLike(String value) {
            addCriterion("company_addr not like", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIn(List<String> values) {
            addCriterion("company_addr in", values, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotIn(List<String> values) {
            addCriterion("company_addr not in", values, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrBetween(String value1, String value2) {
            addCriterion("company_addr between", value1, value2, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotBetween(String value1, String value2) {
            addCriterion("company_addr not between", value1, value2, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andRepoTimeIsNull() {
            addCriterion("repo_time is null");
            return (Criteria) this;
        }

        public Criteria andRepoTimeIsNotNull() {
            addCriterion("repo_time is not null");
            return (Criteria) this;
        }

        public Criteria andRepoTimeEqualTo(Date value) {
            addCriterion("repo_time =", value, "repoTime");
            return (Criteria) this;
        }

        public Criteria andRepoTimeNotEqualTo(Date value) {
            addCriterion("repo_time <>", value, "repoTime");
            return (Criteria) this;
        }

        public Criteria andRepoTimeGreaterThan(Date value) {
            addCriterion("repo_time >", value, "repoTime");
            return (Criteria) this;
        }

        public Criteria andRepoTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("repo_time >=", value, "repoTime");
            return (Criteria) this;
        }

        public Criteria andRepoTimeLessThan(Date value) {
            addCriterion("repo_time <", value, "repoTime");
            return (Criteria) this;
        }

        public Criteria andRepoTimeLessThanOrEqualTo(Date value) {
            addCriterion("repo_time <=", value, "repoTime");
            return (Criteria) this;
        }

        public Criteria andRepoTimeIn(List<Date> values) {
            addCriterion("repo_time in", values, "repoTime");
            return (Criteria) this;
        }

        public Criteria andRepoTimeNotIn(List<Date> values) {
            addCriterion("repo_time not in", values, "repoTime");
            return (Criteria) this;
        }

        public Criteria andRepoTimeBetween(Date value1, Date value2) {
            addCriterion("repo_time between", value1, value2, "repoTime");
            return (Criteria) this;
        }

        public Criteria andRepoTimeNotBetween(Date value1, Date value2) {
            addCriterion("repo_time not between", value1, value2, "repoTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("check_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("check_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Date value) {
            addCriterion("check_time =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Date value) {
            addCriterion("check_time <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Date value) {
            addCriterion("check_time >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_time >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Date value) {
            addCriterion("check_time <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_time <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Date> values) {
            addCriterion("check_time in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Date> values) {
            addCriterion("check_time not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Date value1, Date value2) {
            addCriterion("check_time between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_time not between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCompactTimeIsNull() {
            addCriterion("compact_time is null");
            return (Criteria) this;
        }

        public Criteria andCompactTimeIsNotNull() {
            addCriterion("compact_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompactTimeEqualTo(Date value) {
            addCriterion("compact_time =", value, "compactTime");
            return (Criteria) this;
        }

        public Criteria andCompactTimeNotEqualTo(Date value) {
            addCriterion("compact_time <>", value, "compactTime");
            return (Criteria) this;
        }

        public Criteria andCompactTimeGreaterThan(Date value) {
            addCriterion("compact_time >", value, "compactTime");
            return (Criteria) this;
        }

        public Criteria andCompactTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("compact_time >=", value, "compactTime");
            return (Criteria) this;
        }

        public Criteria andCompactTimeLessThan(Date value) {
            addCriterion("compact_time <", value, "compactTime");
            return (Criteria) this;
        }

        public Criteria andCompactTimeLessThanOrEqualTo(Date value) {
            addCriterion("compact_time <=", value, "compactTime");
            return (Criteria) this;
        }

        public Criteria andCompactTimeIn(List<Date> values) {
            addCriterion("compact_time in", values, "compactTime");
            return (Criteria) this;
        }

        public Criteria andCompactTimeNotIn(List<Date> values) {
            addCriterion("compact_time not in", values, "compactTime");
            return (Criteria) this;
        }

        public Criteria andCompactTimeBetween(Date value1, Date value2) {
            addCriterion("compact_time between", value1, value2, "compactTime");
            return (Criteria) this;
        }

        public Criteria andCompactTimeNotBetween(Date value1, Date value2) {
            addCriterion("compact_time not between", value1, value2, "compactTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeIsNull() {
            addCriterion("abandon_time is null");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeIsNotNull() {
            addCriterion("abandon_time is not null");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeEqualTo(Date value) {
            addCriterion("abandon_time =", value, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeNotEqualTo(Date value) {
            addCriterion("abandon_time <>", value, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeGreaterThan(Date value) {
            addCriterion("abandon_time >", value, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("abandon_time >=", value, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeLessThan(Date value) {
            addCriterion("abandon_time <", value, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeLessThanOrEqualTo(Date value) {
            addCriterion("abandon_time <=", value, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeIn(List<Date> values) {
            addCriterion("abandon_time in", values, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeNotIn(List<Date> values) {
            addCriterion("abandon_time not in", values, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeBetween(Date value1, Date value2) {
            addCriterion("abandon_time between", value1, value2, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andAbandonTimeNotBetween(Date value1, Date value2) {
            addCriterion("abandon_time not between", value1, value2, "abandonTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNull() {
            addCriterion("delete_time is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNotNull() {
            addCriterion("delete_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualTo(Date value) {
            addCriterion("delete_time =", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualTo(Date value) {
            addCriterion("delete_time <>", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThan(Date value) {
            addCriterion("delete_time >", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delete_time >=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThan(Date value) {
            addCriterion("delete_time <", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("delete_time <=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIn(List<Date> values) {
            addCriterion("delete_time in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotIn(List<Date> values) {
            addCriterion("delete_time not in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeBetween(Date value1, Date value2) {
            addCriterion("delete_time between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("delete_time not between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andIsPhoneIsNull() {
            addCriterion("is_phone is null");
            return (Criteria) this;
        }

        public Criteria andIsPhoneIsNotNull() {
            addCriterion("is_phone is not null");
            return (Criteria) this;
        }

        public Criteria andIsPhoneEqualTo(Integer value) {
            addCriterion("is_phone =", value, "isPhone");
            return (Criteria) this;
        }

        public Criteria andIsPhoneNotEqualTo(Integer value) {
            addCriterion("is_phone <>", value, "isPhone");
            return (Criteria) this;
        }

        public Criteria andIsPhoneGreaterThan(Integer value) {
            addCriterion("is_phone >", value, "isPhone");
            return (Criteria) this;
        }

        public Criteria andIsPhoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_phone >=", value, "isPhone");
            return (Criteria) this;
        }

        public Criteria andIsPhoneLessThan(Integer value) {
            addCriterion("is_phone <", value, "isPhone");
            return (Criteria) this;
        }

        public Criteria andIsPhoneLessThanOrEqualTo(Integer value) {
            addCriterion("is_phone <=", value, "isPhone");
            return (Criteria) this;
        }

        public Criteria andIsPhoneIn(List<Integer> values) {
            addCriterion("is_phone in", values, "isPhone");
            return (Criteria) this;
        }

        public Criteria andIsPhoneNotIn(List<Integer> values) {
            addCriterion("is_phone not in", values, "isPhone");
            return (Criteria) this;
        }

        public Criteria andIsPhoneBetween(Integer value1, Integer value2) {
            addCriterion("is_phone between", value1, value2, "isPhone");
            return (Criteria) this;
        }

        public Criteria andIsPhoneNotBetween(Integer value1, Integer value2) {
            addCriterion("is_phone not between", value1, value2, "isPhone");
            return (Criteria) this;
        }

        public Criteria andIsVisitIsNull() {
            addCriterion("is_visit is null");
            return (Criteria) this;
        }

        public Criteria andIsVisitIsNotNull() {
            addCriterion("is_visit is not null");
            return (Criteria) this;
        }

        public Criteria andIsVisitEqualTo(Integer value) {
            addCriterion("is_visit =", value, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitNotEqualTo(Integer value) {
            addCriterion("is_visit <>", value, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitGreaterThan(Integer value) {
            addCriterion("is_visit >", value, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_visit >=", value, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitLessThan(Integer value) {
            addCriterion("is_visit <", value, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitLessThanOrEqualTo(Integer value) {
            addCriterion("is_visit <=", value, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitIn(List<Integer> values) {
            addCriterion("is_visit in", values, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitNotIn(List<Integer> values) {
            addCriterion("is_visit not in", values, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitBetween(Integer value1, Integer value2) {
            addCriterion("is_visit between", value1, value2, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsVisitNotBetween(Integer value1, Integer value2) {
            addCriterion("is_visit not between", value1, value2, "isVisit");
            return (Criteria) this;
        }

        public Criteria andIsGoldBeansIsNull() {
            addCriterion("is_gold_beans is null");
            return (Criteria) this;
        }

        public Criteria andIsGoldBeansIsNotNull() {
            addCriterion("is_gold_beans is not null");
            return (Criteria) this;
        }

        public Criteria andIsGoldBeansEqualTo(Integer value) {
            addCriterion("is_gold_beans =", value, "isGoldBeans");
            return (Criteria) this;
        }

        public Criteria andIsGoldBeansNotEqualTo(Integer value) {
            addCriterion("is_gold_beans <>", value, "isGoldBeans");
            return (Criteria) this;
        }

        public Criteria andIsGoldBeansGreaterThan(Integer value) {
            addCriterion("is_gold_beans >", value, "isGoldBeans");
            return (Criteria) this;
        }

        public Criteria andIsGoldBeansGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_gold_beans >=", value, "isGoldBeans");
            return (Criteria) this;
        }

        public Criteria andIsGoldBeansLessThan(Integer value) {
            addCriterion("is_gold_beans <", value, "isGoldBeans");
            return (Criteria) this;
        }

        public Criteria andIsGoldBeansLessThanOrEqualTo(Integer value) {
            addCriterion("is_gold_beans <=", value, "isGoldBeans");
            return (Criteria) this;
        }

        public Criteria andIsGoldBeansIn(List<Integer> values) {
            addCriterion("is_gold_beans in", values, "isGoldBeans");
            return (Criteria) this;
        }

        public Criteria andIsGoldBeansNotIn(List<Integer> values) {
            addCriterion("is_gold_beans not in", values, "isGoldBeans");
            return (Criteria) this;
        }

        public Criteria andIsGoldBeansBetween(Integer value1, Integer value2) {
            addCriterion("is_gold_beans between", value1, value2, "isGoldBeans");
            return (Criteria) this;
        }

        public Criteria andIsGoldBeansNotBetween(Integer value1, Integer value2) {
            addCriterion("is_gold_beans not between", value1, value2, "isGoldBeans");
            return (Criteria) this;
        }

        public Criteria andIsCompactIsNull() {
            addCriterion("is_compact is null");
            return (Criteria) this;
        }

        public Criteria andIsCompactIsNotNull() {
            addCriterion("is_compact is not null");
            return (Criteria) this;
        }

        public Criteria andIsCompactEqualTo(Integer value) {
            addCriterion("is_compact =", value, "isCompact");
            return (Criteria) this;
        }

        public Criteria andIsCompactNotEqualTo(Integer value) {
            addCriterion("is_compact <>", value, "isCompact");
            return (Criteria) this;
        }

        public Criteria andIsCompactGreaterThan(Integer value) {
            addCriterion("is_compact >", value, "isCompact");
            return (Criteria) this;
        }

        public Criteria andIsCompactGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_compact >=", value, "isCompact");
            return (Criteria) this;
        }

        public Criteria andIsCompactLessThan(Integer value) {
            addCriterion("is_compact <", value, "isCompact");
            return (Criteria) this;
        }

        public Criteria andIsCompactLessThanOrEqualTo(Integer value) {
            addCriterion("is_compact <=", value, "isCompact");
            return (Criteria) this;
        }

        public Criteria andIsCompactIn(List<Integer> values) {
            addCriterion("is_compact in", values, "isCompact");
            return (Criteria) this;
        }

        public Criteria andIsCompactNotIn(List<Integer> values) {
            addCriterion("is_compact not in", values, "isCompact");
            return (Criteria) this;
        }

        public Criteria andIsCompactBetween(Integer value1, Integer value2) {
            addCriterion("is_compact between", value1, value2, "isCompact");
            return (Criteria) this;
        }

        public Criteria andIsCompactNotBetween(Integer value1, Integer value2) {
            addCriterion("is_compact not between", value1, value2, "isCompact");
            return (Criteria) this;
        }

        public Criteria andIsCompactCheckIsNull() {
            addCriterion("is_compact_check is null");
            return (Criteria) this;
        }

        public Criteria andIsCompactCheckIsNotNull() {
            addCriterion("is_compact_check is not null");
            return (Criteria) this;
        }

        public Criteria andIsCompactCheckEqualTo(Integer value) {
            addCriterion("is_compact_check =", value, "isCompactCheck");
            return (Criteria) this;
        }

        public Criteria andIsCompactCheckNotEqualTo(Integer value) {
            addCriterion("is_compact_check <>", value, "isCompactCheck");
            return (Criteria) this;
        }

        public Criteria andIsCompactCheckGreaterThan(Integer value) {
            addCriterion("is_compact_check >", value, "isCompactCheck");
            return (Criteria) this;
        }

        public Criteria andIsCompactCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_compact_check >=", value, "isCompactCheck");
            return (Criteria) this;
        }

        public Criteria andIsCompactCheckLessThan(Integer value) {
            addCriterion("is_compact_check <", value, "isCompactCheck");
            return (Criteria) this;
        }

        public Criteria andIsCompactCheckLessThanOrEqualTo(Integer value) {
            addCriterion("is_compact_check <=", value, "isCompactCheck");
            return (Criteria) this;
        }

        public Criteria andIsCompactCheckIn(List<Integer> values) {
            addCriterion("is_compact_check in", values, "isCompactCheck");
            return (Criteria) this;
        }

        public Criteria andIsCompactCheckNotIn(List<Integer> values) {
            addCriterion("is_compact_check not in", values, "isCompactCheck");
            return (Criteria) this;
        }

        public Criteria andIsCompactCheckBetween(Integer value1, Integer value2) {
            addCriterion("is_compact_check between", value1, value2, "isCompactCheck");
            return (Criteria) this;
        }

        public Criteria andIsCompactCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("is_compact_check not between", value1, value2, "isCompactCheck");
            return (Criteria) this;
        }

        public Criteria andIsMoneyIsNull() {
            addCriterion("is_money is null");
            return (Criteria) this;
        }

        public Criteria andIsMoneyIsNotNull() {
            addCriterion("is_money is not null");
            return (Criteria) this;
        }

        public Criteria andIsMoneyEqualTo(Integer value) {
            addCriterion("is_money =", value, "isMoney");
            return (Criteria) this;
        }

        public Criteria andIsMoneyNotEqualTo(Integer value) {
            addCriterion("is_money <>", value, "isMoney");
            return (Criteria) this;
        }

        public Criteria andIsMoneyGreaterThan(Integer value) {
            addCriterion("is_money >", value, "isMoney");
            return (Criteria) this;
        }

        public Criteria andIsMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_money >=", value, "isMoney");
            return (Criteria) this;
        }

        public Criteria andIsMoneyLessThan(Integer value) {
            addCriterion("is_money <", value, "isMoney");
            return (Criteria) this;
        }

        public Criteria andIsMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("is_money <=", value, "isMoney");
            return (Criteria) this;
        }

        public Criteria andIsMoneyIn(List<Integer> values) {
            addCriterion("is_money in", values, "isMoney");
            return (Criteria) this;
        }

        public Criteria andIsMoneyNotIn(List<Integer> values) {
            addCriterion("is_money not in", values, "isMoney");
            return (Criteria) this;
        }

        public Criteria andIsMoneyBetween(Integer value1, Integer value2) {
            addCriterion("is_money between", value1, value2, "isMoney");
            return (Criteria) this;
        }

        public Criteria andIsMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("is_money not between", value1, value2, "isMoney");
            return (Criteria) this;
        }

        public Criteria andIsInterestCustIsNull() {
            addCriterion("is_interest_cust is null");
            return (Criteria) this;
        }

        public Criteria andIsInterestCustIsNotNull() {
            addCriterion("is_interest_cust is not null");
            return (Criteria) this;
        }

        public Criteria andIsInterestCustEqualTo(Integer value) {
            addCriterion("is_interest_cust =", value, "isInterestCust");
            return (Criteria) this;
        }

        public Criteria andIsInterestCustNotEqualTo(Integer value) {
            addCriterion("is_interest_cust <>", value, "isInterestCust");
            return (Criteria) this;
        }

        public Criteria andIsInterestCustGreaterThan(Integer value) {
            addCriterion("is_interest_cust >", value, "isInterestCust");
            return (Criteria) this;
        }

        public Criteria andIsInterestCustGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_interest_cust >=", value, "isInterestCust");
            return (Criteria) this;
        }

        public Criteria andIsInterestCustLessThan(Integer value) {
            addCriterion("is_interest_cust <", value, "isInterestCust");
            return (Criteria) this;
        }

        public Criteria andIsInterestCustLessThanOrEqualTo(Integer value) {
            addCriterion("is_interest_cust <=", value, "isInterestCust");
            return (Criteria) this;
        }

        public Criteria andIsInterestCustIn(List<Integer> values) {
            addCriterion("is_interest_cust in", values, "isInterestCust");
            return (Criteria) this;
        }

        public Criteria andIsInterestCustNotIn(List<Integer> values) {
            addCriterion("is_interest_cust not in", values, "isInterestCust");
            return (Criteria) this;
        }

        public Criteria andIsInterestCustBetween(Integer value1, Integer value2) {
            addCriterion("is_interest_cust between", value1, value2, "isInterestCust");
            return (Criteria) this;
        }

        public Criteria andIsInterestCustNotBetween(Integer value1, Integer value2) {
            addCriterion("is_interest_cust not between", value1, value2, "isInterestCust");
            return (Criteria) this;
        }

        public Criteria andCompactImgIsNull() {
            addCriterion("compact_img is null");
            return (Criteria) this;
        }

        public Criteria andCompactImgIsNotNull() {
            addCriterion("compact_img is not null");
            return (Criteria) this;
        }

        public Criteria andCompactImgEqualTo(String value) {
            addCriterion("compact_img =", value, "compactImg");
            return (Criteria) this;
        }

        public Criteria andCompactImgNotEqualTo(String value) {
            addCriterion("compact_img <>", value, "compactImg");
            return (Criteria) this;
        }

        public Criteria andCompactImgGreaterThan(String value) {
            addCriterion("compact_img >", value, "compactImg");
            return (Criteria) this;
        }

        public Criteria andCompactImgGreaterThanOrEqualTo(String value) {
            addCriterion("compact_img >=", value, "compactImg");
            return (Criteria) this;
        }

        public Criteria andCompactImgLessThan(String value) {
            addCriterion("compact_img <", value, "compactImg");
            return (Criteria) this;
        }

        public Criteria andCompactImgLessThanOrEqualTo(String value) {
            addCriterion("compact_img <=", value, "compactImg");
            return (Criteria) this;
        }

        public Criteria andCompactImgLike(String value) {
            addCriterion("compact_img like", value, "compactImg");
            return (Criteria) this;
        }

        public Criteria andCompactImgNotLike(String value) {
            addCriterion("compact_img not like", value, "compactImg");
            return (Criteria) this;
        }

        public Criteria andCompactImgIn(List<String> values) {
            addCriterion("compact_img in", values, "compactImg");
            return (Criteria) this;
        }

        public Criteria andCompactImgNotIn(List<String> values) {
            addCriterion("compact_img not in", values, "compactImg");
            return (Criteria) this;
        }

        public Criteria andCompactImgBetween(String value1, String value2) {
            addCriterion("compact_img between", value1, value2, "compactImg");
            return (Criteria) this;
        }

        public Criteria andCompactImgNotBetween(String value1, String value2) {
            addCriterion("compact_img not between", value1, value2, "compactImg");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonIsNull() {
            addCriterion("abandon_reason is null");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonIsNotNull() {
            addCriterion("abandon_reason is not null");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonEqualTo(String value) {
            addCriterion("abandon_reason =", value, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonNotEqualTo(String value) {
            addCriterion("abandon_reason <>", value, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonGreaterThan(String value) {
            addCriterion("abandon_reason >", value, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonGreaterThanOrEqualTo(String value) {
            addCriterion("abandon_reason >=", value, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonLessThan(String value) {
            addCriterion("abandon_reason <", value, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonLessThanOrEqualTo(String value) {
            addCriterion("abandon_reason <=", value, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonLike(String value) {
            addCriterion("abandon_reason like", value, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonNotLike(String value) {
            addCriterion("abandon_reason not like", value, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonIn(List<String> values) {
            addCriterion("abandon_reason in", values, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonNotIn(List<String> values) {
            addCriterion("abandon_reason not in", values, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonBetween(String value1, String value2) {
            addCriterion("abandon_reason between", value1, value2, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andAbandonReasonNotBetween(String value1, String value2) {
            addCriterion("abandon_reason not between", value1, value2, "abandonReason");
            return (Criteria) this;
        }

        public Criteria andDeleteReasonIsNull() {
            addCriterion("delete_reason is null");
            return (Criteria) this;
        }

        public Criteria andDeleteReasonIsNotNull() {
            addCriterion("delete_reason is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteReasonEqualTo(String value) {
            addCriterion("delete_reason =", value, "deleteReason");
            return (Criteria) this;
        }

        public Criteria andDeleteReasonNotEqualTo(String value) {
            addCriterion("delete_reason <>", value, "deleteReason");
            return (Criteria) this;
        }

        public Criteria andDeleteReasonGreaterThan(String value) {
            addCriterion("delete_reason >", value, "deleteReason");
            return (Criteria) this;
        }

        public Criteria andDeleteReasonGreaterThanOrEqualTo(String value) {
            addCriterion("delete_reason >=", value, "deleteReason");
            return (Criteria) this;
        }

        public Criteria andDeleteReasonLessThan(String value) {
            addCriterion("delete_reason <", value, "deleteReason");
            return (Criteria) this;
        }

        public Criteria andDeleteReasonLessThanOrEqualTo(String value) {
            addCriterion("delete_reason <=", value, "deleteReason");
            return (Criteria) this;
        }

        public Criteria andDeleteReasonLike(String value) {
            addCriterion("delete_reason like", value, "deleteReason");
            return (Criteria) this;
        }

        public Criteria andDeleteReasonNotLike(String value) {
            addCriterion("delete_reason not like", value, "deleteReason");
            return (Criteria) this;
        }

        public Criteria andDeleteReasonIn(List<String> values) {
            addCriterion("delete_reason in", values, "deleteReason");
            return (Criteria) this;
        }

        public Criteria andDeleteReasonNotIn(List<String> values) {
            addCriterion("delete_reason not in", values, "deleteReason");
            return (Criteria) this;
        }

        public Criteria andDeleteReasonBetween(String value1, String value2) {
            addCriterion("delete_reason between", value1, value2, "deleteReason");
            return (Criteria) this;
        }

        public Criteria andDeleteReasonNotBetween(String value1, String value2) {
            addCriterion("delete_reason not between", value1, value2, "deleteReason");
            return (Criteria) this;
        }

        public Criteria andCheckRefuseReasonIsNull() {
            addCriterion("check_refuse_reason is null");
            return (Criteria) this;
        }

        public Criteria andCheckRefuseReasonIsNotNull() {
            addCriterion("check_refuse_reason is not null");
            return (Criteria) this;
        }

        public Criteria andCheckRefuseReasonEqualTo(String value) {
            addCriterion("check_refuse_reason =", value, "checkRefuseReason");
            return (Criteria) this;
        }

        public Criteria andCheckRefuseReasonNotEqualTo(String value) {
            addCriterion("check_refuse_reason <>", value, "checkRefuseReason");
            return (Criteria) this;
        }

        public Criteria andCheckRefuseReasonGreaterThan(String value) {
            addCriterion("check_refuse_reason >", value, "checkRefuseReason");
            return (Criteria) this;
        }

        public Criteria andCheckRefuseReasonGreaterThanOrEqualTo(String value) {
            addCriterion("check_refuse_reason >=", value, "checkRefuseReason");
            return (Criteria) this;
        }

        public Criteria andCheckRefuseReasonLessThan(String value) {
            addCriterion("check_refuse_reason <", value, "checkRefuseReason");
            return (Criteria) this;
        }

        public Criteria andCheckRefuseReasonLessThanOrEqualTo(String value) {
            addCriterion("check_refuse_reason <=", value, "checkRefuseReason");
            return (Criteria) this;
        }

        public Criteria andCheckRefuseReasonLike(String value) {
            addCriterion("check_refuse_reason like", value, "checkRefuseReason");
            return (Criteria) this;
        }

        public Criteria andCheckRefuseReasonNotLike(String value) {
            addCriterion("check_refuse_reason not like", value, "checkRefuseReason");
            return (Criteria) this;
        }

        public Criteria andCheckRefuseReasonIn(List<String> values) {
            addCriterion("check_refuse_reason in", values, "checkRefuseReason");
            return (Criteria) this;
        }

        public Criteria andCheckRefuseReasonNotIn(List<String> values) {
            addCriterion("check_refuse_reason not in", values, "checkRefuseReason");
            return (Criteria) this;
        }

        public Criteria andCheckRefuseReasonBetween(String value1, String value2) {
            addCriterion("check_refuse_reason between", value1, value2, "checkRefuseReason");
            return (Criteria) this;
        }

        public Criteria andCheckRefuseReasonNotBetween(String value1, String value2) {
            addCriterion("check_refuse_reason not between", value1, value2, "checkRefuseReason");
            return (Criteria) this;
        }

        public Criteria andDonateGoldBeansIsNull() {
            addCriterion("donate_gold_beans is null");
            return (Criteria) this;
        }

        public Criteria andDonateGoldBeansIsNotNull() {
            addCriterion("donate_gold_beans is not null");
            return (Criteria) this;
        }

        public Criteria andDonateGoldBeansEqualTo(Integer value) {
            addCriterion("donate_gold_beans =", value, "donateGoldBeans");
            return (Criteria) this;
        }

        public Criteria andDonateGoldBeansNotEqualTo(Integer value) {
            addCriterion("donate_gold_beans <>", value, "donateGoldBeans");
            return (Criteria) this;
        }

        public Criteria andDonateGoldBeansGreaterThan(Integer value) {
            addCriterion("donate_gold_beans >", value, "donateGoldBeans");
            return (Criteria) this;
        }

        public Criteria andDonateGoldBeansGreaterThanOrEqualTo(Integer value) {
            addCriterion("donate_gold_beans >=", value, "donateGoldBeans");
            return (Criteria) this;
        }

        public Criteria andDonateGoldBeansLessThan(Integer value) {
            addCriterion("donate_gold_beans <", value, "donateGoldBeans");
            return (Criteria) this;
        }

        public Criteria andDonateGoldBeansLessThanOrEqualTo(Integer value) {
            addCriterion("donate_gold_beans <=", value, "donateGoldBeans");
            return (Criteria) this;
        }

        public Criteria andDonateGoldBeansIn(List<Integer> values) {
            addCriterion("donate_gold_beans in", values, "donateGoldBeans");
            return (Criteria) this;
        }

        public Criteria andDonateGoldBeansNotIn(List<Integer> values) {
            addCriterion("donate_gold_beans not in", values, "donateGoldBeans");
            return (Criteria) this;
        }

        public Criteria andDonateGoldBeansBetween(Integer value1, Integer value2) {
            addCriterion("donate_gold_beans between", value1, value2, "donateGoldBeans");
            return (Criteria) this;
        }

        public Criteria andDonateGoldBeansNotBetween(Integer value1, Integer value2) {
            addCriterion("donate_gold_beans not between", value1, value2, "donateGoldBeans");
            return (Criteria) this;
        }

        public Criteria andRelativeIdIsNull() {
            addCriterion("relative_id is null");
            return (Criteria) this;
        }

        public Criteria andRelativeIdIsNotNull() {
            addCriterion("relative_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelativeIdEqualTo(Integer value) {
            addCriterion("relative_id =", value, "relativeId");
            return (Criteria) this;
        }

        public Criteria andRelativeIdNotEqualTo(Integer value) {
            addCriterion("relative_id <>", value, "relativeId");
            return (Criteria) this;
        }

        public Criteria andRelativeIdGreaterThan(Integer value) {
            addCriterion("relative_id >", value, "relativeId");
            return (Criteria) this;
        }

        public Criteria andRelativeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("relative_id >=", value, "relativeId");
            return (Criteria) this;
        }

        public Criteria andRelativeIdLessThan(Integer value) {
            addCriterion("relative_id <", value, "relativeId");
            return (Criteria) this;
        }

        public Criteria andRelativeIdLessThanOrEqualTo(Integer value) {
            addCriterion("relative_id <=", value, "relativeId");
            return (Criteria) this;
        }

        public Criteria andRelativeIdIn(List<Integer> values) {
            addCriterion("relative_id in", values, "relativeId");
            return (Criteria) this;
        }

        public Criteria andRelativeIdNotIn(List<Integer> values) {
            addCriterion("relative_id not in", values, "relativeId");
            return (Criteria) this;
        }

        public Criteria andRelativeIdBetween(Integer value1, Integer value2) {
            addCriterion("relative_id between", value1, value2, "relativeId");
            return (Criteria) this;
        }

        public Criteria andRelativeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("relative_id not between", value1, value2, "relativeId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}