package cn.everlook.myweb.persistence.dao.system.rbac.permission;

import cn.everlook.myweb.persistence.entity.assort.rbac.permission.CommSysPermission;
import cn.everlook.myweb.persistence.entity.assort.rbac.permission.CommSysPermissionExample;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.permission.PermissionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommSysPermissionMapper {
  int countByExample(CommSysPermissionExample example);
  
  int deleteByExample(CommSysPermissionExample example);
  
  int deleteByPrimaryKey(Integer id);
  
  int insert(CommSysPermission record);
  
  int insertSelective(CommSysPermission record);
  
  List<CommSysPermission> selectByExample(CommSysPermissionExample example);
  
  CommSysPermission selectByPrimaryKey(Integer id);
  
  int updateByExampleSelective(@Param("record") CommSysPermission record, @Param("example") CommSysPermissionExample example);
  
  int updateByExample(@Param("record") CommSysPermission record, @Param("example") CommSysPermissionExample example);
  
  int updateByPrimaryKeySelective(CommSysPermission record);
  
  int updateByPrimaryKey(CommSysPermission record);
  
  //全查询
  List<CommSysPermission> queryAllPermissions(CommSysPermission permission);
  
  //根据用户id查询该用户对应的菜单
  List<CommSysPermission> queryMenusByUserId(Integer id);
  
  //根据用户名查询该用户的权限
  List<CommSysPermission> queryPermissionByUserId(Integer userId);
  
  //getMaxIdWithDept
  int getMaxIdWithMenu(PermissionVo permissionVo);
  
  //mysql利用函数查询一个父节点下面的所有的子节点信息（结果为单一的模式，不是嵌套的）
  List<CommSysPermission> getChildrenMenu(Integer id);
  
  List<CommSysPermission> queryMenuListByDelId(CommSysPermission permission);
  
  //mysql利用函数查询一个父节点下面的所有的权限节点信息（结果为单一的模式，不是嵌套的）
//  List<CommSysPermission> getChildrenPermission(Integer id);
  List<CommSysPermission> getChildrenPermission(CommSysPermission permission);
  
  //根据角色Id查询已分配的权限
  List<CommSysPermission> queryPermissionByRoleIdForList(Integer roleId);
}