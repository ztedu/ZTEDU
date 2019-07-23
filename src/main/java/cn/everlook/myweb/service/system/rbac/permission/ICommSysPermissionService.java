package cn.everlook.myweb.service.system.rbac.permission;

import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.persistence.entity.assort.rbac.permission.CommSysPermission;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.permission.PermissionVo;

import java.util.List;

public interface ICommSysPermissionService {
  
  /**
   * 查询所有菜单
   */
  List<CommSysPermission> queryAllTreePermissionForList(PermissionVo permissionVo);
  
  /**
   * 查询当前登录人的所有菜单信息
   */
  List<CommSysPermission> queryAllTreePermissionForList(Integer id);
  
  /**
   * 查询所有的权限返回DataGridView
   */
  DataGridView queryAllPermissions(PermissionVo permissionVo);
  
  
  /**
   * 获取添加新的权限后新增的权限的id属性，为ztree的节点添加该属性
   */
  int getMaxIdWithPermission(PermissionVo permissionVo);
  
  /**
   * 点击右边的树对菜单列表刷新
   */
  DataGridView clickTreeNodeLoadAllMenus(PermissionVo permissionVo);
  
  /**
   * 点击右边的树对对应菜单的权限列表刷新
   */
  DataGridView clickTreeNodeLoadAllPermissions(PermissionVo permissionVo);
  
  
  /**
   * 查询要删除的菜单下面有没有子菜单
   */
  List<CommSysPermission> queryMenuListByDelId(PermissionVo permissionVo);
  
  
  /**
   * 删除菜单信息
   */
  void deleteMenu(Integer id);
  
  /**
   * 删除权限信息
   */
  void deletePermission(Integer id);
  
  /**
   * 根据用户Id查询权限code集合
   */
  List<String> queryPermissionByUserId(Integer userId);
  
  
  /**
   * 添加权限
   */
  void addPermission(PermissionVo permissionVo);
  
  
  /**
   * 根据权限id查询权限信息
   */
  CommSysPermission queryMenuById(Integer id);
  
  /**
   * 修改菜单信息
   */
  void updateMenu(PermissionVo permissionVo);
  
  /**
   * 修改权限信息
   */
  void updatePermission(PermissionVo permissionVo);
  
  
  /**
   * 获取指定菜单的所有的子菜单，结果是单一的模式，采用mysql函数 sql语句嵌套的形式
   */
  List<CommSysPermission> getChildrenMenu(Integer id);
  
  
  /**
   * 查询所有菜单返回
   */
  List<CommSysPermission> queryAllMenuForList(PermissionVo permissionVo);
  
  /**
   * 根据角色ID查询权限
   */
  List<CommSysPermission> queryPermissionByRoleIdForList(Integer roleId);
}
