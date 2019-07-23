package cn.everlook.myweb.commons.util.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Getter;
import lombok.Setter;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析监听器，
 * 每解析一行会回调invoke()方法。
 * 整个excel解析结束会执行doAfterAllAnalysed()方法
 * <p>
 * 下面只是我写的一个样例而已，可以根据自己的逻辑修改该类。
 *
 * @author Administrator
 * @createDate 2019/5/14
 */
public class ExcelListener extends AnalysisEventListener {
  
  //自定义用于暂时存储data。
  //可以通过实例获取该值
  @Setter
  @Getter
  private List<Object> datas = new ArrayList<>();
  
  public void invoke(Object object, AnalysisContext context) {
    System.out.println("当前sheet:" + context.getCurrentSheet().getSheetNo() + ",当前行:" + context.getCurrentRowNum());
    datas.add(object);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
    doSomething(object);//根据自己业务做处理
  }
  
  private void doSomething(Object object) {
    //1、入库调用接口
    System.out.println(object);
  }

  
  public void doAfterAllAnalysed(AnalysisContext context) {
    // datas.clear();//解析结束销毁不用的资源
  }

}
