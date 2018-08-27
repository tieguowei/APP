package com.resale.foreground.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoleOptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleOptExample() {
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

        public Criteria andRoptIdIsNull() {
            addCriterion("ropt_id is null");
            return (Criteria) this;
        }

        public Criteria andRoptIdIsNotNull() {
            addCriterion("ropt_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoptIdEqualTo(Integer value) {
            addCriterion("ropt_id =", value, "roptId");
            return (Criteria) this;
        }

        public Criteria andRoptIdNotEqualTo(Integer value) {
            addCriterion("ropt_id <>", value, "roptId");
            return (Criteria) this;
        }

        public Criteria andRoptIdGreaterThan(Integer value) {
            addCriterion("ropt_id >", value, "roptId");
            return (Criteria) this;
        }

        public Criteria andRoptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ropt_id >=", value, "roptId");
            return (Criteria) this;
        }

        public Criteria andRoptIdLessThan(Integer value) {
            addCriterion("ropt_id <", value, "roptId");
            return (Criteria) this;
        }

        public Criteria andRoptIdLessThanOrEqualTo(Integer value) {
            addCriterion("ropt_id <=", value, "roptId");
            return (Criteria) this;
        }

        public Criteria andRoptIdIn(List<Integer> values) {
            addCriterion("ropt_id in", values, "roptId");
            return (Criteria) this;
        }

        public Criteria andRoptIdNotIn(List<Integer> values) {
            addCriterion("ropt_id not in", values, "roptId");
            return (Criteria) this;
        }

        public Criteria andRoptIdBetween(Integer value1, Integer value2) {
            addCriterion("ropt_id between", value1, value2, "roptId");
            return (Criteria) this;
        }

        public Criteria andRoptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ropt_id not between", value1, value2, "roptId");
            return (Criteria) this;
        }

        public Criteria andRIdIsNull() {
            addCriterion("r_id is null");
            return (Criteria) this;
        }

        public Criteria andRIdIsNotNull() {
            addCriterion("r_id is not null");
            return (Criteria) this;
        }

        public Criteria andRIdEqualTo(Integer value) {
            addCriterion("r_id =", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotEqualTo(Integer value) {
            addCriterion("r_id <>", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThan(Integer value) {
            addCriterion("r_id >", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_id >=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThan(Integer value) {
            addCriterion("r_id <", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThanOrEqualTo(Integer value) {
            addCriterion("r_id <=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdIn(List<Integer> values) {
            addCriterion("r_id in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotIn(List<Integer> values) {
            addCriterion("r_id not in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdBetween(Integer value1, Integer value2) {
            addCriterion("r_id between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotBetween(Integer value1, Integer value2) {
            addCriterion("r_id not between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRoptNameIsNull() {
            addCriterion("ropt_name is null");
            return (Criteria) this;
        }

        public Criteria andRoptNameIsNotNull() {
            addCriterion("ropt_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoptNameEqualTo(String value) {
            addCriterion("ropt_name =", value, "roptName");
            return (Criteria) this;
        }

        public Criteria andRoptNameNotEqualTo(String value) {
            addCriterion("ropt_name <>", value, "roptName");
            return (Criteria) this;
        }

        public Criteria andRoptNameGreaterThan(String value) {
            addCriterion("ropt_name >", value, "roptName");
            return (Criteria) this;
        }

        public Criteria andRoptNameGreaterThanOrEqualTo(String value) {
            addCriterion("ropt_name >=", value, "roptName");
            return (Criteria) this;
        }

        public Criteria andRoptNameLessThan(String value) {
            addCriterion("ropt_name <", value, "roptName");
            return (Criteria) this;
        }

        public Criteria andRoptNameLessThanOrEqualTo(String value) {
            addCriterion("ropt_name <=", value, "roptName");
            return (Criteria) this;
        }

        public Criteria andRoptNameLike(String value) {
            addCriterion("ropt_name like", value, "roptName");
            return (Criteria) this;
        }

        public Criteria andRoptNameNotLike(String value) {
            addCriterion("ropt_name not like", value, "roptName");
            return (Criteria) this;
        }

        public Criteria andRoptNameIn(List<String> values) {
            addCriterion("ropt_name in", values, "roptName");
            return (Criteria) this;
        }

        public Criteria andRoptNameNotIn(List<String> values) {
            addCriterion("ropt_name not in", values, "roptName");
            return (Criteria) this;
        }

        public Criteria andRoptNameBetween(String value1, String value2) {
            addCriterion("ropt_name between", value1, value2, "roptName");
            return (Criteria) this;
        }

        public Criteria andRoptNameNotBetween(String value1, String value2) {
            addCriterion("ropt_name not between", value1, value2, "roptName");
            return (Criteria) this;
        }

        public Criteria andRoptTypeIsNull() {
            addCriterion("ropt_type is null");
            return (Criteria) this;
        }

        public Criteria andRoptTypeIsNotNull() {
            addCriterion("ropt_type is not null");
            return (Criteria) this;
        }

        public Criteria andRoptTypeEqualTo(String value) {
            addCriterion("ropt_type =", value, "roptType");
            return (Criteria) this;
        }

        public Criteria andRoptTypeNotEqualTo(String value) {
            addCriterion("ropt_type <>", value, "roptType");
            return (Criteria) this;
        }

        public Criteria andRoptTypeGreaterThan(String value) {
            addCriterion("ropt_type >", value, "roptType");
            return (Criteria) this;
        }

        public Criteria andRoptTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ropt_type >=", value, "roptType");
            return (Criteria) this;
        }

        public Criteria andRoptTypeLessThan(String value) {
            addCriterion("ropt_type <", value, "roptType");
            return (Criteria) this;
        }

        public Criteria andRoptTypeLessThanOrEqualTo(String value) {
            addCriterion("ropt_type <=", value, "roptType");
            return (Criteria) this;
        }

        public Criteria andRoptTypeLike(String value) {
            addCriterion("ropt_type like", value, "roptType");
            return (Criteria) this;
        }

        public Criteria andRoptTypeNotLike(String value) {
            addCriterion("ropt_type not like", value, "roptType");
            return (Criteria) this;
        }

        public Criteria andRoptTypeIn(List<String> values) {
            addCriterion("ropt_type in", values, "roptType");
            return (Criteria) this;
        }

        public Criteria andRoptTypeNotIn(List<String> values) {
            addCriterion("ropt_type not in", values, "roptType");
            return (Criteria) this;
        }

        public Criteria andRoptTypeBetween(String value1, String value2) {
            addCriterion("ropt_type between", value1, value2, "roptType");
            return (Criteria) this;
        }

        public Criteria andRoptTypeNotBetween(String value1, String value2) {
            addCriterion("ropt_type not between", value1, value2, "roptType");
            return (Criteria) this;
        }

        public Criteria andRoptTimeIsNull() {
            addCriterion("ropt_time is null");
            return (Criteria) this;
        }

        public Criteria andRoptTimeIsNotNull() {
            addCriterion("ropt_time is not null");
            return (Criteria) this;
        }

        public Criteria andRoptTimeEqualTo(Date value) {
            addCriterion("ropt_time =", value, "roptTime");
            return (Criteria) this;
        }

        public Criteria andRoptTimeNotEqualTo(Date value) {
            addCriterion("ropt_time <>", value, "roptTime");
            return (Criteria) this;
        }

        public Criteria andRoptTimeGreaterThan(Date value) {
            addCriterion("ropt_time >", value, "roptTime");
            return (Criteria) this;
        }

        public Criteria andRoptTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ropt_time >=", value, "roptTime");
            return (Criteria) this;
        }

        public Criteria andRoptTimeLessThan(Date value) {
            addCriterion("ropt_time <", value, "roptTime");
            return (Criteria) this;
        }

        public Criteria andRoptTimeLessThanOrEqualTo(Date value) {
            addCriterion("ropt_time <=", value, "roptTime");
            return (Criteria) this;
        }

        public Criteria andRoptTimeIn(List<Date> values) {
            addCriterion("ropt_time in", values, "roptTime");
            return (Criteria) this;
        }

        public Criteria andRoptTimeNotIn(List<Date> values) {
            addCriterion("ropt_time not in", values, "roptTime");
            return (Criteria) this;
        }

        public Criteria andRoptTimeBetween(Date value1, Date value2) {
            addCriterion("ropt_time between", value1, value2, "roptTime");
            return (Criteria) this;
        }

        public Criteria andRoptTimeNotBetween(Date value1, Date value2) {
            addCriterion("ropt_time not between", value1, value2, "roptTime");
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