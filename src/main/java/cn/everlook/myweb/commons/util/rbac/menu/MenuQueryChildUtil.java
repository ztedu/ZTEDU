package cn.everlook.myweb.commons.util.rbac.menu;

import cn.everlook.myweb.persistence.entity.assort.rbac.permission.CommSysPermission;

import java.util.ArrayList;
import java.util.List;

/**
 * 针对java集合做遍历
 *
 * @author liyqt
 * @createDate 2019/5/1
 */
public class MenuQueryChildUtil {
  //子节点数组
  public static List<CommSysPermission> childMenu = new ArrayList<>();
  
  /**
   * 获取某个父节点下面的所有子节点
   *
   * @param menuList 遍历的所有的菜单列表
   * @param id       父级部门的id
   * @return
   */
  public static List<CommSysPermission> treeMenuList(List<CommSysPermission> menuList, int id) {
    for (CommSysPermission menu : menuList) {
      //遍历出父id等于参数的id，add进子节点集合
      if (Integer.valueOf(menu.getPid()) == id) {
        //递归遍历下一级
        treeMenuList(menuList, Integer.valueOf(menu.getId()));
        childMenu.add(menu);
      }
    }
    return childMenu;
  }
  
  
}
