package cn.everlook.myweb.commons.util.easyexcel;

import java.io.InputStream;

/**
 * 文件操作工具
 *
 * @author Administrator
 * @createDate 2019/5/15
 */
public class FileUtil {
  public static InputStream getResourcesFileInputStream(String fileName) {
    return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + fileName);
  }
  
  
}
