package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompareStatisticExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompareStatisticExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAnnualTotalIsNull() {
            addCriterion("annual_total is null");
            return (Criteria) this;
        }

        public Criteria andAnnualTotalIsNotNull() {
            addCriterion("annual_total is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualTotalEqualTo(Integer value) {
            addCriterion("annual_total =", value, "annualTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualTotalNotEqualTo(Integer value) {
            addCriterion("annual_total <>", value, "annualTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualTotalGreaterThan(Integer value) {
            addCriterion("annual_total >", value, "annualTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("annual_total >=", value, "annualTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualTotalLessThan(Integer value) {
            addCriterion("annual_total <", value, "annualTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualTotalLessThanOrEqualTo(Integer value) {
            addCriterion("annual_total <=", value, "annualTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualTotalIn(List<Integer> values) {
            addCriterion("annual_total in", values, "annualTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualTotalNotIn(List<Integer> values) {
            addCriterion("annual_total not in", values, "annualTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualTotalBetween(Integer value1, Integer value2) {
            addCriterion("annual_total between", value1, value2, "annualTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("annual_total not between", value1, value2, "annualTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualItemTotalIsNull() {
            addCriterion("annual_item_total is null");
            return (Criteria) this;
        }

        public Criteria andAnnualItemTotalIsNotNull() {
            addCriterion("annual_item_total is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualItemTotalEqualTo(Integer value) {
            addCriterion("annual_item_total =", value, "annualItemTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualItemTotalNotEqualTo(Integer value) {
            addCriterion("annual_item_total <>", value, "annualItemTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualItemTotalGreaterThan(Integer value) {
            addCriterion("annual_item_total >", value, "annualItemTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualItemTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("annual_item_total >=", value, "annualItemTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualItemTotalLessThan(Integer value) {
            addCriterion("annual_item_total <", value, "annualItemTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualItemTotalLessThanOrEqualTo(Integer value) {
            addCriterion("annual_item_total <=", value, "annualItemTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualItemTotalIn(List<Integer> values) {
            addCriterion("annual_item_total in", values, "annualItemTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualItemTotalNotIn(List<Integer> values) {
            addCriterion("annual_item_total not in", values, "annualItemTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualItemTotalBetween(Integer value1, Integer value2) {
            addCriterion("annual_item_total between", value1, value2, "annualItemTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualItemTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("annual_item_total not between", value1, value2, "annualItemTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyTotalIsNull() {
            addCriterion("instantly_total is null");
            return (Criteria) this;
        }

        public Criteria andInstantlyTotalIsNotNull() {
            addCriterion("instantly_total is not null");
            return (Criteria) this;
        }

        public Criteria andInstantlyTotalEqualTo(Integer value) {
            addCriterion("instantly_total =", value, "instantlyTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyTotalNotEqualTo(Integer value) {
            addCriterion("instantly_total <>", value, "instantlyTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyTotalGreaterThan(Integer value) {
            addCriterion("instantly_total >", value, "instantlyTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("instantly_total >=", value, "instantlyTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyTotalLessThan(Integer value) {
            addCriterion("instantly_total <", value, "instantlyTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyTotalLessThanOrEqualTo(Integer value) {
            addCriterion("instantly_total <=", value, "instantlyTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyTotalIn(List<Integer> values) {
            addCriterion("instantly_total in", values, "instantlyTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyTotalNotIn(List<Integer> values) {
            addCriterion("instantly_total not in", values, "instantlyTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyTotalBetween(Integer value1, Integer value2) {
            addCriterion("instantly_total between", value1, value2, "instantlyTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("instantly_total not between", value1, value2, "instantlyTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyItemTotalIsNull() {
            addCriterion("instantly_item_total is null");
            return (Criteria) this;
        }

        public Criteria andInstantlyItemTotalIsNotNull() {
            addCriterion("instantly_item_total is not null");
            return (Criteria) this;
        }

        public Criteria andInstantlyItemTotalEqualTo(Integer value) {
            addCriterion("instantly_item_total =", value, "instantlyItemTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyItemTotalNotEqualTo(Integer value) {
            addCriterion("instantly_item_total <>", value, "instantlyItemTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyItemTotalGreaterThan(Integer value) {
            addCriterion("instantly_item_total >", value, "instantlyItemTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyItemTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("instantly_item_total >=", value, "instantlyItemTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyItemTotalLessThan(Integer value) {
            addCriterion("instantly_item_total <", value, "instantlyItemTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyItemTotalLessThanOrEqualTo(Integer value) {
            addCriterion("instantly_item_total <=", value, "instantlyItemTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyItemTotalIn(List<Integer> values) {
            addCriterion("instantly_item_total in", values, "instantlyItemTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyItemTotalNotIn(List<Integer> values) {
            addCriterion("instantly_item_total not in", values, "instantlyItemTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyItemTotalBetween(Integer value1, Integer value2) {
            addCriterion("instantly_item_total between", value1, value2, "instantlyItemTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyItemTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("instantly_item_total not between", value1, value2, "instantlyItemTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualExTotalIsNull() {
            addCriterion("annual_ex_total is null");
            return (Criteria) this;
        }

        public Criteria andAnnualExTotalIsNotNull() {
            addCriterion("annual_ex_total is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualExTotalEqualTo(Integer value) {
            addCriterion("annual_ex_total =", value, "annualExTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualExTotalNotEqualTo(Integer value) {
            addCriterion("annual_ex_total <>", value, "annualExTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualExTotalGreaterThan(Integer value) {
            addCriterion("annual_ex_total >", value, "annualExTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualExTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("annual_ex_total >=", value, "annualExTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualExTotalLessThan(Integer value) {
            addCriterion("annual_ex_total <", value, "annualExTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualExTotalLessThanOrEqualTo(Integer value) {
            addCriterion("annual_ex_total <=", value, "annualExTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualExTotalIn(List<Integer> values) {
            addCriterion("annual_ex_total in", values, "annualExTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualExTotalNotIn(List<Integer> values) {
            addCriterion("annual_ex_total not in", values, "annualExTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualExTotalBetween(Integer value1, Integer value2) {
            addCriterion("annual_ex_total between", value1, value2, "annualExTotal");
            return (Criteria) this;
        }

        public Criteria andAnnualExTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("annual_ex_total not between", value1, value2, "annualExTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyExTotalIsNull() {
            addCriterion("instantly_ex_total is null");
            return (Criteria) this;
        }

        public Criteria andInstantlyExTotalIsNotNull() {
            addCriterion("instantly_ex_total is not null");
            return (Criteria) this;
        }

        public Criteria andInstantlyExTotalEqualTo(Integer value) {
            addCriterion("instantly_ex_total =", value, "instantlyExTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyExTotalNotEqualTo(Integer value) {
            addCriterion("instantly_ex_total <>", value, "instantlyExTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyExTotalGreaterThan(Integer value) {
            addCriterion("instantly_ex_total >", value, "instantlyExTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyExTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("instantly_ex_total >=", value, "instantlyExTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyExTotalLessThan(Integer value) {
            addCriterion("instantly_ex_total <", value, "instantlyExTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyExTotalLessThanOrEqualTo(Integer value) {
            addCriterion("instantly_ex_total <=", value, "instantlyExTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyExTotalIn(List<Integer> values) {
            addCriterion("instantly_ex_total in", values, "instantlyExTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyExTotalNotIn(List<Integer> values) {
            addCriterion("instantly_ex_total not in", values, "instantlyExTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyExTotalBetween(Integer value1, Integer value2) {
            addCriterion("instantly_ex_total between", value1, value2, "instantlyExTotal");
            return (Criteria) this;
        }

        public Criteria andInstantlyExTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("instantly_ex_total not between", value1, value2, "instantlyExTotal");
            return (Criteria) this;
        }

        public Criteria andExTotalIsNull() {
            addCriterion("ex_total is null");
            return (Criteria) this;
        }

        public Criteria andExTotalIsNotNull() {
            addCriterion("ex_total is not null");
            return (Criteria) this;
        }

        public Criteria andExTotalEqualTo(Integer value) {
            addCriterion("ex_total =", value, "exTotal");
            return (Criteria) this;
        }

        public Criteria andExTotalNotEqualTo(Integer value) {
            addCriterion("ex_total <>", value, "exTotal");
            return (Criteria) this;
        }

        public Criteria andExTotalGreaterThan(Integer value) {
            addCriterion("ex_total >", value, "exTotal");
            return (Criteria) this;
        }

        public Criteria andExTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("ex_total >=", value, "exTotal");
            return (Criteria) this;
        }

        public Criteria andExTotalLessThan(Integer value) {
            addCriterion("ex_total <", value, "exTotal");
            return (Criteria) this;
        }

        public Criteria andExTotalLessThanOrEqualTo(Integer value) {
            addCriterion("ex_total <=", value, "exTotal");
            return (Criteria) this;
        }

        public Criteria andExTotalIn(List<Integer> values) {
            addCriterion("ex_total in", values, "exTotal");
            return (Criteria) this;
        }

        public Criteria andExTotalNotIn(List<Integer> values) {
            addCriterion("ex_total not in", values, "exTotal");
            return (Criteria) this;
        }

        public Criteria andExTotalBetween(Integer value1, Integer value2) {
            addCriterion("ex_total between", value1, value2, "exTotal");
            return (Criteria) this;
        }

        public Criteria andExTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("ex_total not between", value1, value2, "exTotal");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Integer value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Integer value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Integer value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Integer value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Integer value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Integer> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Integer> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Integer value1, Integer value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalItemIsNull() {
            addCriterion("total_item is null");
            return (Criteria) this;
        }

        public Criteria andTotalItemIsNotNull() {
            addCriterion("total_item is not null");
            return (Criteria) this;
        }

        public Criteria andTotalItemEqualTo(Integer value) {
            addCriterion("total_item =", value, "totalItem");
            return (Criteria) this;
        }

        public Criteria andTotalItemNotEqualTo(Integer value) {
            addCriterion("total_item <>", value, "totalItem");
            return (Criteria) this;
        }

        public Criteria andTotalItemGreaterThan(Integer value) {
            addCriterion("total_item >", value, "totalItem");
            return (Criteria) this;
        }

        public Criteria andTotalItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_item >=", value, "totalItem");
            return (Criteria) this;
        }

        public Criteria andTotalItemLessThan(Integer value) {
            addCriterion("total_item <", value, "totalItem");
            return (Criteria) this;
        }

        public Criteria andTotalItemLessThanOrEqualTo(Integer value) {
            addCriterion("total_item <=", value, "totalItem");
            return (Criteria) this;
        }

        public Criteria andTotalItemIn(List<Integer> values) {
            addCriterion("total_item in", values, "totalItem");
            return (Criteria) this;
        }

        public Criteria andTotalItemNotIn(List<Integer> values) {
            addCriterion("total_item not in", values, "totalItem");
            return (Criteria) this;
        }

        public Criteria andTotalItemBetween(Integer value1, Integer value2) {
            addCriterion("total_item between", value1, value2, "totalItem");
            return (Criteria) this;
        }

        public Criteria andTotalItemNotBetween(Integer value1, Integer value2) {
            addCriterion("total_item not between", value1, value2, "totalItem");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Integer value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Integer value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Integer value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Integer value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Integer value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Integer> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Integer> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Integer value1, Integer value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andFullTaskNumIsNull() {
            addCriterion("full_task_num is null");
            return (Criteria) this;
        }

        public Criteria andFullTaskNumIsNotNull() {
            addCriterion("full_task_num is not null");
            return (Criteria) this;
        }

        public Criteria andFullTaskNumEqualTo(Integer value) {
            addCriterion("full_task_num =", value, "fullTaskNum");
            return (Criteria) this;
        }

        public Criteria andFullTaskNumNotEqualTo(Integer value) {
            addCriterion("full_task_num <>", value, "fullTaskNum");
            return (Criteria) this;
        }

        public Criteria andFullTaskNumGreaterThan(Integer value) {
            addCriterion("full_task_num >", value, "fullTaskNum");
            return (Criteria) this;
        }

        public Criteria andFullTaskNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("full_task_num >=", value, "fullTaskNum");
            return (Criteria) this;
        }

        public Criteria andFullTaskNumLessThan(Integer value) {
            addCriterion("full_task_num <", value, "fullTaskNum");
            return (Criteria) this;
        }

        public Criteria andFullTaskNumLessThanOrEqualTo(Integer value) {
            addCriterion("full_task_num <=", value, "fullTaskNum");
            return (Criteria) this;
        }

        public Criteria andFullTaskNumIn(List<Integer> values) {
            addCriterion("full_task_num in", values, "fullTaskNum");
            return (Criteria) this;
        }

        public Criteria andFullTaskNumNotIn(List<Integer> values) {
            addCriterion("full_task_num not in", values, "fullTaskNum");
            return (Criteria) this;
        }

        public Criteria andFullTaskNumBetween(Integer value1, Integer value2) {
            addCriterion("full_task_num between", value1, value2, "fullTaskNum");
            return (Criteria) this;
        }

        public Criteria andFullTaskNumNotBetween(Integer value1, Integer value2) {
            addCriterion("full_task_num not between", value1, value2, "fullTaskNum");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
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