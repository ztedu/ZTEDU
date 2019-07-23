package cn.everlook.myweb.persistence.entity.assort.edu.registration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZtStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZtStudentExample() {
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

        public Criteria andZtStudentIdIsNull() {
            addCriterion("ZT_STUDENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdIsNotNull() {
            addCriterion("ZT_STUDENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdEqualTo(Long value) {
            addCriterion("ZT_STUDENT_ID =", value, "ztStudentId");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNotEqualTo(Long value) {
            addCriterion("ZT_STUDENT_ID <>", value, "ztStudentId");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdGreaterThan(Long value) {
            addCriterion("ZT_STUDENT_ID >", value, "ztStudentId");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ZT_STUDENT_ID >=", value, "ztStudentId");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdLessThan(Long value) {
            addCriterion("ZT_STUDENT_ID <", value, "ztStudentId");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdLessThanOrEqualTo(Long value) {
            addCriterion("ZT_STUDENT_ID <=", value, "ztStudentId");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdIn(List<Long> values) {
            addCriterion("ZT_STUDENT_ID in", values, "ztStudentId");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNotIn(List<Long> values) {
            addCriterion("ZT_STUDENT_ID not in", values, "ztStudentId");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdBetween(Long value1, Long value2) {
            addCriterion("ZT_STUDENT_ID between", value1, value2, "ztStudentId");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNotBetween(Long value1, Long value2) {
            addCriterion("ZT_STUDENT_ID not between", value1, value2, "ztStudentId");
            return (Criteria) this;
        }

        public Criteria andZtStudentNameIsNull() {
            addCriterion("ZT_STUDENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentNameIsNotNull() {
            addCriterion("ZT_STUDENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentNameEqualTo(String value) {
            addCriterion("ZT_STUDENT_NAME =", value, "ztStudentName");
            return (Criteria) this;
        }

        public Criteria andZtStudentNameNotEqualTo(String value) {
            addCriterion("ZT_STUDENT_NAME <>", value, "ztStudentName");
            return (Criteria) this;
        }

        public Criteria andZtStudentNameGreaterThan(String value) {
            addCriterion("ZT_STUDENT_NAME >", value, "ztStudentName");
            return (Criteria) this;
        }

        public Criteria andZtStudentNameGreaterThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_NAME >=", value, "ztStudentName");
            return (Criteria) this;
        }

        public Criteria andZtStudentNameLessThan(String value) {
            addCriterion("ZT_STUDENT_NAME <", value, "ztStudentName");
            return (Criteria) this;
        }

        public Criteria andZtStudentNameLessThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_NAME <=", value, "ztStudentName");
            return (Criteria) this;
        }

        public Criteria andZtStudentNameLike(String value) {
            addCriterion("ZT_STUDENT_NAME like", value, "ztStudentName");
            return (Criteria) this;
        }

        public Criteria andZtStudentNameNotLike(String value) {
            addCriterion("ZT_STUDENT_NAME not like", value, "ztStudentName");
            return (Criteria) this;
        }

        public Criteria andZtStudentNameIn(List<String> values) {
            addCriterion("ZT_STUDENT_NAME in", values, "ztStudentName");
            return (Criteria) this;
        }

        public Criteria andZtStudentNameNotIn(List<String> values) {
            addCriterion("ZT_STUDENT_NAME not in", values, "ztStudentName");
            return (Criteria) this;
        }

        public Criteria andZtStudentNameBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_NAME between", value1, value2, "ztStudentName");
            return (Criteria) this;
        }

        public Criteria andZtStudentNameNotBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_NAME not between", value1, value2, "ztStudentName");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNumberIsNull() {
            addCriterion("ZT_STUDENT_ID_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNumberIsNotNull() {
            addCriterion("ZT_STUDENT_ID_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNumberEqualTo(String value) {
            addCriterion("ZT_STUDENT_ID_NUMBER =", value, "ztStudentIdNumber");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNumberNotEqualTo(String value) {
            addCriterion("ZT_STUDENT_ID_NUMBER <>", value, "ztStudentIdNumber");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNumberGreaterThan(String value) {
            addCriterion("ZT_STUDENT_ID_NUMBER >", value, "ztStudentIdNumber");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_ID_NUMBER >=", value, "ztStudentIdNumber");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNumberLessThan(String value) {
            addCriterion("ZT_STUDENT_ID_NUMBER <", value, "ztStudentIdNumber");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNumberLessThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_ID_NUMBER <=", value, "ztStudentIdNumber");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNumberLike(String value) {
            addCriterion("ZT_STUDENT_ID_NUMBER like", value, "ztStudentIdNumber");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNumberNotLike(String value) {
            addCriterion("ZT_STUDENT_ID_NUMBER not like", value, "ztStudentIdNumber");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNumberIn(List<String> values) {
            addCriterion("ZT_STUDENT_ID_NUMBER in", values, "ztStudentIdNumber");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNumberNotIn(List<String> values) {
            addCriterion("ZT_STUDENT_ID_NUMBER not in", values, "ztStudentIdNumber");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNumberBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_ID_NUMBER between", value1, value2, "ztStudentIdNumber");
            return (Criteria) this;
        }

        public Criteria andZtStudentIdNumberNotBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_ID_NUMBER not between", value1, value2, "ztStudentIdNumber");
            return (Criteria) this;
        }

        public Criteria andZtStudentBirthdayIsNull() {
            addCriterion("ZT_STUDENT_BIRTHDAY is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentBirthdayIsNotNull() {
            addCriterion("ZT_STUDENT_BIRTHDAY is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentBirthdayEqualTo(Date value) {
            addCriterion("ZT_STUDENT_BIRTHDAY =", value, "ztStudentBirthday");
            return (Criteria) this;
        }

        public Criteria andZtStudentBirthdayNotEqualTo(Date value) {
            addCriterion("ZT_STUDENT_BIRTHDAY <>", value, "ztStudentBirthday");
            return (Criteria) this;
        }

        public Criteria andZtStudentBirthdayGreaterThan(Date value) {
            addCriterion("ZT_STUDENT_BIRTHDAY >", value, "ztStudentBirthday");
            return (Criteria) this;
        }

        public Criteria andZtStudentBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("ZT_STUDENT_BIRTHDAY >=", value, "ztStudentBirthday");
            return (Criteria) this;
        }

        public Criteria andZtStudentBirthdayLessThan(Date value) {
            addCriterion("ZT_STUDENT_BIRTHDAY <", value, "ztStudentBirthday");
            return (Criteria) this;
        }

        public Criteria andZtStudentBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("ZT_STUDENT_BIRTHDAY <=", value, "ztStudentBirthday");
            return (Criteria) this;
        }

        public Criteria andZtStudentBirthdayIn(List<Date> values) {
            addCriterion("ZT_STUDENT_BIRTHDAY in", values, "ztStudentBirthday");
            return (Criteria) this;
        }

        public Criteria andZtStudentBirthdayNotIn(List<Date> values) {
            addCriterion("ZT_STUDENT_BIRTHDAY not in", values, "ztStudentBirthday");
            return (Criteria) this;
        }

        public Criteria andZtStudentBirthdayBetween(Date value1, Date value2) {
            addCriterion("ZT_STUDENT_BIRTHDAY between", value1, value2, "ztStudentBirthday");
            return (Criteria) this;
        }

        public Criteria andZtStudentBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("ZT_STUDENT_BIRTHDAY not between", value1, value2, "ztStudentBirthday");
            return (Criteria) this;
        }

        public Criteria andZtStudentSexIsNull() {
            addCriterion("ZT_STUDENT_SEX is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentSexIsNotNull() {
            addCriterion("ZT_STUDENT_SEX is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentSexEqualTo(String value) {
            addCriterion("ZT_STUDENT_SEX =", value, "ztStudentSex");
            return (Criteria) this;
        }

        public Criteria andZtStudentSexNotEqualTo(String value) {
            addCriterion("ZT_STUDENT_SEX <>", value, "ztStudentSex");
            return (Criteria) this;
        }

        public Criteria andZtStudentSexGreaterThan(String value) {
            addCriterion("ZT_STUDENT_SEX >", value, "ztStudentSex");
            return (Criteria) this;
        }

        public Criteria andZtStudentSexGreaterThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_SEX >=", value, "ztStudentSex");
            return (Criteria) this;
        }

        public Criteria andZtStudentSexLessThan(String value) {
            addCriterion("ZT_STUDENT_SEX <", value, "ztStudentSex");
            return (Criteria) this;
        }

        public Criteria andZtStudentSexLessThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_SEX <=", value, "ztStudentSex");
            return (Criteria) this;
        }

        public Criteria andZtStudentSexLike(String value) {
            addCriterion("ZT_STUDENT_SEX like", value, "ztStudentSex");
            return (Criteria) this;
        }

        public Criteria andZtStudentSexNotLike(String value) {
            addCriterion("ZT_STUDENT_SEX not like", value, "ztStudentSex");
            return (Criteria) this;
        }

        public Criteria andZtStudentSexIn(List<String> values) {
            addCriterion("ZT_STUDENT_SEX in", values, "ztStudentSex");
            return (Criteria) this;
        }

        public Criteria andZtStudentSexNotIn(List<String> values) {
            addCriterion("ZT_STUDENT_SEX not in", values, "ztStudentSex");
            return (Criteria) this;
        }

        public Criteria andZtStudentSexBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_SEX between", value1, value2, "ztStudentSex");
            return (Criteria) this;
        }

        public Criteria andZtStudentSexNotBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_SEX not between", value1, value2, "ztStudentSex");
            return (Criteria) this;
        }

        public Criteria andZtStudentNationIsNull() {
            addCriterion("ZT_STUDENT_NATION is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentNationIsNotNull() {
            addCriterion("ZT_STUDENT_NATION is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentNationEqualTo(String value) {
            addCriterion("ZT_STUDENT_NATION =", value, "ztStudentNation");
            return (Criteria) this;
        }

        public Criteria andZtStudentNationNotEqualTo(String value) {
            addCriterion("ZT_STUDENT_NATION <>", value, "ztStudentNation");
            return (Criteria) this;
        }

        public Criteria andZtStudentNationGreaterThan(String value) {
            addCriterion("ZT_STUDENT_NATION >", value, "ztStudentNation");
            return (Criteria) this;
        }

        public Criteria andZtStudentNationGreaterThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_NATION >=", value, "ztStudentNation");
            return (Criteria) this;
        }

        public Criteria andZtStudentNationLessThan(String value) {
            addCriterion("ZT_STUDENT_NATION <", value, "ztStudentNation");
            return (Criteria) this;
        }

        public Criteria andZtStudentNationLessThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_NATION <=", value, "ztStudentNation");
            return (Criteria) this;
        }

        public Criteria andZtStudentNationLike(String value) {
            addCriterion("ZT_STUDENT_NATION like", value, "ztStudentNation");
            return (Criteria) this;
        }

        public Criteria andZtStudentNationNotLike(String value) {
            addCriterion("ZT_STUDENT_NATION not like", value, "ztStudentNation");
            return (Criteria) this;
        }

        public Criteria andZtStudentNationIn(List<String> values) {
            addCriterion("ZT_STUDENT_NATION in", values, "ztStudentNation");
            return (Criteria) this;
        }

        public Criteria andZtStudentNationNotIn(List<String> values) {
            addCriterion("ZT_STUDENT_NATION not in", values, "ztStudentNation");
            return (Criteria) this;
        }

        public Criteria andZtStudentNationBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_NATION between", value1, value2, "ztStudentNation");
            return (Criteria) this;
        }

        public Criteria andZtStudentNationNotBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_NATION not between", value1, value2, "ztStudentNation");
            return (Criteria) this;
        }

        public Criteria andZtStudentPoliticalAppearanceIsNull() {
            addCriterion("ZT_STUDENT_POLITICAL_APPEARANCE is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentPoliticalAppearanceIsNotNull() {
            addCriterion("ZT_STUDENT_POLITICAL_APPEARANCE is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentPoliticalAppearanceEqualTo(String value) {
            addCriterion("ZT_STUDENT_POLITICAL_APPEARANCE =", value, "ztStudentPoliticalAppearance");
            return (Criteria) this;
        }

        public Criteria andZtStudentPoliticalAppearanceNotEqualTo(String value) {
            addCriterion("ZT_STUDENT_POLITICAL_APPEARANCE <>", value, "ztStudentPoliticalAppearance");
            return (Criteria) this;
        }

        public Criteria andZtStudentPoliticalAppearanceGreaterThan(String value) {
            addCriterion("ZT_STUDENT_POLITICAL_APPEARANCE >", value, "ztStudentPoliticalAppearance");
            return (Criteria) this;
        }

        public Criteria andZtStudentPoliticalAppearanceGreaterThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_POLITICAL_APPEARANCE >=", value, "ztStudentPoliticalAppearance");
            return (Criteria) this;
        }

        public Criteria andZtStudentPoliticalAppearanceLessThan(String value) {
            addCriterion("ZT_STUDENT_POLITICAL_APPEARANCE <", value, "ztStudentPoliticalAppearance");
            return (Criteria) this;
        }

        public Criteria andZtStudentPoliticalAppearanceLessThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_POLITICAL_APPEARANCE <=", value, "ztStudentPoliticalAppearance");
            return (Criteria) this;
        }

        public Criteria andZtStudentPoliticalAppearanceLike(String value) {
            addCriterion("ZT_STUDENT_POLITICAL_APPEARANCE like", value, "ztStudentPoliticalAppearance");
            return (Criteria) this;
        }

        public Criteria andZtStudentPoliticalAppearanceNotLike(String value) {
            addCriterion("ZT_STUDENT_POLITICAL_APPEARANCE not like", value, "ztStudentPoliticalAppearance");
            return (Criteria) this;
        }

        public Criteria andZtStudentPoliticalAppearanceIn(List<String> values) {
            addCriterion("ZT_STUDENT_POLITICAL_APPEARANCE in", values, "ztStudentPoliticalAppearance");
            return (Criteria) this;
        }

        public Criteria andZtStudentPoliticalAppearanceNotIn(List<String> values) {
            addCriterion("ZT_STUDENT_POLITICAL_APPEARANCE not in", values, "ztStudentPoliticalAppearance");
            return (Criteria) this;
        }

        public Criteria andZtStudentPoliticalAppearanceBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_POLITICAL_APPEARANCE between", value1, value2, "ztStudentPoliticalAppearance");
            return (Criteria) this;
        }

        public Criteria andZtStudentPoliticalAppearanceNotBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_POLITICAL_APPEARANCE not between", value1, value2, "ztStudentPoliticalAppearance");
            return (Criteria) this;
        }

        public Criteria andZtStudentNativePlaceIsNull() {
            addCriterion("ZT_STUDENT_NATIVE_PLACE is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentNativePlaceIsNotNull() {
            addCriterion("ZT_STUDENT_NATIVE_PLACE is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentNativePlaceEqualTo(String value) {
            addCriterion("ZT_STUDENT_NATIVE_PLACE =", value, "ztStudentNativePlace");
            return (Criteria) this;
        }

        public Criteria andZtStudentNativePlaceNotEqualTo(String value) {
            addCriterion("ZT_STUDENT_NATIVE_PLACE <>", value, "ztStudentNativePlace");
            return (Criteria) this;
        }

        public Criteria andZtStudentNativePlaceGreaterThan(String value) {
            addCriterion("ZT_STUDENT_NATIVE_PLACE >", value, "ztStudentNativePlace");
            return (Criteria) this;
        }

        public Criteria andZtStudentNativePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_NATIVE_PLACE >=", value, "ztStudentNativePlace");
            return (Criteria) this;
        }

        public Criteria andZtStudentNativePlaceLessThan(String value) {
            addCriterion("ZT_STUDENT_NATIVE_PLACE <", value, "ztStudentNativePlace");
            return (Criteria) this;
        }

        public Criteria andZtStudentNativePlaceLessThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_NATIVE_PLACE <=", value, "ztStudentNativePlace");
            return (Criteria) this;
        }

        public Criteria andZtStudentNativePlaceLike(String value) {
            addCriterion("ZT_STUDENT_NATIVE_PLACE like", value, "ztStudentNativePlace");
            return (Criteria) this;
        }

        public Criteria andZtStudentNativePlaceNotLike(String value) {
            addCriterion("ZT_STUDENT_NATIVE_PLACE not like", value, "ztStudentNativePlace");
            return (Criteria) this;
        }

        public Criteria andZtStudentNativePlaceIn(List<String> values) {
            addCriterion("ZT_STUDENT_NATIVE_PLACE in", values, "ztStudentNativePlace");
            return (Criteria) this;
        }

        public Criteria andZtStudentNativePlaceNotIn(List<String> values) {
            addCriterion("ZT_STUDENT_NATIVE_PLACE not in", values, "ztStudentNativePlace");
            return (Criteria) this;
        }

        public Criteria andZtStudentNativePlaceBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_NATIVE_PLACE between", value1, value2, "ztStudentNativePlace");
            return (Criteria) this;
        }

        public Criteria andZtStudentNativePlaceNotBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_NATIVE_PLACE not between", value1, value2, "ztStudentNativePlace");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkUnitIsNull() {
            addCriterion("ZT_STUDENT_WORK_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkUnitIsNotNull() {
            addCriterion("ZT_STUDENT_WORK_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkUnitEqualTo(String value) {
            addCriterion("ZT_STUDENT_WORK_UNIT =", value, "ztStudentWorkUnit");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkUnitNotEqualTo(String value) {
            addCriterion("ZT_STUDENT_WORK_UNIT <>", value, "ztStudentWorkUnit");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkUnitGreaterThan(String value) {
            addCriterion("ZT_STUDENT_WORK_UNIT >", value, "ztStudentWorkUnit");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkUnitGreaterThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_WORK_UNIT >=", value, "ztStudentWorkUnit");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkUnitLessThan(String value) {
            addCriterion("ZT_STUDENT_WORK_UNIT <", value, "ztStudentWorkUnit");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkUnitLessThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_WORK_UNIT <=", value, "ztStudentWorkUnit");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkUnitLike(String value) {
            addCriterion("ZT_STUDENT_WORK_UNIT like", value, "ztStudentWorkUnit");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkUnitNotLike(String value) {
            addCriterion("ZT_STUDENT_WORK_UNIT not like", value, "ztStudentWorkUnit");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkUnitIn(List<String> values) {
            addCriterion("ZT_STUDENT_WORK_UNIT in", values, "ztStudentWorkUnit");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkUnitNotIn(List<String> values) {
            addCriterion("ZT_STUDENT_WORK_UNIT not in", values, "ztStudentWorkUnit");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkUnitBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_WORK_UNIT between", value1, value2, "ztStudentWorkUnit");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkUnitNotBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_WORK_UNIT not between", value1, value2, "ztStudentWorkUnit");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkTelIsNull() {
            addCriterion("ZT_STUDENT_WORK_TEL is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkTelIsNotNull() {
            addCriterion("ZT_STUDENT_WORK_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkTelEqualTo(String value) {
            addCriterion("ZT_STUDENT_WORK_TEL =", value, "ztStudentWorkTel");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkTelNotEqualTo(String value) {
            addCriterion("ZT_STUDENT_WORK_TEL <>", value, "ztStudentWorkTel");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkTelGreaterThan(String value) {
            addCriterion("ZT_STUDENT_WORK_TEL >", value, "ztStudentWorkTel");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkTelGreaterThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_WORK_TEL >=", value, "ztStudentWorkTel");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkTelLessThan(String value) {
            addCriterion("ZT_STUDENT_WORK_TEL <", value, "ztStudentWorkTel");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkTelLessThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_WORK_TEL <=", value, "ztStudentWorkTel");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkTelLike(String value) {
            addCriterion("ZT_STUDENT_WORK_TEL like", value, "ztStudentWorkTel");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkTelNotLike(String value) {
            addCriterion("ZT_STUDENT_WORK_TEL not like", value, "ztStudentWorkTel");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkTelIn(List<String> values) {
            addCriterion("ZT_STUDENT_WORK_TEL in", values, "ztStudentWorkTel");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkTelNotIn(List<String> values) {
            addCriterion("ZT_STUDENT_WORK_TEL not in", values, "ztStudentWorkTel");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkTelBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_WORK_TEL between", value1, value2, "ztStudentWorkTel");
            return (Criteria) this;
        }

        public Criteria andZtStudentWorkTelNotBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_WORK_TEL not between", value1, value2, "ztStudentWorkTel");
            return (Criteria) this;
        }

        public Criteria andZtStudentMobilePhoneIsNull() {
            addCriterion("ZT_STUDENT_MOBILE_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentMobilePhoneIsNotNull() {
            addCriterion("ZT_STUDENT_MOBILE_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentMobilePhoneEqualTo(String value) {
            addCriterion("ZT_STUDENT_MOBILE_PHONE =", value, "ztStudentMobilePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentMobilePhoneNotEqualTo(String value) {
            addCriterion("ZT_STUDENT_MOBILE_PHONE <>", value, "ztStudentMobilePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentMobilePhoneGreaterThan(String value) {
            addCriterion("ZT_STUDENT_MOBILE_PHONE >", value, "ztStudentMobilePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentMobilePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_MOBILE_PHONE >=", value, "ztStudentMobilePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentMobilePhoneLessThan(String value) {
            addCriterion("ZT_STUDENT_MOBILE_PHONE <", value, "ztStudentMobilePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentMobilePhoneLessThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_MOBILE_PHONE <=", value, "ztStudentMobilePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentMobilePhoneLike(String value) {
            addCriterion("ZT_STUDENT_MOBILE_PHONE like", value, "ztStudentMobilePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentMobilePhoneNotLike(String value) {
            addCriterion("ZT_STUDENT_MOBILE_PHONE not like", value, "ztStudentMobilePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentMobilePhoneIn(List<String> values) {
            addCriterion("ZT_STUDENT_MOBILE_PHONE in", values, "ztStudentMobilePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentMobilePhoneNotIn(List<String> values) {
            addCriterion("ZT_STUDENT_MOBILE_PHONE not in", values, "ztStudentMobilePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentMobilePhoneBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_MOBILE_PHONE between", value1, value2, "ztStudentMobilePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentMobilePhoneNotBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_MOBILE_PHONE not between", value1, value2, "ztStudentMobilePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentHomePhoneIsNull() {
            addCriterion("ZT_STUDENT_HOME_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentHomePhoneIsNotNull() {
            addCriterion("ZT_STUDENT_HOME_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentHomePhoneEqualTo(String value) {
            addCriterion("ZT_STUDENT_HOME_PHONE =", value, "ztStudentHomePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentHomePhoneNotEqualTo(String value) {
            addCriterion("ZT_STUDENT_HOME_PHONE <>", value, "ztStudentHomePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentHomePhoneGreaterThan(String value) {
            addCriterion("ZT_STUDENT_HOME_PHONE >", value, "ztStudentHomePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentHomePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_HOME_PHONE >=", value, "ztStudentHomePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentHomePhoneLessThan(String value) {
            addCriterion("ZT_STUDENT_HOME_PHONE <", value, "ztStudentHomePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentHomePhoneLessThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_HOME_PHONE <=", value, "ztStudentHomePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentHomePhoneLike(String value) {
            addCriterion("ZT_STUDENT_HOME_PHONE like", value, "ztStudentHomePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentHomePhoneNotLike(String value) {
            addCriterion("ZT_STUDENT_HOME_PHONE not like", value, "ztStudentHomePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentHomePhoneIn(List<String> values) {
            addCriterion("ZT_STUDENT_HOME_PHONE in", values, "ztStudentHomePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentHomePhoneNotIn(List<String> values) {
            addCriterion("ZT_STUDENT_HOME_PHONE not in", values, "ztStudentHomePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentHomePhoneBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_HOME_PHONE between", value1, value2, "ztStudentHomePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentHomePhoneNotBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_HOME_PHONE not between", value1, value2, "ztStudentHomePhone");
            return (Criteria) this;
        }

        public Criteria andZtStudentEeiIsNull() {
            addCriterion("ZT_STUDENT_EEI is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentEeiIsNotNull() {
            addCriterion("ZT_STUDENT_EEI is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentEeiEqualTo(String value) {
            addCriterion("ZT_STUDENT_EEI =", value, "ztStudentEei");
            return (Criteria) this;
        }

        public Criteria andZtStudentEeiNotEqualTo(String value) {
            addCriterion("ZT_STUDENT_EEI <>", value, "ztStudentEei");
            return (Criteria) this;
        }

        public Criteria andZtStudentEeiGreaterThan(String value) {
            addCriterion("ZT_STUDENT_EEI >", value, "ztStudentEei");
            return (Criteria) this;
        }

        public Criteria andZtStudentEeiGreaterThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_EEI >=", value, "ztStudentEei");
            return (Criteria) this;
        }

        public Criteria andZtStudentEeiLessThan(String value) {
            addCriterion("ZT_STUDENT_EEI <", value, "ztStudentEei");
            return (Criteria) this;
        }

        public Criteria andZtStudentEeiLessThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_EEI <=", value, "ztStudentEei");
            return (Criteria) this;
        }

        public Criteria andZtStudentEeiLike(String value) {
            addCriterion("ZT_STUDENT_EEI like", value, "ztStudentEei");
            return (Criteria) this;
        }

        public Criteria andZtStudentEeiNotLike(String value) {
            addCriterion("ZT_STUDENT_EEI not like", value, "ztStudentEei");
            return (Criteria) this;
        }

        public Criteria andZtStudentEeiIn(List<String> values) {
            addCriterion("ZT_STUDENT_EEI in", values, "ztStudentEei");
            return (Criteria) this;
        }

        public Criteria andZtStudentEeiNotIn(List<String> values) {
            addCriterion("ZT_STUDENT_EEI not in", values, "ztStudentEei");
            return (Criteria) this;
        }

        public Criteria andZtStudentEeiBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_EEI between", value1, value2, "ztStudentEei");
            return (Criteria) this;
        }

        public Criteria andZtStudentEeiNotBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_EEI not between", value1, value2, "ztStudentEei");
            return (Criteria) this;
        }

        public Criteria andZtStudentMajorIsNull() {
            addCriterion("ZT_STUDENT_MAJOR is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentMajorIsNotNull() {
            addCriterion("ZT_STUDENT_MAJOR is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentMajorEqualTo(String value) {
            addCriterion("ZT_STUDENT_MAJOR =", value, "ztStudentMajor");
            return (Criteria) this;
        }

        public Criteria andZtStudentMajorNotEqualTo(String value) {
            addCriterion("ZT_STUDENT_MAJOR <>", value, "ztStudentMajor");
            return (Criteria) this;
        }

        public Criteria andZtStudentMajorGreaterThan(String value) {
            addCriterion("ZT_STUDENT_MAJOR >", value, "ztStudentMajor");
            return (Criteria) this;
        }

        public Criteria andZtStudentMajorGreaterThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_MAJOR >=", value, "ztStudentMajor");
            return (Criteria) this;
        }

        public Criteria andZtStudentMajorLessThan(String value) {
            addCriterion("ZT_STUDENT_MAJOR <", value, "ztStudentMajor");
            return (Criteria) this;
        }

        public Criteria andZtStudentMajorLessThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_MAJOR <=", value, "ztStudentMajor");
            return (Criteria) this;
        }

        public Criteria andZtStudentMajorLike(String value) {
            addCriterion("ZT_STUDENT_MAJOR like", value, "ztStudentMajor");
            return (Criteria) this;
        }

        public Criteria andZtStudentMajorNotLike(String value) {
            addCriterion("ZT_STUDENT_MAJOR not like", value, "ztStudentMajor");
            return (Criteria) this;
        }

        public Criteria andZtStudentMajorIn(List<String> values) {
            addCriterion("ZT_STUDENT_MAJOR in", values, "ztStudentMajor");
            return (Criteria) this;
        }

        public Criteria andZtStudentMajorNotIn(List<String> values) {
            addCriterion("ZT_STUDENT_MAJOR not in", values, "ztStudentMajor");
            return (Criteria) this;
        }

        public Criteria andZtStudentMajorBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_MAJOR between", value1, value2, "ztStudentMajor");
            return (Criteria) this;
        }

        public Criteria andZtStudentMajorNotBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_MAJOR not between", value1, value2, "ztStudentMajor");
            return (Criteria) this;
        }

        public Criteria andZtStudentLevelIsNull() {
            addCriterion("ZT_STUDENT_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentLevelIsNotNull() {
            addCriterion("ZT_STUDENT_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentLevelEqualTo(Integer value) {
            addCriterion("ZT_STUDENT_LEVEL =", value, "ztStudentLevel");
            return (Criteria) this;
        }

        public Criteria andZtStudentLevelNotEqualTo(Integer value) {
            addCriterion("ZT_STUDENT_LEVEL <>", value, "ztStudentLevel");
            return (Criteria) this;
        }

        public Criteria andZtStudentLevelGreaterThan(Integer value) {
            addCriterion("ZT_STUDENT_LEVEL >", value, "ztStudentLevel");
            return (Criteria) this;
        }

        public Criteria andZtStudentLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZT_STUDENT_LEVEL >=", value, "ztStudentLevel");
            return (Criteria) this;
        }

        public Criteria andZtStudentLevelLessThan(Integer value) {
            addCriterion("ZT_STUDENT_LEVEL <", value, "ztStudentLevel");
            return (Criteria) this;
        }

        public Criteria andZtStudentLevelLessThanOrEqualTo(Integer value) {
            addCriterion("ZT_STUDENT_LEVEL <=", value, "ztStudentLevel");
            return (Criteria) this;
        }

        public Criteria andZtStudentLevelIn(List<Integer> values) {
            addCriterion("ZT_STUDENT_LEVEL in", values, "ztStudentLevel");
            return (Criteria) this;
        }

        public Criteria andZtStudentLevelNotIn(List<Integer> values) {
            addCriterion("ZT_STUDENT_LEVEL not in", values, "ztStudentLevel");
            return (Criteria) this;
        }

        public Criteria andZtStudentLevelBetween(Integer value1, Integer value2) {
            addCriterion("ZT_STUDENT_LEVEL between", value1, value2, "ztStudentLevel");
            return (Criteria) this;
        }

        public Criteria andZtStudentLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("ZT_STUDENT_LEVEL not between", value1, value2, "ztStudentLevel");
            return (Criteria) this;
        }

        public Criteria andZtStudentDateOfExamIsNull() {
            addCriterion("ZT_STUDENT_DATE_OF_EXAM is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentDateOfExamIsNotNull() {
            addCriterion("ZT_STUDENT_DATE_OF_EXAM is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentDateOfExamEqualTo(Date value) {
            addCriterion("ZT_STUDENT_DATE_OF_EXAM =", value, "ztStudentDateOfExam");
            return (Criteria) this;
        }

        public Criteria andZtStudentDateOfExamNotEqualTo(Date value) {
            addCriterion("ZT_STUDENT_DATE_OF_EXAM <>", value, "ztStudentDateOfExam");
            return (Criteria) this;
        }

        public Criteria andZtStudentDateOfExamGreaterThan(Date value) {
            addCriterion("ZT_STUDENT_DATE_OF_EXAM >", value, "ztStudentDateOfExam");
            return (Criteria) this;
        }

        public Criteria andZtStudentDateOfExamGreaterThanOrEqualTo(Date value) {
            addCriterion("ZT_STUDENT_DATE_OF_EXAM >=", value, "ztStudentDateOfExam");
            return (Criteria) this;
        }

        public Criteria andZtStudentDateOfExamLessThan(Date value) {
            addCriterion("ZT_STUDENT_DATE_OF_EXAM <", value, "ztStudentDateOfExam");
            return (Criteria) this;
        }

        public Criteria andZtStudentDateOfExamLessThanOrEqualTo(Date value) {
            addCriterion("ZT_STUDENT_DATE_OF_EXAM <=", value, "ztStudentDateOfExam");
            return (Criteria) this;
        }

        public Criteria andZtStudentDateOfExamIn(List<Date> values) {
            addCriterion("ZT_STUDENT_DATE_OF_EXAM in", values, "ztStudentDateOfExam");
            return (Criteria) this;
        }

        public Criteria andZtStudentDateOfExamNotIn(List<Date> values) {
            addCriterion("ZT_STUDENT_DATE_OF_EXAM not in", values, "ztStudentDateOfExam");
            return (Criteria) this;
        }

        public Criteria andZtStudentDateOfExamBetween(Date value1, Date value2) {
            addCriterion("ZT_STUDENT_DATE_OF_EXAM between", value1, value2, "ztStudentDateOfExam");
            return (Criteria) this;
        }

        public Criteria andZtStudentDateOfExamNotBetween(Date value1, Date value2) {
            addCriterion("ZT_STUDENT_DATE_OF_EXAM not between", value1, value2, "ztStudentDateOfExam");
            return (Criteria) this;
        }

        public Criteria andZtStudentRegistrationFeeIsNull() {
            addCriterion("ZT_STUDENT_REGISTRATION_FEE is null");
            return (Criteria) this;
        }

        public Criteria andZtStudentRegistrationFeeIsNotNull() {
            addCriterion("ZT_STUDENT_REGISTRATION_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andZtStudentRegistrationFeeEqualTo(String value) {
            addCriterion("ZT_STUDENT_REGISTRATION_FEE =", value, "ztStudentRegistrationFee");
            return (Criteria) this;
        }

        public Criteria andZtStudentRegistrationFeeNotEqualTo(String value) {
            addCriterion("ZT_STUDENT_REGISTRATION_FEE <>", value, "ztStudentRegistrationFee");
            return (Criteria) this;
        }

        public Criteria andZtStudentRegistrationFeeGreaterThan(String value) {
            addCriterion("ZT_STUDENT_REGISTRATION_FEE >", value, "ztStudentRegistrationFee");
            return (Criteria) this;
        }

        public Criteria andZtStudentRegistrationFeeGreaterThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_REGISTRATION_FEE >=", value, "ztStudentRegistrationFee");
            return (Criteria) this;
        }

        public Criteria andZtStudentRegistrationFeeLessThan(String value) {
            addCriterion("ZT_STUDENT_REGISTRATION_FEE <", value, "ztStudentRegistrationFee");
            return (Criteria) this;
        }

        public Criteria andZtStudentRegistrationFeeLessThanOrEqualTo(String value) {
            addCriterion("ZT_STUDENT_REGISTRATION_FEE <=", value, "ztStudentRegistrationFee");
            return (Criteria) this;
        }

        public Criteria andZtStudentRegistrationFeeLike(String value) {
            addCriterion("ZT_STUDENT_REGISTRATION_FEE like", value, "ztStudentRegistrationFee");
            return (Criteria) this;
        }

        public Criteria andZtStudentRegistrationFeeNotLike(String value) {
            addCriterion("ZT_STUDENT_REGISTRATION_FEE not like", value, "ztStudentRegistrationFee");
            return (Criteria) this;
        }

        public Criteria andZtStudentRegistrationFeeIn(List<String> values) {
            addCriterion("ZT_STUDENT_REGISTRATION_FEE in", values, "ztStudentRegistrationFee");
            return (Criteria) this;
        }

        public Criteria andZtStudentRegistrationFeeNotIn(List<String> values) {
            addCriterion("ZT_STUDENT_REGISTRATION_FEE not in", values, "ztStudentRegistrationFee");
            return (Criteria) this;
        }

        public Criteria andZtStudentRegistrationFeeBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_REGISTRATION_FEE between", value1, value2, "ztStudentRegistrationFee");
            return (Criteria) this;
        }

        public Criteria andZtStudentRegistrationFeeNotBetween(String value1, String value2) {
            addCriterion("ZT_STUDENT_REGISTRATION_FEE not between", value1, value2, "ztStudentRegistrationFee");
            return (Criteria) this;
        }

        public Criteria andZtUserIdIsNull() {
            addCriterion("ZT_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andZtUserIdIsNotNull() {
            addCriterion("ZT_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andZtUserIdEqualTo(Integer value) {
            addCriterion("ZT_USER_ID =", value, "ztUserId");
            return (Criteria) this;
        }

        public Criteria andZtUserIdNotEqualTo(Integer value) {
            addCriterion("ZT_USER_ID <>", value, "ztUserId");
            return (Criteria) this;
        }

        public Criteria andZtUserIdGreaterThan(Integer value) {
            addCriterion("ZT_USER_ID >", value, "ztUserId");
            return (Criteria) this;
        }

        public Criteria andZtUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZT_USER_ID >=", value, "ztUserId");
            return (Criteria) this;
        }

        public Criteria andZtUserIdLessThan(Integer value) {
            addCriterion("ZT_USER_ID <", value, "ztUserId");
            return (Criteria) this;
        }

        public Criteria andZtUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("ZT_USER_ID <=", value, "ztUserId");
            return (Criteria) this;
        }

        public Criteria andZtUserIdIn(List<Integer> values) {
            addCriterion("ZT_USER_ID in", values, "ztUserId");
            return (Criteria) this;
        }

        public Criteria andZtUserIdNotIn(List<Integer> values) {
            addCriterion("ZT_USER_ID not in", values, "ztUserId");
            return (Criteria) this;
        }

        public Criteria andZtUserIdBetween(Integer value1, Integer value2) {
            addCriterion("ZT_USER_ID between", value1, value2, "ztUserId");
            return (Criteria) this;
        }

        public Criteria andZtUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ZT_USER_ID not between", value1, value2, "ztUserId");
            return (Criteria) this;
        }

        public Criteria andZtBuyBooksIsNull() {
            addCriterion("ZT_BUY_BOOKS is null");
            return (Criteria) this;
        }

        public Criteria andZtBuyBooksIsNotNull() {
            addCriterion("ZT_BUY_BOOKS is not null");
            return (Criteria) this;
        }

        public Criteria andZtBuyBooksEqualTo(String value) {
            addCriterion("ZT_BUY_BOOKS =", value, "ztBuyBooks");
            return (Criteria) this;
        }

        public Criteria andZtBuyBooksNotEqualTo(String value) {
            addCriterion("ZT_BUY_BOOKS <>", value, "ztBuyBooks");
            return (Criteria) this;
        }

        public Criteria andZtBuyBooksGreaterThan(String value) {
            addCriterion("ZT_BUY_BOOKS >", value, "ztBuyBooks");
            return (Criteria) this;
        }

        public Criteria andZtBuyBooksGreaterThanOrEqualTo(String value) {
            addCriterion("ZT_BUY_BOOKS >=", value, "ztBuyBooks");
            return (Criteria) this;
        }

        public Criteria andZtBuyBooksLessThan(String value) {
            addCriterion("ZT_BUY_BOOKS <", value, "ztBuyBooks");
            return (Criteria) this;
        }

        public Criteria andZtBuyBooksLessThanOrEqualTo(String value) {
            addCriterion("ZT_BUY_BOOKS <=", value, "ztBuyBooks");
            return (Criteria) this;
        }

        public Criteria andZtBuyBooksLike(String value) {
            addCriterion("ZT_BUY_BOOKS like", value, "ztBuyBooks");
            return (Criteria) this;
        }

        public Criteria andZtBuyBooksNotLike(String value) {
            addCriterion("ZT_BUY_BOOKS not like", value, "ztBuyBooks");
            return (Criteria) this;
        }

        public Criteria andZtBuyBooksIn(List<String> values) {
            addCriterion("ZT_BUY_BOOKS in", values, "ztBuyBooks");
            return (Criteria) this;
        }

        public Criteria andZtBuyBooksNotIn(List<String> values) {
            addCriterion("ZT_BUY_BOOKS not in", values, "ztBuyBooks");
            return (Criteria) this;
        }

        public Criteria andZtBuyBooksBetween(String value1, String value2) {
            addCriterion("ZT_BUY_BOOKS between", value1, value2, "ztBuyBooks");
            return (Criteria) this;
        }

        public Criteria andZtBuyBooksNotBetween(String value1, String value2) {
            addCriterion("ZT_BUY_BOOKS not between", value1, value2, "ztBuyBooks");
            return (Criteria) this;
        }

        public Criteria andZtIntroducerIsNull() {
            addCriterion("ZT_INTRODUCER is null");
            return (Criteria) this;
        }

        public Criteria andZtIntroducerIsNotNull() {
            addCriterion("ZT_INTRODUCER is not null");
            return (Criteria) this;
        }

        public Criteria andZtIntroducerEqualTo(String value) {
            addCriterion("ZT_INTRODUCER =", value, "ztIntroducer");
            return (Criteria) this;
        }

        public Criteria andZtIntroducerNotEqualTo(String value) {
            addCriterion("ZT_INTRODUCER <>", value, "ztIntroducer");
            return (Criteria) this;
        }

        public Criteria andZtIntroducerGreaterThan(String value) {
            addCriterion("ZT_INTRODUCER >", value, "ztIntroducer");
            return (Criteria) this;
        }

        public Criteria andZtIntroducerGreaterThanOrEqualTo(String value) {
            addCriterion("ZT_INTRODUCER >=", value, "ztIntroducer");
            return (Criteria) this;
        }

        public Criteria andZtIntroducerLessThan(String value) {
            addCriterion("ZT_INTRODUCER <", value, "ztIntroducer");
            return (Criteria) this;
        }

        public Criteria andZtIntroducerLessThanOrEqualTo(String value) {
            addCriterion("ZT_INTRODUCER <=", value, "ztIntroducer");
            return (Criteria) this;
        }

        public Criteria andZtIntroducerLike(String value) {
            addCriterion("ZT_INTRODUCER like", value, "ztIntroducer");
            return (Criteria) this;
        }

        public Criteria andZtIntroducerNotLike(String value) {
            addCriterion("ZT_INTRODUCER not like", value, "ztIntroducer");
            return (Criteria) this;
        }

        public Criteria andZtIntroducerIn(List<String> values) {
            addCriterion("ZT_INTRODUCER in", values, "ztIntroducer");
            return (Criteria) this;
        }

        public Criteria andZtIntroducerNotIn(List<String> values) {
            addCriterion("ZT_INTRODUCER not in", values, "ztIntroducer");
            return (Criteria) this;
        }

        public Criteria andZtIntroducerBetween(String value1, String value2) {
            addCriterion("ZT_INTRODUCER between", value1, value2, "ztIntroducer");
            return (Criteria) this;
        }

        public Criteria andZtIntroducerNotBetween(String value1, String value2) {
            addCriterion("ZT_INTRODUCER not between", value1, value2, "ztIntroducer");
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