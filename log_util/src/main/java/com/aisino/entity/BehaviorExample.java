package com.aisino.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BehaviorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BehaviorExample() {
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

        public Criteria andTaxcodeIsNull() {
            addCriterion("taxcode is null");
            return (Criteria) this;
        }

        public Criteria andTaxcodeIsNotNull() {
            addCriterion("taxcode is not null");
            return (Criteria) this;
        }

        public Criteria andTaxcodeEqualTo(String value) {
            addCriterion("taxcode =", value, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeNotEqualTo(String value) {
            addCriterion("taxcode <>", value, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeGreaterThan(String value) {
            addCriterion("taxcode >", value, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeGreaterThanOrEqualTo(String value) {
            addCriterion("taxcode >=", value, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeLessThan(String value) {
            addCriterion("taxcode <", value, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeLessThanOrEqualTo(String value) {
            addCriterion("taxcode <=", value, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeLike(String value) {
            addCriterion("taxcode like", value, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeNotLike(String value) {
            addCriterion("taxcode not like", value, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeIn(List<String> values) {
            addCriterion("taxcode in", values, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeNotIn(List<String> values) {
            addCriterion("taxcode not in", values, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeBetween(String value1, String value2) {
            addCriterion("taxcode between", value1, value2, "taxcode");
            return (Criteria) this;
        }

        public Criteria andTaxcodeNotBetween(String value1, String value2) {
            addCriterion("taxcode not between", value1, value2, "taxcode");
            return (Criteria) this;
        }

        public Criteria andMachinenoIsNull() {
            addCriterion("machineno is null");
            return (Criteria) this;
        }

        public Criteria andMachinenoIsNotNull() {
            addCriterion("machineno is not null");
            return (Criteria) this;
        }

        public Criteria andMachinenoEqualTo(Integer value) {
            addCriterion("machineno =", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoNotEqualTo(Integer value) {
            addCriterion("machineno <>", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoGreaterThan(Integer value) {
            addCriterion("machineno >", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoGreaterThanOrEqualTo(Integer value) {
            addCriterion("machineno >=", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoLessThan(Integer value) {
            addCriterion("machineno <", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoLessThanOrEqualTo(Integer value) {
            addCriterion("machineno <=", value, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoIn(List<Integer> values) {
            addCriterion("machineno in", values, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoNotIn(List<Integer> values) {
            addCriterion("machineno not in", values, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoBetween(Integer value1, Integer value2) {
            addCriterion("machineno between", value1, value2, "machineno");
            return (Criteria) this;
        }

        public Criteria andMachinenoNotBetween(Integer value1, Integer value2) {
            addCriterion("machineno not between", value1, value2, "machineno");
            return (Criteria) this;
        }

        public Criteria andModuleIsNull() {
            addCriterion("module is null");
            return (Criteria) this;
        }

        public Criteria andModuleIsNotNull() {
            addCriterion("module is not null");
            return (Criteria) this;
        }

        public Criteria andModuleEqualTo(String value) {
            addCriterion("module =", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotEqualTo(String value) {
            addCriterion("module <>", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleGreaterThan(String value) {
            addCriterion("module >", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleGreaterThanOrEqualTo(String value) {
            addCriterion("module >=", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLessThan(String value) {
            addCriterion("module <", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLessThanOrEqualTo(String value) {
            addCriterion("module <=", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLike(String value) {
            addCriterion("module like", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotLike(String value) {
            addCriterion("module not like", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleIn(List<String> values) {
            addCriterion("module in", values, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotIn(List<String> values) {
            addCriterion("module not in", values, "module");
            return (Criteria) this;
        }

        public Criteria andModuleBetween(String value1, String value2) {
            addCriterion("module between", value1, value2, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotBetween(String value1, String value2) {
            addCriterion("module not between", value1, value2, "module");
            return (Criteria) this;
        }

        public Criteria andModuletypeIsNull() {
            addCriterion("moduletype is null");
            return (Criteria) this;
        }

        public Criteria andModuletypeIsNotNull() {
            addCriterion("moduletype is not null");
            return (Criteria) this;
        }

        public Criteria andModuletypeEqualTo(String value) {
            addCriterion("moduletype =", value, "moduletype");
            return (Criteria) this;
        }

        public Criteria andModuletypeNotEqualTo(String value) {
            addCriterion("moduletype <>", value, "moduletype");
            return (Criteria) this;
        }

        public Criteria andModuletypeGreaterThan(String value) {
            addCriterion("moduletype >", value, "moduletype");
            return (Criteria) this;
        }

        public Criteria andModuletypeGreaterThanOrEqualTo(String value) {
            addCriterion("moduletype >=", value, "moduletype");
            return (Criteria) this;
        }

        public Criteria andModuletypeLessThan(String value) {
            addCriterion("moduletype <", value, "moduletype");
            return (Criteria) this;
        }

        public Criteria andModuletypeLessThanOrEqualTo(String value) {
            addCriterion("moduletype <=", value, "moduletype");
            return (Criteria) this;
        }

        public Criteria andModuletypeLike(String value) {
            addCriterion("moduletype like", value, "moduletype");
            return (Criteria) this;
        }

        public Criteria andModuletypeNotLike(String value) {
            addCriterion("moduletype not like", value, "moduletype");
            return (Criteria) this;
        }

        public Criteria andModuletypeIn(List<String> values) {
            addCriterion("moduletype in", values, "moduletype");
            return (Criteria) this;
        }

        public Criteria andModuletypeNotIn(List<String> values) {
            addCriterion("moduletype not in", values, "moduletype");
            return (Criteria) this;
        }

        public Criteria andModuletypeBetween(String value1, String value2) {
            addCriterion("moduletype between", value1, value2, "moduletype");
            return (Criteria) this;
        }

        public Criteria andModuletypeNotBetween(String value1, String value2) {
            addCriterion("moduletype not between", value1, value2, "moduletype");
            return (Criteria) this;
        }

        public Criteria andModulefatherIsNull() {
            addCriterion("modulefather is null");
            return (Criteria) this;
        }

        public Criteria andModulefatherIsNotNull() {
            addCriterion("modulefather is not null");
            return (Criteria) this;
        }

        public Criteria andModulefatherEqualTo(String value) {
            addCriterion("modulefather =", value, "modulefather");
            return (Criteria) this;
        }

        public Criteria andModulefatherNotEqualTo(String value) {
            addCriterion("modulefather <>", value, "modulefather");
            return (Criteria) this;
        }

        public Criteria andModulefatherGreaterThan(String value) {
            addCriterion("modulefather >", value, "modulefather");
            return (Criteria) this;
        }

        public Criteria andModulefatherGreaterThanOrEqualTo(String value) {
            addCriterion("modulefather >=", value, "modulefather");
            return (Criteria) this;
        }

        public Criteria andModulefatherLessThan(String value) {
            addCriterion("modulefather <", value, "modulefather");
            return (Criteria) this;
        }

        public Criteria andModulefatherLessThanOrEqualTo(String value) {
            addCriterion("modulefather <=", value, "modulefather");
            return (Criteria) this;
        }

        public Criteria andModulefatherLike(String value) {
            addCriterion("modulefather like", value, "modulefather");
            return (Criteria) this;
        }

        public Criteria andModulefatherNotLike(String value) {
            addCriterion("modulefather not like", value, "modulefather");
            return (Criteria) this;
        }

        public Criteria andModulefatherIn(List<String> values) {
            addCriterion("modulefather in", values, "modulefather");
            return (Criteria) this;
        }

        public Criteria andModulefatherNotIn(List<String> values) {
            addCriterion("modulefather not in", values, "modulefather");
            return (Criteria) this;
        }

        public Criteria andModulefatherBetween(String value1, String value2) {
            addCriterion("modulefather between", value1, value2, "modulefather");
            return (Criteria) this;
        }

        public Criteria andModulefatherNotBetween(String value1, String value2) {
            addCriterion("modulefather not between", value1, value2, "modulefather");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andActionIsNull() {
            addCriterion("action is null");
            return (Criteria) this;
        }

        public Criteria andActionIsNotNull() {
            addCriterion("action is not null");
            return (Criteria) this;
        }

        public Criteria andActionEqualTo(String value) {
            addCriterion("action =", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotEqualTo(String value) {
            addCriterion("action <>", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThan(String value) {
            addCriterion("action >", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThanOrEqualTo(String value) {
            addCriterion("action >=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThan(String value) {
            addCriterion("action <", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThanOrEqualTo(String value) {
            addCriterion("action <=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLike(String value) {
            addCriterion("action like", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotLike(String value) {
            addCriterion("action not like", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionIn(List<String> values) {
            addCriterion("action in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotIn(List<String> values) {
            addCriterion("action not in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionBetween(String value1, String value2) {
            addCriterion("action between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotBetween(String value1, String value2) {
            addCriterion("action not between", value1, value2, "action");
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