package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnnualExtProvGuarInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnnualExtProvGuarInfoExample() {
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

        public Criteria andNbxhIsNull() {
            addCriterion("nbxh is null");
            return (Criteria) this;
        }

        public Criteria andNbxhIsNotNull() {
            addCriterion("nbxh is not null");
            return (Criteria) this;
        }

        public Criteria andNbxhEqualTo(String value) {
            addCriterion("nbxh =", value, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhNotEqualTo(String value) {
            addCriterion("nbxh <>", value, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhGreaterThan(String value) {
            addCriterion("nbxh >", value, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhGreaterThanOrEqualTo(String value) {
            addCriterion("nbxh >=", value, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhLessThan(String value) {
            addCriterion("nbxh <", value, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhLessThanOrEqualTo(String value) {
            addCriterion("nbxh <=", value, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhLike(String value) {
            addCriterion("nbxh like", value, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhNotLike(String value) {
            addCriterion("nbxh not like", value, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhIn(List<String> values) {
            addCriterion("nbxh in", values, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhNotIn(List<String> values) {
            addCriterion("nbxh not in", values, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhBetween(String value1, String value2) {
            addCriterion("nbxh between", value1, value2, "nbxh");
            return (Criteria) this;
        }

        public Criteria andNbxhNotBetween(String value1, String value2) {
            addCriterion("nbxh not between", value1, value2, "nbxh");
            return (Criteria) this;
        }

        public Criteria andSerialNoIsNull() {
            addCriterion("serial_no is null");
            return (Criteria) this;
        }

        public Criteria andSerialNoIsNotNull() {
            addCriterion("serial_no is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNoEqualTo(String value) {
            addCriterion("serial_no =", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotEqualTo(String value) {
            addCriterion("serial_no <>", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoGreaterThan(String value) {
            addCriterion("serial_no >", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoGreaterThanOrEqualTo(String value) {
            addCriterion("serial_no >=", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLessThan(String value) {
            addCriterion("serial_no <", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLessThanOrEqualTo(String value) {
            addCriterion("serial_no <=", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLike(String value) {
            addCriterion("serial_no like", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotLike(String value) {
            addCriterion("serial_no not like", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoIn(List<String> values) {
            addCriterion("serial_no in", values, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotIn(List<String> values) {
            addCriterion("serial_no not in", values, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoBetween(String value1, String value2) {
            addCriterion("serial_no between", value1, value2, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotBetween(String value1, String value2) {
            addCriterion("serial_no not between", value1, value2, "serialNo");
            return (Criteria) this;
        }

        public Criteria andCreditorIsNull() {
            addCriterion("creditor is null");
            return (Criteria) this;
        }

        public Criteria andCreditorIsNotNull() {
            addCriterion("creditor is not null");
            return (Criteria) this;
        }

        public Criteria andCreditorEqualTo(String value) {
            addCriterion("creditor =", value, "creditor");
            return (Criteria) this;
        }

        public Criteria andCreditorNotEqualTo(String value) {
            addCriterion("creditor <>", value, "creditor");
            return (Criteria) this;
        }

        public Criteria andCreditorGreaterThan(String value) {
            addCriterion("creditor >", value, "creditor");
            return (Criteria) this;
        }

        public Criteria andCreditorGreaterThanOrEqualTo(String value) {
            addCriterion("creditor >=", value, "creditor");
            return (Criteria) this;
        }

        public Criteria andCreditorLessThan(String value) {
            addCriterion("creditor <", value, "creditor");
            return (Criteria) this;
        }

        public Criteria andCreditorLessThanOrEqualTo(String value) {
            addCriterion("creditor <=", value, "creditor");
            return (Criteria) this;
        }

        public Criteria andCreditorLike(String value) {
            addCriterion("creditor like", value, "creditor");
            return (Criteria) this;
        }

        public Criteria andCreditorNotLike(String value) {
            addCriterion("creditor not like", value, "creditor");
            return (Criteria) this;
        }

        public Criteria andCreditorIn(List<String> values) {
            addCriterion("creditor in", values, "creditor");
            return (Criteria) this;
        }

        public Criteria andCreditorNotIn(List<String> values) {
            addCriterion("creditor not in", values, "creditor");
            return (Criteria) this;
        }

        public Criteria andCreditorBetween(String value1, String value2) {
            addCriterion("creditor between", value1, value2, "creditor");
            return (Criteria) this;
        }

        public Criteria andCreditorNotBetween(String value1, String value2) {
            addCriterion("creditor not between", value1, value2, "creditor");
            return (Criteria) this;
        }

        public Criteria andDebitorIsNull() {
            addCriterion("debitor is null");
            return (Criteria) this;
        }

        public Criteria andDebitorIsNotNull() {
            addCriterion("debitor is not null");
            return (Criteria) this;
        }

        public Criteria andDebitorEqualTo(String value) {
            addCriterion("debitor =", value, "debitor");
            return (Criteria) this;
        }

        public Criteria andDebitorNotEqualTo(String value) {
            addCriterion("debitor <>", value, "debitor");
            return (Criteria) this;
        }

        public Criteria andDebitorGreaterThan(String value) {
            addCriterion("debitor >", value, "debitor");
            return (Criteria) this;
        }

        public Criteria andDebitorGreaterThanOrEqualTo(String value) {
            addCriterion("debitor >=", value, "debitor");
            return (Criteria) this;
        }

        public Criteria andDebitorLessThan(String value) {
            addCriterion("debitor <", value, "debitor");
            return (Criteria) this;
        }

        public Criteria andDebitorLessThanOrEqualTo(String value) {
            addCriterion("debitor <=", value, "debitor");
            return (Criteria) this;
        }

        public Criteria andDebitorLike(String value) {
            addCriterion("debitor like", value, "debitor");
            return (Criteria) this;
        }

        public Criteria andDebitorNotLike(String value) {
            addCriterion("debitor not like", value, "debitor");
            return (Criteria) this;
        }

        public Criteria andDebitorIn(List<String> values) {
            addCriterion("debitor in", values, "debitor");
            return (Criteria) this;
        }

        public Criteria andDebitorNotIn(List<String> values) {
            addCriterion("debitor not in", values, "debitor");
            return (Criteria) this;
        }

        public Criteria andDebitorBetween(String value1, String value2) {
            addCriterion("debitor between", value1, value2, "debitor");
            return (Criteria) this;
        }

        public Criteria andDebitorNotBetween(String value1, String value2) {
            addCriterion("debitor not between", value1, value2, "debitor");
            return (Criteria) this;
        }

        public Criteria andPriCalSecKindIsNull() {
            addCriterion("pri_cal_sec_kind is null");
            return (Criteria) this;
        }

        public Criteria andPriCalSecKindIsNotNull() {
            addCriterion("pri_cal_sec_kind is not null");
            return (Criteria) this;
        }

        public Criteria andPriCalSecKindEqualTo(String value) {
            addCriterion("pri_cal_sec_kind =", value, "priCalSecKind");
            return (Criteria) this;
        }

        public Criteria andPriCalSecKindNotEqualTo(String value) {
            addCriterion("pri_cal_sec_kind <>", value, "priCalSecKind");
            return (Criteria) this;
        }

        public Criteria andPriCalSecKindGreaterThan(String value) {
            addCriterion("pri_cal_sec_kind >", value, "priCalSecKind");
            return (Criteria) this;
        }

        public Criteria andPriCalSecKindGreaterThanOrEqualTo(String value) {
            addCriterion("pri_cal_sec_kind >=", value, "priCalSecKind");
            return (Criteria) this;
        }

        public Criteria andPriCalSecKindLessThan(String value) {
            addCriterion("pri_cal_sec_kind <", value, "priCalSecKind");
            return (Criteria) this;
        }

        public Criteria andPriCalSecKindLessThanOrEqualTo(String value) {
            addCriterion("pri_cal_sec_kind <=", value, "priCalSecKind");
            return (Criteria) this;
        }

        public Criteria andPriCalSecKindLike(String value) {
            addCriterion("pri_cal_sec_kind like", value, "priCalSecKind");
            return (Criteria) this;
        }

        public Criteria andPriCalSecKindNotLike(String value) {
            addCriterion("pri_cal_sec_kind not like", value, "priCalSecKind");
            return (Criteria) this;
        }

        public Criteria andPriCalSecKindIn(List<String> values) {
            addCriterion("pri_cal_sec_kind in", values, "priCalSecKind");
            return (Criteria) this;
        }

        public Criteria andPriCalSecKindNotIn(List<String> values) {
            addCriterion("pri_cal_sec_kind not in", values, "priCalSecKind");
            return (Criteria) this;
        }

        public Criteria andPriCalSecKindBetween(String value1, String value2) {
            addCriterion("pri_cal_sec_kind between", value1, value2, "priCalSecKind");
            return (Criteria) this;
        }

        public Criteria andPriCalSecKindNotBetween(String value1, String value2) {
            addCriterion("pri_cal_sec_kind not between", value1, value2, "priCalSecKind");
            return (Criteria) this;
        }

        public Criteria andPriCalSecAmIsNull() {
            addCriterion("pri_cal_sec_am is null");
            return (Criteria) this;
        }

        public Criteria andPriCalSecAmIsNotNull() {
            addCriterion("pri_cal_sec_am is not null");
            return (Criteria) this;
        }

        public Criteria andPriCalSecAmEqualTo(Double value) {
            addCriterion("pri_cal_sec_am =", value, "priCalSecAm");
            return (Criteria) this;
        }

        public Criteria andPriCalSecAmNotEqualTo(Double value) {
            addCriterion("pri_cal_sec_am <>", value, "priCalSecAm");
            return (Criteria) this;
        }

        public Criteria andPriCalSecAmGreaterThan(Double value) {
            addCriterion("pri_cal_sec_am >", value, "priCalSecAm");
            return (Criteria) this;
        }

        public Criteria andPriCalSecAmGreaterThanOrEqualTo(Double value) {
            addCriterion("pri_cal_sec_am >=", value, "priCalSecAm");
            return (Criteria) this;
        }

        public Criteria andPriCalSecAmLessThan(Double value) {
            addCriterion("pri_cal_sec_am <", value, "priCalSecAm");
            return (Criteria) this;
        }

        public Criteria andPriCalSecAmLessThanOrEqualTo(Double value) {
            addCriterion("pri_cal_sec_am <=", value, "priCalSecAm");
            return (Criteria) this;
        }

        public Criteria andPriCalSecAmIn(List<Double> values) {
            addCriterion("pri_cal_sec_am in", values, "priCalSecAm");
            return (Criteria) this;
        }

        public Criteria andPriCalSecAmNotIn(List<Double> values) {
            addCriterion("pri_cal_sec_am not in", values, "priCalSecAm");
            return (Criteria) this;
        }

        public Criteria andPriCalSecAmBetween(Double value1, Double value2) {
            addCriterion("pri_cal_sec_am between", value1, value2, "priCalSecAm");
            return (Criteria) this;
        }

        public Criteria andPriCalSecAmNotBetween(Double value1, Double value2) {
            addCriterion("pri_cal_sec_am not between", value1, value2, "priCalSecAm");
            return (Criteria) this;
        }

        public Criteria andPefPerFromIsNull() {
            addCriterion("pef_per_from is null");
            return (Criteria) this;
        }

        public Criteria andPefPerFromIsNotNull() {
            addCriterion("pef_per_from is not null");
            return (Criteria) this;
        }

        public Criteria andPefPerFromEqualTo(Date value) {
            addCriterion("pef_per_from =", value, "pefPerFrom");
            return (Criteria) this;
        }

        public Criteria andPefPerFromNotEqualTo(Date value) {
            addCriterion("pef_per_from <>", value, "pefPerFrom");
            return (Criteria) this;
        }

        public Criteria andPefPerFromGreaterThan(Date value) {
            addCriterion("pef_per_from >", value, "pefPerFrom");
            return (Criteria) this;
        }

        public Criteria andPefPerFromGreaterThanOrEqualTo(Date value) {
            addCriterion("pef_per_from >=", value, "pefPerFrom");
            return (Criteria) this;
        }

        public Criteria andPefPerFromLessThan(Date value) {
            addCriterion("pef_per_from <", value, "pefPerFrom");
            return (Criteria) this;
        }

        public Criteria andPefPerFromLessThanOrEqualTo(Date value) {
            addCriterion("pef_per_from <=", value, "pefPerFrom");
            return (Criteria) this;
        }

        public Criteria andPefPerFromIn(List<Date> values) {
            addCriterion("pef_per_from in", values, "pefPerFrom");
            return (Criteria) this;
        }

        public Criteria andPefPerFromNotIn(List<Date> values) {
            addCriterion("pef_per_from not in", values, "pefPerFrom");
            return (Criteria) this;
        }

        public Criteria andPefPerFromBetween(Date value1, Date value2) {
            addCriterion("pef_per_from between", value1, value2, "pefPerFrom");
            return (Criteria) this;
        }

        public Criteria andPefPerFromNotBetween(Date value1, Date value2) {
            addCriterion("pef_per_from not between", value1, value2, "pefPerFrom");
            return (Criteria) this;
        }

        public Criteria andPefPerToIsNull() {
            addCriterion("pef_per_to is null");
            return (Criteria) this;
        }

        public Criteria andPefPerToIsNotNull() {
            addCriterion("pef_per_to is not null");
            return (Criteria) this;
        }

        public Criteria andPefPerToEqualTo(Date value) {
            addCriterion("pef_per_to =", value, "pefPerTo");
            return (Criteria) this;
        }

        public Criteria andPefPerToNotEqualTo(Date value) {
            addCriterion("pef_per_to <>", value, "pefPerTo");
            return (Criteria) this;
        }

        public Criteria andPefPerToGreaterThan(Date value) {
            addCriterion("pef_per_to >", value, "pefPerTo");
            return (Criteria) this;
        }

        public Criteria andPefPerToGreaterThanOrEqualTo(Date value) {
            addCriterion("pef_per_to >=", value, "pefPerTo");
            return (Criteria) this;
        }

        public Criteria andPefPerToLessThan(Date value) {
            addCriterion("pef_per_to <", value, "pefPerTo");
            return (Criteria) this;
        }

        public Criteria andPefPerToLessThanOrEqualTo(Date value) {
            addCriterion("pef_per_to <=", value, "pefPerTo");
            return (Criteria) this;
        }

        public Criteria andPefPerToIn(List<Date> values) {
            addCriterion("pef_per_to in", values, "pefPerTo");
            return (Criteria) this;
        }

        public Criteria andPefPerToNotIn(List<Date> values) {
            addCriterion("pef_per_to not in", values, "pefPerTo");
            return (Criteria) this;
        }

        public Criteria andPefPerToBetween(Date value1, Date value2) {
            addCriterion("pef_per_to between", value1, value2, "pefPerTo");
            return (Criteria) this;
        }

        public Criteria andPefPerToNotBetween(Date value1, Date value2) {
            addCriterion("pef_per_to not between", value1, value2, "pefPerTo");
            return (Criteria) this;
        }

        public Criteria andGuarantePeriodIsNull() {
            addCriterion("guarante_period is null");
            return (Criteria) this;
        }

        public Criteria andGuarantePeriodIsNotNull() {
            addCriterion("guarante_period is not null");
            return (Criteria) this;
        }

        public Criteria andGuarantePeriodEqualTo(String value) {
            addCriterion("guarante_period =", value, "guarantePeriod");
            return (Criteria) this;
        }

        public Criteria andGuarantePeriodNotEqualTo(String value) {
            addCriterion("guarante_period <>", value, "guarantePeriod");
            return (Criteria) this;
        }

        public Criteria andGuarantePeriodGreaterThan(String value) {
            addCriterion("guarante_period >", value, "guarantePeriod");
            return (Criteria) this;
        }

        public Criteria andGuarantePeriodGreaterThanOrEqualTo(String value) {
            addCriterion("guarante_period >=", value, "guarantePeriod");
            return (Criteria) this;
        }

        public Criteria andGuarantePeriodLessThan(String value) {
            addCriterion("guarante_period <", value, "guarantePeriod");
            return (Criteria) this;
        }

        public Criteria andGuarantePeriodLessThanOrEqualTo(String value) {
            addCriterion("guarante_period <=", value, "guarantePeriod");
            return (Criteria) this;
        }

        public Criteria andGuarantePeriodLike(String value) {
            addCriterion("guarante_period like", value, "guarantePeriod");
            return (Criteria) this;
        }

        public Criteria andGuarantePeriodNotLike(String value) {
            addCriterion("guarante_period not like", value, "guarantePeriod");
            return (Criteria) this;
        }

        public Criteria andGuarantePeriodIn(List<String> values) {
            addCriterion("guarante_period in", values, "guarantePeriod");
            return (Criteria) this;
        }

        public Criteria andGuarantePeriodNotIn(List<String> values) {
            addCriterion("guarante_period not in", values, "guarantePeriod");
            return (Criteria) this;
        }

        public Criteria andGuarantePeriodBetween(String value1, String value2) {
            addCriterion("guarante_period between", value1, value2, "guarantePeriod");
            return (Criteria) this;
        }

        public Criteria andGuarantePeriodNotBetween(String value1, String value2) {
            addCriterion("guarante_period not between", value1, value2, "guarantePeriod");
            return (Criteria) this;
        }

        public Criteria andGuaranteTypeIsNull() {
            addCriterion("guarante_type is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteTypeIsNotNull() {
            addCriterion("guarante_type is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteTypeEqualTo(String value) {
            addCriterion("guarante_type =", value, "guaranteType");
            return (Criteria) this;
        }

        public Criteria andGuaranteTypeNotEqualTo(String value) {
            addCriterion("guarante_type <>", value, "guaranteType");
            return (Criteria) this;
        }

        public Criteria andGuaranteTypeGreaterThan(String value) {
            addCriterion("guarante_type >", value, "guaranteType");
            return (Criteria) this;
        }

        public Criteria andGuaranteTypeGreaterThanOrEqualTo(String value) {
            addCriterion("guarante_type >=", value, "guaranteType");
            return (Criteria) this;
        }

        public Criteria andGuaranteTypeLessThan(String value) {
            addCriterion("guarante_type <", value, "guaranteType");
            return (Criteria) this;
        }

        public Criteria andGuaranteTypeLessThanOrEqualTo(String value) {
            addCriterion("guarante_type <=", value, "guaranteType");
            return (Criteria) this;
        }

        public Criteria andGuaranteTypeLike(String value) {
            addCriterion("guarante_type like", value, "guaranteType");
            return (Criteria) this;
        }

        public Criteria andGuaranteTypeNotLike(String value) {
            addCriterion("guarante_type not like", value, "guaranteType");
            return (Criteria) this;
        }

        public Criteria andGuaranteTypeIn(List<String> values) {
            addCriterion("guarante_type in", values, "guaranteType");
            return (Criteria) this;
        }

        public Criteria andGuaranteTypeNotIn(List<String> values) {
            addCriterion("guarante_type not in", values, "guaranteType");
            return (Criteria) this;
        }

        public Criteria andGuaranteTypeBetween(String value1, String value2) {
            addCriterion("guarante_type between", value1, value2, "guaranteType");
            return (Criteria) this;
        }

        public Criteria andGuaranteTypeNotBetween(String value1, String value2) {
            addCriterion("guarante_type not between", value1, value2, "guaranteType");
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