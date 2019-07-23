package cn.everlook.myweb.persistence.entity.vo.system.rbac.permission;


import cn.everlook.myweb.persistence.entity.assort.rbac.permission.CommSysPermission;
import lombok.Getter;
import lombok.Setter;

/**
 * 权限Vo
 *
 * @author Administrator
 * @createDate 2019/3/9
 */
@Setter
@Getter
public class PermissionVo extends CommSysPermission {
  //做批量删除使用的ids
  private Integer[] ids;
  private Integer page;
  private Integer limit;
}
