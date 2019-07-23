package cn.everlook.myweb.persistence.dao.system.rbac.role;

import cn.everlook.myweb.persistence.entity.assort.rbac.role.CommSysRole;
import cn.everlook.myweb.persistence.entity.assort.rbac.role.CommSysRoleExample;
import org.apache.ibatis.annotations.Param;
import org.bouncycastle.util.Strings;

import java.util.List;

public interface CommSysRoleMapper {
  int countByExample(CommSysRoleExample example);
  
  int deleteByExample(CommSysRoleExample example);
  
  int deleteByPrimaryKey(Integer id);
  
  int insert(CommSysRole record);
  
  int insertSelective(CommSysRole record);
  
  List<CommSysRole> selectByExample(CommSysRoleExample example);
  
  CommSysRole selectByPrimaryKey(Integer id);
  
  int updateByExampleSelective(@Param("record") CommSysRole record, @Param("example") CommSysRoleExample example);
  
  int updateByExample(@Param("record") CommSysRole record, @Param("example") CommSysRoleExample example);
  
  int updateByPrimaryKeySelective(CommSysRole record);
  
  int updateByPrimaryKey(CommSysRole record);
  
  //根据用户id查询当前登录人的所有的角色
  List<CommSysRole> queryRolesByUserId(Integer userId);
  
  //查询全部的角色类型并展示
  List<CommSysRole> queryAllRoles(CommSysRole sysRole);
  
  //查看某个角色当前的使用人数
  Integer selectThisRoleUsingCount (CommSysRole sysRole);
  
  //查看某个角色当前的使用人数
  Integer selectThisRoleUsingCountById (Integer id);
  
  //删除原来的数据，根据roleId删除sys_role_permission里面的数据
  void deleteRolePermissionByRoleId(Integer rid);
  
  //添加角色和权限之间的关系数据
  void addRolePermission(Integer roleId,Integer perId);
  
  List<CommSysRole> loadAllPosition();
}
