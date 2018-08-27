package com.resale.foreground.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeptOptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeptOptExample() {
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

        public Criteria andDoptIdIsNull() {
            addCriterion("dopt_id is null");
            return (Criteria) this;
        }

        public Criteria andDoptIdIsNotNull() {
            addCriterion("dopt_id is not null");
            return (Criteria) this;
        }

        public Criteria andDoptIdEqualTo(Integer value) {
            addCriterion("dopt_id =", value, "doptId");
            return (Criteria) this;
        }

        public Criteria andDoptIdNotEqualTo(Integer value) {
            addCriterion("dopt_id <>", value, "doptId");
            return (Criteria) this;
        }

        public Criteria andDoptIdGreaterThan(Integer value) {
            addCriterion("dopt_id >", value, "doptId");
            return (Criteria) this;
        }

        public Criteria andDoptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dopt_id >=", value, "doptId");
            return (Criteria) this;
        }

        public Criteria andDoptIdLessThan(Integer value) {
            addCriterion("dopt_id <", value, "doptId");
            return (Criteria) this;
        }

        public Criteria andDoptIdLessThanOrEqualTo(Integer value) {
            addCriterion("dopt_id <=", value, "doptId");
            return (Criteria) this;
        }

        public Criteria andDoptIdIn(List<Integer> values) {
            addCriterion("dopt_id in", values, "doptId");
            return (Criteria) this;
        }

        public Criteria andDoptIdNotIn(List<Integer> values) {
            addCriterion("dopt_id not in", values, "doptId");
            return (Criteria) this;
        }

        public Criteria andDoptIdBetween(Integer value1, Integer value2) {
            addCriterion("dopt_id between", value1, value2, "doptId");
            return (Criteria) this;
        }

        public Criteria andDoptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dopt_id not between", value1, value2, "doptId");
            return (Criteria) this;
        }

        public Criteria andDIdIsNull() {
            addCriterion("d_id is null");
            return (Criteria) this;
        }

        public Criteria andDIdIsNotNull() {
            addCriterion("d_id is not null");
            return (Criteria) this;
        }

        public Criteria andDIdEqualTo(Integer value) {
            addCriterion("d_id =", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotEqualTo(Integer value) {
            addCriterion("d_id <>", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdGreaterThan(Integer value) {
            addCriterion("d_id >", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_id >=", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdLessThan(Integer value) {
            addCriterion("d_id <", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdLessThanOrEqualTo(Integer value) {
            addCriterion("d_id <=", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdIn(List<Integer> values) {
            addCriterion("d_id in", values, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotIn(List<Integer> values) {
            addCriterion("d_id not in", values, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdBetween(Integer value1, Integer value2) {
            addCriterion("d_id between", value1, value2, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotBetween(Integer value1, Integer value2) {
            addCriterion("d_id not between", value1, value2, "dId");
            return (Criteria) this;
        }

        public Criteria andDoptNameIsNull() {
            addCriterion("dopt_name is null");
            return (Criteria) this;
        }

        public Criteria andDoptNameIsNotNull() {
            addCriterion("dopt_name is not null");
            return (Criteria) this;
        }

        public Criteria andDoptNameEqualTo(String value) {
            addCriterion("dopt_name =", value, "doptName");
            return (Criteria) this;
        }

        public Criteria andDoptNameNotEqualTo(String value) {
            addCriterion("dopt_name <>", value, "doptName");
            return (Criteria) this;
        }

        public Criteria andDoptNameGreaterThan(String value) {
            addCriterion("dopt_name >", value, "doptName");
            return (Criteria) this;
        }

        public Criteria andDoptNameGreaterThanOrEqualTo(String value) {
            addCriterion("dopt_name >=", value, "doptName");
            return (Criteria) this;
        }

        public Criteria andDoptNameLessThan(String value) {
            addCriterion("dopt_name <", value, "doptName");
            return (Criteria) this;
        }

        public Criteria andDoptNameLessThanOrEqualTo(String value) {
            addCriterion("dopt_name <=", value, "doptName");
            return (Criteria) this;
        }

        public Criteria andDoptNameLike(String value) {
            addCriterion("dopt_name like", value, "doptName");
            return (Criteria) this;
        }

        public Criteria andDoptNameNotLike(String value) {
            addCriterion("dopt_name not like", value, "doptName");
            return (Criteria) this;
        }

        public Criteria andDoptNameIn(List<String> values) {
            addCriterion("dopt_name in", values, "doptName");
            return (Criteria) this;
        }

        public Criteria andDoptNameNotIn(List<String> values) {
            addCriterion("dopt_name not in", values, "doptName");
            return (Criteria) this;
        }

        public Criteria andDoptNameBetween(String value1, String value2) {
            addCriterion("dopt_name between", value1, value2, "doptName");
            return (Criteria) this;
        }

        public Criteria andDoptNameNotBetween(String value1, String value2) {
            addCriterion("dopt_name not between", value1, value2, "doptName");
            return (Criteria) this;
        }

        public Criteria andDoptTypeIsNull() {
            addCriterion("dopt_type is null");
            return (Criteria) this;
        }

        public Criteria andDoptTypeIsNotNull() {
            addCriterion("dopt_type is not null");
            return (Criteria) this;
        }

        public Criteria andDoptTypeEqualTo(String value) {
            addCriterion("dopt_type =", value, "doptType");
            return (Criteria) this;
        }

        public Criteria andDoptTypeNotEqualTo(String value) {
            addCriterion("dopt_type <>", value, "doptType");
            return (Criteria) this;
        }

        public Criteria andDoptTypeGreaterThan(String value) {
            addCriterion("dopt_type >", value, "doptType");
            return (Criteria) this;
        }

        public Criteria andDoptTypeGreaterThanOrEqualTo(String value) {
            addCriterion("dopt_type >=", value, "doptType");
            return (Criteria) this;
        }

        public Criteria andDoptTypeLessThan(String value) {
            addCriterion("dopt_type <", value, "doptType");
            return (Criteria) this;
        }

        public Criteria andDoptTypeLessThanOrEqualTo(String value) {
            addCriterion("dopt_type <=", value, "doptType");
            return (Criteria) this;
        }

        public Criteria andDoptTypeLike(String value) {
            addCriterion("dopt_type like", value, "doptType");
            return (Criteria) this;
        }

        public Criteria andDoptTypeNotLike(String value) {
            addCriterion("dopt_type not like", value, "doptType");
            return (Criteria) this;
        }

        public Criteria andDoptTypeIn(List<String> values) {
            addCriterion("dopt_type in", values, "doptType");
            return (Criteria) this;
        }

        public Criteria andDoptTypeNotIn(List<String> values) {
            addCriterion("dopt_type not in", values, "doptType");
            return (Criteria) this;
        }

        public Criteria andDoptTypeBetween(String value1, String value2) {
            addCriterion("dopt_type between", value1, value2, "doptType");
            return (Criteria) this;
        }

        public Criteria andDoptTypeNotBetween(String value1, String value2) {
            addCriterion("dopt_type not between", value1, value2, "doptType");
            return (Criteria) this;
        }

        public Criteria andDoptTimeIsNull() {
            addCriterion("dopt_time is null");
            return (Criteria) this;
        }

        public Criteria andDoptTimeIsNotNull() {
            addCriterion("dopt_time is not null");
            return (Criteria) this;
        }

        public Criteria andDoptTimeEqualTo(Date value) {
            addCriterion("dopt_time =", value, "doptTime");
            return (Criteria) this;
        }

        public Criteria andDoptTimeNotEqualTo(Date value) {
            addCriterion("dopt_time <>", value, "doptTime");
            return (Criteria) this;
        }

        public Criteria andDoptTimeGreaterThan(Date value) {
            addCriterion("dopt_time >", value, "doptTime");
            return (Criteria) this;
        }

        public Criteria andDoptTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dopt_time >=", value, "doptTime");
            return (Criteria) this;
        }

        public Criteria andDoptTimeLessThan(Date value) {
            addCriterion("dopt_time <", value, "doptTime");
            return (Criteria) this;
        }

        public Criteria andDoptTimeLessThanOrEqualTo(Date value) {
            addCriterion("dopt_time <=", value, "doptTime");
            return (Criteria) this;
        }

        public Criteria andDoptTimeIn(List<Date> values) {
            addCriterion("dopt_time in", values, "doptTime");
            return (Criteria) this;
        }

        public Criteria andDoptTimeNotIn(List<Date> values) {
            addCriterion("dopt_time not in", values, "doptTime");
            return (Criteria) this;
        }

        public Criteria andDoptTimeBetween(Date value1, Date value2) {
            addCriterion("dopt_time between", value1, value2, "doptTime");
            return (Criteria) this;
        }

        public Criteria andDoptTimeNotBetween(Date value1, Date value2) {
            addCriterion("dopt_time not between", value1, value2, "doptTime");
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