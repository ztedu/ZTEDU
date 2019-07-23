package cn.everlook.myweb.persistence.entity.assort.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommSysLogExample {
  protected String orderByClause;
  
  protected boolean distinct;
  
  protected List<Criteria> oredCriteria;
  
  public CommSysLogExample() {
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
    
    public Criteria andLogIdIsNull() {
      addCriterion("LOG_ID is null");
      return (Criteria) this;
    }
    
    public Criteria andLogIdIsNotNull() {
      addCriterion("LOG_ID is not null");
      return (Criteria) this;
    }
    
    public Criteria andLogIdEqualTo(String value) {
      addCriterion("LOG_ID =", value, "logId");
      return (Criteria) this;
    }
    
    public Criteria andLogIdNotEqualTo(String value) {
      addCriterion("LOG_ID <>", value, "logId");
      return (Criteria) this;
    }
    
    public Criteria andLogIdGreaterThan(String value) {
      addCriterion("LOG_ID >", value, "logId");
      return (Criteria) this;
    }
    
    public Criteria andLogIdGreaterThanOrEqualTo(String value) {
      addCriterion("LOG_ID >=", value, "logId");
      return (Criteria) this;
    }
    
    public Criteria andLogIdLessThan(String value) {
      addCriterion("LOG_ID <", value, "logId");
      return (Criteria) this;
    }
    
    public Criteria andLogIdLessThanOrEqualTo(String value) {
      addCriterion("LOG_ID <=", value, "logId");
      return (Criteria) this;
    }
    
    public Criteria andLogIdLike(String value) {
      addCriterion("LOG_ID like", value, "logId");
      return (Criteria) this;
    }
    
    public Criteria andLogIdNotLike(String value) {
      addCriterion("LOG_ID not like", value, "logId");
      return (Criteria) this;
    }
    
    public Criteria andLogIdIn(List<String> values) {
      addCriterion("LOG_ID in", values, "logId");
      return (Criteria) this;
    }
    
    public Criteria andLogIdNotIn(List<String> values) {
      addCriterion("LOG_ID not in", values, "logId");
      return (Criteria) this;
    }
    
    public Criteria andLogIdBetween(String value1, String value2) {
      addCriterion("LOG_ID between", value1, value2, "logId");
      return (Criteria) this;
    }
    
    public Criteria andLogIdNotBetween(String value1, String value2) {
      addCriterion("LOG_ID not between", value1, value2, "logId");
      return (Criteria) this;
    }
    
    public Criteria andTypeIsNull() {
      addCriterion("TYPE is null");
      return (Criteria) this;
    }
    
    public Criteria andTypeIsNotNull() {
      addCriterion("TYPE is not null");
      return (Criteria) this;
    }
    
    public Criteria andTypeEqualTo(String value) {
      addCriterion("TYPE =", value, "type");
      return (Criteria) this;
    }
    
    public Criteria andTypeNotEqualTo(String value) {
      addCriterion("TYPE <>", value, "type");
      return (Criteria) this;
    }
    
    public Criteria andTypeGreaterThan(String value) {
      addCriterion("TYPE >", value, "type");
      return (Criteria) this;
    }
    
    public Criteria andTypeGreaterThanOrEqualTo(String value) {
      addCriterion("TYPE >=", value, "type");
      return (Criteria) this;
    }
    
    public Criteria andTypeLessThan(String value) {
      addCriterion("TYPE <", value, "type");
      return (Criteria) this;
    }
    
    public Criteria andTypeLessThanOrEqualTo(String value) {
      addCriterion("TYPE <=", value, "type");
      return (Criteria) this;
    }
    
    public Criteria andTypeLike(String value) {
      addCriterion("TYPE like", value, "type");
      return (Criteria) this;
    }
    
    public Criteria andTypeNotLike(String value) {
      addCriterion("TYPE not like", value, "type");
      return (Criteria) this;
    }
    
    public Criteria andTypeIn(List<String> values) {
      addCriterion("TYPE in", values, "type");
      return (Criteria) this;
    }
    
    public Criteria andTypeNotIn(List<String> values) {
      addCriterion("TYPE not in", values, "type");
      return (Criteria) this;
    }
    
    public Criteria andTypeBetween(String value1, String value2) {
      addCriterion("TYPE between", value1, value2, "type");
      return (Criteria) this;
    }
    
    public Criteria andTypeNotBetween(String value1, String value2) {
      addCriterion("TYPE not between", value1, value2, "type");
      return (Criteria) this;
    }
    
    public Criteria andTitleIsNull() {
      addCriterion("TITLE is null");
      return (Criteria) this;
    }
    
    public Criteria andTitleIsNotNull() {
      addCriterion("TITLE is not null");
      return (Criteria) this;
    }
    
    public Criteria andTitleEqualTo(String value) {
      addCriterion("TITLE =", value, "title");
      return (Criteria) this;
    }
    
    public Criteria andTitleNotEqualTo(String value) {
      addCriterion("TITLE <>", value, "title");
      return (Criteria) this;
    }
    
    public Criteria andTitleGreaterThan(String value) {
      addCriterion("TITLE >", value, "title");
      return (Criteria) this;
    }
    
    public Criteria andTitleGreaterThanOrEqualTo(String value) {
      addCriterion("TITLE >=", value, "title");
      return (Criteria) this;
    }
    
    public Criteria andTitleLessThan(String value) {
      addCriterion("TITLE <", value, "title");
      return (Criteria) this;
    }
    
    public Criteria andTitleLessThanOrEqualTo(String value) {
      addCriterion("TITLE <=", value, "title");
      return (Criteria) this;
    }
    
    public Criteria andTitleLike(String value) {
      addCriterion("TITLE like", value, "title");
      return (Criteria) this;
    }
    
    public Criteria andTitleNotLike(String value) {
      addCriterion("TITLE not like", value, "title");
      return (Criteria) this;
    }
    
    public Criteria andTitleIn(List<String> values) {
      addCriterion("TITLE in", values, "title");
      return (Criteria) this;
    }
    
    public Criteria andTitleNotIn(List<String> values) {
      addCriterion("TITLE not in", values, "title");
      return (Criteria) this;
    }
    
    public Criteria andTitleBetween(String value1, String value2) {
      addCriterion("TITLE between", value1, value2, "title");
      return (Criteria) this;
    }
    
    public Criteria andTitleNotBetween(String value1, String value2) {
      addCriterion("TITLE not between", value1, value2, "title");
      return (Criteria) this;
    }
    
    public Criteria andRemoteAddrIsNull() {
      addCriterion("REMOTE_ADDR is null");
      return (Criteria) this;
    }
    
    public Criteria andRemoteAddrIsNotNull() {
      addCriterion("REMOTE_ADDR is not null");
      return (Criteria) this;
    }
    
    public Criteria andRemoteAddrEqualTo(String value) {
      addCriterion("REMOTE_ADDR =", value, "remoteAddr");
      return (Criteria) this;
    }
    
    public Criteria andRemoteAddrNotEqualTo(String value) {
      addCriterion("REMOTE_ADDR <>", value, "remoteAddr");
      return (Criteria) this;
    }
    
    public Criteria andRemoteAddrGreaterThan(String value) {
      addCriterion("REMOTE_ADDR >", value, "remoteAddr");
      return (Criteria) this;
    }
    
    public Criteria andRemoteAddrGreaterThanOrEqualTo(String value) {
      addCriterion("REMOTE_ADDR >=", value, "remoteAddr");
      return (Criteria) this;
    }
    
    public Criteria andRemoteAddrLessThan(String value) {
      addCriterion("REMOTE_ADDR <", value, "remoteAddr");
      return (Criteria) this;
    }
    
    public Criteria andRemoteAddrLessThanOrEqualTo(String value) {
      addCriterion("REMOTE_ADDR <=", value, "remoteAddr");
      return (Criteria) this;
    }
    
    public Criteria andRemoteAddrLike(String value) {
      addCriterion("REMOTE_ADDR like", value, "remoteAddr");
      return (Criteria) this;
    }
    
    public Criteria andRemoteAddrNotLike(String value) {
      addCriterion("REMOTE_ADDR not like", value, "remoteAddr");
      return (Criteria) this;
    }
    
    public Criteria andRemoteAddrIn(List<String> values) {
      addCriterion("REMOTE_ADDR in", values, "remoteAddr");
      return (Criteria) this;
    }
    
    public Criteria andRemoteAddrNotIn(List<String> values) {
      addCriterion("REMOTE_ADDR not in", values, "remoteAddr");
      return (Criteria) this;
    }
    
    public Criteria andRemoteAddrBetween(String value1, String value2) {
      addCriterion("REMOTE_ADDR between", value1, value2, "remoteAddr");
      return (Criteria) this;
    }
    
    public Criteria andRemoteAddrNotBetween(String value1, String value2) {
      addCriterion("REMOTE_ADDR not between", value1, value2, "remoteAddr");
      return (Criteria) this;
    }
    
    public Criteria andRequestUriIsNull() {
      addCriterion("REQUEST_URI is null");
      return (Criteria) this;
    }
    
    public Criteria andRequestUriIsNotNull() {
      addCriterion("REQUEST_URI is not null");
      return (Criteria) this;
    }
    
    public Criteria andRequestUriEqualTo(String value) {
      addCriterion("REQUEST_URI =", value, "requestUri");
      return (Criteria) this;
    }
    
    public Criteria andRequestUriNotEqualTo(String value) {
      addCriterion("REQUEST_URI <>", value, "requestUri");
      return (Criteria) this;
    }
    
    public Criteria andRequestUriGreaterThan(String value) {
      addCriterion("REQUEST_URI >", value, "requestUri");
      return (Criteria) this;
    }
    
    public Criteria andRequestUriGreaterThanOrEqualTo(String value) {
      addCriterion("REQUEST_URI >=", value, "requestUri");
      return (Criteria) this;
    }
    
    public Criteria andRequestUriLessThan(String value) {
      addCriterion("REQUEST_URI <", value, "requestUri");
      return (Criteria) this;
    }
    
    public Criteria andRequestUriLessThanOrEqualTo(String value) {
      addCriterion("REQUEST_URI <=", value, "requestUri");
      return (Criteria) this;
    }
    
    public Criteria andRequestUriLike(String value) {
      addCriterion("REQUEST_URI like", value, "requestUri");
      return (Criteria) this;
    }
    
    public Criteria andRequestUriNotLike(String value) {
      addCriterion("REQUEST_URI not like", value, "requestUri");
      return (Criteria) this;
    }
    
    public Criteria andRequestUriIn(List<String> values) {
      addCriterion("REQUEST_URI in", values, "requestUri");
      return (Criteria) this;
    }
    
    public Criteria andRequestUriNotIn(List<String> values) {
      addCriterion("REQUEST_URI not in", values, "requestUri");
      return (Criteria) this;
    }
    
    public Criteria andRequestUriBetween(String value1, String value2) {
      addCriterion("REQUEST_URI between", value1, value2, "requestUri");
      return (Criteria) this;
    }
    
    public Criteria andRequestUriNotBetween(String value1, String value2) {
      addCriterion("REQUEST_URI not between", value1, value2, "requestUri");
      return (Criteria) this;
    }
    
    public Criteria andMethodIsNull() {
      addCriterion("METHOD is null");
      return (Criteria) this;
    }
    
    public Criteria andMethodIsNotNull() {
      addCriterion("METHOD is not null");
      return (Criteria) this;
    }
    
    public Criteria andMethodEqualTo(String value) {
      addCriterion("METHOD =", value, "method");
      return (Criteria) this;
    }
    
    public Criteria andMethodNotEqualTo(String value) {
      addCriterion("METHOD <>", value, "method");
      return (Criteria) this;
    }
    
    public Criteria andMethodGreaterThan(String value) {
      addCriterion("METHOD >", value, "method");
      return (Criteria) this;
    }
    
    public Criteria andMethodGreaterThanOrEqualTo(String value) {
      addCriterion("METHOD >=", value, "method");
      return (Criteria) this;
    }
    
    public Criteria andMethodLessThan(String value) {
      addCriterion("METHOD <", value, "method");
      return (Criteria) this;
    }
    
    public Criteria andMethodLessThanOrEqualTo(String value) {
      addCriterion("METHOD <=", value, "method");
      return (Criteria) this;
    }
    
    public Criteria andMethodLike(String value) {
      addCriterion("METHOD like", value, "method");
      return (Criteria) this;
    }
    
    public Criteria andMethodNotLike(String value) {
      addCriterion("METHOD not like", value, "method");
      return (Criteria) this;
    }
    
    public Criteria andMethodIn(List<String> values) {
      addCriterion("METHOD in", values, "method");
      return (Criteria) this;
    }
    
    public Criteria andMethodNotIn(List<String> values) {
      addCriterion("METHOD not in", values, "method");
      return (Criteria) this;
    }
    
    public Criteria andMethodBetween(String value1, String value2) {
      addCriterion("METHOD between", value1, value2, "method");
      return (Criteria) this;
    }
    
    public Criteria andMethodNotBetween(String value1, String value2) {
      addCriterion("METHOD not between", value1, value2, "method");
      return (Criteria) this;
    }
    
    public Criteria andParamsIsNull() {
      addCriterion("PARAMS is null");
      return (Criteria) this;
    }
    
    public Criteria andParamsIsNotNull() {
      addCriterion("PARAMS is not null");
      return (Criteria) this;
    }
    
    public Criteria andParamsEqualTo(String value) {
      addCriterion("PARAMS =", value, "params");
      return (Criteria) this;
    }
    
    public Criteria andParamsNotEqualTo(String value) {
      addCriterion("PARAMS <>", value, "params");
      return (Criteria) this;
    }
    
    public Criteria andParamsGreaterThan(String value) {
      addCriterion("PARAMS >", value, "params");
      return (Criteria) this;
    }
    
    public Criteria andParamsGreaterThanOrEqualTo(String value) {
      addCriterion("PARAMS >=", value, "params");
      return (Criteria) this;
    }
    
    public Criteria andParamsLessThan(String value) {
      addCriterion("PARAMS <", value, "params");
      return (Criteria) this;
    }
    
    public Criteria andParamsLessThanOrEqualTo(String value) {
      addCriterion("PARAMS <=", value, "params");
      return (Criteria) this;
    }
    
    public Criteria andParamsLike(String value) {
      addCriterion("PARAMS like", value, "params");
      return (Criteria) this;
    }
    
    public Criteria andParamsNotLike(String value) {
      addCriterion("PARAMS not like", value, "params");
      return (Criteria) this;
    }
    
    public Criteria andParamsIn(List<String> values) {
      addCriterion("PARAMS in", values, "params");
      return (Criteria) this;
    }
    
    public Criteria andParamsNotIn(List<String> values) {
      addCriterion("PARAMS not in", values, "params");
      return (Criteria) this;
    }
    
    public Criteria andParamsBetween(String value1, String value2) {
      addCriterion("PARAMS between", value1, value2, "params");
      return (Criteria) this;
    }
    
    public Criteria andParamsNotBetween(String value1, String value2) {
      addCriterion("PARAMS not between", value1, value2, "params");
      return (Criteria) this;
    }
    
    public Criteria andExceptionIsNull() {
      addCriterion("EXCEPTION is null");
      return (Criteria) this;
    }
    
    public Criteria andExceptionIsNotNull() {
      addCriterion("EXCEPTION is not null");
      return (Criteria) this;
    }
    
    public Criteria andExceptionEqualTo(String value) {
      addCriterion("EXCEPTION =", value, "exception");
      return (Criteria) this;
    }
    
    public Criteria andExceptionNotEqualTo(String value) {
      addCriterion("EXCEPTION <>", value, "exception");
      return (Criteria) this;
    }
    
    public Criteria andExceptionGreaterThan(String value) {
      addCriterion("EXCEPTION >", value, "exception");
      return (Criteria) this;
    }
    
    public Criteria andExceptionGreaterThanOrEqualTo(String value) {
      addCriterion("EXCEPTION >=", value, "exception");
      return (Criteria) this;
    }
    
    public Criteria andExceptionLessThan(String value) {
      addCriterion("EXCEPTION <", value, "exception");
      return (Criteria) this;
    }
    
    public Criteria andExceptionLessThanOrEqualTo(String value) {
      addCriterion("EXCEPTION <=", value, "exception");
      return (Criteria) this;
    }
    
    public Criteria andExceptionLike(String value) {
      addCriterion("EXCEPTION like", value, "exception");
      return (Criteria) this;
    }
    
    public Criteria andExceptionNotLike(String value) {
      addCriterion("EXCEPTION not like", value, "exception");
      return (Criteria) this;
    }
    
    public Criteria andExceptionIn(List<String> values) {
      addCriterion("EXCEPTION in", values, "exception");
      return (Criteria) this;
    }
    
    public Criteria andExceptionNotIn(List<String> values) {
      addCriterion("EXCEPTION not in", values, "exception");
      return (Criteria) this;
    }
    
    public Criteria andExceptionBetween(String value1, String value2) {
      addCriterion("EXCEPTION between", value1, value2, "exception");
      return (Criteria) this;
    }
    
    public Criteria andExceptionNotBetween(String value1, String value2) {
      addCriterion("EXCEPTION not between", value1, value2, "exception");
      return (Criteria) this;
    }
    
    public Criteria andOperateDateIsNull() {
      addCriterion("OPERATE_DATE is null");
      return (Criteria) this;
    }
    
    public Criteria andOperateDateIsNotNull() {
      addCriterion("OPERATE_DATE is not null");
      return (Criteria) this;
    }
    
    public Criteria andOperateDateEqualTo(Date value) {
      addCriterion("OPERATE_DATE =", value, "operateDate");
      return (Criteria) this;
    }
    
    public Criteria andOperateDateNotEqualTo(Date value) {
      addCriterion("OPERATE_DATE <>", value, "operateDate");
      return (Criteria) this;
    }
    
    public Criteria andOperateDateGreaterThan(Date value) {
      addCriterion("OPERATE_DATE >", value, "operateDate");
      return (Criteria) this;
    }
    
    public Criteria andOperateDateGreaterThanOrEqualTo(Date value) {
      addCriterion("OPERATE_DATE >=", value, "operateDate");
      return (Criteria) this;
    }
    
    public Criteria andOperateDateLessThan(Date value) {
      addCriterion("OPERATE_DATE <", value, "operateDate");
      return (Criteria) this;
    }
    
    public Criteria andOperateDateLessThanOrEqualTo(Date value) {
      addCriterion("OPERATE_DATE <=", value, "operateDate");
      return (Criteria) this;
    }
    
    public Criteria andOperateDateIn(List<Date> values) {
      addCriterion("OPERATE_DATE in", values, "operateDate");
      return (Criteria) this;
    }
    
    public Criteria andOperateDateNotIn(List<Date> values) {
      addCriterion("OPERATE_DATE not in", values, "operateDate");
      return (Criteria) this;
    }
    
    public Criteria andOperateDateBetween(Date value1, Date value2) {
      addCriterion("OPERATE_DATE between", value1, value2, "operateDate");
      return (Criteria) this;
    }
    
    public Criteria andOperateDateNotBetween(Date value1, Date value2) {
      addCriterion("OPERATE_DATE not between", value1, value2, "operateDate");
      return (Criteria) this;
    }
    
    public Criteria andTimeoutIsNull() {
      addCriterion("TIMEOUT is null");
      return (Criteria) this;
    }
    
    public Criteria andTimeoutIsNotNull() {
      addCriterion("TIMEOUT is not null");
      return (Criteria) this;
    }
    
    public Criteria andTimeoutEqualTo(String value) {
      addCriterion("TIMEOUT =", value, "timeout");
      return (Criteria) this;
    }
    
    public Criteria andTimeoutNotEqualTo(String value) {
      addCriterion("TIMEOUT <>", value, "timeout");
      return (Criteria) this;
    }
    
    public Criteria andTimeoutGreaterThan(String value) {
      addCriterion("TIMEOUT >", value, "timeout");
      return (Criteria) this;
    }
    
    public Criteria andTimeoutGreaterThanOrEqualTo(String value) {
      addCriterion("TIMEOUT >=", value, "timeout");
      return (Criteria) this;
    }
    
    public Criteria andTimeoutLessThan(String value) {
      addCriterion("TIMEOUT <", value, "timeout");
      return (Criteria) this;
    }
    
    public Criteria andTimeoutLessThanOrEqualTo(String value) {
      addCriterion("TIMEOUT <=", value, "timeout");
      return (Criteria) this;
    }
    
    public Criteria andTimeoutLike(String value) {
      addCriterion("TIMEOUT like", value, "timeout");
      return (Criteria) this;
    }
    
    public Criteria andTimeoutNotLike(String value) {
      addCriterion("TIMEOUT not like", value, "timeout");
      return (Criteria) this;
    }
    
    public Criteria andTimeoutIn(List<String> values) {
      addCriterion("TIMEOUT in", values, "timeout");
      return (Criteria) this;
    }
    
    public Criteria andTimeoutNotIn(List<String> values) {
      addCriterion("TIMEOUT not in", values, "timeout");
      return (Criteria) this;
    }
    
    public Criteria andTimeoutBetween(String value1, String value2) {
      addCriterion("TIMEOUT between", value1, value2, "timeout");
      return (Criteria) this;
    }
    
    public Criteria andTimeoutNotBetween(String value1, String value2) {
      addCriterion("TIMEOUT not between", value1, value2, "timeout");
      return (Criteria) this;
    }
    
    public Criteria andUserIdIsNull() {
      addCriterion("USER_ID is null");
      return (Criteria) this;
    }
    
    public Criteria andUserIdIsNotNull() {
      addCriterion("USER_ID is not null");
      return (Criteria) this;
    }
    
    public Criteria andUserIdEqualTo(String value) {
      addCriterion("USER_ID =", value, "userId");
      return (Criteria) this;
    }
    
    public Criteria andUserIdNotEqualTo(String value) {
      addCriterion("USER_ID <>", value, "userId");
      return (Criteria) this;
    }
    
    public Criteria andUserIdGreaterThan(String value) {
      addCriterion("USER_ID >", value, "userId");
      return (Criteria) this;
    }
    
    public Criteria andUserIdGreaterThanOrEqualTo(String value) {
      addCriterion("USER_ID >=", value, "userId");
      return (Criteria) this;
    }
    
    public Criteria andUserIdLessThan(String value) {
      addCriterion("USER_ID <", value, "userId");
      return (Criteria) this;
    }
    
    public Criteria andUserIdLessThanOrEqualTo(String value) {
      addCriterion("USER_ID <=", value, "userId");
      return (Criteria) this;
    }
    
    public Criteria andUserIdLike(String value) {
      addCriterion("USER_ID like", value, "userId");
      return (Criteria) this;
    }
    
    public Criteria andUserIdNotLike(String value) {
      addCriterion("USER_ID not like", value, "userId");
      return (Criteria) this;
    }
    
    public Criteria andUserIdIn(List<String> values) {
      addCriterion("USER_ID in", values, "userId");
      return (Criteria) this;
    }
    
    public Criteria andUserIdNotIn(List<String> values) {
      addCriterion("USER_ID not in", values, "userId");
      return (Criteria) this;
    }
    
    public Criteria andUserIdBetween(String value1, String value2) {
      addCriterion("USER_ID between", value1, value2, "userId");
      return (Criteria) this;
    }
    
    public Criteria andUserIdNotBetween(String value1, String value2) {
      addCriterion("USER_ID not between", value1, value2, "userId");
      return (Criteria) this;
    }
    
    public Criteria andUserNameIsNull() {
      addCriterion("USER_NAME is null");
      return (Criteria) this;
    }
    
    public Criteria andUserNameIsNotNull() {
      addCriterion("USER_NAME is not null");
      return (Criteria) this;
    }
    
    public Criteria andUserNameEqualTo(String value) {
      addCriterion("USER_NAME =", value, "userName");
      return (Criteria) this;
    }
    
    public Criteria andUserNameNotEqualTo(String value) {
      addCriterion("USER_NAME <>", value, "userName");
      return (Criteria) this;
    }
    
    public Criteria andUserNameGreaterThan(String value) {
      addCriterion("USER_NAME >", value, "userName");
      return (Criteria) this;
    }
    
    public Criteria andUserNameGreaterThanOrEqualTo(String value) {
      addCriterion("USER_NAME >=", value, "userName");
      return (Criteria) this;
    }
    
    public Criteria andUserNameLessThan(String value) {
      addCriterion("USER_NAME <", value, "userName");
      return (Criteria) this;
    }
    
    public Criteria andUserNameLessThanOrEqualTo(String value) {
      addCriterion("USER_NAME <=", value, "userName");
      return (Criteria) this;
    }
    
    public Criteria andUserNameLike(String value) {
      addCriterion("USER_NAME like", value, "userName");
      return (Criteria) this;
    }
    
    public Criteria andUserNameNotLike(String value) {
      addCriterion("USER_NAME not like", value, "userName");
      return (Criteria) this;
    }
    
    public Criteria andUserNameIn(List<String> values) {
      addCriterion("USER_NAME in", values, "userName");
      return (Criteria) this;
    }
    
    public Criteria andUserNameNotIn(List<String> values) {
      addCriterion("USER_NAME not in", values, "userName");
      return (Criteria) this;
    }
    
    public Criteria andUserNameBetween(String value1, String value2) {
      addCriterion("USER_NAME between", value1, value2, "userName");
      return (Criteria) this;
    }
    
    public Criteria andUserNameNotBetween(String value1, String value2) {
      addCriterion("USER_NAME not between", value1, value2, "userName");
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