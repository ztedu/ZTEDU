package cn.everlook.myweb.commons.filter.shiro.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 自定义验证码错误异常
 * AuthenticationException为Shiro认证错误的异常,不同错误类型继承该异常即可
 *
 * @author Administrator
 * @createDate 2019/5/20
 */
public class CaptchaErrorException extends AuthenticationException {
  
  
  public CaptchaErrorException() {
  }

  public CaptchaErrorException(String message) {
    super(message);
  }

  public CaptchaErrorException(Throwable cause) {
    super(cause);
  }

  public CaptchaErrorException(String message, Throwable cause) {
    super(message, cause);
  }
}
