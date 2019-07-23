package cn.everlook.myweb.persistence.entity.vo.system.rbac.dept;

import cn.everlook.myweb.persistence.entity.assort.rbac.dept.CommSysDept;
import lombok.Getter;
import lombok.Setter;

/**
 * 部门Vo
 *
 * @author liyqt
 * @createDate 2019/3/16
 */

@Setter
@Getter
public class DeptVo extends CommSysDept {
  //做批量删除使用的ids
  private Integer[] ids;
  private Integer page;
  private Integer limit;
}
