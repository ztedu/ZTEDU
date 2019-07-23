package cn.everlook.myweb.commons.filter.shiro;

import cn.everlook.myweb.persistence.entity.dto.rbac.user.ActiverUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.ExpiredSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 登录拦截器
 *
 * @author liyqt
 * @createDate 2019/5/2
 */
public class LoginFormAuthenticationFilter extends FormAuthenticationFilter {
  
  @Override
  public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
    return super.onPreHandle(request, response, mappedValue);
  }
  
  @Override
  protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
    WebUtils.getAndClearSavedRequest(request);
    WebUtils.issueRedirect(request, response, getSuccessUrl(), null, true);
  }
  
  @Override
  protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
    Subject subject = SecurityUtils.getSubject();
    // 如果是记住我登录的，则需要处理一下
    // isRemembered为true、isAuthenticated为false
    if (!subject.isAuthenticated() && subject.isRemembered()) {
      // 通过记住我第一次进程序，并且保存的principal中有内容，添加用户到session
      if (subject.getSession().getAttribute("activerUser") == null && subject.getPrincipal() != null) {
        subject.getSession().setAttribute("activerUser", subject.getPrincipal());
      }
    }
    return subject.isAuthenticated() || subject.isRemembered();
  }
  
  
  /**
   * 构造Token,重写Shiro构造Token的方法,增加验证码
   */
  @Override
  protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
    String username = this.getUsername(request);
    String password = this.getPassword(request);
    boolean rememberMe = WebUtils.isTrue(request, this.getRememberMeParam());
    // 获取登录请求中用户输入的验证码
    //String code = (String) session.getAttribute("KAPTCHA_SESSION_KEY");
    String captchaCode = request.getParameter("captchaCode");
    // 返回带验证码的Token,Token会被传入Realm, 在Realm中可以取得验证码
    return new CaptchaToken(username, password, rememberMe, captchaCode);
  }
  
  
}
