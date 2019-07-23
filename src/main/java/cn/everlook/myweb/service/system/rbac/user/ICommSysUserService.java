package cn.everlook.myweb.service.system.rbac.user;

import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.persistence.entity.assort.rbac.user.CommSysUser;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.user.CommSysUserVo;

import java.util.List;

public interface ICommSysUserService {
  
  //查询用户信息
  CommSysUser queryUserByLoginName(String loginName);
  
  /**
   * 查询所有用户返回
   */
//  List<CommSysUser> queryAllUsersForList(CommSysUserVo commSysUserVo);
  
  
  /**
   * 查询所有用户返回DataGridView
   */
  DataGridView queryAllUsers(CommSysUserVo userVo);
  
  /**
   * 查询当前可用的角色并选中已拥有的角色
   *
   * @param userVo
   * @return
   */
  DataGridView loadAllUserRoles(CommSysUserVo userVo);
  
  /**
   * 查询当前搜索的角色并选中已拥有的角色
   *
   * @param userVo
   * @return
   */
  DataGridView loadAllSelectUserRoles(CommSysUserVo userVo);
  
  
  
  
  /**
   * 点击右边的树对用户列表刷新
   */
  DataGridView clickTreeNodeloadAllUsers(CommSysUserVo userVo);
  
  /**
   * 查找选中部门下的用户
   */
  List<CommSysUser> loadAllUserByDeptId(Integer deptId);
  
  
  /**
   * 添加用户
   */
  void addUser(CommSysUserVo userVo);
  
  /**
   * 查找用户信息
   */
  CommSysUser queryUserById(Integer id);
  
  
  /**
   * 修改用户信息
   */
  void updateUser(CommSysUserVo userVo);
  
  
  /**
   * 删除用户信息
   */
  void deleteUserByUserId(Integer id);
  
  
  /**
   * 为用户添加角色
   */
  void addRolesToUser(CommSysUserVo userVo);
  
  
}
