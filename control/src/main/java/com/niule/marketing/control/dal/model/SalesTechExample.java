package com.niule.marketing.control.dal.model;

import java.util.ArrayList;
import java.util.List;

public class SalesTechExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalesTechExample() {
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

        public Criteria andTechIdIsNull() {
            addCriterion("tech_id is null");
            return (Criteria) this;
        }

        public Criteria andTechIdIsNotNull() {
            addCriterion("tech_id is not null");
            return (Criteria) this;
        }

        public Criteria andTechIdEqualTo(String value) {
            addCriterion("tech_id =", value, "techId");
            return (Criteria) this;
        }

        public Criteria andTechIdNotEqualTo(String value) {
            addCriterion("tech_id <>", value, "techId");
            return (Criteria) this;
        }

        public Criteria andTechIdGreaterThan(String value) {
            addCriterion("tech_id >", value, "techId");
            return (Criteria) this;
        }

        public Criteria andTechIdGreaterThanOrEqualTo(String value) {
            addCriterion("tech_id >=", value, "techId");
            return (Criteria) this;
        }

        public Criteria andTechIdLessThan(String value) {
            addCriterion("tech_id <", value, "techId");
            return (Criteria) this;
        }

        public Criteria andTechIdLessThanOrEqualTo(String value) {
            addCriterion("tech_id <=", value, "techId");
            return (Criteria) this;
        }

        public Criteria andTechIdLike(String value) {
            addCriterion("tech_id like", value, "techId");
            return (Criteria) this;
        }

        public Criteria andTechIdNotLike(String value) {
            addCriterion("tech_id not like", value, "techId");
            return (Criteria) this;
        }

        public Criteria andTechIdIn(List<String> values) {
            addCriterion("tech_id in", values, "techId");
            return (Criteria) this;
        }

        public Criteria andTechIdNotIn(List<String> values) {
            addCriterion("tech_id not in", values, "techId");
            return (Criteria) this;
        }

        public Criteria andTechIdBetween(String value1, String value2) {
            addCriterion("tech_id between", value1, value2, "techId");
            return (Criteria) this;
        }

        public Criteria andTechIdNotBetween(String value1, String value2) {
            addCriterion("tech_id not between", value1, value2, "techId");
            return (Criteria) this;
        }

        public Criteria andTechNameIsNull() {
            addCriterion("tech_name is null");
            return (Criteria) this;
        }

        public Criteria andTechNameIsNotNull() {
            addCriterion("tech_name is not null");
            return (Criteria) this;
        }

        public Criteria andTechNameEqualTo(String value) {
            addCriterion("tech_name =", value, "techName");
            return (Criteria) this;
        }

        public Criteria andTechNameNotEqualTo(String value) {
            addCriterion("tech_name <>", value, "techName");
            return (Criteria) this;
        }

        public Criteria andTechNameGreaterThan(String value) {
            addCriterion("tech_name >", value, "techName");
            return (Criteria) this;
        }

        public Criteria andTechNameGreaterThanOrEqualTo(String value) {
            addCriterion("tech_name >=", value, "techName");
            return (Criteria) this;
        }

        public Criteria andTechNameLessThan(String value) {
            addCriterion("tech_name <", value, "techName");
            return (Criteria) this;
        }

        public Criteria andTechNameLessThanOrEqualTo(String value) {
            addCriterion("tech_name <=", value, "techName");
            return (Criteria) this;
        }

        public Criteria andTechNameLike(String value) {
            addCriterion("tech_name like", value, "techName");
            return (Criteria) this;
        }

        public Criteria andTechNameNotLike(String value) {
            addCriterion("tech_name not like", value, "techName");
            return (Criteria) this;
        }

        public Criteria andTechNameIn(List<String> values) {
            addCriterion("tech_name in", values, "techName");
            return (Criteria) this;
        }

        public Criteria andTechNameNotIn(List<String> values) {
            addCriterion("tech_name not in", values, "techName");
            return (Criteria) this;
        }

        public Criteria andTechNameBetween(String value1, String value2) {
            addCriterion("tech_name between", value1, value2, "techName");
            return (Criteria) this;
        }

        public Criteria andTechNameNotBetween(String value1, String value2) {
            addCriterion("tech_name not between", value1, value2, "techName");
            return (Criteria) this;
        }

        public Criteria andTechContentIsNull() {
            addCriterion("tech_content is null");
            return (Criteria) this;
        }

        public Criteria andTechContentIsNotNull() {
            addCriterion("tech_content is not null");
            return (Criteria) this;
        }

        public Criteria andTechContentEqualTo(String value) {
            addCriterion("tech_content =", value, "techContent");
            return (Criteria) this;
        }

        public Criteria andTechContentNotEqualTo(String value) {
            addCriterion("tech_content <>", value, "techContent");
            return (Criteria) this;
        }

        public Criteria andTechContentGreaterThan(String value) {
            addCriterion("tech_content >", value, "techContent");
            return (Criteria) this;
        }

        public Criteria andTechContentGreaterThanOrEqualTo(String value) {
            addCriterion("tech_content >=", value, "techContent");
            return (Criteria) this;
        }

        public Criteria andTechContentLessThan(String value) {
            addCriterion("tech_content <", value, "techContent");
            return (Criteria) this;
        }

        public Criteria andTechContentLessThanOrEqualTo(String value) {
            addCriterion("tech_content <=", value, "techContent");
            return (Criteria) this;
        }

        public Criteria andTechContentLike(String value) {
            addCriterion("tech_content like", value, "techContent");
            return (Criteria) this;
        }

        public Criteria andTechContentNotLike(String value) {
            addCriterion("tech_content not like", value, "techContent");
            return (Criteria) this;
        }

        public Criteria andTechContentIn(List<String> values) {
            addCriterion("tech_content in", values, "techContent");
            return (Criteria) this;
        }

        public Criteria andTechContentNotIn(List<String> values) {
            addCriterion("tech_content not in", values, "techContent");
            return (Criteria) this;
        }

        public Criteria andTechContentBetween(String value1, String value2) {
            addCriterion("tech_content between", value1, value2, "techContent");
            return (Criteria) this;
        }

        public Criteria andTechContentNotBetween(String value1, String value2) {
            addCriterion("tech_content not between", value1, value2, "techContent");
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