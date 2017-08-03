package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsAdminPunishStdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InsAdminPunishStdExample() {
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

        public Criteria andDocumentNoIsNull() {
            addCriterion("document_no is null");
            return (Criteria) this;
        }

        public Criteria andDocumentNoIsNotNull() {
            addCriterion("document_no is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentNoEqualTo(String value) {
            addCriterion("document_no =", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoNotEqualTo(String value) {
            addCriterion("document_no <>", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoGreaterThan(String value) {
            addCriterion("document_no >", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoGreaterThanOrEqualTo(String value) {
            addCriterion("document_no >=", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoLessThan(String value) {
            addCriterion("document_no <", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoLessThanOrEqualTo(String value) {
            addCriterion("document_no <=", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoLike(String value) {
            addCriterion("document_no like", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoNotLike(String value) {
            addCriterion("document_no not like", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoIn(List<String> values) {
            addCriterion("document_no in", values, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoNotIn(List<String> values) {
            addCriterion("document_no not in", values, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoBetween(String value1, String value2) {
            addCriterion("document_no between", value1, value2, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoNotBetween(String value1, String value2) {
            addCriterion("document_no not between", value1, value2, "documentNo");
            return (Criteria) this;
        }

        public Criteria andBehaviorTypeIsNull() {
            addCriterion("behavior_type is null");
            return (Criteria) this;
        }

        public Criteria andBehaviorTypeIsNotNull() {
            addCriterion("behavior_type is not null");
            return (Criteria) this;
        }

        public Criteria andBehaviorTypeEqualTo(String value) {
            addCriterion("behavior_type =", value, "behaviorType");
            return (Criteria) this;
        }

        public Criteria andBehaviorTypeNotEqualTo(String value) {
            addCriterion("behavior_type <>", value, "behaviorType");
            return (Criteria) this;
        }

        public Criteria andBehaviorTypeGreaterThan(String value) {
            addCriterion("behavior_type >", value, "behaviorType");
            return (Criteria) this;
        }

        public Criteria andBehaviorTypeGreaterThanOrEqualTo(String value) {
            addCriterion("behavior_type >=", value, "behaviorType");
            return (Criteria) this;
        }

        public Criteria andBehaviorTypeLessThan(String value) {
            addCriterion("behavior_type <", value, "behaviorType");
            return (Criteria) this;
        }

        public Criteria andBehaviorTypeLessThanOrEqualTo(String value) {
            addCriterion("behavior_type <=", value, "behaviorType");
            return (Criteria) this;
        }

        public Criteria andBehaviorTypeLike(String value) {
            addCriterion("behavior_type like", value, "behaviorType");
            return (Criteria) this;
        }

        public Criteria andBehaviorTypeNotLike(String value) {
            addCriterion("behavior_type not like", value, "behaviorType");
            return (Criteria) this;
        }

        public Criteria andBehaviorTypeIn(List<String> values) {
            addCriterion("behavior_type in", values, "behaviorType");
            return (Criteria) this;
        }

        public Criteria andBehaviorTypeNotIn(List<String> values) {
            addCriterion("behavior_type not in", values, "behaviorType");
            return (Criteria) this;
        }

        public Criteria andBehaviorTypeBetween(String value1, String value2) {
            addCriterion("behavior_type between", value1, value2, "behaviorType");
            return (Criteria) this;
        }

        public Criteria andBehaviorTypeNotBetween(String value1, String value2) {
            addCriterion("behavior_type not between", value1, value2, "behaviorType");
            return (Criteria) this;
        }

        public Criteria andPunishContentIsNull() {
            addCriterion("punish_content is null");
            return (Criteria) this;
        }

        public Criteria andPunishContentIsNotNull() {
            addCriterion("punish_content is not null");
            return (Criteria) this;
        }

        public Criteria andPunishContentEqualTo(String value) {
            addCriterion("punish_content =", value, "punishContent");
            return (Criteria) this;
        }

        public Criteria andPunishContentNotEqualTo(String value) {
            addCriterion("punish_content <>", value, "punishContent");
            return (Criteria) this;
        }

        public Criteria andPunishContentGreaterThan(String value) {
            addCriterion("punish_content >", value, "punishContent");
            return (Criteria) this;
        }

        public Criteria andPunishContentGreaterThanOrEqualTo(String value) {
            addCriterion("punish_content >=", value, "punishContent");
            return (Criteria) this;
        }

        public Criteria andPunishContentLessThan(String value) {
            addCriterion("punish_content <", value, "punishContent");
            return (Criteria) this;
        }

        public Criteria andPunishContentLessThanOrEqualTo(String value) {
            addCriterion("punish_content <=", value, "punishContent");
            return (Criteria) this;
        }

        public Criteria andPunishContentLike(String value) {
            addCriterion("punish_content like", value, "punishContent");
            return (Criteria) this;
        }

        public Criteria andPunishContentNotLike(String value) {
            addCriterion("punish_content not like", value, "punishContent");
            return (Criteria) this;
        }

        public Criteria andPunishContentIn(List<String> values) {
            addCriterion("punish_content in", values, "punishContent");
            return (Criteria) this;
        }

        public Criteria andPunishContentNotIn(List<String> values) {
            addCriterion("punish_content not in", values, "punishContent");
            return (Criteria) this;
        }

        public Criteria andPunishContentBetween(String value1, String value2) {
            addCriterion("punish_content between", value1, value2, "punishContent");
            return (Criteria) this;
        }

        public Criteria andPunishContentNotBetween(String value1, String value2) {
            addCriterion("punish_content not between", value1, value2, "punishContent");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameIsNull() {
            addCriterion("authority_name is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameIsNotNull() {
            addCriterion("authority_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameEqualTo(String value) {
            addCriterion("authority_name =", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameNotEqualTo(String value) {
            addCriterion("authority_name <>", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameGreaterThan(String value) {
            addCriterion("authority_name >", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameGreaterThanOrEqualTo(String value) {
            addCriterion("authority_name >=", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameLessThan(String value) {
            addCriterion("authority_name <", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameLessThanOrEqualTo(String value) {
            addCriterion("authority_name <=", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameLike(String value) {
            addCriterion("authority_name like", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameNotLike(String value) {
            addCriterion("authority_name not like", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameIn(List<String> values) {
            addCriterion("authority_name in", values, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameNotIn(List<String> values) {
            addCriterion("authority_name not in", values, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameBetween(String value1, String value2) {
            addCriterion("authority_name between", value1, value2, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameNotBetween(String value1, String value2) {
            addCriterion("authority_name not between", value1, value2, "authorityName");
            return (Criteria) this;
        }

        public Criteria andPunishDateIsNull() {
            addCriterion("punish_date is null");
            return (Criteria) this;
        }

        public Criteria andPunishDateIsNotNull() {
            addCriterion("punish_date is not null");
            return (Criteria) this;
        }

        public Criteria andPunishDateEqualTo(Date value) {
            addCriterion("punish_date =", value, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateNotEqualTo(Date value) {
            addCriterion("punish_date <>", value, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateGreaterThan(Date value) {
            addCriterion("punish_date >", value, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateGreaterThanOrEqualTo(Date value) {
            addCriterion("punish_date >=", value, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateLessThan(Date value) {
            addCriterion("punish_date <", value, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateLessThanOrEqualTo(Date value) {
            addCriterion("punish_date <=", value, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateIn(List<Date> values) {
            addCriterion("punish_date in", values, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateNotIn(List<Date> values) {
            addCriterion("punish_date not in", values, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateBetween(Date value1, Date value2) {
            addCriterion("punish_date between", value1, value2, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPunishDateNotBetween(Date value1, Date value2) {
            addCriterion("punish_date not between", value1, value2, "punishDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateIsNull() {
            addCriterion("public_date is null");
            return (Criteria) this;
        }

        public Criteria andPublicDateIsNotNull() {
            addCriterion("public_date is not null");
            return (Criteria) this;
        }

        public Criteria andPublicDateEqualTo(Date value) {
            addCriterion("public_date =", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateNotEqualTo(Date value) {
            addCriterion("public_date <>", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateGreaterThan(Date value) {
            addCriterion("public_date >", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateGreaterThanOrEqualTo(Date value) {
            addCriterion("public_date >=", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateLessThan(Date value) {
            addCriterion("public_date <", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateLessThanOrEqualTo(Date value) {
            addCriterion("public_date <=", value, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateIn(List<Date> values) {
            addCriterion("public_date in", values, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateNotIn(List<Date> values) {
            addCriterion("public_date not in", values, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateBetween(Date value1, Date value2) {
            addCriterion("public_date between", value1, value2, "publicDate");
            return (Criteria) this;
        }

        public Criteria andPublicDateNotBetween(Date value1, Date value2) {
            addCriterion("public_date not between", value1, value2, "publicDate");
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