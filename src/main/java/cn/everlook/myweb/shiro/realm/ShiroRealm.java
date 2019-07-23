package cn.everlook.myweb.shiro.realm;

import cn.everlook.myweb.commons.filter.shiro.CaptchaToken;
import cn.everlook.myweb.commons.filter.shiro.exception.CaptchaEmptyException;
import cn.everlook.myweb.commons.filter.shiro.exception.CaptchaErrorException;
import cn.everlook.myweb.commons.util.byteSourceUtils.ByteSourceUtils;
import cn.everlook.myweb.persistence.entity.assort.rbac.user.CommSysUser;
import cn.everlook.myweb.persistence.entity.dto.rbac.user.ActiverUser;
import cn.everlook.myweb.service.system.rbac.permission.ICommSysPermissionService;
import cn.everlook.myweb.service.system.rbac.role.ICommSysRoleService;
import cn.everlook.myweb.service.system.rbac.user.ICommSysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Realm需要查询对应的数据库，并且得到正确的数据
 *
 * @author liyqt
 * @createDate 2018/9/11
 */
public class ShiroRealm extends AuthorizingRealm implements Serializable {
  
  @Autowired
  private ICommSysUserService iCommSysUserService;
  
  @Autowired
  private ICommSysPermissionService iCommSysPermissionService;
  
  @Autowired
  private ICommSysRoleService iCommSysRoleService;
  
  
  public String getName() {
    return this.getClass().getSimpleName();
  }
  
  /*
   *认证
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    // 在自定义的认证过滤器中将验证码保存至KaptchaCodeToken中
    // 此处的Token就是认证过滤器中实例化的Token,可以直接强制转换
    CaptchaToken captchaToken = (CaptchaToken) authenticationToken;
    // 获取用户在登录页面输入的验证码
    String loginCaptcha = captchaToken.getCaptchaCode();
    // 验证码未输入
    if (loginCaptcha == null || "".equals(loginCaptcha)) {
      // 抛出自定义异常(继承AuthenticationException), Shiro会捕获AuthenticationException异常
      // 发现该异常时认为登录失败,执行登录失败逻辑,登录失败页中可以判断如果是CaptchaEmptyException时为验证码为空
      throw new CaptchaEmptyException();
    }
    // 获取SESSION中的验证码
    // Kaptcha在生成验证码时会将验证码放入SESSION中
    // 默认KEY为KAPTCHA_SESSION_KEY, 可以在Web.xml中配置
//    String sessionCaptcha = (String) SecurityUtils.getSubject().getSession().getAttribute("KAPTCHA_SESSION_KEY");
    String sessionCaptcha = (String) SecurityUtils.getSubject().getSession().getAttribute("shiroCaptcha");
    // 比较登录输入的验证码和SESSION保存的验证码是否一致
    if (!loginCaptcha.equals(sessionCaptcha)) {
      // 抛出自定义异常(继承AuthenticationException), Shiro会捕获AuthenticationException异常
      // 发现该异常时认为登录失败,执行登录失败逻辑,登录失败页中可以判断如果是CaptchaEmptyException时为验证码错误
      throw new CaptchaErrorException();
    }
    
    
//    UsernamePasswordToken token = (UsernamePasswordToken) captchaToken;
    //得到用户登录名
    String loginName = captchaToken.getPrincipal().toString();
    //根据登录名查询用户
    CommSysUser commSysUser = iCommSysUserService.queryUserByLoginName(loginName);
    ActiverUser activerUser = new ActiverUser();
    if (commSysUser != null) {
      activerUser.setCurrentUser(commSysUser);
      //根据用户id查询角色
      activerUser.setRoles(this.iCommSysRoleService.queryRolesByUserId(commSysUser.getId()));
      //根据用户id查询权限
      activerUser.setPermissions(this.iCommSysPermissionService.queryPermissionByUserId(commSysUser.getId()));
      //盐值
      ByteSource salt = ByteSourceUtils.bytes(commSysUser.getLoginName());//salt
//      ByteSource salt = ByteSource.Util.bytes(commSysUser.getLoginName());
      AuthenticationInfo info = new SimpleAuthenticationInfo(activerUser, commSysUser.getPwd(), salt, getName());
      return info;
    } else {
      //用户不存在
      throw new UnknownAccountException();//没找到帐号
    }
  }
  
  
  //授权
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    //得到activeUser
    ActiverUser activerUser = (ActiverUser) principalCollection.getPrimaryPrincipal();
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    if (activerUser.getRoles() != null && activerUser.getRoles().size() > 0) {
      info.addRoles(activerUser.getRoles());
    }
    if (activerUser.getPermissions() != null && activerUser.getPermissions().size() > 0) {
      info.addStringPermissions(activerUser.getPermissions());
    }
    return info;
  }
  
  //清除当前用户缓存中的权限信息，需要在具体的业务的时候调用
  public void clearCache() {
    Subject subject = SecurityUtils.getSubject();
    super.clearCache(subject.getPrincipals());
  }
  
}


//在线用户
//权限缓存