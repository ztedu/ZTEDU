package cn.everlook.myweb.persistence.entity.vo.system.rbac.user;

import cn.everlook.myweb.persistence.entity.assort.rbac.user.CommSysUser;
import lombok.Data;

import java.io.Serializable;

/**
 * UserVO
 *
 * @author Administrator
 * @createDate 2019/3/1
 */

@Data
public class CommSysUserVo extends CommSysUser implements Serializable {
  private boolean rememberMe;
  private String captchaCode;
  //做批量删除使用的ids
  private Integer[] ids;
  private Integer page;
  private Integer limit;
}