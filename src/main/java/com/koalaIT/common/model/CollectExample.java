package com.koalaIT.common.model;

import java.util.ArrayList;
import java.util.List;

public class CollectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollectExample() {
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

        public Criteria andCollectCheckIsNull() {
            addCriterion("collect_check is null");
            return (Criteria) this;
        }

        public Criteria andCollectCheckIsNotNull() {
            addCriterion("collect_check is not null");
            return (Criteria) this;
        }

        public Criteria andCollectCheckEqualTo(Integer value) {
            addCriterion("collect_check =", value, "collectCheck");
            return (Criteria) this;
        }

        public Criteria andCollectCheckNotEqualTo(Integer value) {
            addCriterion("collect_check <>", value, "collectCheck");
            return (Criteria) this;
        }

        public Criteria andCollectCheckGreaterThan(Integer value) {
            addCriterion("collect_check >", value, "collectCheck");
            return (Criteria) this;
        }

        public Criteria andCollectCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_check >=", value, "collectCheck");
            return (Criteria) this;
        }

        public Criteria andCollectCheckLessThan(Integer value) {
            addCriterion("collect_check <", value, "collectCheck");
            return (Criteria) this;
        }

        public Criteria andCollectCheckLessThanOrEqualTo(Integer value) {
            addCriterion("collect_check <=", value, "collectCheck");
            return (Criteria) this;
        }

        public Criteria andCollectCheckIn(List<Integer> values) {
            addCriterion("collect_check in", values, "collectCheck");
            return (Criteria) this;
        }

        public Criteria andCollectCheckNotIn(List<Integer> values) {
            addCriterion("collect_check not in", values, "collectCheck");
            return (Criteria) this;
        }

        public Criteria andCollectCheckBetween(Integer value1, Integer value2) {
            addCriterion("collect_check between", value1, value2, "collectCheck");
            return (Criteria) this;
        }

        public Criteria andCollectCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_check not between", value1, value2, "collectCheck");
            return (Criteria) this;
        }

        public Criteria andCollectStateIsNull() {
            addCriterion("collect_state is null");
            return (Criteria) this;
        }

        public Criteria andCollectStateIsNotNull() {
            addCriterion("collect_state is not null");
            return (Criteria) this;
        }

        public Criteria andCollectStateEqualTo(String value) {
            addCriterion("collect_state =", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateNotEqualTo(String value) {
            addCriterion("collect_state <>", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateGreaterThan(String value) {
            addCriterion("collect_state >", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateGreaterThanOrEqualTo(String value) {
            addCriterion("collect_state >=", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateLessThan(String value) {
            addCriterion("collect_state <", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateLessThanOrEqualTo(String value) {
            addCriterion("collect_state <=", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateLike(String value) {
            addCriterion("collect_state like", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateNotLike(String value) {
            addCriterion("collect_state not like", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateIn(List<String> values) {
            addCriterion("collect_state in", values, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateNotIn(List<String> values) {
            addCriterion("collect_state not in", values, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateBetween(String value1, String value2) {
            addCriterion("collect_state between", value1, value2, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateNotBetween(String value1, String value2) {
            addCriterion("collect_state not between", value1, value2, "collectState");
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