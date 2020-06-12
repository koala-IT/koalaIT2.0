package com.koalaIT.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HunterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HunterExample() {
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

        public Criteria andCapacityIsNull() {
            addCriterion("capacity is null");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNotNull() {
            addCriterion("capacity is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityEqualTo(String value) {
            addCriterion("capacity =", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotEqualTo(String value) {
            addCriterion("capacity <>", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThan(String value) {
            addCriterion("capacity >", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThanOrEqualTo(String value) {
            addCriterion("capacity >=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThan(String value) {
            addCriterion("capacity <", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThanOrEqualTo(String value) {
            addCriterion("capacity <=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLike(String value) {
            addCriterion("capacity like", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotLike(String value) {
            addCriterion("capacity not like", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityIn(List<String> values) {
            addCriterion("capacity in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotIn(List<String> values) {
            addCriterion("capacity not in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityBetween(String value1, String value2) {
            addCriterion("capacity between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotBetween(String value1, String value2) {
            addCriterion("capacity not between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andHunterDetailIsNull() {
            addCriterion("hunter_detail is null");
            return (Criteria) this;
        }

        public Criteria andHunterDetailIsNotNull() {
            addCriterion("hunter_detail is not null");
            return (Criteria) this;
        }

        public Criteria andHunterDetailEqualTo(String value) {
            addCriterion("hunter_detail =", value, "hunterDetail");
            return (Criteria) this;
        }

        public Criteria andHunterDetailNotEqualTo(String value) {
            addCriterion("hunter_detail <>", value, "hunterDetail");
            return (Criteria) this;
        }

        public Criteria andHunterDetailGreaterThan(String value) {
            addCriterion("hunter_detail >", value, "hunterDetail");
            return (Criteria) this;
        }

        public Criteria andHunterDetailGreaterThanOrEqualTo(String value) {
            addCriterion("hunter_detail >=", value, "hunterDetail");
            return (Criteria) this;
        }

        public Criteria andHunterDetailLessThan(String value) {
            addCriterion("hunter_detail <", value, "hunterDetail");
            return (Criteria) this;
        }

        public Criteria andHunterDetailLessThanOrEqualTo(String value) {
            addCriterion("hunter_detail <=", value, "hunterDetail");
            return (Criteria) this;
        }

        public Criteria andHunterDetailLike(String value) {
            addCriterion("hunter_detail like", value, "hunterDetail");
            return (Criteria) this;
        }

        public Criteria andHunterDetailNotLike(String value) {
            addCriterion("hunter_detail not like", value, "hunterDetail");
            return (Criteria) this;
        }

        public Criteria andHunterDetailIn(List<String> values) {
            addCriterion("hunter_detail in", values, "hunterDetail");
            return (Criteria) this;
        }

        public Criteria andHunterDetailNotIn(List<String> values) {
            addCriterion("hunter_detail not in", values, "hunterDetail");
            return (Criteria) this;
        }

        public Criteria andHunterDetailBetween(String value1, String value2) {
            addCriterion("hunter_detail between", value1, value2, "hunterDetail");
            return (Criteria) this;
        }

        public Criteria andHunterDetailNotBetween(String value1, String value2) {
            addCriterion("hunter_detail not between", value1, value2, "hunterDetail");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNull() {
            addCriterion("salary is null");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNotNull() {
            addCriterion("salary is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryEqualTo(String value) {
            addCriterion("salary =", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotEqualTo(String value) {
            addCriterion("salary <>", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThan(String value) {
            addCriterion("salary >", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("salary >=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThan(String value) {
            addCriterion("salary <", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThanOrEqualTo(String value) {
            addCriterion("salary <=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLike(String value) {
            addCriterion("salary like", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotLike(String value) {
            addCriterion("salary not like", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryIn(List<String> values) {
            addCriterion("salary in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotIn(List<String> values) {
            addCriterion("salary not in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryBetween(String value1, String value2) {
            addCriterion("salary between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotBetween(String value1, String value2) {
            addCriterion("salary not between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andHunterStateIsNull() {
            addCriterion("hunter_state is null");
            return (Criteria) this;
        }

        public Criteria andHunterStateIsNotNull() {
            addCriterion("hunter_state is not null");
            return (Criteria) this;
        }

        public Criteria andHunterStateEqualTo(Boolean value) {
            addCriterion("hunter_state =", value, "hunterState");
            return (Criteria) this;
        }

        public Criteria andHunterStateNotEqualTo(Boolean value) {
            addCriterion("hunter_state <>", value, "hunterState");
            return (Criteria) this;
        }

        public Criteria andHunterStateGreaterThan(Boolean value) {
            addCriterion("hunter_state >", value, "hunterState");
            return (Criteria) this;
        }

        public Criteria andHunterStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hunter_state >=", value, "hunterState");
            return (Criteria) this;
        }

        public Criteria andHunterStateLessThan(Boolean value) {
            addCriterion("hunter_state <", value, "hunterState");
            return (Criteria) this;
        }

        public Criteria andHunterStateLessThanOrEqualTo(Boolean value) {
            addCriterion("hunter_state <=", value, "hunterState");
            return (Criteria) this;
        }

        public Criteria andHunterStateIn(List<Boolean> values) {
            addCriterion("hunter_state in", values, "hunterState");
            return (Criteria) this;
        }

        public Criteria andHunterStateNotIn(List<Boolean> values) {
            addCriterion("hunter_state not in", values, "hunterState");
            return (Criteria) this;
        }

        public Criteria andHunterStateBetween(Boolean value1, Boolean value2) {
            addCriterion("hunter_state between", value1, value2, "hunterState");
            return (Criteria) this;
        }

        public Criteria andHunterStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hunter_state not between", value1, value2, "hunterState");
            return (Criteria) this;
        }

        public Criteria andHunterTitleIsNull() {
            addCriterion("hunter_title is null");
            return (Criteria) this;
        }

        public Criteria andHunterTitleIsNotNull() {
            addCriterion("hunter_title is not null");
            return (Criteria) this;
        }

        public Criteria andHunterTitleEqualTo(String value) {
            addCriterion("hunter_title =", value, "hunterTitle");
            return (Criteria) this;
        }

        public Criteria andHunterTitleNotEqualTo(String value) {
            addCriterion("hunter_title <>", value, "hunterTitle");
            return (Criteria) this;
        }

        public Criteria andHunterTitleGreaterThan(String value) {
            addCriterion("hunter_title >", value, "hunterTitle");
            return (Criteria) this;
        }

        public Criteria andHunterTitleGreaterThanOrEqualTo(String value) {
            addCriterion("hunter_title >=", value, "hunterTitle");
            return (Criteria) this;
        }

        public Criteria andHunterTitleLessThan(String value) {
            addCriterion("hunter_title <", value, "hunterTitle");
            return (Criteria) this;
        }

        public Criteria andHunterTitleLessThanOrEqualTo(String value) {
            addCriterion("hunter_title <=", value, "hunterTitle");
            return (Criteria) this;
        }

        public Criteria andHunterTitleLike(String value) {
            addCriterion("hunter_title like", value, "hunterTitle");
            return (Criteria) this;
        }

        public Criteria andHunterTitleNotLike(String value) {
            addCriterion("hunter_title not like", value, "hunterTitle");
            return (Criteria) this;
        }

        public Criteria andHunterTitleIn(List<String> values) {
            addCriterion("hunter_title in", values, "hunterTitle");
            return (Criteria) this;
        }

        public Criteria andHunterTitleNotIn(List<String> values) {
            addCriterion("hunter_title not in", values, "hunterTitle");
            return (Criteria) this;
        }

        public Criteria andHunterTitleBetween(String value1, String value2) {
            addCriterion("hunter_title between", value1, value2, "hunterTitle");
            return (Criteria) this;
        }

        public Criteria andHunterTitleNotBetween(String value1, String value2) {
            addCriterion("hunter_title not between", value1, value2, "hunterTitle");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIsNull() {
            addCriterion("work_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIsNotNull() {
            addCriterion("work_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEqualTo(String value) {
            addCriterion("work_time =", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotEqualTo(String value) {
            addCriterion("work_time <>", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeGreaterThan(String value) {
            addCriterion("work_time >", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeGreaterThanOrEqualTo(String value) {
            addCriterion("work_time >=", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLessThan(String value) {
            addCriterion("work_time <", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLessThanOrEqualTo(String value) {
            addCriterion("work_time <=", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLike(String value) {
            addCriterion("work_time like", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotLike(String value) {
            addCriterion("work_time not like", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIn(List<String> values) {
            addCriterion("work_time in", values, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotIn(List<String> values) {
            addCriterion("work_time not in", values, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeBetween(String value1, String value2) {
            addCriterion("work_time between", value1, value2, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotBetween(String value1, String value2) {
            addCriterion("work_time not between", value1, value2, "workTime");
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

        public Criteria andOrderbossIsNull() {
            addCriterion("orderboss is null");
            return (Criteria) this;
        }

        public Criteria andOrderbossIsNotNull() {
            addCriterion("orderboss is not null");
            return (Criteria) this;
        }

        public Criteria andOrderbossEqualTo(Integer value) {
            addCriterion("orderboss =", value, "orderboss");
            return (Criteria) this;
        }

        public Criteria andOrderbossNotEqualTo(Integer value) {
            addCriterion("orderboss <>", value, "orderboss");
            return (Criteria) this;
        }

        public Criteria andOrderbossGreaterThan(Integer value) {
            addCriterion("orderboss >", value, "orderboss");
            return (Criteria) this;
        }

        public Criteria andOrderbossGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderboss >=", value, "orderboss");
            return (Criteria) this;
        }

        public Criteria andOrderbossLessThan(Integer value) {
            addCriterion("orderboss <", value, "orderboss");
            return (Criteria) this;
        }

        public Criteria andOrderbossLessThanOrEqualTo(Integer value) {
            addCriterion("orderboss <=", value, "orderboss");
            return (Criteria) this;
        }

        public Criteria andOrderbossIn(List<Integer> values) {
            addCriterion("orderboss in", values, "orderboss");
            return (Criteria) this;
        }

        public Criteria andOrderbossNotIn(List<Integer> values) {
            addCriterion("orderboss not in", values, "orderboss");
            return (Criteria) this;
        }

        public Criteria andOrderbossBetween(Integer value1, Integer value2) {
            addCriterion("orderboss between", value1, value2, "orderboss");
            return (Criteria) this;
        }

        public Criteria andOrderbossNotBetween(Integer value1, Integer value2) {
            addCriterion("orderboss not between", value1, value2, "orderboss");
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