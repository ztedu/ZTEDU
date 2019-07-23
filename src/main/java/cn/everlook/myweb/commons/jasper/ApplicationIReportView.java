package cn.everlook.myweb.commons.jasper;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;

import java.util.Map;

/**
 * 继承JasperReportsMultiFormatView类，并重写fillReport()方法，
 * 在该方法中增加setUrl()实现，这样就可以在controller中指定要使用的报表模板文件了。
 * 这样做的好处是，只需要一个jasperReport配置文件，可以在controller中动态的设定报表模板url。
 * <p>
 * SpringMVC + IReport整合 视图处理扩展
 *
 * @author Administrator
 * @createDate 2019/5/28
 */
public class ApplicationIReportView extends JasperReportsMultiFormatView {
  private JasperReport jasperReport;
  
  public ApplicationIReportView() {
    super();
  }
  
  protected JasperPrint fillReport(Map<String, Object> model) throws Exception {
    if (model.containsKey("url")) {
      setUrl(String.valueOf(model.get("url")));
      this.jasperReport = loadReport();
    }
    return super.fillReport(model);
  }
  
  protected JasperReport getReport() {
    return this.jasperReport;
  }
  
}
