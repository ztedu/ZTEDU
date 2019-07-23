package cn.everlook.myweb.commons.filter.shiro;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;

/**
 * 此处填写说明
 *
 * @author Administrator
 * @createDate 2019/5/20
 */
public class CaptchaToken extends UsernamePasswordToken implements Serializable {
  // 序列化ID
  private static final long serialVersionUID = -2804050723838289739L;
  
  // 验证码
  private String captchaCode;
  
  /**
   * 构造函数
   * 用户名和密码是登录必须的,因此构造函数中包含两个字段
   */
  public CaptchaToken(String username, String password, boolean rememberMe, String captchaCode) {
    // 父类UsernamePasswordToken的构造函数,后两个参数暂不需要, 不设置
    super(username, password, rememberMe, "");
    this.captchaCode = captchaCode;
  }
  
  /**
   * 获取验证码
   */
  public String getCaptchaCode() {
    return captchaCode;
  }
  
}
