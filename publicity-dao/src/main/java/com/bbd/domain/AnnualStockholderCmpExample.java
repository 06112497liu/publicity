package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnnualStockholderCmpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnnualStockholderCmpExample() {
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

        public Criteria andShareholderIsNull() {
            addCriterion("shareholder is null");
            return (Criteria) this;
        }

        public Criteria andShareholderIsNotNull() {
            addCriterion("shareholder is not null");
            return (Criteria) this;
        }

        public Criteria andShareholderEqualTo(String value) {
            addCriterion("shareholder =", value, "shareholder");
            return (Criteria) this;
        }

        public Criteria andShareholderNotEqualTo(String value) {
            addCriterion("shareholder <>", value, "shareholder");
            return (Criteria) this;
        }

        public Criteria andShareholderGreaterThan(String value) {
            addCriterion("shareholder >", value, "shareholder");
            return (Criteria) this;
        }

        public Criteria andShareholderGreaterThanOrEqualTo(String value) {
            addCriterion("shareholder >=", value, "shareholder");
            return (Criteria) this;
        }

        public Criteria andShareholderLessThan(String value) {
            addCriterion("shareholder <", value, "shareholder");
            return (Criteria) this;
        }

        public Criteria andShareholderLessThanOrEqualTo(String value) {
            addCriterion("shareholder <=", value, "shareholder");
            return (Criteria) this;
        }

        public Criteria andShareholderLike(String value) {
            addCriterion("shareholder like", value, "shareholder");
            return (Criteria) this;
        }

        public Criteria andShareholderNotLike(String value) {
            addCriterion("shareholder not like", value, "shareholder");
            return (Criteria) this;
        }

        public Criteria andShareholderIn(List<String> values) {
            addCriterion("shareholder in", values, "shareholder");
            return (Criteria) this;
        }

        public Criteria andShareholderNotIn(List<String> values) {
            addCriterion("shareholder not in", values, "shareholder");
            return (Criteria) this;
        }

        public Criteria andShareholderBetween(String value1, String value2) {
            addCriterion("shareholder between", value1, value2, "shareholder");
            return (Criteria) this;
        }

        public Criteria andShareholderNotBetween(String value1, String value2) {
            addCriterion("shareholder not between", value1, value2, "shareholder");
            return (Criteria) this;
        }

        public Criteria andSubCronCapIsNull() {
            addCriterion("sub_cron_cap is null");
            return (Criteria) this;
        }

        public Criteria andSubCronCapIsNotNull() {
            addCriterion("sub_cron_cap is not null");
            return (Criteria) this;
        }

        public Criteria andSubCronCapEqualTo(Double value) {
            addCriterion("sub_cron_cap =", value, "subCronCap");
            return (Criteria) this;
        }

        public Criteria andSubCronCapNotEqualTo(Double value) {
            addCriterion("sub_cron_cap <>", value, "subCronCap");
            return (Criteria) this;
        }

        public Criteria andSubCronCapGreaterThan(Double value) {
            addCriterion("sub_cron_cap >", value, "subCronCap");
            return (Criteria) this;
        }

        public Criteria andSubCronCapGreaterThanOrEqualTo(Double value) {
            addCriterion("sub_cron_cap >=", value, "subCronCap");
            return (Criteria) this;
        }

        public Criteria andSubCronCapLessThan(Double value) {
            addCriterion("sub_cron_cap <", value, "subCronCap");
            return (Criteria) this;
        }

        public Criteria andSubCronCapLessThanOrEqualTo(Double value) {
            addCriterion("sub_cron_cap <=", value, "subCronCap");
            return (Criteria) this;
        }

        public Criteria andSubCronCapIn(List<Double> values) {
            addCriterion("sub_cron_cap in", values, "subCronCap");
            return (Criteria) this;
        }

        public Criteria andSubCronCapNotIn(List<Double> values) {
            addCriterion("sub_cron_cap not in", values, "subCronCap");
            return (Criteria) this;
        }

        public Criteria andSubCronCapBetween(Double value1, Double value2) {
            addCriterion("sub_cron_cap between", value1, value2, "subCronCap");
            return (Criteria) this;
        }

        public Criteria andSubCronCapNotBetween(Double value1, Double value2) {
            addCriterion("sub_cron_cap not between", value1, value2, "subCronCap");
            return (Criteria) this;
        }

        public Criteria andSubCronDateIsNull() {
            addCriterion("sub_cron_date is null");
            return (Criteria) this;
        }

        public Criteria andSubCronDateIsNotNull() {
            addCriterion("sub_cron_date is not null");
            return (Criteria) this;
        }

        public Criteria andSubCronDateEqualTo(Date value) {
            addCriterion("sub_cron_date =", value, "subCronDate");
            return (Criteria) this;
        }

        public Criteria andSubCronDateNotEqualTo(Date value) {
            addCriterion("sub_cron_date <>", value, "subCronDate");
            return (Criteria) this;
        }

        public Criteria andSubCronDateGreaterThan(Date value) {
            addCriterion("sub_cron_date >", value, "subCronDate");
            return (Criteria) this;
        }

        public Criteria andSubCronDateGreaterThanOrEqualTo(Date value) {
            addCriterion("sub_cron_date >=", value, "subCronDate");
            return (Criteria) this;
        }

        public Criteria andSubCronDateLessThan(Date value) {
            addCriterion("sub_cron_date <", value, "subCronDate");
            return (Criteria) this;
        }

        public Criteria andSubCronDateLessThanOrEqualTo(Date value) {
            addCriterion("sub_cron_date <=", value, "subCronDate");
            return (Criteria) this;
        }

        public Criteria andSubCronDateIn(List<Date> values) {
            addCriterion("sub_cron_date in", values, "subCronDate");
            return (Criteria) this;
        }

        public Criteria andSubCronDateNotIn(List<Date> values) {
            addCriterion("sub_cron_date not in", values, "subCronDate");
            return (Criteria) this;
        }

        public Criteria andSubCronDateBetween(Date value1, Date value2) {
            addCriterion("sub_cron_date between", value1, value2, "subCronDate");
            return (Criteria) this;
        }

        public Criteria andSubCronDateNotBetween(Date value1, Date value2) {
            addCriterion("sub_cron_date not between", value1, value2, "subCronDate");
            return (Criteria) this;
        }

        public Criteria andSubCronFromIsNull() {
            addCriterion("sub_cron_from is null");
            return (Criteria) this;
        }

        public Criteria andSubCronFromIsNotNull() {
            addCriterion("sub_cron_from is not null");
            return (Criteria) this;
        }

        public Criteria andSubCronFromEqualTo(String value) {
            addCriterion("sub_cron_from =", value, "subCronFrom");
            return (Criteria) this;
        }

        public Criteria andSubCronFromNotEqualTo(String value) {
            addCriterion("sub_cron_from <>", value, "subCronFrom");
            return (Criteria) this;
        }

        public Criteria andSubCronFromGreaterThan(String value) {
            addCriterion("sub_cron_from >", value, "subCronFrom");
            return (Criteria) this;
        }

        public Criteria andSubCronFromGreaterThanOrEqualTo(String value) {
            addCriterion("sub_cron_from >=", value, "subCronFrom");
            return (Criteria) this;
        }

        public Criteria andSubCronFromLessThan(String value) {
            addCriterion("sub_cron_from <", value, "subCronFrom");
            return (Criteria) this;
        }

        public Criteria andSubCronFromLessThanOrEqualTo(String value) {
            addCriterion("sub_cron_from <=", value, "subCronFrom");
            return (Criteria) this;
        }

        public Criteria andSubCronFromLike(String value) {
            addCriterion("sub_cron_from like", value, "subCronFrom");
            return (Criteria) this;
        }

        public Criteria andSubCronFromNotLike(String value) {
            addCriterion("sub_cron_from not like", value, "subCronFrom");
            return (Criteria) this;
        }

        public Criteria andSubCronFromIn(List<String> values) {
            addCriterion("sub_cron_from in", values, "subCronFrom");
            return (Criteria) this;
        }

        public Criteria andSubCronFromNotIn(List<String> values) {
            addCriterion("sub_cron_from not in", values, "subCronFrom");
            return (Criteria) this;
        }

        public Criteria andSubCronFromBetween(String value1, String value2) {
            addCriterion("sub_cron_from between", value1, value2, "subCronFrom");
            return (Criteria) this;
        }

        public Criteria andSubCronFromNotBetween(String value1, String value2) {
            addCriterion("sub_cron_from not between", value1, value2, "subCronFrom");
            return (Criteria) this;
        }

        public Criteria andAcCronCapIsNull() {
            addCriterion("ac_cron_cap is null");
            return (Criteria) this;
        }

        public Criteria andAcCronCapIsNotNull() {
            addCriterion("ac_cron_cap is not null");
            return (Criteria) this;
        }

        public Criteria andAcCronCapEqualTo(Double value) {
            addCriterion("ac_cron_cap =", value, "acCronCap");
            return (Criteria) this;
        }

        public Criteria andAcCronCapNotEqualTo(Double value) {
            addCriterion("ac_cron_cap <>", value, "acCronCap");
            return (Criteria) this;
        }

        public Criteria andAcCronCapGreaterThan(Double value) {
            addCriterion("ac_cron_cap >", value, "acCronCap");
            return (Criteria) this;
        }

        public Criteria andAcCronCapGreaterThanOrEqualTo(Double value) {
            addCriterion("ac_cron_cap >=", value, "acCronCap");
            return (Criteria) this;
        }

        public Criteria andAcCronCapLessThan(Double value) {
            addCriterion("ac_cron_cap <", value, "acCronCap");
            return (Criteria) this;
        }

        public Criteria andAcCronCapLessThanOrEqualTo(Double value) {
            addCriterion("ac_cron_cap <=", value, "acCronCap");
            return (Criteria) this;
        }

        public Criteria andAcCronCapIn(List<Double> values) {
            addCriterion("ac_cron_cap in", values, "acCronCap");
            return (Criteria) this;
        }

        public Criteria andAcCronCapNotIn(List<Double> values) {
            addCriterion("ac_cron_cap not in", values, "acCronCap");
            return (Criteria) this;
        }

        public Criteria andAcCronCapBetween(Double value1, Double value2) {
            addCriterion("ac_cron_cap between", value1, value2, "acCronCap");
            return (Criteria) this;
        }

        public Criteria andAcCronCapNotBetween(Double value1, Double value2) {
            addCriterion("ac_cron_cap not between", value1, value2, "acCronCap");
            return (Criteria) this;
        }

        public Criteria andAcCronDateIsNull() {
            addCriterion("ac_cron_date is null");
            return (Criteria) this;
        }

        public Criteria andAcCronDateIsNotNull() {
            addCriterion("ac_cron_date is not null");
            return (Criteria) this;
        }

        public Criteria andAcCronDateEqualTo(Date value) {
            addCriterion("ac_cron_date =", value, "acCronDate");
            return (Criteria) this;
        }

        public Criteria andAcCronDateNotEqualTo(Date value) {
            addCriterion("ac_cron_date <>", value, "acCronDate");
            return (Criteria) this;
        }

        public Criteria andAcCronDateGreaterThan(Date value) {
            addCriterion("ac_cron_date >", value, "acCronDate");
            return (Criteria) this;
        }

        public Criteria andAcCronDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ac_cron_date >=", value, "acCronDate");
            return (Criteria) this;
        }

        public Criteria andAcCronDateLessThan(Date value) {
            addCriterion("ac_cron_date <", value, "acCronDate");
            return (Criteria) this;
        }

        public Criteria andAcCronDateLessThanOrEqualTo(Date value) {
            addCriterion("ac_cron_date <=", value, "acCronDate");
            return (Criteria) this;
        }

        public Criteria andAcCronDateIn(List<Date> values) {
            addCriterion("ac_cron_date in", values, "acCronDate");
            return (Criteria) this;
        }

        public Criteria andAcCronDateNotIn(List<Date> values) {
            addCriterion("ac_cron_date not in", values, "acCronDate");
            return (Criteria) this;
        }

        public Criteria andAcCronDateBetween(Date value1, Date value2) {
            addCriterion("ac_cron_date between", value1, value2, "acCronDate");
            return (Criteria) this;
        }

        public Criteria andAcCronDateNotBetween(Date value1, Date value2) {
            addCriterion("ac_cron_date not between", value1, value2, "acCronDate");
            return (Criteria) this;
        }

        public Criteria andAcCronFromIsNull() {
            addCriterion("ac_cron_from is null");
            return (Criteria) this;
        }

        public Criteria andAcCronFromIsNotNull() {
            addCriterion("ac_cron_from is not null");
            return (Criteria) this;
        }

        public Criteria andAcCronFromEqualTo(String value) {
            addCriterion("ac_cron_from =", value, "acCronFrom");
            return (Criteria) this;
        }

        public Criteria andAcCronFromNotEqualTo(String value) {
            addCriterion("ac_cron_from <>", value, "acCronFrom");
            return (Criteria) this;
        }

        public Criteria andAcCronFromGreaterThan(String value) {
            addCriterion("ac_cron_from >", value, "acCronFrom");
            return (Criteria) this;
        }

        public Criteria andAcCronFromGreaterThanOrEqualTo(String value) {
            addCriterion("ac_cron_from >=", value, "acCronFrom");
            return (Criteria) this;
        }

        public Criteria andAcCronFromLessThan(String value) {
            addCriterion("ac_cron_from <", value, "acCronFrom");
            return (Criteria) this;
        }

        public Criteria andAcCronFromLessThanOrEqualTo(String value) {
            addCriterion("ac_cron_from <=", value, "acCronFrom");
            return (Criteria) this;
        }

        public Criteria andAcCronFromLike(String value) {
            addCriterion("ac_cron_from like", value, "acCronFrom");
            return (Criteria) this;
        }

        public Criteria andAcCronFromNotLike(String value) {
            addCriterion("ac_cron_from not like", value, "acCronFrom");
            return (Criteria) this;
        }

        public Criteria andAcCronFromIn(List<String> values) {
            addCriterion("ac_cron_from in", values, "acCronFrom");
            return (Criteria) this;
        }

        public Criteria andAcCronFromNotIn(List<String> values) {
            addCriterion("ac_cron_from not in", values, "acCronFrom");
            return (Criteria) this;
        }

        public Criteria andAcCronFromBetween(String value1, String value2) {
            addCriterion("ac_cron_from between", value1, value2, "acCronFrom");
            return (Criteria) this;
        }

        public Criteria andAcCronFromNotBetween(String value1, String value2) {
            addCriterion("ac_cron_from not between", value1, value2, "acCronFrom");
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