package cn.everlook.myweb.persistence.entity.dto.rbac.user;

import cn.everlook.myweb.persistence.entity.assort.rbac.user.CommSysUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 存储当前的用户信息
 *
 * @author liyqt
 * @createDate 2019/2/28
 */
@Setter
@Getter
@ToString
public class ActiverUser implements Serializable {
  //当前用户
  private CommSysUser currentUser;
  //当前用户的角色
  private List<String> roles;
  //当前用户的权限
  private List<String> permissions;
}
