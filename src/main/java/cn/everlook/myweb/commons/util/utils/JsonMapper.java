package cn.everlook.myweb.commons.util.utils;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.TypeReference;

/**
 * JsonMapper定义对象和字符串之间的相互转换
 *
 * @author liyqt
 * @createDate 2018/10/22
 */
@Slf4j
public class JsonMapper {
  private static ObjectMapper objectMapper = new ObjectMapper();
  
  static {
    // config 排除掉值为空的字段
    // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
    objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
    objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
    objectMapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
    
    //设置将对象转换成JSON字符串时候:包含的属性不能为空或"";
    //Include.Include.ALWAYS 默认
    //Include.NON_DEFAULT 属性为默认值不序列化
    //Include.NON_EMPTY 属性为 空（""）  或者为 NULL 都不序列化
    //Include.NON_NULL 属性为NULL 不序列化
    objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
  }
  
  
  //  对象转字符串
  public static <T> String obj2String(T src) {
    if (src == null) {
      return null;
    }
    try {
      return src instanceof String ? (String) src : objectMapper.writeValueAsString(src);
    } catch (Exception e) {
      log.warn("parse object to String exception, error:{}", e);
      return null;
    }
  }
  
  
  //  字符串转对象
  public static <T> T string2Obj(String src, TypeReference<T> typeReference) {
    if (src == null || typeReference == null) {
      return null;
    }
    try {
      return (T) (typeReference.getType().equals(String.class) ? src : objectMapper.readValue(src, typeReference));
    } catch (Exception e) {
      log.warn("parse String to Object exception, String:{}, TypeReference<T>:{}, error:{}", src, typeReference.getType(), e);
      return null;
    }
  }
}
