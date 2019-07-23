package cn.everlook.myweb.web.controller.system.rbac;

import cn.everlook.myweb.commons.common.JsonData;
import cn.everlook.myweb.commons.constast.rbac.SYS_Constast;
import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.commons.util.rbac.menu.MenuQueryChildUtil;
import cn.everlook.myweb.commons.util.treeNode.TreeSelectNode;
import cn.everlook.myweb.commons.util.treeNode.TreeSelectNodeBuilder;
import cn.everlook.myweb.commons.util.treeNode.ZTreeNode;
import cn.everlook.myweb.persistence.entity.assort.rbac.permission.CommSysPermission;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.permission.PermissionVo;
import cn.everlook.myweb.service.system.rbac.permission.ICommSysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜单管理
 *
 * @author liyqt
 * @createDate 2019/3/12
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
  
  @Autowired
  private ICommSysPermissionService permissionService;
  
  
  /**
   * 跳转到菜单界面
   */
  @RequestMapping("/toMenuManager.do")
  public String toMenuManager() {
    return "system/rbac/menu/menuManager";
  }
  
  
  //  加载左侧菜单树
  @RequestMapping("/loadMenuLeftTree.do")
  @ResponseBody
  public List<ZTreeNode> loadMenuLeftTree(PermissionVo permissionVo) {
    List<ZTreeNode> nodes = new ArrayList<>();
    //    查询所有菜单 type = menu
    permissionVo.setType(SYS_Constast.PERMISSION_TYPE_MENU);
    List<CommSysPermission> menuForList = permissionService.queryAllTreePermissionForList(permissionVo);
    for (CommSysPermission menu : menuForList) {
      Boolean isParent = menu.getParent() == 1 ? true : false;
      Boolean open = menu.getSpread() == 1 ? true : false;
      ZTreeNode node = new ZTreeNode(menu.getId(), menu.getPid(), menu.getName(), isParent, open);
      nodes.add(node);
    }
    return nodes;
  }
  
  
  /**
   * 加载菜单列表
   */
  @RequestMapping("/loadAllMenus.do")
  @ResponseBody
  public DataGridView loadAllMenus(PermissionVo permissionVo) {
    permissionVo.setType(SYS_Constast.PERMISSION_TYPE_MENU);
    //查询所有的菜单 type=menu
    DataGridView view = this.permissionService.queryAllPermissions(permissionVo);
    return view;
  }
  
  
  /**
   * 点击右边的树对菜单列表刷新
   */
  @RequestMapping("/clickTreeNodeloadAllMenus.do")
  @ResponseBody
  public DataGridView clickTreeNodeloadAllMenus(PermissionVo permissionVo) {
    DataGridView view = this.permissionService.clickTreeNodeLoadAllMenus(permissionVo);
    return view;
  }
  
  
  /**
   * 跳转到添加的页面
   */
  @RequestMapping("/toAddMenu.do")
  public String toAddMenu() {
    return "system/rbac/menu/menuAdd";
  }
  
  
  /**
   * 加载添加菜单的弹出框的菜单树
   */
  @RequestMapping("/loadMenuTreeMenus.do")
  @ResponseBody
  public List<TreeSelectNode> loadMenuTreeMenus(PermissionVo permissionVo) {
    permissionVo.setType(SYS_Constast.PERMISSION_TYPE_MENU);
    List<TreeSelectNode> treeLists = new ArrayList<>();
    //1、查询所有的菜单信息
    List<CommSysPermission> permissionForList = this.permissionService.queryAllTreePermissionForList(permissionVo);
    for (CommSysPermission permission : permissionForList) {
      Boolean open = permission.getSpread() == 1 ? true : false;
      treeLists.add(new TreeSelectNode(permission.getId(), permission.getName(), open, false, permission.getPid()));
    }
    List<TreeSelectNode> data = TreeSelectNodeBuilder.build(treeLists, 0);
    return data;
  }
  
  /**
   * 添加菜单
   */
  @RequestMapping("/addMenu.do")
  @ResponseBody
  public JsonData addMenu(PermissionVo permissionVo) {
    this.permissionService.addPermission(permissionVo);
    int maxId = permissionService.getMaxIdWithPermission(permissionVo);
    permissionVo.setId(maxId);
    return JsonData.success(permissionVo);
  }
  
  
  /**
   * 跳转到菜单修改的页面
   */
  @RequestMapping("/toUpdateMenu.do")
  public String toUpdateMenu(PermissionVo permissionVo, Model model) {
    CommSysPermission menu = this.permissionService.queryMenuById(permissionVo.getId());
    model.addAttribute("menu", menu);
    return "system/rbac/menu/menuUpdate";
  }
  
  
  /**
   * 修改菜单信息
   */
  @RequestMapping("/updateMenu.do")
  @ResponseBody
  public JsonData updateMenu(PermissionVo permissionVo) {
    if (permissionVo.getId() == 1) {
      permissionVo.setPid(0);
    }
    
    //查找所有的菜单信息
    List<CommSysPermission> MenuForList = permissionService.queryAllMenuForList(null);
    //查找需要更新的菜单下面的所有子菜单
    List<CommSysPermission> childSysMenu = MenuQueryChildUtil.treeMenuList(MenuForList, permissionVo.getId());
    for (CommSysPermission commSysMenu : childSysMenu) {
      if (permissionVo.getPid() == commSysMenu.getId()) {
        MenuQueryChildUtil.childMenu.clear();
        return JsonData.fail("待更新节点的父菜单不可为其子菜单!");
      }
    }
    
    if (permissionVo.getPid() == permissionVo.getId()) {
      MenuQueryChildUtil.childMenu.clear();
      return JsonData.fail("待更新节点的父菜单不可为其本身!");
    }
    
    this.permissionService.updateMenu(permissionVo);
    MenuQueryChildUtil.childMenu.clear();
    return JsonData.success(permissionVo);
  }
  
  
  /**
   * 删除菜单信息，根菜单是不可删除的，只能对根菜单进行修改
   * 如果一个菜单下面存在子菜单也是不可以删除的
   */
  @RequestMapping("/deleteMenu.do")
  @ResponseBody
  public JsonData deleteMenu(PermissionVo permissionVo) {
    permissionVo.setType(SYS_Constast.PERMISSION_TYPE_MENU);
    if (permissionVo.getId() == 1) {
      return JsonData.fail("根菜单不可删除!", 900);
    }
    List<CommSysPermission> list = this.permissionService.queryMenuListByDelId(permissionVo);
    if (!list.isEmpty()) {//删除的菜单有子菜单的情况
      return JsonData.fail("该菜单下有子菜单,不可删除!", 901);
    } else {//删除的菜单没有子菜单
      this.permissionService.deleteMenu(permissionVo.getId());
      return JsonData.success();
    }
  }
  
  /**
   * 批量删除菜单信息
   * 批量删除的菜单信息里面如果存在根菜单信息则不允许删除
   */
  @RequestMapping("/batchDeleteMenu.do")
  @ResponseBody
  public JsonData batchDeleteMenu(PermissionVo permissionVo) {
    Integer[] ids = permissionVo.getIds();
    if (null != ids && ids.length > 0) {
      for (Integer integer : ids) {
        if (integer == 1) {
          return JsonData.fail("选中的菜单中包含根菜单,根菜单不可删除！", 900);
        }
        CommSysPermission menu = this.permissionService.queryMenuById(integer);
        if (menu.getParent() == 1) {//此时该menu为父节点，需要查看他下面的子节点是不是都在ids里面
          List<CommSysPermission> childMenuList = this.permissionService.getChildrenMenu(menu.getId());
          List<Integer> childMenuIds = childMenuList.stream().map(menuChild -> menuChild.getId()).collect(Collectors.toList());
          List<Integer> idsList = Arrays.asList(ids);
          if (!(idsList.containsAll(childMenuIds))) {//要删除的数组里面包含了该父菜单的所有的子菜单时就可以删除该父菜单
            return JsonData.fail("菜单【" + menu.getName() + "】下包含其他子菜单,不可删除！", 901);
          }
        }
      }
      for (Integer i : ids) {
        this.permissionService.deleteMenu(i);
      }
    } else {
      return JsonData.fail("请选择需要删除的菜单!", 902);
    }
    return JsonData.success();
  }
  
  
}
