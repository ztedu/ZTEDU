package cn.everlook.myweb.service.system.rbac.role.Impl;

import cn.everlook.myweb.commons.util.BeanValidator.BeanValidator;
import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.persistence.dao.system.rbac.role.CommSysRoleMapper;
import cn.everlook.myweb.persistence.entity.assort.rbac.role.CommSysRole;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.role.RoleVo;
import cn.everlook.myweb.service.system.rbac.role.ICommSysRoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色管理
 *
 * @author liyqt
 * @createDate 2019/3/12
 */
@Service
public class CommSysRoleServiceImpl implements ICommSysRoleService {
  @Autowired
  private CommSysRoleMapper commSysRoleMapper;
  
  @Override
  public List<String> queryRolesByUserId(Integer userId) {
    List<CommSysRole> roleList = commSysRoleMapper.queryRolesByUserId(userId);
    List<String> roles = roleList.stream().map(role -> role.getName()).collect(Collectors.toList());
    return roles;
  }
  
  @Override
  public DataGridView queryAllRoles(RoleVo roleVo) {
    Page<CommSysRole> page = PageHelper.startPage(roleVo.getPage(), roleVo.getLimit());
    List<CommSysRole> data = this.commSysRoleMapper.queryAllRoles(roleVo);
    DataGridView view = new DataGridView(page.getTotal(), data);
    return view;
  }
  
  @Override
  public void addRole(RoleVo roleVo) {
    BeanValidator.check(roleVo);
    this.commSysRoleMapper.insert(roleVo);
  }
  
  @Override
  public void updateRole(RoleVo roleVo) {
    BeanValidator.check(roleVo);
    this.commSysRoleMapper.updateByPrimaryKeySelective(roleVo);
  }
  
  @Override
  public void deleteRole(Integer id) {
    this.commSysRoleMapper.deleteByPrimaryKey(id);
  }
  
  
  @Override
  public CommSysRole queryRoleById(Integer id) {
    return this.commSysRoleMapper.selectByPrimaryKey(id);
  }
  
  @Override
  public Integer selectThisRoleUsingCount(RoleVo roleVo) {
    return this.commSysRoleMapper.selectThisRoleUsingCount(roleVo);
  }
  
  @Override
  public Integer selectThisRoleUsingCountById(Integer id) {
    return this.commSysRoleMapper.selectThisRoleUsingCountById(id);
  }
  
  @Override
  public void addRolePermissions(RoleVo roleVo) {
    Integer rid = roleVo.getId();
    Integer[] perIds = roleVo.getIds();
    //1、删除原来的数据，根据roleId删除sys_role_permission里面的数据
    this.commSysRoleMapper.deleteRolePermissionByRoleId(rid);
    //2、重新保存
    if (perIds != null && perIds.length > 0) {
      for (Integer perId : perIds) {
        this.commSysRoleMapper.addRolePermission(rid, perId);
      }
    }
  }
  
  @Override
  public List<CommSysRole> loadAllPosition() {
    List<CommSysRole> roles = this.commSysRoleMapper.loadAllPosition();
    return roles;
  }
}
