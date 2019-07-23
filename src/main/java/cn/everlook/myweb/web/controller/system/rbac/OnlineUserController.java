package cn.everlook.myweb.web.controller.system.rbac;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 在线用户管理
 *
 * @author Administrator
 * @createDate 2019/5/18
 */
@Controller
@RequestMapping("onlineUser")
public class OnlineUserController {
  
  /**
   * 跳转到在线用户管理界面
   */
  @RequestMapping("/toOnlineUserManager.do")
  @RequiresPermissions("onlineUser:list")
  public String toOnlineUserManager() {
    return "system/rbac/online_user/onlineUserManager";
  }
  
  
  
  
}
