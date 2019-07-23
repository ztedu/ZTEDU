package cn.everlook.myweb.commons.util.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 层级工具类，只适用于该项目的业务
 *
 * @author liyqt
 * @createDate 2018/10/23
 */
public class LevelUtil {
  
  public final static String SEPARATOR = ".";
  
  public final static String ROOT = "0";
  
  // 0
  // 0.1
  // 0.1.2
  // 0.1.3
  // 0.4
  public static String calculateLevel(String parentLevel, int parentId) {
    if (StringUtils.isBlank(parentLevel)) {
      return ROOT;
    } else {
      return StringUtils.join(parentLevel, SEPARATOR, parentId);
    }
  }
}