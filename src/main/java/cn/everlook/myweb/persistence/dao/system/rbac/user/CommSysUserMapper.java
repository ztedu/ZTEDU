package cn.everlook.myweb.persistence.dao.system.rbac.user;

import cn.everlook.myweb.persistence.entity.assort.rbac.user.CommSysUser;
import cn.everlook.myweb.persistence.entity.assort.rbac.user.CommSysUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CommSysUserMapper {
  int countByExample(CommSysUserExample example);
  
  int deleteByExample(CommSysUserExample example);
  
  int deleteByPrimaryKey(Integer id);
  
  int insert(CommSysUser record);
  
  int insertSelective(CommSysUser record);
  
  List<CommSysUser> selectByExample(CommSysUserExample example);
  
  CommSysUser selectByPrimaryKey(Integer id);
  
  int updateByExampleSelective(@Param("record") CommSysUser record, @Param("example") CommSysUserExample example);
  
  int updateByExample(@Param("record") CommSysUser record, @Param("example") CommSysUserExample example);
  
  int updateByPrimaryKeySelective(CommSysUser record);
  
  int updateByPrimaryKey(CommSysUser record);
  
  //根据登录名查用户角色
  CommSysUser queryUserByLoginName(String loginName);
  
  //查询所有的用户
  List<CommSysUser> queryAllUsers(CommSysUser user);
  
  //获取某一个部门下面的所有的用户
  List<CommSysUser> loadAllUserByDeptId(Integer deptId);
  
  //为用户添加角色,保存用户和角色之间的关系
  int addRolesToUser(Integer uid, Integer rid);
  
  //删除原有的用户的角色
  void deleteUserRoleByUserId(Integer uid);
  
}