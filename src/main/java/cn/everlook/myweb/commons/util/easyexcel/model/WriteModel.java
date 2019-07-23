package cn.everlook.myweb.commons.util.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class WriteModel extends BaseRowModel {
  
  @ExcelProperty(value = {"表头1", "表头1", "表头31"}, index = 0)
  protected String p1;
  
  @ExcelProperty(value = {"表头1", "表头1", "表头32"}, index = 1)
  protected String p2;
  
  @ExcelProperty(value = {"表头3", "表头3", "表头3"}, index = 2)
  private int p3;
  
  @ExcelProperty(value = {"表头1", "表头4", "表头4"}, index = 3)
  private long p4;
  
  @ExcelProperty(value = {"表头5", "表头51", "表头52"}, index = 4)
  private String p5;
  
  @ExcelProperty(value = {"表头6", "表头61", "表头611"}, index = 5)
  private float p6;
  
  @ExcelProperty(value = {"表头6", "表头61", "表头612"}, index = 6)
  private BigDecimal p7;
  
  @ExcelProperty(value = {"表头6", "表头62", "表头621"}, index = 7)
  private Date p8;
  
  @ExcelProperty(value = {"表头6", "表头62", "表头622"}, index = 8)
  private String p9;
  
  @ExcelProperty(value = {"表头6", "表头62", "表头622"}, index = 9)
  private double p10;
  
  @Override
  public String toString() {
    return "JavaModel1{" +
        "p1='" + p1 + '\'' +
        ", p2='" + p2 + '\'' +
        ", p3=" + p3 +
        ", p4=" + p4 +
        ", p5='" + p5 + '\'' +
        ", p6=" + p6 +
        ", p7=" + p7 +
        ", p8=" + p8 +
        ", p9='" + p9 + '\'' +
        ", p10=" + p10 +
        '}';
  }
}
