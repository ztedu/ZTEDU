package cn.everlook.myweb.service.system.rbac.dept.Impl;

import cn.everlook.myweb.commons.util.BeanValidator.BeanValidator;
import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.persistence.dao.system.rbac.dept.CommSysDeptMapper;
import cn.everlook.myweb.persistence.entity.assort.rbac.dept.CommSysDept;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.dept.DeptVo;
import cn.everlook.myweb.service.system.rbac.dept.ICommSysDeptService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 此处填写说明
 *
 * @author liyqt
 * @createDate 2019/3/16
 */

@Service
public class CommSysDeptServiceImpl implements ICommSysDeptService {
  
  @Autowired
  private CommSysDeptMapper commSysDeptMapper;
  
  @Override
  public List<CommSysDept> queryAllDeptForList(DeptVo deptVo) {
    List<CommSysDept> depts = commSysDeptMapper.queryAllDept(deptVo);
    return depts;
  }
  
  @Override
  public DataGridView queryAllDepts(DeptVo deptVo) {
    Page<CommSysDept> page = PageHelper.startPage(deptVo.getPage(), deptVo.getLimit());
    List<CommSysDept> data = this.commSysDeptMapper.queryAllDept(deptVo);
    DataGridView view = new DataGridView(page.getTotal(), data);
    return view;
  }
  
  @Override
  public DataGridView clickTreeNodeloadAllDepts(DeptVo deptVo) {
    Page<CommSysDept> page = PageHelper.startPage(deptVo.getPage(), deptVo.getLimit());
//    List<CommSysDept> childDeptList = this.getNestChildDeptListById(deptVo.getId());
//    //将嵌套的数据进行拆分
//    List<CommSysDept> resList = DeptQueryChildUtil.treeListByNest(childDeptList);
    List<CommSysDept> data = this.commSysDeptMapper.getChildrenDept(deptVo.getId());
    DataGridView view = new DataGridView(page.getTotal(), data);
    return view;
  }
  
  
  @Override
  public void addDept(DeptVo deptVo) {
    BeanValidator.check(deptVo);
    this.commSysDeptMapper.insert(deptVo);
  }
  
  @Override
  public List<CommSysDept> queryAllTreeDeptForList() {
    List<CommSysDept> depts = commSysDeptMapper.queryAllTreeSelectDept();
    return depts;
  }
  
  @Override
  public CommSysDept queryDeptById(Integer id) {
    return this.commSysDeptMapper.selectByPrimaryKey(id);
  }
  
  @Override
  public void updateDept(DeptVo deptVo) {
    BeanValidator.check(deptVo);
    this.commSysDeptMapper.updateByPrimaryKeySelective(deptVo);
  }
  
  @Override
  public void deleteDept(Integer id) {
    this.commSysDeptMapper.deleteByPrimaryKey(id);
  }
  
  @Override
  public List<CommSysDept> queryDeptListByDelId(DeptVo deptVo) {
    List<CommSysDept> depts = this.commSysDeptMapper.queryDeptListByDelId(deptVo);
    return depts;
  }
  
  @Override
  public int getMaxIdWithDept(DeptVo deptVo) {
    return this.commSysDeptMapper.getMaxIdWithDept(deptVo);
  }
  
  @Override
  public List<CommSysDept> getNestChildDeptListById(Integer id) {
    return this.commSysDeptMapper.getNestChildDeptListById(id);
  }
  
  @Override
  public List<CommSysDept> getChildrenDept(Integer id) {
    List<CommSysDept> list = this.commSysDeptMapper.getChildrenDept(id);
    return list;
  }
  
  @Override
  public List<CommSysDept> getParentDepts(Integer id) {
    List<CommSysDept> list = this.commSysDeptMapper.getParentDepts(id);
    return list;
  }
}
