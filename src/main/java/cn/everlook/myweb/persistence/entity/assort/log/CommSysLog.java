package cn.everlook.myweb.persistence.entity.assort.log;

import cn.everlook.myweb.commons.util.easyexcel.DataUtil;
import cn.everlook.myweb.commons.util.utils.DateUtils;
import cn.everlook.myweb.commons.util.utils.StringUtil;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Setter
@Getter
public class CommSysLog extends BaseRowModel implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @ExcelProperty(value = {"操作日志", "日志主键"}, index = 0)
  private String logId; //日志主键
  
  @ExcelProperty(value = {"操作日志", "日志类型"}, index = 1)
  private String type;//日志类型
  
  @ExcelProperty(value = {"操作日志", "日志标题"}, index = 2)
  private String title; //日志标题
  
  @ExcelProperty(value = {"操作日志", "请求地址"}, index = 3)
  private String remoteAddr;//请求地址
  
  @ExcelProperty(value = {"操作日志", "URI"}, index = 4)
  private String requestUri;//URI
  
  @ExcelProperty(value = {"操作日志", "请求方式"}, index = 5)
  private String method;//请求方式
  
  @ExcelProperty(value = {"操作日志", "提交参数"}, index = 6)
  private String params;//提交参数
  
  @ExcelProperty(value = {"操作日志", "异常"}, index = 7)
  private String exception;//异常
  
  @ExcelProperty(value = {"操作日志", "开始时间"}, index = 8)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date operateDate;//开始时间
  
  @ExcelProperty(value = {"操作日志", "结束时间"}, index = 9)
  private String timeout; //结束时间
  
  private String userId;//用户ID
  
  @ExcelProperty(value = {"操作日志", "用户名称"}, index = 10)
  private String userName;//用户名称
  
  public String getLogId() {
    return StringUtil.isBlank(logId) ? logId : logId.trim();
  }
  
  
  public String getType() {
    return StringUtil.isBlank(type) ? type : type.trim();
  }
  
  
  public String getTitle() {
    return StringUtil.isBlank(title) ? title : title.trim();
  }
  
  
  public String getRemoteAddr() {
    return StringUtil.isBlank(remoteAddr) ? remoteAddr : remoteAddr.trim();
  }
  
  
  public String getRequestUri() {
    return StringUtil.isBlank(requestUri) ? requestUri : requestUri.trim();
  }
  
  
  public String getMethod() {
    return StringUtil.isBlank(method) ? method : method.trim();
  }
  
  
  public String getParams() {
    return StringUtil.isBlank(params) ? params : params.trim();
  }
  
  
  /**
   * 设置请求参数
   *
   * @param paramMap
   */
  public void setMapToParams(Map<String, String[]> paramMap) {
    if (paramMap == null) {
      return;
    }
    StringBuilder params = new StringBuilder();
    for (Map.Entry<String, String[]> param : ((Map<String, String[]>) paramMap).entrySet()) {
      params.append(("".equals(params.toString()) ? "" : "&") + param.getKey() + "=");
      String paramValue = (param.getValue() != null && param.getValue().length > 0 ? param.getValue()[0] : "");
      params.append(StringUtil.abbr(StringUtil.endsWithIgnoreCase(param.getKey(), "password") ? "" : paramValue, 100));
    }
    this.params = params.toString();
  }
  
  
  public String getException() {
    return StringUtil.isBlank(exception) ? exception : exception.trim();
  }
  
  
  public Date getOperateDate() {
    return operateDate;
  }
  
  
  public String getTimeout() {
    return StringUtils.isBlank(timeout) ? timeout : timeout.trim();
  }
  
  public void setTimeout(String timeout) {
    this.timeout = timeout;
  }
  
  
  public String getUserId() {
    return StringUtil.isBlank(userId) ? userId : userId.trim();
  }
  
  public String getUserName() {
    return userName;
  }
  
  public void setUserName(String userName) {
    this.userName = userName == null ? null : userName.trim();
  }
  
  @Override
  public String toString() {
    return "Log [logId=" + logId + ", type=" + type + ", title=" + title
        + ", remoteAddr=" + remoteAddr + ", requestUri=" + requestUri
        + ", method=" + method + ", params=" + params + ", exception="
        + exception + ", operateDate=" + operateDate + ", timeout="
        + timeout + ", userId=" + userId + "]";
  }
  
}