package com.kmdms.pojo;

import java.util.ArrayList;
import java.util.List;

public class BuildingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuildingExample() {
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

        public Criteria andBuildingIdIsNull() {
            addCriterion("building_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("building_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(String value) {
            addCriterion("building_id =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(String value) {
            addCriterion("building_id <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(String value) {
            addCriterion("building_id >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(String value) {
            addCriterion("building_id >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(String value) {
            addCriterion("building_id <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(String value) {
            addCriterion("building_id <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLike(String value) {
            addCriterion("building_id like", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotLike(String value) {
            addCriterion("building_id not like", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<String> values) {
            addCriterion("building_id in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<String> values) {
            addCriterion("building_id not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(String value1, String value2) {
            addCriterion("building_id between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(String value1, String value2) {
            addCriterion("building_id not between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIsNull() {
            addCriterion("building_name is null");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIsNotNull() {
            addCriterion("building_name is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingNameEqualTo(String value) {
            addCriterion("building_name =", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotEqualTo(String value) {
            addCriterion("building_name <>", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameGreaterThan(String value) {
            addCriterion("building_name >", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameGreaterThanOrEqualTo(String value) {
            addCriterion("building_name >=", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLessThan(String value) {
            addCriterion("building_name <", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLessThanOrEqualTo(String value) {
            addCriterion("building_name <=", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameLike(String value) {
            addCriterion("building_name like", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotLike(String value) {
            addCriterion("building_name not like", value, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameIn(List<String> values) {
            addCriterion("building_name in", values, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotIn(List<String> values) {
            addCriterion("building_name not in", values, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameBetween(String value1, String value2) {
            addCriterion("building_name between", value1, value2, "buildingName");
            return (Criteria) this;
        }

        public Criteria andBuildingNameNotBetween(String value1, String value2) {
            addCriterion("building_name not between", value1, value2, "buildingName");
            return (Criteria) this;
        }

        public Criteria andFloorcountIsNull() {
            addCriterion("floorCount is null");
            return (Criteria) this;
        }

        public Criteria andFloorcountIsNotNull() {
            addCriterion("floorCount is not null");
            return (Criteria) this;
        }

        public Criteria andFloorcountEqualTo(Integer value) {
            addCriterion("floorCount =", value, "floorcount");
            return (Criteria) this;
        }

        public Criteria andFloorcountNotEqualTo(Integer value) {
            addCriterion("floorCount <>", value, "floorcount");
            return (Criteria) this;
        }

        public Criteria andFloorcountGreaterThan(Integer value) {
            addCriterion("floorCount >", value, "floorcount");
            return (Criteria) this;
        }

        public Criteria andFloorcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("floorCount >=", value, "floorcount");
            return (Criteria) this;
        }

        public Criteria andFloorcountLessThan(Integer value) {
            addCriterion("floorCount <", value, "floorcount");
            return (Criteria) this;
        }

        public Criteria andFloorcountLessThanOrEqualTo(Integer value) {
            addCriterion("floorCount <=", value, "floorcount");
            return (Criteria) this;
        }

        public Criteria andFloorcountIn(List<Integer> values) {
            addCriterion("floorCount in", values, "floorcount");
            return (Criteria) this;
        }

        public Criteria andFloorcountNotIn(List<Integer> values) {
            addCriterion("floorCount not in", values, "floorcount");
            return (Criteria) this;
        }

        public Criteria andFloorcountBetween(Integer value1, Integer value2) {
            addCriterion("floorCount between", value1, value2, "floorcount");
            return (Criteria) this;
        }

        public Criteria andFloorcountNotBetween(Integer value1, Integer value2) {
            addCriterion("floorCount not between", value1, value2, "floorcount");
            return (Criteria) this;
        }

        public Criteria andDcountIsNull() {
            addCriterion("dCount is null");
            return (Criteria) this;
        }

        public Criteria andDcountIsNotNull() {
            addCriterion("dCount is not null");
            return (Criteria) this;
        }

        public Criteria andDcountEqualTo(Integer value) {
            addCriterion("dCount =", value, "dcount");
            return (Criteria) this;
        }

        public Criteria andDcountNotEqualTo(Integer value) {
            addCriterion("dCount <>", value, "dcount");
            return (Criteria) this;
        }

        public Criteria andDcountGreaterThan(Integer value) {
            addCriterion("dCount >", value, "dcount");
            return (Criteria) this;
        }

        public Criteria andDcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("dCount >=", value, "dcount");
            return (Criteria) this;
        }

        public Criteria andDcountLessThan(Integer value) {
            addCriterion("dCount <", value, "dcount");
            return (Criteria) this;
        }

        public Criteria andDcountLessThanOrEqualTo(Integer value) {
            addCriterion("dCount <=", value, "dcount");
            return (Criteria) this;
        }

        public Criteria andDcountIn(List<Integer> values) {
            addCriterion("dCount in", values, "dcount");
            return (Criteria) this;
        }

        public Criteria andDcountNotIn(List<Integer> values) {
            addCriterion("dCount not in", values, "dcount");
            return (Criteria) this;
        }

        public Criteria andDcountBetween(Integer value1, Integer value2) {
            addCriterion("dCount between", value1, value2, "dcount");
            return (Criteria) this;
        }

        public Criteria andDcountNotBetween(Integer value1, Integer value2) {
            addCriterion("dCount not between", value1, value2, "dcount");
            return (Criteria) this;
        }

        public Criteria andTotaldcountIsNull() {
            addCriterion("totalDCount is null");
            return (Criteria) this;
        }

        public Criteria andTotaldcountIsNotNull() {
            addCriterion("totalDCount is not null");
            return (Criteria) this;
        }

        public Criteria andTotaldcountEqualTo(Integer value) {
            addCriterion("totalDCount =", value, "totaldcount");
            return (Criteria) this;
        }

        public Criteria andTotaldcountNotEqualTo(Integer value) {
            addCriterion("totalDCount <>", value, "totaldcount");
            return (Criteria) this;
        }

        public Criteria andTotaldcountGreaterThan(Integer value) {
            addCriterion("totalDCount >", value, "totaldcount");
            return (Criteria) this;
        }

        public Criteria andTotaldcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalDCount >=", value, "totaldcount");
            return (Criteria) this;
        }

        public Criteria andTotaldcountLessThan(Integer value) {
            addCriterion("totalDCount <", value, "totaldcount");
            return (Criteria) this;
        }

        public Criteria andTotaldcountLessThanOrEqualTo(Integer value) {
            addCriterion("totalDCount <=", value, "totaldcount");
            return (Criteria) this;
        }

        public Criteria andTotaldcountIn(List<Integer> values) {
            addCriterion("totalDCount in", values, "totaldcount");
            return (Criteria) this;
        }

        public Criteria andTotaldcountNotIn(List<Integer> values) {
            addCriterion("totalDCount not in", values, "totaldcount");
            return (Criteria) this;
        }

        public Criteria andTotaldcountBetween(Integer value1, Integer value2) {
            addCriterion("totalDCount between", value1, value2, "totaldcount");
            return (Criteria) this;
        }

        public Criteria andTotaldcountNotBetween(Integer value1, Integer value2) {
            addCriterion("totalDCount not between", value1, value2, "totaldcount");
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