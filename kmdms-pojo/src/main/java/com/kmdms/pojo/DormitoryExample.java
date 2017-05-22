package com.kmdms.pojo;

import java.util.ArrayList;
import java.util.List;

public class DormitoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DormitoryExample() {
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

        public Criteria andDormitoryIdIsNull() {
            addCriterion("dormitory_id is null");
            return (Criteria) this;
        }

        public Criteria andDormitoryIdIsNotNull() {
            addCriterion("dormitory_id is not null");
            return (Criteria) this;
        }

        public Criteria andDormitoryIdEqualTo(String value) {
            addCriterion("dormitory_id =", value, "dormitoryId");
            return (Criteria) this;
        }

        public Criteria andDormitoryIdNotEqualTo(String value) {
            addCriterion("dormitory_id <>", value, "dormitoryId");
            return (Criteria) this;
        }

        public Criteria andDormitoryIdGreaterThan(String value) {
            addCriterion("dormitory_id >", value, "dormitoryId");
            return (Criteria) this;
        }

        public Criteria andDormitoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("dormitory_id >=", value, "dormitoryId");
            return (Criteria) this;
        }

        public Criteria andDormitoryIdLessThan(String value) {
            addCriterion("dormitory_id <", value, "dormitoryId");
            return (Criteria) this;
        }

        public Criteria andDormitoryIdLessThanOrEqualTo(String value) {
            addCriterion("dormitory_id <=", value, "dormitoryId");
            return (Criteria) this;
        }

        public Criteria andDormitoryIdLike(String value) {
            addCriterion("dormitory_id like", value, "dormitoryId");
            return (Criteria) this;
        }

        public Criteria andDormitoryIdNotLike(String value) {
            addCriterion("dormitory_id not like", value, "dormitoryId");
            return (Criteria) this;
        }

        public Criteria andDormitoryIdIn(List<String> values) {
            addCriterion("dormitory_id in", values, "dormitoryId");
            return (Criteria) this;
        }

        public Criteria andDormitoryIdNotIn(List<String> values) {
            addCriterion("dormitory_id not in", values, "dormitoryId");
            return (Criteria) this;
        }

        public Criteria andDormitoryIdBetween(String value1, String value2) {
            addCriterion("dormitory_id between", value1, value2, "dormitoryId");
            return (Criteria) this;
        }

        public Criteria andDormitoryIdNotBetween(String value1, String value2) {
            addCriterion("dormitory_id not between", value1, value2, "dormitoryId");
            return (Criteria) this;
        }

        public Criteria andRoomNumIsNull() {
            addCriterion("room_num is null");
            return (Criteria) this;
        }

        public Criteria andRoomNumIsNotNull() {
            addCriterion("room_num is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNumEqualTo(String value) {
            addCriterion("room_num =", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotEqualTo(String value) {
            addCriterion("room_num <>", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumGreaterThan(String value) {
            addCriterion("room_num >", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumGreaterThanOrEqualTo(String value) {
            addCriterion("room_num >=", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumLessThan(String value) {
            addCriterion("room_num <", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumLessThanOrEqualTo(String value) {
            addCriterion("room_num <=", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumLike(String value) {
            addCriterion("room_num like", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotLike(String value) {
            addCriterion("room_num not like", value, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumIn(List<String> values) {
            addCriterion("room_num in", values, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotIn(List<String> values) {
            addCriterion("room_num not in", values, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumBetween(String value1, String value2) {
            addCriterion("room_num between", value1, value2, "roomNum");
            return (Criteria) this;
        }

        public Criteria andRoomNumNotBetween(String value1, String value2) {
            addCriterion("room_num not between", value1, value2, "roomNum");
            return (Criteria) this;
        }

        public Criteria andBedCountIsNull() {
            addCriterion("bed_count is null");
            return (Criteria) this;
        }

        public Criteria andBedCountIsNotNull() {
            addCriterion("bed_count is not null");
            return (Criteria) this;
        }

        public Criteria andBedCountEqualTo(Integer value) {
            addCriterion("bed_count =", value, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountNotEqualTo(Integer value) {
            addCriterion("bed_count <>", value, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountGreaterThan(Integer value) {
            addCriterion("bed_count >", value, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("bed_count >=", value, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountLessThan(Integer value) {
            addCriterion("bed_count <", value, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountLessThanOrEqualTo(Integer value) {
            addCriterion("bed_count <=", value, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountIn(List<Integer> values) {
            addCriterion("bed_count in", values, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountNotIn(List<Integer> values) {
            addCriterion("bed_count not in", values, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountBetween(Integer value1, Integer value2) {
            addCriterion("bed_count between", value1, value2, "bedCount");
            return (Criteria) this;
        }

        public Criteria andBedCountNotBetween(Integer value1, Integer value2) {
            addCriterion("bed_count not between", value1, value2, "bedCount");
            return (Criteria) this;
        }

        public Criteria andDormitorySortIsNull() {
            addCriterion("dormitory_sort is null");
            return (Criteria) this;
        }

        public Criteria andDormitorySortIsNotNull() {
            addCriterion("dormitory_sort is not null");
            return (Criteria) this;
        }

        public Criteria andDormitorySortEqualTo(Integer value) {
            addCriterion("dormitory_sort =", value, "dormitorySort");
            return (Criteria) this;
        }

        public Criteria andDormitorySortNotEqualTo(Integer value) {
            addCriterion("dormitory_sort <>", value, "dormitorySort");
            return (Criteria) this;
        }

        public Criteria andDormitorySortGreaterThan(Integer value) {
            addCriterion("dormitory_sort >", value, "dormitorySort");
            return (Criteria) this;
        }

        public Criteria andDormitorySortGreaterThanOrEqualTo(Integer value) {
            addCriterion("dormitory_sort >=", value, "dormitorySort");
            return (Criteria) this;
        }

        public Criteria andDormitorySortLessThan(Integer value) {
            addCriterion("dormitory_sort <", value, "dormitorySort");
            return (Criteria) this;
        }

        public Criteria andDormitorySortLessThanOrEqualTo(Integer value) {
            addCriterion("dormitory_sort <=", value, "dormitorySort");
            return (Criteria) this;
        }

        public Criteria andDormitorySortIn(List<Integer> values) {
            addCriterion("dormitory_sort in", values, "dormitorySort");
            return (Criteria) this;
        }

        public Criteria andDormitorySortNotIn(List<Integer> values) {
            addCriterion("dormitory_sort not in", values, "dormitorySort");
            return (Criteria) this;
        }

        public Criteria andDormitorySortBetween(Integer value1, Integer value2) {
            addCriterion("dormitory_sort between", value1, value2, "dormitorySort");
            return (Criteria) this;
        }

        public Criteria andDormitorySortNotBetween(Integer value1, Integer value2) {
            addCriterion("dormitory_sort not between", value1, value2, "dormitorySort");
            return (Criteria) this;
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