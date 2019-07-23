package cn.everlook.myweb.commons.util.password;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 代码生成工具
 *
 * @author liyqt
 * @createDate 2019/3/11
 */
public class EncodePasswordUtil {
  
  /**shiro原则的加密方式，可以用来进行密码修改以及初始加密密码的生成
   *
   * @param hashAlgorithmName 加密方式
   * @param crdentials 密码原值
   * @param salt 盐值
   * @param hashIterations 加密次数
   * @return
   */
  public static String encodePassword(String hashAlgorithmName, Object crdentials, Object salt, int hashIterations) {
    return new SimpleHash(hashAlgorithmName, crdentials, salt, hashIterations).toString();
  }
  
  public static void main(String[] args) {
    System.out.println(encodePassword("SHA-256","123456","admin",1024));
    System.out.println(encodePassword("MD5","123456","liyaqi",1024));
  }
  
}
