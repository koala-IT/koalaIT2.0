package com.koalaIT.common.model;

import java.util.ArrayList;
import java.util.List;

public class HuntercollectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HuntercollectExample() {
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

        public Criteria andCollectIdIsNull() {
            addCriterion("collect_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectIdIsNotNull() {
            addCriterion("collect_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectIdEqualTo(Integer value) {
            addCriterion("collect_id =", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdNotEqualTo(Integer value) {
            addCriterion("collect_id <>", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdGreaterThan(Integer value) {
            addCriterion("collect_id >", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_id >=", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdLessThan(Integer value) {
            addCriterion("collect_id <", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdLessThanOrEqualTo(Integer value) {
            addCriterion("collect_id <=", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdIn(List<Integer> values) {
            addCriterion("collect_id in", values, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdNotIn(List<Integer> values) {
            addCriterion("collect_id not in", values, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdBetween(Integer value1, Integer value2) {
            addCriterion("collect_id between", value1, value2, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_id not between", value1, value2, "collectId");
            return (Criteria) this;
        }

        public Criteria andHunterIdIsNull() {
            addCriterion("hunter_id is null");
            return (Criteria) this;
        }

        public Criteria andHunterIdIsNotNull() {
            addCriterion("hunter_id is not null");
            return (Criteria) this;
        }

        public Criteria andHunterIdEqualTo(Integer value) {
            addCriterion("hunter_id =", value, "hunterId");
            return (Criteria) this;
        }

        public Criteria andHunterIdNotEqualTo(Integer value) {
            addCriterion("hunter_id <>", value, "hunterId");
            return (Criteria) this;
        }

        public Criteria andHunterIdGreaterThan(Integer value) {
            addCriterion("hunter_id >", value, "hunterId");
            return (Criteria) this;
        }

        public Criteria andHunterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hunter_id >=", value, "hunterId");
            return (Criteria) this;
        }

        public Criteria andHunterIdLessThan(Integer value) {
            addCriterion("hunter_id <", value, "hunterId");
            return (Criteria) this;
        }

        public Criteria andHunterIdLessThanOrEqualTo(Integer value) {
            addCriterion("hunter_id <=", value, "hunterId");
            return (Criteria) this;
        }

        public Criteria andHunterIdIn(List<Integer> values) {
            addCriterion("hunter_id in", values, "hunterId");
            return (Criteria) this;
        }

        public Criteria andHunterIdNotIn(List<Integer> values) {
            addCriterion("hunter_id not in", values, "hunterId");
            return (Criteria) this;
        }

        public Criteria andHunterIdBetween(Integer value1, Integer value2) {
            addCriterion("hunter_id between", value1, value2, "hunterId");
            return (Criteria) this;
        }

        public Criteria andHunterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hunter_id not between", value1, value2, "hunterId");
            return (Criteria) this;
        }

        public Criteria andBossIdIsNull() {
            addCriterion("boss_id is null");
            return (Criteria) this;
        }

        public Criteria andBossIdIsNotNull() {
            addCriterion("boss_id is not null");
            return (Criteria) this;
        }

        public Criteria andBossIdEqualTo(Integer value) {
            addCriterion("boss_id =", value, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdNotEqualTo(Integer value) {
            addCriterion("boss_id <>", value, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdGreaterThan(Integer value) {
            addCriterion("boss_id >", value, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("boss_id >=", value, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdLessThan(Integer value) {
            addCriterion("boss_id <", value, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdLessThanOrEqualTo(Integer value) {
            addCriterion("boss_id <=", value, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdIn(List<Integer> values) {
            addCriterion("boss_id in", values, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdNotIn(List<Integer> values) {
            addCriterion("boss_id not in", values, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdBetween(Integer value1, Integer value2) {
            addCriterion("boss_id between", value1, value2, "bossId");
            return (Criteria) this;
        }

        public Criteria andBossIdNotBetween(Integer value1, Integer value2) {
            addCriterion("boss_id not between", value1, value2, "bossId");
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

        public Criteria andCollectStateEqualTo(Integer value) {
            addCriterion("collect_state =", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateNotEqualTo(Integer value) {
            addCriterion("collect_state <>", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateGreaterThan(Integer value) {
            addCriterion("collect_state >", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_state >=", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateLessThan(Integer value) {
            addCriterion("collect_state <", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateLessThanOrEqualTo(Integer value) {
            addCriterion("collect_state <=", value, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateIn(List<Integer> values) {
            addCriterion("collect_state in", values, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateNotIn(List<Integer> values) {
            addCriterion("collect_state not in", values, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateBetween(Integer value1, Integer value2) {
            addCriterion("collect_state between", value1, value2, "collectState");
            return (Criteria) this;
        }

        public Criteria andCollectStateNotBetween(Integer value1, Integer value2) {
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