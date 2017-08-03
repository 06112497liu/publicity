package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyExItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyExItemExample() {
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

        public Criteria andCompanyPropertyIsNull() {
            addCriterion("company_property is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyIsNotNull() {
            addCriterion("company_property is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyEqualTo(Integer value) {
            addCriterion("company_property =", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyNotEqualTo(Integer value) {
            addCriterion("company_property <>", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyGreaterThan(Integer value) {
            addCriterion("company_property >", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_property >=", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyLessThan(Integer value) {
            addCriterion("company_property <", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyLessThanOrEqualTo(Integer value) {
            addCriterion("company_property <=", value, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyIn(List<Integer> values) {
            addCriterion("company_property in", values, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyNotIn(List<Integer> values) {
            addCriterion("company_property not in", values, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyBetween(Integer value1, Integer value2) {
            addCriterion("company_property between", value1, value2, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyPropertyNotBetween(Integer value1, Integer value2) {
            addCriterion("company_property not between", value1, value2, "companyProperty");
            return (Criteria) this;
        }

        public Criteria andAnnualNumIsNull() {
            addCriterion("annual_num is null");
            return (Criteria) this;
        }

        public Criteria andAnnualNumIsNotNull() {
            addCriterion("annual_num is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualNumEqualTo(Integer value) {
            addCriterion("annual_num =", value, "annualNum");
            return (Criteria) this;
        }

        public Criteria andAnnualNumNotEqualTo(Integer value) {
            addCriterion("annual_num <>", value, "annualNum");
            return (Criteria) this;
        }

        public Criteria andAnnualNumGreaterThan(Integer value) {
            addCriterion("annual_num >", value, "annualNum");
            return (Criteria) this;
        }

        public Criteria andAnnualNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("annual_num >=", value, "annualNum");
            return (Criteria) this;
        }

        public Criteria andAnnualNumLessThan(Integer value) {
            addCriterion("annual_num <", value, "annualNum");
            return (Criteria) this;
        }

        public Criteria andAnnualNumLessThanOrEqualTo(Integer value) {
            addCriterion("annual_num <=", value, "annualNum");
            return (Criteria) this;
        }

        public Criteria andAnnualNumIn(List<Integer> values) {
            addCriterion("annual_num in", values, "annualNum");
            return (Criteria) this;
        }

        public Criteria andAnnualNumNotIn(List<Integer> values) {
            addCriterion("annual_num not in", values, "annualNum");
            return (Criteria) this;
        }

        public Criteria andAnnualNumBetween(Integer value1, Integer value2) {
            addCriterion("annual_num between", value1, value2, "annualNum");
            return (Criteria) this;
        }

        public Criteria andAnnualNumNotBetween(Integer value1, Integer value2) {
            addCriterion("annual_num not between", value1, value2, "annualNum");
            return (Criteria) this;
        }

        public Criteria andInstantlyNumIsNull() {
            addCriterion("instantly_num is null");
            return (Criteria) this;
        }

        public Criteria andInstantlyNumIsNotNull() {
            addCriterion("instantly_num is not null");
            return (Criteria) this;
        }

        public Criteria andInstantlyNumEqualTo(Integer value) {
            addCriterion("instantly_num =", value, "instantlyNum");
            return (Criteria) this;
        }

        public Criteria andInstantlyNumNotEqualTo(Integer value) {
            addCriterion("instantly_num <>", value, "instantlyNum");
            return (Criteria) this;
        }

        public Criteria andInstantlyNumGreaterThan(Integer value) {
            addCriterion("instantly_num >", value, "instantlyNum");
            return (Criteria) this;
        }

        public Criteria andInstantlyNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("instantly_num >=", value, "instantlyNum");
            return (Criteria) this;
        }

        public Criteria andInstantlyNumLessThan(Integer value) {
            addCriterion("instantly_num <", value, "instantlyNum");
            return (Criteria) this;
        }

        public Criteria andInstantlyNumLessThanOrEqualTo(Integer value) {
            addCriterion("instantly_num <=", value, "instantlyNum");
            return (Criteria) this;
        }

        public Criteria andInstantlyNumIn(List<Integer> values) {
            addCriterion("instantly_num in", values, "instantlyNum");
            return (Criteria) this;
        }

        public Criteria andInstantlyNumNotIn(List<Integer> values) {
            addCriterion("instantly_num not in", values, "instantlyNum");
            return (Criteria) this;
        }

        public Criteria andInstantlyNumBetween(Integer value1, Integer value2) {
            addCriterion("instantly_num between", value1, value2, "instantlyNum");
            return (Criteria) this;
        }

        public Criteria andInstantlyNumNotBetween(Integer value1, Integer value2) {
            addCriterion("instantly_num not between", value1, value2, "instantlyNum");
            return (Criteria) this;
        }

        public Criteria andAnnualExTypesIsNull() {
            addCriterion("annual_ex_types is null");
            return (Criteria) this;
        }

        public Criteria andAnnualExTypesIsNotNull() {
            addCriterion("annual_ex_types is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualExTypesEqualTo(Integer value) {
            addCriterion("annual_ex_types =", value, "annualExTypes");
            return (Criteria) this;
        }

        public Criteria andAnnualExTypesNotEqualTo(Integer value) {
            addCriterion("annual_ex_types <>", value, "annualExTypes");
            return (Criteria) this;
        }

        public Criteria andAnnualExTypesGreaterThan(Integer value) {
            addCriterion("annual_ex_types >", value, "annualExTypes");
            return (Criteria) this;
        }

        public Criteria andAnnualExTypesGreaterThanOrEqualTo(Integer value) {
            addCriterion("annual_ex_types >=", value, "annualExTypes");
            return (Criteria) this;
        }

        public Criteria andAnnualExTypesLessThan(Integer value) {
            addCriterion("annual_ex_types <", value, "annualExTypes");
            return (Criteria) this;
        }

        public Criteria andAnnualExTypesLessThanOrEqualTo(Integer value) {
            addCriterion("annual_ex_types <=", value, "annualExTypes");
            return (Criteria) this;
        }

        public Criteria andAnnualExTypesIn(List<Integer> values) {
            addCriterion("annual_ex_types in", values, "annualExTypes");
            return (Criteria) this;
        }

        public Criteria andAnnualExTypesNotIn(List<Integer> values) {
            addCriterion("annual_ex_types not in", values, "annualExTypes");
            return (Criteria) this;
        }

        public Criteria andAnnualExTypesBetween(Integer value1, Integer value2) {
            addCriterion("annual_ex_types between", value1, value2, "annualExTypes");
            return (Criteria) this;
        }

        public Criteria andAnnualExTypesNotBetween(Integer value1, Integer value2) {
            addCriterion("annual_ex_types not between", value1, value2, "annualExTypes");
            return (Criteria) this;
        }

        public Criteria andInsExTypesIsNull() {
            addCriterion("ins_ex_types is null");
            return (Criteria) this;
        }

        public Criteria andInsExTypesIsNotNull() {
            addCriterion("ins_ex_types is not null");
            return (Criteria) this;
        }

        public Criteria andInsExTypesEqualTo(Integer value) {
            addCriterion("ins_ex_types =", value, "insExTypes");
            return (Criteria) this;
        }

        public Criteria andInsExTypesNotEqualTo(Integer value) {
            addCriterion("ins_ex_types <>", value, "insExTypes");
            return (Criteria) this;
        }

        public Criteria andInsExTypesGreaterThan(Integer value) {
            addCriterion("ins_ex_types >", value, "insExTypes");
            return (Criteria) this;
        }

        public Criteria andInsExTypesGreaterThanOrEqualTo(Integer value) {
            addCriterion("ins_ex_types >=", value, "insExTypes");
            return (Criteria) this;
        }

        public Criteria andInsExTypesLessThan(Integer value) {
            addCriterion("ins_ex_types <", value, "insExTypes");
            return (Criteria) this;
        }

        public Criteria andInsExTypesLessThanOrEqualTo(Integer value) {
            addCriterion("ins_ex_types <=", value, "insExTypes");
            return (Criteria) this;
        }

        public Criteria andInsExTypesIn(List<Integer> values) {
            addCriterion("ins_ex_types in", values, "insExTypes");
            return (Criteria) this;
        }

        public Criteria andInsExTypesNotIn(List<Integer> values) {
            addCriterion("ins_ex_types not in", values, "insExTypes");
            return (Criteria) this;
        }

        public Criteria andInsExTypesBetween(Integer value1, Integer value2) {
            addCriterion("ins_ex_types between", value1, value2, "insExTypes");
            return (Criteria) this;
        }

        public Criteria andInsExTypesNotBetween(Integer value1, Integer value2) {
            addCriterion("ins_ex_types not between", value1, value2, "insExTypes");
            return (Criteria) this;
        }

        public Criteria andAnnualExModulesIsNull() {
            addCriterion("annual_ex_modules is null");
            return (Criteria) this;
        }

        public Criteria andAnnualExModulesIsNotNull() {
            addCriterion("annual_ex_modules is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualExModulesEqualTo(Integer value) {
            addCriterion("annual_ex_modules =", value, "annualExModules");
            return (Criteria) this;
        }

        public Criteria andAnnualExModulesNotEqualTo(Integer value) {
            addCriterion("annual_ex_modules <>", value, "annualExModules");
            return (Criteria) this;
        }

        public Criteria andAnnualExModulesGreaterThan(Integer value) {
            addCriterion("annual_ex_modules >", value, "annualExModules");
            return (Criteria) this;
        }

        public Criteria andAnnualExModulesGreaterThanOrEqualTo(Integer value) {
            addCriterion("annual_ex_modules >=", value, "annualExModules");
            return (Criteria) this;
        }

        public Criteria andAnnualExModulesLessThan(Integer value) {
            addCriterion("annual_ex_modules <", value, "annualExModules");
            return (Criteria) this;
        }

        public Criteria andAnnualExModulesLessThanOrEqualTo(Integer value) {
            addCriterion("annual_ex_modules <=", value, "annualExModules");
            return (Criteria) this;
        }

        public Criteria andAnnualExModulesIn(List<Integer> values) {
            addCriterion("annual_ex_modules in", values, "annualExModules");
            return (Criteria) this;
        }

        public Criteria andAnnualExModulesNotIn(List<Integer> values) {
            addCriterion("annual_ex_modules not in", values, "annualExModules");
            return (Criteria) this;
        }

        public Criteria andAnnualExModulesBetween(Integer value1, Integer value2) {
            addCriterion("annual_ex_modules between", value1, value2, "annualExModules");
            return (Criteria) this;
        }

        public Criteria andAnnualExModulesNotBetween(Integer value1, Integer value2) {
            addCriterion("annual_ex_modules not between", value1, value2, "annualExModules");
            return (Criteria) this;
        }

        public Criteria andInsExModulesIsNull() {
            addCriterion("ins_ex_modules is null");
            return (Criteria) this;
        }

        public Criteria andInsExModulesIsNotNull() {
            addCriterion("ins_ex_modules is not null");
            return (Criteria) this;
        }

        public Criteria andInsExModulesEqualTo(Integer value) {
            addCriterion("ins_ex_modules =", value, "insExModules");
            return (Criteria) this;
        }

        public Criteria andInsExModulesNotEqualTo(Integer value) {
            addCriterion("ins_ex_modules <>", value, "insExModules");
            return (Criteria) this;
        }

        public Criteria andInsExModulesGreaterThan(Integer value) {
            addCriterion("ins_ex_modules >", value, "insExModules");
            return (Criteria) this;
        }

        public Criteria andInsExModulesGreaterThanOrEqualTo(Integer value) {
            addCriterion("ins_ex_modules >=", value, "insExModules");
            return (Criteria) this;
        }

        public Criteria andInsExModulesLessThan(Integer value) {
            addCriterion("ins_ex_modules <", value, "insExModules");
            return (Criteria) this;
        }

        public Criteria andInsExModulesLessThanOrEqualTo(Integer value) {
            addCriterion("ins_ex_modules <=", value, "insExModules");
            return (Criteria) this;
        }

        public Criteria andInsExModulesIn(List<Integer> values) {
            addCriterion("ins_ex_modules in", values, "insExModules");
            return (Criteria) this;
        }

        public Criteria andInsExModulesNotIn(List<Integer> values) {
            addCriterion("ins_ex_modules not in", values, "insExModules");
            return (Criteria) this;
        }

        public Criteria andInsExModulesBetween(Integer value1, Integer value2) {
            addCriterion("ins_ex_modules between", value1, value2, "insExModules");
            return (Criteria) this;
        }

        public Criteria andInsExModulesNotBetween(Integer value1, Integer value2) {
            addCriterion("ins_ex_modules not between", value1, value2, "insExModules");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andAnnualCmpTimeIsNull() {
            addCriterion("annual_cmp_time is null");
            return (Criteria) this;
        }

        public Criteria andAnnualCmpTimeIsNotNull() {
            addCriterion("annual_cmp_time is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualCmpTimeEqualTo(Date value) {
            addCriterion("annual_cmp_time =", value, "annualCmpTime");
            return (Criteria) this;
        }

        public Criteria andAnnualCmpTimeNotEqualTo(Date value) {
            addCriterion("annual_cmp_time <>", value, "annualCmpTime");
            return (Criteria) this;
        }

        public Criteria andAnnualCmpTimeGreaterThan(Date value) {
            addCriterion("annual_cmp_time >", value, "annualCmpTime");
            return (Criteria) this;
        }

        public Criteria andAnnualCmpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("annual_cmp_time >=", value, "annualCmpTime");
            return (Criteria) this;
        }

        public Criteria andAnnualCmpTimeLessThan(Date value) {
            addCriterion("annual_cmp_time <", value, "annualCmpTime");
            return (Criteria) this;
        }

        public Criteria andAnnualCmpTimeLessThanOrEqualTo(Date value) {
            addCriterion("annual_cmp_time <=", value, "annualCmpTime");
            return (Criteria) this;
        }

        public Criteria andAnnualCmpTimeIn(List<Date> values) {
            addCriterion("annual_cmp_time in", values, "annualCmpTime");
            return (Criteria) this;
        }

        public Criteria andAnnualCmpTimeNotIn(List<Date> values) {
            addCriterion("annual_cmp_time not in", values, "annualCmpTime");
            return (Criteria) this;
        }

        public Criteria andAnnualCmpTimeBetween(Date value1, Date value2) {
            addCriterion("annual_cmp_time between", value1, value2, "annualCmpTime");
            return (Criteria) this;
        }

        public Criteria andAnnualCmpTimeNotBetween(Date value1, Date value2) {
            addCriterion("annual_cmp_time not between", value1, value2, "annualCmpTime");
            return (Criteria) this;
        }

        public Criteria andInstantlyCmpTimeIsNull() {
            addCriterion("instantly_cmp_time is null");
            return (Criteria) this;
        }

        public Criteria andInstantlyCmpTimeIsNotNull() {
            addCriterion("instantly_cmp_time is not null");
            return (Criteria) this;
        }

        public Criteria andInstantlyCmpTimeEqualTo(Date value) {
            addCriterion("instantly_cmp_time =", value, "instantlyCmpTime");
            return (Criteria) this;
        }

        public Criteria andInstantlyCmpTimeNotEqualTo(Date value) {
            addCriterion("instantly_cmp_time <>", value, "instantlyCmpTime");
            return (Criteria) this;
        }

        public Criteria andInstantlyCmpTimeGreaterThan(Date value) {
            addCriterion("instantly_cmp_time >", value, "instantlyCmpTime");
            return (Criteria) this;
        }

        public Criteria andInstantlyCmpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("instantly_cmp_time >=", value, "instantlyCmpTime");
            return (Criteria) this;
        }

        public Criteria andInstantlyCmpTimeLessThan(Date value) {
            addCriterion("instantly_cmp_time <", value, "instantlyCmpTime");
            return (Criteria) this;
        }

        public Criteria andInstantlyCmpTimeLessThanOrEqualTo(Date value) {
            addCriterion("instantly_cmp_time <=", value, "instantlyCmpTime");
            return (Criteria) this;
        }

        public Criteria andInstantlyCmpTimeIn(List<Date> values) {
            addCriterion("instantly_cmp_time in", values, "instantlyCmpTime");
            return (Criteria) this;
        }

        public Criteria andInstantlyCmpTimeNotIn(List<Date> values) {
            addCriterion("instantly_cmp_time not in", values, "instantlyCmpTime");
            return (Criteria) this;
        }

        public Criteria andInstantlyCmpTimeBetween(Date value1, Date value2) {
            addCriterion("instantly_cmp_time between", value1, value2, "instantlyCmpTime");
            return (Criteria) this;
        }

        public Criteria andInstantlyCmpTimeNotBetween(Date value1, Date value2) {
            addCriterion("instantly_cmp_time not between", value1, value2, "instantlyCmpTime");
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

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryIsNull() {
            addCriterion("primary_industry is null");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryIsNotNull() {
            addCriterion("primary_industry is not null");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryEqualTo(String value) {
            addCriterion("primary_industry =", value, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryNotEqualTo(String value) {
            addCriterion("primary_industry <>", value, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryGreaterThan(String value) {
            addCriterion("primary_industry >", value, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("primary_industry >=", value, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryLessThan(String value) {
            addCriterion("primary_industry <", value, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryLessThanOrEqualTo(String value) {
            addCriterion("primary_industry <=", value, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryLike(String value) {
            addCriterion("primary_industry like", value, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryNotLike(String value) {
            addCriterion("primary_industry not like", value, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryIn(List<String> values) {
            addCriterion("primary_industry in", values, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryNotIn(List<String> values) {
            addCriterion("primary_industry not in", values, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryBetween(String value1, String value2) {
            addCriterion("primary_industry between", value1, value2, "primaryIndustry");
            return (Criteria) this;
        }

        public Criteria andPrimaryIndustryNotBetween(String value1, String value2) {
            addCriterion("primary_industry not between", value1, value2, "primaryIndustry");
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