package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsAdminLicenseStdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InsAdminLicenseStdExample() {
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

        public Criteria andLicenseNoIsNull() {
            addCriterion("license_no is null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNotNull() {
            addCriterion("license_no is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoEqualTo(String value) {
            addCriterion("license_no =", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotEqualTo(String value) {
            addCriterion("license_no <>", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThan(String value) {
            addCriterion("license_no >", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThanOrEqualTo(String value) {
            addCriterion("license_no >=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThan(String value) {
            addCriterion("license_no <", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThanOrEqualTo(String value) {
            addCriterion("license_no <=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLike(String value) {
            addCriterion("license_no like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotLike(String value) {
            addCriterion("license_no not like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIn(List<String> values) {
            addCriterion("license_no in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotIn(List<String> values) {
            addCriterion("license_no not in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoBetween(String value1, String value2) {
            addCriterion("license_no between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotBetween(String value1, String value2) {
            addCriterion("license_no not between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNameIsNull() {
            addCriterion("license_name is null");
            return (Criteria) this;
        }

        public Criteria andLicenseNameIsNotNull() {
            addCriterion("license_name is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseNameEqualTo(String value) {
            addCriterion("license_name =", value, "licenseName");
            return (Criteria) this;
        }

        public Criteria andLicenseNameNotEqualTo(String value) {
            addCriterion("license_name <>", value, "licenseName");
            return (Criteria) this;
        }

        public Criteria andLicenseNameGreaterThan(String value) {
            addCriterion("license_name >", value, "licenseName");
            return (Criteria) this;
        }

        public Criteria andLicenseNameGreaterThanOrEqualTo(String value) {
            addCriterion("license_name >=", value, "licenseName");
            return (Criteria) this;
        }

        public Criteria andLicenseNameLessThan(String value) {
            addCriterion("license_name <", value, "licenseName");
            return (Criteria) this;
        }

        public Criteria andLicenseNameLessThanOrEqualTo(String value) {
            addCriterion("license_name <=", value, "licenseName");
            return (Criteria) this;
        }

        public Criteria andLicenseNameLike(String value) {
            addCriterion("license_name like", value, "licenseName");
            return (Criteria) this;
        }

        public Criteria andLicenseNameNotLike(String value) {
            addCriterion("license_name not like", value, "licenseName");
            return (Criteria) this;
        }

        public Criteria andLicenseNameIn(List<String> values) {
            addCriterion("license_name in", values, "licenseName");
            return (Criteria) this;
        }

        public Criteria andLicenseNameNotIn(List<String> values) {
            addCriterion("license_name not in", values, "licenseName");
            return (Criteria) this;
        }

        public Criteria andLicenseNameBetween(String value1, String value2) {
            addCriterion("license_name between", value1, value2, "licenseName");
            return (Criteria) this;
        }

        public Criteria andLicenseNameNotBetween(String value1, String value2) {
            addCriterion("license_name not between", value1, value2, "licenseName");
            return (Criteria) this;
        }

        public Criteria andValidityFromIsNull() {
            addCriterion("validity_from is null");
            return (Criteria) this;
        }

        public Criteria andValidityFromIsNotNull() {
            addCriterion("validity_from is not null");
            return (Criteria) this;
        }

        public Criteria andValidityFromEqualTo(Date value) {
            addCriterion("validity_from =", value, "validityFrom");
            return (Criteria) this;
        }

        public Criteria andValidityFromNotEqualTo(Date value) {
            addCriterion("validity_from <>", value, "validityFrom");
            return (Criteria) this;
        }

        public Criteria andValidityFromGreaterThan(Date value) {
            addCriterion("validity_from >", value, "validityFrom");
            return (Criteria) this;
        }

        public Criteria andValidityFromGreaterThanOrEqualTo(Date value) {
            addCriterion("validity_from >=", value, "validityFrom");
            return (Criteria) this;
        }

        public Criteria andValidityFromLessThan(Date value) {
            addCriterion("validity_from <", value, "validityFrom");
            return (Criteria) this;
        }

        public Criteria andValidityFromLessThanOrEqualTo(Date value) {
            addCriterion("validity_from <=", value, "validityFrom");
            return (Criteria) this;
        }

        public Criteria andValidityFromIn(List<Date> values) {
            addCriterion("validity_from in", values, "validityFrom");
            return (Criteria) this;
        }

        public Criteria andValidityFromNotIn(List<Date> values) {
            addCriterion("validity_from not in", values, "validityFrom");
            return (Criteria) this;
        }

        public Criteria andValidityFromBetween(Date value1, Date value2) {
            addCriterion("validity_from between", value1, value2, "validityFrom");
            return (Criteria) this;
        }

        public Criteria andValidityFromNotBetween(Date value1, Date value2) {
            addCriterion("validity_from not between", value1, value2, "validityFrom");
            return (Criteria) this;
        }

        public Criteria andValidityToIsNull() {
            addCriterion("validity_to is null");
            return (Criteria) this;
        }

        public Criteria andValidityToIsNotNull() {
            addCriterion("validity_to is not null");
            return (Criteria) this;
        }

        public Criteria andValidityToEqualTo(Date value) {
            addCriterion("validity_to =", value, "validityTo");
            return (Criteria) this;
        }

        public Criteria andValidityToNotEqualTo(Date value) {
            addCriterion("validity_to <>", value, "validityTo");
            return (Criteria) this;
        }

        public Criteria andValidityToGreaterThan(Date value) {
            addCriterion("validity_to >", value, "validityTo");
            return (Criteria) this;
        }

        public Criteria andValidityToGreaterThanOrEqualTo(Date value) {
            addCriterion("validity_to >=", value, "validityTo");
            return (Criteria) this;
        }

        public Criteria andValidityToLessThan(Date value) {
            addCriterion("validity_to <", value, "validityTo");
            return (Criteria) this;
        }

        public Criteria andValidityToLessThanOrEqualTo(Date value) {
            addCriterion("validity_to <=", value, "validityTo");
            return (Criteria) this;
        }

        public Criteria andValidityToIn(List<Date> values) {
            addCriterion("validity_to in", values, "validityTo");
            return (Criteria) this;
        }

        public Criteria andValidityToNotIn(List<Date> values) {
            addCriterion("validity_to not in", values, "validityTo");
            return (Criteria) this;
        }

        public Criteria andValidityToBetween(Date value1, Date value2) {
            addCriterion("validity_to between", value1, value2, "validityTo");
            return (Criteria) this;
        }

        public Criteria andValidityToNotBetween(Date value1, Date value2) {
            addCriterion("validity_to not between", value1, value2, "validityTo");
            return (Criteria) this;
        }

        public Criteria andLicenseAuthorityIsNull() {
            addCriterion("license_authority is null");
            return (Criteria) this;
        }

        public Criteria andLicenseAuthorityIsNotNull() {
            addCriterion("license_authority is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseAuthorityEqualTo(String value) {
            addCriterion("license_authority =", value, "licenseAuthority");
            return (Criteria) this;
        }

        public Criteria andLicenseAuthorityNotEqualTo(String value) {
            addCriterion("license_authority <>", value, "licenseAuthority");
            return (Criteria) this;
        }

        public Criteria andLicenseAuthorityGreaterThan(String value) {
            addCriterion("license_authority >", value, "licenseAuthority");
            return (Criteria) this;
        }

        public Criteria andLicenseAuthorityGreaterThanOrEqualTo(String value) {
            addCriterion("license_authority >=", value, "licenseAuthority");
            return (Criteria) this;
        }

        public Criteria andLicenseAuthorityLessThan(String value) {
            addCriterion("license_authority <", value, "licenseAuthority");
            return (Criteria) this;
        }

        public Criteria andLicenseAuthorityLessThanOrEqualTo(String value) {
            addCriterion("license_authority <=", value, "licenseAuthority");
            return (Criteria) this;
        }

        public Criteria andLicenseAuthorityLike(String value) {
            addCriterion("license_authority like", value, "licenseAuthority");
            return (Criteria) this;
        }

        public Criteria andLicenseAuthorityNotLike(String value) {
            addCriterion("license_authority not like", value, "licenseAuthority");
            return (Criteria) this;
        }

        public Criteria andLicenseAuthorityIn(List<String> values) {
            addCriterion("license_authority in", values, "licenseAuthority");
            return (Criteria) this;
        }

        public Criteria andLicenseAuthorityNotIn(List<String> values) {
            addCriterion("license_authority not in", values, "licenseAuthority");
            return (Criteria) this;
        }

        public Criteria andLicenseAuthorityBetween(String value1, String value2) {
            addCriterion("license_authority between", value1, value2, "licenseAuthority");
            return (Criteria) this;
        }

        public Criteria andLicenseAuthorityNotBetween(String value1, String value2) {
            addCriterion("license_authority not between", value1, value2, "licenseAuthority");
            return (Criteria) this;
        }

        public Criteria andLicenseContentIsNull() {
            addCriterion("license_content is null");
            return (Criteria) this;
        }

        public Criteria andLicenseContentIsNotNull() {
            addCriterion("license_content is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseContentEqualTo(String value) {
            addCriterion("license_content =", value, "licenseContent");
            return (Criteria) this;
        }

        public Criteria andLicenseContentNotEqualTo(String value) {
            addCriterion("license_content <>", value, "licenseContent");
            return (Criteria) this;
        }

        public Criteria andLicenseContentGreaterThan(String value) {
            addCriterion("license_content >", value, "licenseContent");
            return (Criteria) this;
        }

        public Criteria andLicenseContentGreaterThanOrEqualTo(String value) {
            addCriterion("license_content >=", value, "licenseContent");
            return (Criteria) this;
        }

        public Criteria andLicenseContentLessThan(String value) {
            addCriterion("license_content <", value, "licenseContent");
            return (Criteria) this;
        }

        public Criteria andLicenseContentLessThanOrEqualTo(String value) {
            addCriterion("license_content <=", value, "licenseContent");
            return (Criteria) this;
        }

        public Criteria andLicenseContentLike(String value) {
            addCriterion("license_content like", value, "licenseContent");
            return (Criteria) this;
        }

        public Criteria andLicenseContentNotLike(String value) {
            addCriterion("license_content not like", value, "licenseContent");
            return (Criteria) this;
        }

        public Criteria andLicenseContentIn(List<String> values) {
            addCriterion("license_content in", values, "licenseContent");
            return (Criteria) this;
        }

        public Criteria andLicenseContentNotIn(List<String> values) {
            addCriterion("license_content not in", values, "licenseContent");
            return (Criteria) this;
        }

        public Criteria andLicenseContentBetween(String value1, String value2) {
            addCriterion("license_content between", value1, value2, "licenseContent");
            return (Criteria) this;
        }

        public Criteria andLicenseContentNotBetween(String value1, String value2) {
            addCriterion("license_content not between", value1, value2, "licenseContent");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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