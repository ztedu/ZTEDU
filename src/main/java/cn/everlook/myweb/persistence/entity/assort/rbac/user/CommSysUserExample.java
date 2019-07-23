package cn.everlook.myweb.persistence.entity.assort.rbac.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommSysUserExample {
  protected String orderByClause;
  
  protected boolean distinct;
  
  protected List<Criteria> oredCriteria;
  
  public CommSysUserExample() {
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
      addCriterion("ID is null");
      return (Criteria) this;
    }
    
    public Criteria andIdIsNotNull() {
      addCriterion("ID is not null");
      return (Criteria) this;
    }
    
    public Criteria andIdEqualTo(Integer value) {
      addCriterion("ID =", value, "id");
      return (Criteria) this;
    }
    
    public Criteria andIdNotEqualTo(Integer value) {
      addCriterion("ID <>", value, "id");
      return (Criteria) this;
    }
    
    public Criteria andIdGreaterThan(Integer value) {
      addCriterion("ID >", value, "id");
      return (Criteria) this;
    }
    
    public Criteria andIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("ID >=", value, "id");
      return (Criteria) this;
    }
    
    public Criteria andIdLessThan(Integer value) {
      addCriterion("ID <", value, "id");
      return (Criteria) this;
    }
    
    public Criteria andIdLessThanOrEqualTo(Integer value) {
      addCriterion("ID <=", value, "id");
      return (Criteria) this;
    }
    
    public Criteria andIdIn(List<Integer> values) {
      addCriterion("ID in", values, "id");
      return (Criteria) this;
    }
    
    public Criteria andIdNotIn(List<Integer> values) {
      addCriterion("ID not in", values, "id");
      return (Criteria) this;
    }
    
    public Criteria andIdBetween(Integer value1, Integer value2) {
      addCriterion("ID between", value1, value2, "id");
      return (Criteria) this;
    }
    
    public Criteria andIdNotBetween(Integer value1, Integer value2) {
      addCriterion("ID not between", value1, value2, "id");
      return (Criteria) this;
    }
    
    public Criteria andNameIsNull() {
      addCriterion("NAME is null");
      return (Criteria) this;
    }
    
    public Criteria andNameIsNotNull() {
      addCriterion("NAME is not null");
      return (Criteria) this;
    }
    
    public Criteria andNameEqualTo(String value) {
      addCriterion("NAME =", value, "name");
      return (Criteria) this;
    }
    
    public Criteria andNameNotEqualTo(String value) {
      addCriterion("NAME <>", value, "name");
      return (Criteria) this;
    }
    
    public Criteria andNameGreaterThan(String value) {
      addCriterion("NAME >", value, "name");
      return (Criteria) this;
    }
    
    public Criteria andNameGreaterThanOrEqualTo(String value) {
      addCriterion("NAME >=", value, "name");
      return (Criteria) this;
    }
    
    public Criteria andNameLessThan(String value) {
      addCriterion("NAME <", value, "name");
      return (Criteria) this;
    }
    
    public Criteria andNameLessThanOrEqualTo(String value) {
      addCriterion("NAME <=", value, "name");
      return (Criteria) this;
    }
    
    public Criteria andNameLike(String value) {
      addCriterion("NAME like", value, "name");
      return (Criteria) this;
    }
    
    public Criteria andNameNotLike(String value) {
      addCriterion("NAME not like", value, "name");
      return (Criteria) this;
    }
    
    public Criteria andNameIn(List<String> values) {
      addCriterion("NAME in", values, "name");
      return (Criteria) this;
    }
    
    public Criteria andNameNotIn(List<String> values) {
      addCriterion("NAME not in", values, "name");
      return (Criteria) this;
    }
    
    public Criteria andNameBetween(String value1, String value2) {
      addCriterion("NAME between", value1, value2, "name");
      return (Criteria) this;
    }
    
    public Criteria andNameNotBetween(String value1, String value2) {
      addCriterion("NAME not between", value1, value2, "name");
      return (Criteria) this;
    }
    
    public Criteria andLoginNameIsNull() {
      addCriterion("LOGIN_NAME is null");
      return (Criteria) this;
    }
    
    public Criteria andLoginNameIsNotNull() {
      addCriterion("LOGIN_NAME is not null");
      return (Criteria) this;
    }
    
    public Criteria andLoginNameEqualTo(String value) {
      addCriterion("LOGIN_NAME =", value, "loginName");
      return (Criteria) this;
    }
    
    public Criteria andLoginNameNotEqualTo(String value) {
      addCriterion("LOGIN_NAME <>", value, "loginName");
      return (Criteria) this;
    }
    
    public Criteria andLoginNameGreaterThan(String value) {
      addCriterion("LOGIN_NAME >", value, "loginName");
      return (Criteria) this;
    }
    
    public Criteria andLoginNameGreaterThanOrEqualTo(String value) {
      addCriterion("LOGIN_NAME >=", value, "loginName");
      return (Criteria) this;
    }
    
    public Criteria andLoginNameLessThan(String value) {
      addCriterion("LOGIN_NAME <", value, "loginName");
      return (Criteria) this;
    }
    
    public Criteria andLoginNameLessThanOrEqualTo(String value) {
      addCriterion("LOGIN_NAME <=", value, "loginName");
      return (Criteria) this;
    }
    
    public Criteria andLoginNameLike(String value) {
      addCriterion("LOGIN_NAME like", value, "loginName");
      return (Criteria) this;
    }
    
    public Criteria andLoginNameNotLike(String value) {
      addCriterion("LOGIN_NAME not like", value, "loginName");
      return (Criteria) this;
    }
    
    public Criteria andLoginNameIn(List<String> values) {
      addCriterion("LOGIN_NAME in", values, "loginName");
      return (Criteria) this;
    }
    
    public Criteria andLoginNameNotIn(List<String> values) {
      addCriterion("LOGIN_NAME not in", values, "loginName");
      return (Criteria) this;
    }
    
    public Criteria andLoginNameBetween(String value1, String value2) {
      addCriterion("LOGIN_NAME between", value1, value2, "loginName");
      return (Criteria) this;
    }
    
    public Criteria andLoginNameNotBetween(String value1, String value2) {
      addCriterion("LOGIN_NAME not between", value1, value2, "loginName");
      return (Criteria) this;
    }
    
    public Criteria andAddressIsNull() {
      addCriterion("ADDRESS is null");
      return (Criteria) this;
    }
    
    public Criteria andAddressIsNotNull() {
      addCriterion("ADDRESS is not null");
      return (Criteria) this;
    }
    
    public Criteria andAddressEqualTo(String value) {
      addCriterion("ADDRESS =", value, "address");
      return (Criteria) this;
    }
    
    public Criteria andAddressNotEqualTo(String value) {
      addCriterion("ADDRESS <>", value, "address");
      return (Criteria) this;
    }
    
    public Criteria andAddressGreaterThan(String value) {
      addCriterion("ADDRESS >", value, "address");
      return (Criteria) this;
    }
    
    public Criteria andAddressGreaterThanOrEqualTo(String value) {
      addCriterion("ADDRESS >=", value, "address");
      return (Criteria) this;
    }
    
    public Criteria andAddressLessThan(String value) {
      addCriterion("ADDRESS <", value, "address");
      return (Criteria) this;
    }
    
    public Criteria andAddressLessThanOrEqualTo(String value) {
      addCriterion("ADDRESS <=", value, "address");
      return (Criteria) this;
    }
    
    public Criteria andAddressLike(String value) {
      addCriterion("ADDRESS like", value, "address");
      return (Criteria) this;
    }
    
    public Criteria andAddressNotLike(String value) {
      addCriterion("ADDRESS not like", value, "address");
      return (Criteria) this;
    }
    
    public Criteria andAddressIn(List<String> values) {
      addCriterion("ADDRESS in", values, "address");
      return (Criteria) this;
    }
    
    public Criteria andAddressNotIn(List<String> values) {
      addCriterion("ADDRESS not in", values, "address");
      return (Criteria) this;
    }
    
    public Criteria andAddressBetween(String value1, String value2) {
      addCriterion("ADDRESS between", value1, value2, "address");
      return (Criteria) this;
    }
    
    public Criteria andAddressNotBetween(String value1, String value2) {
      addCriterion("ADDRESS not between", value1, value2, "address");
      return (Criteria) this;
    }
    
    public Criteria andSexIsNull() {
      addCriterion("SEX is null");
      return (Criteria) this;
    }
    
    public Criteria andSexIsNotNull() {
      addCriterion("SEX is not null");
      return (Criteria) this;
    }
    
    public Criteria andSexEqualTo(Integer value) {
      addCriterion("SEX =", value, "sex");
      return (Criteria) this;
    }
    
    public Criteria andSexNotEqualTo(Integer value) {
      addCriterion("SEX <>", value, "sex");
      return (Criteria) this;
    }
    
    public Criteria andSexGreaterThan(Integer value) {
      addCriterion("SEX >", value, "sex");
      return (Criteria) this;
    }
    
    public Criteria andSexGreaterThanOrEqualTo(Integer value) {
      addCriterion("SEX >=", value, "sex");
      return (Criteria) this;
    }
    
    public Criteria andSexLessThan(Integer value) {
      addCriterion("SEX <", value, "sex");
      return (Criteria) this;
    }
    
    public Criteria andSexLessThanOrEqualTo(Integer value) {
      addCriterion("SEX <=", value, "sex");
      return (Criteria) this;
    }
    
    public Criteria andSexIn(List<Integer> values) {
      addCriterion("SEX in", values, "sex");
      return (Criteria) this;
    }
    
    public Criteria andSexNotIn(List<Integer> values) {
      addCriterion("SEX not in", values, "sex");
      return (Criteria) this;
    }
    
    public Criteria andSexBetween(Integer value1, Integer value2) {
      addCriterion("SEX between", value1, value2, "sex");
      return (Criteria) this;
    }
    
    public Criteria andSexNotBetween(Integer value1, Integer value2) {
      addCriterion("SEX not between", value1, value2, "sex");
      return (Criteria) this;
    }
    
    public Criteria andRemarkIsNull() {
      addCriterion("REMARK is null");
      return (Criteria) this;
    }
    
    public Criteria andRemarkIsNotNull() {
      addCriterion("REMARK is not null");
      return (Criteria) this;
    }
    
    public Criteria andRemarkEqualTo(String value) {
      addCriterion("REMARK =", value, "remark");
      return (Criteria) this;
    }
    
    public Criteria andRemarkNotEqualTo(String value) {
      addCriterion("REMARK <>", value, "remark");
      return (Criteria) this;
    }
    
    public Criteria andRemarkGreaterThan(String value) {
      addCriterion("REMARK >", value, "remark");
      return (Criteria) this;
    }
    
    public Criteria andRemarkGreaterThanOrEqualTo(String value) {
      addCriterion("REMARK >=", value, "remark");
      return (Criteria) this;
    }
    
    public Criteria andRemarkLessThan(String value) {
      addCriterion("REMARK <", value, "remark");
      return (Criteria) this;
    }
    
    public Criteria andRemarkLessThanOrEqualTo(String value) {
      addCriterion("REMARK <=", value, "remark");
      return (Criteria) this;
    }
    
    public Criteria andRemarkLike(String value) {
      addCriterion("REMARK like", value, "remark");
      return (Criteria) this;
    }
    
    public Criteria andRemarkNotLike(String value) {
      addCriterion("REMARK not like", value, "remark");
      return (Criteria) this;
    }
    
    public Criteria andRemarkIn(List<String> values) {
      addCriterion("REMARK in", values, "remark");
      return (Criteria) this;
    }
    
    public Criteria andRemarkNotIn(List<String> values) {
      addCriterion("REMARK not in", values, "remark");
      return (Criteria) this;
    }
    
    public Criteria andRemarkBetween(String value1, String value2) {
      addCriterion("REMARK between", value1, value2, "remark");
      return (Criteria) this;
    }
    
    public Criteria andRemarkNotBetween(String value1, String value2) {
      addCriterion("REMARK not between", value1, value2, "remark");
      return (Criteria) this;
    }
    
    public Criteria andPwdIsNull() {
      addCriterion("PWD is null");
      return (Criteria) this;
    }
    
    public Criteria andPwdIsNotNull() {
      addCriterion("PWD is not null");
      return (Criteria) this;
    }
    
    public Criteria andPwdEqualTo(String value) {
      addCriterion("PWD =", value, "pwd");
      return (Criteria) this;
    }
    
    public Criteria andPwdNotEqualTo(String value) {
      addCriterion("PWD <>", value, "pwd");
      return (Criteria) this;
    }
    
    public Criteria andPwdGreaterThan(String value) {
      addCriterion("PWD >", value, "pwd");
      return (Criteria) this;
    }
    
    public Criteria andPwdGreaterThanOrEqualTo(String value) {
      addCriterion("PWD >=", value, "pwd");
      return (Criteria) this;
    }
    
    public Criteria andPwdLessThan(String value) {
      addCriterion("PWD <", value, "pwd");
      return (Criteria) this;
    }
    
    public Criteria andPwdLessThanOrEqualTo(String value) {
      addCriterion("PWD <=", value, "pwd");
      return (Criteria) this;
    }
    
    public Criteria andPwdLike(String value) {
      addCriterion("PWD like", value, "pwd");
      return (Criteria) this;
    }
    
    public Criteria andPwdNotLike(String value) {
      addCriterion("PWD not like", value, "pwd");
      return (Criteria) this;
    }
    
    public Criteria andPwdIn(List<String> values) {
      addCriterion("PWD in", values, "pwd");
      return (Criteria) this;
    }
    
    public Criteria andPwdNotIn(List<String> values) {
      addCriterion("PWD not in", values, "pwd");
      return (Criteria) this;
    }
    
    public Criteria andPwdBetween(String value1, String value2) {
      addCriterion("PWD between", value1, value2, "pwd");
      return (Criteria) this;
    }
    
    public Criteria andPwdNotBetween(String value1, String value2) {
      addCriterion("PWD not between", value1, value2, "pwd");
      return (Criteria) this;
    }
    
    public Criteria andHireDateIsNull() {
      addCriterion("HIRE_DATE is null");
      return (Criteria) this;
    }
    
    public Criteria andHireDateIsNotNull() {
      addCriterion("HIRE_DATE is not null");
      return (Criteria) this;
    }
    
    public Criteria andHireDateEqualTo(Date value) {
      addCriterion("HIRE_DATE =", value, "hireDate");
      return (Criteria) this;
    }
    
    public Criteria andHireDateNotEqualTo(Date value) {
      addCriterion("HIRE_DATE <>", value, "hireDate");
      return (Criteria) this;
    }
    
    public Criteria andHireDateGreaterThan(Date value) {
      addCriterion("HIRE_DATE >", value, "hireDate");
      return (Criteria) this;
    }
    
    public Criteria andHireDateGreaterThanOrEqualTo(Date value) {
      addCriterion("HIRE_DATE >=", value, "hireDate");
      return (Criteria) this;
    }
    
    public Criteria andHireDateLessThan(Date value) {
      addCriterion("HIRE_DATE <", value, "hireDate");
      return (Criteria) this;
    }
    
    public Criteria andHireDateLessThanOrEqualTo(Date value) {
      addCriterion("HIRE_DATE <=", value, "hireDate");
      return (Criteria) this;
    }
    
    public Criteria andHireDateIn(List<Date> values) {
      addCriterion("HIRE_DATE in", values, "hireDate");
      return (Criteria) this;
    }
    
    public Criteria andHireDateNotIn(List<Date> values) {
      addCriterion("HIRE_DATE not in", values, "hireDate");
      return (Criteria) this;
    }
    
    public Criteria andHireDateBetween(Date value1, Date value2) {
      addCriterion("HIRE_DATE between", value1, value2, "hireDate");
      return (Criteria) this;
    }
    
    public Criteria andHireDateNotBetween(Date value1, Date value2) {
      addCriterion("HIRE_DATE not between", value1, value2, "hireDate");
      return (Criteria) this;
    }
    
    public Criteria andMgrIsNull() {
      addCriterion("MGR is null");
      return (Criteria) this;
    }
    
    public Criteria andMgrIsNotNull() {
      addCriterion("MGR is not null");
      return (Criteria) this;
    }
    
    public Criteria andMgrEqualTo(Integer value) {
      addCriterion("MGR =", value, "mgr");
      return (Criteria) this;
    }
    
    public Criteria andMgrNotEqualTo(Integer value) {
      addCriterion("MGR <>", value, "mgr");
      return (Criteria) this;
    }
    
    public Criteria andMgrGreaterThan(Integer value) {
      addCriterion("MGR >", value, "mgr");
      return (Criteria) this;
    }
    
    public Criteria andMgrGreaterThanOrEqualTo(Integer value) {
      addCriterion("MGR >=", value, "mgr");
      return (Criteria) this;
    }
    
    public Criteria andMgrLessThan(Integer value) {
      addCriterion("MGR <", value, "mgr");
      return (Criteria) this;
    }
    
    public Criteria andMgrLessThanOrEqualTo(Integer value) {
      addCriterion("MGR <=", value, "mgr");
      return (Criteria) this;
    }
    
    public Criteria andMgrIn(List<Integer> values) {
      addCriterion("MGR in", values, "mgr");
      return (Criteria) this;
    }
    
    public Criteria andMgrNotIn(List<Integer> values) {
      addCriterion("MGR not in", values, "mgr");
      return (Criteria) this;
    }
    
    public Criteria andMgrBetween(Integer value1, Integer value2) {
      addCriterion("MGR between", value1, value2, "mgr");
      return (Criteria) this;
    }
    
    public Criteria andMgrNotBetween(Integer value1, Integer value2) {
      addCriterion("MGR not between", value1, value2, "mgr");
      return (Criteria) this;
    }
    
    public Criteria andDeptIdIsNull() {
      addCriterion("DEPT_ID is null");
      return (Criteria) this;
    }
    
    public Criteria andDeptIdIsNotNull() {
      addCriterion("DEPT_ID is not null");
      return (Criteria) this;
    }
    
    public Criteria andDeptIdEqualTo(Integer value) {
      addCriterion("DEPT_ID =", value, "deptId");
      return (Criteria) this;
    }
    
    public Criteria andDeptIdNotEqualTo(Integer value) {
      addCriterion("DEPT_ID <>", value, "deptId");
      return (Criteria) this;
    }
    
    public Criteria andDeptIdGreaterThan(Integer value) {
      addCriterion("DEPT_ID >", value, "deptId");
      return (Criteria) this;
    }
    
    public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("DEPT_ID >=", value, "deptId");
      return (Criteria) this;
    }
    
    public Criteria andDeptIdLessThan(Integer value) {
      addCriterion("DEPT_ID <", value, "deptId");
      return (Criteria) this;
    }
    
    public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
      addCriterion("DEPT_ID <=", value, "deptId");
      return (Criteria) this;
    }
    
    public Criteria andDeptIdIn(List<Integer> values) {
      addCriterion("DEPT_ID in", values, "deptId");
      return (Criteria) this;
    }
    
    public Criteria andDeptIdNotIn(List<Integer> values) {
      addCriterion("DEPT_ID not in", values, "deptId");
      return (Criteria) this;
    }
    
    public Criteria andDeptIdBetween(Integer value1, Integer value2) {
      addCriterion("DEPT_ID between", value1, value2, "deptId");
      return (Criteria) this;
    }
    
    public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
      addCriterion("DEPT_ID not between", value1, value2, "deptId");
      return (Criteria) this;
    }
    
    public Criteria andAvailableIsNull() {
      addCriterion("AVAILABLE is null");
      return (Criteria) this;
    }
    
    public Criteria andAvailableIsNotNull() {
      addCriterion("AVAILABLE is not null");
      return (Criteria) this;
    }
    
    public Criteria andAvailableEqualTo(Integer value) {
      addCriterion("AVAILABLE =", value, "available");
      return (Criteria) this;
    }
    
    public Criteria andAvailableNotEqualTo(Integer value) {
      addCriterion("AVAILABLE <>", value, "available");
      return (Criteria) this;
    }
    
    public Criteria andAvailableGreaterThan(Integer value) {
      addCriterion("AVAILABLE >", value, "available");
      return (Criteria) this;
    }
    
    public Criteria andAvailableGreaterThanOrEqualTo(Integer value) {
      addCriterion("AVAILABLE >=", value, "available");
      return (Criteria) this;
    }
    
    public Criteria andAvailableLessThan(Integer value) {
      addCriterion("AVAILABLE <", value, "available");
      return (Criteria) this;
    }
    
    public Criteria andAvailableLessThanOrEqualTo(Integer value) {
      addCriterion("AVAILABLE <=", value, "available");
      return (Criteria) this;
    }
    
    public Criteria andAvailableIn(List<Integer> values) {
      addCriterion("AVAILABLE in", values, "available");
      return (Criteria) this;
    }
    
    public Criteria andAvailableNotIn(List<Integer> values) {
      addCriterion("AVAILABLE not in", values, "available");
      return (Criteria) this;
    }
    
    public Criteria andAvailableBetween(Integer value1, Integer value2) {
      addCriterion("AVAILABLE between", value1, value2, "available");
      return (Criteria) this;
    }
    
    public Criteria andAvailableNotBetween(Integer value1, Integer value2) {
      addCriterion("AVAILABLE not between", value1, value2, "available");
      return (Criteria) this;
    }
    
    public Criteria andOrderNumIsNull() {
      addCriterion("ORDER_NUM is null");
      return (Criteria) this;
    }
    
    public Criteria andOrderNumIsNotNull() {
      addCriterion("ORDER_NUM is not null");
      return (Criteria) this;
    }
    
    public Criteria andOrderNumEqualTo(Integer value) {
      addCriterion("ORDER_NUM =", value, "orderNum");
      return (Criteria) this;
    }
    
    public Criteria andOrderNumNotEqualTo(Integer value) {
      addCriterion("ORDER_NUM <>", value, "orderNum");
      return (Criteria) this;
    }
    
    public Criteria andOrderNumGreaterThan(Integer value) {
      addCriterion("ORDER_NUM >", value, "orderNum");
      return (Criteria) this;
    }
    
    public Criteria andOrderNumGreaterThanOrEqualTo(Integer value) {
      addCriterion("ORDER_NUM >=", value, "orderNum");
      return (Criteria) this;
    }
    
    public Criteria andOrderNumLessThan(Integer value) {
      addCriterion("ORDER_NUM <", value, "orderNum");
      return (Criteria) this;
    }
    
    public Criteria andOrderNumLessThanOrEqualTo(Integer value) {
      addCriterion("ORDER_NUM <=", value, "orderNum");
      return (Criteria) this;
    }
    
    public Criteria andOrderNumIn(List<Integer> values) {
      addCriterion("ORDER_NUM in", values, "orderNum");
      return (Criteria) this;
    }
    
    public Criteria andOrderNumNotIn(List<Integer> values) {
      addCriterion("ORDER_NUM not in", values, "orderNum");
      return (Criteria) this;
    }
    
    public Criteria andOrderNumBetween(Integer value1, Integer value2) {
      addCriterion("ORDER_NUM between", value1, value2, "orderNum");
      return (Criteria) this;
    }
    
    public Criteria andOrderNumNotBetween(Integer value1, Integer value2) {
      addCriterion("ORDER_NUM not between", value1, value2, "orderNum");
      return (Criteria) this;
    }
    
    public Criteria andAttachmentIdIsNull() {
      addCriterion("ATTACHMENT_ID is null");
      return (Criteria) this;
    }
    
    public Criteria andAttachmentIdIsNotNull() {
      addCriterion("ATTACHMENT_ID is not null");
      return (Criteria) this;
    }
    
    public Criteria andAttachmentIdEqualTo(Integer value) {
      addCriterion("ATTACHMENT_ID =", value, "attachmentId");
      return (Criteria) this;
    }
    
    public Criteria andAttachmentIdNotEqualTo(Integer value) {
      addCriterion("ATTACHMENT_ID <>", value, "attachmentId");
      return (Criteria) this;
    }
    
    public Criteria andAttachmentIdGreaterThan(Integer value) {
      addCriterion("ATTACHMENT_ID >", value, "attachmentId");
      return (Criteria) this;
    }
    
    public Criteria andAttachmentIdGreaterThanOrEqualTo(Integer value) {
      addCriterion("ATTACHMENT_ID >=", value, "attachmentId");
      return (Criteria) this;
    }
    
    public Criteria andAttachmentIdLessThan(Integer value) {
      addCriterion("ATTACHMENT_ID <", value, "attachmentId");
      return (Criteria) this;
    }
    
    public Criteria andAttachmentIdLessThanOrEqualTo(Integer value) {
      addCriterion("ATTACHMENT_ID <=", value, "attachmentId");
      return (Criteria) this;
    }
    
    public Criteria andAttachmentIdIn(List<Integer> values) {
      addCriterion("ATTACHMENT_ID in", values, "attachmentId");
      return (Criteria) this;
    }
    
    public Criteria andAttachmentIdNotIn(List<Integer> values) {
      addCriterion("ATTACHMENT_ID not in", values, "attachmentId");
      return (Criteria) this;
    }
    
    public Criteria andAttachmentIdBetween(Integer value1, Integer value2) {
      addCriterion("ATTACHMENT_ID between", value1, value2, "attachmentId");
      return (Criteria) this;
    }
    
    public Criteria andAttachmentIdNotBetween(Integer value1, Integer value2) {
      addCriterion("ATTACHMENT_ID not between", value1, value2, "attachmentId");
      return (Criteria) this;
    }
    
    public Criteria andUserNoIsNull() {
      addCriterion("USER_NO is null");
      return (Criteria) this;
    }
    
    public Criteria andUserNoIsNotNull() {
      addCriterion("USER_NO is not null");
      return (Criteria) this;
    }
    
    public Criteria andUserNoEqualTo(String value) {
      addCriterion("USER_NO =", value, "userNo");
      return (Criteria) this;
    }
    
    public Criteria andUserNoNotEqualTo(String value) {
      addCriterion("USER_NO <>", value, "userNo");
      return (Criteria) this;
    }
    
    public Criteria andUserNoGreaterThan(String value) {
      addCriterion("USER_NO >", value, "userNo");
      return (Criteria) this;
    }
    
    public Criteria andUserNoGreaterThanOrEqualTo(String value) {
      addCriterion("USER_NO >=", value, "userNo");
      return (Criteria) this;
    }
    
    public Criteria andUserNoLessThan(String value) {
      addCriterion("USER_NO <", value, "userNo");
      return (Criteria) this;
    }
    
    public Criteria andUserNoLessThanOrEqualTo(String value) {
      addCriterion("USER_NO <=", value, "userNo");
      return (Criteria) this;
    }
    
    public Criteria andUserNoLike(String value) {
      addCriterion("USER_NO like", value, "userNo");
      return (Criteria) this;
    }
    
    public Criteria andUserNoNotLike(String value) {
      addCriterion("USER_NO not like", value, "userNo");
      return (Criteria) this;
    }
    
    public Criteria andUserNoIn(List<String> values) {
      addCriterion("USER_NO in", values, "userNo");
      return (Criteria) this;
    }
    
    public Criteria andUserNoNotIn(List<String> values) {
      addCriterion("USER_NO not in", values, "userNo");
      return (Criteria) this;
    }
    
    public Criteria andUserNoBetween(String value1, String value2) {
      addCriterion("USER_NO between", value1, value2, "userNo");
      return (Criteria) this;
    }
    
    public Criteria andUserNoNotBetween(String value1, String value2) {
      addCriterion("USER_NO not between", value1, value2, "userNo");
      return (Criteria) this;
    }
    
    public Criteria andIsSystemIsNull() {
      addCriterion("IS_SYSTEM is null");
      return (Criteria) this;
    }
    
    public Criteria andIsSystemIsNotNull() {
      addCriterion("IS_SYSTEM is not null");
      return (Criteria) this;
    }
    
    public Criteria andIsSystemEqualTo(Integer value) {
      addCriterion("IS_SYSTEM =", value, "isSystem");
      return (Criteria) this;
    }
    
    public Criteria andIsSystemNotEqualTo(Integer value) {
      addCriterion("IS_SYSTEM <>", value, "isSystem");
      return (Criteria) this;
    }
    
    public Criteria andIsSystemGreaterThan(Integer value) {
      addCriterion("IS_SYSTEM >", value, "isSystem");
      return (Criteria) this;
    }
    
    public Criteria andIsSystemGreaterThanOrEqualTo(Integer value) {
      addCriterion("IS_SYSTEM >=", value, "isSystem");
      return (Criteria) this;
    }
    
    public Criteria andIsSystemLessThan(Integer value) {
      addCriterion("IS_SYSTEM <", value, "isSystem");
      return (Criteria) this;
    }
    
    public Criteria andIsSystemLessThanOrEqualTo(Integer value) {
      addCriterion("IS_SYSTEM <=", value, "isSystem");
      return (Criteria) this;
    }
    
    public Criteria andIsSystemIn(List<Integer> values) {
      addCriterion("IS_SYSTEM in", values, "isSystem");
      return (Criteria) this;
    }
    
    public Criteria andIsSystemNotIn(List<Integer> values) {
      addCriterion("IS_SYSTEM not in", values, "isSystem");
      return (Criteria) this;
    }
    
    public Criteria andIsSystemBetween(Integer value1, Integer value2) {
      addCriterion("IS_SYSTEM between", value1, value2, "isSystem");
      return (Criteria) this;
    }
    
    public Criteria andIsSystemNotBetween(Integer value1, Integer value2) {
      addCriterion("IS_SYSTEM not between", value1, value2, "isSystem");
      return (Criteria) this;
    }
    
    public Criteria andPhoneIsNull() {
      addCriterion("PHONE is null");
      return (Criteria) this;
    }
    
    public Criteria andPhoneIsNotNull() {
      addCriterion("PHONE is not null");
      return (Criteria) this;
    }
    
    public Criteria andPhoneEqualTo(String value) {
      addCriterion("PHONE =", value, "phone");
      return (Criteria) this;
    }
    
    public Criteria andPhoneNotEqualTo(String value) {
      addCriterion("PHONE <>", value, "phone");
      return (Criteria) this;
    }
    
    public Criteria andPhoneGreaterThan(String value) {
      addCriterion("PHONE >", value, "phone");
      return (Criteria) this;
    }
    
    public Criteria andPhoneGreaterThanOrEqualTo(String value) {
      addCriterion("PHONE >=", value, "phone");
      return (Criteria) this;
    }
    
    public Criteria andPhoneLessThan(String value) {
      addCriterion("PHONE <", value, "phone");
      return (Criteria) this;
    }
    
    public Criteria andPhoneLessThanOrEqualTo(String value) {
      addCriterion("PHONE <=", value, "phone");
      return (Criteria) this;
    }
    
    public Criteria andPhoneLike(String value) {
      addCriterion("PHONE like", value, "phone");
      return (Criteria) this;
    }
    
    public Criteria andPhoneNotLike(String value) {
      addCriterion("PHONE not like", value, "phone");
      return (Criteria) this;
    }
    
    public Criteria andPhoneIn(List<String> values) {
      addCriterion("PHONE in", values, "phone");
      return (Criteria) this;
    }
    
    public Criteria andPhoneNotIn(List<String> values) {
      addCriterion("PHONE not in", values, "phone");
      return (Criteria) this;
    }
    
    public Criteria andPhoneBetween(String value1, String value2) {
      addCriterion("PHONE between", value1, value2, "phone");
      return (Criteria) this;
    }
    
    public Criteria andPhoneNotBetween(String value1, String value2) {
      addCriterion("PHONE not between", value1, value2, "phone");
      return (Criteria) this;
    }
    
    public Criteria andTelIsNull() {
      addCriterion("TEL is null");
      return (Criteria) this;
    }
    
    public Criteria andTelIsNotNull() {
      addCriterion("TEL is not null");
      return (Criteria) this;
    }
    
    public Criteria andTelEqualTo(String value) {
      addCriterion("TEL =", value, "tel");
      return (Criteria) this;
    }
    
    public Criteria andTelNotEqualTo(String value) {
      addCriterion("TEL <>", value, "tel");
      return (Criteria) this;
    }
    
    public Criteria andTelGreaterThan(String value) {
      addCriterion("TEL >", value, "tel");
      return (Criteria) this;
    }
    
    public Criteria andTelGreaterThanOrEqualTo(String value) {
      addCriterion("TEL >=", value, "tel");
      return (Criteria) this;
    }
    
    public Criteria andTelLessThan(String value) {
      addCriterion("TEL <", value, "tel");
      return (Criteria) this;
    }
    
    public Criteria andTelLessThanOrEqualTo(String value) {
      addCriterion("TEL <=", value, "tel");
      return (Criteria) this;
    }
    
    public Criteria andTelLike(String value) {
      addCriterion("TEL like", value, "tel");
      return (Criteria) this;
    }
    
    public Criteria andTelNotLike(String value) {
      addCriterion("TEL not like", value, "tel");
      return (Criteria) this;
    }
    
    public Criteria andTelIn(List<String> values) {
      addCriterion("TEL in", values, "tel");
      return (Criteria) this;
    }
    
    public Criteria andTelNotIn(List<String> values) {
      addCriterion("TEL not in", values, "tel");
      return (Criteria) this;
    }
    
    public Criteria andTelBetween(String value1, String value2) {
      addCriterion("TEL between", value1, value2, "tel");
      return (Criteria) this;
    }
    
    public Criteria andTelNotBetween(String value1, String value2) {
      addCriterion("TEL not between", value1, value2, "tel");
      return (Criteria) this;
    }
    
    public Criteria andPositionIsNull() {
      addCriterion("POSITION is null");
      return (Criteria) this;
    }
    
    public Criteria andPositionIsNotNull() {
      addCriterion("POSITION is not null");
      return (Criteria) this;
    }
    
    public Criteria andPositionEqualTo(Integer value) {
      addCriterion("POSITION =", value, "position");
      return (Criteria) this;
    }
    
    public Criteria andPositionNotEqualTo(Integer value) {
      addCriterion("POSITION <>", value, "position");
      return (Criteria) this;
    }
    
    public Criteria andPositionGreaterThan(Integer value) {
      addCriterion("POSITION >", value, "position");
      return (Criteria) this;
    }
    
    public Criteria andPositionGreaterThanOrEqualTo(Integer value) {
      addCriterion("POSITION >=", value, "position");
      return (Criteria) this;
    }
    
    public Criteria andPositionLessThan(Integer value) {
      addCriterion("POSITION <", value, "position");
      return (Criteria) this;
    }
    
    public Criteria andPositionLessThanOrEqualTo(Integer value) {
      addCriterion("POSITION <=", value, "position");
      return (Criteria) this;
    }
    
    public Criteria andPositionIn(List<Integer> values) {
      addCriterion("POSITION in", values, "position");
      return (Criteria) this;
    }
    
    public Criteria andPositionNotIn(List<Integer> values) {
      addCriterion("POSITION not in", values, "position");
      return (Criteria) this;
    }
    
    public Criteria andPositionBetween(Integer value1, Integer value2) {
      addCriterion("POSITION between", value1, value2, "position");
      return (Criteria) this;
    }
    
    public Criteria andPositionNotBetween(Integer value1, Integer value2) {
      addCriterion("POSITION not between", value1, value2, "position");
      return (Criteria) this;
    }
    
    public Criteria andBirthDateIsNull() {
      addCriterion("BIRTH_DATE is null");
      return (Criteria) this;
    }
    
    public Criteria andBirthDateIsNotNull() {
      addCriterion("BIRTH_DATE is not null");
      return (Criteria) this;
    }
    
    public Criteria andBirthDateEqualTo(Date value) {
      addCriterion("BIRTH_DATE =", value, "birthDate");
      return (Criteria) this;
    }
    
    public Criteria andBirthDateNotEqualTo(Date value) {
      addCriterion("BIRTH_DATE <>", value, "birthDate");
      return (Criteria) this;
    }
    
    public Criteria andBirthDateGreaterThan(Date value) {
      addCriterion("BIRTH_DATE >", value, "birthDate");
      return (Criteria) this;
    }
    
    public Criteria andBirthDateGreaterThanOrEqualTo(Date value) {
      addCriterion("BIRTH_DATE >=", value, "birthDate");
      return (Criteria) this;
    }
    
    public Criteria andBirthDateLessThan(Date value) {
      addCriterion("BIRTH_DATE <", value, "birthDate");
      return (Criteria) this;
    }
    
    public Criteria andBirthDateLessThanOrEqualTo(Date value) {
      addCriterion("BIRTH_DATE <=", value, "birthDate");
      return (Criteria) this;
    }
    
    public Criteria andBirthDateIn(List<Date> values) {
      addCriterion("BIRTH_DATE in", values, "birthDate");
      return (Criteria) this;
    }
    
    public Criteria andBirthDateNotIn(List<Date> values) {
      addCriterion("BIRTH_DATE not in", values, "birthDate");
      return (Criteria) this;
    }
    
    public Criteria andBirthDateBetween(Date value1, Date value2) {
      addCriterion("BIRTH_DATE between", value1, value2, "birthDate");
      return (Criteria) this;
    }
    
    public Criteria andBirthDateNotBetween(Date value1, Date value2) {
      addCriterion("BIRTH_DATE not between", value1, value2, "birthDate");
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