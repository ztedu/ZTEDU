package cn.everlook.myweb.service.system.rbac.dept;

import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.persistence.entity.assort.rbac.dept.CommSysDept;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.dept.DeptVo;

import java.util.List;

public interface ICommSysDeptService {
  
  /**
   * 查询所有部门返回
   */
  List<CommSysDept> queryAllDeptForList(DeptVo deptVo);
  
  
  /**
   * 查询所有的部门返回DataGridView
   */
  DataGridView queryAllDepts(DeptVo deptVo);
  
  /**
   * 点击右边的树对部门列表刷新
   */
  DataGridView clickTreeNodeloadAllDepts(DeptVo deptVo);
  
  
  /**
   * 添加部门
   */
  void addDept(DeptVo deptVo);
  
  /**
   * 查询所有部门返回
   */
  List<CommSysDept> queryAllTreeDeptForList();
  
  /**
   * 根据部门id查询部门信息
   */
  CommSysDept queryDeptById(Integer id);
  
  /**
   * 修改部门信息
   */
  void updateDept(DeptVo deptVo);
  
  /**
   * 删除部门信息
   */
  void deleteDept(Integer id);
  
  /**
   * 查询要删除的部门下面有没有子部门
   */
  List<CommSysDept> queryDeptListByDelId(DeptVo deptVo);
  
  /**
   * 获取添加新的部门后新增的部门的id属性，为ztree的节点添加该属性
   */
  int getMaxIdWithDept(DeptVo deptVo);
  
  /**
   * 获取指定部门的所有的子部门，结果是嵌套的形式
   *
   * @param id 需要查询的部门id
   * @return
   */
  List<CommSysDept> getNestChildDeptListById(Integer id);
  
  /**
   * 获取指定部门的所有的子部门，结果是单一的模式，采用mysql函数 sql语句嵌套的形式
   */
  List<CommSysDept> getChildrenDept(Integer id);
  
  
  /**
   * 获取指定部门的所有的父部门
   */
  List<CommSysDept> getParentDepts(Integer id);
  
}
