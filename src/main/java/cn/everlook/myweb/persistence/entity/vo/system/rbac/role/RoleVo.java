package cn.everlook.myweb.persistence.entity.vo.system.rbac.role;

import cn.everlook.myweb.commons.common.JsonData;
import cn.everlook.myweb.persistence.entity.assort.rbac.role.CommSysRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * RoleVo
 *
 * @author liyqt
 * @createDate 2019/7/4
 */
@Setter
@Getter
public class RoleVo extends CommSysRole {
  
  
  @JsonProperty("LAY_CHECKED")
  private Boolean LAY_CHECKED = false;
  
  //做批量删除和分配权限用使用的ids
  private Integer[] ids;
  private Integer page;
  private Integer limit;
}
