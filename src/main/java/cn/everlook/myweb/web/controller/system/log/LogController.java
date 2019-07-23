package cn.everlook.myweb.web.controller.system.log;

import cn.everlook.myweb.annotation.log.SystemControllerLog;
import cn.everlook.myweb.commons.common.JsonData;
import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.persistence.entity.assort.log.CommSysLog;
import cn.everlook.myweb.persistence.entity.vo.system.log.LogVo;
import cn.everlook.myweb.service.system.Log.system_log.ICommSysLogService;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日志管理
 *
 * @author Administrator
 * @createDate 2019/5/22
 */
@Controller
@RequestMapping("/log")
public class LogController {
  
  @Autowired
  private ICommSysLogService iCommSysLogService;
  
  
  /**
   * 跳转到日志管理界面
   */
  @SystemControllerLog(description = "日志界面")
  @RequiresPermissions("log:page")
  @RequestMapping("/toLogManager.do")
  public String toDeptManager() {
    return "system/log/log";
  }
  
  /**
   * 加载日志列表
   */
  @SystemControllerLog(description = "日志列表")
  @RequiresPermissions("log:list")
  @RequestMapping("/loadAllLogs.do")
  @ResponseBody
  public DataGridView loadAllLogs(LogVo logVo) {
    DataGridView view = this.iCommSysLogService.queryAllLogs(logVo);
    return view;
  }
  
  /**
   * 日志搜索
   */
  @SystemControllerLog(description = "日志搜索")
  @RequiresPermissions("log:select")
  @RequestMapping("/selectLogs.do")
  @ResponseBody
  public DataGridView selectLogs(LogVo logVo) {
    DataGridView view = this.iCommSysLogService.queryAllLogs(logVo);
    return view;
  }
  
  /**
   * 日志重置
   */
  @SystemControllerLog(description = "日志重置")
  @RequiresPermissions("log:reset")
  @RequestMapping("/resetLogs.do")
  @ResponseBody
  public DataGridView resetLogs(LogVo logVo) {
    DataGridView view = this.iCommSysLogService.queryAllLogs(logVo);
    return view;
  }
  
  
  /**
   * 批量删除日志信息
   */
  @SystemControllerLog(description = "日志批量删除")
  @RequiresPermissions("log:batchDel")
  @RequestMapping("/batchDeleteLogs.do")
  @ResponseBody
  public JsonData batchDeleteLogs(LogVo logVo) {
    String[] ids = logVo.getIds();
    if (null != ids && ids.length > 0) {
      for (String i : ids) {
        this.iCommSysLogService.deleteLogs(i);
      }
    } else {
      return JsonData.fail("请选择需要删除的日志!", 902);
    }
    return JsonData.success();
  }
  
  
  /**
   * 删除日志信息
   */
  @SystemControllerLog(description = "日志删除")
  @RequiresPermissions("log:delete")
  @RequestMapping("/deleteLog.do")
  @ResponseBody
  public JsonData deleteLog(LogVo logVo) {
    this.iCommSysLogService.deleteLogs(logVo.getLogId());
    return JsonData.success();
  }
  
  /**
   * 清空日志信息
   */
  @SystemControllerLog(description = "清空日志")
  @RequiresPermissions("log:clearLog")
  @RequestMapping("/clearLogs.do")
  @ResponseBody
  public JsonData clearLogs() {
    this.iCommSysLogService.clearLogs();
    return JsonData.success();
  }
  
  
  /**
   * 导出日志信息
   */
  @SystemControllerLog(description = "导出日志")
  @RequiresPermissions("log:exportLogs")
  @RequestMapping("/exportLogs.do")
  @ResponseBody
  public JsonData exportLogs() {
    ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletResponse response = requestAttributes.getResponse();
    HttpServletRequest request = requestAttributes.getRequest();
    
    // 文件名
    String filename = new SimpleDateFormat("/yyyyMMddHHmmss").format(new Date()) + ".xlsx";
    //创建文件夹：
    File excelPath = new File(request.getSession().getServletContext().getRealPath("") + "/download/logsExcel");
    if (!excelPath.exists()) {
      excelPath.mkdirs();
    }
    try {
      // 写到服务器上
      String path = excelPath + filename;
      File name = new File(path);
      OutputStream out = new FileOutputStream(name);
      ExcelWriter writer = EasyExcelFactory.getWriter(out);
      //模型上打有表头的注解
      Sheet sheetLog = new Sheet(1, 2, CommSysLog.class, "操作日志", null);
      //设置列宽 设置每列的宽度
      Map columnWidth = new HashMap();
      columnWidth.put(0, 9000);
      columnWidth.put(1, 2500);
      columnWidth.put(2, 2500);
      columnWidth.put(3, 5000);
      columnWidth.put(4, 5000);
      columnWidth.put(5, 2000);
      columnWidth.put(6, 5000);
      columnWidth.put(7, 5000);
      columnWidth.put(8, 5000);
      columnWidth.put(9, 5000);
      columnWidth.put(10, 5000);
      sheetLog.setColumnWidthMap(columnWidth);
      writer.write(iCommSysLogService.exportLogs(), sheetLog);
      writer.finish();
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    OutputStream out = null;
    try {
      //1.弹出下载框，并处理中文
      //如果是从jsp页面传过来的话，就要进行中文处理，在这里action里面产生的直接可以用
      //String filename = request.getParameter("filename");
      if (request.getMethod().equalsIgnoreCase("GET")) {
        filename = new String(filename.getBytes("iso8859-1"), "utf-8");
      }
      response.setHeader("Content-Disposition", "attachment; filename=" + new String("系统日志.xlsx".getBytes("UTF-8"), "ISO-8859-1"));
      //2.下载
      out = response.getOutputStream();
      String pathDownload = request.getSession().getServletContext().getRealPath("") + "/download/logsExcel" + filename;
      //inputStream：读文件，前提是这个文件必须存在，要不就会报错
      InputStream is = new FileInputStream(pathDownload);
      byte[] b = new byte[4096];
      int size = is.read(b);
      while (size > 0) {
        out.write(b, 0, size);
        size = is.read(b);
      }
      out.close();
      is.close();
      File file = new File(pathDownload);
      file.delete();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return JsonData.success();
  }
  
  
  /**
   *  
   * 返回iReport报表视图
   *
   * @param model  * @return
   */
  @RequestMapping(value = "/reportLog", method = RequestMethod.GET)
  public String reportLog(Model model, LogVo logVo) {
    //报表数据源
    logVo.setLogId("05ff5179aa6b471abe77e1db31179f77");
    CommSysLog commSysLog = iCommSysLogService.selectByPrimaryKey(logVo);
    List<CommSysLog> list = new ArrayList<CommSysLog>();
    list.add(commSysLog);
    JRDataSource jrDataSource = new JRBeanCollectionDataSource(list);
    
    //动态指定报表模板url
    model.addAttribute("url", "/WEB-INF/jasper/logReport.jasper");
    model.addAttribute("format", "pdf"); // 报表格式
    model.addAttribute("jrMainDataSource", jrDataSource);
    return "iReportView"; // 对应jasper-defs.xml中的bean id
  }
  
  /**
   * 返回iReport报表视图
   *
   * @param model
   * @return
   */
  @RequestMapping(value = "/report", method = RequestMethod.GET)
  public String report(Model model) {
    // 报表数据源
    JRDataSource jrDataSource = new JRBeanCollectionDataSource(JavaBeanPerson.getList());
    
    // 动态指定报表模板url
    model.addAttribute("url", "/WEB-INF/jasper/MvcIReportExample.jasper");
    model.addAttribute("format", "pdf"); // 报表格式
    model.addAttribute("jrMainDataSource", jrDataSource);
    
    return "iReportView"; // 对应jasper-defs.xml中的bean id
  }
}
