package cn.everlook.myweb.commons.common;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求返回Json数据封装
 *
 * @author liyqt
 * @createDate 2018/10/22
 */
@Getter
@Setter
public class JsonData {
  private Integer code;
  
  private boolean ret;
  
  private String msg;
  
  private Object data;
  
  public JsonData(boolean ret) {
    this.ret = ret;
  }
  
  public static JsonData success(Object object, String msg, Integer code) {
    JsonData jsonData = new JsonData(true);
    jsonData.data = object;
    jsonData.msg = msg;
    jsonData.code = code;
    return jsonData;
  }
  
  public static JsonData success(Object object, String msg) {
    JsonData jsonData = new JsonData(true);
    jsonData.data = object;
    jsonData.msg = msg;
    return jsonData;
  }
  
  public static JsonData success(Object object) {
    JsonData jsonData = new JsonData(true);
    jsonData.data = object;
    return jsonData;
  }
  
  public static JsonData success() {
    return new JsonData(true);
  }
  
  public static JsonData fail(String msg) {
    JsonData jsonData = new JsonData(false);
    jsonData.msg = msg;
    return jsonData;
  }
  
  public static JsonData fail(String msg,Integer code) {
    JsonData jsonData = new JsonData(false);
    jsonData.msg = msg;
    jsonData.code = code;
    return jsonData;
  }
  
  public Map<String, Object> toMap() {
    HashMap<String, Object> result = new HashMap<String, Object>();
    result.put("ret", ret);
    result.put("msg", msg);
    result.put("data", data);
    return result;
  }
  
}
