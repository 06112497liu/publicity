package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnnualBaseCmpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnnualBaseCmpExample() {
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

        public Criteria andRegnoIsNull() {
            addCriterion("regno is null");
            return (Criteria) this;
        }

        public Criteria andRegnoIsNotNull() {
            addCriterion("regno is not null");
            return (Criteria) this;
        }

        public Criteria andRegnoEqualTo(String value) {
            addCriterion("regno =", value, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoNotEqualTo(String value) {
            addCriterion("regno <>", value, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoGreaterThan(String value) {
            addCriterion("regno >", value, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoGreaterThanOrEqualTo(String value) {
            addCriterion("regno >=", value, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoLessThan(String value) {
            addCriterion("regno <", value, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoLessThanOrEqualTo(String value) {
            addCriterion("regno <=", value, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoLike(String value) {
            addCriterion("regno like", value, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoNotLike(String value) {
            addCriterion("regno not like", value, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoIn(List<String> values) {
            addCriterion("regno in", values, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoNotIn(List<String> values) {
            addCriterion("regno not in", values, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoBetween(String value1, String value2) {
            addCriterion("regno between", value1, value2, "regno");
            return (Criteria) this;
        }

        public Criteria andRegnoNotBetween(String value1, String value2) {
            addCriterion("regno not between", value1, value2, "regno");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNull() {
            addCriterion("credit_code is null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNotNull() {
            addCriterion("credit_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeEqualTo(String value) {
            addCriterion("credit_code =", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotEqualTo(String value) {
            addCriterion("credit_code <>", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThan(String value) {
            addCriterion("credit_code >", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("credit_code >=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThan(String value) {
            addCriterion("credit_code <", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("credit_code <=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLike(String value) {
            addCriterion("credit_code like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotLike(String value) {
            addCriterion("credit_code not like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIn(List<String> values) {
            addCriterion("credit_code in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotIn(List<String> values) {
            addCriterion("credit_code not in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeBetween(String value1, String value2) {
            addCriterion("credit_code between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotBetween(String value1, String value2) {
            addCriterion("credit_code not between", value1, value2, "creditCode");
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andAnnualDateIsNull() {
            addCriterion("annual_date is null");
            return (Criteria) this;
        }

        public Criteria andAnnualDateIsNotNull() {
            addCriterion("annual_date is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualDateEqualTo(Date value) {
            addCriterion("annual_date =", value, "annualDate");
            return (Criteria) this;
        }

        public Criteria andAnnualDateNotEqualTo(Date value) {
            addCriterion("annual_date <>", value, "annualDate");
            return (Criteria) this;
        }

        public Criteria andAnnualDateGreaterThan(Date value) {
            addCriterion("annual_date >", value, "annualDate");
            return (Criteria) this;
        }

        public Criteria andAnnualDateGreaterThanOrEqualTo(Date value) {
            addCriterion("annual_date >=", value, "annualDate");
            return (Criteria) this;
        }

        public Criteria andAnnualDateLessThan(Date value) {
            addCriterion("annual_date <", value, "annualDate");
            return (Criteria) this;
        }

        public Criteria andAnnualDateLessThanOrEqualTo(Date value) {
            addCriterion("annual_date <=", value, "annualDate");
            return (Criteria) this;
        }

        public Criteria andAnnualDateIn(List<Date> values) {
            addCriterion("annual_date in", values, "annualDate");
            return (Criteria) this;
        }

        public Criteria andAnnualDateNotIn(List<Date> values) {
            addCriterion("annual_date not in", values, "annualDate");
            return (Criteria) this;
        }

        public Criteria andAnnualDateBetween(Date value1, Date value2) {
            addCriterion("annual_date between", value1, value2, "annualDate");
            return (Criteria) this;
        }

        public Criteria andAnnualDateNotBetween(Date value1, Date value2) {
            addCriterion("annual_date not between", value1, value2, "annualDate");
            return (Criteria) this;
        }

        public Criteria andAnnualYearIsNull() {
            addCriterion("annual_year is null");
            return (Criteria) this;
        }

        public Criteria andAnnualYearIsNotNull() {
            addCriterion("annual_year is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualYearEqualTo(String value) {
            addCriterion("annual_year =", value, "annualYear");
            return (Criteria) this;
        }

        public Criteria andAnnualYearNotEqualTo(String value) {
            addCriterion("annual_year <>", value, "annualYear");
            return (Criteria) this;
        }

        public Criteria andAnnualYearGreaterThan(String value) {
            addCriterion("annual_year >", value, "annualYear");
            return (Criteria) this;
        }

        public Criteria andAnnualYearGreaterThanOrEqualTo(String value) {
            addCriterion("annual_year >=", value, "annualYear");
            return (Criteria) this;
        }

        public Criteria andAnnualYearLessThan(String value) {
            addCriterion("annual_year <", value, "annualYear");
            return (Criteria) this;
        }

        public Criteria andAnnualYearLessThanOrEqualTo(String value) {
            addCriterion("annual_year <=", value, "annualYear");
            return (Criteria) this;
        }

        public Criteria andAnnualYearLike(String value) {
            addCriterion("annual_year like", value, "annualYear");
            return (Criteria) this;
        }

        public Criteria andAnnualYearNotLike(String value) {
            addCriterion("annual_year not like", value, "annualYear");
            return (Criteria) this;
        }

        public Criteria andAnnualYearIn(List<String> values) {
            addCriterion("annual_year in", values, "annualYear");
            return (Criteria) this;
        }

        public Criteria andAnnualYearNotIn(List<String> values) {
            addCriterion("annual_year not in", values, "annualYear");
            return (Criteria) this;
        }

        public Criteria andAnnualYearBetween(String value1, String value2) {
            addCriterion("annual_year between", value1, value2, "annualYear");
            return (Criteria) this;
        }

        public Criteria andAnnualYearNotBetween(String value1, String value2) {
            addCriterion("annual_year not between", value1, value2, "annualYear");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andPostalCodeIsNull() {
            addCriterion("postal_code is null");
            return (Criteria) this;
        }

        public Criteria andPostalCodeIsNotNull() {
            addCriterion("postal_code is not null");
            return (Criteria) this;
        }

        public Criteria andPostalCodeEqualTo(String value) {
            addCriterion("postal_code =", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotEqualTo(String value) {
            addCriterion("postal_code <>", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeGreaterThan(String value) {
            addCriterion("postal_code >", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("postal_code >=", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeLessThan(String value) {
            addCriterion("postal_code <", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeLessThanOrEqualTo(String value) {
            addCriterion("postal_code <=", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeLike(String value) {
            addCriterion("postal_code like", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotLike(String value) {
            addCriterion("postal_code not like", value, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeIn(List<String> values) {
            addCriterion("postal_code in", values, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotIn(List<String> values) {
            addCriterion("postal_code not in", values, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeBetween(String value1, String value2) {
            addCriterion("postal_code between", value1, value2, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPostalCodeNotBetween(String value1, String value2) {
            addCriterion("postal_code not between", value1, value2, "postalCode");
            return (Criteria) this;
        }

        public Criteria andPhonesIsNull() {
            addCriterion("phones is null");
            return (Criteria) this;
        }

        public Criteria andPhonesIsNotNull() {
            addCriterion("phones is not null");
            return (Criteria) this;
        }

        public Criteria andPhonesEqualTo(String value) {
            addCriterion("phones =", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesNotEqualTo(String value) {
            addCriterion("phones <>", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesGreaterThan(String value) {
            addCriterion("phones >", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesGreaterThanOrEqualTo(String value) {
            addCriterion("phones >=", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesLessThan(String value) {
            addCriterion("phones <", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesLessThanOrEqualTo(String value) {
            addCriterion("phones <=", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesLike(String value) {
            addCriterion("phones like", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesNotLike(String value) {
            addCriterion("phones not like", value, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesIn(List<String> values) {
            addCriterion("phones in", values, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesNotIn(List<String> values) {
            addCriterion("phones not in", values, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesBetween(String value1, String value2) {
            addCriterion("phones between", value1, value2, "phones");
            return (Criteria) this;
        }

        public Criteria andPhonesNotBetween(String value1, String value2) {
            addCriterion("phones not between", value1, value2, "phones");
            return (Criteria) this;
        }

        public Criteria andEmailsIsNull() {
            addCriterion("emails is null");
            return (Criteria) this;
        }

        public Criteria andEmailsIsNotNull() {
            addCriterion("emails is not null");
            return (Criteria) this;
        }

        public Criteria andEmailsEqualTo(String value) {
            addCriterion("emails =", value, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsNotEqualTo(String value) {
            addCriterion("emails <>", value, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsGreaterThan(String value) {
            addCriterion("emails >", value, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsGreaterThanOrEqualTo(String value) {
            addCriterion("emails >=", value, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsLessThan(String value) {
            addCriterion("emails <", value, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsLessThanOrEqualTo(String value) {
            addCriterion("emails <=", value, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsLike(String value) {
            addCriterion("emails like", value, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsNotLike(String value) {
            addCriterion("emails not like", value, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsIn(List<String> values) {
            addCriterion("emails in", values, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsNotIn(List<String> values) {
            addCriterion("emails not in", values, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsBetween(String value1, String value2) {
            addCriterion("emails between", value1, value2, "emails");
            return (Criteria) this;
        }

        public Criteria andEmailsNotBetween(String value1, String value2) {
            addCriterion("emails not between", value1, value2, "emails");
            return (Criteria) this;
        }

        public Criteria andEmpnumIsNull() {
            addCriterion("empnum is null");
            return (Criteria) this;
        }

        public Criteria andEmpnumIsNotNull() {
            addCriterion("empnum is not null");
            return (Criteria) this;
        }

        public Criteria andEmpnumEqualTo(Long value) {
            addCriterion("empnum =", value, "empnum");
            return (Criteria) this;
        }

        public Criteria andEmpnumNotEqualTo(Long value) {
            addCriterion("empnum <>", value, "empnum");
            return (Criteria) this;
        }

        public Criteria andEmpnumGreaterThan(Long value) {
            addCriterion("empnum >", value, "empnum");
            return (Criteria) this;
        }

        public Criteria andEmpnumGreaterThanOrEqualTo(Long value) {
            addCriterion("empnum >=", value, "empnum");
            return (Criteria) this;
        }

        public Criteria andEmpnumLessThan(Long value) {
            addCriterion("empnum <", value, "empnum");
            return (Criteria) this;
        }

        public Criteria andEmpnumLessThanOrEqualTo(Long value) {
            addCriterion("empnum <=", value, "empnum");
            return (Criteria) this;
        }

        public Criteria andEmpnumIn(List<Long> values) {
            addCriterion("empnum in", values, "empnum");
            return (Criteria) this;
        }

        public Criteria andEmpnumNotIn(List<Long> values) {
            addCriterion("empnum not in", values, "empnum");
            return (Criteria) this;
        }

        public Criteria andEmpnumBetween(Long value1, Long value2) {
            addCriterion("empnum between", value1, value2, "empnum");
            return (Criteria) this;
        }

        public Criteria andEmpnumNotBetween(Long value1, Long value2) {
            addCriterion("empnum not between", value1, value2, "empnum");
            return (Criteria) this;
        }

        public Criteria andMemnumIsNull() {
            addCriterion("memnum is null");
            return (Criteria) this;
        }

        public Criteria andMemnumIsNotNull() {
            addCriterion("memnum is not null");
            return (Criteria) this;
        }

        public Criteria andMemnumEqualTo(Long value) {
            addCriterion("memnum =", value, "memnum");
            return (Criteria) this;
        }

        public Criteria andMemnumNotEqualTo(Long value) {
            addCriterion("memnum <>", value, "memnum");
            return (Criteria) this;
        }

        public Criteria andMemnumGreaterThan(Long value) {
            addCriterion("memnum >", value, "memnum");
            return (Criteria) this;
        }

        public Criteria andMemnumGreaterThanOrEqualTo(Long value) {
            addCriterion("memnum >=", value, "memnum");
            return (Criteria) this;
        }

        public Criteria andMemnumLessThan(Long value) {
            addCriterion("memnum <", value, "memnum");
            return (Criteria) this;
        }

        public Criteria andMemnumLessThanOrEqualTo(Long value) {
            addCriterion("memnum <=", value, "memnum");
            return (Criteria) this;
        }

        public Criteria andMemnumIn(List<Long> values) {
            addCriterion("memnum in", values, "memnum");
            return (Criteria) this;
        }

        public Criteria andMemnumNotIn(List<Long> values) {
            addCriterion("memnum not in", values, "memnum");
            return (Criteria) this;
        }

        public Criteria andMemnumBetween(Long value1, Long value2) {
            addCriterion("memnum between", value1, value2, "memnum");
            return (Criteria) this;
        }

        public Criteria andMemnumNotBetween(Long value1, Long value2) {
            addCriterion("memnum not between", value1, value2, "memnum");
            return (Criteria) this;
        }

        public Criteria andOpstateIsNull() {
            addCriterion("opstate is null");
            return (Criteria) this;
        }

        public Criteria andOpstateIsNotNull() {
            addCriterion("opstate is not null");
            return (Criteria) this;
        }

        public Criteria andOpstateEqualTo(String value) {
            addCriterion("opstate =", value, "opstate");
            return (Criteria) this;
        }

        public Criteria andOpstateNotEqualTo(String value) {
            addCriterion("opstate <>", value, "opstate");
            return (Criteria) this;
        }

        public Criteria andOpstateGreaterThan(String value) {
            addCriterion("opstate >", value, "opstate");
            return (Criteria) this;
        }

        public Criteria andOpstateGreaterThanOrEqualTo(String value) {
            addCriterion("opstate >=", value, "opstate");
            return (Criteria) this;
        }

        public Criteria andOpstateLessThan(String value) {
            addCriterion("opstate <", value, "opstate");
            return (Criteria) this;
        }

        public Criteria andOpstateLessThanOrEqualTo(String value) {
            addCriterion("opstate <=", value, "opstate");
            return (Criteria) this;
        }

        public Criteria andOpstateLike(String value) {
            addCriterion("opstate like", value, "opstate");
            return (Criteria) this;
        }

        public Criteria andOpstateNotLike(String value) {
            addCriterion("opstate not like", value, "opstate");
            return (Criteria) this;
        }

        public Criteria andOpstateIn(List<String> values) {
            addCriterion("opstate in", values, "opstate");
            return (Criteria) this;
        }

        public Criteria andOpstateNotIn(List<String> values) {
            addCriterion("opstate not in", values, "opstate");
            return (Criteria) this;
        }

        public Criteria andOpstateBetween(String value1, String value2) {
            addCriterion("opstate between", value1, value2, "opstate");
            return (Criteria) this;
        }

        public Criteria andOpstateNotBetween(String value1, String value2) {
            addCriterion("opstate not between", value1, value2, "opstate");
            return (Criteria) this;
        }

        public Criteria andOpNameIsNull() {
            addCriterion("op_name is null");
            return (Criteria) this;
        }

        public Criteria andOpNameIsNotNull() {
            addCriterion("op_name is not null");
            return (Criteria) this;
        }

        public Criteria andOpNameEqualTo(String value) {
            addCriterion("op_name =", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameNotEqualTo(String value) {
            addCriterion("op_name <>", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameGreaterThan(String value) {
            addCriterion("op_name >", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameGreaterThanOrEqualTo(String value) {
            addCriterion("op_name >=", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameLessThan(String value) {
            addCriterion("op_name <", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameLessThanOrEqualTo(String value) {
            addCriterion("op_name <=", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameLike(String value) {
            addCriterion("op_name like", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameNotLike(String value) {
            addCriterion("op_name not like", value, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameIn(List<String> values) {
            addCriterion("op_name in", values, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameNotIn(List<String> values) {
            addCriterion("op_name not in", values, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameBetween(String value1, String value2) {
            addCriterion("op_name between", value1, value2, "opName");
            return (Criteria) this;
        }

        public Criteria andOpNameNotBetween(String value1, String value2) {
            addCriterion("op_name not between", value1, value2, "opName");
            return (Criteria) this;
        }

        public Criteria andAmountMonIsNull() {
            addCriterion("amount_mon is null");
            return (Criteria) this;
        }

        public Criteria andAmountMonIsNotNull() {
            addCriterion("amount_mon is not null");
            return (Criteria) this;
        }

        public Criteria andAmountMonEqualTo(Double value) {
            addCriterion("amount_mon =", value, "amountMon");
            return (Criteria) this;
        }

        public Criteria andAmountMonNotEqualTo(Double value) {
            addCriterion("amount_mon <>", value, "amountMon");
            return (Criteria) this;
        }

        public Criteria andAmountMonGreaterThan(Double value) {
            addCriterion("amount_mon >", value, "amountMon");
            return (Criteria) this;
        }

        public Criteria andAmountMonGreaterThanOrEqualTo(Double value) {
            addCriterion("amount_mon >=", value, "amountMon");
            return (Criteria) this;
        }

        public Criteria andAmountMonLessThan(Double value) {
            addCriterion("amount_mon <", value, "amountMon");
            return (Criteria) this;
        }

        public Criteria andAmountMonLessThanOrEqualTo(Double value) {
            addCriterion("amount_mon <=", value, "amountMon");
            return (Criteria) this;
        }

        public Criteria andAmountMonIn(List<Double> values) {
            addCriterion("amount_mon in", values, "amountMon");
            return (Criteria) this;
        }

        public Criteria andAmountMonNotIn(List<Double> values) {
            addCriterion("amount_mon not in", values, "amountMon");
            return (Criteria) this;
        }

        public Criteria andAmountMonBetween(Double value1, Double value2) {
            addCriterion("amount_mon between", value1, value2, "amountMon");
            return (Criteria) this;
        }

        public Criteria andAmountMonNotBetween(Double value1, Double value2) {
            addCriterion("amount_mon not between", value1, value2, "amountMon");
            return (Criteria) this;
        }

        public Criteria andHoldingsIsNull() {
            addCriterion("holdings is null");
            return (Criteria) this;
        }

        public Criteria andHoldingsIsNotNull() {
            addCriterion("holdings is not null");
            return (Criteria) this;
        }

        public Criteria andHoldingsEqualTo(String value) {
            addCriterion("holdings =", value, "holdings");
            return (Criteria) this;
        }

        public Criteria andHoldingsNotEqualTo(String value) {
            addCriterion("holdings <>", value, "holdings");
            return (Criteria) this;
        }

        public Criteria andHoldingsGreaterThan(String value) {
            addCriterion("holdings >", value, "holdings");
            return (Criteria) this;
        }

        public Criteria andHoldingsGreaterThanOrEqualTo(String value) {
            addCriterion("holdings >=", value, "holdings");
            return (Criteria) this;
        }

        public Criteria andHoldingsLessThan(String value) {
            addCriterion("holdings <", value, "holdings");
            return (Criteria) this;
        }

        public Criteria andHoldingsLessThanOrEqualTo(String value) {
            addCriterion("holdings <=", value, "holdings");
            return (Criteria) this;
        }

        public Criteria andHoldingsLike(String value) {
            addCriterion("holdings like", value, "holdings");
            return (Criteria) this;
        }

        public Criteria andHoldingsNotLike(String value) {
            addCriterion("holdings not like", value, "holdings");
            return (Criteria) this;
        }

        public Criteria andHoldingsIn(List<String> values) {
            addCriterion("holdings in", values, "holdings");
            return (Criteria) this;
        }

        public Criteria andHoldingsNotIn(List<String> values) {
            addCriterion("holdings not in", values, "holdings");
            return (Criteria) this;
        }

        public Criteria andHoldingsBetween(String value1, String value2) {
            addCriterion("holdings between", value1, value2, "holdings");
            return (Criteria) this;
        }

        public Criteria andHoldingsNotBetween(String value1, String value2) {
            addCriterion("holdings not between", value1, value2, "holdings");
            return (Criteria) this;
        }

        public Criteria andOpActivityIsNull() {
            addCriterion("op_activity is null");
            return (Criteria) this;
        }

        public Criteria andOpActivityIsNotNull() {
            addCriterion("op_activity is not null");
            return (Criteria) this;
        }

        public Criteria andOpActivityEqualTo(String value) {
            addCriterion("op_activity =", value, "opActivity");
            return (Criteria) this;
        }

        public Criteria andOpActivityNotEqualTo(String value) {
            addCriterion("op_activity <>", value, "opActivity");
            return (Criteria) this;
        }

        public Criteria andOpActivityGreaterThan(String value) {
            addCriterion("op_activity >", value, "opActivity");
            return (Criteria) this;
        }

        public Criteria andOpActivityGreaterThanOrEqualTo(String value) {
            addCriterion("op_activity >=", value, "opActivity");
            return (Criteria) this;
        }

        public Criteria andOpActivityLessThan(String value) {
            addCriterion("op_activity <", value, "opActivity");
            return (Criteria) this;
        }

        public Criteria andOpActivityLessThanOrEqualTo(String value) {
            addCriterion("op_activity <=", value, "opActivity");
            return (Criteria) this;
        }

        public Criteria andOpActivityLike(String value) {
            addCriterion("op_activity like", value, "opActivity");
            return (Criteria) this;
        }

        public Criteria andOpActivityNotLike(String value) {
            addCriterion("op_activity not like", value, "opActivity");
            return (Criteria) this;
        }

        public Criteria andOpActivityIn(List<String> values) {
            addCriterion("op_activity in", values, "opActivity");
            return (Criteria) this;
        }

        public Criteria andOpActivityNotIn(List<String> values) {
            addCriterion("op_activity not in", values, "opActivity");
            return (Criteria) this;
        }

        public Criteria andOpActivityBetween(String value1, String value2) {
            addCriterion("op_activity between", value1, value2, "opActivity");
            return (Criteria) this;
        }

        public Criteria andOpActivityNotBetween(String value1, String value2) {
            addCriterion("op_activity not between", value1, value2, "opActivity");
            return (Criteria) this;
        }

        public Criteria andWomenNumIsNull() {
            addCriterion("women_num is null");
            return (Criteria) this;
        }

        public Criteria andWomenNumIsNotNull() {
            addCriterion("women_num is not null");
            return (Criteria) this;
        }

        public Criteria andWomenNumEqualTo(Integer value) {
            addCriterion("women_num =", value, "womenNum");
            return (Criteria) this;
        }

        public Criteria andWomenNumNotEqualTo(Integer value) {
            addCriterion("women_num <>", value, "womenNum");
            return (Criteria) this;
        }

        public Criteria andWomenNumGreaterThan(Integer value) {
            addCriterion("women_num >", value, "womenNum");
            return (Criteria) this;
        }

        public Criteria andWomenNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("women_num >=", value, "womenNum");
            return (Criteria) this;
        }

        public Criteria andWomenNumLessThan(Integer value) {
            addCriterion("women_num <", value, "womenNum");
            return (Criteria) this;
        }

        public Criteria andWomenNumLessThanOrEqualTo(Integer value) {
            addCriterion("women_num <=", value, "womenNum");
            return (Criteria) this;
        }

        public Criteria andWomenNumIn(List<Integer> values) {
            addCriterion("women_num in", values, "womenNum");
            return (Criteria) this;
        }

        public Criteria andWomenNumNotIn(List<Integer> values) {
            addCriterion("women_num not in", values, "womenNum");
            return (Criteria) this;
        }

        public Criteria andWomenNumBetween(Integer value1, Integer value2) {
            addCriterion("women_num between", value1, value2, "womenNum");
            return (Criteria) this;
        }

        public Criteria andWomenNumNotBetween(Integer value1, Integer value2) {
            addCriterion("women_num not between", value1, value2, "womenNum");
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