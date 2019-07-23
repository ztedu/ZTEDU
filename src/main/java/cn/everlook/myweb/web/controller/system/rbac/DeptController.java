package cn.everlook.myweb.web.controller.system.rbac;

import cn.everlook.myweb.annotation.log.SystemControllerLog;
import cn.everlook.myweb.commons.common.JsonData;
import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.commons.util.rbac.dept.DeptQueryChildUtil;
import cn.everlook.myweb.commons.util.treeNode.TreeSelectNode;
import cn.everlook.myweb.commons.util.treeNode.TreeSelectNodeBuilder;
import cn.everlook.myweb.commons.util.treeNode.ZTreeNode;
import cn.everlook.myweb.persistence.entity.assort.rbac.dept.CommSysDept;
import cn.everlook.myweb.persistence.entity.vo.system.rbac.dept.DeptVo;
import cn.everlook.myweb.service.system.rbac.dept.Impl.CommSysDeptServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 部门管理
 *
 * @author liyqt
 * @createDate 2019/3/12
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
  
  @Autowired
  private CommSysDeptServiceImpl commSysDeptService;
  
  
  /**
   * 跳转到部门界面
   */
  @RequestMapping("/toDeptManager.do")
  @RequiresPermissions("dept:list")
  public String toDeptManager() {
    return "system/rbac/dept/deptManager";
  }
  
  
  //  加载左侧部门树
  @RequestMapping("/loadDeptLeftTree.do")
  @ResponseBody
  public List<ZTreeNode> loadDeptLeftTree(DeptVo deptVo) {
    List<ZTreeNode> nodes = new ArrayList<>();
    //    查询所有部门
    List<CommSysDept> deptForList = commSysDeptService.queryAllDeptForList(deptVo);
    for (CommSysDept dept : deptForList) {
      Boolean isParent = dept.getParent() == 1 ? true : false;
      Boolean open = dept.getSpread() == 1 ? true : false;
      ZTreeNode node = new ZTreeNode(dept.getId(), dept.getPid(), dept.getName(), isParent, open);
      nodes.add(node);
    }
    return nodes;
  }
  
  /**
   * 加载部门列表
   */
  @SystemControllerLog(description = "加载部门")
  @RequestMapping("/loadAllDepts.do")
  @ResponseBody
  public DataGridView loadAllDepts(DeptVo deptVo) {
    DataGridView view = this.commSysDeptService.queryAllDepts(deptVo);
    return view;
  }
  
  
  /**
   * 点击右边的树对部门列表刷新
   */
  @RequestMapping("/clickTreeNodeloadAllDepts.do")
  @ResponseBody
  public DataGridView clickTreeNodeloadAllDepts(DeptVo deptVo) {
    DataGridView view = this.commSysDeptService.clickTreeNodeloadAllDepts(deptVo);
    return view;
  }
  
  
  /**
   * 跳转到添加的页面
   */
  @RequestMapping("/toAddDept.do")
  public String toAddDept() {
    return "system/rbac/dept/deptAdd";
  }
  
  /**
   * 添加部门
   */
  @RequestMapping("/addDept.do")
  @ResponseBody
  public JsonData addDept(DeptVo deptVo) {
    this.commSysDeptService.addDept(deptVo);
    int maxId = commSysDeptService.getMaxIdWithDept(deptVo);
    deptVo.setId(maxId);
    return JsonData.success(deptVo);
  }

  /*
  public Map<String, Object> addDept(DeptVo deptVo) {
    Map<String, Object> map = new HashMap<>();
    String msg = "添加成功";
    try {
      //添加
      this.commSysDeptService.addDept(deptVo);
    } catch (Exception e) {
      msg = "添加失败" + e.getMessage();
    }
    map.put("msg", msg);
    return map;
  }
  */
  
  
  /**
   * 加载添加部门菜单的弹出框的部门树
   */
  @RequestMapping("/loadDeptTreeMenus.do")
  @ResponseBody
  public List<TreeSelectNode> loadDeptTreeMenus() {
    List<TreeSelectNode> treeLists = new ArrayList<>();
    //1、查询所有的部门信息
    List<CommSysDept> deptForList = this.commSysDeptService.queryAllTreeDeptForList();
    for (CommSysDept dept : deptForList) {
      Boolean open = dept.getSpread() == 1 ? true : false;
      treeLists.add(new TreeSelectNode(dept.getId(), dept.getName(), open, false, dept.getPid()));
    }
    
    List<TreeSelectNode> data = TreeSelectNodeBuilder.build(treeLists, 0);
    return data;
  }
  
  
  /**
   * 跳转到部门修改的页面
   */
  @RequestMapping("/toUpdateDept.do")
  public String toUpdateDept(DeptVo deptVo, Model model) {
    CommSysDept dept = this.commSysDeptService.queryDeptById(deptVo.getId());
    model.addAttribute("dept", dept);
    return "system/rbac/dept/deptUpdate";
  }
  
  
  /**
   * 修改部门信息
   */
  @RequestMapping("/updateDept.do")
  @ResponseBody
  public JsonData updateDept(DeptVo deptVo) {
    if (deptVo.getId() == 1) {
      deptVo.setPid(0);
    }
    
    //查找所有的部门信息
    List<CommSysDept> deptForList = commSysDeptService.queryAllDeptForList(null);
    //查找需要更新的部门下面的所有子部门
    List<CommSysDept> childSysDept = DeptQueryChildUtil.treeDeptList(deptForList, deptVo.getId());
    for (CommSysDept commSysDept : childSysDept) {
      if (deptVo.getPid() == commSysDept.getId()) {
        DeptQueryChildUtil.childDept.clear();
        return JsonData.fail("待更新节点的父部门不可为其子部门!");
      }
    }
    
    if (deptVo.getPid() == deptVo.getId()) {
      DeptQueryChildUtil.childDept.clear();
      return JsonData.fail("待更新节点的父部门不可为其本身!");
    }
    
    this.commSysDeptService.updateDept(deptVo);
    DeptQueryChildUtil.childDept.clear();
    return JsonData.success(deptVo);
  }
  
  /**
   * 删除用户信息，根部门是不可删除的，只能对根部门进行修改
   * 如果一个部门下面存在子部门也是不可以删除的
   */
  @RequestMapping("/deleteDept.do")
  @ResponseBody
  public JsonData deleteDept(DeptVo deptVo) {
    if (deptVo.getId() == 1) {
      return JsonData.fail("根部门不可删除!", 900);
    }
    List<CommSysDept> list = this.commSysDeptService.queryDeptListByDelId(deptVo);
    if (!list.isEmpty()) {//删除的部门有子部门的情况
      return JsonData.fail("该部门下有子部门,不可删除!", 901);
    } else {//删除的部门没有子部门
      this.commSysDeptService.deleteDept(deptVo.getId());
      return JsonData.success();
    }
  }
  
  /**
   * 批量删除部门信息
   * 批量删除的部门信息里面如果存在根部门信息则不允许删除
   */
  @RequestMapping("/batchDeleteDept.do")
  @ResponseBody
  public JsonData batchDeleteDept(DeptVo deptVo) {
    Integer[] ids = deptVo.getIds();
    if (null != ids && ids.length > 0) {
      for (Integer integer : ids) {
        if (integer == 1) {
          return JsonData.fail("选中的部门中包含根部门,根部门不可删除！", 900);
        }
        CommSysDept dept = this.commSysDeptService.queryDeptById(integer);
        if (dept.getParent() == 1) {//此时该dept为父节点，需要查看他下面的子节点是不是都在ids里面
          List<CommSysDept> childDeptList = this.commSysDeptService.getChildrenDept(dept.getId());
          List<Integer> childDeptIds = childDeptList.stream().map(deptChild -> deptChild.getId()).collect(Collectors.toList());
          List<Integer> idsList = Arrays.asList(ids);
          if (!(idsList.containsAll(childDeptIds))) {//要删除的数组里面包含了该父部门的所有的子部门时就可以删除该父部门
            return JsonData.fail("部门【" + dept.getName() + "】下包含其他子部门,不可删除！", 901);
          }
        }
      }
      for (Integer i : ids) {
        this.commSysDeptService.deleteDept(i);
      }
    } else {
      return JsonData.fail("请选择需要删除的部门!", 902);
    }
    return JsonData.success();
  }
  
  
  //扩展
  
  /**
   * 获取指定的部门下面的所有的子部门信息,结果为嵌套的模式
   */
  @RequestMapping("/getChildDeptList.do")
  @ResponseBody
  public JsonData getChildDeptList(DeptVo deptVo) {
    List<CommSysDept> childDeptList = this.commSysDeptService.getNestChildDeptListById(deptVo.getId());
    //将嵌套的数据进行拆分
    List<CommSysDept> resList = DeptQueryChildUtil.treeListByNest(childDeptList);
    System.out.println("treeListByNest" + resList);
    DeptQueryChildUtil.childDeptWithNest.clear();
    return JsonData.success();
  }
  
  /**
   * 获取指定的部门下面的所有的子部门信息，结果为单一的结果集
   */
  @RequestMapping("/getChildrenDept.do")
  @ResponseBody
  public JsonData getChildrenDept(DeptVo deptVo) {
    List<CommSysDept> childDeptList = this.commSysDeptService.getChildrenDept(deptVo.getId());
    System.out.println("getChildrenDept" + childDeptList);
    return JsonData.success();
  }
  
  
  /**
   * 获取指定的部门下面的所有的父部门信息，结果为单一的结果集
   */
  @RequestMapping("/getParentDepts.do")
  @ResponseBody
  public JsonData getParentDepts(DeptVo deptVo) {
    List<CommSysDept> parentDeptList = this.commSysDeptService.getParentDepts(deptVo.getId());
    System.out.println("getParentDepts" + parentDeptList);
    return JsonData.success();
  }
  
}
