package cn.everlook.myweb.commons.util.dataGridView.layuiTable;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 数据表格信息对象
 * 适配layui的table的
 *
 * @author liyqt
 * @createDate 2019/3/17
 */
@Setter
@Getter
public class DataGridView {
  private Integer code = 0;
  private String msg = "";
  private Long count;
  private List<?> data;
  
  public DataGridView() {
  
  }
  
  public DataGridView(long count, List<?> data) {
    this.count = count;
    this.data = data;
  }
}
