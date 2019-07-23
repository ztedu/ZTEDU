package cn.everlook.myweb.web.controller.system.rbac;

import cn.everlook.myweb.annotation.log.SystemControllerLog;
import cn.everlook.myweb.commons.common.JsonData;
import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.commons.util.utils.ZTPinYinUtil;
import cn.everlook.myweb.persistence.entity.assort.rbac.user.CommSysUser;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.user.CommSysUserVo;
import cn.everlook.myweb.service.system.rbac.user.ICommSysUserService;
import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.ls.LSInput;

import java.util.List;

/**
 * 用户管理控制器
 *
 * @author Administrator
 * @createDate 2019/5/16
 */
@Controller
@RequestMapping("/user")
public class UserController {
  
  @Autowired
  private ICommSysUserService iCommSysUserService;
  
  /**
   * 跳转到用户管理界面
   */
  @RequestMapping("/toUserManager.do")
  @RequiresPermissions("user:list")
  public String toUserManager() {
    return "system/rbac/user/userManager";
  }
  
  
  /**
   * 加载用户列表
   */
  @SystemControllerLog(description = "加载用户")
  @RequestMapping("/loadAllUsers.do")
  @ResponseBody
  public DataGridView loadAllUsers(CommSysUserVo userVo) {
    DataGridView view = this.iCommSysUserService.queryAllUsers(userVo);
    return view;
  }
  
  
  /**
   * 点击右边的树对用户列表刷新
   */
  @RequestMapping("/clickTreeNodeloadAllUsers.do")
  @ResponseBody
  public DataGridView clickTreeNodeloadAllUsers(CommSysUserVo userVo) {
    DataGridView view = this.iCommSysUserService.clickTreeNodeloadAllUsers(userVo);
    return view;
  }
  
  
  /**
   * 跳转到用户添加的页面
   */
  @RequestMapping("/toAddUser.do")
  public String toAddUser() {
    return "system/rbac/user/userAdd";
  }
  
  
  /**
   * 根据部门ID查询用户
   */
  @RequestMapping("/loadAllUserByDeptId.do")
  @ResponseBody
  public List<CommSysUser> loadAllUserByDeptId(Integer deptId) {
    List<CommSysUser> commSysUserList = this.iCommSysUserService.loadAllUserByDeptId(deptId);
    return commSysUserList;
  }
  
  
  /**
   * 添加用户
   */
  @RequestMapping("/addNewUser.do")
  @ResponseBody
  public JsonData addNewUser(CommSysUserVo userVo) {
    CommSysUser user = iCommSysUserService.queryUserByLoginName(userVo.getLoginName());
    if (user == null) {
      if (userVo.getMgr() == null) {
        userVo.setMgr(0);
      }
      this.iCommSysUserService.addUser(userVo);
      return JsonData.success(userVo);
    } else
      return JsonData.fail("该用户名已存在，请修改后再次提交!");
    
  }
  
  /**
   * 把用户名改为拼音
   */
  @RequestMapping("/createLoginName.do")
  @ResponseBody
  public String createLoginName(String name) {
    return ZTPinYinUtil.getPingYin(name);
  }
  
  
  /**
   * 跳转到用户修改的页面
   */
  @RequestMapping("/toUpdateUser.do")
  public String toUpdateUser(CommSysUserVo userVo, Model model) {
    CommSysUser user = this.iCommSysUserService.queryUserById(userVo.getId());
    model.addAttribute("user", user);
    CommSysUser userLeader = this.iCommSysUserService.queryUserById(user.getMgr());
    model.addAttribute("userLeader", userLeader);
    return "system/rbac/user/userUpdate";
  }
  
  /**
   * 更新用户信息
   */
  @RequestMapping("/UpdateUser.do")
  @ResponseBody
  public JsonData UpdateUser(CommSysUserVo userVo) {
    CommSysUser user = iCommSysUserService.queryUserByLoginName(userVo.getLoginName());
    if (user == null) {
      if (userVo.getMgr() == null) {
        userVo.setMgr(0);
      }
      this.iCommSysUserService.updateUser(userVo);
      return JsonData.success(userVo);
    }
    if (user.getId() != userVo.getId()) {
      return JsonData.fail("该用户名已存在，请修改后再次提交!");
    }
    if (userVo.getMgr() == null) {
      userVo.setMgr(0);
    }
    this.iCommSysUserService.updateUser(userVo);
    return JsonData.success(userVo);
    
  }
  
  /**
   * 设置默认的密码
   *
   * @param userVo
   * @return
   */
  @RequestMapping("/resortPwd.do")
  @ResponseBody
  public JsonData resortPwd(CommSysUserVo userVo) {
    this.iCommSysUserService.updateUser(userVo);
    return JsonData.success(userVo);
  }
  
  
  /**
   * 删除某一个用户
   */
  @RequestMapping("/deleteUser.do")
  @ResponseBody
  public JsonData deleteUser(CommSysUserVo userVo) {
    if (userVo.getId() == 1) {
      return JsonData.fail("系统管理员账户不可删除!", 901);
    }
    this.iCommSysUserService.deleteUserByUserId(userVo.getId());
    return JsonData.success();
  }
  
  /**
   * 批量删除用户
   */
  @RequestMapping("/batchDeleteUser.do")
  @ResponseBody
  public JsonData batchDeleteUser(CommSysUserVo userVo) {
    Integer[] ids = userVo.getIds();
    if (null != ids && ids.length > 0) {
      for (Integer i : ids) {
        if (i == 1) {//系统管理员不可删除
          return JsonData.fail("包含管理员账号，不可删除!", 901);
        }
      }
    }
    if (null != ids && ids.length > 0) {
      for (Integer i : ids) {
        this.iCommSysUserService.deleteUserByUserId(i);
      }
    }
    return JsonData.success();
  }
  
  /**
   * 跳转到分配角色的界面
   */
  @RequestMapping("/toSelectUserRole.do")
  @RequiresPermissions("user:selectRole")
  public String toSelectUserRole(CommSysUserVo userVo, Model model) {
    CommSysUser user = this.iCommSysUserService.queryUserById(userVo.getId());
    model.addAttribute("user", user);
    return "system/rbac/user/selectUserRole";
  }
  
  /**
   * 给用户添加角色
   *
   * @param userVo
   * @return
   */
  @RequestMapping("/addRoles.do")
  @ResponseBody
  public JsonData addRoles(CommSysUserVo userVo) {
    this.iCommSysUserService.addRolesToUser(userVo);
    return JsonData.success();
  }
  
  /**
   * 查询当前可用的角色并选中已拥有的角色
   */
  @SystemControllerLog(description = "查询拥有角色")
  @RequestMapping("/loadAllUserRoles.do")
  @ResponseBody
  public DataGridView loadAllUserRoles(CommSysUserVo userVo) {
    DataGridView view = this.iCommSysUserService.loadAllUserRoles(userVo);
    return view;
  }
  
  /**
   * 查询当前搜索的部门并选中已拥有的角色
   */
  
  @RequestMapping("/loadAllSelectUserRoles.do")
  @ResponseBody
  public DataGridView loadAllSelectUserRoles(CommSysUserVo userVo) {
    DataGridView view = this.iCommSysUserService.loadAllSelectUserRoles(userVo);
    return view;
  }
}
