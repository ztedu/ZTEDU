package cn.everlook.myweb.commons.filter.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * shiro会话监听器
 *
 * @author liyqt
 * @createDate 2019/5/4
 */
public class ShiroSessionListener implements SessionListener {
  @Autowired
  private SessionDAO sessionDAO;
  
  private final AtomicInteger sessionCount = new AtomicInteger(0);
  
  @Override
  public void onStart(Session session) {//会话创建时触发
    sessionCount.incrementAndGet();
    Collection<Session> sessionsOriginal = sessionDAO.getActiveSessions();
    System.out.println("登陆+1==" + sessionCount.get());
    System.out.println("会话创建：" + session.getId());
  }
  
  @Override
  public void onStop(Session session) {//退出/会话过期时触发
    sessionCount.decrementAndGet();
    System.out.println("登陆-1==" + sessionCount.get());
    System.out.println("会话停止：" + session.getId());
  }
  
  @Override
  public void onExpiration(Session session) {//会话过期时触发
    sessionCount.decrementAndGet();
    System.out.println("登陆过期-1==" + sessionCount.get());
    System.out.println("会话过期：" + session.getId());
  }
  
}
