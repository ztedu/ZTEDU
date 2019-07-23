package cn.everlook.myweb.commons.common;

import cn.everlook.myweb.commons.exception.ParamException;
import cn.everlook.myweb.commons.exception.PermissionException;
import cn.everlook.myweb.commons.filter.shiro.exception.CaptchaEmptyException;
import cn.everlook.myweb.commons.filter.shiro.exception.CaptchaErrorException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.ExpiredSessionException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

/**
 * 实现HandlerExceptionResolver统一处理异常,对全局的异常进行捕捉
 *
 * @author liyqt
 * @createDate 2018/10/22
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {
  
  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    String url = request.getRequestURL().toString();
    ModelAndView mv;
    String defaultMsg = "System Error!";
//    System.out.println("URL+++++" + url);
    
    // 这里我们要求项目中所有请求json数据，都使用.do结尾
    if (url.endsWith(".do")) {
      if (ex instanceof PermissionException ||
          ex instanceof ParamException ||
          ex instanceof IncorrectCredentialsException ||
          ex instanceof CaptchaErrorException ||
          ex instanceof CaptchaEmptyException ||
          ex instanceof FileNotFoundException
      ) {
        JsonData result = JsonData.fail(ex.getMessage());
        mv = new ModelAndView("jsonView", result.toMap());
      } else if (ex instanceof MaxUploadSizeExceededException) {//文件过大异常
        ModelAndView maxMv = new ModelAndView();
        //指定错误信息
        maxMv.addObject("errormessage", "上传文件过大");
        //设置跳转视图
        maxMv.setViewName("/common/error/maxUploadSizeErrorPage");
        return maxMv;
      } else if (ex instanceof UnauthenticatedException) {//认证异常
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errormessage", "认证异常");
        modelAndView.setViewName("/common/error/404");
        return modelAndView;
      } else if (ex instanceof UnauthorizedException) {//授权异常
        ModelAndView view = new ModelAndView();
        view.addObject("errormessage", "授权异常");
        view.setViewName("/common/error/403");
        return view;
      } else if (ex instanceof ExpiredSessionException) {
        return new ModelAndView("redirect:/login/toLogin.do");
      } else {
        log.error("unknown json exception, url:" + url, ex);
        JsonData result = JsonData.fail(defaultMsg);
        mv = new ModelAndView("jsonView", result.toMap());
      }
    } else if (url.endsWith(".page")) { // 这里我们要求项目中所有请求page页面，都使用.page结尾
      log.error("unknown page exception, url:" + url, ex);
      JsonData result = JsonData.fail(defaultMsg);
      mv = new ModelAndView("/common/execption", result.toMap());
    } else {
      log.error("unknow exception, url:" + url, ex);
      JsonData result = JsonData.fail(defaultMsg);
      mv = new ModelAndView("jsonView", result.toMap());
    }
    return mv;
  }
}
