package com.koalaIT.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BossExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BossExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andBossDetailIsNull() {
            addCriterion("boss_detail is null");
            return (Criteria) this;
        }

        public Criteria andBossDetailIsNotNull() {
            addCriterion("boss_detail is not null");
            return (Criteria) this;
        }

        public Criteria andBossDetailEqualTo(String value) {
            addCriterion("boss_detail =", value, "bossDetail");
            return (Criteria) this;
        }

        public Criteria andBossDetailNotEqualTo(String value) {
            addCriterion("boss_detail <>", value, "bossDetail");
            return (Criteria) this;
        }

        public Criteria andBossDetailGreaterThan(String value) {
            addCriterion("boss_detail >", value, "bossDetail");
            return (Criteria) this;
        }

        public Criteria andBossDetailGreaterThanOrEqualTo(String value) {
            addCriterion("boss_detail >=", value, "bossDetail");
            return (Criteria) this;
        }

        public Criteria andBossDetailLessThan(String value) {
            addCriterion("boss_detail <", value, "bossDetail");
            return (Criteria) this;
        }

        public Criteria andBossDetailLessThanOrEqualTo(String value) {
            addCriterion("boss_detail <=", value, "bossDetail");
            return (Criteria) this;
        }

        public Criteria andBossDetailLike(String value) {
            addCriterion("boss_detail like", value, "bossDetail");
            return (Criteria) this;
        }

        public Criteria andBossDetailNotLike(String value) {
            addCriterion("boss_detail not like", value, "bossDetail");
            return (Criteria) this;
        }

        public Criteria andBossDetailIn(List<String> values) {
            addCriterion("boss_detail in", values, "bossDetail");
            return (Criteria) this;
        }

        public Criteria andBossDetailNotIn(List<String> values) {
            addCriterion("boss_detail not in", values, "bossDetail");
            return (Criteria) this;
        }

        public Criteria andBossDetailBetween(String value1, String value2) {
            addCriterion("boss_detail between", value1, value2, "bossDetail");
            return (Criteria) this;
        }

        public Criteria andBossDetailNotBetween(String value1, String value2) {
            addCriterion("boss_detail not between", value1, value2, "bossDetail");
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

        public Criteria andLimitedTimeIsNull() {
            addCriterion("limited_time is null");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeIsNotNull() {
            addCriterion("limited_time is not null");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeEqualTo(String value) {
            addCriterion("limited_time =", value, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeNotEqualTo(String value) {
            addCriterion("limited_time <>", value, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeGreaterThan(String value) {
            addCriterion("limited_time >", value, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeGreaterThanOrEqualTo(String value) {
            addCriterion("limited_time >=", value, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeLessThan(String value) {
            addCriterion("limited_time <", value, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeLessThanOrEqualTo(String value) {
            addCriterion("limited_time <=", value, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeLike(String value) {
            addCriterion("limited_time like", value, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeNotLike(String value) {
            addCriterion("limited_time not like", value, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeIn(List<String> values) {
            addCriterion("limited_time in", values, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeNotIn(List<String> values) {
            addCriterion("limited_time not in", values, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeBetween(String value1, String value2) {
            addCriterion("limited_time between", value1, value2, "limitedTime");
            return (Criteria) this;
        }

        public Criteria andLimitedTimeNotBetween(String value1, String value2) {
            addCriterion("limited_time not between", value1, value2, "limitedTime");
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

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andDailyWageIsNull() {
            addCriterion("daily_wage is null");
            return (Criteria) this;
        }

        public Criteria andDailyWageIsNotNull() {
            addCriterion("daily_wage is not null");
            return (Criteria) this;
        }

        public Criteria andDailyWageEqualTo(String value) {
            addCriterion("daily_wage =", value, "dailyWage");
            return (Criteria) this;
        }

        public Criteria andDailyWageNotEqualTo(String value) {
            addCriterion("daily_wage <>", value, "dailyWage");
            return (Criteria) this;
        }

        public Criteria andDailyWageGreaterThan(String value) {
            addCriterion("daily_wage >", value, "dailyWage");
            return (Criteria) this;
        }

        public Criteria andDailyWageGreaterThanOrEqualTo(String value) {
            addCriterion("daily_wage >=", value, "dailyWage");
            return (Criteria) this;
        }

        public Criteria andDailyWageLessThan(String value) {
            addCriterion("daily_wage <", value, "dailyWage");
            return (Criteria) this;
        }

        public Criteria andDailyWageLessThanOrEqualTo(String value) {
            addCriterion("daily_wage <=", value, "dailyWage");
            return (Criteria) this;
        }

        public Criteria andDailyWageLike(String value) {
            addCriterion("daily_wage like", value, "dailyWage");
            return (Criteria) this;
        }

        public Criteria andDailyWageNotLike(String value) {
            addCriterion("daily_wage not like", value, "dailyWage");
            return (Criteria) this;
        }

        public Criteria andDailyWageIn(List<String> values) {
            addCriterion("daily_wage in", values, "dailyWage");
            return (Criteria) this;
        }

        public Criteria andDailyWageNotIn(List<String> values) {
            addCriterion("daily_wage not in", values, "dailyWage");
            return (Criteria) this;
        }

        public Criteria andDailyWageBetween(String value1, String value2) {
            addCriterion("daily_wage between", value1, value2, "dailyWage");
            return (Criteria) this;
        }

        public Criteria andDailyWageNotBetween(String value1, String value2) {
            addCriterion("daily_wage not between", value1, value2, "dailyWage");
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
            addCriterionForJDBCDate("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andBossTitleIsNull() {
            addCriterion("boss_title is null");
            return (Criteria) this;
        }

        public Criteria andBossTitleIsNotNull() {
            addCriterion("boss_title is not null");
            return (Criteria) this;
        }

        public Criteria andBossTitleEqualTo(String value) {
            addCriterion("boss_title =", value, "bossTitle");
            return (Criteria) this;
        }

        public Criteria andBossTitleNotEqualTo(String value) {
            addCriterion("boss_title <>", value, "bossTitle");
            return (Criteria) this;
        }

        public Criteria andBossTitleGreaterThan(String value) {
            addCriterion("boss_title >", value, "bossTitle");
            return (Criteria) this;
        }

        public Criteria andBossTitleGreaterThanOrEqualTo(String value) {
            addCriterion("boss_title >=", value, "bossTitle");
            return (Criteria) this;
        }

        public Criteria andBossTitleLessThan(String value) {
            addCriterion("boss_title <", value, "bossTitle");
            return (Criteria) this;
        }

        public Criteria andBossTitleLessThanOrEqualTo(String value) {
            addCriterion("boss_title <=", value, "bossTitle");
            return (Criteria) this;
        }

        public Criteria andBossTitleLike(String value) {
            addCriterion("boss_title like", value, "bossTitle");
            return (Criteria) this;
        }

        public Criteria andBossTitleNotLike(String value) {
            addCriterion("boss_title not like", value, "bossTitle");
            return (Criteria) this;
        }

        public Criteria andBossTitleIn(List<String> values) {
            addCriterion("boss_title in", values, "bossTitle");
            return (Criteria) this;
        }

        public Criteria andBossTitleNotIn(List<String> values) {
            addCriterion("boss_title not in", values, "bossTitle");
            return (Criteria) this;
        }

        public Criteria andBossTitleBetween(String value1, String value2) {
            addCriterion("boss_title between", value1, value2, "bossTitle");
            return (Criteria) this;
        }

        public Criteria andBossTitleNotBetween(String value1, String value2) {
            addCriterion("boss_title not between", value1, value2, "bossTitle");
            return (Criteria) this;
        }

        public Criteria andBossStateIsNull() {
            addCriterion("boss_state is null");
            return (Criteria) this;
        }

        public Criteria andBossStateIsNotNull() {
            addCriterion("boss_state is not null");
            return (Criteria) this;
        }

        public Criteria andBossStateEqualTo(Integer value) {
            addCriterion("boss_state =", value, "bossState");
            return (Criteria) this;
        }

        public Criteria andBossStateNotEqualTo(Integer value) {
            addCriterion("boss_state <>", value, "bossState");
            return (Criteria) this;
        }

        public Criteria andBossStateGreaterThan(Integer value) {
            addCriterion("boss_state >", value, "bossState");
            return (Criteria) this;
        }

        public Criteria andBossStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("boss_state >=", value, "bossState");
            return (Criteria) this;
        }

        public Criteria andBossStateLessThan(Integer value) {
            addCriterion("boss_state <", value, "bossState");
            return (Criteria) this;
        }

        public Criteria andBossStateLessThanOrEqualTo(Integer value) {
            addCriterion("boss_state <=", value, "bossState");
            return (Criteria) this;
        }

        public Criteria andBossStateIn(List<Integer> values) {
            addCriterion("boss_state in", values, "bossState");
            return (Criteria) this;
        }

        public Criteria andBossStateNotIn(List<Integer> values) {
            addCriterion("boss_state not in", values, "bossState");
            return (Criteria) this;
        }

        public Criteria andBossStateBetween(Integer value1, Integer value2) {
            addCriterion("boss_state between", value1, value2, "bossState");
            return (Criteria) this;
        }

        public Criteria andBossStateNotBetween(Integer value1, Integer value2) {
            addCriterion("boss_state not between", value1, value2, "bossState");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andOrderhunterIsNull() {
            addCriterion("orderhunter is null");
            return (Criteria) this;
        }

        public Criteria andOrderhunterIsNotNull() {
            addCriterion("orderhunter is not null");
            return (Criteria) this;
        }

        public Criteria andOrderhunterEqualTo(Integer value) {
            addCriterion("orderhunter =", value, "orderhunter");
            return (Criteria) this;
        }

        public Criteria andOrderhunterNotEqualTo(Integer value) {
            addCriterion("orderhunter <>", value, "orderhunter");
            return (Criteria) this;
        }

        public Criteria andOrderhunterGreaterThan(Integer value) {
            addCriterion("orderhunter >", value, "orderhunter");
            return (Criteria) this;
        }

        public Criteria andOrderhunterGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderhunter >=", value, "orderhunter");
            return (Criteria) this;
        }

        public Criteria andOrderhunterLessThan(Integer value) {
            addCriterion("orderhunter <", value, "orderhunter");
            return (Criteria) this;
        }

        public Criteria andOrderhunterLessThanOrEqualTo(Integer value) {
            addCriterion("orderhunter <=", value, "orderhunter");
            return (Criteria) this;
        }

        public Criteria andOrderhunterIn(List<Integer> values) {
            addCriterion("orderhunter in", values, "orderhunter");
            return (Criteria) this;
        }

        public Criteria andOrderhunterNotIn(List<Integer> values) {
            addCriterion("orderhunter not in", values, "orderhunter");
            return (Criteria) this;
        }

        public Criteria andOrderhunterBetween(Integer value1, Integer value2) {
            addCriterion("orderhunter between", value1, value2, "orderhunter");
            return (Criteria) this;
        }

        public Criteria andOrderhunterNotBetween(Integer value1, Integer value2) {
            addCriterion("orderhunter not between", value1, value2, "orderhunter");
            return (Criteria) this;
        }

        public Criteria andCheckstateIsNull() {
            addCriterion("checkstate is null");
            return (Criteria) this;
        }

        public Criteria andCheckstateIsNotNull() {
            addCriterion("checkstate is not null");
            return (Criteria) this;
        }

        public Criteria andCheckstateEqualTo(Integer value) {
            addCriterion("checkstate =", value, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateNotEqualTo(Integer value) {
            addCriterion("checkstate <>", value, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateGreaterThan(Integer value) {
            addCriterion("checkstate >", value, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("checkstate >=", value, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateLessThan(Integer value) {
            addCriterion("checkstate <", value, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateLessThanOrEqualTo(Integer value) {
            addCriterion("checkstate <=", value, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateIn(List<Integer> values) {
            addCriterion("checkstate in", values, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateNotIn(List<Integer> values) {
            addCriterion("checkstate not in", values, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateBetween(Integer value1, Integer value2) {
            addCriterion("checkstate between", value1, value2, "checkstate");
            return (Criteria) this;
        }

        public Criteria andCheckstateNotBetween(Integer value1, Integer value2) {
            addCriterion("checkstate not between", value1, value2, "checkstate");
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