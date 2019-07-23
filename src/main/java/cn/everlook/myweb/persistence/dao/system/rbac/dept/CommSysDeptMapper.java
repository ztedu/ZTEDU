package cn.everlook.myweb.persistence.dao.system.rbac.dept;

import cn.everlook.myweb.persistence.entity.assort.rbac.dept.CommSysDept;
import cn.everlook.myweb.persistence.entity.assort.rbac.dept.CommSysDeptExample;

import java.util.List;

import cn.everlook.myweb.persistence.entity.vo.system.rbac.dept.DeptVo;
import org.apache.ibatis.annotations.Param;

public interface CommSysDeptMapper {
  int countByExample(CommSysDeptExample example);
  
  int deleteByExample(CommSysDeptExample example);
  
  int deleteByPrimaryKey(Integer id);
  
  int insert(CommSysDept record);
  
  int insertSelective(CommSysDept record);
  
  List<CommSysDept> selectByExample(CommSysDeptExample example);
  
  CommSysDept selectByPrimaryKey(Integer id);
  
  int updateByExampleSelective(@Param("record") CommSysDept record, @Param("example") CommSysDeptExample example);
  
  int updateByExample(@Param("record") CommSysDept record, @Param("example") CommSysDeptExample example);
  
  int updateByPrimaryKeySelective(CommSysDept record);
  
  int updateByPrimaryKey(CommSysDept record);
  
  //部门全查询
  List<CommSysDept> queryAllDept(DeptVo deptVo);
  
  //部门全查询
  List<CommSysDept> queryAllTreeSelectDept();
  
  //根据要删除的部门的id查询该部门下面的子部门
  List<CommSysDept> queryDeptListByDelId(DeptVo deptVo);
  
  //getMaxIdWithDept
  int getMaxIdWithDept(DeptVo deptVo);
  
  //查询某一个节点的子节点，结果为嵌套的形式
  List<CommSysDept> getNestChildDeptListById(Integer id);
  
  
  //mysql利用函数查询一个父节点下面的所有的子节点信息（结果为单一的模式，不是嵌套的）
  List<CommSysDept> getChildrenDept(Integer id);
  
  
  //查询一个部门下面的所有的父级部门
  List<CommSysDept> getParentDepts(Integer id);
  

}