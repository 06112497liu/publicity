package com.bbd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnnualEnterpriseAssetsCmpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnnualEnterpriseAssetsCmpExample() {
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

        public Criteria andAssTotalIsNull() {
            addCriterion("ass_total is null");
            return (Criteria) this;
        }

        public Criteria andAssTotalIsNotNull() {
            addCriterion("ass_total is not null");
            return (Criteria) this;
        }

        public Criteria andAssTotalEqualTo(Double value) {
            addCriterion("ass_total =", value, "assTotal");
            return (Criteria) this;
        }

        public Criteria andAssTotalNotEqualTo(Double value) {
            addCriterion("ass_total <>", value, "assTotal");
            return (Criteria) this;
        }

        public Criteria andAssTotalGreaterThan(Double value) {
            addCriterion("ass_total >", value, "assTotal");
            return (Criteria) this;
        }

        public Criteria andAssTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("ass_total >=", value, "assTotal");
            return (Criteria) this;
        }

        public Criteria andAssTotalLessThan(Double value) {
            addCriterion("ass_total <", value, "assTotal");
            return (Criteria) this;
        }

        public Criteria andAssTotalLessThanOrEqualTo(Double value) {
            addCriterion("ass_total <=", value, "assTotal");
            return (Criteria) this;
        }

        public Criteria andAssTotalIn(List<Double> values) {
            addCriterion("ass_total in", values, "assTotal");
            return (Criteria) this;
        }

        public Criteria andAssTotalNotIn(List<Double> values) {
            addCriterion("ass_total not in", values, "assTotal");
            return (Criteria) this;
        }

        public Criteria andAssTotalBetween(Double value1, Double value2) {
            addCriterion("ass_total between", value1, value2, "assTotal");
            return (Criteria) this;
        }

        public Criteria andAssTotalNotBetween(Double value1, Double value2) {
            addCriterion("ass_total not between", value1, value2, "assTotal");
            return (Criteria) this;
        }

        public Criteria andGrossRevenueIsNull() {
            addCriterion("gross_revenue is null");
            return (Criteria) this;
        }

        public Criteria andGrossRevenueIsNotNull() {
            addCriterion("gross_revenue is not null");
            return (Criteria) this;
        }

        public Criteria andGrossRevenueEqualTo(Double value) {
            addCriterion("gross_revenue =", value, "grossRevenue");
            return (Criteria) this;
        }

        public Criteria andGrossRevenueNotEqualTo(Double value) {
            addCriterion("gross_revenue <>", value, "grossRevenue");
            return (Criteria) this;
        }

        public Criteria andGrossRevenueGreaterThan(Double value) {
            addCriterion("gross_revenue >", value, "grossRevenue");
            return (Criteria) this;
        }

        public Criteria andGrossRevenueGreaterThanOrEqualTo(Double value) {
            addCriterion("gross_revenue >=", value, "grossRevenue");
            return (Criteria) this;
        }

        public Criteria andGrossRevenueLessThan(Double value) {
            addCriterion("gross_revenue <", value, "grossRevenue");
            return (Criteria) this;
        }

        public Criteria andGrossRevenueLessThanOrEqualTo(Double value) {
            addCriterion("gross_revenue <=", value, "grossRevenue");
            return (Criteria) this;
        }

        public Criteria andGrossRevenueIn(List<Double> values) {
            addCriterion("gross_revenue in", values, "grossRevenue");
            return (Criteria) this;
        }

        public Criteria andGrossRevenueNotIn(List<Double> values) {
            addCriterion("gross_revenue not in", values, "grossRevenue");
            return (Criteria) this;
        }

        public Criteria andGrossRevenueBetween(Double value1, Double value2) {
            addCriterion("gross_revenue between", value1, value2, "grossRevenue");
            return (Criteria) this;
        }

        public Criteria andGrossRevenueNotBetween(Double value1, Double value2) {
            addCriterion("gross_revenue not between", value1, value2, "grossRevenue");
            return (Criteria) this;
        }

        public Criteria andMainGrossRevenueIsNull() {
            addCriterion("main_gross_revenue is null");
            return (Criteria) this;
        }

        public Criteria andMainGrossRevenueIsNotNull() {
            addCriterion("main_gross_revenue is not null");
            return (Criteria) this;
        }

        public Criteria andMainGrossRevenueEqualTo(Double value) {
            addCriterion("main_gross_revenue =", value, "mainGrossRevenue");
            return (Criteria) this;
        }

        public Criteria andMainGrossRevenueNotEqualTo(Double value) {
            addCriterion("main_gross_revenue <>", value, "mainGrossRevenue");
            return (Criteria) this;
        }

        public Criteria andMainGrossRevenueGreaterThan(Double value) {
            addCriterion("main_gross_revenue >", value, "mainGrossRevenue");
            return (Criteria) this;
        }

        public Criteria andMainGrossRevenueGreaterThanOrEqualTo(Double value) {
            addCriterion("main_gross_revenue >=", value, "mainGrossRevenue");
            return (Criteria) this;
        }

        public Criteria andMainGrossRevenueLessThan(Double value) {
            addCriterion("main_gross_revenue <", value, "mainGrossRevenue");
            return (Criteria) this;
        }

        public Criteria andMainGrossRevenueLessThanOrEqualTo(Double value) {
            addCriterion("main_gross_revenue <=", value, "mainGrossRevenue");
            return (Criteria) this;
        }

        public Criteria andMainGrossRevenueIn(List<Double> values) {
            addCriterion("main_gross_revenue in", values, "mainGrossRevenue");
            return (Criteria) this;
        }

        public Criteria andMainGrossRevenueNotIn(List<Double> values) {
            addCriterion("main_gross_revenue not in", values, "mainGrossRevenue");
            return (Criteria) this;
        }

        public Criteria andMainGrossRevenueBetween(Double value1, Double value2) {
            addCriterion("main_gross_revenue between", value1, value2, "mainGrossRevenue");
            return (Criteria) this;
        }

        public Criteria andMainGrossRevenueNotBetween(Double value1, Double value2) {
            addCriterion("main_gross_revenue not between", value1, value2, "mainGrossRevenue");
            return (Criteria) this;
        }

        public Criteria andTaxTotalIsNull() {
            addCriterion("tax_total is null");
            return (Criteria) this;
        }

        public Criteria andTaxTotalIsNotNull() {
            addCriterion("tax_total is not null");
            return (Criteria) this;
        }

        public Criteria andTaxTotalEqualTo(Double value) {
            addCriterion("tax_total =", value, "taxTotal");
            return (Criteria) this;
        }

        public Criteria andTaxTotalNotEqualTo(Double value) {
            addCriterion("tax_total <>", value, "taxTotal");
            return (Criteria) this;
        }

        public Criteria andTaxTotalGreaterThan(Double value) {
            addCriterion("tax_total >", value, "taxTotal");
            return (Criteria) this;
        }

        public Criteria andTaxTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("tax_total >=", value, "taxTotal");
            return (Criteria) this;
        }

        public Criteria andTaxTotalLessThan(Double value) {
            addCriterion("tax_total <", value, "taxTotal");
            return (Criteria) this;
        }

        public Criteria andTaxTotalLessThanOrEqualTo(Double value) {
            addCriterion("tax_total <=", value, "taxTotal");
            return (Criteria) this;
        }

        public Criteria andTaxTotalIn(List<Double> values) {
            addCriterion("tax_total in", values, "taxTotal");
            return (Criteria) this;
        }

        public Criteria andTaxTotalNotIn(List<Double> values) {
            addCriterion("tax_total not in", values, "taxTotal");
            return (Criteria) this;
        }

        public Criteria andTaxTotalBetween(Double value1, Double value2) {
            addCriterion("tax_total between", value1, value2, "taxTotal");
            return (Criteria) this;
        }

        public Criteria andTaxTotalNotBetween(Double value1, Double value2) {
            addCriterion("tax_total not between", value1, value2, "taxTotal");
            return (Criteria) this;
        }

        public Criteria andOwnEquityIsNull() {
            addCriterion("own_equity is null");
            return (Criteria) this;
        }

        public Criteria andOwnEquityIsNotNull() {
            addCriterion("own_equity is not null");
            return (Criteria) this;
        }

        public Criteria andOwnEquityEqualTo(Double value) {
            addCriterion("own_equity =", value, "ownEquity");
            return (Criteria) this;
        }

        public Criteria andOwnEquityNotEqualTo(Double value) {
            addCriterion("own_equity <>", value, "ownEquity");
            return (Criteria) this;
        }

        public Criteria andOwnEquityGreaterThan(Double value) {
            addCriterion("own_equity >", value, "ownEquity");
            return (Criteria) this;
        }

        public Criteria andOwnEquityGreaterThanOrEqualTo(Double value) {
            addCriterion("own_equity >=", value, "ownEquity");
            return (Criteria) this;
        }

        public Criteria andOwnEquityLessThan(Double value) {
            addCriterion("own_equity <", value, "ownEquity");
            return (Criteria) this;
        }

        public Criteria andOwnEquityLessThanOrEqualTo(Double value) {
            addCriterion("own_equity <=", value, "ownEquity");
            return (Criteria) this;
        }

        public Criteria andOwnEquityIn(List<Double> values) {
            addCriterion("own_equity in", values, "ownEquity");
            return (Criteria) this;
        }

        public Criteria andOwnEquityNotIn(List<Double> values) {
            addCriterion("own_equity not in", values, "ownEquity");
            return (Criteria) this;
        }

        public Criteria andOwnEquityBetween(Double value1, Double value2) {
            addCriterion("own_equity between", value1, value2, "ownEquity");
            return (Criteria) this;
        }

        public Criteria andOwnEquityNotBetween(Double value1, Double value2) {
            addCriterion("own_equity not between", value1, value2, "ownEquity");
            return (Criteria) this;
        }

        public Criteria andProTotalIsNull() {
            addCriterion("pro_total is null");
            return (Criteria) this;
        }

        public Criteria andProTotalIsNotNull() {
            addCriterion("pro_total is not null");
            return (Criteria) this;
        }

        public Criteria andProTotalEqualTo(Double value) {
            addCriterion("pro_total =", value, "proTotal");
            return (Criteria) this;
        }

        public Criteria andProTotalNotEqualTo(Double value) {
            addCriterion("pro_total <>", value, "proTotal");
            return (Criteria) this;
        }

        public Criteria andProTotalGreaterThan(Double value) {
            addCriterion("pro_total >", value, "proTotal");
            return (Criteria) this;
        }

        public Criteria andProTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("pro_total >=", value, "proTotal");
            return (Criteria) this;
        }

        public Criteria andProTotalLessThan(Double value) {
            addCriterion("pro_total <", value, "proTotal");
            return (Criteria) this;
        }

        public Criteria andProTotalLessThanOrEqualTo(Double value) {
            addCriterion("pro_total <=", value, "proTotal");
            return (Criteria) this;
        }

        public Criteria andProTotalIn(List<Double> values) {
            addCriterion("pro_total in", values, "proTotal");
            return (Criteria) this;
        }

        public Criteria andProTotalNotIn(List<Double> values) {
            addCriterion("pro_total not in", values, "proTotal");
            return (Criteria) this;
        }

        public Criteria andProTotalBetween(Double value1, Double value2) {
            addCriterion("pro_total between", value1, value2, "proTotal");
            return (Criteria) this;
        }

        public Criteria andProTotalNotBetween(Double value1, Double value2) {
            addCriterion("pro_total not between", value1, value2, "proTotal");
            return (Criteria) this;
        }

        public Criteria andProNetIsNull() {
            addCriterion("pro_net is null");
            return (Criteria) this;
        }

        public Criteria andProNetIsNotNull() {
            addCriterion("pro_net is not null");
            return (Criteria) this;
        }

        public Criteria andProNetEqualTo(Double value) {
            addCriterion("pro_net =", value, "proNet");
            return (Criteria) this;
        }

        public Criteria andProNetNotEqualTo(Double value) {
            addCriterion("pro_net <>", value, "proNet");
            return (Criteria) this;
        }

        public Criteria andProNetGreaterThan(Double value) {
            addCriterion("pro_net >", value, "proNet");
            return (Criteria) this;
        }

        public Criteria andProNetGreaterThanOrEqualTo(Double value) {
            addCriterion("pro_net >=", value, "proNet");
            return (Criteria) this;
        }

        public Criteria andProNetLessThan(Double value) {
            addCriterion("pro_net <", value, "proNet");
            return (Criteria) this;
        }

        public Criteria andProNetLessThanOrEqualTo(Double value) {
            addCriterion("pro_net <=", value, "proNet");
            return (Criteria) this;
        }

        public Criteria andProNetIn(List<Double> values) {
            addCriterion("pro_net in", values, "proNet");
            return (Criteria) this;
        }

        public Criteria andProNetNotIn(List<Double> values) {
            addCriterion("pro_net not in", values, "proNet");
            return (Criteria) this;
        }

        public Criteria andProNetBetween(Double value1, Double value2) {
            addCriterion("pro_net between", value1, value2, "proNet");
            return (Criteria) this;
        }

        public Criteria andProNetNotBetween(Double value1, Double value2) {
            addCriterion("pro_net not between", value1, value2, "proNet");
            return (Criteria) this;
        }

        public Criteria andLiabTotalIsNull() {
            addCriterion("liab_total is null");
            return (Criteria) this;
        }

        public Criteria andLiabTotalIsNotNull() {
            addCriterion("liab_total is not null");
            return (Criteria) this;
        }

        public Criteria andLiabTotalEqualTo(Double value) {
            addCriterion("liab_total =", value, "liabTotal");
            return (Criteria) this;
        }

        public Criteria andLiabTotalNotEqualTo(Double value) {
            addCriterion("liab_total <>", value, "liabTotal");
            return (Criteria) this;
        }

        public Criteria andLiabTotalGreaterThan(Double value) {
            addCriterion("liab_total >", value, "liabTotal");
            return (Criteria) this;
        }

        public Criteria andLiabTotalGreaterThanOrEqualTo(Double value) {
            addCriterion("liab_total >=", value, "liabTotal");
            return (Criteria) this;
        }

        public Criteria andLiabTotalLessThan(Double value) {
            addCriterion("liab_total <", value, "liabTotal");
            return (Criteria) this;
        }

        public Criteria andLiabTotalLessThanOrEqualTo(Double value) {
            addCriterion("liab_total <=", value, "liabTotal");
            return (Criteria) this;
        }

        public Criteria andLiabTotalIn(List<Double> values) {
            addCriterion("liab_total in", values, "liabTotal");
            return (Criteria) this;
        }

        public Criteria andLiabTotalNotIn(List<Double> values) {
            addCriterion("liab_total not in", values, "liabTotal");
            return (Criteria) this;
        }

        public Criteria andLiabTotalBetween(Double value1, Double value2) {
            addCriterion("liab_total between", value1, value2, "liabTotal");
            return (Criteria) this;
        }

        public Criteria andLiabTotalNotBetween(Double value1, Double value2) {
            addCriterion("liab_total not between", value1, value2, "liabTotal");
            return (Criteria) this;
        }

        public Criteria andProTotalNetIsNull() {
            addCriterion("pro_total_net is null");
            return (Criteria) this;
        }

        public Criteria andProTotalNetIsNotNull() {
            addCriterion("pro_total_net is not null");
            return (Criteria) this;
        }

        public Criteria andProTotalNetEqualTo(Double value) {
            addCriterion("pro_total_net =", value, "proTotalNet");
            return (Criteria) this;
        }

        public Criteria andProTotalNetNotEqualTo(Double value) {
            addCriterion("pro_total_net <>", value, "proTotalNet");
            return (Criteria) this;
        }

        public Criteria andProTotalNetGreaterThan(Double value) {
            addCriterion("pro_total_net >", value, "proTotalNet");
            return (Criteria) this;
        }

        public Criteria andProTotalNetGreaterThanOrEqualTo(Double value) {
            addCriterion("pro_total_net >=", value, "proTotalNet");
            return (Criteria) this;
        }

        public Criteria andProTotalNetLessThan(Double value) {
            addCriterion("pro_total_net <", value, "proTotalNet");
            return (Criteria) this;
        }

        public Criteria andProTotalNetLessThanOrEqualTo(Double value) {
            addCriterion("pro_total_net <=", value, "proTotalNet");
            return (Criteria) this;
        }

        public Criteria andProTotalNetIn(List<Double> values) {
            addCriterion("pro_total_net in", values, "proTotalNet");
            return (Criteria) this;
        }

        public Criteria andProTotalNetNotIn(List<Double> values) {
            addCriterion("pro_total_net not in", values, "proTotalNet");
            return (Criteria) this;
        }

        public Criteria andProTotalNetBetween(Double value1, Double value2) {
            addCriterion("pro_total_net between", value1, value2, "proTotalNet");
            return (Criteria) this;
        }

        public Criteria andProTotalNetNotBetween(Double value1, Double value2) {
            addCriterion("pro_total_net not between", value1, value2, "proTotalNet");
            return (Criteria) this;
        }

        public Criteria andSupFundIsNull() {
            addCriterion("sup_fund is null");
            return (Criteria) this;
        }

        public Criteria andSupFundIsNotNull() {
            addCriterion("sup_fund is not null");
            return (Criteria) this;
        }

        public Criteria andSupFundEqualTo(Double value) {
            addCriterion("sup_fund =", value, "supFund");
            return (Criteria) this;
        }

        public Criteria andSupFundNotEqualTo(Double value) {
            addCriterion("sup_fund <>", value, "supFund");
            return (Criteria) this;
        }

        public Criteria andSupFundGreaterThan(Double value) {
            addCriterion("sup_fund >", value, "supFund");
            return (Criteria) this;
        }

        public Criteria andSupFundGreaterThanOrEqualTo(Double value) {
            addCriterion("sup_fund >=", value, "supFund");
            return (Criteria) this;
        }

        public Criteria andSupFundLessThan(Double value) {
            addCriterion("sup_fund <", value, "supFund");
            return (Criteria) this;
        }

        public Criteria andSupFundLessThanOrEqualTo(Double value) {
            addCriterion("sup_fund <=", value, "supFund");
            return (Criteria) this;
        }

        public Criteria andSupFundIn(List<Double> values) {
            addCriterion("sup_fund in", values, "supFund");
            return (Criteria) this;
        }

        public Criteria andSupFundNotIn(List<Double> values) {
            addCriterion("sup_fund not in", values, "supFund");
            return (Criteria) this;
        }

        public Criteria andSupFundBetween(Double value1, Double value2) {
            addCriterion("sup_fund between", value1, value2, "supFund");
            return (Criteria) this;
        }

        public Criteria andSupFundNotBetween(Double value1, Double value2) {
            addCriterion("sup_fund not between", value1, value2, "supFund");
            return (Criteria) this;
        }

        public Criteria andLoanIsNull() {
            addCriterion("loan is null");
            return (Criteria) this;
        }

        public Criteria andLoanIsNotNull() {
            addCriterion("loan is not null");
            return (Criteria) this;
        }

        public Criteria andLoanEqualTo(Double value) {
            addCriterion("loan =", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanNotEqualTo(Double value) {
            addCriterion("loan <>", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanGreaterThan(Double value) {
            addCriterion("loan >", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanGreaterThanOrEqualTo(Double value) {
            addCriterion("loan >=", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanLessThan(Double value) {
            addCriterion("loan <", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanLessThanOrEqualTo(Double value) {
            addCriterion("loan <=", value, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanIn(List<Double> values) {
            addCriterion("loan in", values, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanNotIn(List<Double> values) {
            addCriterion("loan not in", values, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanBetween(Double value1, Double value2) {
            addCriterion("loan between", value1, value2, "loan");
            return (Criteria) this;
        }

        public Criteria andLoanNotBetween(Double value1, Double value2) {
            addCriterion("loan not between", value1, value2, "loan");
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