package com.resale.foreground.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserOptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserOptExample() {
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

        public Criteria andUoptIdIsNull() {
            addCriterion("uopt_id is null");
            return (Criteria) this;
        }

        public Criteria andUoptIdIsNotNull() {
            addCriterion("uopt_id is not null");
            return (Criteria) this;
        }

        public Criteria andUoptIdEqualTo(Integer value) {
            addCriterion("uopt_id =", value, "uoptId");
            return (Criteria) this;
        }

        public Criteria andUoptIdNotEqualTo(Integer value) {
            addCriterion("uopt_id <>", value, "uoptId");
            return (Criteria) this;
        }

        public Criteria andUoptIdGreaterThan(Integer value) {
            addCriterion("uopt_id >", value, "uoptId");
            return (Criteria) this;
        }

        public Criteria andUoptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("uopt_id >=", value, "uoptId");
            return (Criteria) this;
        }

        public Criteria andUoptIdLessThan(Integer value) {
            addCriterion("uopt_id <", value, "uoptId");
            return (Criteria) this;
        }

        public Criteria andUoptIdLessThanOrEqualTo(Integer value) {
            addCriterion("uopt_id <=", value, "uoptId");
            return (Criteria) this;
        }

        public Criteria andUoptIdIn(List<Integer> values) {
            addCriterion("uopt_id in", values, "uoptId");
            return (Criteria) this;
        }

        public Criteria andUoptIdNotIn(List<Integer> values) {
            addCriterion("uopt_id not in", values, "uoptId");
            return (Criteria) this;
        }

        public Criteria andUoptIdBetween(Integer value1, Integer value2) {
            addCriterion("uopt_id between", value1, value2, "uoptId");
            return (Criteria) this;
        }

        public Criteria andUoptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("uopt_id not between", value1, value2, "uoptId");
            return (Criteria) this;
        }

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUoptNameIsNull() {
            addCriterion("uopt_name is null");
            return (Criteria) this;
        }

        public Criteria andUoptNameIsNotNull() {
            addCriterion("uopt_name is not null");
            return (Criteria) this;
        }

        public Criteria andUoptNameEqualTo(String value) {
            addCriterion("uopt_name =", value, "uoptName");
            return (Criteria) this;
        }

        public Criteria andUoptNameNotEqualTo(String value) {
            addCriterion("uopt_name <>", value, "uoptName");
            return (Criteria) this;
        }

        public Criteria andUoptNameGreaterThan(String value) {
            addCriterion("uopt_name >", value, "uoptName");
            return (Criteria) this;
        }

        public Criteria andUoptNameGreaterThanOrEqualTo(String value) {
            addCriterion("uopt_name >=", value, "uoptName");
            return (Criteria) this;
        }

        public Criteria andUoptNameLessThan(String value) {
            addCriterion("uopt_name <", value, "uoptName");
            return (Criteria) this;
        }

        public Criteria andUoptNameLessThanOrEqualTo(String value) {
            addCriterion("uopt_name <=", value, "uoptName");
            return (Criteria) this;
        }

        public Criteria andUoptNameLike(String value) {
            addCriterion("uopt_name like", value, "uoptName");
            return (Criteria) this;
        }

        public Criteria andUoptNameNotLike(String value) {
            addCriterion("uopt_name not like", value, "uoptName");
            return (Criteria) this;
        }

        public Criteria andUoptNameIn(List<String> values) {
            addCriterion("uopt_name in", values, "uoptName");
            return (Criteria) this;
        }

        public Criteria andUoptNameNotIn(List<String> values) {
            addCriterion("uopt_name not in", values, "uoptName");
            return (Criteria) this;
        }

        public Criteria andUoptNameBetween(String value1, String value2) {
            addCriterion("uopt_name between", value1, value2, "uoptName");
            return (Criteria) this;
        }

        public Criteria andUoptNameNotBetween(String value1, String value2) {
            addCriterion("uopt_name not between", value1, value2, "uoptName");
            return (Criteria) this;
        }

        public Criteria andUoptTypeIsNull() {
            addCriterion("uopt_type is null");
            return (Criteria) this;
        }

        public Criteria andUoptTypeIsNotNull() {
            addCriterion("uopt_type is not null");
            return (Criteria) this;
        }

        public Criteria andUoptTypeEqualTo(String value) {
            addCriterion("uopt_type =", value, "uoptType");
            return (Criteria) this;
        }

        public Criteria andUoptTypeNotEqualTo(String value) {
            addCriterion("uopt_type <>", value, "uoptType");
            return (Criteria) this;
        }

        public Criteria andUoptTypeGreaterThan(String value) {
            addCriterion("uopt_type >", value, "uoptType");
            return (Criteria) this;
        }

        public Criteria andUoptTypeGreaterThanOrEqualTo(String value) {
            addCriterion("uopt_type >=", value, "uoptType");
            return (Criteria) this;
        }

        public Criteria andUoptTypeLessThan(String value) {
            addCriterion("uopt_type <", value, "uoptType");
            return (Criteria) this;
        }

        public Criteria andUoptTypeLessThanOrEqualTo(String value) {
            addCriterion("uopt_type <=", value, "uoptType");
            return (Criteria) this;
        }

        public Criteria andUoptTypeLike(String value) {
            addCriterion("uopt_type like", value, "uoptType");
            return (Criteria) this;
        }

        public Criteria andUoptTypeNotLike(String value) {
            addCriterion("uopt_type not like", value, "uoptType");
            return (Criteria) this;
        }

        public Criteria andUoptTypeIn(List<String> values) {
            addCriterion("uopt_type in", values, "uoptType");
            return (Criteria) this;
        }

        public Criteria andUoptTypeNotIn(List<String> values) {
            addCriterion("uopt_type not in", values, "uoptType");
            return (Criteria) this;
        }

        public Criteria andUoptTypeBetween(String value1, String value2) {
            addCriterion("uopt_type between", value1, value2, "uoptType");
            return (Criteria) this;
        }

        public Criteria andUoptTypeNotBetween(String value1, String value2) {
            addCriterion("uopt_type not between", value1, value2, "uoptType");
            return (Criteria) this;
        }

        public Criteria andUoptTimeIsNull() {
            addCriterion("uopt_time is null");
            return (Criteria) this;
        }

        public Criteria andUoptTimeIsNotNull() {
            addCriterion("uopt_time is not null");
            return (Criteria) this;
        }

        public Criteria andUoptTimeEqualTo(Date value) {
            addCriterion("uopt_time =", value, "uoptTime");
            return (Criteria) this;
        }

        public Criteria andUoptTimeNotEqualTo(Date value) {
            addCriterion("uopt_time <>", value, "uoptTime");
            return (Criteria) this;
        }

        public Criteria andUoptTimeGreaterThan(Date value) {
            addCriterion("uopt_time >", value, "uoptTime");
            return (Criteria) this;
        }

        public Criteria andUoptTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("uopt_time >=", value, "uoptTime");
            return (Criteria) this;
        }

        public Criteria andUoptTimeLessThan(Date value) {
            addCriterion("uopt_time <", value, "uoptTime");
            return (Criteria) this;
        }

        public Criteria andUoptTimeLessThanOrEqualTo(Date value) {
            addCriterion("uopt_time <=", value, "uoptTime");
            return (Criteria) this;
        }

        public Criteria andUoptTimeIn(List<Date> values) {
            addCriterion("uopt_time in", values, "uoptTime");
            return (Criteria) this;
        }

        public Criteria andUoptTimeNotIn(List<Date> values) {
            addCriterion("uopt_time not in", values, "uoptTime");
            return (Criteria) this;
        }

        public Criteria andUoptTimeBetween(Date value1, Date value2) {
            addCriterion("uopt_time between", value1, value2, "uoptTime");
            return (Criteria) this;
        }

        public Criteria andUoptTimeNotBetween(Date value1, Date value2) {
            addCriterion("uopt_time not between", value1, value2, "uoptTime");
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