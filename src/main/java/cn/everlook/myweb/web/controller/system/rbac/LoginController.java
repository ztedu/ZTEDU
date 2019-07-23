package cn.everlook.myweb.web.controller.system.rbac;

import cn.everlook.myweb.annotation.log.SystemControllerLog;
import cn.everlook.myweb.commons.filter.shiro.CaptchaToken;
import cn.everlook.myweb.commons.filter.shiro.exception.CaptchaEmptyException;
import cn.everlook.myweb.commons.filter.shiro.exception.CaptchaErrorException;
import cn.everlook.myweb.persistence.entity.dto.rbac.user.ActiverUser;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.user.CommSysUserVo;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 登录控制器
 *
 * @author liyqt
 * @createDate 2019/2/28
 */
@Controller
@RequestMapping("/login")
@CommonsLog
public class LoginController {
  
  //  跳转到登录界面
  @RequestMapping("/toLogin.do")
  public String toLogin() {
    return "system/rbac/login";
  }
  
  //  跳转到个人信息界面
  @RequestMapping("/personInfo.do")
  public String toPersonInfo() {
    return "system/rbac/user/personInfo";
  }
  
  //跳转到首页面
  @RequestMapping("/index.do")
  public ModelAndView index() {
    return new ModelAndView("system/rbac/index");
  }
  
  @RequestMapping("/console.do")
  public ModelAndView console(){
    return new ModelAndView("system/rbac/console");
  }
  
  
  
  //  登录
  @SystemControllerLog(description = "登录系统")
  @ResponseBody
  @RequestMapping("/login.do")
  public Map<String, Object> login(@RequestBody CommSysUserVo commSysUserVo, Model model, HttpSession session) throws AuthenticationException {
    Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
    String msg;
    //    1.创建UserNamePasswordToken
    CaptchaToken captchaToken = new CaptchaToken(commSysUserVo.getLoginName(), commSysUserVo.getPwd(), commSysUserVo.isRememberMe(),commSysUserVo.getCaptchaCode());
    //2.得到Subject
    Subject subject = SecurityUtils.getSubject();
    try {
      subject.login(captchaToken);
      //得到ActiverUser
      ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
      session.setAttribute("activerUser", activerUser);
      if (subject.isAuthenticated()) {
        System.out.println("认证成功！");
        resultMap.put("status", 200);
        resultMap.put("message", "登录成功");
//        return resultMap;
      }
    } catch (ExcessiveAttemptsException e) {
      e.printStackTrace();
      resultMap.put("status", 202);
      resultMap.put("message", "登录失败多次，账户锁定1分钟!");
//      throw new ExcessiveAttemptsException();
    } catch (IncorrectCredentialsException e) {
      e.printStackTrace();
      resultMap.put("status", 201);
      resultMap.put("message", "用户名或密码错误!");
//      throw new IncorrectCredentialsException();
    } catch (LockedAccountException e) {
      e.printStackTrace();
      msg = "帐号已被锁定,如有疑问请联系管理员. ";//The account for username " + token.getPrincipal() + " was locked.
      model.addAttribute("message", msg);
//      throw new LockedAccountException();
    } catch (DisabledAccountException e) {
      e.printStackTrace();
      msg = "帐号已被禁用. ";//The account for username " + token.getPrincipal() + " was disabled.
      model.addAttribute("message", msg);
//      throw new DisabledAccountException();
    } catch (ExpiredCredentialsException e) {
      e.printStackTrace();
      msg = "帐号已过期. ";//the account for username " + token.getPrincipal() + "  was expired.
      model.addAttribute("message", msg);
//      throw new ExpiredCredentialsException();
    } catch (UnknownAccountException e) {
      e.printStackTrace();
      resultMap.put("status", 201);
      resultMap.put("message", "用户名或密码错误!");
//      throw new UnknownAccountException();
    } catch (UnauthorizedException e) {
      e.printStackTrace();
      msg = "您没有得到相应的授权！" + e.getMessage();
      model.addAttribute("message", msg);
//      throw new UnauthorizedException();
    } catch (CaptchaEmptyException e) {
      e.printStackTrace();
      resultMap.put("status", 203);
      resultMap.put("message", "请输入验证码！!");
    }catch (CaptchaErrorException e) {
      e.printStackTrace();
      resultMap.put("status", 204);
      resultMap.put("message", "验证码错误!");
    }catch (AuthenticationException e) {
      e.printStackTrace();
      resultMap.put("status", 205);
      resultMap.put("message", "登录失败!");
//      throw new AuthenticationException();
    }
    return resultMap;
    
  }
  
  
  
  
}
