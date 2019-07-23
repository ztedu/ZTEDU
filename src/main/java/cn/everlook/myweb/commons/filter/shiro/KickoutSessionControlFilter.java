package cn.everlook.myweb.commons.filter.shiro;

import cn.everlook.myweb.persistence.entity.dto.rbac.user.ActiverUser;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 强制退出过滤器
 *
 * @author Administrator
 * @createDate 2019/5/17
 */
public class KickoutSessionControlFilter extends AccessControlFilter {
  private String kickoutUrl; //踢出后到的地址
  private boolean kickoutAfter = false; //踢出之前登录的/之后登录的用户 默认踢出之前登录的用户
  private int maxSession = 1; //同一个帐号最大会话数 默认1
  private SessionManager sessionManager;
  private Cache<String, Deque<Serializable>> cache;
  
  public void setKickoutUrl(String kickoutUrl) {
    this.kickoutUrl = kickoutUrl;
  }
  
  public void setKickoutAfter(boolean kickoutAfter) {
    this.kickoutAfter = kickoutAfter;
  }
  
  public void setMaxSession(int maxSession) {
    this.maxSession = maxSession;
  }
  
  public void setSessionManager(SessionManager sessionManager) {
    this.sessionManager = sessionManager;
  }
  
  public void setCacheManager(CacheManager cacheManager) {
    this.cache = cacheManager.getCache("shiro-activeSessionCache");
  }
  
 /**
   * 是否允许访问，返回true表示允许
   */
  @Override
  protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
    return false;
  }
  
  /**
   * 表示访问拒绝时是否自己处理，如果返回true表示自己不处理且继续拦截器链执行，
   * 返回false表示自己已经处理了（比如重定向到另一个页面）。
   */
  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    Subject subject = getSubject(request, response);
    if (!subject.isAuthenticated() && !subject.isRemembered()) {
      //如果没有登录，直接进行之后的流程
      return true;
    }
    
    Session session = subject.getSession();
    ActiverUser activerUser = (ActiverUser)subject.getPrincipal();
    String username = activerUser.getCurrentUser().getLoginName();
    Serializable sessionId = session.getId();
    
    //TODO 同步控制
    Deque<Serializable> deque = cache.get(username);
    if (deque == null) {
      deque = new LinkedList<Serializable>();
      cache.put(username, deque);
    }
    
    //如果队列里没有此sessionId，且用户没有被踢出；放入队列
    if (!deque.contains(sessionId) && session.getAttribute("kickout") == null) {
      deque.push(sessionId);
    }
    
    //如果队列里的sessionId数超出最大会话数，开始踢人
    while (deque.size() > maxSession) {
      Serializable kickoutSessionId = null;
      if (kickoutAfter) { //如果踢出后者
        kickoutSessionId = deque.getFirst();
        kickoutSessionId = deque.removeFirst();
      } else { //否则踢出前者
        kickoutSessionId = deque.removeLast();
      }
      try {
        Session kickoutSession = sessionManager.getSession(new DefaultSessionKey(kickoutSessionId));
        if (kickoutSession != null) {
          //设置会话的kickout属性表示踢出了
          kickoutSession.setAttribute("kickout", true);
        }
      } catch (Exception e) {//ignore exception
        e.printStackTrace();
      }
    }
    
    //如果被踢出了，直接退出，重定向到踢出后的地址
    if (session.getAttribute("kickout") != null) {
      //会话被踢出了
      try {
        subject.logout();
      } catch (Exception e) { //ignore
      }
      saveRequest(request);
      WebUtils.issueRedirect(request, response, kickoutUrl);
      return false;
    }
    
    return true;
  }
}
