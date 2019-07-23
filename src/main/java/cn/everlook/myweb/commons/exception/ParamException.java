package cn.everlook.myweb.commons.exception;
/**
 * 参数异常
 *
 * @author liyqt
 * @createDate 2018/10/22
 */
public class ParamException extends RuntimeException {
  public ParamException() {
    super();
  }
  
  public ParamException(String message) {
    super(message);
  }
  
  public ParamException(String message, Throwable cause) {
    super(message, cause);
  }
  
  public ParamException(Throwable cause) {
    super(cause);
  }
  
  protected ParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
