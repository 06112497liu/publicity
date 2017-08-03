package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InstantlyExPrevDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InstantlyExPrevDetailExample() {
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

        public Criteria andPropNameIsNull() {
            addCriterion("prop_name is null");
            return (Criteria) this;
        }

        public Criteria andPropNameIsNotNull() {
            addCriterion("prop_name is not null");
            return (Criteria) this;
        }

        public Criteria andPropNameEqualTo(String value) {
            addCriterion("prop_name =", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameNotEqualTo(String value) {
            addCriterion("prop_name <>", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameGreaterThan(String value) {
            addCriterion("prop_name >", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameGreaterThanOrEqualTo(String value) {
            addCriterion("prop_name >=", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameLessThan(String value) {
            addCriterion("prop_name <", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameLessThanOrEqualTo(String value) {
            addCriterion("prop_name <=", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameLike(String value) {
            addCriterion("prop_name like", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameNotLike(String value) {
            addCriterion("prop_name not like", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameIn(List<String> values) {
            addCriterion("prop_name in", values, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameNotIn(List<String> values) {
            addCriterion("prop_name not in", values, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameBetween(String value1, String value2) {
            addCriterion("prop_name between", value1, value2, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameNotBetween(String value1, String value2) {
            addCriterion("prop_name not between", value1, value2, "propName");
            return (Criteria) this;
        }

        public Criteria andSubmoduleIsNull() {
            addCriterion("submodule is null");
            return (Criteria) this;
        }

        public Criteria andSubmoduleIsNotNull() {
            addCriterion("submodule is not null");
            return (Criteria) this;
        }

        public Criteria andSubmoduleEqualTo(Integer value) {
            addCriterion("submodule =", value, "submodule");
            return (Criteria) this;
        }

        public Criteria andSubmoduleNotEqualTo(Integer value) {
            addCriterion("submodule <>", value, "submodule");
            return (Criteria) this;
        }

        public Criteria andSubmoduleGreaterThan(Integer value) {
            addCriterion("submodule >", value, "submodule");
            return (Criteria) this;
        }

        public Criteria andSubmoduleGreaterThanOrEqualTo(Integer value) {
            addCriterion("submodule >=", value, "submodule");
            return (Criteria) this;
        }

        public Criteria andSubmoduleLessThan(Integer value) {
            addCriterion("submodule <", value, "submodule");
            return (Criteria) this;
        }

        public Criteria andSubmoduleLessThanOrEqualTo(Integer value) {
            addCriterion("submodule <=", value, "submodule");
            return (Criteria) this;
        }

        public Criteria andSubmoduleIn(List<Integer> values) {
            addCriterion("submodule in", values, "submodule");
            return (Criteria) this;
        }

        public Criteria andSubmoduleNotIn(List<Integer> values) {
            addCriterion("submodule not in", values, "submodule");
            return (Criteria) this;
        }

        public Criteria andSubmoduleBetween(Integer value1, Integer value2) {
            addCriterion("submodule between", value1, value2, "submodule");
            return (Criteria) this;
        }

        public Criteria andSubmoduleNotBetween(Integer value1, Integer value2) {
            addCriterion("submodule not between", value1, value2, "submodule");
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

        public Criteria andExTypeIsNull() {
            addCriterion("ex_type is null");
            return (Criteria) this;
        }

        public Criteria andExTypeIsNotNull() {
            addCriterion("ex_type is not null");
            return (Criteria) this;
        }

        public Criteria andExTypeEqualTo(Integer value) {
            addCriterion("ex_type =", value, "exType");
            return (Criteria) this;
        }

        public Criteria andExTypeNotEqualTo(Integer value) {
            addCriterion("ex_type <>", value, "exType");
            return (Criteria) this;
        }

        public Criteria andExTypeGreaterThan(Integer value) {
            addCriterion("ex_type >", value, "exType");
            return (Criteria) this;
        }

        public Criteria andExTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ex_type >=", value, "exType");
            return (Criteria) this;
        }

        public Criteria andExTypeLessThan(Integer value) {
            addCriterion("ex_type <", value, "exType");
            return (Criteria) this;
        }

        public Criteria andExTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ex_type <=", value, "exType");
            return (Criteria) this;
        }

        public Criteria andExTypeIn(List<Integer> values) {
            addCriterion("ex_type in", values, "exType");
            return (Criteria) this;
        }

        public Criteria andExTypeNotIn(List<Integer> values) {
            addCriterion("ex_type not in", values, "exType");
            return (Criteria) this;
        }

        public Criteria andExTypeBetween(Integer value1, Integer value2) {
            addCriterion("ex_type between", value1, value2, "exType");
            return (Criteria) this;
        }

        public Criteria andExTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ex_type not between", value1, value2, "exType");
            return (Criteria) this;
        }

        public Criteria andCompareTimeIsNull() {
            addCriterion("compare_time is null");
            return (Criteria) this;
        }

        public Criteria andCompareTimeIsNotNull() {
            addCriterion("compare_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompareTimeEqualTo(Date value) {
            addCriterion("compare_time =", value, "compareTime");
            return (Criteria) this;
        }

        public Criteria andCompareTimeNotEqualTo(Date value) {
            addCriterion("compare_time <>", value, "compareTime");
            return (Criteria) this;
        }

        public Criteria andCompareTimeGreaterThan(Date value) {
            addCriterion("compare_time >", value, "compareTime");
            return (Criteria) this;
        }

        public Criteria andCompareTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("compare_time >=", value, "compareTime");
            return (Criteria) this;
        }

        public Criteria andCompareTimeLessThan(Date value) {
            addCriterion("compare_time <", value, "compareTime");
            return (Criteria) this;
        }

        public Criteria andCompareTimeLessThanOrEqualTo(Date value) {
            addCriterion("compare_time <=", value, "compareTime");
            return (Criteria) this;
        }

        public Criteria andCompareTimeIn(List<Date> values) {
            addCriterion("compare_time in", values, "compareTime");
            return (Criteria) this;
        }

        public Criteria andCompareTimeNotIn(List<Date> values) {
            addCriterion("compare_time not in", values, "compareTime");
            return (Criteria) this;
        }

        public Criteria andCompareTimeBetween(Date value1, Date value2) {
            addCriterion("compare_time between", value1, value2, "compareTime");
            return (Criteria) this;
        }

        public Criteria andCompareTimeNotBetween(Date value1, Date value2) {
            addCriterion("compare_time not between", value1, value2, "compareTime");
            return (Criteria) this;
        }

        public Criteria andBaseIsNull() {
            addCriterion("base is null");
            return (Criteria) this;
        }

        public Criteria andBaseIsNotNull() {
            addCriterion("base is not null");
            return (Criteria) this;
        }

        public Criteria andBaseEqualTo(String value) {
            addCriterion("base =", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseNotEqualTo(String value) {
            addCriterion("base <>", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseGreaterThan(String value) {
            addCriterion("base >", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseGreaterThanOrEqualTo(String value) {
            addCriterion("base >=", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseLessThan(String value) {
            addCriterion("base <", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseLessThanOrEqualTo(String value) {
            addCriterion("base <=", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseLike(String value) {
            addCriterion("base like", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseNotLike(String value) {
            addCriterion("base not like", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseIn(List<String> values) {
            addCriterion("base in", values, "base");
            return (Criteria) this;
        }

        public Criteria andBaseNotIn(List<String> values) {
            addCriterion("base not in", values, "base");
            return (Criteria) this;
        }

        public Criteria andBaseBetween(String value1, String value2) {
            addCriterion("base between", value1, value2, "base");
            return (Criteria) this;
        }

        public Criteria andBaseNotBetween(String value1, String value2) {
            addCriterion("base not between", value1, value2, "base");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("other like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other not between", value1, value2, "other");
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