package com.niule.marketing.controller.controller.dal.model;

import java.util.ArrayList;
import java.util.List;

public class IncentInstExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IncentInstExample() {
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

        public Criteria andInstIdIsNull() {
            addCriterion("inst_id is null");
            return (Criteria) this;
        }

        public Criteria andInstIdIsNotNull() {
            addCriterion("inst_id is not null");
            return (Criteria) this;
        }

        public Criteria andInstIdEqualTo(String value) {
            addCriterion("inst_id =", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdNotEqualTo(String value) {
            addCriterion("inst_id <>", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdGreaterThan(String value) {
            addCriterion("inst_id >", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdGreaterThanOrEqualTo(String value) {
            addCriterion("inst_id >=", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdLessThan(String value) {
            addCriterion("inst_id <", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdLessThanOrEqualTo(String value) {
            addCriterion("inst_id <=", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdLike(String value) {
            addCriterion("inst_id like", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdNotLike(String value) {
            addCriterion("inst_id not like", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdIn(List<String> values) {
            addCriterion("inst_id in", values, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdNotIn(List<String> values) {
            addCriterion("inst_id not in", values, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdBetween(String value1, String value2) {
            addCriterion("inst_id between", value1, value2, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdNotBetween(String value1, String value2) {
            addCriterion("inst_id not between", value1, value2, "instId");
            return (Criteria) this;
        }

        public Criteria andInstNameIsNull() {
            addCriterion("inst_name is null");
            return (Criteria) this;
        }

        public Criteria andInstNameIsNotNull() {
            addCriterion("inst_name is not null");
            return (Criteria) this;
        }

        public Criteria andInstNameEqualTo(String value) {
            addCriterion("inst_name =", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameNotEqualTo(String value) {
            addCriterion("inst_name <>", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameGreaterThan(String value) {
            addCriterion("inst_name >", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameGreaterThanOrEqualTo(String value) {
            addCriterion("inst_name >=", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameLessThan(String value) {
            addCriterion("inst_name <", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameLessThanOrEqualTo(String value) {
            addCriterion("inst_name <=", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameLike(String value) {
            addCriterion("inst_name like", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameNotLike(String value) {
            addCriterion("inst_name not like", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameIn(List<String> values) {
            addCriterion("inst_name in", values, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameNotIn(List<String> values) {
            addCriterion("inst_name not in", values, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameBetween(String value1, String value2) {
            addCriterion("inst_name between", value1, value2, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameNotBetween(String value1, String value2) {
            addCriterion("inst_name not between", value1, value2, "instName");
            return (Criteria) this;
        }

        public Criteria andInstContentIsNull() {
            addCriterion("inst_content is null");
            return (Criteria) this;
        }

        public Criteria andInstContentIsNotNull() {
            addCriterion("inst_content is not null");
            return (Criteria) this;
        }

        public Criteria andInstContentEqualTo(String value) {
            addCriterion("inst_content =", value, "instContent");
            return (Criteria) this;
        }

        public Criteria andInstContentNotEqualTo(String value) {
            addCriterion("inst_content <>", value, "instContent");
            return (Criteria) this;
        }

        public Criteria andInstContentGreaterThan(String value) {
            addCriterion("inst_content >", value, "instContent");
            return (Criteria) this;
        }

        public Criteria andInstContentGreaterThanOrEqualTo(String value) {
            addCriterion("inst_content >=", value, "instContent");
            return (Criteria) this;
        }

        public Criteria andInstContentLessThan(String value) {
            addCriterion("inst_content <", value, "instContent");
            return (Criteria) this;
        }

        public Criteria andInstContentLessThanOrEqualTo(String value) {
            addCriterion("inst_content <=", value, "instContent");
            return (Criteria) this;
        }

        public Criteria andInstContentLike(String value) {
            addCriterion("inst_content like", value, "instContent");
            return (Criteria) this;
        }

        public Criteria andInstContentNotLike(String value) {
            addCriterion("inst_content not like", value, "instContent");
            return (Criteria) this;
        }

        public Criteria andInstContentIn(List<String> values) {
            addCriterion("inst_content in", values, "instContent");
            return (Criteria) this;
        }

        public Criteria andInstContentNotIn(List<String> values) {
            addCriterion("inst_content not in", values, "instContent");
            return (Criteria) this;
        }

        public Criteria andInstContentBetween(String value1, String value2) {
            addCriterion("inst_content between", value1, value2, "instContent");
            return (Criteria) this;
        }

        public Criteria andInstContentNotBetween(String value1, String value2) {
            addCriterion("inst_content not between", value1, value2, "instContent");
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