package cn.everlook.myweb.web.controller.system.rbac;

import cn.everlook.myweb.commons.common.JsonData;
import cn.everlook.myweb.commons.constast.rbac.SYS_Constast;
import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.commons.util.treeNode.TreeNode;
import cn.everlook.myweb.commons.util.treeNode.TreeNodeBuilder;
import cn.everlook.myweb.persistence.entity.assort.rbac.permission.CommSysPermission;
import cn.everlook.myweb.persistence.entity.dto.rbac.user.ActiverUser;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.permission.PermissionVo;
import cn.everlook.myweb.service.system.rbac.permission.ICommSysPermissionService;
import com.google.common.collect.Lists;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 权限控制器
 *
 * @author Administrator
 * @createDate 2019/3/9
 */
@Controller
@RequestMapping("permission")
public class PermissionController {
  
  @Autowired
  private ICommSysPermissionService permissionService;
  
  @Autowired
  private SessionDAO sessionDAO;
  
  
  /**
   * 加载index页面左边的导航树
   */
  @RequestMapping("loadIndexTreeMenus.do")
  @ResponseBody
  public JsonData loadIndexTreeMenus() {
    Subject subject = SecurityUtils.getSubject();
    //1、查询当前用户的所有菜单 type=menu
    ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
    List<TreeNode> nodes = new ArrayList<>();
    List<CommSysPermission> permissions = this.permissionService.queryAllTreePermissionForList(activerUser.getCurrentUser().getId());
    for (CommSysPermission p : permissions) {
      boolean spread = p.getSpread() == 1 ? true : false;
      nodes.add(new TreeNode(p.getId(), p.getPid(), p.getName(), p.getHref(), p.getIcon(), spread));
    }
    //构造树de对象
    List<TreeNode> data = TreeNodeBuilder.build(nodes, 1);
    return JsonData.success(data, "", 0);
  }
  
  
  /********** 权限管理开始**********/
  
  /**
   * 跳转到权限界面界面
   */
  @RequestMapping("/toPermissionManager.do")
  public String toPermissionManager() {
    return "system/rbac/permission/permissionManager";
  }
  
  
  /**
   * 跳转到权限界面界面
   */
  @RequestMapping("/toAddPermission.do")
  public String toAddPermission() {
    return "system/rbac/permission/permissionAdd";
  }
  
  
  /**
   * 加载权限列表
   */
  @RequestMapping("/loadAllPermissions.do")
  @ResponseBody
  public DataGridView loadAllPermissions(PermissionVo permissionVo) {
//    Collection<Session> sessionMiddle = new ArrayList<>();
//    Collection<Session> sessionResult = new ArrayList();
//    Collection<Session> sessionsOriginal = sessionDAO.getActiveSessions();
//    List<Session> result = Lists.newArrayList(sessionsOriginal);
//    System.out.println(sessionsOriginal);
//    try {
//      // 获取在线用户信息 下面的代码封装成list，好做分页查询功能
//      for (int i = 0; i < result.size(); i++) {
//        if (result.get(i) instanceof Session) {
//          System.out.println("==========" + result.get(i));
//          sessionResult.add(result.get(i));
//        }
//
//      }
//
//
//      List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//      Map<String, Object> m;
//      for (Session s : sessionResult) {
//        m = new HashMap<String, Object>();
//        m.put("sessionId", s.getId());
//        Object obj = s.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
//        if (obj != null) {
//          SimplePrincipalCollection spc = (SimplePrincipalCollection) obj;
//          if (spc.getPrimaryPrincipal() != null) {
//            sessionResult.add(s);
//          }
//        } else {
//          continue;
//        }
//        list.add(m);// 装成list，好做分页查询功能
//        System.out.println("-----------------------" + list);
//      }
//    } catch (Exception e) {
//      System.out.println(e.getMessage());
//    }
//    System.out.println(sessionResult);
    
    
    permissionVo.setType(SYS_Constast.PERMISSION_TYPE_PERMISSION);
    //查询所有的权限 type=Permissions
    DataGridView view = this.permissionService.queryAllPermissions(permissionVo);
    return view;
  }
  
  
  /**
   * 点击右边的树对权限列表刷新
   */
  @RequestMapping("/clickTreeNodeLoadAllPermissions.do")
  @ResponseBody
  public DataGridView clickTreeNodeLoadAllPermissions(PermissionVo permissionVo) {
    DataGridView view = this.permissionService.clickTreeNodeLoadAllPermissions(permissionVo);
    return view;
  }
  
  /**
   * 批量删除权限信息
   */
  @RequestMapping("/batchDeletePermission.do")
  @ResponseBody
  public JsonData batchDeletePermission(PermissionVo permissionVo) {
    Integer[] ids = permissionVo.getIds();
    if (null != ids && ids.length > 0) {
      for (Integer i : ids) {
        this.permissionService.deletePermission(i);
      }
    } else {
      return JsonData.fail("请选择需要删除的权限!", 902);
    }
    return JsonData.success();
  }
  
  /**
   * 删除权限信息
   */
  @RequestMapping("/deletePermission.do")
  @ResponseBody
  public JsonData deletePermission(PermissionVo permissionVo) {
    this.permissionService.deletePermission(permissionVo.getId());
    return JsonData.success();
    
  }
  
  
  /**
   * 添加权限
   */
  @RequestMapping("/addPermission.do")
  @ResponseBody
  public JsonData addPermission(PermissionVo permissionVo) {
    permissionVo.setSpread(0);
    this.permissionService.addPermission(permissionVo);
    int maxId = permissionService.getMaxIdWithPermission(permissionVo);
    permissionVo.setId(maxId);
    return JsonData.success(permissionVo);
  }
  
  
  /**
   * 跳转到权限修改的页面
   */
  @RequestMapping("/toUpdatePermission.do")
  public String toUpdatePermission(PermissionVo permissionVo, Model model) {
    CommSysPermission permission = this.permissionService.queryMenuById(permissionVo.getId());
    model.addAttribute("permission", permission);
    return "system/rbac/permission/permissionUpdate";
  }
  
  
  /**
   * 修权限信息
   */
  @RequestMapping("/updatePermission.do")
  @ResponseBody
  public JsonData updateDept(PermissionVo permissionVo) {
    this.permissionService.updateMenu(permissionVo);
    return JsonData.success(permissionVo);
  }
  
  /********** 权限管理结束**********/
  
  
}
