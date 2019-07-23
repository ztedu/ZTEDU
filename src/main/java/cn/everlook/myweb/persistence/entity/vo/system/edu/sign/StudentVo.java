package cn.everlook.myweb.persistence.entity.vo.system.edu.sign;

import cn.everlook.myweb.persistence.entity.assort.edu.registration.ZtStudent;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 学员信息填写
 *
 * @author liyqt
 * @createDate 2019/6/11
 */
@Setter
@Getter
public class StudentVo extends ZtStudent {
  //做批量删除使用的ids
  private Integer[] ids;
  private Integer page;
  private Integer limit;
}
