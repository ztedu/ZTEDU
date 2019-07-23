package cn.everlook.myweb.web.controller.test.Kaptcha;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 此处填写说明
 *
 * @author Administrator
 * @createDate 2019/5/20
 */
@Controller
@RequestMapping("/kaptcha")
public class Kaptcha {
  
  @RequestMapping("/kaptcha/get")
  @ResponseBody
  public String getKaptcha(HttpSession session) {
    // Kaptcha生成验证后保存SESSION中的KEY为KAPTCHA_SESSION_KEY
    return (String) session.getAttribute("KAPTCHA_SESSION_KEY");
  }
}
