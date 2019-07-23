package cn.everlook.myweb.commons.util.rbac.dept;

import cn.everlook.myweb.persistence.entity.assort.rbac.dept.CommSysDept;

import java.util.ArrayList;
import java.util.List;

/**
 * 针对java集合做遍历
 *
 * @author Administrator
 * @createDate 2019/4/4
 */
public class DeptQueryChildUtil {
  //子节点数组
  public static List<CommSysDept> childDept = new ArrayList<>();
  
  /**
   * 获取某个父节点下面的所有子节点
   *
   * @param deptList 遍历的所有的部门列表
   * @param id       父级部门的id
   * @return
   */
  public static List<CommSysDept> treeDeptList(List<CommSysDept> deptList, int id) {
    for (CommSysDept dept : deptList) {
      //遍历出父id等于参数的id，add进子节点集合
      if (Integer.valueOf(dept.getPid()) == id) {
        //递归遍历下一级
        treeDeptList(deptList, Integer.valueOf(dept.getId()));
        childDept.add(dept);
      }
    }
    return childDept;
  }
  
  
  //获取的拆分后的嵌套结果集合数组
  public static List<CommSysDept> childDeptWithNest = new ArrayList<>();
  /**
   * 利用Mybatis嵌套获取一个部门下面的所有子部门结果遍历获取该
   * 父节点下面的所有子节点
   * 拆分嵌套结果集
   *
   * @param deptList 遍历的所有的部门列表
   * @return
   */
  public static List<CommSysDept> treeListByNest(List<CommSysDept> deptList) {
    for (CommSysDept dept : deptList) {
      CommSysDept commSysDept = new CommSysDept();
      commSysDept.setAvailable(dept.getAvailable());
      commSysDept.setDeptList(dept.getDeptList());
      commSysDept.setId(dept.getId());
      commSysDept.setName(dept.getName());
      commSysDept.setPid(dept.getPid());
      commSysDept.setLoc(dept.getLoc());
      commSysDept.setOrderNum(dept.getOrderNum());
      commSysDept.setParent(dept.getParent());
      commSysDept.setSpread(dept.getSpread());
      treeListByNest(commSysDept.getDeptList());
      childDeptWithNest.add(commSysDept);
    }
    return childDeptWithNest;
  }
}
