package com.niule.marketing.controller.controller.dal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BackgroundUserAuthInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BackgroundUserAuthInfoExample() {
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

        public Criteria andPageInterfaceIsNull() {
            addCriterion("page_interface is null");
            return (Criteria) this;
        }

        public Criteria andPageInterfaceIsNotNull() {
            addCriterion("page_interface is not null");
            return (Criteria) this;
        }

        public Criteria andPageInterfaceEqualTo(String value) {
            addCriterion("page_interface =", value, "pageInterface");
            return (Criteria) this;
        }

        public Criteria andPageInterfaceNotEqualTo(String value) {
            addCriterion("page_interface <>", value, "pageInterface");
            return (Criteria) this;
        }

        public Criteria andPageInterfaceGreaterThan(String value) {
            addCriterion("page_interface >", value, "pageInterface");
            return (Criteria) this;
        }

        public Criteria andPageInterfaceGreaterThanOrEqualTo(String value) {
            addCriterion("page_interface >=", value, "pageInterface");
            return (Criteria) this;
        }

        public Criteria andPageInterfaceLessThan(String value) {
            addCriterion("page_interface <", value, "pageInterface");
            return (Criteria) this;
        }

        public Criteria andPageInterfaceLessThanOrEqualTo(String value) {
            addCriterion("page_interface <=", value, "pageInterface");
            return (Criteria) this;
        }

        public Criteria andPageInterfaceLike(String value) {
            addCriterion("page_interface like", value, "pageInterface");
            return (Criteria) this;
        }

        public Criteria andPageInterfaceNotLike(String value) {
            addCriterion("page_interface not like", value, "pageInterface");
            return (Criteria) this;
        }

        public Criteria andPageInterfaceIn(List<String> values) {
            addCriterion("page_interface in", values, "pageInterface");
            return (Criteria) this;
        }

        public Criteria andPageInterfaceNotIn(List<String> values) {
            addCriterion("page_interface not in", values, "pageInterface");
            return (Criteria) this;
        }

        public Criteria andPageInterfaceBetween(String value1, String value2) {
            addCriterion("page_interface between", value1, value2, "pageInterface");
            return (Criteria) this;
        }

        public Criteria andPageInterfaceNotBetween(String value1, String value2) {
            addCriterion("page_interface not between", value1, value2, "pageInterface");
            return (Criteria) this;
        }

        public Criteria andBackRoleIdsIsNull() {
            addCriterion("back_role_ids is null");
            return (Criteria) this;
        }

        public Criteria andBackRoleIdsIsNotNull() {
            addCriterion("back_role_ids is not null");
            return (Criteria) this;
        }

        public Criteria andBackRoleIdsEqualTo(String value) {
            addCriterion("back_role_ids =", value, "backRoleIds");
            return (Criteria) this;
        }

        public Criteria andBackRoleIdsNotEqualTo(String value) {
            addCriterion("back_role_ids <>", value, "backRoleIds");
            return (Criteria) this;
        }

        public Criteria andBackRoleIdsGreaterThan(String value) {
            addCriterion("back_role_ids >", value, "backRoleIds");
            return (Criteria) this;
        }

        public Criteria andBackRoleIdsGreaterThanOrEqualTo(String value) {
            addCriterion("back_role_ids >=", value, "backRoleIds");
            return (Criteria) this;
        }

        public Criteria andBackRoleIdsLessThan(String value) {
            addCriterion("back_role_ids <", value, "backRoleIds");
            return (Criteria) this;
        }

        public Criteria andBackRoleIdsLessThanOrEqualTo(String value) {
            addCriterion("back_role_ids <=", value, "backRoleIds");
            return (Criteria) this;
        }

        public Criteria andBackRoleIdsLike(String value) {
            addCriterion("back_role_ids like", value, "backRoleIds");
            return (Criteria) this;
        }

        public Criteria andBackRoleIdsNotLike(String value) {
            addCriterion("back_role_ids not like", value, "backRoleIds");
            return (Criteria) this;
        }

        public Criteria andBackRoleIdsIn(List<String> values) {
            addCriterion("back_role_ids in", values, "backRoleIds");
            return (Criteria) this;
        }

        public Criteria andBackRoleIdsNotIn(List<String> values) {
            addCriterion("back_role_ids not in", values, "backRoleIds");
            return (Criteria) this;
        }

        public Criteria andBackRoleIdsBetween(String value1, String value2) {
            addCriterion("back_role_ids between", value1, value2, "backRoleIds");
            return (Criteria) this;
        }

        public Criteria andBackRoleIdsNotBetween(String value1, String value2) {
            addCriterion("back_role_ids not between", value1, value2, "backRoleIds");
            return (Criteria) this;
        }

        public Criteria andPageDescIsNull() {
            addCriterion("page_desc is null");
            return (Criteria) this;
        }

        public Criteria andPageDescIsNotNull() {
            addCriterion("page_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPageDescEqualTo(String value) {
            addCriterion("page_desc =", value, "pageDesc");
            return (Criteria) this;
        }

        public Criteria andPageDescNotEqualTo(String value) {
            addCriterion("page_desc <>", value, "pageDesc");
            return (Criteria) this;
        }

        public Criteria andPageDescGreaterThan(String value) {
            addCriterion("page_desc >", value, "pageDesc");
            return (Criteria) this;
        }

        public Criteria andPageDescGreaterThanOrEqualTo(String value) {
            addCriterion("page_desc >=", value, "pageDesc");
            return (Criteria) this;
        }

        public Criteria andPageDescLessThan(String value) {
            addCriterion("page_desc <", value, "pageDesc");
            return (Criteria) this;
        }

        public Criteria andPageDescLessThanOrEqualTo(String value) {
            addCriterion("page_desc <=", value, "pageDesc");
            return (Criteria) this;
        }

        public Criteria andPageDescLike(String value) {
            addCriterion("page_desc like", value, "pageDesc");
            return (Criteria) this;
        }

        public Criteria andPageDescNotLike(String value) {
            addCriterion("page_desc not like", value, "pageDesc");
            return (Criteria) this;
        }

        public Criteria andPageDescIn(List<String> values) {
            addCriterion("page_desc in", values, "pageDesc");
            return (Criteria) this;
        }

        public Criteria andPageDescNotIn(List<String> values) {
            addCriterion("page_desc not in", values, "pageDesc");
            return (Criteria) this;
        }

        public Criteria andPageDescBetween(String value1, String value2) {
            addCriterion("page_desc between", value1, value2, "pageDesc");
            return (Criteria) this;
        }

        public Criteria andPageDescNotBetween(String value1, String value2) {
            addCriterion("page_desc not between", value1, value2, "pageDesc");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNull() {
            addCriterion("create_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNotNull() {
            addCriterion("create_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("create_name =", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("create_name <>", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("create_name >", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_name >=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThan(String value) {
            addCriterion("create_name <", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("create_name <=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLike(String value) {
            addCriterion("create_name like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotLike(String value) {
            addCriterion("create_name not like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("create_name in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("create_name not in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("create_name between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("create_name not between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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