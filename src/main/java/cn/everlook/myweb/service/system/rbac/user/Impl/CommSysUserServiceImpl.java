package cn.everlook.myweb.service.system.rbac.user.Impl;

import cn.everlook.myweb.commons.constast.rbac.SYS_Constast;
import cn.everlook.myweb.commons.util.BeanValidator.BeanValidator;
import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.commons.util.password.EncodePasswordUtil;
import cn.everlook.myweb.commons.util.password.PasswordUtil;
import cn.everlook.myweb.persistence.dao.system.rbac.role.CommSysRoleMapper;
import cn.everlook.myweb.persistence.dao.system.rbac.user.CommSysUserMapper;
import cn.everlook.myweb.persistence.entity.assort.rbac.dept.CommSysDept;
import cn.everlook.myweb.persistence.entity.assort.rbac.role.CommSysRole;
import cn.everlook.myweb.persistence.entity.assort.rbac.user.CommSysUser;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.role.RoleVo;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.user.CommSysUserVo;
import cn.everlook.myweb.service.system.rbac.user.ICommSysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据登录名获取相应的用户
 *
 * @author Administrator
 * @createDate 2019/3/1
 */
@Service
public class CommSysUserServiceImpl implements ICommSysUserService {
  @Autowired
  private CommSysUserMapper commSysUserMapper;
  
  @Autowired
  private CommSysRoleMapper roleMapper;
  
  @Override
  public CommSysUser queryUserByLoginName(String loginName) {
    return commSysUserMapper.queryUserByLoginName(loginName);
  }
  
  @Override
  public DataGridView queryAllUsers(CommSysUserVo userVo) {
    Page<CommSysUser> page = PageHelper.startPage(userVo.getPage(), userVo.getLimit());
    List<CommSysUser> data = this.commSysUserMapper.queryAllUsers(userVo);
    DataGridView view = new DataGridView(page.getTotal(), data);
    return view;
  }
  
  
  @Override
  public DataGridView clickTreeNodeloadAllUsers(CommSysUserVo userVo) {
    Page<CommSysUser> page = PageHelper.startPage(userVo.getPage(), userVo.getLimit());
    List<CommSysUser> data = this.commSysUserMapper.queryAllUsers(userVo);
    DataGridView view = new DataGridView(page.getTotal(), data);
    return view;
  }
  
  @Override
  public List<CommSysUser> loadAllUserByDeptId(Integer deptId) {
    return this.commSysUserMapper.loadAllUserByDeptId(deptId);
  }
  
  @Override
  public void addUser(CommSysUserVo userVo) {
    BeanValidator.check(userVo);
    if (userVo.getLoginName() != null && userVo.getLoginName().length() > 0) {
      userVo.setPwd(EncodePasswordUtil.encodePassword(SYS_Constast.SHA256, "123456", userVo.getLoginName(), 1024));
    }
    this.commSysUserMapper.insert(userVo);
  }
  
  @Override
  public CommSysUser queryUserById(Integer id) {
    return this.commSysUserMapper.selectByPrimaryKey(id);
  }
  
  @Override
  public void updateUser(CommSysUserVo userVo) {
    BeanValidator.check(userVo);
    if (userVo.getLoginName() != null && userVo.getLoginName().length() > 0) {
      userVo.setPwd(EncodePasswordUtil.encodePassword(SYS_Constast.SHA256, "123456", userVo.getLoginName(), 1024));
    }
    this.commSysUserMapper.updateByPrimaryKeySelective(userVo);
  }
  
  @Override
  public void deleteUserByUserId(Integer id) {
    this.commSysUserMapper.deleteByPrimaryKey(id);
  }
  
  @Override
  public void addRolesToUser(CommSysUserVo userVo) {
    Integer uid = userVo.getId();
    Integer[] rids = userVo.getIds();
    //1、删除原有的用户的角色
    this.commSysUserMapper.deleteUserRoleByUserId(uid);
    //2、重新分配
    if (rids != null && rids.length > 0) {
      for (Integer rid : rids) {
        this.commSysUserMapper.addRolesToUser(uid, rid);
      }
    }
  }
  
  @Override
  public DataGridView loadAllUserRoles(CommSysUserVo userVo) {
    //1、查询所有的可用角色
    CommSysRole role = new CommSysRole();
    role.setAvailable(SYS_Constast.AVAILABLE_YES);
    List<CommSysRole> allAvailableRoles = roleMapper.queryAllRoles(role);
    //2、根据用户ID查询当前用户拥有的角色
    List<CommSysRole> userRoles = roleMapper.queryRolesByUserId(userVo.getId());
    //3、封装对应的LAY_CHECKED
    List<RoleVo> roles = new ArrayList<>();
    for (CommSysRole arole : allAvailableRoles){
      Boolean LAY_CHECK = false;
      for (CommSysRole urole : userRoles){
        if (arole.getId() == urole.getId()){
          LAY_CHECK = true;
        }
      }
      RoleVo roleVo = new RoleVo();
      //copy属性
      BeanUtils.copyProperties(arole,roleVo);
      roleVo.setLAY_CHECKED(LAY_CHECK);
      roles.add(roleVo);
    }
    return new DataGridView(Long.valueOf(allAvailableRoles.size()),roles);
  }
  
  @Override
  public DataGridView loadAllSelectUserRoles(CommSysUserVo userVo) {
    //1、查询搜索的可用角色
    CommSysRole role = new CommSysRole();
    role.setAvailable(SYS_Constast.AVAILABLE_YES);
    role.setName(userVo.getName());
    List<CommSysRole> allAvailableRoles = roleMapper.queryAllRoles(role);
    //2、根据用户ID查询当前用户拥有的角色
    List<CommSysRole> userRoles = roleMapper.queryRolesByUserId(userVo.getId());
    //3、封装对应的LAY_CHECKED
    List<RoleVo> roles = new ArrayList<>();
    for (CommSysRole arole : allAvailableRoles){
      Boolean LAY_CHECK = false;
      for (CommSysRole urole : userRoles){
        if (arole.getId() == urole.getId()){
          LAY_CHECK = true;
        }
      }
      RoleVo roleVo = new RoleVo();
      //copy属性
      BeanUtils.copyProperties(arole,roleVo);
      roleVo.setLAY_CHECKED(LAY_CHECK);
      roles.add(roleVo);
    }
    return new DataGridView(Long.valueOf(allAvailableRoles.size()),roles);
  }
}
