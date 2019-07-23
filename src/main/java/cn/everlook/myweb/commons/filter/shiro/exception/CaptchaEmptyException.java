package cn.everlook.myweb.commons.filter.shiro.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 自定义验证码为空异常
 * AuthenticationException为Shiro认证错误的异常,不同错误类型继承该异常即可
 *
 * @author Administrator
 * @createDate 2019/5/20
 */
public class CaptchaEmptyException extends AuthenticationException {
  public CaptchaEmptyException() {
  }

  public CaptchaEmptyException(String message) {
    super(message);
  }

  public CaptchaEmptyException(Throwable cause) {
    super(cause);
  }

  public CaptchaEmptyException(String message, Throwable cause) {
    super(message, cause);
  }
  
 
}
