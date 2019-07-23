package cn.everlook.myweb.commons.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 对文件操作工具
 *
 * @author Administrator
 * @createDate 2019/4/29
 */
public class ZtFileUtils {
  /**
   * 得到文件类型
   *
   * @param
   * @return
   */
  public static String getFileType(String fileName) {
    int i = fileName.lastIndexOf('.');
    if (i == -1) return "";
    return fileName.substring(i);
  }
  
  /**
   * 计算要保存相对路径
   *
   * @return
   */
  private static DateFormat df = new SimpleDateFormat("yyyyMMdd");
  
  public static String genDateRelaPath(String dir) {
    if (dir == null)
      dir = "upload/";
    if (dir.length() > 1 && '/' != dir.charAt(dir.length() - 1))
      dir += "/";
    String date = df.format(new Date());
    String path = dir + date + '/';
    return path;
  }
  
  
  /**
   * 得到要保存的文件夹
   *
   * @return
   */
  public static File getBaseDir(String path) {
    if (path == null)
      path = "";
    File baseDir = new File(getBasePath() + path);
    if (!baseDir.exists())
      baseDir.mkdirs();
    return baseDir;
  }
  
  public static String getBasePath() {
    return SystemConfig.get("sys.upload.dir");
  }
  
}
