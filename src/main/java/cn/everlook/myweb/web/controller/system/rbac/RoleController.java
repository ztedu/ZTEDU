package cn.everlook.myweb.web.controller.system.rbac;

import cn.everlook.myweb.annotation.log.SystemControllerLog;
import cn.everlook.myweb.commons.common.JsonData;
import cn.everlook.myweb.commons.constast.rbac.SYS_Constast;
import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.commons.util.treeNode.ZTreeNode;
import cn.everlook.myweb.commons.util.treeNode.ZTreeNodeBuilder;
import cn.everlook.myweb.persistence.entity.assort.rbac.dept.CommSysDept;
import cn.everlook.myweb.persistence.entity.assort.rbac.permission.CommSysPermission;
import cn.everlook.myweb.persistence.entity.assort.rbac.role.CommSysRole;
import cn.everlook.myweb.persistence.entity.dto.rbac.user.ActiverUser;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.dept.DeptVo;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.permission.PermissionVo;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.role.RoleVo;
import cn.everlook.myweb.service.system.rbac.permission.ICommSysPermissionService;
import cn.everlook.myweb.service.system.rbac.role.ICommSysRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.NodeSetData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色控制器
 *
 * @author liyqt
 * @createDate 2019/7/4
 */
@Controller
@RequestMapping("/role")
public class RoleController {
  
  @Autowired
  private ICommSysRoleService iCommSysRoleService;
  
  @Autowired
  private ICommSysPermissionService iCommSysPermissionService;
  
  /**
   * 跳转到角色界面
   */
  @RequestMapping("/toRoleManager.do")
  @RequiresPermissions("role:list")
  public String toRoleManager() {
    return "system/rbac/role/roleManager";
  }
  
  
  /**
   * 加载角色列表
   */
  @SystemControllerLog(description = "加载角色")
  @RequestMapping("/loadAllRoles.do")
  @ResponseBody
  public DataGridView loadAllRoles(RoleVo roleVo) {
    DataGridView view = this.iCommSysRoleService.queryAllRoles(roleVo);
    return view;
  }
  
  /**
   * 加载角色列表
   */
  @SystemControllerLog(description = "加载职位")
  @RequestMapping("/loadAllPosition.do")
  @ResponseBody
  public List<CommSysRole> loadAllPosition() {
    List<CommSysRole> roles = this.iCommSysRoleService.loadAllPosition();
    return roles;
  }
  
  
  /**
   * 跳转到添加角色的页面
   */
  @RequestMapping("/toAddRole.do")
  public String toAddRole() {
    return "system/rbac/role/roleAdd";
  }
  
  
  /**
   * 添加角色
   */
  @RequestMapping("/addRole.do")
  @ResponseBody
  public JsonData addRole(RoleVo roleVo) {
    this.iCommSysRoleService.addRole(roleVo);
    return JsonData.success(roleVo);
  }
  
  
  /**
   * 跳转到角色修改的页面
   */
  @RequestMapping("/toUpdateRole.do")
  public String toUpdateRole(RoleVo roleVo, Model model) {
    CommSysRole role = this.iCommSysRoleService.queryRoleById(roleVo.getId());
    model.addAttribute("role", role);
    return "system/rbac/role/roleUpdate";
  }
  
  /**
   * 修改部门信息
   */
  @RequestMapping("/updateRole.do")
  @ResponseBody
  public JsonData updateRole(RoleVo roleVo) {
    this.iCommSysRoleService.updateRole(roleVo);
    return JsonData.success(roleVo);
  }
  
  
  /**
   * 删除角色信息
   */
  @RequestMapping("/deleteRole.do")
  @ResponseBody
  public JsonData deleteRole(RoleVo roleVo) {
    //查看该角色现在系统里面有没有正在被使用
    Integer userRoleCount = iCommSysRoleService.selectThisRoleUsingCount(roleVo);
    if (userRoleCount > 0) {//删除的角色正在被使用
      return JsonData.fail("该角色已使用,不可删除!", 901);
    } else {//删除对应的角色
      this.iCommSysRoleService.deleteRole(roleVo.getId());
      return JsonData.success();
    }
  }
  
  
  /**
   * 批量删除角色信息
   */
  @RequestMapping("/batchDeleteRole.do")
  @ResponseBody
  public JsonData batchDeleteRole(RoleVo roleVo) {
    Integer[] ids = roleVo.getIds();
    if (null != ids && ids.length > 0) {
      for (Integer i : ids) {
        Integer userCount = this.iCommSysRoleService.selectThisRoleUsingCountById(i);
        if (userCount > 0) {//删除的角色正在被使用
          return JsonData.fail("有的角色已使用,不可删除!", 901);
        }
      }
      for (Integer i : ids) {
        this.iCommSysRoleService.deleteRole(i);
      }
    } else {
      return JsonData.fail("请选择需要删除的角色!", 902);
    }
    return JsonData.success();
  }
  
  
  /**
   * 跳转到给角色添加权限的页面
   */
  @RequestMapping("/toSelectPermissions.do")
  public String toSelectPermissions(RoleVo roleVo, Model model) {
    CommSysRole role = this.iCommSysRoleService.queryRoleById(roleVo.getId());
    model.addAttribute("role", role);
    return "system/rbac/role/selectPermissions";
  }
  
  
  //加载权限树的json和选中当前角色的已有的权限
  @RequestMapping("/initRolePermissionTree.do")
  @ResponseBody
  public List<ZTreeNode> initRolePermissionTree(RoleVo roleVo) {
    List<ZTreeNode> nodes = new ArrayList<>();
    //查询所有的可用的权限和菜单
    PermissionVo permissionVo = new PermissionVo();
    permissionVo.setAvailable(SYS_Constast.AVAILABLE_YES);//查询可用的权限
    List<CommSysPermission> allPermissions = iCommSysPermissionService.queryAllTreePermissionForList(permissionVo);
    //查询已有的权限
    List<CommSysPermission> rolePermissions = iCommSysPermissionService.queryPermissionByRoleIdForList(roleVo.getId());
    
    for (CommSysPermission all : allPermissions) {
      Boolean checked = false;
      for (CommSysPermission permission : rolePermissions) {
        if (permission.getId() == all.getId()) {
          checked = true;
          break;
        }
      }
      Boolean isParent = all.getParent() == 1 ? true : false;
      Boolean open = all.getSpread() == 1 ? true : false;
      nodes.add(new ZTreeNode(all.getId(), all.getPid(), all.getName(), isParent, open, checked));
    }
    return ZTreeNodeBuilder.build(nodes, 0);
  }
  
  //保存角色和权限之间的关系
  @RequestMapping("/addRolePermission.do")
  @ResponseBody
  public Map<String, Object> addRolePermission(RoleVo roleVo) {
    Map<String, Object> map = new HashMap<>();
    try {
      this.iCommSysRoleService.addRolePermissions(roleVo);
      map.put("msg", "分配权限成功!");
    } catch (Exception e) {
      e.printStackTrace();
      map.put("msg", "分配权限失败!");
    }
    return map;
  }
  

  
}
