package cn.everlook.myweb.service.system.rbac.role;

import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.persistence.entity.assort.rbac.role.CommSysRole;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.dept.DeptVo;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.role.RoleVo;

import java.util.List;


public interface ICommSysRoleService {
  
  //根据用户Id查询当前用户的角色
  List<String> queryRolesByUserId(Integer userId);
  
  /**
   * 查询所有的角色返回DataGridView
   */
  DataGridView queryAllRoles(RoleVo roleVo);
  
  
  /**
   * 添加角色
   */
  void addRole(RoleVo roleVo);
  
  
  /**
   * 修改部门信息
   */
  void updateRole(RoleVo roleVo);
  
  /**
   * 删除部门信息
   */
  void deleteRole(Integer id);
  
  /**
   * 根据角色id查询角色信息
   */
  CommSysRole queryRoleById(Integer id);
  
  
  /**
   * 获取对应角色已使用的情况
   */
  Integer selectThisRoleUsingCount(RoleVo roleVo);
  
  
  /**
   * 获取对应角色已使用的情况
   */
  Integer selectThisRoleUsingCountById(Integer id);
  
  /**
   * 保存角色和权限之间的关系
   */
  void addRolePermissions(RoleVo roleVo);
  
  /**
   * 查找所有的角色
   */
  List<CommSysRole> loadAllPosition();
}
