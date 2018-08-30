package com.niule.marketing.control.dal.model;

import java.util.ArrayList;
import java.util.List;

public class KnowRepoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KnowRepoExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andRepoIdIsNull() {
            addCriterion("repo_id is null");
            return (Criteria) this;
        }

        public Criteria andRepoIdIsNotNull() {
            addCriterion("repo_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepoIdEqualTo(String value) {
            addCriterion("repo_id =", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdNotEqualTo(String value) {
            addCriterion("repo_id <>", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdGreaterThan(String value) {
            addCriterion("repo_id >", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdGreaterThanOrEqualTo(String value) {
            addCriterion("repo_id >=", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdLessThan(String value) {
            addCriterion("repo_id <", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdLessThanOrEqualTo(String value) {
            addCriterion("repo_id <=", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdLike(String value) {
            addCriterion("repo_id like", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdNotLike(String value) {
            addCriterion("repo_id not like", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdIn(List<String> values) {
            addCriterion("repo_id in", values, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdNotIn(List<String> values) {
            addCriterion("repo_id not in", values, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdBetween(String value1, String value2) {
            addCriterion("repo_id between", value1, value2, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdNotBetween(String value1, String value2) {
            addCriterion("repo_id not between", value1, value2, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoNameIsNull() {
            addCriterion("repo_name is null");
            return (Criteria) this;
        }

        public Criteria andRepoNameIsNotNull() {
            addCriterion("repo_name is not null");
            return (Criteria) this;
        }

        public Criteria andRepoNameEqualTo(String value) {
            addCriterion("repo_name =", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameNotEqualTo(String value) {
            addCriterion("repo_name <>", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameGreaterThan(String value) {
            addCriterion("repo_name >", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameGreaterThanOrEqualTo(String value) {
            addCriterion("repo_name >=", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameLessThan(String value) {
            addCriterion("repo_name <", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameLessThanOrEqualTo(String value) {
            addCriterion("repo_name <=", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameLike(String value) {
            addCriterion("repo_name like", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameNotLike(String value) {
            addCriterion("repo_name not like", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameIn(List<String> values) {
            addCriterion("repo_name in", values, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameNotIn(List<String> values) {
            addCriterion("repo_name not in", values, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameBetween(String value1, String value2) {
            addCriterion("repo_name between", value1, value2, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameNotBetween(String value1, String value2) {
            addCriterion("repo_name not between", value1, value2, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoContentIsNull() {
            addCriterion("repo_content is null");
            return (Criteria) this;
        }

        public Criteria andRepoContentIsNotNull() {
            addCriterion("repo_content is not null");
            return (Criteria) this;
        }

        public Criteria andRepoContentEqualTo(String value) {
            addCriterion("repo_content =", value, "repoContent");
            return (Criteria) this;
        }

        public Criteria andRepoContentNotEqualTo(String value) {
            addCriterion("repo_content <>", value, "repoContent");
            return (Criteria) this;
        }

        public Criteria andRepoContentGreaterThan(String value) {
            addCriterion("repo_content >", value, "repoContent");
            return (Criteria) this;
        }

        public Criteria andRepoContentGreaterThanOrEqualTo(String value) {
            addCriterion("repo_content >=", value, "repoContent");
            return (Criteria) this;
        }

        public Criteria andRepoContentLessThan(String value) {
            addCriterion("repo_content <", value, "repoContent");
            return (Criteria) this;
        }

        public Criteria andRepoContentLessThanOrEqualTo(String value) {
            addCriterion("repo_content <=", value, "repoContent");
            return (Criteria) this;
        }

        public Criteria andRepoContentLike(String value) {
            addCriterion("repo_content like", value, "repoContent");
            return (Criteria) this;
        }

        public Criteria andRepoContentNotLike(String value) {
            addCriterion("repo_content not like", value, "repoContent");
            return (Criteria) this;
        }

        public Criteria andRepoContentIn(List<String> values) {
            addCriterion("repo_content in", values, "repoContent");
            return (Criteria) this;
        }

        public Criteria andRepoContentNotIn(List<String> values) {
            addCriterion("repo_content not in", values, "repoContent");
            return (Criteria) this;
        }

        public Criteria andRepoContentBetween(String value1, String value2) {
            addCriterion("repo_content between", value1, value2, "repoContent");
            return (Criteria) this;
        }

        public Criteria andRepoContentNotBetween(String value1, String value2) {
            addCriterion("repo_content not between", value1, value2, "repoContent");
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