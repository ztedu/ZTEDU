package cn.everlook.myweb.commons.beans;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

/**
 * 分页查询Beans
 *
 * @author liyqt
 * @createDate 2018/11/12
 */
public class PageQuery {
  
  @Getter
  @Setter
  @Min(value = 1, message = "当前页码不合法")
  private int pageNo = 1;
  
  @Getter
  @Setter
  @Min(value = 1, message = "每页展示数量不合法")
  private int pageSize = 10;
  
  @Setter
  private int offset;
  public int getOffset() {
    return (pageNo - 1) * pageSize;
  }
}
