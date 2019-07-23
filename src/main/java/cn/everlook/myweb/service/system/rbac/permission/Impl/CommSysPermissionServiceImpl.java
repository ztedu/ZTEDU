package cn.everlook.myweb.service.system.rbac.permission.Impl;

import cn.everlook.myweb.commons.constast.rbac.SYS_Constast;
import cn.everlook.myweb.commons.util.BeanValidator.BeanValidator;
import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.persistence.dao.system.rbac.permission.CommSysPermissionMapper;
import cn.everlook.myweb.persistence.entity.assort.rbac.permission.CommSysPermission;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.permission.PermissionVo;
import cn.everlook.myweb.service.system.rbac.permission.ICommSysPermissionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 获取系统权限
 *
 * @author Administrator
 * @createDate 2019/3/9
 */
@Service
public class CommSysPermissionServiceImpl implements ICommSysPermissionService {
  @Autowired
  private CommSysPermissionMapper permissionMapper;
  
  
  @Override
  public List<CommSysPermission> queryAllTreePermissionForList(PermissionVo permissionVo) {
    return permissionMapper.queryAllPermissions(permissionVo);
  }
  
  @Override
  public List<CommSysPermission> queryAllTreePermissionForList(Integer id) {
    return permissionMapper.queryMenusByUserId(id);
  }
  
  
  @Override
  public DataGridView queryAllPermissions(PermissionVo permissionVo) {
    Page<CommSysPermission> page = PageHelper.startPage(permissionVo.getPage(), permissionVo.getLimit());
    List<CommSysPermission> data = this.permissionMapper.queryAllPermissions(permissionVo);
    DataGridView view = new DataGridView(page.getTotal(), data);
    return view;
  }
  
  @Override
  public DataGridView clickTreeNodeLoadAllMenus(PermissionVo permissionVo) {
    Page<CommSysPermission> page = PageHelper.startPage(permissionVo.getPage(), permissionVo.getLimit());
    List<CommSysPermission> data = this.permissionMapper.getChildrenMenu(permissionVo.getId());
    DataGridView view = new DataGridView(page.getTotal(), data);
    return view;
  }
  
  @Override
  public DataGridView clickTreeNodeLoadAllPermissions(PermissionVo permissionVo) {
    permissionVo.setType(SYS_Constast.PERMISSION_TYPE_PERMISSION);
    Page<CommSysPermission> page = PageHelper.startPage(permissionVo.getPage(), permissionVo.getLimit());
    List<CommSysPermission> data = this.permissionMapper.getChildrenPermission(permissionVo);
    DataGridView view = new DataGridView(page.getTotal(), data);
    return view;
  }
  
  @Override
  public void addPermission(PermissionVo permissionVo) {
    BeanValidator.check(permissionVo);
    this.permissionMapper.insert(permissionVo);
  }
  
  
  @Override
  public List<String> queryPermissionByUserId(Integer userId) {
    List<CommSysPermission> list = permissionMapper.queryPermissionByUserId(userId);
    List<String> codes = list.stream().map(permission -> permission.getPercode()).collect(Collectors.toList());
    return codes;
  }
  
  
  @Override
  public CommSysPermission queryMenuById(Integer id) {
    return this.permissionMapper.selectByPrimaryKey(id);
  }
  
  @Override
  public void updateMenu(PermissionVo permissionVo) {
    BeanValidator.check(permissionVo);
    this.permissionMapper.updateByPrimaryKeySelective(permissionVo);
  }
  
  @Override
  public void updatePermission(PermissionVo permissionVo) {
    BeanValidator.check(permissionVo);
    this.permissionMapper.updateByPrimaryKeySelective(permissionVo);
  }
  
  @Override
  public void deleteMenu(Integer id) {
    this.permissionMapper.deleteByPrimaryKey(id);
  }
  
  @Override
  public void deletePermission(Integer id) {
    this.permissionMapper.deleteByPrimaryKey(id);
  }
  
  
  @Override
  public List<CommSysPermission> queryMenuListByDelId(PermissionVo permissionVo) {
    List<CommSysPermission> menus = this.permissionMapper.queryMenuListByDelId(permissionVo);
    return menus;
  }
  
  @Override
  public int getMaxIdWithPermission(PermissionVo permissionVo) {
    return this.permissionMapper.getMaxIdWithMenu(permissionVo);
  }
  
  
  @Override
  public List<CommSysPermission> getChildrenMenu(Integer id) {
    return this.permissionMapper.getChildrenMenu(id);
  }
  
  @Override
  public List<CommSysPermission> queryAllMenuForList(PermissionVo permissionVo) {
    return permissionMapper.queryAllPermissions(permissionVo);
  }
  
  
  @Override
  public List<CommSysPermission> queryPermissionByRoleIdForList(Integer roleId) {
    return this.permissionMapper.queryPermissionByRoleIdForList(roleId);
  }
}
