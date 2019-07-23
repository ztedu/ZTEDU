package cn.everlook.myweb.commons.constast.rbac;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 加载左侧的当行菜单的类型，分位menu和permission
 *
 * @author Administrator
 * @createDate 2019/3/9
 */
public interface SYS_Constast {
  /**
   * 菜单类型
   */
  public static final String PERMISSION_TYPE_MENU = "menu";
  public static final String PERMISSION_TYPE_PERMISSION = "permission";
  
  /**
   * 菜单是否可用
   */
  public static final int AVAILABLE_YES = 1;
  public static final int AVAILABLE_NO = 0;
  
  /**
   * 加密的算法
   */
  public static final String SHA256 = "SHA-256";
  public static final String MD5 = "MD5";
}
