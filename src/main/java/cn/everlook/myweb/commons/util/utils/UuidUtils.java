package cn.everlook.myweb.commons.util.utils;

import java.util.UUID;

/**
 * UuidUtils
 *
 * @author Administrator
 * @createDate 2019/5/21
 */
public class UuidUtils {
  
  public static String creatUUID() {
    return UUID.randomUUID().toString().replace("-", "");
  }
  
  public static void main(String[] args) {
    System.out.println(UuidUtils.creatUUID());
  }
}
