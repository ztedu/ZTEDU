package excel;

import cn.everlook.myweb.commons.util.easyexcel.DataUtil;
import cn.everlook.myweb.commons.util.easyexcel.ExcelListener;
import cn.everlook.myweb.commons.util.easyexcel.FileUtil;
import cn.everlook.myweb.commons.util.easyexcel.model.WriteModel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.*;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * 此处填写说明
 *
 * @author Administrator
 * @createDate 2019/5/14
 */
public class easyExcelTest {
  
  /********************************  读Excel  ********************************/
  
  /**
   * 03、07版本excel读数据量少于1千行数据，内部采用回调方法.
   *
   * @throws IOException 简单抛出异常，真实环境需要catch异常,同时在finally中关闭流
   */
  @Test
  public void simpleReadWithoutEntity() throws IOException {
    InputStream inputStream = new FileInputStream("writeWithEntityHead.xlsx");
//    InputStream inputStream = FileUtil.getResourcesFileInputStream("writeWithEntityHead.xlsx");
    try {
      List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 1));
      System.err.println(data);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        inputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  /**
   * 03、07版本excel读数据量少于1千行数据自动转成javamodel，内部采用回调方法.
   *
   * @throws IOException 简单抛出异常，真实环境需要catch异常,同时在finally中关闭流
   */
  @Test
  public void simpleReadWithEntity() throws IOException {
    InputStream inputStream = new FileInputStream("writeWithEntityHead.xlsx");
    try {
      List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 1, ExcelPropertyIndexModel.class));
      System.err.println(data);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        inputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  /**
   * 03版、07版本excel读数据量大于1千行，内部采用回调方法.
   * 返回 List<Object>
   *
   * @throws IOException 简单抛出异常，真实环境需要catch异常,同时在finally中关闭流
   */
  @Test
  public void readWithoutEntity() throws IOException {
    InputStream inputStream = new FileInputStream("writeWithEntityHead.xlsx");
    try {
      // 解析每行结果在listener中处理
      ExcelListener listener = new ExcelListener();
      EasyExcelFactory.readBySax(inputStream, new Sheet(1, 1), listener);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        inputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  /**
   * 03、07版本excel读数据量大于1千行，内部采用回调方法.
   * 数据返回List<? extend BaseRowModel>
   *
   * @throws IOException 简单抛出异常，真实环境需要catch异常,同时在finally中关闭流
   */
  @Test
  public void readWithEntity() throws Exception {
    InputStream inputStream = new FileInputStream("writeWithEntityHead.xlsx");
    try {
      AnalysisEventListener<ExcelPropertyIndexModel> listener = new AnalysisEventListener<ExcelPropertyIndexModel>() {
        
        @Override
        public void invoke(ExcelPropertyIndexModel object, AnalysisContext context) {
          System.out.println("Row:" + context.getCurrentRowNum() + " Data:" + object);
        }
        
        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
          System.out.println("doAfterAllAnalysed...");
        }
      };
      //第二个参数为表头行数，按照实际设置
      EasyExcelFactory.readBySax(inputStream, new Sheet(1, 1, ExcelPropertyIndexModel.class), listener);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        inputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  
  /**
   * 03、07版本excel读取sheet
   *
   * @throws IOException 简单抛出异常，真实环境需要catch异常,同时在finally中关闭流
   */
  @Test
  public void saxReadSheets() throws IOException {
    InputStream inputStream = new FileInputStream("writeWithEntityHead.xlsx");
    ExcelListener excelListener = new ExcelListener();
    ExcelReader excelReader = EasyExcelFactory.getReader(inputStream, excelListener);
    List<Sheet> sheets = excelReader.getSheets();
    System.out.println("sheet信息---------->>>>>>>>>>" + sheets);
    System.out.println();
    for (Sheet sheet : sheets) {
      if (sheet.getSheetNo() == 1) {
        sheet.setHeadLineMun(1);
        excelReader.read(sheet);
      } else if (sheet.getSheetNo() == 2) {
        sheet.setHeadLineMun(1);
        sheet.setClazz(ExcelPropertyIndexModel.class);
        excelReader.read(sheet);
      } else if (sheet.getSheetNo() == 3) {
        sheet.setHeadLineMun(1);
        excelReader.read(sheet);
      }
    }
    inputStream.close();
  }
  
  
  /************************写Excel***************************/
  @Test
  public void writeV2007() throws IOException {
    OutputStream out = new FileOutputStream("e:/2007.xlsx");
    ExcelWriter writer = EasyExcelFactory.getWriter(out);
    //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
    Sheet sheet1 = new Sheet(1, 3);
    sheet1.setSheetName("第一个sheet");
    
    
    //设置列宽 设置每列的宽度
    Map columnWidth = new HashMap();
    columnWidth.put(0, 5000);
    columnWidth.put(1, 10000);
    columnWidth.put(2, 5000);
    columnWidth.put(3, 5000);
    columnWidth.put(4, 5000);
    columnWidth.put(5, 3000);
    columnWidth.put(6, 5000);
    columnWidth.put(7, 3000);
    sheet1.setColumnWidthMap(columnWidth);
    sheet1.setHead(DataUtil.createTestListStringHead());
    //or 设置自适应宽度
    //sheet1.setAutoWidth(Boolean.TRUE);
    writer.write1(DataUtil.createTestListObject(), sheet1);
    
    //写第二个sheet sheet2  模型上打有表头的注解，合并单元格
    Sheet sheet2 = new Sheet(2, 3, WriteModel.class, "第二个sheet", null);
    sheet2.setTableStyle(DataUtil.createTableStyle());
    //writer.write1(null, sheet2);
    writer.write(DataUtil.createTestListJavaMode(), sheet2);
    //需要合并单元格
    writer.merge(5, 20, 1, 1);
    
    
    //写第三个sheet包含多个table情况
    Sheet sheet3 = new Sheet(3, 0);
    sheet3.setSheetName("第三个sheet");
    Table table1 = new Table(1);
    table1.setHead(DataUtil.createTestListStringHead());
    writer.write1(DataUtil.createTestListObject(), sheet3, table1);
    
    //写sheet2  模型上打有表头的注解
    Table table2 = new Table(2);
    table2.setTableStyle(DataUtil.createTableStyle());
    table2.setClazz(WriteModel.class);
    writer.write(DataUtil.createTestListJavaMode(), sheet3, table2);
    
    writer.finish();
    out.close();
    
  }
  
  
  @Test
  public void writeV2007WithTemplate() throws IOException {
    InputStream inputStream = FileUtil.getResourcesFileInputStream("temp/excel/temp.xlsx");
    OutputStream out = new FileOutputStream("e:/2007.xlsx");
    ExcelWriter writer = EasyExcelFactory.getWriterWithTemp(inputStream, out, ExcelTypeEnum.XLSX, false);
    //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
    Sheet sheet1 = new Sheet(1, 3);
    sheet1.setSheetName("第一个sheet");
    sheet1.setStartRow(2);
    
    //设置列宽 设置每列的宽度
    Map columnWidth = new HashMap();
    columnWidth.put(0, 5000);
    columnWidth.put(1, 10000);
    columnWidth.put(2, 5000);
    columnWidth.put(3, 5000);
    columnWidth.put(4, 5000);
    columnWidth.put(5, 3000);
    columnWidth.put(6, 5000);
    columnWidth.put(7, 3000);
    sheet1.setColumnWidthMap(columnWidth);
//    sheet1.setHead(createTestListStringHead());
    //or 设置自适应宽度
    //sheet1.setAutoWidth(Boolean.TRUE);
    writer.write1(DataUtil.createTestListObject(), sheet1);
    
    
    //写第二个sheet sheet2  模型上打有表头的注解，合并单元格
    Sheet sheet2 = new Sheet(2, 3, WriteModel.class, "第二个sheet", null);
    sheet2.setTableStyle(DataUtil.createTableStyle());
    sheet2.setStartRow(2);
    writer.write(DataUtil.createTestListJavaMode(), sheet2);
    
    
    //写第三个sheet包含多个table情况
    Sheet sheet3 = new Sheet(3, 0);
    sheet3.setSheetName("第三个sheet");
    sheet3.setStartRow(6);
    Table table1 = new Table(1);
    table1.setHead(DataUtil.createTestListStringHead());
    writer.write1(DataUtil.createTestListObject(), sheet3, table1);
    
    //写sheet2  模型上打有表头的注解
    Table table2 = new Table(2);
    table2.setTableStyle(DataUtil.createTableStyle());
    table2.setClazz(WriteModel.class);
    writer.write(DataUtil.createTestListJavaMode(), sheet3, table2);
    
    writer.finish();
    out.close();
    
  }
  
  
  /********************************  写Excel（老的方法，不建议使用）  ********************************/
  /**
   * 每行数据是List<String>无表头
   *
   * @throws IOException
   */
  @Test
  public void writeWithoutHead() throws IOException {
    try (OutputStream out = new FileOutputStream("writeWithoutHead.xlsx");) {
      ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, false);
      Sheet sheet1 = new Sheet(1, 0);
      sheet1.setSheetName("sheet1");
      List<List<String>> data = new ArrayList<>();
      for (int i = 0; i < 100; i++) {
        List<String> item = new ArrayList<>();
        item.add("item0" + i);
        item.add("item1" + i);
        item.add("item2" + i);
        data.add(item);
      }
      writer.write0(data, sheet1);
      writer.finish();
    }
  }
  
  //很多时候，我们在生成Excel的时候都是需要添加表头的，使用easyexcel可以很容易的实现，
//我们可以对上面的例子进行简单的改造，为其添加表头
  @Test
  public void writeWithHead() throws IOException {
    try (OutputStream out = new FileOutputStream("writeWithHead.xlsx");) {
      ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
      Sheet sheet1 = new Sheet(1, 0);
      sheet1.setSheetName("sheet1");
      List<List<String>> data = new ArrayList<>();
      for (int i = 0; i < 100; i++) {
        List<String> item = new ArrayList<>();
        item.add("item0" + i);
        item.add("item1" + i);
        item.add("item2" + i);
        data.add(item);
      }
      List<List<String>> head = new ArrayList<List<String>>();
      List<String> headCoulumn1 = new ArrayList<String>();
      List<String> headCoulumn2 = new ArrayList<String>();
      List<String> headCoulumn3 = new ArrayList<String>();
      headCoulumn1.add("第一列");
      headCoulumn2.add("第二列");
      headCoulumn3.add("第三列");
      head.add(headCoulumn1);
      head.add(headCoulumn2);
      head.add(headCoulumn3);
      Table table = new Table(1);
      table.setHead(head);
      writer.write0(data, sheet1, table);
      writer.finish();
    }
  }
  
  
  // 除了上面添加表头的方式，我们还可以使用实体类，
// 为其添加com.alibaba.excel.annotation.ExcelProperty注解来生成表头，
// 实体类数据作为Excel数据
  @Test
  public void writeWithEntityHead() throws IOException {
    try (OutputStream out = new FileOutputStream("writeWithEntityHead.xlsx");) {
      ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
      Sheet sheet1 = new Sheet(1, 0, ExcelPropertyIndexModel.class);
      sheet1.setSheetName("sheet1");
      List<ExcelPropertyIndexModel> data = new ArrayList<>();
      for (int i = 0; i < 100; i++) {
        ExcelPropertyIndexModel item = new ExcelPropertyIndexModel();
        item.name = "name" + i;
        item.age = "age" + i;
        item.email = "email" + i;
        item.address = "address" + i;
        item.sax = "sax" + i;
        item.heigh = "heigh" + i;
        item.last = "last" + i;
        data.add(item);
      }
      writer.write(data, sheet1);
      writer.finish();
    }
  }
  
  @Setter
  @Getter
  public static class ExcelPropertyIndexModel extends BaseRowModel {
    
    @ExcelProperty(value = "姓名", index = 0)
    private String name;
    
    @ExcelProperty(value = "年龄", index = 1)
    private String age;
    
    @ExcelProperty(value = "邮箱", index = 2)
    private String email;
    
    @ExcelProperty(value = "地址", index = 3)
    private String address;
    
    @ExcelProperty(value = "性别", index = 4)
    private String sax;
    
    @ExcelProperty(value = "高度", index = 5)
    private String heigh;
    
    @ExcelProperty(value = "备注", index = 6)
    private String last;
    
    @Override
    public String toString() {
      return "ExcelPropertyIndexModel [name=" + name + ", age=" + age + ", email=" + email + ", address=" + address
          + ", sax=" + sax + ", heigh=" + heigh + ", last=" + last + "]";
    }
  }
  
  
  //  如果单行表头表头还不满足需求，没关系，还可以使用多行复杂的表头
  @Test
  public void writeWithMultiHead() throws IOException {
    try (OutputStream out = new FileOutputStream("writeWithMultiHead.xlsx");) {
      ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
      Sheet sheet1 = new Sheet(1, 0, MultiLineHeadExcelModel.class);
      sheet1.setSheetName("sheet1");
      List<MultiLineHeadExcelModel> data = new ArrayList<>();
      for (int i = 0; i < 100; i++) {
        MultiLineHeadExcelModel item = new MultiLineHeadExcelModel();
        item.p1 = "p1" + i;
        item.p2 = "p2" + i;
        item.p3 = "p3" + i;
        item.p4 = "p4" + i;
        item.p5 = "p5" + i;
        item.p6 = "p6" + i;
        item.p7 = "p7" + i;
        item.p8 = "p8" + i;
        item.p9 = "p9" + i;
        data.add(item);
      }
      writer.write(data, sheet1);
      writer.finish();
    }
  }
  
  @Getter
  @Setter
  public static class MultiLineHeadExcelModel extends BaseRowModel {
    
    @ExcelProperty(value = {"表头1", "表头1", "表头31"}, index = 0)
    private String p1;
    
    @ExcelProperty(value = {"表头1", "表头1", "表头32"}, index = 1)
    private String p2;
    
    @ExcelProperty(value = {"表头3", "表头3", "表头3"}, index = 2)
    private String p3;
    
    @ExcelProperty(value = {"表头4", "表头4", "表头4"}, index = 3)
    private String p4;
    
    @ExcelProperty(value = {"表头5", "表头51", "表头52"}, index = 4)
    private String p5;
    
    @ExcelProperty(value = {"表头6", "表头61", "表头611"}, index = 5)
    private String p6;
    
    @ExcelProperty(value = {"表头6", "表头61", "表头612"}, index = 6)
    private String p7;
    
    @ExcelProperty(value = {"表头6", "表头62", "表头621"}, index = 7)
    private String p8;
    
    @ExcelProperty(value = {"表头6", "表头62", "表头622"}, index = 8)
    private String p9;
    
  }
  
  
  //  在一个sheet中添加多个表
  //  如果表头的样式不满足我们的需求，需要调整，我们可以使用
  //  com.alibaba.excel.metadata.TableStyle定义我们需要的样式，
  //  然后调用table对象的setTableStyle方法进行设置。
  @Test
  public void writeWithMultiTableMore() throws IOException {
    try (OutputStream out = new FileOutputStream("writeWithMultiTableMore.xlsx");) {
      ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
      Sheet sheet1 = new Sheet(1, 0);
      sheet1.setSheetName("sheet1");
      
      // 数据全是List<String> 无模型映射关系
      Table table1 = new Table(1);
      List<List<String>> data1 = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
        List<String> item = new ArrayList<>();
        item.add("item0" + i);
        item.add("item1" + i);
        item.add("item2" + i);
        data1.add(item);
      }
      writer.write0(data1, sheet1, table1);
      
      // 模型上有表头的注解
      Table table2 = new Table(2);
      table2.setClazz(MultiLineHeadExcelModel.class);
      List<MultiLineHeadExcelModel> data2 = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
        MultiLineHeadExcelModel item = new MultiLineHeadExcelModel();
        item.p1 = "p1" + i;
        item.p2 = "p2" + i;
        item.p3 = "p3" + i;
        item.p4 = "p4" + i;
        item.p5 = "p5" + i;
        item.p6 = "p6" + i;
        item.p7 = "p7" + i;
        item.p8 = "p8" + i;
        item.p9 = "p9" + i;
        data2.add(item);
      }
      writer.write(data2, sheet1, table2);
      
      // 模型上没有注解，表头数据动态传入,此情况下模型field顺序与excel现实顺序一致
      List<List<String>> head = new ArrayList<List<String>>();
      List<String> headCoulumn1 = new ArrayList<String>();
      List<String> headCoulumn2 = new ArrayList<String>();
      List<String> headCoulumn3 = new ArrayList<String>();
      headCoulumn1.add("第一列");
      headCoulumn2.add("第二列");
      headCoulumn3.add("第三列");
      head.add(headCoulumn1);
      head.add(headCoulumn2);
      head.add(headCoulumn3);
      Table table3 = new Table(3);
      
      //定义Excel正文背景颜色
      TableStyle tableStyle = new TableStyle();
      tableStyle.setTableContentBackGroundColor(IndexedColors.BLUE);
      
      //定义Excel正文字体大小
      Font font = new Font();
      font.setFontHeightInPoints((short) 10);
      
      tableStyle.setTableContentFont(font);
      
      Table table = new Table(0);
      table.setTableStyle(tableStyle);
      
      table3.setTableStyle(tableStyle);
      
      table3.setHead(head);
      writer.write0(data1, sheet1, table3);
      
      writer.finish();
    }
  }
  
}
