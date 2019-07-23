package cn.everlook.myweb.commons.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ApplicationContextHelper 可以直接获取ApplicationContextHelper中的applicationContext
 *
 *
 * public <T>这个T是个修饰符的功能，表示是个泛型方法，
 * 就像有static修饰的方法是个静态方法一样。
 *
 * <T> 不是返回值，表示传入参数有泛型
 *
 * public static <T>list<T> aslist(T...a)
 *
 * 第一个表示是泛型方法,第二个表示返回值是list类型，而这个list有泛型，
 * 只能存t类型的数据
 *
 *
 * @author liyqt
 * @createDate 2018/10/23
 */
@Component("applicationContextHelper")
public class ApplicationContextHelper implements ApplicationContextAware {
  
  private static ApplicationContext applicationContext;
  
  public void setApplicationContext(ApplicationContext context) throws BeansException {
    applicationContext = context;
  }
  
  public static <T> T popBean(Class<T> clazz) {
    if (applicationContext == null) {
      return null;
    }
    return applicationContext.getBean(clazz);
  }
  
  public static <T> T popBean(String name, Class<T> clazz) {
    if (applicationContext == null) {
      return null;
    }
    return applicationContext.getBean(name, clazz);
  }
}
